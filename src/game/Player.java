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

    public void increment() { roundScore++; }

    public void incrementHighScore(){ ++highScore; }
    
    public void incrementHealth() { ++health;}
    
    public void decreassHealth() { --health; }
    
    public void critical() { health -= 2;}
    
    public void incrementBar() { bar++; }
    
    public void superCritical() { health -= 3; }
    
    //public int setHighScore() { return ++highScore; }

    public void resetRoundScore(){ roundScore = 0; }
    
    public void resetBar() { bar = 0; }

    public void resetHighScore(){
        highScore = 0;
    }

    Random random = new Random();
    public void inputGuess(){
        boolean valid = false; //Variable that becomes true if the string input is correct
        while(!valid) {
            guess = JOP.in("Pick rock, paper or scissors.");
            if (!guess.equalsIgnoreCase("rock") && !guess.equalsIgnoreCase("paper") && !guess.equalsIgnoreCase("scissors")) {
                JOP.msg("Enter a valid input.");
            } else {
                valid = true;
            }
        }
    }
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