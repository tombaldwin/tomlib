package io.poly.tomlib.logo.theme.birthday;

import io.poly.tomlib.logo.AbstractTheme;
import io.poly.tomlib.util.UserInference;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Arrays;

import static io.poly.tomlib.logo.theme.easter.EasterTheme.arrayOf;

/// Theme for Birthdays.
/// Features a birthday cake logo that can adapt to the user's name.
public class BirthdayTheme extends AbstractTheme {

    /// Default constructor.
    public BirthdayTheme() {
        super(
            "Birthday", arrayOf(), arrayOf()
        );
    }

    @Override
    public boolean isActive(LocalDate date) {
        MonthDay birthday = getInferredBirthday();
        return birthday != null && date.getMonthValue() == birthday.getMonthValue() && date.getDayOfMonth() == birthday.getDayOfMonth();
    }

    @Override
    public int getPriority() {
        return 30;
    }

    @Override
    public int[] getLogoColour(char c, int row, int col, boolean glitchMode) {
        double factor = (row * 15.0 + col * 5.0) / 360.0;
        int colourIndex = (int) (factor * 40) % 4;
        return switch (colourIndex) {
            case 0 -> new int[]{255, 20, 147};  // Deep Pink
            case 1 -> new int[]{255, 255, 0};   // Yellow
            case 2 -> new int[]{0, 255, 255};   // Cyan
            case 3 -> new int[]{127, 255, 0};   // Chartreuse
            default -> new int[]{255, 255, 255};
        };
    }

    @Override
    public int[] getStarColour(char c, int row, int col, boolean glitchMode) {
        if (c == 'i' || c == '!') {
            return new int[]{255, 255, 0}; // Yellow for candles/flames
        } else if (c == '*' || c == '+' || c == '.') {
            // Bright sprinkles/stars
            return switch (new java.util.Random().nextInt(3)) {
                case 0 -> new int[]{255, 105, 180}; // Hot Pink
                case 1 -> new int[]{0, 255, 255};   // Cyan
                default -> new int[]{255, 255, 0};   // Yellow
            };
        }
        return super.getStarColour(c, row, col, glitchMode);
    }

    @Override
    public String[] getLogo(String logoText) {
        String text = logoText;
        String inferredName = getInferredName();
        MonthDay birthday = getInferredBirthday();

        if (inferredName != null && birthday != null) {
            // Use first name only
            text = inferredName.split("\\s+")[0].toLowerCase();
        }

        int textLength = text.length();
        int width = Math.max(textLength + 4, 16); // Minimum width for a decent cake

        // Shared calculation for centred text line
        int totalPadding = width - 2 - textLength;
        int leftPadding = totalPadding / 2;
        int rightPadding = totalPadding - leftPadding;
        String textLine = "|" + " ".repeat(leftPadding) + text + " ".repeat(rightPadding) + "|";

        // Generate candles based on width
        int candleCount = Math.min(width / 4, 8);
        int candleWidth = width - 2;
        int totalCandleSpace = (candleCount - 1) * 3 + 1; // Assuming 3-space interval for candles
        int startPos = 1 + (candleWidth - totalCandleSpace) / 2;

        StringBuilder flames = new StringBuilder(" ".repeat(width));
        StringBuilder candles = new StringBuilder(" ".repeat(width));

        for (int i = 0; i < candleCount; i++) {
            int pos = startPos + i * 3;
            if (pos < width - 1) {
                flames.setCharAt(pos, 'i');
                candles.setCharAt(pos, '!');
            }
        }

        String top = " " + "-".repeat(width - 2) + " ";
        String icing = "|" + "  ~".repeat((width - 2) / 3) + " ".repeat((width - 2) % 3) + "|";
        String bottom = "|" + "_".repeat(width - 2) + "|";

        return new String[] {
            flames.toString(),
            candles.toString(),
            top,
            icing,
            textLine,
            bottom
        };
    }

    ///
    /// Attempts to infer the user's birthday from the local environment.
    ///
    /// @return the inferred MonthDay, or null if not found
    ///
    protected MonthDay getInferredBirthday() {
        return UserInference.getInferredBirthday();
    }

    ///
    /// Attempts to infer the user's name from the local environment.
    ///
    /// @return the inferred name, or null if not found
    ///
    protected String getInferredName() {
        return UserInference.getInferredName();
    }

}
