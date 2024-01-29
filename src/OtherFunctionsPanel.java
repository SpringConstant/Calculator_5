import javax.swing.*;
import java.awt.*;

public class OtherFunctionsPanel extends JPanel {

    public OtherFunctionsPanel(){

        setPreferredSize(new Dimension(200,300));
        setLayout(new GridLayout(3,1,5,5));
        setBorder(BorderFactory.createEmptyBorder(0,15,1,2));
        add(new OtherFunctionsButton("Calculator")); //add one button (Converter) to the panel of the class OtherFunctions
        add(new OtherFunctionsButton("Converter")); //add second button (NGG) to the panel of the class OtherFunctions
        add(new OtherFunctionsButton("Number Guessing Game")); //add third button (Calculator) to the panel of the class OtherFunctions
    }
}