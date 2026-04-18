package io.poly.tomlib.logo.theme.may4th;

import io.poly.tomlib.logo.AbstractMascot;
import io.poly.tomlib.logo.AbstractTheme;
import io.poly.tomlib.logo.MascotRegistry;
import io.poly.tomlib.logo.font.StarWarsAsciiFont;
import io.poly.tomlib.logo.theme.may4th.mascot.*;
import io.poly.tomlib.logo.theme.may4th.mascot.trek.*;

import static io.poly.tomlib.logo.theme.easter.EasterTheme.arrayOf;

/// Theme for May the 4th (Star Wars Day).
public class May4thTheme extends AbstractTheme {

    public May4thTheme() {
        super(
            "May 4th",
            arrayOf(XWingMascot.class, R2D2Mascot.class, VaderMascot.class, StormtrooperMascot.class,
                DeathStarMascot.class, TieFighterMascot.class, YodaMascot.class, FalconMascot.class),
            arrayOf(JarJarMascot.class, SpockMascot.class, KirkMascot.class, PicardMascot.class),
            new StarWarsAsciiFont()
        );
    }

    @Override
    public String[] getStarsLeft(boolean glitchMode) {
        if (glitchMode) {
            return new String[]{"  -  ", " --  ", " --- ", "  -- ", "  -  ", "     "};
        }
        return generateStarfield();
    }

    @Override
    public String[] getStarsRight(boolean glitchMode) {
        if (glitchMode) {
            return new String[]{"  -  ", "  -- ", " --- ", " --  ", "  -  ", "     "};
        }
        return generateStarfield();
    }

    private String[] generateStarfield() {
        String[] stars = new String[6];
        String pool = ".....+*";
        for (int i = 0; i < 6; i++) {
            char[] s = {' ', ' ', ' ', ' ', ' '};
            // First star: 50% chance
            if (rnd.nextInt(2) == 0) s[rnd.nextInt(5)] = pool.charAt(rnd.nextInt(pool.length()));
            // Second star: 80% chance for more density
            if (rnd.nextInt(10) < 8) {
                int p2 = rnd.nextInt(5);
                if (s[p2] == ' ') s[p2] = pool.charAt(rnd.nextInt(pool.length()));
            }
            // Third star: 40% chance
            if (rnd.nextInt(10) < 4) {
                int p3 = rnd.nextInt(5);
                if (s[p3] == ' ') s[p3] = pool.charAt(rnd.nextInt(pool.length()));
            }
            stars[i] = new String(s);
        }
        return stars;
    }

    @Override
    public boolean isActive(java.time.LocalDate date) {
        return date.getMonthValue() == 5 && date.getDayOfMonth() == 4;
    }

    @Override
    public int getPriority() {
        return 30;
    }

    @Override
    public String getGlitchMessage() {
        AbstractMascot mascot = getMascot(true);
        String prefix = "[!] ";
        if (mascot instanceof JarJarMascot) prefix += "JAR-JAR SAYS: ";
        else if (mascot instanceof SpockMascot) prefix += "SPOCK SAYS: ";
        else if (mascot instanceof KirkMascot) prefix += "KIRK SAYS: ";
        else if (mascot instanceof PicardMascot) prefix += "PICARD SAYS: ";

        return prefix + mascot.getQuote();
    }

    @Override
    public int[] getLogoColour(char c, int row, int col, boolean glitchMode) {
        if (c == '*' || c == '+' || c == '.') {
            return getStarColour(c, row, col, glitchMode);
        }
        return new int[]{255, 255, 0}; // Yellow
    }

    @Override
    public int[] getStarColour(char c, int row, int col, boolean glitchMode) {
        if (glitchMode) {
            return new int[]{255, 0, 0}; // Red for glitch stars
        }
        return new int[]{255, 255, 255}; // White
    }

    @Override
    public boolean glitchDistortion() {
        return false;
    }

    @Override
    public char glitchNoise() {
        return ".+*oO0".charAt(rnd.nextInt(6));
    }
}
