import javax.swing.*;
import java.awt.*;
public class TextPanel extends JPanel {
    public static JLabel label;

    public TextPanel() {
        setPreferredSize(new Dimension(750, 50));

        label = new JLabel();
        label.setPreferredSize(new Dimension(750, 50));
        label.setBorder(BorderFactory.createEmptyBorder(0,15,0,0));
        add(label);
    }

}