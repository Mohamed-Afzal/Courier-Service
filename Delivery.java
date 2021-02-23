package workout;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Delivery {
	public static void main(String[] args)throws Exception {
		System.out.println("**WELCOME TO COURIER SERVICE*");
		System.out.println("****");
		DateAndTime dt = new DateAndTime();
		System.out.println("****");
		Calculation calc=new Calculation();
		calc.getDist();
	}       
}
class DateAndTime{
	public DateAndTime() {
		//date now
		LocalDate date=LocalDate.now();
		System.out.println("TODAY:"+date);
		System.out.println("****");
		//time now
		LocalTime time =LocalTime.now();
		System.out.println("TIME:"+time);
		
	}
}
class Calculation{
	public void getDist() {
	System.out.println("Speed will be : 100 Miles/Hr");	
	System.out.println("****");
	System.out.println("Pls Enter the Distance..(in MILES):");
	Scanner scan = new Scanner(System.in);	
	float miles = scan.nextFloat();
	System.out.println("Distance is:"+miles+"miles");
	System.out.println("****");
	float a=miles/45;
	System.out.println("Your Package will Reach your Destination in:"+a+"Hrs");
	
	}
}