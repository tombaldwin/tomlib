package io.poly.tomlib.logo.theme.limmy.mascot;

import io.poly.tomlib.logo.AbstractMascot;
import io.poly.tomlib.util.UserInference;
import java.util.List;

/// Raymond Day mascot - paranormal investigator.
public class RaymondDayMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[]{
            "   .-|||-.   ",
            "  /  ---  \\",
            " |  (O O)  |",
            "  \\  ---  / ",
            "   '-----'  "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        return switch (c) {
            case 'O' -> new int[]{0, 0, 255}; // Blue eyes
            case 's', 'p', 'o', 'k' -> new int[]{150, 150, 255}; // Ethereal text
            default -> new int[]{100, 100, 100}; // Dark/Mysterious
        };
    }

    @Override
    public List<String> getQuotes() {
        String name = "David";
        String inferredFirstName = UserInference.getInferredFirstName();
        if (inferredFirstName != null) {
            name = inferredFirstName;
        }

        return List.of(
            "It's all about the vibration.",
            "I'm sensing a presence.",
            "Can you hear that?",
            "Is there anyone there?",
            "A message from the other side.",
            "I'm Raymond Day, and I'm a psychic.",
            "The spirits are speaking.",
            "I can feel the energy.",
            "They're all around us.",
            "I'm getting a name... " + name + "."
        );
    }
}
