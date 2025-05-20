package main;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;

public class MorFWindow {
	private Main main;
	private final int button_size = 75;
	
	public MorFWindow(Main main) {
		this.main = main;
	}
	
	public Parent getPane() {
		// Main elements 
    	BorderPane pane = new BorderPane();
    	StackPane navbar = new StackPane();
    	HBox m_or_f = new HBox();
    	StackPane m = new StackPane();
    	StackPane f = new StackPane();
    	Rectangle overlay1 = new Rectangle(400, 600);
	    overlay1.setFill(Color.rgb(0, 0, 0, 0)); 
	    Rectangle overlay2 = new Rectangle(400, 600);
	    overlay2.setFill(Color.rgb(0, 0, 0, 0)); 
	    Label male_label = new Label("Male");
	    male_label.setFont(new Font("Verdana",35));
	    male_label.setTextFill(Color.WHITE);
	    Label female_label = new Label("Female");
	    female_label.setFont(new Font("Verdana",35));
	    female_label.setTextFill(Color.WHITE);
	     
    	BackgroundImage home_image = new BackgroundImage(
    			new Image("file:/F:/Java/Clothes Basket/imgs/bg.png"), 
    			BackgroundRepeat.NO_REPEAT,
    			BackgroundRepeat.NO_REPEAT,
    			BackgroundPosition.CENTER,
    			new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
    			);
    	// images 
    	Image male_image = new Image("file:/F:/Java/Clothes Basket/imgs/male.jpg");
    	ImageView male = new ImageView(male_image);
	
		male.setFitWidth(400);  
		male.setFitHeight(600); 
    	male.setPreserveRatio(false);
    	male.setSmooth(true);
    	
    	
    	Image female_image = new Image("file:/F:/Java/Clothes Basket/imgs/female.jpg");
    	ImageView female = new ImageView(female_image);
    	
    	
    	female.setFitWidth(400);   // Set width to 300 pixels	
		female.setFitHeight(600);  // Set height to 200 pixels
    	female.setPreserveRatio(false);
    	female.setSmooth(true);
    	
    	// Handlers
    	m.setOnMouseEntered(e -> {
    		overlay1.setFill(Color.rgb(0, 0, 0, 0.5));
    		male_label.setTextFill(Color.BLUE);
    	});
    	
    	m.setOnMouseExited(e -> {
    		overlay1.setFill(Color.rgb(0, 0, 0, 0));
    		male_label.setTextFill(Color.WHITE);
    	});
    	
    	m.setOnMouseClicked(e -> {
    		main.switchToStoreWindow("Male");
    	});
    	

    	f.setOnMouseEntered(e -> {
    		overlay2.setFill(Color.rgb(0, 0, 0, 0.5));
    		female_label.setTextFill(Color.RED);
    	});
    	
    	f.setOnMouseExited(e -> {
    		overlay2.setFill(Color.rgb(0, 0, 0, 0));
    		female_label.setTextFill(Color.WHITE);
    	});
    	
    	f.setOnMouseClicked(e -> {
    		main.switchToStoreWindow("Female");
    	});
    	
    	
    	// Sub-elements
    	Label title = new Label("Clothes Basket");
    	title.setFont(new Font("Verdana",35));
    	
    	
    	
    	// Styling
    	DropShadow shadow = new DropShadow();
    	shadow.setOffsetX(3.0);
    	shadow.setOffsetY(3.0);
    	shadow.setColor(Color.BLACK);
    	title.setEffect(shadow);
    	title.setStyle("-fx-text-fill: #FFD300;");
    	navbar.setStyle("-fx-border-color: #FFD300; -fx-border-width: 3 3 3 3;");
  
    	
    	// Adding sub-elements to main elements
    	pane.setBackground(new Background(home_image));
    	navbar.getChildren().addAll(title);
    	navbar.setAlignment(Pos.CENTER);
    	m.getChildren().addAll(male,overlay1,male_label);
    	f.getChildren().addAll(female,overlay2,female_label);
    	m_or_f.getChildren().addAll(m,f);
    	pane.setTop(navbar);
    	pane.setCenter(m_or_f);
		return pane;
	}
}