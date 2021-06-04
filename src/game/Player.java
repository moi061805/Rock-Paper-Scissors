package game;

import java.util.Random;

import cont.JOP;
public class Player {
    private String guess;
    private int roundScore;
    private int highScore;
    private int health;
    private int bar; 

    public Player() {
        roundScore = 0;
        highScore = 0;
        health = 3;
    }

    public int getScore() {return roundScore;}
    public int getHighScore() {return highScore;}
    public int gethealth() {return health;}
    public int getBar() { return bar;}
//it increments the round score
    public void increment() { roundScore++; }
//it increments the highscore
    public void incrementHighScore(){ ++highScore; }
//it increments the health
    public void incrementHealth() { ++health;}
//it decreasses the health
    public void decreassHealth() { --health; }
//it makes a critical taking out 2 health
    public void critical() { health -= 2;}
//it increments the critical bar
    public void incrementBar() { bar++; }
//it makes a super critical taking out 3 health
    public void superCritical() { health -= 3; }
//it resets the round score
    public void resetRoundScore(){ roundScore = 0; }
//it resets the bar
    public void resetBar() { bar = 0; }
//it resets the highscore
    public void resetHighScore(){
        highScore = 0;
    }

    Random random = new Random();
    //it inputs the guess of the player
    public void inputGuess(){
        boolean valid = false; 
        while(!valid) {
            guess = JOP.in("Pick rock, paper or scissors.");
            if (!guess.equalsIgnoreCase("rock") && !guess.equalsIgnoreCase("paper") && !guess.equalsIgnoreCase("scissors")) {
                JOP.msg("Enter a valid input.");
            } else {
                valid = true;
            }
        }
    }
    //it inputs the guess of the computer
    public void computerGuess(){
        //0 is rock, 1 is paper, 2 is scissors
        int computerNum = random.nextInt(2);
        if(computerNum == 0){ guess = "rock"; }
        else if(computerNum == 1){ guess = "paper"; }
        else { guess = "scissors"; }
    }
    public String getGuess(){
        return this.guess;
    }

}
