package converter;

import javax.swing.*;
public class ConvertFromPanel extends JPanel {

    public static ConverterTextField convertFromTextField; //public because ill use it in the ConvertButtonPanel Class
    public static ComboBox comboBoxConvertFrom;

    public ConvertFromPanel() {
        convertFromTextField = new ConverterTextField(true);
        comboBoxConvertFrom = new ComboBox();
        add(convertFromTextField);
        add(comboBoxConvertFrom);
    }
}