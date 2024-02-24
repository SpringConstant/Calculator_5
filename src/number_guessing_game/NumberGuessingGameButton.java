package number_guessing_game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberGuessingGameButton extends JButton implements ActionListener {

    //these variables are used to see the level of difference between the answer and the user's input
    //that way, I can let the user know how close or how far he is from getting to the right answer
    static final int fiftyPercentOf100 = (int) Math.round((0.50 * 100));
    static final int fortyPercentOf100 = (int) Math.round((0.40 * 100));
    static final int thirtyPercentOf100 = (int) Math.round((0.30 * 100));
    static final int twentyPercentOf100 = (int) Math.round((0.20 * 100));
    static final int tenPercentOf100 = (int) Math.round((0.10 * 100));
    static final int fivePercentOf100 = (int) Math.round((0.05 * 100));
    static final int twoPercentOf100 = (int) Math.round((0.02 * 100));



    //is called everytime NumberGuessingGamePanel makes a new button
    public NumberGuessingGameButton(String text) {
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
        //get Text of the button and use if statements to tell what each button does
        String labelText = NumberGuessingGameTextPanel.label.getText();


        //check if there's text in the textlabel when pressing a button (if there is some text, then the label will be empty)
        Pattern pattern = Pattern.compile("[a-z]");
        Matcher matcher = pattern.matcher(labelText);
        boolean matchFound = matcher.find();
        if (matchFound) {
            NumberGuessingGameTextPanel.label.setText("");
        }


        //gets label text again
        labelText = NumberGuessingGameTextPanel.label.getText();


        //this for loop makes the button print whatever number is on the label (while avoiding that there are buttons with letters)
        for (int i = 0; i < 10; i++) {
            if (Objects.equals(getText(), String.valueOf(i))) {
                NumberGuessingGameTextPanel.label.setText(labelText + i);
            }
        }


        switch (getText()){
            case "Enter" -> {
                //if labelText is Empty, the given message will show
                if (labelText.isEmpty()){
                    NumberGuessingGameTextPanel.label.setText("Remember, you have to guess a number between 0 and 100!");
                    break;
                }

                //erase the original message
                NumberGuessingGameTextPanel.label.setText("");

                //difference between the userInput and numberToBeGuessed
                int userInput = Integer.parseInt(labelText);
                int diff = (userInput - (NumberGuessingGamePanel.numberToBeGuessed));
                if (diff == 0) {
                    NumberGuessingGameTextPanel.label.setText("Congratulations! You've guessed the number!");
                }


                else if (userInput > 100 || userInput < 0){
                    NumberGuessingGameTextPanel.label.setText("Remember, you have to guess a number between 0 and 100!");
                }

                else if (Math.abs(diff) > fiftyPercentOf100){
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
                reset();
            }


            case "Delete" -> {
                if (labelText.isEmpty()){
                    //do nothing lol
                    break;
                }
                NumberGuessingGameTextPanel.label.setText(labelText.substring(0, labelText.length() - 1));
            }
        }
    } //end of override


    //prints big or small
    public static String BigSmallSign(int diff){
        //userInput is greater that the numberToBeGuessed
        if (diff > 0){
            return "big";
        }
        else{
            return "small";
        }
    }


    //prints bigger/smaller
    public static String DiffSign(int diff) {
        //userInput is greater that the numberToBeGuessed
        if (diff > 0) {
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