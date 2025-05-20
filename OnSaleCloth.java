package main;

import javafx.scene.image.Image;

public class OnSaleCloth extends Cloth {
	public OnSaleCloth() {
		id = 0;
		img=null;
		name = "";
		brand = "";
		category = "";
		size = "";
		color = "";
		price = 0.0;
		material="";
		description="";
		gender="";
		isOnSale=true;
	}
	
	public OnSaleCloth(Image img, String name, String gender, String brand, String category, String size,
            String color, double price, String material, String description) {
		super(img,name,gender,brand,category,size,color,price,material,description);
		isOnSale=true;
	}
	
	public OnSaleCloth(OnSaleCloth c) {
		id = c.getId();
		img = c.getImg();
		name = c.getName();
		brand = c.getBrand();
		category = c.getCategory();
		size = c.getSize();
		color = c.getColor();
		price = c.getPrice();
		material = c.getMaterial();
		description = c.getDescription();
		gender = c.getGender();
		isOnSale=true;
	}
	
	@Override
	public double getPrice() {
		return price/2.0;
	}
}
