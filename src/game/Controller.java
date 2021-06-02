package game;

/*  Program structure: playerOrComputer boolean variable (in main class, for details check comment). running boolean. Player versus player main method. Player versus computer main method.
Get player1 input method. Get player2 input. Get computer move. */

import java.awt.*;

import javax.swing.JOptionPane;

import cont.JOP;

public class Controller {
boolean main = true;
boolean running = true;
Player Player1 = new Player();
Player Player2 = new Player();
Player Computer = new Player();


public Controller(){
    JOP.msg("NEW UPDATE" + "\n Roack, Paper, Scissors 2.0"
 + "\n New feature in Player vs Computer"
 + "\n Now Player and Computer have a health bar if your health bar reaches 0 you lose and if the bar of the computer reaches 0 you win"
 + "\n Every time you win a game the openent loses 1 point of health and if you lose you lose 1 point of health"
 + "\n There is also a 30% of a critical that deals 2 damage"
 + "\n The player also has a bar that increases every time you get hit and if it reaches 3 the computer will recive 3 damage");
	while(main){
    	setGame();
    	if(Player1.getBar() == 3) {
    		JOP.msg("Your bar is complete \n Computer -3");
    		Computer.superCritical();
    		Player1.resetBar();
    	}
    	if(Player1.gethealth() == 0 || Player1.gethealth()<0) {
    		JOP.msg("You have loss all your health");
    		main = false;
    	}
    	if(Computer.gethealth() == 0 || Computer.gethealth()<0) {
    		JOP.msg("You have beat the computer");
    		main = false;
    	}
    }
        
}
public void playerVsPlayer(){
    while(running){
        JOP.msg("The score is: " + Player1.getScore() + " for player one \n the score is: " + Player2.getScore() + " for player two.");
        JOP.msg("It's player one's turn!");
        Player1.inputGuess();
        JOP.msg("It's player two's turn!");
        Player2.inputGuess();
        getWinnerPVP();
    }
    running = true;
}
public void playerVsComputer(){
    while(running){
        JOP.msg("The score is: " + Player1.getScore() + " for player one \n the score is: " + Computer.getScore() + " for computer.");
        JOP.msg("It's your turn player one!");
        Player1.inputGuess();
        JOP.msg("It's the computer's turn!");
        Computer.computerGuess();
        getWinnerPVC();
    }
    running = true;
}

public void setGame() {
	String playerOrComputer = JOP.in("Writer 'p' to play against another player or write 'c' to play against the computer. \n The current high scores are: \n Player 1: " + Player1.getHighScore() + "\n Player 2: " + Player2.getHighScore() + "\n Computer: " + Computer.getHighScore() + "\n Player health: " + Player1.gethealth() + "\n Computer health: " + Computer.gethealth() + "\n Player Bar: " + Player1.getBar());

    if(playerOrComputer.equalsIgnoreCase("p")){
    	
        playerVsPlayer();
    } 
    if(playerOrComputer.equalsIgnoreCase("c")){
    	
        playerVsComputer();
    }
}

public void getWinnerPVP(){
	if(Player1.getGuess().equalsIgnoreCase("rock") && Player2.getGuess().equalsIgnoreCase("paper")){
        Player2.increment();
        JOP.msg("Player choose: " + Player1.getGuess() + " Player two choose: " + Player2.getGuess() + ". Player two wins the round!");
    } else if(Player1.getGuess().equalsIgnoreCase("paper") && Player2.getGuess().equalsIgnoreCase("scissors")){
        Player2.increment();
        JOP.msg("Player choose: " + Player1.getGuess() + " Player two choose: " + Player2.getGuess() + ". Player two wins the round!");
    } else if(Player1.getGuess().equalsIgnoreCase("scissors") && Player2.getGuess().equalsIgnoreCase("rock")){
        Player2.increment();
        JOP.msg("Player choose: " + Player1.getGuess() + " Player two choose: " + Player2.getGuess() + ". Player two wins the round!");
    } else if(Player1.getGuess().equalsIgnoreCase("paper") && Player2.getGuess().equalsIgnoreCase("rock")){
        Player1.increment();
        JOP.msg("Player choose: " + Player1.getGuess() + " Player two choose: " + Player2.getGuess() + ". Player one wins the round!");
    } else if(Player1.getGuess().equalsIgnoreCase("scissors") && Player2.getGuess().equalsIgnoreCase("paper")){
        Player1.increment();
        JOP.msg("Player choose: " + Player1.getGuess() + " Player two choose: " + Player2.getGuess() + ". Player one wins the round!");
    } else if(Player1.getGuess().equalsIgnoreCase("rock") && Player2.getGuess().equalsIgnoreCase("scissors")){
        Player1.increment();
        JOP.msg("Player choose: " + Player1.getGuess() + " Player two choose: " + Player2.getGuess() + ". Player one wins the round!");
    } else{
        JOP.msg("It's a tie!.");
    }
    if(Player1.getScore() >= 2){
        Player2.resetHighScore();
        Player2.resetRoundScore();
        Player1.resetRoundScore();
        Player1.incrementHighScore();
        JOP.msg("Player one wins the game!");
        
        running = false;
    }
    if(Player2.getScore() >= 2){
        Player1.resetHighScore();
        Player1.resetRoundScore();
        Player2.resetRoundScore();
        Player2.incrementHighScore();
        JOP.msg("Player two wins the game!");
        running = false;
    }
}
public void getWinnerPVC(){
    if(Player1.getGuess().equalsIgnoreCase("rock") && Computer.getGuess().equalsIgnoreCase("paper")){
        Computer.increment();
        JOP.msg("Player choose: " + Player1.getGuess() + " Computer choose: " + Computer.getGuess() + ". Computer wins the round!");
    } else if(Player1.getGuess().equalsIgnoreCase("paper") && Computer.getGuess().equalsIgnoreCase("scissors")){
        Computer.increment();
        JOP.msg("Player choose: " + Player1.getGuess() + " Computer choose: " + Computer.getGuess() + ". Computer wins the round!");
    } else if(Player1.getGuess().equalsIgnoreCase("scissors") && Computer.getGuess().equalsIgnoreCase("rock")){
        Computer.increment();
        JOP.msg("Player choose: " + Player1.getGuess() + " Computer choose: " + Computer.getGuess() + ". Computer wins the round!");
    } else if(Player1.getGuess().equalsIgnoreCase("paper") && Computer.getGuess().equalsIgnoreCase("rock")){
        Player1.increment();
        JOP.msg("Player choose: " + Player1.getGuess() + " Computer choose: " + Computer.getGuess() + ". Player one wins the round!");
    } else if(Player1.getGuess().equalsIgnoreCase("scissors") && Computer.getGuess().equalsIgnoreCase("paper")){
        Player1.increment();
        JOP.msg("Player choose: " + Player1.getGuess() + " Computer choose: " + Computer.getGuess() + ". Player one wins the round!");
    } else if(Player1.getGuess().equalsIgnoreCase("rock") && Computer.getGuess().equalsIgnoreCase("scissors")){
        Player1.increment();
        JOP.msg("Player choose: " + Player1.getGuess() + " Computer choose: " + Computer.getGuess() + ". Player one wins the round!");
    } else if(Player1.getGuess().equalsIgnoreCase(Computer.getGuess())){
        JOP.msg("It's a tie!.");
    }
    if(Computer.getScore() >= 2){
        Player1.resetHighScore();
        Player1.resetRoundScore();
        Computer.resetRoundScore();
        Computer.incrementHighScore();
        Computer.incrementHealth();
        if(Math.random() < 0.3) {
        	Player1.critical();
        	JOP.msg("Critical!!! \n ouch.. that should hurt");
        }
        else {
        	Player1.decreassHealth();
        }
        Player1.incrementBar();
        JOP.msg("Computer wins the game!");
        running = false;
    }
    if(Player1.getScore() >= 2){
        Computer.resetHighScore();
        Computer.resetRoundScore();
        Player1.resetRoundScore();
        Player1.incrementHighScore();
        Player1.incrementHealth();
        if(Math.random() < 0.3) {
        	Computer.critical();
        	JOP.msg("You have landed a Critical!!! \n Good Job");
        }
        else {
        	Computer.decreassHealth();
        }
        JOP.msg("Player one wins the game!");
        running = false;
    }
}
}