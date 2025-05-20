package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LogIn {
	private Main main;
	
	public LogIn(Main main) {
		this.main = main;
	}
	
	public Parent getLogIn() {
		StackPane root = new StackPane();
    	HBox name_box = new HBox(5);
    	HBox password_box = new HBox(5);
    	Label name_label = new Label("Username: "); 
    	Label password_label = new Label("Password: ");
    	Label title = new Label("Clothes Basket");
    	name_box.setAlignment(Pos.CENTER);
    	password_box.setAlignment(Pos.CENTER);
    	TextField name_textfield = new TextField();
    	name_textfield.setPromptText("Username Must be Unique");
    	TextField password_textfield = new TextField();
    	Button submit_button = new Button("Log In | Sign Up");
    	BackgroundImage home_image = new BackgroundImage(
    			new Image("file:/F:/Java/Clothes Basket/imgs/bg.png"), 
    			BackgroundRepeat.NO_REPEAT,
    			BackgroundRepeat.NO_REPEAT,
    			BackgroundPosition.CENTER,
    			new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
    			);
    	name_box.getChildren().addAll(name_label, name_textfield  );
    	password_box.getChildren().addAll(password_label , password_textfield);
    	
    	
    	// Event handling 
    	submit_button.setOnAction(e -> {
    		if(name_textfield.getText().length()>=1 && password_textfield.getText().length()>=1) {
    		try {
    			File file = new File("log.txt");
    			Scanner input = new Scanner(file);
    			boolean has_name = false;
                while (input.hasNextLine()) {
                    String line = input.nextLine();
                    String[] credentials = line.split(",");
                    if(credentials[0].equals(name_textfield.getText()) && credentials[1].equals(password_textfield.getText())) {
                    	Alert alert = new Alert(AlertType.INFORMATION);
        				alert.setTitle("Info");
        				alert.setHeaderText("Logged In Successfully!");
        				alert.setContentText("Welcome Back! " + name_textfield.getText());
        				alert.showAndWait();
                    	has_name = true;
                    	main.setName(credentials[0]);
                    	main.setBalance();
                    	main.switchToLoadingWindow(true);
                    	break;
                    } else if (credentials[0].equals(name_textfield.getText()) && !credentials[1].equals(password_textfield.getText())) {
                    	has_name=true;
                    	Alert alert = new Alert(AlertType.ERROR);
        				alert.setTitle("Error");
        				alert.setHeaderText("Log In Not Successful!");
        				alert.setContentText("Please Enter the Correct Password!");
        				alert.showAndWait();
                    }
                }
                
                if(!has_name) {
                	try {
                        FileWriter credentials_writer = new FileWriter("log.txt", true);
                        credentials_writer.write("\n" + name_textfield.getText() + "," + password_textfield.getText());
                        credentials_writer.close();
                        
                        FileWriter balance_writer = new FileWriter("log2.txt", true);
                        balance_writer.write("\n" + name_textfield.getText() + "," + 500);
                        balance_writer.close();
                        Alert alert = new Alert(AlertType.INFORMATION);
        				alert.setTitle("Info");
        				alert.setHeaderText("Signed Up Successfully!");
        				alert.setContentText("Welcome! " + name_textfield.getText());
        				alert.showAndWait();
                        main.setName(name_textfield.getText());
                        main.setBalance();
                        main.switchToLoadingWindow(true);
                    } catch (IOException exc) {
                        System.out.println("An error occurred.");
                        exc.printStackTrace();
                    }
                }
                
                input.close();
                
    		} catch (FileNotFoundException exc) {
                System.out.println("File not found.");
                exc.printStackTrace();
            } catch (IOException exc2) {
            	 System.out.println("Error Occured.");
                 exc2.printStackTrace();
            }
    		} else {
    			Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Credentials Error");
				alert.setContentText("Please Fill both Username and Password Fields!");
				alert.showAndWait();
    		}
    	});
    	
    	// Buttons Styling 
    	
    	submit_button.setOnMouseEntered(e -> {
    		submit_button.setStyle("-fx-background-color: #FFD300; -fx-text-fill: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	submit_button.setOnMouseExited(e -> {
    		submit_button.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	submit_button.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	
    	// Styling 
    	name_textfield.setStyle("-fx-font-size: 12px; -fx-pref-width: 200px; -fx-pref-height: 20px;");
    	password_textfield.setStyle("-fx-font-size: 12px; -fx-pref-width: 200px; -fx-pref-height: 20px;");
    	name_label.setFont(Font.font("Arial",FontWeight.BOLD,20));
    	password_label.setFont(Font.font("Arial",FontWeight.BOLD,20));
    	title.setFont(Font.font("Arial",FontWeight.BOLD,60));
    	name_label.setTextFill(Color.WHITE);
    	password_label.setTextFill(Color.WHITE);
    	title.setTextFill(Color.web("#FFD300"));
    	
    	DropShadow shadow = new DropShadow();
    	shadow.setOffsetX(3.0);
    	shadow.setOffsetY(3.0);
    	shadow.setColor(Color.BLACK);
    	title.setEffect(shadow);
    	name_label.setEffect(shadow);
    	password_label.setEffect(shadow);
    	
    	
    	VBox v1 = new VBox(10);
    	v1.setAlignment(Pos.CENTER);
    	v1.getChildren().addAll(title,name_box,password_box,submit_button);
    	root.setBackground(new Background(home_image));
    	root.getChildren().add(v1);
    	return root;
    }

	}
	
