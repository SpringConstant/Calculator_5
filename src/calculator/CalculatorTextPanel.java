package calculator;

import javax.swing.*;
import java.awt.*;
public class CalculatorTextPanel extends JPanel {
    public static JLabel label;
    public CalculatorTextPanel() {
        //TextPanel has a label where all the equations and their answers will appear (NORTH)
        setPreferredSize(new Dimension(750, 50));

        label = new JLabel();
        label.setPreferredSize(new Dimension(750, 50));
        label.setBorder(BorderFactory.createEmptyBorder(0,15,0,0));
        add(label);
    }
}