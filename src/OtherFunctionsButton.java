import converter.ConverterPanel;
import numberGuessingGame.NumberGuessingGamePanel;
import numberGuessingGame.NumberGuessingGameTextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OtherFunctionsButton extends JButton implements ActionListener {
    public OtherFunctionsButton(String text) {
        setText(text);
        setSize(5, 5); //its just 1 button
        setFocusable(false);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame Frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        //Remove all the panel from the frame
        Frame.getContentPane().removeAll();

        //Make the Frame stay the size (for Calculator, Converter and NGG)
        Frame.setPreferredSize(new Dimension(750,500));

        //Set Border for the Frame
        Frame.setLayout(new BorderLayout());


        //What the NGG, converter and Calculator buttons will do:
        switch (getText()) {
            case "Number Guessing Game" -> {
                Frame.add(new  NumberGuessingGamePanel(), BorderLayout.CENTER);
                Frame.setTitle("Number Guessing Game");
                Frame.add(new NumberGuessingGameTextPanel(), BorderLayout.NORTH);
            }

            case "Calculator" -> {
                Frame.add(new CalculatorPanel(), BorderLayout.CENTER);
                Frame.setTitle("Calculator");
                Frame.add(new TextPanel(), BorderLayout.NORTH);
            }

            case "Converter" ->{
                Frame.add(new ConverterPanel(), BorderLayout.CENTER);
                Frame.setTitle("Unit Converter");
            }
        }

        Frame.add(new OtherFunctionsPanel(), BorderLayout.EAST);
        Frame.getContentPane().validate();
        Frame.getContentPane().repaint();

        Frame.pack();
        setVisible(true);
    }
}