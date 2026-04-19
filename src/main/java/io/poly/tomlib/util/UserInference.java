package io.poly.tomlib.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Period;
import java.util.concurrent.TimeUnit;

/// Utility class for inferring user information from the environment.
public final class UserInference {

    private UserInference() {
        // Utility class
    }

    ///
    /// Attempts to infer the user's first name from the local environment.
    ///
    /// @return the inferred first name, or null if not found
    ///
    public static String getInferredFirstName() {
        String fullName = getInferredName();
        if (fullName == null || fullName.trim().isEmpty()) {
            return null;
        }

        // Take the first part (split by space, dot, underscore, or hyphen)
        String firstPart = fullName.split("[ ._-]")[0];
        if (firstPart.isEmpty()) {
            return null;
        }

        // Capitalise it properly
        return firstPart.substring(0, 1).toUpperCase() + firstPart.substring(1).toLowerCase();
    }

    ///
    /// Attempts to infer the user's last name from the local environment.
    ///
    /// @return the inferred last name, or null if not found
    ///
    public static String getInferredLastName() {
        String fullName = getInferredName();
        if (fullName == null || fullName.trim().isEmpty()) {
            return null;
        }

        // Split by space, dot, underscore, or hyphen
        String[] parts = fullName.trim().split("[ ._-]+");
        if (parts.length < 2) {
            return null;
        }

        // Take the last part
        String lastPart = parts[parts.length - 1];
        if (lastPart.isEmpty()) {
            return null;
        }

        // Capitalise it properly
        return lastPart.substring(0, 1).toUpperCase() + lastPart.substring(1).toLowerCase();
    }

    ///
    /// Attempts to infer the user's name from the local environment.
    ///
    /// Strategies:
    /// 1. Environment variables USER_NAME, FULL_NAME, NAME, USER, USERNAME
    /// 2. macOS only: dscl utility to read RealName attribute
    /// 3. Git configuration: git config user.name
    /// 4. System property user.name as a fallback
    ///
    /// @return the inferred name, or null if not found
    ///
    public static String getInferredName() {
        if (!TomlibConfig.isInferenceEnabled()) {
            return null;
        }

        // 0. System property override (for testing or manual override)
        String sysOverride = System.getProperty("tomlib.user.name");
        if (sysOverride != null && !sysOverride.trim().isEmpty()) {
            return sysOverride.trim();
        }

        // 1. Environment Variables
        String[] envVars = {"USER_NAME", "FULL_NAME", "NAME"};
        for (String var : envVars) {
            String val = System.getenv(var);
            if (val != null && !val.trim().isEmpty()) {
                return val.trim();
            }
        }

        // 2. macOS dscl (Directory Service Command Line)
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("mac")) {
            try {
                String username = System.getProperty("user.name");
                Process process = new ProcessBuilder("dscl", ".", "-read", "/Users/" + username, "RealName")
                        .redirectError(ProcessBuilder.Redirect.DISCARD)
                        .start();
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                    String line = reader.readLine();
                    // Output format: "RealName: Tom Baldwin" or multiple lines
                    if (line != null && line.contains("RealName:")) {
                        String name = line.substring(line.indexOf(":") + 1).trim();
                        if (!name.isEmpty()) return name;
                    }
                    // Sometimes RealName is on the next line
                    String nextLine = reader.readLine();
                    if (nextLine != null && !nextLine.trim().isEmpty()) {
                        return nextLine.trim();
                    }
                }
                process.waitFor(500, TimeUnit.MILLISECONDS);
            } catch (Exception ignored) {}
        }

        // 3. Git configuration
        try {
            Process process = new ProcessBuilder("git", "config", "user.name")
                    .redirectError(ProcessBuilder.Redirect.DISCARD)
                    .start();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line = reader.readLine();
                if (line != null && !line.trim().isEmpty()) {
                    return line.trim();
                }
            }
            process.waitFor(500, TimeUnit.MILLISECONDS);
        } catch (Exception ignored) {}

        // 4. Fallback Environment variable
        String envUser = System.getenv("USER");
        if (envUser == null) envUser = System.getenv("USERNAME");
        if (envUser != null && !envUser.isEmpty() && !"root".equals(envUser)) {
            return envUser;
        }

        // 5. System property (usually login name)
        String sysUser = System.getProperty("user.name");
        if (sysUser != null && !sysUser.trim().isEmpty() && !"root".equals(sysUser)) {
            return sysUser;
        }

        return null;
    }

    ///
    /// Attempts to infer the user's birthday from the local environment.
    ///
    /// Strategies:
    /// 1. Environment variable USER_BIRTHDAY (format: MM-DD)
    /// 2. Local config file ~/.birthday (format: MM-DD)
    /// 3. macOS only: dscl utility to read BirthDay attribute
    ///
    /// @return the inferred MonthDay, or null if not found
    ///
    public static MonthDay getInferredBirthday() {
        if (!TomlibConfig.isInferenceEnabled()) {
            return null;
        }
        // 1. Environment Variable
        String envBirthday = System.getenv("USER_BIRTHDAY");
        if (envBirthday != null && envBirthday.matches("\\d{2}-\\d{2}")) {
            return MonthDay.parse("--" + envBirthday);
        }

        // 2. Config File
        String userHome = System.getProperty("user.home");
        File birthdayFile = new File(userHome, ".birthday");
        if (birthdayFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(birthdayFile))) {
                String line = reader.readLine();
                if (line != null && line.trim().matches("\\d{2}-\\d{2}")) {
                    return MonthDay.parse("--" + line.trim());
                }
            } catch (IOException ignored) {}
        }

        // 3. macOS dscl (Directory Service Command Line)
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("mac")) {
            try {
                String username = System.getProperty("user.name");
                Process process = new ProcessBuilder("dscl", ".", "-read", "/Users/" + username, "BirthDay")
                        .redirectError(ProcessBuilder.Redirect.DISCARD)
                        .start();
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                    String line = reader.readLine();
                    // Output format is usually: "BirthDay: 1980-06-01" or similar
                    if (line != null && line.contains("BirthDay:")) {
                        String datePart = line.substring(line.indexOf(":") + 1).trim();
                        if (datePart.matches("\\d{4}-\\d{2}-\\d{2}")) {
                            return MonthDay.parse("--" + datePart.substring(5));
                        }
                    }
                }
                process.waitFor(500, TimeUnit.MILLISECONDS);
            } catch (Exception ignored) {}
        }

        return null;
    }

    ///
    /// Attempts to infer the user's age based on their inferred birthday.
    /// This requires the full date of birth (including year) which is currently
    /// only available from the macOS dscl strategy.
    ///
    /// @return the inferred age, or -1 if the birth year cannot be determined
    ///
    public static int getInferredAge() {
        if (!TomlibConfig.isInferenceEnabled()) {
            return -1;
        }
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("mac")) {
            try {
                String username = System.getProperty("user.name");
                Process process = new ProcessBuilder("dscl", ".", "-read", "/Users/" + username, "BirthDay")
                        .redirectError(ProcessBuilder.Redirect.DISCARD)
                        .start();
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                    String line = reader.readLine();
                    if (line != null && line.contains("BirthDay:")) {
                        String datePart = line.substring(line.indexOf(":") + 1).trim();
                        if (datePart.matches("\\d{4}-\\d{2}-\\d{2}")) {
                            LocalDate dob = LocalDate.parse(datePart);
                            return Period.between(dob, LocalDate.now()).getYears();
                        }
                    }
                }
                process.waitFor(500, TimeUnit.MILLISECONDS);
            } catch (Exception ignored) {}
        }
        return -1;
    }
}
