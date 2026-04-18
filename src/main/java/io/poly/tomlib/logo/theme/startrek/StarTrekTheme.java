package io.poly.tomlib.logo.theme.startrek;

import io.poly.tomlib.logo.AbstractMascot;
import io.poly.tomlib.logo.AbstractTheme;
import io.poly.tomlib.logo.FontRegistry;
import io.poly.tomlib.logo.font.StarTrekAsciiFont;
import io.poly.tomlib.logo.theme.may4th.mascot.*;
import io.poly.tomlib.logo.theme.startrek.mascot.*;
import java.time.LocalDate;

import static io.poly.tomlib.logo.theme.easter.EasterTheme.arrayOf;

/// Theme for Star Trek.
public class StarTrekTheme extends AbstractTheme {

    public StarTrekTheme() {
        super(
            "Star Trek",
            arrayOf(KirkMascot.class, SpockMascot.class, PicardMascot.class),
            arrayOf(
                DeathStarMascot.class,
                FalconMascot.class,
                R2D2Mascot.class,
                StormtrooperMascot.class,
                TieFighterMascot.class,
                VaderMascot.class,
                XWingMascot.class,
                YodaMascot.class
            ),
            FontRegistry.getFont(StarTrekAsciiFont.class).orElseThrow()
        );
    }

    @Override
    public boolean isActive(LocalDate date) {
        // September 8 is Star Trek Day (anniversary of the original series premiere in 1966)
        return date.getMonthValue() == 9 && date.getDayOfMonth() == 8;
    }

    @Override
    public int getPriority() {
        return 25;
    }

    @Override
    public String getGlitchMessage() {
        return "[!] SUBSPACE INTERFERENCE DETECTED";
    }

    @Override
    public String[] getStarsRight(boolean glitchMode) {
        return new String[]{"  *  ", " . + ", "  .  ", " + . ", "  *  ", " . + "};
    }

    @Override
    public int[] getLogoColour(char c, int row, int col, boolean glitchMode) {
        // Stars should be white
        if (c == '*' || c == '+' || c == '.') {
            return new int[]{255, 255, 255};
        }
        // Gold/Yellow for the logo
        return new int[]{255, 215, 0};
    }
}
