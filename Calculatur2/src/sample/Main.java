package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
    static BorderPane mainLayout;
    public static void main(String[] args){
        launch(args);
    };

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainLayout = new BorderPane();

        Scene scene = new Scene(mainLayout, 400, 500);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();

        HBox Textfield = new HBox();
        TextField input = new TextField();
        Textfield.getChildren().add(input);
        mainLayout.setTop(Textfield);

        input.setPrefHeight(50);
        input.setPrefWidth(400);

        GridPane buttonPane = new GridPane();

        Button[] buttons = {
            new Button("1"), new Button("2"), new Button("3"), new Button("+"),
            new Button("4"), new Button("5"), new Button("6"), new Button("-"),
            new Button("7"), new Button("8"), new Button("9"), new Button("=")
        };

        for (int i = 0; i < buttons.length; i++){
            buttons[i].setMinHeight(100);
            buttons[i].setMinWidth(100);
        };

        HBox rowOne = new HBox();
        rowOne.getChildren().addAll(buttons[0], buttons[1], buttons[2], buttons[3]);
        buttonPane.add(rowOne, 0,0);

        HBox rowTwo = new HBox();
        rowTwo.getChildren().addAll(buttons[4], buttons[5], buttons[6], buttons[7]);
        buttonPane.add(rowTwo, 0,1);

        HBox rowThree = new HBox();
        rowThree.getChildren().addAll(buttons[8], buttons[9], buttons[10], buttons [11]);
        buttonPane.add(rowThree, 0,2);

        mainLayout.setCenter(buttonPane);
    }
}
