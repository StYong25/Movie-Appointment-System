package assignment;
import java.text.ParseException;
import java.util.*;

public class Movie_main {

	public static void main(String[] args) throws ParseException {
		int choice = 0;
		String role;
		do {
			final Scanner input = new Scanner(System.in);
			System.out.println(" __  __     ______     __         __         ______   \r\n"
					+ "/\\ \\_\\ \\   /\\  ___\\   /\\ \\       /\\ \\       /\\  __ \\  \r\n"
					+ "\\ \\  __ \\  \\ \\  __\\   \\ \\ \\____  \\ \\ \\____  \\ \\ \\/\\ \\ \r\n"
					+ " \\ \\_\\ \\_\\  \\ \\_____\\  \\ \\_____\\  \\ \\_____\\  \\ \\_____\\\r\n"
					+ "  \\/_/\\/_/   \\/_____/   \\/_____/   \\/_____/   \\/_____/\r\n"
					+ "                                                      \r\n"
					+ " __    __     ______     __   __   __     ______      \r\n"
					+ "/\\ \"-./  \\   /\\  __ \\   /\\ \\ / /  /\\ \\   /\\  ___\\     \r\n"
					+ "\\ \\ \\-./\\ \\  \\ \\ \\/\\ \\  \\ \\ \\'/   \\ \\ \\  \\ \\  __\\     \r\n"
					+ " \\ \\_\\ \\ \\_\\  \\ \\_____\\  \\ \\__|    \\ \\_\\  \\ \\_____\\   \r\n"
					+ "  \\/_/  \\/_/   \\/_____/   \\/_/      \\/_/   \\/_____/   ");
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println("           WELCOME TO XX MOVIE MANGEMENT SYSTEM");
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println("1> Staff");
			System.out.println("2> Customers");
			System.out.println("3> Exit");
			System.out.println("Please choose your role ");
			choice = userChoice.valiUserChoice(input,3);//validate user input
			switch(choice) {
			case 1://user is staff
				admin.portalStaff();
				break;
			case 2://user is customer
				role = "Customer";
				customer.portalCustomer();
				break;
			case 3:
				userChoice.exitSystem();
			}
			
		}while(choice != 3);
	}

}
