package main;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
import javafx.scene.layout.FlowPane;

public class CartWindow {
	private Main main;
	private final int button_size = 75;
	
	public CartWindow(Main main) {
		this.main = main;
	}
	
	FlowPane store_items = new FlowPane();
	ScrollPane store_items_with_scroll = new ScrollPane(store_items);
	
	public Parent getPane() {
		// Main elements 
    	BorderPane pane = new BorderPane();
    	BorderPane store = new BorderPane();
    	VBox sidebar = new VBox();
    	StackPane main_navbar = new StackPane();
    	StackPane footer = new StackPane();
    	BackgroundImage home_image = new BackgroundImage(
    			new Image("file:/F:/Java/Clothes Basket/imgs/bg.png"), 
    			BackgroundRepeat.NO_REPEAT,
    			BackgroundRepeat.NO_REPEAT,
    			BackgroundPosition.CENTER,
    			new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
    			);
    			
    			
    	// Sub-elements
    	Label title = new Label("Clothes Basket");
    	title.setFont(new Font("Verdana",35));
    	Button balance = new Button("Balance");
    	Button home = new Button("Home");
    	Button store_button = new Button("Store");
    	Button checkout = new Button("Checkout");
    	
    	// Adding items 
    	ArrayList<Cloth> cart_clothes = Cart.getCart();
    	set_clothes(cart_clothes);
    	
    	// Event Handling 
    	// SideBar
    	home.setOnAction(e -> {
    		main.switchToMainWindow();
    	});
    	
    	balance.setOnAction(e -> {
    		main.switchToBalanceWindow();
    	});
    	
    	store_button.setOnAction(e -> {
    		main.switchToMorFWindow();
    	});
    	
    	checkout.setOnAction(e -> {
    		Cart.checkout(main);
    		set_clothes(Cart.getCart());
    	});
    	
    	// Buttons Styling 
    	
    	balance.setOnMouseEntered(e -> {
    		balance.setStyle("-fx-background-color: #FFD300; -fx-text-fill: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	balance.setOnMouseExited(e -> {
    		balance.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	home.setOnMouseEntered(e -> {
    		home.setStyle("-fx-background-color: #FFD300; -fx-text-fill: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	home.setOnMouseExited(e -> {
    		home.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	store_button.setOnMouseEntered(e -> {
    		store_button.setStyle("-fx-background-color: #FFD300; -fx-text-fill: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	store_button.setOnMouseExited(e -> {
    		store_button.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	checkout.setOnMouseEntered(e -> {
    		checkout.setStyle("-fx-background-color: #FFD300; -fx-text-fill: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	checkout.setOnMouseExited(e -> {
    		checkout.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	
    	// buttons size 
    	balance.setMaxWidth(button_size);
    	home.setMaxWidth(button_size);
    	store_button.setMaxWidth(button_size);
    	
    	//styling 
    	DropShadow shadow = new DropShadow();
    	shadow.setOffsetX(3.0);
    	shadow.setOffsetY(3.0);
    	shadow.setColor(Color.BLACK);
    	title.setEffect(shadow);
    	balance.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	home.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	store_button.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	checkout.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");	
    			
    	// Configuring Spacing and padding 
    	sidebar.setSpacing(5);
    	sidebar.setPrefWidth(90);
    	sidebar.setAlignment(Pos.TOP_CENTER);
    	sidebar.setMargin(balance, new Insets(5,0,0,0));
    	store_items_with_scroll.setFitToWidth(true);
    	store_items_with_scroll.setFitToHeight(true);
    	store_items_with_scroll.setPannable(true); 
    	footer.setMargin(checkout, new Insets(10,10,10,10));
    	store_items.setStyle("-fx-background-color: #0C3EFF;");
    	
    	// Styling 
    	title.setStyle("-fx-text-fill: #FFD300;");
    	main_navbar.setStyle("-fx-border-color: #FFD300; -fx-border-width: 3 3 3 3;");
    	sidebar.setStyle("-fx-border-color: #FFD300; -fx-border-width: 0 0 3 3;");
    	store.setStyle("-fx-background-color: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 0 0 0 3;");
    	footer.setStyle("-fx-background-color: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 3 3 3 0;");
    			
    	// Adding sub-elements to main elements
    	main_navbar.getChildren().addAll(title);
    	footer.getChildren().addAll(checkout);
    	sidebar.getChildren().addAll(balance,store_button,home);
    	store.setCenter(store_items_with_scroll);
    	store.setBottom(footer);
    	pane.setBackground(new Background(home_image));
    	pane.setLeft(sidebar);
    	pane.setTop(main_navbar);
    	pane.setCenter(store);
		return pane;
	}
	
	private void set_clothes(ArrayList<Cloth> clothes) {
			store_items.getChildren().clear();
			int counter = 1;
			for(Cloth cloth:clothes) {
					// Elememts
					VBox store_item = new VBox(5);
					Label name = new Label(cloth.getBrand() + " " + cloth.getName());
					Label price = new Label(cloth.getPrice() + " USD");
					Button remove = new Button("Remove");
					
					// Image 
		    		Image img = cloth.getImg();
		    		ImageView img_view = new ImageView(img);
		    		img_view.setFitWidth(150);
		    		img_view.setPreserveRatio(true);
		    		img_view.setStyle("-fx-border-color: #FFD700; -fx-border-width: 2; -fx-border-radius: 5;");
		    		
		    		// Event Handling 
		    		store_item.setOnMouseEntered(e -> {
		    			store_item.setStyle("-fx-border-color: black; -fx-border-width: 3; -fx-border-radius: 10; -fx-padding: 10;");
		    		});
		    		
		    		store_item.setOnMouseExited(e -> {
		    			store_item.setStyle("-fx-border-color: #FFD700; -fx-border-width: 3; -fx-border-radius: 10; -fx-padding: 10;");
		    		});
		    		
		    		remove.setOnAction(e -> {
		    			Cart.removeFromCart(cloth.getId());
		    			set_clothes(Cart.getCart());
		    		});
		    		
		    		// Styling 
		    		remove.setOnMouseEntered(e -> {
		        		remove.setStyle("-fx-background-color: #FFD300; -fx-text-fill: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
		        	});
		        	
		        	remove.setOnMouseExited(e -> {
		        		remove.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
		        	});
		    			    	
		    		remove.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
		    		
					// Layout 
					name.setFont(new Font("Verdana", 18));
					price.setFont(new Font("Verdana", 18));
					store_item.setPrefWidth(215);
					store_item.setAlignment(Pos.TOP_CENTER);
					store_item.setStyle("-fx-border-color: #FFD300; -fx-border-width: 3; -fx-border-radius: 10; -fx-padding: 10;");
					
					// Adding children
					store_item.getChildren().addAll(img_view,name,price,remove);
					store_items.setMargin(store_item, new Insets(5));
					store_items.getChildren().add(store_item);
					
					// Updating Counter
					counter++;
				}
	}
}
