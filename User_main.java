package swiggy;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import exception.NamemismatchException;
import exception.PasswordmismatchException;

public class User_main {

	String new_name;
	
	String new_pass;
	
	Scanner sc=new Scanner(System.in);
	
	Map<Integer, Swiggy_user>m=new HashMap<Integer, Swiggy_user>();
	
	public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String CYAN = "\u001B[36m";
		
	public boolean user_login() throws InterruptedException  {
		
		m.put(1, new Swiggy_user("admin", "pass"));
		m.put(2, new Swiggy_user("Username", "Oct@1"));	
		m.put(30, new Swiggy_user("kko", "kko"));
		
		while(true){
		
			System.out.println(RED+"\n*******Swiggy Login*******"+RESET);
			System.out.println("===========================");
			Thread.sleep(1000);
			System.out.println(CYAN+"\n  1.Exsisting user\n  \n  2.New user"+RESET);
		System.out.print("\nEnter the choice (1 or 2): ");
		int input=sc.nextInt();
		sc.nextLine();
		
		switch(input) {
		
		case 1:{
			boolean b=true;
			boolean validUser = false;
			while(b){
			
			System.out.print(" \nEnter Username: ");
			
			String user_name=sc.nextLine();
			
			System.out.print(" \nEnter Password: ");
			
			String user_pass=sc.nextLine();
			
			try {
			for(Entry<Integer, Swiggy_user> e:m.entrySet()) {
				if(e.getValue().getUsername().equalsIgnoreCase(user_name)&&(e.getValue().getPassword().equals(user_pass))) {
					
					validUser= true;
					System.out.println(GREEN+"\n 🎉 User Login successfull!"+RESET);
					break;				
				}
			}
				
				 if (!validUser) {
	                    // If no match is found, throw an exception
	                    throw new NamemismatchException(RED+"Invalid username or password"+RESET);
	                }		
			
			return true;
			
			}catch(NamemismatchException e) {
				System.out.println(e);
			}
			}   //while loop
			
		break;}   //case 1 ends
		
		case 2:{
			
			boolean b=true;
			while(b){
			System.out.print(" \nEnter your username: ");
			
			 new_name=sc.nextLine();
						
			try {
			if(new_name.length()<5) {
				throw new NamemismatchException(RED+"Enter atleast 5 characters"+RESET);
			}
					
			if(!(new_name.charAt(0)>='A'&&new_name.charAt(0)<='Z')) {
				throw new NamemismatchException(RED+"Enter 1st letter caps"+RESET);
				
			}
						
			for(int i=0;i<new_name.length();i++) {
				char ch=new_name.charAt(i);
			
				if(ch>='0'&&ch<='9') {
					throw new NamemismatchException(RED+"Username should not contain numbers"+RESET);
				}
					
			}
				
			b=false;      //no exception found break the loop
						
			}catch(NamemismatchException e){
				System.out.println(e);
			
			}
			
			}    // user_name loop		
			
			//password --
			
			b=true;
			while(b) {
			System.out.print(" \nEnter your password :");
			
			 new_pass=sc.nextLine();
						
			try {
			if(new_pass.length()<4) {
				throw new PasswordmismatchException(RED+"Enter atleast 5 characters"+RESET);
			}
				
			if(password_check(new_pass)) {
				
			}else {
				throw new PasswordmismatchException(RED+"Invalid  password:contain 1caps,1special char,1 number"+RESET);
			}
			
			b=false;   //no exception found break the loop
			
			
			}catch(PasswordmismatchException p) {
				System.out.println(p);
			}
			
			}   //pass loop
			for(Entry<Integer, Swiggy_user> a:m.entrySet()) {
			if(!(a.getValue().getUsername().equalsIgnoreCase(new_name)&&(a.getValue().getPassword().equalsIgnoreCase(new_pass)))) {
			int id=m.size()+1;
			
			m.put(id, new Swiggy_user(new_name, new_pass));
			
			System.out.println(GREEN+"\n 🎉 Username created successfully!"+RESET);
//		 return true;
			break;
			
			}else {
				System.out.println(" username or password already exsists");
			}
			
			}
			break;}  //case 2 ends		
		
		default :{
			
			System.out.println(RED+" invalid input"+RESET);
		break;}
			}  //switch ends
		}		
//	return false;			
	}
	

	public boolean password_check(String password) {
		
		boolean uppercase=false;
		boolean  number=false;
		boolean specialchar=false;
		
		for(int j=0;j<password.length();j++) {
			char pass=new_pass.charAt(j);
		
			if(pass>='A' && pass<='Z') {
				uppercase=true;
			}
			
			if(pass>='0' && pass<='9') {
				number=true;
			}
			
			if((!(pass>='A' && pass<='Z'))  && (!(pass>='a' && pass<='z')) &&(!(pass>'0' && pass<'9'))){
				specialchar=true;
			}
			
		}
		
		return uppercase && number && specialchar;
			}	
	
}
