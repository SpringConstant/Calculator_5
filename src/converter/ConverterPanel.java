package converter;

import javax.swing.*;
public class ConverterPanel extends JPanel {
            public ConverterPanel(){
            setSize(750, 500);

            //Creating a Panel which will contain ConvertFromPanel, ConvertToPanel and Convert Button

                setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
                //blank panels are for formatting
                add(new JPanel());
                add(new JPanel());
                add(new ConvertFromPanel());
                add(new ConvertToPanel());
                add(new ConverterButtonPanel());
                add(new JPanel());
                add(new JPanel());
                setVisible(true);
    }
}