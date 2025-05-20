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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BalanceWindow {
	private Main main;
	private final int button_size = 75;
	
	public BalanceWindow(Main main) {
		this.main = main;
	}
	
	public Parent getPane() {
		BorderPane pane = new BorderPane();
		Label title = new Label("Clothes Basket");
		StackPane main_navbar = new StackPane();
		VBox box = new VBox(10);
		Label balance_label = new Label("Balance: " + main.getBalance() + "USD");
		Label exc_label = new Label("");
		VBox sidebar = new VBox();
		Button home = new Button("Home");
		Button store = new Button("Store");
		Button cart = new Button("Cart");
		Button change_balance = new Button("Change Balance");
		TextField balance_textfield = new TextField();
		BackgroundImage home_image = new BackgroundImage(
    			new Image("file:/F:/Java/Clothes Basket/imgs/bg.png"), 
    			BackgroundRepeat.NO_REPEAT,
    			BackgroundRepeat.NO_REPEAT,
    			BackgroundPosition.CENTER,
    			new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
    			);
		
		home.setOnAction(e -> {
    		main.switchToMainWindow();
    	});
		
		store.setOnAction(e -> {
			main.switchToMorFWindow();
		});
		
		cart.setOnAction(e -> {
			main.switchToCartWindow();
		});
		
		// button styling
		home.setOnMouseEntered(e -> {
    		home.setStyle("-fx-background-color: #FFD300; -fx-text-fill: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	home.setOnMouseExited(e -> {
    		home.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	cart.setOnMouseEntered(e -> {
    		cart.setStyle("-fx-background-color: #FFD300; -fx-text-fill: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	cart.setOnMouseExited(e -> {
    		cart.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	store.setOnMouseEntered(e -> {
    		store.setStyle("-fx-background-color: #FFD300; -fx-text-fill: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	store.setOnMouseExited(e -> {
    		store.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	change_balance.setOnMouseEntered(e -> {
    		change_balance.setStyle("-fx-background-color: #FFD300; -fx-text-fill: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	change_balance.setOnMouseExited(e -> {
    		change_balance.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
		
		change_balance.setOnAction(e -> {
			try {
			double balance = Double.parseDouble(balance_textfield.getText());
			if(balance < 0) {
				throw new NegativeNumberException("Incorrect Balance Added! Please Try Again");
			}
			main.setBalance(balance,false);
			exc_label.setText("");
			
			} catch(NumberFormatException exc) {
				// exc_label.setText("Incorrect Balance Added! Please Try Again.");
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Balance Error");
				alert.setContentText("Incorrect Balance Added! Please Try Again.");
				alert.showAndWait();
			} catch(NegativeNumberException exc) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Balance Error");
				alert.setContentText("Incorrect Balance Added! Please Try Again.");
				alert.showAndWait();
			}
			
			balance_label.setText("Balance: " + main.getBalance() + "USD");
		});
		
		// Styling 
		DropShadow shadow = new DropShadow();
    	shadow.setOffsetX(3.0);
    	shadow.setOffsetY(3.0);
    	shadow.setColor(Color.BLACK);
    	title.setEffect(shadow);
    	title.setStyle("-fx-text-fill: #FFD300;");
    	main_navbar.setStyle("-fx-border-color: #FFD300; -fx-border-width: 3 3 3 3;");
    	sidebar.setStyle("-fx-border-color: #FFD300; -fx-border-width: 0 3 3 3;");
    	box.setStyle("-fx-border-color: #FFD300; -fx-border-width: 0 3 3 0;");
    	home.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	store.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	cart.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	change_balance.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	sidebar.setSpacing(5);
    	sidebar.setPrefWidth(90);
    	sidebar.setAlignment(Pos.TOP_CENTER);
    	sidebar.setMargin(home, new Insets(5,0,0,0));
		title.setFont(new Font("Verdana",35));
		home.setMaxWidth(button_size);
		store.setMaxWidth(button_size);
		cart.setMaxWidth(button_size);
		balance_textfield.setMaxWidth(150);
		balance_label.setFont(Font.font("Arial",FontWeight.BOLD,24));
		balance_label.setTextFill(Color.WHITE);
		box.setAlignment(Pos.CENTER);
		
		main_navbar.getChildren().addAll(title);
		sidebar.getChildren().addAll(home,cart,store);
		box.getChildren().addAll(balance_label,balance_textfield,change_balance,exc_label);
		pane.setBackground(new Background(home_image));
		pane.setTop(main_navbar);
		pane.setCenter(box);
		pane.setLeft(sidebar);
		return pane;
	}
	
	
	
}
