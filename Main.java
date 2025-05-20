package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
	private Stage primaryStage;
	private static String name;
	private double balance;

    @Override
    public void start(Stage pStage) throws Exception{
    	primaryStage = pStage;
    	Image icon = new Image("file:/F:/Java/Clothes Basket/imgs/icon2.png");
    	
    	Scene login = new Scene(new LogIn(this).getLogIn(),800,600);
    	primaryStage.setScene(login);
    	primaryStage.setTitle("Clothes Basket");
    	primaryStage.setResizable(false);
    	primaryStage.getIcons().add(icon);
    	primaryStage.show();
    	
    }
    
    public void switchToMainWindow() {
        Scene scene = new Scene(new MainWindow(this).getPane(), 800, 600);
        primaryStage.setScene(scene);
    }
    
    public void switchToBalanceWindow() {
    	Scene scene = new Scene(new BalanceWindow(this).getPane(), 800, 600);
    	primaryStage.setScene(scene);
    }
    
    public void switchToStoreWindow(String gender) {
    	Scene scene = new Scene(new StoreWindow(this,gender).getPane(), 800, 600);
    	primaryStage.setScene(scene);
    }
    
    public void switchToClothWindow(int id) {
    	Scene scene = new Scene(new ClothWindow(this).getPane(id), 800, 600);
    	primaryStage.setScene(scene);
    }
    
    public void switchToCartWindow() {
    	Scene scene = new Scene(new CartWindow(this).getPane(), 800, 600);
    	primaryStage.setScene(scene);
    }
    
    public void switchToMorFWindow() {
    	Scene scene = new Scene(new MorFWindow(this).getPane(), 800, 600);
    	primaryStage.setScene(scene);
    }
    
    public void switchToLoadingWindow(boolean login) {
    	Scene scene = new Scene(new LoadingWindow(this, login).getPane(), 800, 600);
    	primaryStage.setScene(scene);
    }
    
    

    public static void main(String[] args) {
        launch(args);
    }

	public Stage getStage() {
		return primaryStage;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name; 
	}
	
	public double getBalance() {
		return balance;
	}
	
     
	public void setBalance() {
		try {
			boolean has_balance = false;
			File file = new File("log2.txt");
			Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] credentials = line.split(",");
                if(credentials[0].equals(name)) {
                	has_balance = true;
                	balance = Double.parseDouble(credentials[1]);
                }
            }
            
            input.close();  
            
            if(!has_balance) {
            	balance = 0.0;
            }
		} catch (FileNotFoundException exc) {
            System.out.println("File not found.");
            exc.printStackTrace();
        } catch (IOException exc2) {
        	 System.out.println("Error Occured.");
             exc2.printStackTrace();
        }
	}
	
	public void setBalance(double balance, boolean is_checkout) {
		boolean has_added = true;
		try {
		this.balance = balance;
		File originalFile = new File("log2.txt");
        File tempFile = new File("temp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(originalFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String line;
        while ((line = reader.readLine()) != null) {
        	String[] credentials = line.split(",");
            if (credentials[0].equals(name)) {
                writer.write(credentials[0] + "," + balance);
            } else {
                writer.write(line);
            }
            writer.newLine();
        }

        reader.close();
        writer.close();

        if (originalFile.delete()) {
            tempFile.renameTo(originalFile);
	}
		} catch(FileNotFoundException exc) {
			has_added = false;
		} catch(IOException exc) {
			has_added = false;
	}
		if(has_added && !is_checkout) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Info");
		alert.setHeaderText("Balance Information");
		alert.setContentText("Balance Added Successfully!");
		alert.showAndWait();
		} else if(!has_added) {
			System.out.println("An Error Occured.");
		}
		
		if(has_added && is_checkout) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Info");
			alert.setHeaderText("Checkout");
			alert.setContentText("Checked Out Successfully!");
			alert.showAndWait();
		} else if(!has_added) {
			System.out.println("An Error occured");
		}
}
}