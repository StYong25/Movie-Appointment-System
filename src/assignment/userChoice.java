package assignment;
import java.util.InputMismatchException;
import java.util.*;

public class userChoice {
	//validate the input
	public static int valiUserChoice(Scanner input, int available_choice ) {
		int min_choice = 1;
		int user_choice =0;
		
		String range = "1 to "+available_choice;
		if (available_choice == 2)
			range = "1 or 2";
		do {
			try {
				System.out.println("Choose "+range+">>");
				user_choice = input.nextInt();
				
				if (user_choice<min_choice ||user_choice>available_choice) { //invalid input that are int
					System.out.println("Please enter "+ range + " only");
				}
			}catch( InputMismatchException e){ //invalid input that are not int
				System.out.println("Please input valid choices from "+range+" only");
				user_choice = -1;
			}
		}while(user_choice< min_choice ||user_choice > available_choice);
		return user_choice;
	}
	
	public static void exitSystem() {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("Thank you for using our system!");
		System.out.println(" ________  ________  ________  ________  ________      ___    ___ _______      \r\n"
				+ "|\\   ____\\|\\   __  \\|\\   __  \\|\\   ___ \\|\\   __  \\    |\\  \\  /  /|\\  ___ \\     \r\n"
				+ "\\ \\  \\___|\\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\_|\\ \\ \\  \\|\\ /_   \\ \\  \\/  / | \\   __/|    \r\n"
				+ " \\ \\  \\  __\\ \\  \\\\\\  \\ \\  \\\\\\  \\ \\  \\ \\\\ \\ \\   __  \\   \\ \\    / / \\ \\  \\_|/__  \r\n"
				+ "  \\ \\  \\|\\  \\ \\  \\\\\\  \\ \\  \\\\\\  \\ \\  \\_\\\\ \\ \\  \\|\\  \\   \\/  /  /   \\ \\  \\_|\\ \\ \r\n"
				+ "   \\ \\_______\\ \\_______\\ \\_______\\ \\_______\\ \\_______\\__/  / /      \\ \\_______\\\r\n"
				+ "    \\|_______|\\|_______|\\|_______|\\|_______|\\|_______|\\___/ /        \\|_______|\r\n"
				+ "                                                     \\|___|/                   ");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		//art for goodbye
	}
	
	
}
