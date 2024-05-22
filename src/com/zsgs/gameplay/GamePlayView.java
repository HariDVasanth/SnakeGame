package com.zsgs.gameplay;

import com.zsgs.SnakeGame;
import com.zsgs.scanner.ScannerGet;

import java.util.Scanner;

public class GamePlayView {
    private GamePlayModel gamePlayModel;
    Scanner scanner = ScannerGet.getInstance();
    public GamePlayView(){
        gamePlayModel = new GamePlayModel(this);
    }

    public void init(){
        System.out.println(SnakeGame.getInstance().getAppName());
        startGame();
    }
    public void startGame(){
        do{
            gamePlayModel.getSnakeGame();
            gamePlayModel.snakeAddFood();
            System.out.println("Where do you want to move?");
            System.out.println("1. Up");
            System.out.println("2. Down");
            System.out.println("3. Left");
            System.out.println("4. Right");

            int userChoice = scanner.nextInt();

            switch (userChoice){
                case 1:
                    gamePlayModel.snakeMovement(SnakeMovements.UP);
                    break;
                case 2:
                    gamePlayModel.snakeMovement(SnakeMovements.DOWN);
                    break;
                case 3:
                    gamePlayModel.snakeMovement(SnakeMovements.LEFT);
                    break;
                case 4:
                    gamePlayModel.snakeMovement(SnakeMovements.RIGHT);
                    break;
                default:
                    System.out.println("Please pick the right option");
            }

        }while (!gamePlayModel.snakeGameStatus());
    }
    public void displaySnakeGame(char[][] snakeBoard){
        for(int i=0;i<snakeBoard.length;i++){
            for(int j=0;j<snakeBoard[i].length;j++){
                System.out.print(snakeBoard[i][j]+" ");
            }
            System.out.println();
        }
    }
}
