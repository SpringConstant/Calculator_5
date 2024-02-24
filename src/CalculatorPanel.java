import javax.swing.*;
import java.awt.*;
public class CalculatorPanel extends JPanel {
public static Button[] operatorsArray = new Button[4];
    public CalculatorPanel(){
        setLayout(new GridLayout(4,5,10,10));
        setBorder(BorderFactory.createEmptyBorder(0,2,0,0));

        //Layout of my calculator
        String[] buttonsText = {"7", "8", "9", "×", "÷",
                                "4", "5", "6", "+", "-",
                                "1", "2", "3", "=", "Delete",
                                "0", ".", "π", "Ans", "Clear"};


        int index = 0;
        for (int i = 0; i < 20; i++) {
            Button calculatorButton = new Button(buttonsText[i]);
            add(calculatorButton);

            if (buttonsText[i].equals("+") || buttonsText[i].equals("-") || buttonsText[i].equals("×") || buttonsText[i].equals("÷")) {
                operatorsArray[index] = calculatorButton;
                        index++;
            }
        }
    }
}