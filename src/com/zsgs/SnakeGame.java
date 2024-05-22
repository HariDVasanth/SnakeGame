package com.zsgs;

import com.zsgs.snakegamemenu.GameSetUpView;

public class SnakeGame {
    private String appName = "SnakeGame";
    private String appVersion = "0.0.1";
    private static SnakeGame snakeGame;

    public String getAppName() {
        return appName;
    }



    public String getAppVersion() {
        return appVersion;
    }


    public static SnakeGame getInstance(){
        if(snakeGame ==  null){
            snakeGame = new SnakeGame();
        }
        return snakeGame;
    }

    public static void main(String[] args) {
        GameSetUpView menuView = new GameSetUpView();
        menuView.init();
    }
}
