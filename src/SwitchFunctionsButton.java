import calculator.CalculatorPanel;
import calculator.CalculatorTextPanel;
import converter.ConverterPanel;
import number_guessing_game.NumberGuessingGamePanel;
import number_guessing_game.NumberGuessingGameTextPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwitchFunctionsButton extends JButton implements ActionListener {
    private final Frame frame;
    public SwitchFunctionsButton(Frame frame, String text) {
        this.frame = frame;
        setText(text);
        setSize(5, 5);
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

        //what the "NGG", "Converter" and "Calculator" buttons will do:
        switch (getText()) {
            case "Number Guessing Game" -> {
                frame.setTitle("Number Guessing Game");
                frame.add(new  NumberGuessingGamePanel(), BorderLayout.CENTER);
                frame.add(new NumberGuessingGameTextPanel(), BorderLayout.NORTH);
            }

            case "Calculator" -> {
                frame.setTitle("Calculator");
                frame.add(new CalculatorPanel(), BorderLayout.CENTER);
                frame.add(new CalculatorTextPanel(), BorderLayout.NORTH);
            }

            case "Converter" ->{
                frame.setTitle("Unit Converter");
                frame.add(new ConverterPanel(), BorderLayout.CENTER);
            }
        }

        frame.add(new SwitchFunctionsPanel(frame), BorderLayout.EAST);
        frame.getContentPane().validate();
        setVisible(true);
    }
}