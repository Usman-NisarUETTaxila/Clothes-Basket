package main;

import java.util.Random;

import javafx.scene.image.Image;

public class Cloth {
	protected int id; 
	protected Image img;
	protected String name;        
	protected String brand; 
	protected String category;    
	protected String size;        
	protected String color;        
	protected double price;           
	protected String material;
	protected String description;
	protected String gender;
	protected boolean isOnSale;  
	
	public Cloth() {
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
		isOnSale=false;
	}
	
	public Cloth(Image img, String name, String gender, String brand, String category, String size,
            String color, double price, String material, String description) {
		Random rand = new Random();
		this.id = rand.nextInt(999999);
		this.img = img;
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.size = size;
		this.color = color;
		this.price = price;
		this.material = material;
		this.description=description;
		this.gender = gender;
		isOnSale=false;
	}
	
	public Cloth(Cloth c) {
		this.id = c.getId();
		this.img = c.getImg();
		this.name = c.getName();
		this.brand = c.getBrand();
		this.category = c.getCategory();
		this.size = c.getSize();
		this.color = c.getColor();
		this.price = c.getPrice();
		this.material = c.getMaterial();
		this.description = c.getDescription();
		this.gender = c.getGender();
		isOnSale=false;
	}
	
	
	@Override
	public String toString() {
	    return name + " (" + size + ", " + color + ") - $" + price;
	}
	
	// Getters
	public int getId() {
		return id;
	}
	
	public Image getImg() {
		return img;
	}
	
	public String getName() {
		return name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getSize() {
		return size;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getMaterial() {
		return material;
	}
	
	public String getDescription() {
		return description;
	}
	
	public double getPrice() {
		return price;
	}
	
	public boolean check_on_sale() {
		return isOnSale;
	}
	
	// Setters	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setMaterial(String material) {
		this.material = material;
	}
	
	public void setPrice(double price) {
		if(price > 0) {
			this.price = price;
		}
	}
}
