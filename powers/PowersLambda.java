package assignment11.powers;

/*
 *
 * Name: PowersLambda.java
 * Purpose: Uses the EventListener<ActionEvent e> Functional Interface
 *          to allow button interaction
 * Author: grivera64
 * Date: 11/28/2021
 *
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PowersLambda extends Application {

    /* Helper method as using many Exceptions in the long run is slower that iterating through characters */
    public static boolean isDouble(String numberString) {

        return numberString.chars().allMatch((c) -> Character.isDigit(c) || c == '.');

    }

    /* Helper method to create content for the JavaFX Application */
    private Parent createContent() {

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));

        /* Input Section */
        Label inputLabel = new Label("Base Value:");
        TextField inputTextField = new TextField("0");
        HBox inputBox = new HBox(10, inputLabel, inputTextField);
        inputBox.setPadding(new Insets(5));
        inputBox.setAlignment(Pos.CENTER_LEFT);
        root.getChildren().add(inputBox);

        /* Output Rows */
        Label powerLabel1 = new Label("Power of 2:");
        Label powerOutput1 = new Label();
        HBox powerBox1 = new HBox(10, powerLabel1, powerOutput1);
        powerBox1.setPadding(new Insets(5));
        powerBox1.setAlignment(Pos.CENTER_LEFT);
        root.getChildren().add(powerBox1);

        Label powerLabel2 = new Label("Power of 3:");
        Label powerOutput2 = new Label();
        HBox powerBox2 = new HBox(10, powerLabel2, powerOutput2);
        powerBox2.setPadding(new Insets(5));
        powerBox2.setAlignment(Pos.CENTER_LEFT);
        root.getChildren().add(powerBox2);

        Label powerLabel3 = new Label("Power of 4:");
        Label powerOutput3 = new Label();
        HBox powerBox3 = new HBox(10, powerLabel3, powerOutput3);
        powerBox3.setPadding(new Insets(5));
        powerBox3.setAlignment(Pos.CENTER_LEFT);
        root.getChildren().add(powerBox3);

        /* Set up the Button */
        Button calculateButton = new Button("Calculate the Powers");
        calculateButton.setOnAction((e) -> {

           if (inputTextField.getLength() < 1) {

               powerOutput1.setText("");
               powerOutput2.setText("");
               powerOutput3.setText("");
               return;

           }

           final String input = inputTextField.getText();

           if (!PowersLambda.isDouble(input)) {

                System.out.printf("Invalid Input Provided: %s\nDefaulting to NaN...\n", input);
                powerOutput1.setText("NaN");
                powerOutput2.setText("NaN");
                powerOutput3.setText("NaN");
                return;

            }

           final double baseValue = Double.parseDouble(input);
           powerOutput1.setText(String.format("%.2f", Math.pow(baseValue, 2)));
           powerOutput2.setText(String.format("%.2f", Math.pow(baseValue, 3)));
           powerOutput3.setText(String.format("%.2f", Math.pow(baseValue, 4)));

        });
        calculateButton.setAlignment(Pos.CENTER);
        root.getChildren().add(calculateButton);
        return root;

    }

    //@Override
    public void start(Stage primaryStage) {

        /* Set Window */
        primaryStage.setTitle("PowersLambda by grivera64");
        primaryStage.setScene(new Scene(this.createContent()));
        primaryStage.show();

    }

    public static void main(String[] args) {

        launch(args);

    }

}
