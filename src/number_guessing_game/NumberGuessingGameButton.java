package number_guessing_game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static number_guessing_game.NumberGuessingGamePanel.RANGE;

public class NumberGuessingGameButton extends JButton implements ActionListener {

    //these variables are used to see the level of difference between the answer and the user's input
    //that way, I can let the user know how close or how far he is from getting to the right answer
    static final int fiftyPercentOfRange = (int) Math.round((0.50 * RANGE));
    static final int fortyPercentOfRange = (int) Math.round((0.40 * RANGE));
    static final int thirtyPercentOfRange = (int) Math.round((0.30 * RANGE));
    static final int twentyPercentOfRange = (int) Math.round((0.20 * RANGE));
    static final int tenPercentOfRange = (int) Math.round((0.10 * RANGE));
    static final int fivePercentOfRange = (int) Math.round((0.05 * RANGE));
    static final int twoPercentOfRange = (int) Math.round((0.02 * RANGE));



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


        //check if there's text in the text label when pressing a button (if there is some text, then the label will be empty)
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
            case "Enter" -> enter(labelText);

            case "Reset" -> reset();

            case "Delete" -> {
                if (labelText.isEmpty()){
                    //do nothing lol
                    break;
                }
                NumberGuessingGameTextPanel.label.setText(labelText.substring(0, labelText.length() - 1));
            }
        }
    } //end of override

    private static void enter(String labelText) {
        //if labelText is Empty, the given message will show
        if (labelText.isEmpty()){
            NumberGuessingGameTextPanel.label.setText("Remember, you have to guess a number between 0 and " + RANGE + "!");
            return;
        }

        //erase the original message
        NumberGuessingGameTextPanel.label.setText("");

        //difference between the userInput and numberToBeGuessed
        int userInput = Integer.parseInt(labelText);
        int diff = (userInput - (NumberGuessingGamePanel.numberToBeGuessed));

        if (diff == 0) {
            NumberGuessingGameTextPanel.label.setText("Congratulations! You've guessed the number!");
        }

        else if (userInput > RANGE || userInput < 0){
            NumberGuessingGameTextPanel.label.setText("Remember, you have to guess a number between 0 and " + RANGE + "!");
        }

        else {
            int absoluteDiff = Math.abs(diff);
            if (absoluteDiff > fiftyPercentOfRange){
                NumberGuessingGameTextPanel.label.setText("Your number is waaaayyy too " + bigSmallSign(diff) + "! :P Try Again");
            }

            else if (absoluteDiff > fortyPercentOfRange){
                NumberGuessingGameTextPanel.label.setText("Your number is too " + bigSmallSign(diff) + "! Try Again Lol");
            }

            else if (absoluteDiff > thirtyPercentOfRange){
                NumberGuessingGameTextPanel.label.setText("Still pretty far. Your number is unfortunately a bit too " + bigSmallSign(diff) + " :( Try Again");
            }

            else if (absoluteDiff > twentyPercentOfRange){
                NumberGuessingGameTextPanel.label.setText("OOF IT'S GETTING HOT. Try again for a number that is " + diffSign(diff) + ". Try again. You got this.");
            }

            else if (absoluteDiff > tenPercentOfRange){
                NumberGuessingGameTextPanel.label.setText("nope, not it lol. Try for a " + diffSign(diff) + " number");
            }

            else if (absoluteDiff > fivePercentOfRange){
                NumberGuessingGameTextPanel.label.setText("You're so close!!!! Too bad your answer is a bit too " + bigSmallSign(diff) + ".");
            }

            else if (absoluteDiff > twoPercentOfRange){
                NumberGuessingGameTextPanel.label.setText("YOU'RE GETTING THERE. Try again for a " + diffSign(diff) + " number. Good luck mate");
            }

            else if (absoluteDiff == 1){
                NumberGuessingGameTextPanel.label.setText("UGH YOU'RE ALMOST TO THE FINISHED LINE!!!! I am not giving any more hints anymore");
            }

            else {
                NumberGuessingGameTextPanel.label.setText("Extremely extremely close. Go for a " + diffSign(diff) + " number. Good Luck!");
            }
        }
    }


    //prints big or small
    public static String bigSmallSign(int diff){
        //userInput is greater that the numberToBeGuessed
        if (diff > 0){
            return "big";
        }
        else{
            return "small";
        }
    }


    //prints bigger/smaller
    public static String diffSign(int diff) {
        //userInput is greater that the numberToBeGuessed
        if (diff > 0) {
            return "smaller";
        } else {
            return "bigger";
        }
    }


    public void reset(){
        NumberGuessingGamePanel.numberToBeGuessed = new Random().nextInt(RANGE); //numberToBeGuessed is an instance variable
        NumberGuessingGameTextPanel.label.setText("Guess a number between 0 and " + RANGE + "!");
    }
}