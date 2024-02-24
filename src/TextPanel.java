import javax.swing.*;
import java.awt.*;
public class TextPanel extends JPanel {
    public static JLabel label;
    public TextPanel() {
        //TextPanel has a label where all the equations and their answers will appear
        setPreferredSize(new Dimension(750, 50));
        label = new JLabel();
        label.setPreferredSize(new Dimension(750, 50));
        label.setBorder(BorderFactory.createEmptyBorder(0,15,0,0));
        add(label);
    }
}