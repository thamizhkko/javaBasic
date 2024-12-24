package swiggy;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[1;31m";
    public static final String GREEN = "\u001B[32m";
    public static final String CYAN = "\u001B[36m";
    public static final String YELLOW = "\u001B[33m";
	
	

	private List<FoodItem> cart=new ArrayList<FoodItem>();
	
	final double GST_PERCENT = 18.0 / 100;
	
	public List<FoodItem> getCart() {
		return cart;
	}

	public void additem(FoodItem item) {
		
		cart.add(item);
	}
	
	public void removeitem(FoodItem item) {
		cart.remove(item);
	}
	
	public void display_cart() {
	
		for(int i=0;i<cart.size();i++) {
			FoodItem cart_item=cart.get(i);
			
			System.out.println(CYAN+"\n"+cart_item+RESET);
			
		}
	}
	
	public double total_Bill() {
		double total=0;
		
		double delivery_charges=30;
		
		System.out.println(YELLOW+"====================== BILL ========================="+RESET);
	    System.out.println(YELLOW+"\n-----------------------------------------------------"+RESET);
		System.out.printf(RED+"%-20s %10s %10s %10s\n", "Item", "Price", "GST", "Total"+RESET);
	    System.out.println(YELLOW+"-----------------------------------------------------"+RESET);
	    	    
	    for (int i = 0; i < cart.size(); i++) {
	        FoodItem cart_value = cart.get(i);
	       
	        double base_price = cart_value.getPrice();
	                
	        double Gst = base_price * GST_PERCENT;
	        	        
	        double itemtotal = base_price + Gst;
	        	       
//	        System.out.printf("%-20s %10.2f %10.2f %10.2f\n", cart_value.getName(), base_price, Gst, itemtotal);
	        System.out.println(CYAN+String.format("%-20s %10.2f %10.2f %10.2f\n", cart_value.getName(),base_price,Gst,itemtotal)+RESET);
	        
	        // Add the item's total to the overall total
	        total += itemtotal;
	        
	          }
	    
	    total+=delivery_charges; 
	    
	    System.out.println(YELLOW+"====================================================="+RESET);
	    System.out.println(String.format("%-20s %30.2f\n","Delivery Charges : ", delivery_charges));
//	    System.out.printf("%-20s %30.2f\n", "Total Bill (incl. GST): ", total);
	    System.out.println(GREEN+String.format("%-20s %30.2f\n", "Total Bill (incl. GST):", total)+RESET);
	    System.out.println(YELLOW+"-----------------------------------------------------"+RESET);
	    return total;
	}
	
	
}
