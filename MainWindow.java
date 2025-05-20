package main;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;

public class MainWindow {
	private Main main;
	private final int button_size = 75;
	
	public MainWindow(Main main) {
		this.main = main;
	}
	
	public Parent getPane() {
		// Main elements 
    	BorderPane pane = new BorderPane();
    	VBox sidebar = new VBox();
    	StackPane navbar = new StackPane();
    	Pane homepage = new Pane();
    	BackgroundImage home_image = new BackgroundImage(
    			new Image("file:/F:/Java/Clothes Basket/imgs/Clothes.png"), 
    			BackgroundRepeat.NO_REPEAT,
    			BackgroundRepeat.NO_REPEAT,
    			BackgroundPosition.CENTER,
    			new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
    			);
    			
    	// Sub-elements
    	Label title = new Label("Clothes Basket");
    	title.setFont(new Font("Verdana",35));
    	Button balance = new Button("Balance");
    	Button back = new Button("Log Out");
    	Button cart = new Button("Cart");
    	Button store = new Button("View Store");
    	
    	// Event Handling 
    	back.setOnAction(e -> {
    		main.switchToLoadingWindow(false);
    	});
    	
    	balance.setOnAction(e -> {
    		main.switchToBalanceWindow();
    	});
    	
    	store.setOnAction(e -> {
    		main.switchToMorFWindow();
    	});
    	
    	cart.setOnAction(e -> {
    		main.switchToCartWindow();
    	});
    	
    	balance.setOnMouseEntered(e -> {
    		balance.setStyle("-fx-background-color: #FFD300; -fx-text-fill: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	balance.setOnMouseExited(e -> {
    		balance.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	back.setOnMouseEntered(e -> {
    		back.setStyle("-fx-background-color: #FFD300; -fx-text-fill: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	back.setOnMouseExited(e -> {
    		back.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	store.setOnMouseEntered(e -> {
    		store.setStyle("-fx-background-color: #FFD300; -fx-text-fill: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	store.setOnMouseExited(e -> {
    		store.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	cart.setOnMouseEntered(e -> {
    		cart.setStyle("-fx-background-color: #FFD300; -fx-text-fill: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	cart.setOnMouseExited(e -> {
    		cart.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
   
    			
    	// buttons size 
    	balance.setMaxWidth(button_size);
    	back.setMaxWidth(button_size);
    	cart.setMaxWidth(button_size);
    	store.setPrefWidth(140);
    	store.setPrefHeight(40);
    			
    	// Configuring Spacing and padding 
    	sidebar.setSpacing(5);
    	sidebar.setPrefWidth(90);
    	sidebar.setAlignment(Pos.TOP_CENTER);
    	sidebar.setMargin(balance, new Insets(5,0,0,0));
    	
    	// Styling
    	DropShadow shadow = new DropShadow();
    	shadow.setOffsetX(3.0);
    	shadow.setOffsetY(3.0);
    	shadow.setColor(Color.BLACK);
    	title.setEffect(shadow);
    	title.setStyle("-fx-text-fill: #FFD300;");
    	sidebar.setStyle("-fx-border-color: #FFD300; -fx-border-width: 0 0 3 3;");    	
    	navbar.setStyle("-fx-border-color: #FFD300; -fx-border-width: 3 3 3 3;");
    	homepage.setStyle("-fx-border-color: #FFD300; -fx-border-width: 0 3 3 0;");
    	balance.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	back.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	store.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	cart.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	
    	// Adding sub-elements to main elements
    	pane.setBackground(new Background(home_image));
    	homepage.getChildren().addAll(store);
    	store.setTranslateX(240);
    	store.setTranslateY(450);
    	navbar.getChildren().addAll(title);
    	sidebar.getChildren().addAll(balance,cart,back);
    	pane.setLeft(sidebar);
    	pane.setTop(navbar);
    	pane.setCenter(homepage);
		return pane;
	}
}
