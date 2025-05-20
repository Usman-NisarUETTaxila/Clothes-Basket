package main;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Alert.AlertType;
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
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class ClothWindow {
	private Main main;
	private final int button_size = 75;
	
	public ClothWindow(Main main) {
		this.main = main;
	}
	
	HBox item_display = new HBox();
	ScrollPane item_display_with_scroll = new ScrollPane(item_display);
	
	public Parent getPane(int id) {
		// Main elements 
    	BorderPane pane = new BorderPane();
    	VBox sidebar = new VBox();
    	StackPane main_navbar = new StackPane();
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
    	Button back = new Button("Back");
    	
    	// Event Handling
    	
    	back.setOnAction(e -> {
    		try {
    		ArrayList<Cloth> clothes = Clothes.getClothes();
    		boolean has_cloth = false;
        	for(Cloth cloth:clothes) {
        		if(cloth.getId()==id) {
        			String gender = cloth.getGender();
        			has_cloth = true;
        			main.switchToStoreWindow(gender);
        		}
        	}
        	if(!has_cloth)
        		main.switchToMorFWindow();
    		} catch (ConcurrentModificationException exc) {
    		}
    	});
    	
    	// Cloth
    	ArrayList<Cloth> clothes = Clothes.getClothes();
    	int counter = 1;
    	for(Cloth cloth:clothes) {
    		if(cloth.getId()==id) {
			// Elememts
			VBox store_item = new VBox(5);
			HBox checkout = new HBox(10);
			Label name = new Label(cloth.getBrand() + " " + cloth.getName());
			Label price = new Label(cloth.getPrice() + " USD");
			Label details = new Label("Details" + "\nBrand: " + cloth.getBrand() + "\nMaterial: " + cloth.getMaterial() + "\nColor: " + cloth.getColor());
			Text description_text = new Text("Description\n" + cloth.getDescription() + "\n");
			description_text.setFont(Font.font("Arial", FontWeight.EXTRA_LIGHT, 18));
			description_text.setFill(Color.WHITE);
			TextFlow description = new TextFlow(description_text);
			Label size_label = new Label("Select Size: ");
			ChoiceBox<String> size_box = new ChoiceBox<>();
			size_box.getItems().addAll("S", "M", "L");				
			size_box.setValue("M");
			Button add_to_cart = new Button("Add To Cart");
			
			// Image 
    		Image img = cloth.getImg();
    		ImageView img_view = new ImageView(img);
    		img_view.setFitWidth(300);
    		img_view.setPreserveRatio(true);
    		img_view.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-border-radius: 5;");
    		
    		
    		add_to_cart.setOnAction(e -> {
    			Cloth cart_cloth = new Cloth(cloth);
    			if(size_box.getValue().equals("S")) {
    				cart_cloth.setPrice(cart_cloth.getPrice()/1.25);
    				cart_cloth.setSize("S");
    			}else if (size_box.getValue().equals("L")) {
    				cart_cloth.setPrice(cart_cloth.getPrice()*1.25);
    				cart_cloth.setSize("L");
    			} else {
    				cart_cloth.setSize("M");
    			}
    			Cart.addToCart(cart_cloth);
    			Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Info");
				alert.setHeaderText("Added Item");
				alert.setContentText(cart_cloth + " has been added to the cart.");
				alert.showAndWait();
    		});
    		
    		// button styling
    		add_to_cart.setOnMouseEntered(e -> {
        		add_to_cart.setStyle("-fx-background-color: #FFD300; -fx-text-fill: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
        	});
        	
        	add_to_cart.setOnMouseExited(e -> {
        		add_to_cart.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
        	});
        	
    		
    		size_box.setOnAction(e -> {
    			if(size_box.getValue().equals("S")) {
    				if(cloth.check_on_sale()) {
    	        		price.setTextFill(Color.RED);
    	        		price.setText(cloth.getPrice()/1.25 + " USD" + " 50% Off");
    	        	} else {
    	        		price.setTextFill(Color.web("#FFD300"));
    	        		price.setText(cloth.getPrice()/1.25 + " USD");
    	        	}
    			}else if (size_box.getValue().equals("M")) {
    				if(cloth.check_on_sale()) {
    	        		price.setTextFill(Color.RED);
    	        		price.setText(cloth.getPrice() + " USD" + " 50% Off");
    	        	} else {
    	        		price.setTextFill(Color.web("#FFD300"));
    	        		price.setText(cloth.getPrice() + " USD");
    	        	}
    			}else if (size_box.getValue().equals("L")) {
    				if(cloth.check_on_sale()) {
    	        		price.setTextFill(Color.RED);
    	        		price.setText(cloth.getPrice()*1.25 + " USD" + " 50% Off");
    	        	} else {
    	        		price.setTextFill(Color.web("#FFD300"));
    	        		price.setText(cloth.getPrice()*1.25 + " USD");;
    	        	}
    			}
    		});
    			    
    		// button styling
    		size_box.setOnMouseEntered(e -> {
        		size_box.setStyle("-fx-background-color: #FFD300; -fx-text-fill: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
        	});
        	
        	size_box.setOnMouseExited(e -> {
        		size_box.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
        	});
        	
        	// On sale
        	if(cloth.check_on_sale()) {
        		price.setTextFill(Color.RED);
        		price.setText(cloth.getPrice() + " USD" + " 50% Off");
        	} else {
        		price.setTextFill(Color.web("#FFD300"));
        	}
    		
			// Layout 
    		name.setFont(new Font("Arial", 24));
			price.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD ,24));
			details.setFont(new Font("Arial",18));
			name.setTextFill(Color.WHITE);
    		details.setTextFill(Color.WHITE);
			description.setTextAlignment(TextAlignment.LEFT); 
			description.setMaxWidth(400);
			size_label.setFont(new Font("Arial",14));
			size_label.setTextFill(Color.WHITE);
			add_to_cart.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
			size_box.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
			add_to_cart.setMaxWidth(100);
			store_item.setMaxWidth(600);
			store_item.setSpacing(7);
			store_item.setAlignment(Pos.TOP_LEFT);
			item_display.setStyle("-fx-background-color: #0C3EFF; -fx-padding: 10;");
			item_display.setSpacing(10);
			item_display.setAlignment(Pos.TOP_CENTER);
			
			// Adding children
			checkout.getChildren().addAll(size_label,size_box,add_to_cart);
			store_item.getChildren().addAll(name,price,details,description,checkout);
			item_display.getChildren().addAll(img_view,store_item);	
    		}
    		
    		// Updating counter
    		counter++;
		}

    	// buttons size 
    	back.setMaxWidth(button_size);
    	
    	// Buttons Styling 
    	
    	back.setOnMouseEntered(e -> {
    		back.setStyle("-fx-background-color: #FFD300; -fx-text-fill: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	back.setOnMouseExited(e -> {
    		back.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	});
    	
    	
    			
    	// Configuring Spacing and padding 
    	sidebar.setSpacing(5);
    	sidebar.setPrefWidth(90);
    	sidebar.setAlignment(Pos.TOP_CENTER);
    	sidebar.setMargin(back, new Insets(5,0,0,0));
    	item_display_with_scroll.setFitToWidth(true);
    	item_display_with_scroll.setFitToHeight(true);
    	item_display_with_scroll.setPannable(true);
    	item_display_with_scroll.setStyle("-fx-background-color: #0C3EFF; -fx-border-color: #FFD300; -fx-border-width: 0 3 3 3;");
    			
    	// Styling 
    	DropShadow shadow = new DropShadow();
    	shadow.setOffsetX(3.0);
    	shadow.setOffsetY(3.0);
    	shadow.setColor(Color.BLACK);
    	title.setEffect(shadow);
    	title.setStyle("-fx-text-fill: #FFD300;");
    	main_navbar.setStyle("-fx-border-color: #FFD300; -fx-border-width: 3 3 3 3;");
    	sidebar.setStyle("-fx-border-color: #FFD300; -fx-border-width: 0 0 3 3;");
    	back.setStyle("-fx-background-color: #0C3EFF; -fx-text-fill: #FFFFFF; -fx-border-color: #FFD300; -fx-border-width: 2; -fx-border-radius: 5;");
    	
    	
    	sidebar.getChildren().addAll(back);
    	main_navbar.getChildren().addAll(title);
    	pane.setBackground(new Background(home_image));
    	pane.setLeft(sidebar);
    	pane.setTop(main_navbar);
    	pane.setCenter(item_display_with_scroll);
		return pane;
	}
}
	