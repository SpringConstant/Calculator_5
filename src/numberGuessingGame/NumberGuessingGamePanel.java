package numberGuessingGame;

import javax.swing.*;
import java.awt.*;
public class NumberGuessingGamePanel extends JPanel {
    public static int numberToBeGuessed;
    public NumberGuessingGamePanel(){
        setLayout(new GridLayout(3,5,10,10));
        setBorder(BorderFactory.createEmptyBorder(0,2,0,0));

        String[] buttonsText = {"7", "8", "9", "Reset", "Delete",
                                "4", "5", "6", "Enter", " ",
                                "1", "2", "3", "0", " "};


        for (int i = 0; i < 15; i++) {
            add(new NumberGuessingGameButton(buttonsText[i]));
        }
        numberToBeGuessed = (int) (Math.random() * 101);
    }
}