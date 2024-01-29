package converter;

import javax.swing.*;
import java.awt.*;

public class ComboBox extends JComboBox<String>{
    public static String[] volumeUnits = {"L", "mL", "Cups", "Tbsp", "Tsp"};
    public static String[] massUnits = {"kg", "g"};

    public ComboBox() {
        setPreferredSize(new Dimension(150, 100));
        for (String unit : volumeUnits) {
            addItem(unit);
        }
        for (String unit : massUnits) {
            addItem(unit);
        }
        setVisible(true);
    }
}
