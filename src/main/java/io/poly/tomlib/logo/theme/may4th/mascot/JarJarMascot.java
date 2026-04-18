package io.poly.tomlib.logo.theme.may4th.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// Star Wars Mascot: Jar-Jar Binks (Glitch)
public class JarJarMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            "  _   _  ",
            " (o) (o) ",
            "  | v |  ",
            " /  -  \\ ",
            " |  _  | ",
            " \\_____/ "
        };
    }

    @Override
    public String getQuote() {
        String[] quotes = {
            "Mesa called Jar Jar Binks, mesa your humble servant!",
            "Ex-squeeze me, but the mostest safest place would be Gunga City.",
            "Yousa thinking yousa people ganna die?",
            "Ooh, maxi big da Force. Well, dat smells good.",
            "Mesa cause-a some storage?",
            "How wude!",
            "Mesa day startin okay then BOOM! Gettin berry scared, and then mesa see that guy and mesa be like... 'Who's that guy?'",
            "Mesa tinking mesa stay here wit yousa.",
            "Wesa got a grand army. That's why yousa no tinking wesa can help yousa."
        };
        return quotes[new java.util.Random().nextInt(quotes.length)];
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        int[] rgb = {210, 180, 140};
        if (c == 'o') rgb = new int[]{255, 255, 0};
        else if (c == 'v') rgb = new int[]{255, 0, 0};
        return rgb;
    }
}
