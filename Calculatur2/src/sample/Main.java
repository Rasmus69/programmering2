package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    BorderPane mainLayout;
    HBox inputLayout;
    TextField input;
    Button[] buttons;
    HBox inputrowOne;
    HBox inputrowTwo;
    HBox inputrowThree;
    HBox inputrowFour;
    HBox inputrowFive;

    public static void main(String[] args){

        launch(args);
    };

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainLayout = new BorderPane();

        Scene scene = new Scene(mainLayout, 400, 550);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);

        inputLayout = new HBox();
        input = new TextField();
        inputLayout.getChildren().add(input);
        mainLayout.setTop(inputLayout);
        input.setEditable(false);

        input.setPrefHeight(50);
        input.setPrefWidth(400);

        createButtons();

        setupButtons();

        setupStyle();

    }


    private void createButtons() {
        buttons = new Button[]{
                new Button("AC"), new Button(","), new Button("x"),
                new Button("1"), new Button("2"), new Button("3"), new Button("/"),
                new Button("4"), new Button("5"), new Button("6"), new Button("+"),
                new Button("7"), new Button("8"), new Button("9"), new Button("-"),
                new Button("="), new Button("0")
        };
    }

    private void setupButtons() {
        for (int i = 0; i < buttons.length; i++){
            Button button = buttons[i];
            //Här ger jag några specefika knappar en lite mörkare grå färg.
            if(button.getText() == "AC" || button.getText() == "," || button.getText() == "x" || button.getText() == "/" ||
                    button.getText() == "+" || button.getText() == "-" || button.getText() == "=" || button.getText() == "0"){
                button.setStyle("-fx-background-color:#adadad; -fx-border-color:#8c8c8c; -fx-border-width: 1px;");

                button.onMouseEnteredProperty().set(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        button.setStyle("-fx-background-color:#C3C3C3; -fx-border-color:#00C0E6; -fx-border-width: 1.5px;");

                    }
                });

                button.onMouseExitedProperty().set(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        button.setStyle("-fx-background-color:#adadad; -fx-border-color:#8c8c8c; -fx-border-width: 1px;");
                    }
                });
            }
            //Här ger jag tre knappar en större width än resten av knapparna.
            if(button.getText() == "0" || button.getText() == "=" || button.getText() == "AC") {
                button.setMinHeight(100);
                button.setMinWidth(200);

            } else {
                button.setMinHeight(100);
                button.setMinWidth(100);
            }

            String textValue = button.getText();


            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {


                    if(textValue == "="){
                        String s = input.getText();

                        int index = 0;
                        char op = ' ';
                        for(int i = 0; i < s.length(); i++) {
                            if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == 'x' || s.charAt(i) == '/') {
                                index = i;
                                op = s.charAt(i);
                                break;

                            }
                        }
                        //skriver om "," till ".".
                        s = s.replace(',', '.');
                        String Subs = s.substring(0,index);
                        String Subs2 = s.substring(index + 1, s.length());
                        double res = calc(Subs, Subs2, op );

                        String output = Double.toString(res);
                        //skriver om "." till ",".
                        output = output.replace('.', ',');
                        input.setText(output);

                    } else if(textValue == "AC") {
                        input.setText("");

                    } else {
                        if(textValue.equals(",") || textValue.equals("+") || textValue.equals("-") || textValue.equals("x") || textValue.equals("/") ){
                            if(input.getText().length() > 0 && (input.getText().charAt(input.getText().length() - 1) == ',' ||
                                    input.getText().charAt(input.getText().length() - 1) == '+' ||
                                    input.getText().charAt(input.getText().length() - 1) == '-' ||
                                    input.getText().charAt(input.getText().length() - 1) == 'x' ||
                                    input.getText().charAt(input.getText().length() - 1) == '/')){

                            }else if (input.getText().length() == 0){

                            }else{
                                input.setText(input.getText() + textValue);
                            }
                        }else {
                            input.setText(input.getText() + textValue);
                        }
                    }
                }
            });
        };
    }

    private void setupStyle() {

        GridPane buttonPane = new GridPane();

        inputrowOne = new HBox();
        inputrowOne.getChildren().addAll(buttons[0], buttons[1], buttons[2]);
        buttonPane.add(inputrowOne, 0,0);

        inputrowTwo = new HBox();
        inputrowTwo.getChildren().addAll(buttons[3], buttons[4], buttons[5], buttons[6]);
        buttonPane.add(inputrowTwo, 0,1);

        inputrowThree = new HBox();
        inputrowThree.getChildren().addAll(buttons[7], buttons[8], buttons[9], buttons [10]);
        buttonPane.add(inputrowThree, 0,2);

        inputrowFour = new HBox();
        inputrowFour.getChildren().addAll(buttons[11], buttons[12], buttons[13], buttons[14]);
        buttonPane.add(inputrowFour,0,3);

        inputrowFive = new HBox();
        inputrowFive.getChildren().addAll(buttons[15], buttons[16]);
        buttonPane.add(inputrowFive,0,4);

        mainLayout.setCenter(buttonPane);
    }
        //Här är min metod som omvänlar måna Strings till double och sen utför operationen.
        public static double calc (String n1, String n2 ,char op){
            switch (op) {
                case '+':
                    return Double.parseDouble(n1) + Double.parseDouble(n2);
                case '-':
                    return Double.parseDouble(n1) - Double.parseDouble(n2);
                case 'x':
                    return Double.parseDouble(n1) * Double.parseDouble(n2);
                case '/':
                    return Double.parseDouble(n1) / Double.parseDouble(n2);
                default:
                    return 0;
        }
    }
}
