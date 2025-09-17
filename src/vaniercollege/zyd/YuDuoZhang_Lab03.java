package vaniercollege.zyd;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * @author Yu Duo Zhang (2480549)
 * https://github.com/zyd-074/Vanier_F25_420-SF3-RE_Lab03.git
 */
public class YuDuoZhang_Lab03 extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Initial Elements Set Up
        BorderPane root = new BorderPane();
        GridPane elements = new GridPane();
        root.setCenter(elements);
        
        Label firstName = new Label("First Name: ");
        Label lastName = new Label("Last Name: ");
        Label email = new Label("Email: ");
        Label password = new Label("Password: ");
        Label statusMessage = new Label();
        
        TextField userFName = new TextField();
        TextField userLName = new TextField();
        TextField userEmail = new TextField();
        PasswordField userPW = new PasswordField();
        
        Button register = new Button("Register");
        register.setDisable(true);
        Button clear = new Button("Clear");
        
        elements.setAlignment(Pos.TOP_LEFT);
        elements.add(firstName, 0, 0);
        elements.add(lastName, 1, 0);
        elements.add(email, 2, 0);
        elements.add(password, 3, 0);
        elements.add(register, 4, 0);
        elements.add(userFName, 0, 1);
        elements.add(userLName, 1, 1);
        elements.add(userEmail, 2, 1);
        elements.add(userPW, 3, 1);
        elements.add(clear, 4, 1);
        
        
        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
    
}
