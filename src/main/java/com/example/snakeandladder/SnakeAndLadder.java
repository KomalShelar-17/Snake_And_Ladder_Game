package com.example.snakeandladder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeAndLadder extends Application {

    public static final int tileSize=60,width=10,height=10;

    public static final int buttonLine=height*tileSize+50, infoLine=buttonLine-30;

    private Pane createContent(){

        Pane root = new Pane();
        root.setPrefSize(width*tileSize,height*tileSize+100);

        for (int i = 0; i <height ; i++) {
            for (int j = 0; j < width; j++) {
                Tile tile = new Tile(tileSize);
                tile.setTranslateX(j*tileSize);
                tile.setTranslateY(i*tileSize);
                root.getChildren().add(tile);
            }
        }
        Image img = new Image("D:\\komal Java\\SnakeAndLadder\\src\\main\\snakes-ladders-board.jpg");
        ImageView board = new ImageView();
        board.setImage(img);
        board.setFitWidth(width*tileSize);
        board.setFitHeight(height*tileSize);


        // Button

        Button playerOneButton = new Button("Player One");
        Button playerTwoButton = new Button("Player Two");
        Button startButton = new Button("Start");

        playerOneButton.setTranslateX(50);
        playerOneButton.setTranslateY(buttonLine);
        playerTwoButton.setTranslateX(450);
        playerTwoButton.setTranslateY(buttonLine);
        startButton.setTranslateX(280);
        startButton.setTranslateY(buttonLine);

        //Label

        Label playerOneLabel = new Label("My turn");
        Label playerTwoLabel = new Label("Your turn");
        Label startLabel = new Label("Dice");

        playerOneLabel.setTranslateX(60);
        playerOneLabel.setTranslateY(infoLine);
        playerTwoLabel.setTranslateX(460);
        playerTwoLabel.setTranslateY(infoLine);
        startLabel.setTranslateX(290);
        startLabel.setTranslateY(infoLine);

        root.getChildren().addAll(board,
                playerOneButton,playerTwoButton,startButton,
                playerOneLabel,playerTwoLabel,startLabel);

        return root;
    }
    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = new Scene(createContent());
        stage.setTitle("Snake and Ladder");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}