package swiggy;

public class FoodItem {

	private String  name;
	
	private double price;
	
	public  FoodItem(String name,double price) {
		
		this.name=name;
		this.price=price;
	}
	
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
	public String toString() {
		
		return String.format( "%-25s --$%6.2f",name,price);
	}
	
}
