package com.example.tictactoe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private Scene startMenuScene;
    private Scene gameScene;
    private GameController gameController;

    @Override
    public void start(Stage stage) {
        // Initialize the start menu
        createStartMenu(stage);

        // Initialize the main game scene with GameController
        gameController = new GameController();
        gameScene = new Scene(gameController.getBoardView(), 300, 300);

        // Set up the stage with the start menu initially
        stage.setScene(startMenuScene);
        stage.setTitle("Tic-Tac-Toe Menu");
        stage.show();
    }