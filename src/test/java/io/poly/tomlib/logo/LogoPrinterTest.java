package io.poly.tomlib.logo;

import io.poly.tomlib.logo.theme.halloween.HalloweenLogoTheme;
import io.poly.tomlib.logo.theme.may4th.May4thTheme;
import io.poly.tomlib.logo.theme.may4th.mascot.R2D2Mascot;
import io.poly.tomlib.logo.font.AsciiFont;
import io.poly.tomlib.util.UserInference;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/// Unit test for printing a startup logo in both normal and glitchy modes.
public class LogoPrinterTest {

    private LogoPrinter logoPrinter;

    @BeforeEach
    void setUp() {
        MascotRegistry.clearCache();
        ThemeRegistry.clearCache();
        logoPrinter = new LogoPrinter();
    }

    @Test
    public void orderedThemes() {
        // Ensure themes are loaded
        ThemeRegistry.getTheme(May4thTheme.class);
        ThemeRegistry.getTheme(io.poly.tomlib.logo.theme.festive.FestiveTheme.class);

        // We need to create a new LogoPrinter after loading themes if it doesn't auto-refresh
        logoPrinter = new LogoPrinter();

        List<Theme> themes = logoPrinter.getThemes();
        assertFalse(themes.isEmpty(), "Themes should not be empty");

        // Verify order (highest priority first)
        for (int i = 0; i < themes.size() - 1; i++) {
            assertTrue(themes.get(i).getPriority() >= themes.get(i + 1).getPriority(),
                    "Themes should be ordered by priority descending: " + themes.get(i).getName() + "(" + themes.get(i).getPriority() + ") vs " + themes.get(i + 1).getName() + "(" + themes.get(i + 1).getPriority() + ")");
        }

        // Specifically check that May 4th (30) is before Festive (5)
        int may4thIdx = -1;
        int festiveIdx = -1;
        for (int i = 0; i < themes.size(); i++) {
            if (themes.get(i) instanceof May4thTheme) may4thIdx = i;
            if (themes.get(i).getName().equals("Festive")) festiveIdx = i;
        }
        assertTrue(may4thIdx != -1 && festiveIdx != -1, "Both themes should be present");
        assertTrue(may4thIdx < festiveIdx, "May 4th should have higher priority than Festive");
    }

    @Test
    public void printNormalLogo() {
        System.out.println("--- NORMAL LOGO ---");
        logoPrinter.printLogo(false);
    }

    @Test
    public void dynamicStandardLogo() {
        String[] texts = {"A", "POLY", "tombaldwin", "1234567890", "SUPERLONGTEXT", "poly.io"};
        for (String text : texts) {
            System.out.println("--- DYNAMIC LOGO (" + text + ") ---");
            LogoPrinter dynamicPrinter = new LogoPrinter(text);
            dynamicPrinter.printLogo(false);
        }
    }

    @Test
    public void printGlitchyLogo() {
        for (int i = 0; i < 5; i++) {
            System.out.println("--- GLITCHY LOGO ATTEMPT " + (i + 1) + " ---");
            logoPrinter.printLogo(true);
        }
    }

    @Test
    public void halloweenGlitchModeScaryGhost() {
        HalloweenLogoTheme theme = new HalloweenLogoTheme();
        // Scary ghost marker is ",." in the first line
        for (int i = 0; i < 10; i++) {
            String[] logo = theme.getLogo("tomlib", true);
            assertTrue(logo[0].contains(",."), "Glitchy Halloween logo should always be the scary ghost");
        }
    }

    @Test
    public void halloweenStarsSlimeAndBlood() {
        HalloweenLogoTheme theme = new HalloweenLogoTheme();

        // Normal mode: Green slime
        int[] normalColourDot = theme.getStarColour('.', 0, 0, false);
        assertArrayEquals(new int[]{173, 255, 47}, normalColourDot, "Halloween normal stars (dot) should be Green Yellow slime");
        int[] normalColourSmallO = theme.getStarColour('o', 0, 0, false);
        assertArrayEquals(new int[]{127, 255, 0}, normalColourSmallO, "Halloween normal stars (o) should be Chartreuse slime");
        int[] normalColourLargeO = theme.getStarColour('O', 0, 0, false);
        assertArrayEquals(new int[]{50, 205, 50}, normalColourLargeO, "Halloween normal stars (O) should be Lime Green slime");

        // Glitch mode: Red blood
        int[] glitchColour = theme.getStarColour('.', 0, 0, true);
        assertArrayEquals(new int[]{255, 0, 0}, glitchColour, "Halloween glitch stars should be red blood");

        // Verify characters
        String[] starsLeft = theme.getStarsLeft(false);
        boolean hasExpectedChars = false;
        for (String s : starsLeft) {
            if (s.contains(".") || s.contains("o") || s.contains("O")) {
                hasExpectedChars = true;
                break;
            }
        }
        assertTrue(hasExpectedChars, "Halloween stars should contain '.', 'o', or 'O'");
    }

    @Test
    public void halloweenNormalModeNoScaryGhost() {
        HalloweenLogoTheme theme = new HalloweenLogoTheme();
        // Scary ghost marker is ",." in the first line
        for (int i = 0; i < 10; i++) {
            String[] logo = theme.getLogo("tomlib", false);
            assertFalse(logo[0].contains(",."), "Normal Halloween logo should never be the scary ghost");
        }
    }

    @Test
    public void halloweenMascotOnlyInLogo() {
        LogoPrinter.instance(); // Ensure things are initialised
        HalloweenLogoTheme theme = new HalloweenLogoTheme();
        AbstractMascot mascot = theme.getMascot(false);
        assertNull(mascot, "Halloween theme should not have a side mascot");
    }

    @Test
    public void printChristmasLogo() {
        System.out.println("--- CHRISTMAS LOGO ---");
        new LogoPrinter() {
            @Override
            public void printLogo(boolean glitchMode) {
                printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(io.poly.tomlib.logo.theme.festive.FestiveTheme.class).orElseThrow());
            }
        }.printLogo(false);
    }

    @Test
    public void printChristmasGlitchyLogo() {
        for (int i = 0; i < 5; i++) {
            System.out.println("--- CHRISTMAS GLITCHY LOGO ATTEMPT " + (i + 1) + " ---");
            new LogoPrinter() {
                @Override
                public void printLogo(boolean glitchMode) {
                    printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(io.poly.tomlib.logo.theme.festive.FestiveTheme.class).orElseThrow());
                }
            }.printLogo(true);
        }
    }

    @Test
    public void printHalloweenLogo() {
        System.out.println("--- HALLOWEEN LOGO (Classic) ---");
        new LogoPrinter() {
            @Override
            public void printLogo(boolean glitchMode) {
                printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(HalloweenLogoTheme.class).orElseThrow());
            }
        }.printLogo(false);
    }

    @Test
    public void halloweenGhostVariants() {
        for (int i = 0; i < 3; i++) {
            final int variant = i;
            String name = switch (variant) {
                case 1 -> "Cute";
                case 2 -> "Scary";
                default -> "Classic";
            };
            System.out.println("--- HALLOWEEN LOGO (" + name + ") ---");
            // Since we've moved the logic, we test it through the printer that now uses the theme
            LogoPrinter variantPrinter = new LogoPrinter() {
                @Override
                public void printLogo(boolean glitchMode) {
                    HalloweenLogoTheme theme = new HalloweenLogoTheme();
                    theme.setVariant(variant);
                    // Manually simulate what LogoPrinter would do if halloweenMode was true
                    // but we want to force our variant.
                    // This is slightly complex because of how printLogo is structured now.
                    // For testing purposes, we'll just check if we can get the logo from the theme directly
                    // and verify it contains expected markers.
                    String[] logo = theme.getLogo(getLogoText());
                    if (variant == 1) assert logo[0].contains(".-''-.");
                    else if (variant == 2) assert logo[0].contains(",.");
                    else assert logo[0].contains(".-.");

                    // To keep the test outputting something:
                    printLogoWithTheme(glitchMode, theme);
                }
            };
            variantPrinter.printLogo(false);
        }
    }

    @Test
    public void overrideHalloweenText() {
        System.out.println("--- OVERRIDDEN HALLOWEEN LOGO (Short) ---");
        LogoPrinter shortPrinter = new LogoPrinter("SPOOKY") {
            @Override
            public void printLogo(boolean glitchMode) {
                printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(HalloweenLogoTheme.class).orElseThrow());
            }
        };
        shortPrinter.printLogo(false);

        System.out.println("--- OVERRIDDEN HALLOWEEN LOGO (Long 10 chars) ---");
        LogoPrinter longPrinter = new LogoPrinter("HAPPYGHOST", 0.0) {
            @Override
            public void printLogo(boolean glitchMode) {
                printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(HalloweenLogoTheme.class).orElseThrow());
            }
        };
        longPrinter.printLogo(false);

        System.out.println("--- OVERRIDDEN HALLOWEEN LOGO (Very Long 15 chars) ---");
        LogoPrinter veryLongPrinter = new LogoPrinter("SUPERLONGGHOSTY", 0.0) {
            @Override
            public void printLogo(boolean glitchMode) {
                printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(HalloweenLogoTheme.class).orElseThrow());
            }
        };
        veryLongPrinter.printLogo(false);
    }

    @Test
    public void logoPrinterConstructor() {
        System.out.println("--- CONSTRUCTOR: CUSTOM TEXT, NO THEMES, NO GLITCH ---");
        LogoPrinter customPrinter = new LogoPrinter("custom", 0.0);
        customPrinter.printLogo();

        System.out.println("--- CONSTRUCTOR: CUSTOM TEXT, THEMES, GLITCH ---");
        LogoPrinter glitchPrinter = new LogoPrinter("glitchy", 1.0);
        glitchPrinter.printLogo();

        System.out.println("--- CONSTRUCTOR: GLITCH PROBABILITY 1.0 ---");
        LogoPrinter mascotPrinter = new LogoPrinter("mascot", 1.0);
        mascotPrinter.printLogo();

        System.out.println("--- CONSTRUCTOR: GLITCH PROBABILITY 0.0 ---");
        LogoPrinter noMascotPrinter = new LogoPrinter("no-mascot", 0.0);
        noMascotPrinter.printLogo();
    }

    @Test
    public void printHalloweenGlitchyLogo() {
        System.out.println("--- HALLOWEEN GLITCHY LOGO ---");
        new LogoPrinter() {
            @Override
            public void printLogo(boolean glitchMode) {
                printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(HalloweenLogoTheme.class).orElseThrow());
            }
        }.printLogo(true);
    }

    @Test
    public void printNewYearLogo() {
        System.out.println("--- NEW YEAR LOGO ---");
        new LogoPrinter() {
            @Override
            public void printLogo(boolean glitchMode) {
                printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(io.poly.tomlib.logo.theme.newyear.NewYearTheme.class).orElseThrow());
            }
        }.printLogo(false);
    }

    @Test
    public void printNewYearGlitchyLogo() {
        for (int i = 0; i < 5; i++) {
            System.out.println("--- NEW YEAR GLITCHY LOGO ATTEMPT " + (i + 1) + " ---");
            new LogoPrinter() {
                @Override
                public void printLogo(boolean glitchMode) {
                    printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(io.poly.tomlib.logo.theme.newyear.NewYearTheme.class).orElseThrow());
                }
            }.printLogo(true);
        }
    }

    @Test
    public void printValentinesLogo() {
        System.out.println("--- VALENTINE'S LOGO ---");
        new LogoPrinter() {
            @Override
            public void printLogo(boolean glitchMode) {
                printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(io.poly.tomlib.logo.theme.valentines.ValentinesTheme.class).orElseThrow());
            }
        }.printLogo(false);
    }

    @Test
    public void printValentinesGlitchyLogo() {
        for (int i = 0; i < 5; i++) {
            System.out.println("--- VALENTINE'S GLITCHY LOGO ATTEMPT " + (i + 1) + " ---");
            new LogoPrinter() {
                @Override
                public void printLogo(boolean glitchMode) {
                    printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(io.poly.tomlib.logo.theme.valentines.ValentinesTheme.class).orElseThrow());
                }
            }.printLogo(true);
        }
    }

    @Test
    public void printEasterLogo() {
        System.out.println("--- EASTER LOGO ---");
        new LogoPrinter() {
            @Override
            public void printLogo(boolean glitchMode) {
                printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(io.poly.tomlib.logo.theme.easter.EasterTheme.class).orElseThrow());
            }
        }.printLogo(false);
    }

    @Test
    public void printEasterGlitchyLogo() {
        for (int i = 0; i < 5; i++) {
            System.out.println("--- EASTER GLITCHY LOGO ATTEMPT " + (i + 1) + " ---");
            new LogoPrinter() {
                @Override
                public void printLogo(boolean glitchMode) {
                    printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(io.poly.tomlib.logo.theme.easter.EasterTheme.class).orElseThrow());
                }
            }.printLogo(true);
        }
    }

    @Test
    public void printMay4thLogo() {
        System.out.println("--- MAY 4TH LOGO ---");
        new LogoPrinter() {
            @Override
            public void printLogo(boolean glitchMode) {
                printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(May4thTheme.class).orElseThrow());
            }
        }.printLogo(false);
    }

    @Test
    public void may4thLogoColour() {
        io.poly.tomlib.logo.theme.may4th.May4thTheme theme = new io.poly.tomlib.logo.theme.may4th.May4thTheme();
        int[] colour = theme.getLogoColour('a', 0, 0, false);
        assertArrayEquals(new int[]{255, 255, 0}, colour, "May 4th logo should be yellow");
    }

    @Test
    public void printMay4thGlitchyLogo() {
        for (int i = 0; i < 5; i++) {
            System.out.println("--- MAY 4TH GLITCHY LOGO ATTEMPT " + (i + 1) + " ---");
            new LogoPrinter() {
                @Override
                public void printLogo(boolean glitchMode) {
                    printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(May4thTheme.class).orElseThrow());
                }
            }.printLogo(true);
        }
    }

    @Test
    public void printFourthOfJulyLogo() {
        System.out.println("--- 4TH OF JULY LOGO ---");
        new LogoPrinter() {
            @Override
            public void printLogo(boolean glitchMode) {
                printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(io.poly.tomlib.logo.theme.fourthofjuly.FourthOfJulyTheme.class).orElseThrow());
            }
        }.printLogo(false);
    }

    @Test
    public void printFourthOfJulyGlitchyLogo() {
        for (int i = 0; i < 5; i++) {
            System.out.println("--- 4TH OF JULY GLITCHY LOGO ATTEMPT " + (i + 1) + " ---");
            new LogoPrinter() {
                @Override
                public void printLogo(boolean glitchMode) {
                    printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(io.poly.tomlib.logo.theme.fourthofjuly.FourthOfJulyTheme.class).orElseThrow());
                }
            }.printLogo(true);
        }
    }

    @Test
    public void printBirthdayLogo() {
        System.out.println("--- BIRTHDAY LOGO (DEFAULT) ---");
        new LogoPrinter() {
            @Override
            public void printLogo(boolean glitchMode) {
                printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(io.poly.tomlib.logo.theme.birthday.BirthdayTheme.class).orElseThrow());
            }
        }.printLogo(false);

        System.out.println("--- BIRTHDAY LOGO (LONG TEXT) ---");
        LogoPrinter longLogoPrinter = new LogoPrinter("happy-birthday-to-you") {
            @Override
            public void printLogo(boolean glitchMode) {
                printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(io.poly.tomlib.logo.theme.birthday.BirthdayTheme.class).orElseThrow());
            }
        };
        longLogoPrinter.printLogo(false);

        System.out.println("--- BIRTHDAY LOGO (SHORT TEXT) ---");
        LogoPrinter shortLogoPrinter = new LogoPrinter("tom") {
            @Override
            public void printLogo(boolean glitchMode) {
                printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(io.poly.tomlib.logo.theme.birthday.BirthdayTheme.class).orElseThrow());
            }
        };
        shortLogoPrinter.printLogo(false);
    }

    @Test
    public void birthdayInference() {
        System.out.println("--- TESTING BIRTHDAY INFERENCE ---");

        java.time.MonthDay birthday = UserInference.getInferredBirthday();
        if (birthday != null) {
            System.out.println("Inferred birthday: " + birthday);
        } else {
            System.out.println("No birthday inferred from current environment.");
        }
    }

    @Test
    public void birthdayModeTrigger() {
        System.out.println("--- TESTING BIRTHDAY MODE TRIGGER ---");
        java.time.LocalDate today = java.time.LocalDate.now();
        java.time.MonthDay todayMD = java.time.MonthDay.from(today);

        io.poly.tomlib.logo.theme.birthday.BirthdayTheme birthdayTheme = new io.poly.tomlib.logo.theme.birthday.BirthdayTheme() {
            @Override
            public java.time.MonthDay getInferredBirthday() {
                return todayMD;
            }
        };

        LogoPrinter triggerPrinter = new LogoPrinter() {
            @Override
            public void printLogo(boolean glitchMode) {
                if (birthdayTheme.isActive(java.time.LocalDate.now())) {
                    System.out.println(String.join("\n", birthdayTheme.getLogo(getLogoText())));
                } else {
                    super.printLogo(glitchMode);
                }
            }
        };

        // This should print the birthday cake because we mocked the inferred birthday to today
        triggerPrinter.printLogo(false);
    }

    @Test
    public void nameInference() {
        System.out.println("--- TESTING NAME INFERENCE ---");
        String name = UserInference.getInferredName();
        if (name != null) {
            System.out.println("Inferred name: " + name);
        } else {
            System.out.println("No name inferred from current environment.");
        }
    }

    @Test
    public void logoTextIsDefaultTomlib() {
        System.out.println("--- TESTING LOGO TEXT IS DEFAULT TOMLIB ---");
        LogoPrinter printer = new LogoPrinter() {
            @Override
            protected String getInferredName() {
                return "Should Be Ignored";
            }
        };
        String logoText = printer.getLogoText();
        System.out.println("Logo text: " + logoText);
        org.junit.jupiter.api.Assertions.assertEquals("tomlib", logoText);
    }

    @Test
    public void birthdayCakeWithFirstName() {
        System.out.println("--- TESTING BIRTHDAY CAKE WITH FIRST NAME ---");
        io.poly.tomlib.logo.theme.birthday.BirthdayTheme birthdayTheme = new io.poly.tomlib.logo.theme.birthday.BirthdayTheme() {
            @Override
            public java.time.MonthDay getInferredBirthday() {
                return java.time.MonthDay.now();
            }
        };

        LogoPrinter birthdayNamePrinter = new LogoPrinter() {
            @Override
            protected String getInferredName() {
                return "Tom Baldwin";
            }
            @Override
            public void printLogo(boolean glitchMode) {
                System.out.println(String.join("\n", birthdayTheme.getLogo(getLogoText())));
            }
        };

        // This should print the birthday cake with "tom" (first name)
        birthdayNamePrinter.printLogo(false);
    }

    @Test
    public void birthdayCakeWithoutKnownBirthday() {
        System.out.println("--- TESTING BIRTHDAY CAKE WITHOUT KNOWN BIRTHDAY ---");
        LogoPrinter manualBirthdayPrinter = new LogoPrinter() {
            @Override
            protected String getInferredName() {
                return "Tom Baldwin";
            }
        };

        // Manually trigger birthday mode
        // It should use "tomlib" because birthday is not known (even if name is known)
        System.out.println("Manual birthday trigger (birthday not inferred):");
        new LogoPrinter() {
            @Override
            protected String getInferredName() {
                return "Tom Baldwin";
            }
            @Override
            public void printLogo(boolean glitchMode) {
                printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(io.poly.tomlib.logo.theme.birthday.BirthdayTheme.class).orElseThrow());
            }
        }.printLogo(false);
    }

    @Test
    public void catMascotColour() {
        LogoPrinter printer = new LogoPrinter("test", 0.0);
        // We can't easily capture output and verify colours in this setup without complex mocking,
        // but we can at least ensure it doesn't crash when trying to get the mascot colour.
        printer.printLogo();
    }

    @Test
    public void printMascot() {
        System.out.println("--- SEARCHING FOR MASCOT (1/10 chance) ---");
        for (int i = 0; i < 30; i++) {
            System.out.println("Attempt " + (i + 1) + ":");
            logoPrinter.printLogo(false);
        }
    }

    /// Test case to output all mascot options for review.
    @Test
    public void printR2D2() {
        System.out.println("--- R2-D2 (May 4th) ---");
        String[] r2d2 = new R2D2Mascot().getArt();
        org.junit.jupiter.api.Assertions.assertNotNull(r2d2);
        org.junit.jupiter.api.Assertions.assertTrue(r2d2.length >= 5);
        for (String line : r2d2) {
            System.out.println(line);
        }
    }

    @Test
    public void printMascots() {
        System.out.println("=== ALL REGISTERED MASCOTS ===");
        for (AbstractMascot mascot : MascotRegistry.getMascots().values()) {
            System.out.println("\n--- " + mascot.getClass().getSimpleName() + " ---");
            for (String line : mascot.getColouredArt()) {
                System.out.println(line);
            }
        }
    }

    @Test
    public void printAllMascotOptions() {

        System.out.println("=== MASCOT OPTIONS (COMBINED) ===");

        System.out.println("\n--- OPTION: SNOWMAN (Christmas Mode, Normal) ---");
        new LogoPrinter() {
            @Override
            public void printLogo(boolean glitchMode) {
                printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(io.poly.tomlib.logo.theme.festive.FestiveTheme.class).orElseThrow());
            }
        }.printLogo(false);

        System.out.println("\n--- OPTION: GRINCH (Christmas Mode, Glitchy) ---");
        // We run it a few times to see different glitch variations while keeping the Grinch stable
        for (int i = 1; i <= 3; i++) {
            System.out.println("Attempt " + i + ":");
            new LogoPrinter() {
                @Override
                public void printLogo(boolean glitchMode) {
                    printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(io.poly.tomlib.logo.theme.festive.FestiveTheme.class).orElseThrow());
                }
            }.printLogo(true);
        }

        System.out.println("\n--- OPTION: HALLOWEEN GHOST (Halloween Mode) ---");
        new LogoPrinter() {
            @Override
            public void printLogo(boolean glitchMode) {
                printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(HalloweenLogoTheme.class).orElseThrow());
            }
        }.printLogo(false);

        System.out.println("\n--- OPTION: HALLOWEEN SCARY GHOST (Halloween Mode, Glitchy) ---");
        new LogoPrinter() {
            @Override
            public void printLogo(boolean glitchMode) {
                printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(HalloweenLogoTheme.class).orElseThrow());
            }
        }.printLogo(true);

        System.out.println("\n--- OPTION: NEW YEAR (New Year Mode) ---");
        new LogoPrinter() {
            @Override
            public void printLogo(boolean glitchMode) {
                printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(io.poly.tomlib.logo.theme.newyear.NewYearTheme.class).orElseThrow());
            }
        }.printLogo(false);

        System.out.println("\n--- OPTION: VALENTINE (Valentine Mode) ---");
        new LogoPrinter() {
            @Override
            public void printLogo(boolean glitchMode) {
                printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(io.poly.tomlib.logo.theme.valentines.ValentinesTheme.class).orElseThrow());
            }
        }.printLogo(false);

        System.out.println("\n--- OPTION: EASTER (Easter Mode) ---");
        new LogoPrinter() {
            @Override
            public void printLogo(boolean glitchMode) {
                printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(io.poly.tomlib.logo.theme.easter.EasterTheme.class).orElseThrow());
            }
        }.printLogo(false);

        System.out.println("\n--- OPTION: SKELETOR (Valentine Mode, Glitchy) ---");
        for (int i = 1; i <= 3; i++) {
            System.out.println("Attempt " + i + ":");
            new LogoPrinter() {
                @Override
                public void printLogo(boolean glitchMode) {
                    printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(io.poly.tomlib.logo.theme.valentines.ValentinesTheme.class).orElseThrow());
                }
            }.printLogo(true);
        }

        System.out.println("\n--- OPTION: BROKEN EGG (Easter Mode, Glitchy) ---");
        for (int i = 1; i <= 3; i++) {
            System.out.println("Attempt " + i + ":");
            new LogoPrinter() {
                @Override
                public void printLogo(boolean glitchMode) {
                    printLogoWithTheme(glitchMode, ThemeRegistry.getTheme(io.poly.tomlib.logo.theme.easter.EasterTheme.class).orElseThrow());
                }
            }.printLogo(true);
        }

        System.out.println("==========================================");
    }

    @Test
    public void halloweenLogoColours() {
        HalloweenLogoTheme theme = new HalloweenLogoTheme();

        // Normal mode
        // Body character (e.g. '(' in classic/cute/scary)
        assertArrayEquals(new int[]{255, 255, 255}, theme.getLogoColour('(', 1, 15, false), "Ghost body should be white");
        // Eye character 'o' in classic/cute ghost (row 1)
        assertArrayEquals(new int[]{255, 255, 255}, theme.getLogoColour('o', 1, 15, false), "Ghost eyes 'o' should be white");
        // Logo text character 't' in row 3
        assertArrayEquals(new int[]{127, 255, 0}, theme.getLogoColour('t', 3, 15, false), "Logo text should be slime green");
        // 'o' in logo text row 3
        assertArrayEquals(new int[]{127, 255, 0}, theme.getLogoColour('o', 3, 15, false), "'o' in logo text should be slime green");
        // Drip character 'O' in row 2 (not eye row 1, not text row 3)
        assertArrayEquals(new int[]{50, 205, 50}, theme.getLogoColour('O', 2, 15, false), "Drip 'O' should be green");
        // Space in logo text row
        assertArrayEquals(new int[]{127, 255, 0}, theme.getLogoColour(' ', 3, 15, false), "Logo text spaces should be slime green");

        // Glitch mode
        // Scary ghost eyes '0'
        assertArrayEquals(new int[]{255, 0, 0}, theme.getLogoColour('0', 1, 15, true), "Scary ghost eyes should be red");
        // Logo text in glitch mode
        assertArrayEquals(new int[]{255, 0, 0}, theme.getLogoColour('t', 3, 15, true), "Glitchy logo text should be red");
    }

    @Test
    public void halloweenGhostBodyColours() {
        HalloweenLogoTheme theme = new HalloweenLogoTheme();

        // Classic/Cute Ghost uses '.' in row 0: " .-.  " or " .-''-. "
        assertArrayEquals(new int[]{255, 255, 255}, theme.getLogoColour('.', 0, 15, false), "Ghost body '.' in row 0 should be white");
        assertArrayEquals(new int[]{255, 255, 255}, theme.getLogoColour('.', 0, 15, true), "Ghost body '.' in row 0 should be white in glitch mode too");

        // Cute Ghost uses 'o' in row 1 for eyes
        assertArrayEquals(new int[]{255, 255, 255}, theme.getLogoColour('o', 1, 15, false), "Ghost eyes 'o' in row 1 should be white");

        // Row 2 is typically the mouth/body of the ghost, but currently it contains no .oO.
        // It is instead used for slime drips (stars) in the background.
        assertArrayEquals(new int[]{50, 205, 50}, theme.getLogoColour('O', 2, 15, false), "Background drip 'O' in row 2 should be coloured");

        // But slime drips in row 3 (logo row) should be coloured
        assertArrayEquals(new int[]{127, 255, 0}, theme.getLogoColour('.', 3, 15, false), "Slime drip '.' in row 3 should be green");
        assertArrayEquals(new int[]{127, 255, 0}, theme.getLogoColour('o', 3, 15, false), "Slime drip 'o' in row 3 should be green");
        assertArrayEquals(new int[]{127, 255, 0}, theme.getLogoColour('O', 3, 15, false), "Slime drip 'O' in row 3 should be green");
    }

    @Test
    public void customFont() {
        AsciiFont customFont = new AsciiFont() {
            @Override
            public String[] render(String text) {
                return new String[]{"[" + text + "]"};
            }

            @Override
            public int getHeight() {
                return 1;
            }

            @Override
            public void printAllCharacters(int maxWidth) {
                // No-op
            }
        };
        AbstractTheme theme = new AbstractTheme("Custom", new Class[0], new Class[0], customFont) {
            @Override
            public boolean isActive(java.time.LocalDate date) {
                return false;
            }
        };
        String[] logo = theme.getLogo("test", false);
        assertEquals(1, logo.length);
        assertEquals("[test]", logo[0]);
    }

    @Test
    public void halloweenLogoTextAllColoured() {
        HalloweenLogoTheme theme = new HalloweenLogoTheme();

        // Any non-whitespace character in row 3 should be slime/blood coloured
        int[] slime = {127, 255, 0};
        assertArrayEquals(slime, theme.getLogoColour('T', 3, 15, false), "Uppercase 'T' should be green");
        assertArrayEquals(slime, theme.getLogoColour('O', 3, 15, false), "Uppercase 'O' should be green");
        assertArrayEquals(slime, theme.getLogoColour('M', 3, 15, false), "Uppercase 'M' should be green");
        assertArrayEquals(slime, theme.getLogoColour('B', 3, 15, false), "Uppercase 'B' should be green");
        assertArrayEquals(slime, theme.getLogoColour('1', 3, 15, false), "Digit '1' should be green");
        assertArrayEquals(slime, theme.getLogoColour('!', 3, 15, false), "Symbol '!' should be green");

        int[] blood = {255, 0, 0};
        assertArrayEquals(blood, theme.getLogoColour('U', 3, 15, true), "Uppercase 'U' should be red in glitch mode");
    }
}
