package calculator;

import javax.swing.*;
import java.awt.*;
public class CalculatorPanel extends JPanel {
public static CalculatorButton[] operatorsArray = new CalculatorButton[4];
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
            CalculatorButton calculatorButton = new CalculatorButton(buttonsText[i]);
            add(calculatorButton);

            /*this is statement put the operators into an array that is later used in the CalculatorButton class
              to disable those operator when they are used (to avoid doing multiple operations in a single line)*/
            if (buttonsText[i].equals("+") || buttonsText[i].equals("-") || buttonsText[i].equals("×") || buttonsText[i].equals("÷")) {
                operatorsArray[index] = calculatorButton;
                        index++;
            }
        }
    }
}