package main;

import java.util.ArrayList;

import javafx.scene.image.Image;

public class Clothes {
	private static ArrayList<Cloth> clothes = new ArrayList<>();
	
	public static void initialize() {
		clothes.clear();
		clothes.add(new Cloth(new Image("file:/F:/Java/Clothes Basket/imgs/1.jpg"),"Slim Fit Tee","Male","Nike", "T-Shirt", "M", "Blue", 30.00, "Cotton","A sleek, athletic black T-shirt made from breathable cotton. Ideal for workouts or casual wear, offering comfort with a modern slim fit."));
        clothes.add(new Cloth(new Image("file:/F:/Java/Clothes Basket/imgs/2.jpg"),"Classic Polo","Male" ,"Ralph Lauren", "Polo", "L", "White", 60.00, "Cotton","A timeless white cotton polo shirt, tailored for a relaxed yet polished look. Perfect for smart-casual occasions."));
        clothes.add(new Cloth(new Image("file:/F:/Java/Clothes Basket/imgs/3.jpg"),"Denim Jeans","Male" ,"Levi's", "Pants", "32", "Blue", 80.00, "Denim","Iconic blue denim jeans with a classic fit. Durable and stylish, suitable for daily wear and rugged activities."));
        clothes.add(new Cloth(new Image("file:/F:/Java/Clothes Basket/imgs/4.jpg"),"Hooded Sweatshirt","Male" ,"Adidas", "Sweatshirt", "XL", "Gray", 50.00, "Fleece","A cozy gray fleece hoodie that combines comfort and sporty style. Great for cool weather or layering during workouts."));
        clothes.add(new Cloth(new Image("file:/F:/Java/Clothes Basket/imgs/5.jpg"),"Running Shorts","Male" ,"Puma", "Shorts", "M", "Navy", 25.00,"Polyester","Lightweight navy polyester shorts designed for active movement. Breathable fabric keeps you cool during high-intensity workouts."));
        clothes.add(new Cloth(new Image("file:/F:/Java/Clothes Basket/imgs/6.jpg"),"Formal Shirt","Male" ,"Zara", "Shirt", "L", "Light Blue", 40.00, "Cotton","A light blue cotton shirt with a clean, structured look. Ideal for office wear or formal events, pairing well with trousers or suits."));
        clothes.add(new Cloth(new Image("file:/F:/Java/Clothes Basket/imgs/7.jpg"),"Winter Jacket","Male" ,"North Face", "Jacket", "M", "Black", 130.00, "Nylon","A black nylon jacket built for warmth and weather resistance. Designed to protect you in cold, windy, or wet conditions."));
        clothes.add(new Cloth(new Image("file:/F:/Java/Clothes Basket/imgs/8.jpg"),"Yoga Pants","Female","Lululemon", "Leggings", "S", "Charcoal", 90.00, "Spandex","Stretchy, charcoal-colored leggings made from premium spandex. Designed for yoga, gym, or everyday comfort."));
        clothes.add(new Cloth(new Image("file:/F:/Java/Clothes Basket/imgs/9.jpg"),"Summer Dress","Female","H&M", "Dress", "M", "Red", 50.00, "Linen","A lightweight red linen dress that radiates summer charm. Breezy, breathable, and perfect for casual outings or vacations."));
        clothes.add(new Cloth(new Image("file:/F:/Java/Clothes Basket/imgs/10.jpg"),"Cargo Pants","Male" ,"Uniqlo", "Pants", "34", "Olive", 60.00, "Cotton","Olive green cotton cargo pants with practical pockets and a relaxed fit. Suitable for outdoor use or street-style fashion."));
        clothes.add(new OnSaleCloth(new Image("file:/F:/Java/Clothes Basket/imgs/11.jpeg"),"Graphic Tee","Male","H&M","T-Shirt","M","Black",40.00,"Cotton","A casual black cotton T-shirt with bold graphic print. Comfortable and perfect for daily wear."));
        clothes.add(new Cloth(new Image("file:/F:/Java/Clothes Basket/imgs/12.jpeg"),"Leather Jacket","Male","Zara", "Jacket", "L", "Black", 150.00, "Leather","Stylish black leather jacket with a snug fit. Ideal for a night out or adding edge to any outfit."));
        clothes.add(new Cloth(new Image("file:/F:/Java/Clothes Basket/imgs/13.jpeg"),"Track Pants","Male","Nike", "Pants", "M", "Black", 45.00, "Polyester","Comfortable black track pants perfect for workouts or lounging, made with breathable quick-dry fabric."));
        clothes.add(new Cloth(new Image("file:/F:/Java/Clothes Basket/imgs/14.jpeg"),"Checkered Shirt","Male","Uniqlo", "Shirt", "L", "Red", 35.00, "Cotton","A casual red and black checkered shirt, great for layering or wearing on its own."));
        clothes.add(new Cloth(new Image("file:/F:/Java/Clothes Basket/imgs/15.jpeg"),"Swim Trunks","Male","Speedo", "Shorts", "M", "Black", 28.00, "Polyester","Quick-dry black swim trunks designed for performance and comfort in water."));
        clothes.add(new OnSaleCloth(new Image("file:/F:/Java/Clothes Basket/imgs/16.jpeg"),"Henley Shirt","Male","Old Navy", "Shirt", "M", "Black", 22.00, "Cotton","A soft Black Henley shirt with button-up collar, combining casual style and comfort."));
        clothes.add(new Cloth(new Image("file:/F:/Java/Clothes Basket/imgs/17.jpeg"),"High-Waist Jeans","Female","Levi's", "Pants", "28", "Dark Blue", 70.00, "Denim","Trendy dark blue high-waist jeans that hug the figure while offering comfort."));
        clothes.add(new Cloth(new Image("file:/F:/Java/Clothes Basket/imgs/18.jpeg"),"Button-Up Shirt","Female","Mango", "Shirt", "M", "Sky Blue", 42.00, "Cotton","A classic sky blue button-up shirt offering a refined look. Perfect for business casual or a polished everyday style."));
        clothes.add(new OnSaleCloth(new Image("file:/F:/Java/Clothes Basket/imgs/19.jpeg"),"Peplum Blouse","Female","Zara", "Shirt", "S", "Ivory", 39.00, "Polyester","Chic ivory blouse with a peplum waist. A modern choice for dressing up jeans or trousers."));
        clothes.add(new Cloth(new Image("file:/F:/Java/Clothes Basket/imgs/20.jpeg"),"Wide-Leg Trousers","Female","Uniqlo", "Pants", "M", "Beige", 55.00, "Linen","Breathable beige linen trousers with a wide-leg cut. Lightweight and stylish for summer."));
        clothes.add(new Cloth(new Image("file:/F:/Java/Clothes Basket/imgs/21.jpeg"),"Skinny Jeans","Female","Levi's", "Pants", "28", "Dark Blue", 68.00, "Denim","Dark blue skinny jeans with stretch for comfort. A wardrobe essential for any occasion."));
        clothes.add(new Cloth(new Image("file:/F:/Java/Clothes Basket/imgs/22.jpeg"),"Denim Jacket","Female","H&M", "Jacket", "M", "Light Blue", 65.00, "Denim","Trendy light blue denim jacket with button front. Ideal for layering in all seasons."));
        clothes.add(new OnSaleCloth(new Image("file:/F:/Java/Clothes Basket/imgs/23.jpeg"),"Faux Leather Jacket","Female","Forever 21", "Jacket", "S", "Black", 75.00, "Faux Leather","A sleek black faux leather jacket that adds edge to any outfit."));
        clothes.add(new Cloth(new Image("file:/F:/Java/Clothes Basket/imgs/24.jpeg"),"High-Rise Leggings","Female","Lululemon", "Leggings", "M", "Gray", 88.00, "Spandex","Supportive gray high-rise leggings built for flexibility and comfort during any workout."));
        clothes.add(new Cloth(new Image("file:/F:/Java/Clothes Basket/imgs/25.jpeg"),"Printed Leggings","Female","Nike", "Leggings", "S", "Black/White", 72.00, "Polyester","Bold black and white printed leggings. Moisture-wicking and eye-catching for activewear fashion."));
        clothes.add(new Cloth(new Image("file:/F:/Java/Clothes Basket/imgs/26.jpeg"),"Wrap Dress","Female","Zara", "Dress", "M", "Green", 58.00, "Cotton","Soft green cotton wrap dress that flatters all body types. Perfect for both daytime and evening."));
        clothes.add(new OnSaleCloth(new Image("file:/F:/Java/Clothes Basket/imgs/27.jpeg"),"Pleated Midi Dress","Female","H&M", "Dress", "L", "Blush Pink", 48.00, "Polyester","Elegant blush pink pleated dress that flows with grace. Ideal for spring events or special occasions."));
        clothes.add(new Cloth(new Image("file:/F:/Java/Clothes Basket/imgs/28.jpeg"),"Casual Tee","Female","Uniqlo", "T-Shirt", "M", "Lavender", 22.00, "Cotton","A soft lavender cotton T-shirt with a relaxed fit. Comfortable and breathable for everyday wear."));
        clothes.add(new OnSaleCloth(new Image("file:/F:/Java/Clothes Basket/imgs/29.jpeg"),"Linen Shorts","Female","H&M", "Shorts", "S", "Khaki", 30.00, "Linen","Lightweight khaki linen shorts with a high-waist design. Great for summer outings and casual style."));


	}
	
	public static void showClothes() {
		for(Cloth c:clothes) {
			if(c!=null)
				System.out.println(c);
		}
	}
	
	public static ArrayList<Cloth> getClothes() {
		return clothes;
	}
	
	public static void removeCloth(int id) {
		
		  for(int i=0;i<clothes.size();i++) {
			  if(clothes.get(i).getId()==id) {
				  clothes.remove(i);
			  }
		  }

    }
}
