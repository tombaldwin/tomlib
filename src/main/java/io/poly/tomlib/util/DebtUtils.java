package io.poly.tomlib.util;

/// Utility class for fetching and estimating the US national debt.
public final class DebtUtils {

    private DebtUtils() {
        // Utility class
    }

    /// Fetches the US national debt from the Treasury API or provides an estimate.
    /// @return a formatted string of the US national debt
    public static String getUSNationalDebt() {
        try {
            java.net.URL url = new java.net.URL("https://api.fiscaldata.treasury.gov/services/api/fiscal_service/v2/accounting/od/debt_to_penny?sort=-record_date&page[size]=1");
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(500); // 500ms timeout
            conn.setReadTimeout(500);

            if (conn.getResponseCode() == 200) {
                java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream()));
                StringBuilder content = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                String json = content.toString();
                // Extremely simple JSON parsing to find total_public_debt_outstanding
                int index = json.indexOf("\"tot_pub_debt_out_amt\":\"");
                if (index != -1) {
                    int start = index + "\"tot_pub_debt_out_amt\":\"".length();
                    int end = json.indexOf("\"", start);
                    if (end != -1) {
                        String amount = json.substring(start, end);
                        try {
                            double val = Double.parseDouble(amount);
                            return String.format("$%,.2f", val);
                        } catch (NumberFormatException e) {
                            return amount;
                        }
                    }
                }
            }
        } catch (Exception e) {
            // Fallback to estimate
        }
        return getNationalDebtEstimate();
    }

    /// Provides a locally generated estimate of the US national debt.
    /// @return a formatted string of the estimated US national debt
    public static String getNationalDebtEstimate() {
        // Approximate US debt as of April 2026: ~39 trillion
        // Increasing by ~2.5 trillion per year
        long baseTime = 1776422400000L; // Approx April 2026
        double baseDebt = 39_000_000_000_000.0;
        double increasePerMs = 2_500_000_000_000.0 / (365.25 * 24 * 60 * 60 * 1000);

        long now = System.currentTimeMillis();
        double estimatedDebt = baseDebt + (now - baseTime) * increasePerMs;

        return String.format("$%,.2f (ESTIMATED)", estimatedDebt);
    }
}
