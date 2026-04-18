package io.poly.tomlib.logo;

import io.poly.tomlib.logo.font.AsciiFont;
import io.poly.tomlib.logo.font.DefaultAsciiFont;
import java.util.*;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;

import static java.util.Collections.unmodifiableList;

/// Abstract base class for themes to share common functionality.
public abstract class AbstractTheme implements Theme {
    protected final String name;
    protected final List<AbstractMascot> normalMascots;
    protected final List<AbstractMascot> glitchMascots;
    protected final List<AbstractMascot> allMascots;
    protected final AsciiFont font;
    protected RandomGenerator rnd = RandomGenerator.getDefault();

    protected AbstractTheme(String name, Class<? extends AbstractMascot>[] normalMascots, Class<? extends AbstractMascot>[] glitchMascots) {
        this(name, normalMascots, glitchMascots, FontRegistry.getDefaultFont());
    }

    protected AbstractTheme(String name, Class<? extends AbstractMascot>[] normalMascots, Class<? extends AbstractMascot>[] glitchMascots, AsciiFont font) {
        this.name = name;
        this.font = font;

        this.normalMascots = unmodifiableList(new ArrayList<AbstractMascot>(MascotRegistry.getMascots(normalMascots)));
        this.glitchMascots = unmodifiableList(new ArrayList<AbstractMascot>(MascotRegistry.getMascots(glitchMascots)));
        this.allMascots = union(this.normalMascots, this.glitchMascots);
    }

    @SafeVarargs
    private static <T, V extends T> List<T> union(List<T>... lists) {
        return Arrays.stream(lists).flatMap(Collection::stream).distinct().collect(Collectors.toList());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String[] getLogo(String logoText, boolean glitchMode) {
        // Default implementation uses the assigned font logic if not overridden
        return font.render(logoText);
    }

    @Override
    public final void printMascots(Boolean glitchMode) {
        getMascots(glitchMode).forEach(AbstractMascot::print);
    }

    public final List<AbstractMascot> getMascots(Boolean glitchMode) {
        ArrayList<AbstractMascot> mascots = new ArrayList<>();
        if (glitchMode == null || glitchMode) {
            mascots.addAll(glitchMascots);
        }
        if (glitchMode == null || !glitchMode) {
            mascots.addAll(normalMascots);
        }
        return mascots;
    }

    /// Returns an equally weighted random Mascot from those available.
    /// @param glitchMode whether to return a glitch variant.
    /// @return the mascot instance.
    public AbstractMascot getMascot(boolean glitchMode) {
        List<AbstractMascot> available = getMascots(glitchMode);
        if (available.isEmpty()) return null;
        return available.get(new Random().nextInt(available.size()));
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
    public int[] getLogoColour(char c, int row, int col, boolean glitchMode) {
        double hue = (row * 15.0 + col * 5.0) % 360.0;
        if (glitchMode && new java.util.Random().nextInt(3) == 0) {
            hue = (hue + new java.util.Random().nextInt(180)) % 360.0;
        }
        return hsvToRgb(hue, 1.0, 1.0);
    }

    @Override
    public int[] getStarColour(char c, int row, int col, boolean glitchMode) {
        return new int[]{255, 255, 255}; // Default white
    }

    @Override
    public String getGlitchMessage() {
        return "[!] GLITCH DETECTED";
    }

    protected int[] hsvToRgb(double h, double s, double v) {
        double c = v * s;
        double x = c * (1 - Math.abs((h / 60.0) % 2 - 1));
        double m = v - c;
        double r, g, b;
        if (h < 60) {
            r = c; g = x; b = 0;
        } else if (h < 120) {
            r = x; g = c; b = 0;
        } else if (h < 180) {
            r = 0; g = c; b = x;
        } else if (h < 240) {
            r = 0; g = x; b = c;
        } else if (h < 300) {
            r = x; g = 0; b = c;
        } else {
            r = c; g = 0; b = x;
        }
        return new int[]{(int) ((r + m) * 255), (int) ((g + m) * 255), (int) ((b + m) * 255)};
    }

    @Override
    public char glitchNoise() {
        return "░▒▓.@#%&*~░▒▓".charAt(rnd.nextInt(13));
    }

    @Override
    public int noiseCount() {
        return rnd.nextInt(6);
    }

    @Override
    public void addNoiseColour(StringBuilder colouredLine, int row, int col, char c, boolean glitchMode) {
        // Greyscale noise characters
        int grey = rnd.nextInt(100) + 50; // Greyscale 50-150
        colouredLine.append(String.format("\u001B[38;2;%d;%d;%dm%c\u001B[0m", grey, grey, grey, c));
    }
}
