package io.poly.tomlib.logo.theme.fourthofjuly;

import io.poly.tomlib.logo.AbstractMascot;
import io.poly.tomlib.logo.AbstractTheme;
import io.poly.tomlib.logo.MascotRegistry;
import io.poly.tomlib.logo.theme.fourthofjuly.mascot.EagleMascot;
import io.poly.tomlib.logo.theme.fourthofjuly.mascot.USFireworksMascot;
import io.poly.tomlib.logo.theme.fourthofjuly.mascot.USFlagMascot;
import io.poly.tomlib.util.DebtUtils;

import java.util.Random;

import static io.poly.tomlib.logo.theme.easter.EasterTheme.arrayOf;

/// Theme for the 4th of July (Independence Day).
public class FourthOfJulyTheme extends AbstractTheme {
    private final Random random = new Random();

    public FourthOfJulyTheme() {
        super(
            "4th of July",
            arrayOf(EagleMascot.class, USFireworksMascot.class, USFlagMascot.class),
            arrayOf(EagleMascot.class, USFireworksMascot.class, USFlagMascot.class)
        );
    }

    @Override
    public String[] getStarsLeft(boolean glitchMode) {
        return new String[]{"  *  ", " + . ", "  .  ", " . + ", "  *  ", "  .  "};
    }

    @Override
    public String[] getStarsRight(boolean glitchMode) {
        return new String[]{"  *  ", " . + ", "  .  ", " + . ", "  *  ", " . + "};
    }

    @Override
    public int[] getStarColour(char c, int row, int col, boolean glitchMode) {
        // Red, White, Blue for stars
        return switch (random.nextInt(3)) {
            case 0 -> new int[]{255, 0, 0};     // Red
            case 1 -> new int[]{255, 255, 255}; // White
            default -> new int[]{0, 0, 255};    // Blue
        };
    }

    @Override
    public int[] getLogoColour(char c, int row, int col, boolean glitchMode) {
        if (c == '*' || c == '+' || c == '.') {
            return getStarColour(c, row, col, glitchMode);
        }

        double factor = (row * 15.0 + col * 5.0) / 360.0;
        int colourIndex = (int) (factor * 30) % 3;

        return switch (colourIndex) {
            case 0 -> new int[]{255, 0, 0};     // Red
            case 1 -> new int[]{255, 255, 255}; // White
            case 2 -> new int[]{0, 0, 255};     // Blue
            default -> new int[]{255, 255, 255};
        };
    }

    @Override
    public String getGlitchMessage() {
        return "[!] GLITCH DETECTED: US National Debt: " + DebtUtils.getUSNationalDebt();
    }

    @Override
    public boolean isActive(java.time.LocalDate date) {
        return date.getMonth() == java.time.Month.JULY && date.getDayOfMonth() == 4;
    }

    @Override
    public String getActivationRule() {
        return "Active on the 4th of July (Independence Day).";
    }

    @Override
    public int getPriority() {
        return 30;
    }

}
