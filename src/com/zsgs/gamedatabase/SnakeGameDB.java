package com.zsgs.gamedatabase;

import com.zsgs.model.SnakeFood;
import com.zsgs.model.SnakeHead;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SnakeGameDB {
    private static SnakeGameDB snakeGameDB;
    private int row;
    private int col;
    private char[][] snakeBoard;
    Queue<SnakeFood> snakeFoods = new LinkedList<>();
    Stack<SnakeHead> snakeHeads = new Stack<>();
    private int moves;
    public static SnakeGameDB getInstance(){
        if(snakeGameDB == null){
            snakeGameDB = new SnakeGameDB();
        }
        return snakeGameDB;
    }
    public boolean setSnakeGameDB(int row,int col){
        this.row = row;
        this.col = col;
        SnakeHead snakeHead = new SnakeHead();
        snakeBoard = new char[this.row][this.col];
        if(snakeBoard.length>1 && snakeBoard[0].length>0){
            snakeBoard[0][0] = 'S';
            snakeHead.setSnakeHeadRow(0);
            snakeHead.setSnakeHeadCol(0);
            setSnakeHeads(snakeHead);
            

            return true;
        }
        return false;
    }
    public void addFood(){
        SnakeFood snakeFood;
        snakeFood = snakeFoods.poll();
        assert snakeFood != null;
        int currRow = snakeFood.getFoodRow();
        int currCol = snakeFood.getFoodCol();
        snakeBoard[currRow][currCol] = 'F';
    }

    public char[][] getSnakeBoard() {
        return snakeBoard;
    }

    public Queue<SnakeFood> getSnakeFoods() {
        return snakeFoods;
    }
    public void setSnakeFood(SnakeFood snakeFood){
        snakeFoods.add(snakeFood);
    }
    public boolean snakeGameStatus(){
        return snakeFoods.isEmpty();
    }

    public Stack<SnakeHead> getSnakeHeads() {
        return snakeHeads;
    }


    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

    public void setSnakeHeads(SnakeHead snakeHead) {
        snakeHeads.push(snakeHead);
    }
    public void snakeGameMove(int snakeGameRow, int snakeGameCol){
        if(snakeBoard[snakeGameRow][snakeGameCol] == 'F') {

        }
        else {
            int currSnakeRow = snakeHeads.peek().getSnakeHeadRow();

        }
        setSnakeFood();
    }
    public void setSnakeFood(){
        assert snakeFoods.peek() != null;
        int foodRow = snakeFoods.peek().getFoodRow();
        assert snakeFoods.peek() != null;
        int foodCol = snakeFoods.peek().getFoodRow();
        if(checkForSnake(foodRow,foodCol)){
            snakeBoard[foodRow][foodCol] = 'F';
        }
        else{
            newFood();
        }
    }
    public void newFood(){
        int foodRow = snakeFoods.remove().getFoodRow();
        int foodCol = snakeFoods.remove().getFoodCol();

        SnakeFood snakeFood = new SnakeFood();
        snakeFood.setFoodRow(foodRow);
        snakeFood.setFoodCol(foodCol);

        snakeFoods.add(snakeFood);
        setSnakeFood();

    }
    public boolean checkForSnake(int snakeRow,int snakeCol){
        if(snakeBoard[snakeRow][snakeCol]!= 'S' || snakeBoard[snakeRow][snakeCol]!= 'F' ){
            return true;
        }
        return false;
    }



    public void snakeGameOver(){
        snakeHeads.clear();
    }

    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }


}
