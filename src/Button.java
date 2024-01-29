import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Objects;

public class Button extends JButton implements ActionListener {
    private double firstNum;

    /*Creates a button.*/
    public Button(String text) {
        setText(text);
        setSize(10, 5);
        setFocusable(false);
        addActionListener(this);
        if (text.isBlank()) {
            setVisible(false);
        }
    }

    public void disableOperators(boolean disable) {
        for (int i = 0; i < 4; i++) {
            CalculatorPanel.operatorsArray[i].setEnabled(!disable);
        }
    }




    @Override
    public void actionPerformed(ActionEvent e) {

        //getText of the button and use if statements to tell what eah buttons does
        String buttonText = getText();

        //get text of the label
        String labelText = TextPanel.label.getText();


        // Numbers :
        for (int i = 0; i < 10; i++) {
            if (Objects.equals(buttonText, String.valueOf(i))) {
                TextPanel.label.setText(labelText + i);
            }
        }

        if (Objects.equals(buttonText, "π")) {
            double π = Math.PI;
            TextPanel.label.setText(labelText + "π");
            //add that it takes the number before it and get multi[plied
            //add that if its alone, treat it like any other number

        } else if (Objects.equals(buttonText, ".")) {
            TextPanel.label.setText(labelText + ".");

        } else if (Objects.equals(buttonText, "Clear")) {
            TextPanel.label.setText("");
            disableOperators(false);

        } else if (Objects.equals(buttonText, "Delete") && !labelText.isBlank()) {
            TextPanel.label.setText(labelText.substring(0, labelText.length() - 1));

            if (labelText.charAt(labelText.length() - 1) == ' ') {
                TextPanel.label.setText(labelText.substring(0, labelText.length() - 3));
            }

            char c = 0;
            try {
                c = labelText.charAt(labelText.length() - 2);
            }
            catch (IndexOutOfBoundsException exception2){
                
            }
            if (c == '+' || c == '-' ||
                    c == '×' || c == '÷') {
                disableOperators(false);
            }
            
        } else if (Objects.equals(buttonText, "Ans")) {
            TextPanel.label.setText(TextPanel.label.getText());
            disableOperators(false);
        }


        //Operators :
        char[] operatorsArray = {'+', '-', '×', '÷'};
        for (int i = 0; i <= 3; i++) {
            if (Objects.equals(buttonText, String.valueOf(operatorsArray[i]))) {
                TextPanel.label.setText(labelText + " " + operatorsArray[i] + " ");
                disableOperators(true);
                return;
            }
        }


        //equal sign
        if (Objects.equals(buttonText, "=")) {
            TextPanel.label.setText(labelText + " = ");
            //add code for addition substraction multiplicatio and division


            if (labelText.contains("π")) {
                labelText = labelText.replace("π", String.valueOf(Math.PI));
            }

            String[] equationArray = labelText.split(" ");
            double firstNum = 0;
            double secondNum = 0;

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
}