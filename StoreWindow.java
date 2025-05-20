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

public class StoreWindow {
	private Main main;
	private final int button_size = 75;
	private String selected_gender;
	
	public StoreWindow(Main main, String gender) {
		this.main = main;
		selected_gender = gender;
	}
	
	FlowPane store_items = new FlowPane();
	ScrollPane store_items_with_scroll = new ScrollPane(store_items);
	
	public Parent getPane() {
		// Main elements 
    	BorderPane pane = new BorderPane();
    	BorderPane store = new BorderPane();
    	VBox sidebar = new VBox();
    	StackPane main_navbar = new StackPane();
    	HBox store_navbar = new HBox(10);
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
    	Button cart = new Button("Cart");
    	Button all = new Button("All");
    	Button tshirts = new Button("T-Shirts");
    	Button shirts = new Button("Shirts");
    	Button jackets = new Button("Jackets");
    	Button pants = new Button("Pants");
    	Button shorts = new Button("Shorts");
    	Button leggings = new Button("Leggings");
    	Button dress = new Button("Dress");
    	
    	// Adding items 
    	Clothes.initialize();
    	ArrayList<Cloth> clothes = Clothes.getClothes();
    	set_clothes(clothes);
    	
    	// Event Handling 
    	// SideBar
    	home.setOnAction(e -> {
    		main.switchToMainWindow();
    	});
    	
    	balance.setOnAction(e -> {
    		main.switchToBalanceWindow();
    	});
    	
    	cart.setOnAction(e -> {
    		main.switchToCartWindow();
    	});
    	
    	// Items
    	all.setOnAction(e -> {
    		set_clothes(clothes);
    	});
    	
    	tshirts.setOnAction(e -> {
    		set_clothes(clothes,"T-Shirt");
    	});
    	
    	shirts.setOnAction(e -> {
    		set_clothes(clothes,"Shirt");
    	});
    	
    	jackets.setOnAction(e -> {
    		set_clothes(clothes,"Jacket");
    	});
    	
    	pants.setOnAction(e -> {
    		set_clothes(clothes,"Pants");
    	});
    	
    	shorts.setOnAction(e -> {
    		set_clothes(clothes,"Shorts");
    	});
    	
    	leggings.setOnAction(e -> {
    		set_clothes(clothes,"Leggings");
    	});
    	
    	dress.setOnAction(e -> {
    		set_clothes(clothes,"Dress");
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
    	
    	cart.setOnMouseEntered(e -> {
    		cart.setStyle("-fx-background-color: #FFD300; -fx-text-fill: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	cart.setOnMouseExited(e -> {
    		cart.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	all.setOnMouseEntered(e -> {
    		all.setStyle("-fx-background-color: #FFD300; -fx-text-fill: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	all.setOnMouseExited(e -> {
    		all.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	shirts.setOnMouseEntered(e -> {
    		shirts.setStyle("-fx-background-color: #FFD300; -fx-text-fill: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	shirts.setOnMouseExited(e -> {
    		shirts.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	pants.setOnMouseEntered(e -> {
    		pants.setStyle("-fx-background-color: #FFD300; -fx-text-fill: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	pants.setOnMouseExited(e -> {
    		pants.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	tshirts.setOnMouseEntered(e -> {
    		tshirts.setStyle("-fx-background-color: #FFD300; -fx-text-fill: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	tshirts.setOnMouseExited(e -> {
    		tshirts.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	jackets.setOnMouseEntered(e -> {
    		jackets.setStyle("-fx-background-color: #FFD300; -fx-text-fill: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	jackets.setOnMouseExited(e -> {
    		jackets.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	shorts.setOnMouseEntered(e -> {
    		shorts.setStyle("-fx-background-color: #FFD300; -fx-text-fill: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	shorts.setOnMouseExited(e -> {
    		shorts.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	leggings.setOnMouseEntered(e -> {
    		leggings.setStyle("-fx-background-color: #FFD300; -fx-text-fill: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	leggings.setOnMouseExited(e -> {
    		leggings.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	dress.setOnMouseEntered(e -> {
    		dress.setStyle("-fx-background-color: #FFD300; -fx-text-fill: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	dress.setOnMouseExited(e -> {
    		dress.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	
    	balance.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	home.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	cart.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	all.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	tshirts.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	shirts.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	pants.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	jackets.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	leggings.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	shorts.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	dress.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	

    	// buttons size 
    	balance.setMaxWidth(button_size);
    	home.setMaxWidth(button_size);
    	cart.setMaxWidth(button_size);
    			
    	// Configuring Spacing and padding 
    	sidebar.setSpacing(5);
    	sidebar.setPrefWidth(90);
    	sidebar.setAlignment(Pos.TOP_CENTER);
    	sidebar.setMargin(balance, new Insets(5,0,0,0));
    	store_navbar.setPadding(new Insets(5));
    	store_items_with_scroll.setFitToWidth(true);
    	store_items_with_scroll.setFitToHeight(true);
    	store_items_with_scroll.setPannable(true); 
    			
    	// Styling 
    	DropShadow shadow = new DropShadow();
    	shadow.setOffsetX(3.0);
    	shadow.setOffsetY(3.0);
    	shadow.setColor(Color.BLACK);
    	title.setEffect(shadow);
    	title.setStyle("-fx-text-fill: #FFD300;");
    	main_navbar.setStyle("-fx-border-color: #FFD300; -fx-border-width: 3 3 3 3;");
    	store_navbar.setStyle("-fx-border-color: #FFD300; -fx-border-width: 0 3 0 3;");
    	sidebar.setStyle("-fx-border-color: #FFD300; -fx-border-width: 0 0 3 3;");    	
    	store_items.setStyle("-fx-background-color: #0C3EFF;");
    	store_items_with_scroll.setStyle("-fx-background-color: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 3 0 0 3;");
    	
    	// Adding sub-elements to main elements
    	main_navbar.getChildren().addAll(title);
    	store_navbar.getChildren().addAll(all,tshirts,shirts,jackets,pants,shorts,leggings,dress);
    	sidebar.getChildren().addAll(balance,cart,home);
    	store.setTop(store_navbar);
    	store.setCenter(store_items_with_scroll);
    	pane.setBackground(new Background(home_image));
    	pane.setLeft(sidebar);
    	pane.setTop(main_navbar);
    	pane.setCenter(store);
		return pane;
	}
	
	private void set_clothes(ArrayList<Cloth> clothes, String type) {
		store_items.getChildren().clear();
		int counter = 1;
		for(Cloth cloth:clothes) {
			if(type.equals(cloth.getCategory()) && selected_gender.equals(cloth.getGender())) {
    		// Elememts
    		VBox store_item = new VBox(5);
    		Label name = new Label(cloth.getName());
    		Label category = new Label("Type: " + cloth.getCategory());
    		Label price = new Label(cloth.getPrice() + " USD");
    		Label material = new Label("Material: " + cloth.getMaterial());
    		
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
    		
    		store_item.setOnMouseClicked(e -> {
    			main.switchToClothWindow(cloth.getId());
    		});
    		
    		// on sale 
    		if(cloth.check_on_sale()) {
        		price.setTextFill(Color.RED);
        		price.setText(cloth.getPrice() + " USD" + " On Sale");
        	} else {
        		price.setTextFill(Color.WHITE);
        	}
    		
    		// Layout 
    		name.setFont(new Font("Verdana", 18));
    		category.setFont(new Font("Verdana", 18));
    		price.setFont(new Font("Verdana", 18));
    		material.setFont(new Font("Verdana", 18));
    		
    		name.setTextFill(Color.WHITE);
    		category.setTextFill(Color.WHITE);
    		material.setTextFill(Color.WHITE);
    		
    		store_item.setPrefWidth(215);
    		store_item.setAlignment(Pos.TOP_CENTER);
    		store_item.setStyle("-fx-border-color: #FFD700; -fx-border-width: 3; -fx-border-radius: 10; -fx-padding: 10;");
    		
    		// Adding children
    		store_item.getChildren().addAll(img_view,name,category,price,material);
    		store_items.setMargin(store_item, new Insets(5));
    		store_items.getChildren().add(store_item);
			}
			// Updating counter
			counter++;
    	}
	}
	private void set_clothes(ArrayList<Cloth> clothes) {
			store_items.getChildren().clear();
			int counter = 1;
			for(Cloth cloth:clothes) {
				if(selected_gender.equals(cloth.getGender())) {
					// Elememts
					VBox store_item = new VBox(5);
					Label name = new Label(cloth.getName());
					Label category = new Label("Type: " + cloth.getCategory());
					Label price = new Label(cloth.getPrice() + " USD");
					Label material = new Label("Material: " + cloth.getMaterial());
					
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
		    		
		    		store_item.setOnMouseClicked(e -> {
		    			main.switchToClothWindow(cloth.getId());
		    		});
		    		
		    		// on sale 
		    		if(cloth.check_on_sale()) {
		        		price.setTextFill(Color.RED);
		        		price.setText(cloth.getPrice() + " USD" + " 50% Off");
		        	} else {
		        		price.setTextFill(Color.WHITE);
		        	}
		    		
					// Layout 
					name.setFont(new Font("Verdana", 18));
					category.setFont(new Font("Verdana", 18));
					price.setFont(new Font("Verdana", 18));
					material.setFont(new Font("Verdana", 18));
					
					name.setTextFill(Color.WHITE);
		    		category.setTextFill(Color.WHITE);
		    		material.setTextFill(Color.WHITE);
					store_item.setPrefWidth(215);
					store_item.setAlignment(Pos.TOP_CENTER);
					store_item.setStyle("-fx-border-color: #FFD700; -fx-border-width: 3; -fx-border-radius: 10; -fx-padding: 10;");
					
					// Adding children
					store_item.getChildren().addAll(img_view,name,category,price,material);
					store_items.setMargin(store_item, new Insets(5));
					store_items.getChildren().add(store_item);
					
					// Updating Counter
					counter++;
				}
			}
	}
}
