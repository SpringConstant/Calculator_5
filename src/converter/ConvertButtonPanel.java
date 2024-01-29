package converter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;

public class ConvertButtonPanel extends JPanel implements ActionListener {

    public ConvertButtonPanel(){
        JButton button = new JButton("Convert");
        button.setPreferredSize(new Dimension(300,100));
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setFocusable(false);
        button.addActionListener(this);
        add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //number of milliliter in every one of those units
        HashMap<String, Double> usedMap = new HashMap<String, Double>();
        usedMap.put("g", 1.0); //g is the key, and 1.0 is the value
        usedMap.put("kg", 1000.0);
        usedMap.put("ml", 1.0); //ml is the key, and 1.0 is the value
        usedMap.put("l", 1000.0);
        usedMap.put("tsp", 5.0);
        usedMap.put("tbsp", 15.0);
        usedMap.put("cups", 250.0);

        double numberToConvertFrom = 0;

        try{
            numberToConvertFrom = Double.parseDouble(ConvertFromPanel.convertFromTextField.getText());
        } catch (Exception exception){
            ConvertToPanel.convertToTextField.setText("Numbers only!");
            return;
        }

        //System.out.println(numberToConvertFrom);
        String unitConvertFrom = ((String) ConvertFromPanel.comboBoxConvertFrom.getSelectedItem()).toLowerCase();
        String unitConvertTo = ((String) ConvertToPanel.comboBoxConvertTo.getSelectedItem()).toLowerCase();

        //if ((mass) tries to be converted into (volume)
        //or (volume) tries to be converted into (mass))
        //print error.
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
        Double answer = numberToConvertFrom * usedMap.get(unitConvertFrom) / usedMap.get(unitConvertTo);
        ConvertToPanel.convertToTextField.setText(String.valueOf(answer));
        
    }
}