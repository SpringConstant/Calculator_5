import calculator.CalculatorPanel;
import calculator.CalculatorTextPanel;

import javax.swing.*;
import java.awt.*;
public class Frame extends JFrame {
    //acts like the Main class
    public Frame() {
        setSize(750,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        //The calculator and number guessing game have 3 panels.
           // CENTER panel : (main buttons that do the job)
           // NORTH panel : text Label
           // EAST panel : Buttons to get to the other functions of the program

        // Converter has only 2 panels.
           // CENTER panel : 2 comboBoxes (each of them are attached to a textField)
           // EAST panel : Buttons to get toe the other functions of the program

        //adding calculator panel to start with and the panel to reach the other panels on the side
        setTitle("Calculator");
        add(new CalculatorPanel(), BorderLayout.CENTER);
        add(new SwitchFunctionsPanel(this), BorderLayout.EAST);
        add(new CalculatorTextPanel(), BorderLayout.NORTH);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Frame();
    }
}