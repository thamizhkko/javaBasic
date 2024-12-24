package swiggy;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	
	double total;
	
	private List<FoodItem>kfc=new ArrayList<FoodItem>();
	
	private List<FoodItem>mcd=new ArrayList<FoodItem>();
	
	private List<FoodItem>dominos=new ArrayList<FoodItem>();
	
	Order order=new Order();
	
	public static final String CYAN = "\u001B[36m";
	public static final String RESET = "\u001B[0m";
	
	public Restaurant() {
		
		kfc.add(new FoodItem("Chicken Popcorn",160));
		kfc.add(new FoodItem("Zinger Burger", 220));
		kfc.add(new FoodItem("Hot Wings", 240));
		
		mcd.add(new FoodItem("Mcspicy Burger", 219));
		mcd.add(new FoodItem("French Fries", 140));
		mcd.add(new FoodItem("Mcchicken Combo", 276));
		
		dominos.add(new FoodItem("Margherita",150));
		dominos.add(new FoodItem("Chicken Fiesta", 350));
		dominos.add(new FoodItem("Chicken Pepperoni", 629));
			
	}
	
	public List<FoodItem> getKfc() {
		return kfc;
	}

	public List<FoodItem> getMcd() {
		return mcd;
	}
	
	public List<FoodItem> getDominos() {
		return dominos;
	}

	public void Menudisplay(List<FoodItem> hotel) {
		
		for(int i=0;i<hotel.size();i++) {
			FoodItem it=hotel.get(i);
			System.out.println(CYAN+"\n"+it+RESET);
		}
	}
	
	public void displaycart() {
		order.display_cart();
	}
	
	public double totalbill() {
		
		return this.total=order.total_Bill();
	}
	
	public boolean item_check(String itemname, List<FoodItem> list,int quantity) {
		
		for(int i=0;i<list.size();i++) {
			FoodItem item=list.get(i);
		
			if(item.getName().equalsIgnoreCase(itemname)) {
				for(int j=0;j<quantity;j++) {
				order.additem(item);
			}return true;			
				}				
		}	
		return false;
	}
	
public boolean item_remove(String itemname,List<FoodItem> list) {
	
	for(int i=0;i<list.size();i++) {
		FoodItem item=list.get(i);
	
		if(item.getName().equalsIgnoreCase(itemname)) {
			order.removeitem(item);
			return true;			
			}				
	}	
	
	return false;
}
	
public boolean isCartEmpty() {
	
	return order.getCart().isEmpty();
}

public List<FoodItem> getCart() {
	return order.getCart();
}

	
}
