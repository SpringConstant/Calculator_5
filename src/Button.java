import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Objects;

public class Button extends JButton implements ActionListener {

    //Creating a button
    public Button(String text) {
        setText(text);
        setSize(10, 5);
        setFocusable(false);
        addActionListener(this);

        //The CalculatorPanel has a grid layout of 4 by 5, but I don't use 20 buttons.
        //So the ones with no functions are not seen (it'll just be a blank space)
        if (text.isBlank()) {
            setVisible(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //getText of the button and use if statements to tell what eah buttons does
        String buttonText = getText();

        //get text of the label
        String labelText = TextPanel.label.getText();

        //this for loop makes the button print whatever number is on the label (while avoiding that there are buttons with letters))
        //printing numbers on the text label (in using the same for loop for my number guessing game):
        for (int i = 0; i < 10; i++) {
            if (Objects.equals(buttonText, String.valueOf(i))) {
                TextPanel.label.setText(labelText + i);
            }
        }


        //print pi
        if (Objects.equals(buttonText, "π")) {
            double π = Math.PI;
            TextPanel.label.setText(labelText + "π");
            //add that it takes the number before it and get multiplied
            //add that if its alone, treat it like any other number
        }


        //print .
        else if (Objects.equals(buttonText, ".")) {
            TextPanel.label.setText(labelText + ".");
        }


        //when "Clear" button is pressed, the text becomes empty
        else if (Objects.equals(buttonText, "Clear")) {
            TextPanel.label.setText("");
            disableOperators(false);
        }



        //when there is text on the label and the "delete button is pressed", the last character gets removed
        else if (Objects.equals(buttonText, "Delete") && !labelText.isBlank()) {
            TextPanel.label.setText(labelText.substring(0, labelText.length() - 1));

            //the operators are surround by two spaces. so when the character to remove is a space (it'll remove all 3 characters (space, operator, space))
            if (labelText.charAt(labelText.length() - 1) == ' ') {
                TextPanel.label.setText(labelText.substring(0, labelText.length() - 3));
            }

            char c = 0;
            //I need to look for the operator with (labelText.length()) - 2 because (labelText.length()) - 1 is a space
            try {
                c = labelText.charAt(labelText.length() - 2);
            }
            catch (IndexOutOfBoundsException exception2){
                //doing labelText.length()) - 2 when there's only one character left on the text label gives an exception
                //I need nothing to happen though
            }

            //context : whenever an operator is used, all operator buttons are disabled (to do one equation at a time)
            //so when you delete an operator from the text label, this if statement will enable it again
            if (c == '+' || c == '-' ||
                    c == '×' || c == '÷') {
                disableOperators(false);
            }
        }



        //copy and paste answer for next calculation and enables the operator (it works like the reset button, but your first number is your answer from the previous calculation)
        else if (Objects.equals(buttonText, "Ans")) {
            TextPanel.label.setText(TextPanel.label.getText());
            disableOperators(false);
        }


        //printing operators :
        char[] operatorsArray = {'+', '-', '×', '÷'};
        for (int i = 0; i <= 3; i++) {
            if (Objects.equals(buttonText, String.valueOf(operatorsArray[i]))) {
                TextPanel.label.setText(labelText + " " + operatorsArray[i] + " ");
                disableOperators(true);
                return;
            }
        }



        //equal sign (operation is happening)
        if (Objects.equals(buttonText, "=")) {
            TextPanel.label.setText(labelText + " = ");

            //π becomes 3.1415926535
            if (labelText.contains("π")) {
                labelText = labelText.replace("π", String.valueOf(Math.PI));
            }

            String[] equationArray = labelText.split(" ");
            double firstNum;
            double secondNum;

            //if the user doesn't
            try {
                firstNum = Double.parseDouble(equationArray[0]);
                secondNum = Double.parseDouble(equationArray[2]);
            } catch (Exception exception) {
                TextPanel.label.setText("Error. Press clear");
                return;
            }

            switch (equationArray[1]) {

                case "+":
                    TextPanel.label.setText(String.valueOf(BigDecimal.valueOf(firstNum + secondNum)));
                    break;

                case "-":
                    TextPanel.label.setText(String.valueOf(BigDecimal.valueOf(firstNum - secondNum)));
                    break;

                case "×":
                    TextPanel.label.setText(String.valueOf(BigDecimal.valueOf(firstNum * secondNum)));
                    break;

                case "÷":
                    TextPanel.label.setText(String.valueOf(BigDecimal.valueOf(firstNum / secondNum)));
                    break;
            }
        }
    }



    public void disableOperators(boolean disable) {
        for (int i = 0; i < 4; i++) {
            CalculatorPanel.operatorsArray[i].setEnabled(!disable);
        }
    }
}