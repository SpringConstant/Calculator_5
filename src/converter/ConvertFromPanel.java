package converter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConvertFromPanel extends JPanel implements ActionListener {

    public static ConverterTextField convertFromTextField; //public because ill use it in the ConvertButtonPanel Class
     public static ComboBox comboBoxConvertFrom;
    public ConvertFromPanel(){
        convertFromTextField = new ConverterTextField(true);
        comboBoxConvertFrom = new ComboBox();

        add(convertFromTextField); //Focusable true means that  can type in it
        add(comboBoxConvertFrom);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
