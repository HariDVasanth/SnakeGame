package com.zsgs.gameplay;


import com.zsgs.gamedatabase.SnakeGameDB;
import com.zsgs.model.SnakeHead;


import java.util.Stack;

public class GamePlayModel {
    private GamePlayView gamePlayView;
    private final SnakeGameDB snakeGameDB = SnakeGameDB.getInstance();
    public GamePlayModel(GamePlayView gamePlayView){
        this.gamePlayView=gamePlayView;
    }
    public void getSnakeGame(){
        gamePlayView = new GamePlayView();
        char[][] snakeBoard = snakeGameDB.getSnakeBoard();
        for(int i=0;i<snakeBoard.length;i++){
            for (int j=0;j<snakeBoard[i].length;j++){
                if(snakeBoard[i][j]=='\u0000'){
                    snakeBoard[i][j] = '_';
                }
            }
        }
        gamePlayView.displaySnakeGame(snakeBoard);
    }
    public void snakeAddFood(){
        snakeGameDB.addFood();
    }

    public boolean snakeGameStatus(){
        return snakeGameDB.snakeGameStatus();
    }


    public void snakeMovement(SnakeMovements direction) {
        int row = snakeGameDB.getRow();
        int col = snakeGameDB.getCol();

        Stack<SnakeHead> snakeHeadStack = snakeGameDB.getSnakeHeads();
        SnakeHead currentHead = snakeHeadStack.peek();
        int currentRow = currentHead.getSnakeHeadRow();
        int currentCol = currentHead.getSnakeHeadCol();

        int newRow = currentRow;
        int newCol = currentCol;

        switch (direction) {
            case UP -> newRow = currentRow - 1;
            case DOWN -> newRow = currentRow + 1;
            case LEFT -> newCol = currentCol - 1;
            case RIGHT -> newCol = currentCol + 1;
        }
        if (newRow < 0 || newRow >= row || newCol < 0 || newCol >= col || containsSnakeHead(newRow, newCol)) {
            snakeGameDB.snakeGameOver();
        } else {
            snakeGameDB.snakeGameMove(newRow, newCol);
        }
    }

    private boolean containsSnakeHead(int row, int col) {
        for (SnakeHead head : snakeGameDB.getSnakeHeads()) {
            if (head.getSnakeHeadRow() == row && head.getSnakeHeadCol() == col) {
                return true;
            }
        }
        return false;
    }

    public void gameOver(){

    }


}
