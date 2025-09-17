package vaniercollege.zyd;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author Yu Duo Zhang (2480549)
 * https://github.com/zyd-074/Vanier_F25_420-SF3-RE_Lab03.git
 */
public class YuDuoZhang_Lab03 extends Application{
    // Status Message Creation
    static Label statusMessage = new Label();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Initial Elements Set Up
        // Layout SetUp
        BorderPane root = new BorderPane();
        GridPane elements = new GridPane();
        elements.setPadding(new Insets(15,15,15,15));
        elements.setHgap(10);
        elements.setVgap(10);
        root.setCenter(elements);
        
        // Label creation
        Label firstName = new Label("First Name: ");
        Label lastName = new Label("Last Name: ");
        Label email = new Label("Email: ");
        Label password = new Label("Password: ");

        // TextField Creation
        TextField userFName = new TextField();
        TextField userLName = new TextField();
        TextField userEmail = new TextField();
        PasswordField userPW = new PasswordField();
        
        // Button creation
        Button register = new Button("Register");
        register.setDisable(true);
        Button clear = new Button("Clear");
        
        // Position Set Up
        elements.setAlignment(Pos.TOP_LEFT);
        elements.add(firstName, 0, 0);
        elements.add(lastName, 0, 1);
        elements.add(email, 0, 2);
        elements.add(password, 0, 3);
        elements.add(register, 0, 4);
        elements.add(userFName, 1, 0);
        elements.add(userLName, 1, 1);
        elements.add(userEmail, 1, 2);
        elements.add(userPW, 1, 3);
        elements.add(clear, 1, 4);
        elements.add(statusMessage, 0, 5);
        
        // Implementation for Clear
        clear.setOnAction(e -> {
            userFName.setText("");
            userLName.setText("");
            userEmail.setText("");
            userPW.setText("");
        });
        
        // Implementation for Register
        register.setOnMouseClicked(e -> {
            if (checkEmailStatus(userEmail.getText()) && checkPWStatus(userPW.getText())) {
                statusMessage.setTextFill(Color.GREEN);
                statusMessage.setText("Welcome, " + userFName.getText());
            }
        });
        
        // Update FieldStatus
        userFName.setOnKeyTyped(e -> {
            if (checkFieldStatus(userFName.getText(), userLName.getText(), userEmail.getText(), userPW.getText())) {
                statusMessage.setText("");
                register.setDisable(false);
            }
        });
        userLName.setOnKeyTyped(e -> {
            if (checkFieldStatus(userFName.getText(), userLName.getText(), userEmail.getText(), userPW.getText())) {
                statusMessage.setText("");
                register.setDisable(false);
            }
        });
        userEmail.setOnKeyTyped(e -> {
            if (checkFieldStatus(userFName.getText(), userLName.getText(), userEmail.getText(), userPW.getText())) {
                statusMessage.setText("");
                register.setDisable(false);
            }
        });
        userPW.setOnKeyTyped(e -> {
            if (checkFieldStatus(userFName.getText(), userLName.getText(), userEmail.getText(), userPW.getText())) {
                statusMessage.setText("");
                register.setDisable(false);
            }
        });
        
        // Scene SetUp + show
        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Checks if all fields contains something
     * @param fName user first name
     * @param lName user last name
     * @param email user email
     * @param pw user password
     * @return  true or false
     */
    public boolean checkFieldStatus(String fName, String lName, String email, String pw) {
        boolean hasFName = false;
        boolean hasLName = false;
        boolean hasEmail = false;
        boolean hasPW = false;
        
        if (fName.isBlank() == false) {
            hasFName = true;
        } else {
            statusMessage.setTextFill(Color.FIREBRICK);
            statusMessage.setText("Please enter your first name");
        }
        
        if (lName.isBlank() == false) {
            hasLName = true;
        } else {
            statusMessage.setTextFill(Color.FIREBRICK);
            statusMessage.setText("Please enter your last name");
        }
        
        if (email.isBlank() == false) {
            hasEmail = true;
        } else {
            statusMessage.setTextFill(Color.FIREBRICK);
            statusMessage.setText("Please enter your email");
        }
        
        if (pw.isBlank() == false) {
            hasPW = true;
        } else {
            statusMessage.setTextFill(Color.FIREBRICK);
            statusMessage.setText("Please enter your password");
        }
        
        return hasFName && hasLName && hasEmail && hasPW;
    }
    
    /**
     * Checks if the email contains '@' and a domain
     * @param email user Email
     * @return true or false
     */
    public boolean checkEmailStatus(String email) {
        return email.contains("@") && email.contains(".");
    }
    
    /**
     * Checks if the Password has at least one digit and one letter
     * @param pw user Password
     * @return true or false 
     */
    public boolean checkPWStatus(String pw) {
        char[] charPW = pw.toCharArray();
        boolean hasDigit = false;
        boolean hasLetter = false;
        
        for (char c : charPW) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if(Character.isLetter(c)) {
                hasLetter = true;
            }
        }
        
        return hasDigit && hasLetter;
    }
}
