package converter;

import javax.swing.*;
public class ConvertToPanel extends JPanel {
    public static ConverterTextField convertToTextField; //public because ill use it in the ConvertButtonPanel Class
    public static ComboBox comboBoxConvertTo;
    public ConvertToPanel(){
        convertToTextField = new ConverterTextField(false);
        comboBoxConvertTo = new ComboBox();

        add(convertToTextField); //focusable false mean that i cannot type in the textfield
        add(comboBoxConvertTo);

    }
}

