package com.zsgs.snakegamemenu;

import com.zsgs.SnakeGame;
import com.zsgs.gamedatabase.SnakeGameDB;
import com.zsgs.gameplay.GamePlayView;
import com.zsgs.scanner.ScannerGet;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GameSetUpView {
    private SnakeGame snakeGame = SnakeGame.getInstance();
    private Scanner scanner = ScannerGet.getInstance();
    private GameSetUpModel gameSetUpModel;

    public GameSetUpView(){
        this.gameSetUpModel = new GameSetUpModel(this);
    }

    public void init(){
        showMenu();
    }

    public void showMenu(){
        System.out.println("Welcome to " + snakeGame.getAppName());
        System.out.println("1. Set up the game.");
        System.out.println("2. Start play.");
        System.out.println("3. End game.");
        try {
            System.out.println("Enter your choice:");
            int userChoice = scanner.nextInt();
            scanner.nextLine();
            switch (userChoice) {
                case 1:
                    gameSetUp();
                    break;
                case 2:
                    startPlay();
                    break;
                case 3:
                    endGame();
                    break;
                default:
                    System.out.println("Please enter the right choice.");
            }
        } catch (InputMismatchException exception) {
            System.out.println(exception.getMessage());
            init();
        }
    }

    public void gameSetUp(){
        System.out.println("Welcome to snake game set up");
        System.out.println("Enter the row size of the board:");
        int snakeRow = scanner.nextInt();
        System.out.println("Enter the column size of the board:");
        int snakeColumn = scanner.nextInt();
        gameSetUpModel.setSnakeBoard(snakeRow, snakeColumn);
    }

    public void startPlay(){
        // Implementation for starting the game
    }

    public void endGame(){
        // Implementation for ending the game
    }

    public void gameSetUpSuccess(String message){
        System.out.println(message);
        gameSetUpModel.setFoodForSnake();
    }

    public void gameSetUpFailed(String message){
        System.out.println(message);
        init();
    }

    public void setSnakeGameFood(int currentFoodCount, int totalFoodRequired,int snakeRowsAvailable, int snakeColsAvaialble){
        Random random = new Random();
        int snakeGameRow = random.nextInt(0,snakeRowsAvailable);
        int snakeGameCol = random.nextInt(1,snakeColsAvaialble);
        gameSetUpModel.setSnakeGameDB(snakeGameRow, snakeGameCol);

        System.out.println(  currentFoodCount + " current filled out of " + totalFoodRequired);
    }

    public void gameSetUpOver(){
        System.out.println("The game set up is completed");
        GamePlayView gamePlayView = new GamePlayView();
        gamePlayView.init();
    }
}
