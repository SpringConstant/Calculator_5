package calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Objects;

public class CalculatorButton extends JButton implements ActionListener {

    //Creating a button
    public CalculatorButton(String text) {
        setText(text);
        setSize(10, 5);
        setFocusable(false);
        addActionListener(this);

        /*The calculator.CalculatorPanel has a grid layout of 4 by 5, but I don't use 20 buttons.
        So the ones with no functions are not seen (it'll just be a blank space)*/
        if (text.isBlank()) {
            setVisible(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //getText of the button and use if statements to tell what eah buttons does
        String buttonText = getText();

        //get text of the label
        String labelText = CalculatorTextPanel.label.getText();

        switch (buttonText) {
            case "π", ".", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" -> {
                CalculatorTextPanel.label.setText(labelText + buttonText);
            }
            case "Clear" -> {
                CalculatorTextPanel.label.setText("");
                disableOperators(false);
            }
            case "Ans" -> {
                /*copy and paste answer for next calculation and enables the operator (it works like the reset button,
                 but your first number is your answer from the previous calculation)*/
                CalculatorTextPanel.label.setText(CalculatorTextPanel.label.getText());
                disableOperators(false);
            }
            case "=" -> {
                caculate(labelText);
            }
            case "Delete" -> {
                //when there is text on the label and the "delete button is pressed", the last character gets removed
                if (!labelText.isBlank()){
                    delete(labelText);
                }
            }
        }

        //printing operators :
        char[] operatorsArray = {'+', '-', '×', '÷'};
        for (int i = 0; i <= 3; i++) {
            if (Objects.equals(buttonText, String.valueOf(operatorsArray[i]))) {
                CalculatorTextPanel.label.setText(labelText + " " + operatorsArray[i] + " ");
                disableOperators(true);
                return;
            }
        }
    }



    private void delete(String labelText) {
        CalculatorTextPanel.label.setText(labelText.substring(0, labelText.length() - 1));

        //the operators are surround by two spaces. so when the character to remove is a space (it'll remove all 3 characters (space, operator, space))
        if (labelText.charAt(labelText.length() - 1) == ' ') {

            CalculatorTextPanel.label.setText(labelText.substring(0, labelText.length() - 3));
            disableOperators(false);
        }
    }


    private static void caculate(String labelText) {
        //π becomes 3.1415926535
        if (labelText.contains("π")) {
            labelText = labelText.replace("π", String.valueOf(Math.PI));
        }

        String[] equationArray = labelText.split(" ");
        double firstNum;
        double secondNum;

        try {
            firstNum = Double.parseDouble(equationArray[0]);
            secondNum = Double.parseDouble(equationArray[2]);
        } catch (Exception exception) {
            CalculatorTextPanel.label.setText("Error. Press clear");
            return;
        }

        switch (equationArray[1]) {
            case "+" -> CalculatorTextPanel.label.setText(String.valueOf(BigDecimal.valueOf(firstNum + secondNum)));
            case "-" -> CalculatorTextPanel.label.setText(String.valueOf(BigDecimal.valueOf(firstNum - secondNum)));
            case "×" -> CalculatorTextPanel.label.setText(String.valueOf(BigDecimal.valueOf(firstNum * secondNum)));
            case "÷" -> CalculatorTextPanel.label.setText(String.valueOf(BigDecimal.valueOf(firstNum / secondNum)));
        }
    }



    public void disableOperators(boolean disable) {
        for (int i = 0; i < 4; i++) {
            CalculatorPanel.operatorsArray[i].setEnabled(!disable);
        }
    }
}