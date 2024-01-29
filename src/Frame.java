import javax.swing.*;
import java.awt.*;
public class Frame extends JFrame {
    //This class is used for the Calculator and the NumberGuessingGame only. The converter as its own classes

    public Frame() {
        setSize(750,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //3 panels (one for the whole calculator (CENTER), and
        // another panel to choose what you'd like to use other than the calculator (NGG and convert) (EAST)
        // and a third panel for the text box (NORTH)))

        setLayout(new BorderLayout());
        //Creating a label for the text box (where the numbers will appear). It'll be at the top of the Frame


        //adding calculator panel to start with and the panel to reach the other panels on the side
        add(new CalculatorPanel(), BorderLayout.CENTER);
        setTitle("Calculator"); //setting the title of the frame as Calculator (temporary title)
        add(new OtherFunctionsPanel(), BorderLayout.EAST);
        add(new TextPanel(), BorderLayout.NORTH);
        setResizable(false);
        setVisible(true);
    }
}
