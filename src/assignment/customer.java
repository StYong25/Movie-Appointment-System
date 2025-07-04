package assignment;
import java.util.*;
import java.io.*;
import java.text.ParseException;

public class customer {
	private static final Scanner input = new Scanner(System.in);
	
	public static void portalCustomer() throws ParseException {
		int choice= 0;
		String role = "Customer";
		do {
			Scanner input = new Scanner(System.in);
			System.out.println("1> Register Account");
			System.out.println("2> Login Account");
			System.out.println("3> Back");
			System.out.println(">>>>>>>>>>>>>>>>>>");
			choice = userChoice.valiUserChoice(input, 3);
			switch(choice) {
			case 1:
				userProfile.registerAcc(role);
				break;
			case 2:
				userProfile.loginAcc(role);
				break;
			case 3:
				Movie_main.main(null);
			}
		}while (choice<1 || choice>2);
	}
	
	
}
