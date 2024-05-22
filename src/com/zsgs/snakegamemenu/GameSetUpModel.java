package com.zsgs.snakegamemenu;

import com.zsgs.gamedatabase.SnakeGameDB;
import com.zsgs.model.SnakeFood;

public class GameSetUpModel {
    private GameSetUpView gameSetUpView;
    private SnakeGameDB snakeGameDB = SnakeGameDB.getInstance();

    public GameSetUpModel(GameSetUpView gameSetUpView){
        this.gameSetUpView = gameSetUpView;
    }

    public void setSnakeBoard(int row, int col){
        if(snakeGameDB.setSnakeGameDB(row,col)){
            gameSetUpView.gameSetUpSuccess("Snake Board game set up success, proceed to add food");
        } else {
            gameSetUpView.gameSetUpFailed("Please enter the board size value greater than 2.");
        }
    }

    public void setFoodForSnake(){
        int snakeGameRow = snakeGameDB.getRow();
        int snakeGameColumn = snakeGameDB.getCol();
        int totalFood = totalFoodSize(snakeGameRow, snakeGameColumn);
        int snakeRowsAvailable = snakeGameDB.getRow();
        int snakeColsAvailable = snakeGameDB.getCol();
        for(int i = 1; i <= totalFood-1; i++){
            gameSetUpView.setSnakeGameFood(i, totalFood,snakeRowsAvailable,snakeColsAvailable);
        }
        gameSetUpView.gameSetUpOver();
    }

    public void setSnakeGameDB(int snakeRow, int snakeCol){
        SnakeFood snakeFood = new SnakeFood();
        snakeFood.setFoodRow(snakeRow);
        snakeFood.setFoodCol(snakeCol);
        snakeGameDB.setSnakeFood(snakeFood);
    }

    public int totalFoodSize(int snakeGameRow, int snakeGameCol){
        return snakeGameRow * snakeGameCol;
    }
}
