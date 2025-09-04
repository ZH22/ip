package Nacho.Ui;

import java.util.Objects;

import Nacho.Nacho;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Main Class for JavaFX GUI ChatRoom with Nacho Chatbot
 */
public class Main extends Application {

    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.jpg"));
    private Image nachoImage = new Image(this.getClass().getResourceAsStream("/images/DaNacho.jpg"));
    private Nacho nacho = new Nacho("GUI");

    @Override
    public void start(Stage stage) {
        //Setting up required components

        scrollPane = new ScrollPane();
        dialogContainer = new VBox();
        scrollPane.setContent(dialogContainer);

        // Styling Settings
        scrollPane.getStyleClass().add("my-scrollPane");
        dialogContainer.getStyleClass().add("my-dialogContainer");
        dialogContainer.setSpacing(20);

        userInput = new TextField();
        sendButton = new Button("Send");

        AnchorPane mainLayout = new AnchorPane();
        mainLayout.getChildren().addAll(scrollPane, userInput, sendButton);

        scene = new Scene(mainLayout);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        stage.setScene(scene);
        stage.show();


        //More code to be added here later

        stage.setTitle("Nacho - Personal Cheesy Todo Tracker");
        stage.setResizable(false);
        stage.setMinHeight(600.0);
        stage.setMinWidth(400.0);

        mainLayout.setPrefSize(400.0, 600.0);

        scrollPane.setPrefSize(385, 535);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        scrollPane.setVvalue(1.0);
        scrollPane.setFitToWidth(true);

        dialogContainer.setPrefHeight(Region.USE_COMPUTED_SIZE);

        userInput.setPrefWidth(325.0);

        sendButton.setPrefWidth(55.0);

        AnchorPane.setTopAnchor(scrollPane, 1.0);

        AnchorPane.setBottomAnchor(sendButton, 1.0);
        AnchorPane.setRightAnchor(sendButton, 1.0);

        AnchorPane.setLeftAnchor(userInput, 1.0);
        AnchorPane.setBottomAnchor(userInput, 1.0);

        // Handle User Inputs
        sendButton.setOnMouseClicked((event) -> {
            handleUserInput();
        });
        userInput.setOnAction((event) -> {
            handleUserInput();
        });

        // Scroll down to the end every time dialogContainer's height changes.
        dialogContainer.heightProperty().addListener((observable) -> scrollPane.setVvalue(1.0));

        // Show First Message
        dialogContainer.getChildren().add(
                DialogBox.getNachoDialog("Hello I'm Nacho\nWhat can I do for you?", nachoImage)
        );
    }

    private void handleUserInput() {
        String userText = userInput.getText();
        String nachoText = "";
        boolean toCloseWindow = false;

        // Handle Bye Case
        if (Objects.equals(userText, "bye")) {
            nachoText = "Bye. Hope to see you again soon!\nClosing Chat in 3...2..1...";
            toCloseWindow = true;
        } else {
            nachoText = nacho.handleQuery(userInput.getText());
        }

        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(userText, userImage),
                DialogBox.getNachoDialog(nachoText, nachoImage)
        );

        userInput.clear();

        // If Time to end query -> Close stage
        if (toCloseWindow) {
            // Using sendButton to get stage context
            Stage stage = ((Stage) sendButton.getScene().getWindow());

            // Delay one second for user to view goodbye message
            PauseTransition delay = new PauseTransition(Duration.seconds(3));
            delay.setOnFinished(event -> stage.close());
            delay.play();
        }
    }
}
