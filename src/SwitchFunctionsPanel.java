import javax.swing.*;
import java.awt.*;
public class SwitchFunctionsPanel extends JPanel {

    public SwitchFunctionsPanel(Frame frame){

        setPreferredSize(new Dimension(200,300));
        setLayout(new GridLayout(3,1,5,5));
        setBorder(BorderFactory.createEmptyBorder(0,15,1,2));

        add(new SwitchFunctionsButton(frame, "Calculator")); //add one button (Converter) to the panel of the class OtherFunctions
        add(new SwitchFunctionsButton(frame,"Converter")); //add second button (NGG) to the panel of the class OtherFunctions
        add(new SwitchFunctionsButton(frame, "Number Guessing Game")); //add third button (Calculator) to the panel of the class OtherFunctions
    }
}