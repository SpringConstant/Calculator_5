package numberGuessingGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberGuessingGameButton extends JButton implements ActionListener {

    static final int fiftyPercentOf100 = (int) Math.round((0.50 * 100));
    static final int fortyPercentOf100 = (int) Math.round((0.40 * 100));
    static final int thirtyPercentOf100 = (int) Math.round((0.30 * 100));
    static final int twentyPercentOf100 = (int) Math.round((0.20 * 100));
    static final int tenPercentOf100 = (int) Math.round((0.10 * 100));
    static final int fivePercentOf100 = (int) Math.round((0.05 * 100));
    static final int twoPercentOf100 = (int) Math.round((0.02 * 100));






    public NumberGuessingGameButton(String text) { //is called everytime NumberGuessingGamePanel makes a new button
        setText(text);
        setSize(10, 5);
        setFocusable(false);
        addActionListener(this);

        if (text.isBlank()) {
            setVisible(false);
        }
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        String labelText = NumberGuessingGameTextPanel.label.getText(); //getText of the button and use if statements to tell what each buttons does

        Pattern pattern = Pattern.compile("[a-z]");
        Matcher matcher = pattern.matcher(labelText);
        boolean matchFound = matcher.find();
        if (matchFound) {
            NumberGuessingGameTextPanel.label.setText("");
        }

        //this for loop makes the button print whatever number on the label
        for (int i = 0; i < 10; i++) {
            if (Objects.equals(getText(), String.valueOf(i))) {
                NumberGuessingGameTextPanel.label.setText(NumberGuessingGameTextPanel.label.getText() + i);
            }
        }

        switch (getText()){
            case "Enter" -> {
                //getting the number that the user has input, and
                int userInput = Integer.parseInt(NumberGuessingGameTextPanel.label.getText());
                NumberGuessingGameTextPanel.label.setText("");


                //difference between the userInput and numberToBeGuessed
                int diff = (userInput - (NumberGuessingGamePanel.numberToBeGuessed));
                if (diff == 0) {
                    NumberGuessingGameTextPanel.label.setText("Congratulations! You've guessed the number!");
                }

                else if (userInput > 100 || userInput < 0){
                    NumberGuessingGameTextPanel.label.setText("Remember, you have to guess a number between 0 and 100!");
                }

                else if (diff > fiftyPercentOf100){
                    NumberGuessingGameTextPanel.label.setText("Your number is waaaayyy too " + BigSmallSign(diff) + "! :P Try Again");
                }

                else if (Math.abs(diff) > fortyPercentOf100){
                    NumberGuessingGameTextPanel.label.setText("Your number is too " + BigSmallSign(diff) + "! Try Again Lol");
                }

                else if (Math.abs(diff) > thirtyPercentOf100){
                    NumberGuessingGameTextPanel.label.setText("Still pretty far. Your number is unfortunately a bit too " + BigSmallSign(diff) + " :( Try Again");
                }

                else if (Math.abs(diff) > twentyPercentOf100){
                    NumberGuessingGameTextPanel.label.setText("OOF IT'S GETTING HOT. Try again for a number that is " + DiffSign(diff) + ". Try again. You got this.");
                }

                else if (Math.abs(diff) > tenPercentOf100){
                    NumberGuessingGameTextPanel.label.setText("nope, not it lol. Try for a " + DiffSign(diff) + " number");
                }

                else if (Math.abs(diff) > fivePercentOf100){
                    NumberGuessingGameTextPanel.label.setText("You're so close!!!! Too bad your answer is a bit too " + BigSmallSign(diff) + ".");
                }

                else if (Math.abs(diff) > twoPercentOf100){
                    NumberGuessingGameTextPanel.label.setText("YOU'RE GETTING THERE. Try again for a " + DiffSign(diff) + " number. Good luck mate");
                }

                else if (Math.abs(diff) <= twoPercentOf100){
                    NumberGuessingGameTextPanel.label.setText("UGH YOU'RE ALMOST TO THE FINISHED LINE!!!! I am not giving any more hints anymore");
                }
            }



            case "Reset" -> {
                System.out.println("reset");
                reset();
            }

            case "Delete" -> {
                NumberGuessingGameTextPanel.label.setText(NumberGuessingGameTextPanel.label.getText().substring(0, NumberGuessingGameTextPanel.label.getText().length()-1));
            }
        }



    } //end of override
    public static String BigSmallSign(int diff){  //big/small
        if (diff > 0){//userInput is greater that the numberToBeGuessed
            return "big";
        }
        else{
            return "small";
        }
    }
    public static String DiffSign(int diff) {//bigger/smaller
        if (diff > 0) {//userInput is greater that the numberToBeGuessed
            return "smaller";
        } else {
            return "bigger";
        }
    }
    public void reset(){
        NumberGuessingGamePanel.numberToBeGuessed = (int) (Math.random() * 101); //numberToBeGuessed is an instance variable
        NumberGuessingGameTextPanel.label.setText("Guess a number between 0 and 100");
    }
}
