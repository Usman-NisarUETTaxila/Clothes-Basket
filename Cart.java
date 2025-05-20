package main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Cart {
	private static ArrayList<Cloth> cart = new ArrayList<>();
	
	public static void addToCart(Cloth c) {
		cart.add(c);
	}
	
	public static ArrayList<Cloth> getCart() {
		return cart;
	}
	
	public static void removeFromCart(int id) {
		for(int i=0;i<cart.size();i++) {
			if(cart.get(i).getId()==id) {
				cart.remove(i);
			}
		}
	}
	
	public static void displayCart() {
		for(Cloth cloth:cart) {
			System.out.println(cloth);
		}
	} 
	
	public static double calculatePrice() {
		double price = 0.0;
		if(cart.size()>=1) {
		for(Cloth cloth:cart) {
			price+=cloth.getPrice();
		}
		}
		return price;
	}
	
	public static void checkout(Main main) {
		double total_price = calculatePrice();
		double balance = main.getBalance();
		if((total_price < balance) && (cart.size()>=1)) {
			balance -= total_price;
			main.setBalance(balance,true);
				for(Cloth cloth:cart) {
					try {
						FileWriter history_writer = new FileWriter("log3.txt", true);
						history_writer.write("\n" + main.getName() + " Bought " + cloth);
						history_writer.close();
						
					} catch (IOException exc) {
						System.out.println("An error occurred.");
						exc.printStackTrace();
					}
				}
				cart.clear();
		}
	}
}
