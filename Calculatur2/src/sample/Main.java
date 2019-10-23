package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Main extends Application {

    static BorderPane mainLayout;
    public static void main(String[] args){

        launch(args);
    };

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainLayout = new BorderPane();

        Scene scene = new Scene(mainLayout, 400, 450);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);

        HBox Textfield = new HBox();
        TextField input = new TextField();
        Textfield.getChildren().add(input);
        mainLayout.setTop(Textfield);

        input.setPrefHeight(50);
        input.setPrefWidth(400);

        GridPane buttonPane = new GridPane();

        Button[] buttons = {
            new Button("1"), new Button("2"), new Button("3"), new Button("x"),
            new Button("4"), new Button("5"), new Button("6"), new Button("/"),
            new Button("7"), new Button("8"), new Button("9"), new Button("+"),
            new Button("0"), new Button(","), new Button("="), new Button("-")
        };

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < buttons.length; i++){
            buttons[i].setMinHeight(100);
            buttons[i].setMinWidth(100);
            String textValue = buttons[i].getText();


            buttons[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if(textValue != "="){
                        if(textValue.equals(",") || textValue.equals("+") || textValue.equals("-") || textValue.equals("x") || textValue.equals("/") ){
                            if(input.getText().charAt(input.getText().length() - 1) == ',' ||
                                    input.getText().charAt(input.getText().length() - 1) == '+' ||
                                    input.getText().charAt(input.getText().length() - 1) == '-' ||
                                    input.getText().charAt(input.getText().length() - 1) == 'x' ||
                                    input.getText().charAt(input.getText().length() - 1) == '/'){
                            }else{
                                input.setText(input.getText() + textValue);
                            }
                        }else {
                            input.setText(input.getText() + textValue);
                        }
                    }else {
                        switch("="){
                            case "+":
                        }

                        //Räkna ut koden/metoden.

                    }
                }
            });
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

        HBox rowFour = new HBox();
        rowFour.getChildren().addAll(buttons[12], buttons[13], buttons[14], buttons[15]);
        buttonPane.add(rowFour,0,3);

        mainLayout.setCenter(buttonPane);
    }
}
