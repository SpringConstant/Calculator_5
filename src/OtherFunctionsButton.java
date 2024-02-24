import converter.ConverterPanel;
import numberGuessingGame.NumberGuessingGamePanel;
import numberGuessingGame.NumberGuessingGameTextPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OtherFunctionsButton extends JButton implements ActionListener {
    public Frame frame;
    public OtherFunctionsButton(Frame frame, String text) {
        this.frame = frame;
        setText(text);
        setSize(5, 5); //its just 1 button
        setFocusable(false);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //remove all the panels from the frame
        frame.getContentPane().removeAll();


        //set size of the frame
        frame.setPreferredSize(new Dimension(750,500));


        //set Border for the Frame
        frame.setLayout(new BorderLayout());


        //what the NGG, converter and Calculator buttons will do:
        switch (getText()) {
            case "Number Guessing Game" -> {
                frame.add(new  NumberGuessingGamePanel(), BorderLayout.CENTER);
                frame.setTitle("Number Guessing Game");
                frame.add(new NumberGuessingGameTextPanel(), BorderLayout.NORTH);
            }

            case "Calculator" -> {
                frame.add(new CalculatorPanel(), BorderLayout.CENTER);
                frame.setTitle("Calculator");
                frame.add(new TextPanel(), BorderLayout.NORTH);
            }

            case "Converter" ->{
                frame.add(new ConverterPanel(), BorderLayout.CENTER);
                frame.setTitle("Unit Converter");
            }
        }

        frame.add(new OtherFunctionsPanel(frame), BorderLayout.EAST);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
        frame.pack();
        setVisible(true);
    }
}