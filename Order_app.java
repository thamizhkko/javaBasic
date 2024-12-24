package swiggy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

//import javax.lang.model.element.QualifiedNameable;

//import exception.NamemismatchException;


public class Order_app  {
	
	static String yrn;
	static int pay;
	static boolean orderplaced=false;
	static double user_entered_bill;
	static int user_entered_otp;
	
	public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[1;31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String CYAN = "\u001B[36m";
    public static final String PURPLE = "\u001B[45m";
    public static final String GREEN = "\u001B[32m";
	
	public static void main(String[] args) throws InterruptedException {
		
		Restaurant resta=new Restaurant();
//		Order order=new Order();
		
		User_main ref=new User_main();
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("\n"+RED+"\t\t\t\t******Welcome to Swiggy******"+RESET);
		System.out.println("\n\t\t\t=============================");
		Thread.sleep(2000);
			
		boolean b=true;
			
		if(ref.user_login()) {
		
		while(b) {
		
			System.out.println(YELLOW+"\n===================\nChoose the Hotels 🏨\n==================="+RESET);
		System.out.println(CYAN+"\n    1.KFC 🍗\n    \n    2.McDonald's 🍔\n    \n    3.Domino's 🍕\n    \n    4.cart 🛒\n    \n    5.Bill Generator 🧾\n    \n    6.Exit 🛑"+RESET);
		
		System.out.print("\nEnter the choice : ");
		int user_hotel=sc.nextInt();
		
		switch(user_hotel) {
		
		case 1:{      
			
			 if (orderplaced) {
                 System.out.println("Order already placed. You cannot place another order.");
                 break;
             }
			
			while(true) {
				System.out.println(PURPLE+"\n***** Welcome to KFC 🍗 *****"+RESET);
			System.out.println(YELLOW+" \n====================\nchoose the menu\n===================="+RESET);
			System.out.println();
			//menu display
			resta.Menudisplay(resta.getKfc());
			sc.nextLine();
			System.out.print("\nEnter ItemName :");
			String item_name=sc.nextLine();
			
			System.out.print("\nEnter the Quantity :");	
			int quantity=sc.nextInt();
			
			if(resta.item_check(item_name,resta.getKfc(),quantity)) {
				System.out.println(GREEN+"\n***** 🎉 added to cart. *****"+RESET);
			}else {
				System.out.println(RED+"item not found"+RESET);
			}
			
			System.out.print("\nDo you want to add another item? (yes/no):");
			String yrn=sc.next();
			if(yrn.charAt(0)=='n') {
				break;
			}
			}     //inner loop
			
			System.out.println(GREEN+"\nyour total items:"+RESET);
			resta.displaycart();
			System.out.print("\nDo you want to place the order or remove any item? (yes/no):");
			String yrn=sc.next();
			if(yrn.charAt(0)=='n') {
				System.out.println("\nwhich item you want to remove");
				resta.displaycart();
				sc.nextLine();
				System.out.print("\nenter itemname : ");
				String remove_item=sc.nextLine();
				if(resta.item_remove(remove_item, resta.getKfc())) {
					System.out.println(GREEN+"\nitem removed suuccessfully"+RESET);
				}
			}else if(yrn.charAt(0)=='y') {
			processcart(resta, sc);
			}else {
				System.out.println("Please enter YES or NO");
			}
					
			}   //case 1 ends here
		break;
                                
		                                  //mcd		
		
		case 2:{
			
			 if (orderplaced) {
                 System.out.println("\nOrder already placed. You cannot place another order.");
                 break;
             }
			
			while(true) {
				System.out.println(PURPLE+"\n***** Welcome to McDonald's 🍔 *****"+RESET);
				System.out.println(YELLOW+" \n====================\nchoose the menu\n===================="+RESET);
				System.out.println();
				//menu display
				resta.Menudisplay(resta.getMcd());
				sc.nextLine();
				System.out.print("\nEnter ItemName :");
				String item_name=sc.nextLine();
				
				
				System.out.print("\nEnter the quantity :");
				
				int quantity=sc.nextInt();
				
				if(resta.item_check(item_name,resta.getMcd(), quantity)) {
					System.out.println(GREEN+"\n***** 🎉 added to cart. *****"+RESET);
				}else {
					System.out.println(RED+"item not found"+RESET);
				}
				
				System.out.print("\nDo you want to add another item? (yes/no):");
				String yrn=sc.next();
				if(yrn.charAt(0)=='n') {
					break;
				}
				}     //inner loop
				
				System.out.println(GREEN+"\nyour total items:"+RESET);
				resta.displaycart();
				System.out.print("\nDo you want to place the order or remove any item? (yes/no):");
				String yrn=sc.next();
				if(yrn.charAt(0)=='n') {
					System.out.println("\nwhich item you want to remove");
					resta.displaycart();
					sc.nextLine();
					System.out.print("\nenter itemname : ");
					String remove_item=sc.nextLine();
					if(resta.item_remove(remove_item, resta.getMcd())) {
						System.out.println(GREEN+"\n*****Item removed from cart suuccessfully*****"+RESET);
					}
				}
				
				processcart(resta, sc);
					
				
				break;	}    // case 2 ends here
				              
		               //domino's                 
		
		case 3:{
			
			 if (orderplaced) {
                 System.out.println("\nOrder already placed. You cannot place another order.");
                 break;
             }
			
			while(true) {
				System.out.println(PURPLE+"\n***** welcome to Domino's 🍕 *****"+RESET);
				System.out.println(YELLOW+" \n====================\nchoose the menu\n===================="+RESET);
				System.out.println();
				//menu display
				resta.Menudisplay(resta.getDominos());
				sc.nextLine();
				System.out.print("\nEnter ItemName :");
				String item_name=sc.nextLine();
					
				System.out.print("\nEnter the quantity :");
				
				int quantity=sc.nextInt();
				
				if(resta.item_check(item_name,resta.getDominos(), quantity)) {
					System.out.println(GREEN+"\n***** 🎉 added to cart. *****"+RESET);
				}else {
					System.out.println(RED+"item not found"+RESET);
				}
				
				System.out.print("\nDo you want to add another item? (yes/no):");
				String yrn=sc.next();
				if(yrn.charAt(0)=='n') {
					break;
				}
				}     //inner loop
				
				System.out.println(GREEN+"\nyour total items:"+RESET);
				resta.displaycart();
				System.out.print("\nDo you want to place the order or remove any item? (yes/no):");
				String yrn=sc.next();
				if(yrn.charAt(0)=='n') {
					System.out.println("\nwhich item you want to remove");
					resta.displaycart();
					sc.nextLine();
					System.out.print("\nenter itemname : ");
					String remove_item=sc.nextLine();
					if(resta.item_remove(remove_item, resta.getMcd())) {
						System.out.println(GREEN+"\n*****Item removed from cart suuccessfully*****"+RESET);
					}
				}
				
				processcart(resta, sc);
			
		break;}            //case 3 ends here
		
				
		case 4:{
			
			 if (orderplaced) {
                 System.out.println(YELLOW+"\n*****Order already placed. You cannot place another order.*****"+RESET);
                 System.out.println();
                 resta.displaycart();
                 break;
             }
			
			
			if (resta.isCartEmpty()) {
		        System.out.println(YELLOW+"\n*****Your cart is empty! Add items to the cart before placing an order.*****"+RESET);
		        break;
		    }
			if(!orderplaced) {
			resta.displaycart();
			System.out.println("Do you want to place the order or remove any item? (yes/no):");
			String yrn=sc.next();
			if(yrn.charAt(0)=='y') {
				processcart(resta, sc);
		}else {
			System.out.println(GREEN+"*****Thank you for Choosing Swiggy.Please visit again!!!*****"+RESET);
			break;
		}
			}		
			break;}
		
		case 5:{
				
			File obj=new File("C://SwiggyBill//bill.txt");
//			obj.mkdir();
			try {
		        FileWriter fw = new FileWriter(obj);

		        fw.write("==================== BILL ========================\n");
		        fw.write(String.format("%-20s %10s %10s %10s\n", "Item", "Price", "GST", "Total"));
		           
		        double total = 0;
		        double GST_PERCENT = 18.0 / 100;
		        double deliveryCharges = 30.00;
		        
		        for (FoodItem item : resta.getCart()) {
		            double basePrice = item.getPrice();
		            double gst = basePrice * GST_PERCENT;
		            double itemTotal = basePrice + gst;
		            total += itemTotal;
		            
		            fw.write(String.format("%-20s %10.2f %10.2f %10.2f\n", item.getName(), basePrice, gst, itemTotal));
		        }
		        
		        fw.write("===================================================\n");
		        fw.write(String.format("%-20s %30.2f\n", "Delivery Charges :", deliveryCharges));
		        fw.write(String.format("%-20s %30.2f\n", "Total Bill (incl. GST):", total + deliveryCharges));
		        		      
		        fw.close();

		        System.out.println(GREEN+"\nBill has been generated and saved as: "+RESET+ RED+ obj.getAbsolutePath()+RESET);
		    
			} catch (IOException e) {
		        System.out.println("An error occurred while generating the bill.");
		        e.printStackTrace();
		    }
						
		break;}
		
		case 6:{
			System.out.println(RED+"====================================="+RESET);
			System.out.println(GREEN+"\n ***Thank you for choosing Swiggy!***"+RESET);
			System.out.println(RED+"\n====================================="+RED);
			
			b=false;
		
			break;}
			
		default:{
			System.out.println("Invalid input! Please enter a valid input");
			break;}
		
		}          //switch loop ends here
			
		} //outer loop
		
	}else {
		System.out.println(" Invalid username or password!");
	}
	
	}

	private static void processcart(Restaurant resta,Scanner sc) throws InterruptedException {
		
		System.out.println("\nyour  bill is : ");
		resta.totalbill();
		while(true) {
		
			System.out.println();
			System.out.println(YELLOW+"=========================\nchoose the payment mode\n========================="+RESET);
			System.out.println(CYAN+"  \n1.Gpay or Paytm\n  \n2.Cash onDelivery(COD)"+RESET);
		
			System.out.print("\nEnter your Choice :");
		try {
		 pay=sc.nextInt();
//		 break;
		}catch(InputMismatchException e){
			System.out.println(RED+"Invalid input! Please enter a number."+RESET);
			sc.next();
		}
		switch(pay) {
		
		case 1:{
			
			System.out.print("\nEnter the bill amount: $");
			try { 
			user_entered_bill=sc.nextDouble();
			}catch(InputMismatchException e) {
				System.out.println(e);
				sc.next();
			}
			if(resta.total==user_entered_bill) {
				
				int sys_otp=(int) (Math.random()*90000+10000);
				System.out.println("\nGenerating your OTP, please wait..");
				Thread.sleep(3000);
				System.out.println(RED+"\nYour OTP is: "+sys_otp+RESET);
				Thread.sleep(1000);
				System.out.print("\nPlease enter the OTP: ");
				try {
				user_entered_otp=sc.nextInt();
				}catch(InputMismatchException e ){
					System.out.println(e);
				}
				if(sys_otp==user_entered_otp) {
					orderplaced=true;
					System.out.println(RED+"\n****************************************************"+RESET);
					System.out.println(GREEN+"\nThank you! Your order is confirmed and on the way."+RESET);
					System.out.println(RED+"\n****************************************************"+RESET);
					return;
				}else {
					System.out.println("Invalid OTP! Please try again.");
				}
			}else {
				System.out.println("Incorrect bill amount! Please recheck.");
			}
						
		}break;
		
		case 2:{
			
			System.out.print("\nEnter the bill amount: $");
			 user_entered_bill=sc.nextDouble();
			
			if(resta.total==user_entered_bill) {
				orderplaced=true;
				System.out.println(RED+"\n*****************************************************************************"+RED);
				System.out.println(GREEN+"\nThank you! Please keep the exact change ready. Your order will arrive soon."+GREEN);
				System.out.println(RED+"\n*****************************************************************************"+RED);
				
				return;
			}
		}break;
		
		default:{
			System.out.println(RED+"\nInvalid input! Please select a valid payment option."+RESET);
			
		}break;
		}   //switch case
		}//loop
		}

}
