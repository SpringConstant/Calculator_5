package number_guessing_game;
import javax.swing.*;
import java.awt.*;

import static number_guessing_game.NumberGuessingGamePanel.RANGE;

public class NumberGuessingGameTextPanel extends JPanel {
    //it's ont this label that the text and numbers appear
    public static JLabel label;

    //the NumberGuessingGameTextPanel contains the label
    public NumberGuessingGameTextPanel(){
            setPreferredSize(new Dimension(750, 50));
            label = new JLabel();
            label.setPreferredSize(new Dimension(750, 50));
            label.setBorder(BorderFactory.createEmptyBorder(0,15,0,0));
            label.setText("Guess a number between 0 and " + RANGE + "!");
            add(label);
    }
}