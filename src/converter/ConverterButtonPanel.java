package converter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Objects;

public class ConverterButtonPanel extends JPanel implements ActionListener {

    final HashMap<String, Double> conversionMap = new HashMap<>();

    public ConverterButtonPanel(){
        JButton button = new JButton("Convert");
        button.setPreferredSize(new Dimension(300,100));
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setFocusable(false);
        button.addActionListener(this);
        add(button);

        //number of milliliter in every one of those units
        conversionMap.put("g", 1.0); //g is the key, and 1.0 is the value
        conversionMap.put("kg", 1000.0);
        conversionMap.put("ml", 1.0);
        conversionMap.put("l", 1000.0);
        conversionMap.put("tsp", 5.0);
        conversionMap.put("tbsp", 15.0);
        conversionMap.put("cups", 250.0);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        double numberToConvertFrom;

        try{
            numberToConvertFrom = Double.parseDouble(ConvertFromPanel.convertFromTextField.getText());
        } catch (Exception exception){
            ConvertToPanel.convertToTextField.setText("Numbers only!");
            return;
        }

        //System.out.println(numberToConvertFrom);
        String unitConvertFrom = ((String) Objects.requireNonNull(ConvertFromPanel.comboBoxConvertFrom.getSelectedItem())).toLowerCase();
        String unitConvertTo = ((String) Objects.requireNonNull(ConvertToPanel.comboBoxConvertTo.getSelectedItem())).toLowerCase();

        //if ((mass) tries to be converted into (volume) or (volume) tries to be converted into (mass)), print error.
        if ((unitConvertFrom.equals("kg") || unitConvertFrom.equals("g")) &&
                (unitConvertTo.equals("l") || unitConvertTo.equals("ml") || unitConvertTo.equals("tsp") ||
                        unitConvertTo.equals("tbsp") || unitConvertTo.equals("cups")) ||

                (unitConvertFrom.equals("l") || unitConvertFrom.equals("ml") || unitConvertFrom.equals("tsp") ||
                        unitConvertFrom.equals("tbsp") || unitConvertFrom.equals("cups")) &&
                        (unitConvertTo.equals("kg") || unitConvertTo.equals("g"))) {
            ConvertToPanel.convertToTextField.setText("Error, mass and volumes cannot be compared.");
            return;
        }

        //ex : 10 Cups into L : 10 * 250 / 1000 = 2.5 L
        //basically I'm converting everything to mL/g and dividing them by mL/g
        Double answer = numberToConvertFrom * conversionMap.get(unitConvertFrom) / conversionMap.get(unitConvertTo);
        ConvertToPanel.convertToTextField.setText(String.valueOf(answer));
        
    }
}