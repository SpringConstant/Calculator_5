package converter;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

public class ConverterTextField extends JFormattedTextField {

    public ConverterTextField(boolean focusable) {
        setFocusable(focusable); //will be true for ConvertFrom, but false for ConvertTo
        setPreferredSize(new Dimension(300, 100));
        setBorder(new EtchedBorder());
        NumberFormat format = NumberFormat.getIntegerInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        setFormatter(formatter);
        DefaultFormatterFactory factory = new DefaultFormatterFactory(formatter);
        setFormatterFactory(factory);
    }
}
