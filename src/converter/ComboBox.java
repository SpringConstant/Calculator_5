package converter;

import javax.swing.*;
import java.awt.*;

public class ComboBox extends JComboBox<String>{
    //separating these two types of unit because later on, I need to avoid letting a conversion between volume and mass happen
    public static String[] volumeUnits = {"L", "mL", "Cups", "Tbsp", "Tsp"};
    public static String[] massUnits = {"kg", "g"};


    public ComboBox() {
        setPreferredSize(new Dimension(150, 100));
        //adding the two types of units to the combo
        //later, I'm adding this combobox in the ConvertFromPanel and ConvertToPanel
        for (String unit : volumeUnits) {
            addItem(unit);
        }
        for (String unit : massUnits) {
            addItem(unit);
        }
        setVisible(true);
    }
}