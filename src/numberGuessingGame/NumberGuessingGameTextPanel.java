package numberGuessingGame;

import javax.swing.*;
import java.awt.*;

public class NumberGuessingGameTextPanel extends JPanel {
    public static JLabel label;
    public NumberGuessingGameTextPanel(){


            setPreferredSize(new Dimension(750, 50));

            label = new JLabel();
            label.setPreferredSize(new Dimension(750, 50));
            label.setBorder(BorderFactory.createEmptyBorder(0,15,0,0));
            label.setText("Guess a number between 0 and 100");
            add(label);
    }

}