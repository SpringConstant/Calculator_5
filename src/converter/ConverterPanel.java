package converter;

import javax.swing.*;

public class ConverterPanel extends JPanel {
            public ConverterPanel(){
            setSize(750, 500);

            //Creating a Panel which will contain ConvertFromPanel, ConvertToPanel and Convert Button
                JPanel bigPanel = new JPanel();
                bigPanel.setLayout(new BoxLayout(bigPanel, BoxLayout.Y_AXIS));
                bigPanel.add(new ConvertFromPanel());
                bigPanel.add(new ConvertToPanel());
                bigPanel.add(new ConvertButtonPanel());
                add(bigPanel);
                setVisible(true);
    }
}