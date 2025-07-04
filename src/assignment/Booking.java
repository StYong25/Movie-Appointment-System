package assignment;

import java.io.*;
import java.util.*;

public class Booking 
{	
	private ArrayList<Booking> bookings = new ArrayList<>();
	private String bookingID;
	private String customername;
	private String moviename;
	private String date;
	private String time;
	private String hall;
	private int quantity;
	private String seat;
	private double price;
	
	private static final Scanner input = new Scanner(System.in);
	private static final String bookingFile = "bookings.txt";
	
	// Assessor for bookings
	public ArrayList<Booking> getBookings()
	{
		return bookings;
	}
	public String getBookingID()
	{
		return bookingID;
	}
	public String getCustomerName()
	{
		return customername;
	}
	public String getMovieName()
	{
		return moviename;
	}
	public String getDate()
	{
		return date;
	}
	public String getTime()
	{
		return time;
	}
	public String getHall()
	{
		return hall;
	}
	public int getTicketQuantity()
	{
		return quantity;
	}
	public String getSeat()
	{
		return seat;
	}
	public double getPrice()
	{
		return price;
	}

	// Method to generate booking ID
    private String generateBookingId() 
    {
        // Get the last booking ID from Bookings.txt and generate the next one
        String latestBookingID = getLastBookingId();
        int lastBookingNum = Integer.parseInt(latestBookingID.substring(3));
        int nextBookingNum = lastBookingNum + 1;
        return "BGK" + String.format("%03d", nextBookingNum);
    }
    
	// Method to get last booking ID from Bookings.txt
    private String getLastBookingId() 
    {
        String lastestBookingID = "BGK000"; // Initialize as "BGK000" 
        try (BufferedReader reader = new BufferedReader(new FileReader(bookingFile))) 
        {
            String line;
            // Read line until the end of file
            while ((line = reader.readLine()) != null) 
            {
            	lastestBookingID = line.split(",")[0];
            }
        } 
        catch (IOException | NumberFormatException e) 
        {
            e.printStackTrace();
        }
        return lastestBookingID;
    }
    
	// The constructor for Booking
	public Booking(String customername, String moviename, String date, String time, String hall, int quantity,String seat, double price)
	{
		this.bookingID = generateBookingId();
		this.customername = customername;
		this.moviename = moviename;
		this.date = date;
		this.time = time;
		this.hall = hall;
		this.quantity = quantity;
		this.seat = seat;
		this.price = price;
	}

    // Method to login as customer
	public static void loginCustomer(String username) 
    {
    	System.out.println("");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(" ________  ___  ___  ________  _________  ________  _____ ______   _______   ________          ________  ________  ________  _______      \r\n"
				+ "|\\   ____\\|\\  \\|\\  \\|\\   ____\\|\\___   ___\\\\   __  \\|\\   _ \\  _   \\|\\  ___ \\ |\\   __  \\        |\\   __  \\|\\   __  \\|\\   ____\\|\\  ___ \\     \r\n"
				+ "\\ \\  \\___|\\ \\  \\\\\\  \\ \\  \\___|\\|___ \\  \\_\\ \\  \\|\\  \\ \\  \\\\\\__\\ \\  \\ \\   __/|\\ \\  \\|\\  \\       \\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\___|\\ \\   __/|    \r\n"
				+ " \\ \\  \\    \\ \\  \\\\\\  \\ \\_____  \\   \\ \\  \\ \\ \\  \\\\\\  \\ \\  \\\\|__| \\  \\ \\  \\_|/_\\ \\   _  _\\       \\ \\   ____\\ \\   __  \\ \\  \\  __\\ \\  \\_|/__  \r\n"
				+ "  \\ \\  \\____\\ \\  \\\\\\  \\|____|\\  \\   \\ \\  \\ \\ \\  \\\\\\  \\ \\  \\    \\ \\  \\ \\  \\_|\\ \\ \\  \\\\  \\|       \\ \\  \\___|\\ \\  \\ \\  \\ \\  \\|\\  \\ \\  \\_|\\ \\ \r\n"
				+ "   \\ \\_______\\ \\_______\\____\\_\\  \\   \\ \\__\\ \\ \\_______\\ \\__\\    \\ \\__\\ \\_______\\ \\__\\\\ _\\        \\ \\__\\    \\ \\__\\ \\__\\ \\_______\\ \\_______\\\r\n"
				+ "    \\|_______|\\|_______|\\_________\\   \\|__|  \\|_______|\\|__|     \\|__|\\|_______|\\|__|\\|__|        \\|__|     \\|__|\\|__|\\|_______|\\|_______|\r\n"
				+ "                       \\|_________|                                                                                                       ");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		System.out.println("Welcome back, "+username);
		
		int choice=0;
		do {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println("Do you want to ....");
			System.out.println("1> Checkout available movies");
			System.out.println("2> view bookings");
			System.out.println("3> Exit");
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			choice = userChoice.valiUserChoice(input,3);
			switch(choice) {
			case 1:
				//select movie and create booking
				createMovieBooking(username);
			case 2:
				//view purchased bookings
				viewBookingsCustomer(username);
			case 3:
				//exit system
				userChoice.exitSystem();
				break;
			}
		}while (choice!=99);
    }
    
	// Method to login the admin
    public static void loginAdmin(String username) 
    {
    	System.out.println("");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(" ________  ________  _____ ______   ___  ________           ________  ________  ________  _______      \r\n"
				+ "|\\   __  \\|\\   ___ \\|\\   _ \\  _   \\|\\  \\|\\   ___  \\        |\\   __  \\|\\   __  \\|\\   ____\\|\\  ___ \\     \r\n"
				+ "\\ \\  \\|\\  \\ \\  \\_|\\ \\ \\  \\\\\\__\\ \\  \\ \\  \\ \\  \\\\ \\  \\       \\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\___|\\ \\   __/|    \r\n"
				+ " \\ \\   __  \\ \\  \\ \\\\ \\ \\  \\\\|__| \\  \\ \\  \\ \\  \\\\ \\  \\       \\ \\   ____\\ \\   __  \\ \\  \\  __\\ \\  \\_|/__  \r\n"
				+ "  \\ \\  \\ \\  \\ \\  \\_\\\\ \\ \\  \\    \\ \\  \\ \\  \\ \\  \\\\ \\  \\       \\ \\  \\___|\\ \\  \\ \\  \\ \\  \\|\\  \\ \\  \\_|\\ \\ \r\n"
				+ "   \\ \\__\\ \\__\\ \\_______\\ \\__\\    \\ \\__\\ \\__\\ \\__\\\\ \\__\\       \\ \\__\\    \\ \\__\\ \\__\\ \\_______\\ \\_______\\\r\n"
				+ "    \\|__|\\|__|\\|_______|\\|__|     \\|__|\\|__|\\|__| \\|__|        \\|__|     \\|__|\\|__|\\|_______|\\|_______|");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		System.out.println("Welcome back, "+username);
		
		int choice=0;
		do {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println("Do you want to ....");
			System.out.println("1> Edit bookings");
			System.out.println("2> Delete bookings");
			System.out.println("3> Exit");
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			choice = userChoice.valiUserChoice(input,3);
			switch (choice) {
            case 1:
                // Edit bookings
                System.out.println("\nEnter Booking ID to search for:");
                String bookingIDInput = input.next();
                String matchingBookings = null;
                
                matchingBookings = viewBookingsAdmin(bookingIDInput);
                if (!matchingBookings.isBlank())                     	
                	modifyBookings(matchingBookings);
                break;
            case 2:
            	// Cancel bookings
                Booking.cancelBooking();
                break;
            case 3:
            	userChoice.exitSystem();
                System.exit(0);                    
                break;
			}
		}while (choice!=99);
    }
    
    // Method to select movie booking
    public static void createMovieBooking(String customerName) {
        ArrayList<MovieBooking> movieList = MovieBooking.getMovie();

        char TicketChoice,BookingChoice;
        int movieChoice;
        MovieBooking choosenMovie = null;
        boolean  repeat = true;
        do {
            do {
            	// Display header for movie selection
            	System.out.println("");
            	System.out.println("==================================================");
                System.out.println(" __  __                                 __                                                  \r\n"
                		+ "/\\ \\/\\ \\                               /\\ \\                          __                     \r\n"
                		+ "\\ \\ `\\\\ \\    ___   __  __  __       ___\\ \\ \\___     ___   __  __  __/\\_\\    ___      __     \r\n"
                		+ " \\ \\ , ` \\  / __`\\/\\ \\/\\ \\/\\ \\     /',__\\ \\  _ `\\  / __`\\/\\ \\/\\ \\/\\ \\/\\ \\ /' _ `\\  /'_ `\\   \r\n"
                		+ "  \\ \\ \\`\\ \\/\\ \\L\\ \\ \\ \\_/ \\_/ \\   /\\__, `\\ \\ \\ \\ \\/\\ \\L\\ \\ \\ \\_/ \\_/ \\ \\ \\/\\ \\/\\ \\/\\ \\L\\ \\  \r\n"
                		+ "   \\ \\_\\ \\_\\ \\____/\\ \\___x___/'   \\/\\____/\\ \\_\\ \\_\\ \\____/\\ \\___x___/'\\ \\_\\ \\_\\ \\_\\ \\____ \\ \r\n"
                		+ "    \\/_/\\/_/\\/___/  \\/__//__/      \\/___/  \\/_/\\/_/\\/___/  \\/__//__/   \\/_/\\/_/\\/_/\\/___L\\ \\\r\n"
                		+ "                                                                                     /\\____/\r\n"
                		+ "                                                                                     \\_/__/ ");
            	System.out.println("==================================================");
                
                // Display list of available movies
                for (int i = 0; i < movieList.size(); i++) {
                    System.out.println("[" + (i + 1) + "] " + (movieList.get(i)).getName());
                }

                // Get customer's movie choice
                movieChoice = userChoice.valiUserChoice(input, movieList.size());
                
                // Initialize movie details into choosenMovie
                int movieIndex = movieChoice - 1;
                choosenMovie = movieList.get(movieIndex);

                System.out.println("");
                System.out.println("-------------");
                System.out.println("MOVIE DETAILS");
                System.out.println("-------------");
                System.out.println(choosenMovie);
                System.out.println("\nNote: You can only book tickets for two days in advance.");
                System.out.println("\nDo you want to buy a ticket for this movie? (y / n): ");
                TicketChoice = (input.next().toUpperCase()).charAt(0); 
                if(TicketChoice == 'Y')
                	repeat = false;
                else if(TicketChoice == 'N')
                	repeat = true;
                else 
                    System.out.println("Invalid choice. Please enter 'y' or 'n'.");
            } while (repeat);// repeat until user enter y

            // Date selection
            System.out.println("");
            System.out.println(">>>>");
            System.out.println("Date");
            System.out.println(">>>>");
            System.out.println("[1] 23/08/2024 (Fri)");
            System.out.println("[2] 24/08/2024 (Sat)");
            System.out.println("[3] 25/08/2024 (Sun)");
            System.out.println("[4] 26/08/2024 (Mon)");
            System.out.println("[5] 27/08/2024 (Tue)");
            int selectedDate = userChoice.valiUserChoice(input, 5);
            choosenMovie.setDate(selectedDate);

            // Time selection
            System.out.println("");
            System.out.println(">>>>");
            System.out.println("TIME");
            System.out.println(">>>>");
            System.out.println("[1] Morning (10:00 am)");
            System.out.println("[2] Evening (3:00 pm)");
            System.out.println("[3] Night (8:00 pm)");
            System.out.println("[4] Midnight (1:00 am)");
            int selectedTime = userChoice.valiUserChoice(input, 4);
            choosenMovie.setTime(selectedTime);

            //Quantity selection
            System.out.println("");
            System.out.println(">>>>>>>>>>>>>>");
            System.out.println("QUANTITY");
            System.out.println(">>>>>>>>>>>>>>");
            System.out.println("Min Ticket Quantity: 1 ticket");
            System.out.println("Max Ticket Quantity: 6 ticket(s)");
            int quantity = userChoice.valiUserChoice(input, 6);

            // Hall details
            String hallName="";
            switch (movieChoice) {
                case 1:
                    hallName = "Hall Violet";
                    break;
                case 2:
                    hallName = "Hall Magnenta";
                    break;
                case 3:
                    hallName = "Hall Turquish";
                    break;
                case 4:
                    hallName = "Hall White";
                    break;
            }

            // Seat details
            // Display hall map to get selected seat details
            System.out.println("");
            System.out.println("----");
            System.out.println("SEAT");
            System.out.println("----");
            String date = choosenMovie.getDate();
            String time = choosenMovie.getTime();
            
            String seatName = Hall_Seat_Map.getSeatDetail1(hallName,date,time,quantity);

            // Calculate total price based on movie price and quantity
            double totalPrice = choosenMovie.getPrice() * quantity;

            // Display booking confirmation details
            System.out.println("");
            System.out.println("===============================================");
            System.out.println("||          BOOKING CONFIRMATION             ||");
            System.out.println("===============================================");
            System.out.println(":| Movie       |: " + choosenMovie.getName());
            System.out.println(":| Date        |: " + choosenMovie.getDate());
            System.out.println(":| Time        |: " + choosenMovie.getTime());
            System.out.println(":| Hall        |: " + hallName);
            System.out.println(":| Seat(s)     |: " + seatName);
            System.out.println(":| Ticket(s)   |: " + quantity);
            System.out.printf (":| Total Price |: RM %.2f", totalPrice);

            System.out.print("\n\nConfirm booking? (y / n): ");
            BookingChoice = ((input.next()).toUpperCase()).charAt(0);
            if (BookingChoice == 'Y') {
				// Create a new booking
				Booking booking = new Booking(customerName, choosenMovie.getName(), choosenMovie.getDate(),choosenMovie.getTime(), hallName,quantity,seatName,totalPrice); 
				
				booking.writeToFile();	// record booking into file
				
				// Display booking ID
				System.out.println("\nBooking ID: " + booking.generateBookingId());
				System.out.println("Booking record added to file.");
				repeat = false;//stop the loop 
				break;
			}
            else
            	repeat = true;

        } while (repeat); // Repeat booking process if not confirmed

        // Display thank you message
        System.out.println("Thank you so much for using our application!");
    }
    
	// Method to view bookings (Customer)
	public static void viewBookingsCustomer(String nameInput)
	{     
        List<String> matchingBookings = new ArrayList<>();

        matchingBookings = loadBookingsCustomer(nameInput);
            
            if (matchingBookings.isEmpty()) {
            	// No bookings are found
                System.out.println("No bookings found for " + nameInput);
            } else {
            	// At least one booking is found
                System.out.println("Bookings for " + nameInput + ":");
                for (String booking : matchingBookings) {
                    String[] item = booking.split(",");
                    System.out.println("Booking ID      : " 	+ item[0].trim());
                    System.out.println("Customer Name   : " 	+ item[1].trim());
                    System.out.println("Movie Name      : "		+ item[2].trim());
                    System.out.println("Date            : "		+ item[3].trim());
                    System.out.println("Time            : "		+ item[4].trim());
                    System.out.println("Hall Name       : " 	+ item[5].trim());
                    System.out.println("Ticket Quantity : " 	+ item[6].trim());
                    System.out.println("Seat Names      : " 	+ item[7].trim());
                    System.out.println("Total Price     : RM " 	+ item[8].trim());
                    System.out.println();
                }
                
            	System.out.println("====================");
            	System.out.println("Total Bookings : " + matchingBookings.size());
            	System.out.println("====================");         
            }
    }
	
	// Method to view bookings (Admin)
	public static String viewBookingsAdmin(String bookingIDInput)
	{     
		bookingIDInput = bookingIDInput.toUpperCase();
        String matchingBookings = loadBookingsAdmin(bookingIDInput);
            
            if (matchingBookings.isEmpty()) {
            	// No bookings are found
                System.out.println("\nNo bookings found for " + bookingIDInput);
            } else {
            	// Matching booking is found
            	System.out.println("");
            	System.out.println(">>>>>>>>>>>>>>");
                System.out.println("BOOKING FOUND:"); 
            	System.out.println(">>>>>>>>>>>>>>");
            	String[] item = matchingBookings.split(",");
                System.out.println("Booking ID      : " 	+ item[0].trim());
                System.out.println("Customer Name   : " 	+ item[1].trim());
                System.out.println("Movie Name      : "		+ item[2].trim());
                System.out.println("Date            : "		+ item[3].trim());
                System.out.println("Time            : "		+ item[4].trim());
                System.out.println("Hall Name       : " 	+ item[5].trim());
                System.out.println("Ticket Quantity : " 	+ item[6].trim());
                System.out.println("Seat Names      : " 	+ item[7].trim());
                System.out.println("Total Price     : RM " 	+ item[8].trim());
                                }
            
           return matchingBookings;
    }
	
	// Method to load matching bookings (Customer - with customer name)
	public static List<String> loadBookingsCustomer(String nameInput){
		List<String> matchingBookings = new ArrayList<>();
		
        try {
            BufferedReader reader = new BufferedReader(new FileReader(bookingFile));
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] item = line.split(",");
                String customerName = item[1].trim(); // Extracting customer name
                
                if (customerName.equals(nameInput)) {
                    matchingBookings.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		return matchingBookings;
	}


	// Method to load matching bookings (Admin - with booking ID)
	public static String loadBookingsAdmin(String bookingIDInput){
		String matchingBookings = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(bookingFile));
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] item = line.split(",");
                String bookingID = item[0].trim(); // Extracting customer name
                
                if (bookingID.equals(bookingIDInput)) {
                    matchingBookings = line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		return matchingBookings;
	}
	
	// Method to modify bookings
	public static void modifyBookings(String matchingBookings)
	{
		String booking = new String(matchingBookings);
        String[] item = booking.split(",");
        
    	String continueEditChoice;
        int editOption = 0;
        String comfirmEditOption;
        
        String hallName = item[5];
        String date 	= item[3];
        String time 	= item[4];
        int newTicketQuantity = Integer.parseInt(item[6]);       
        String newMovieSeat = item[7];
        
        do {
        	System.out.println("");
        	System.out.println("===============================================");
    		System.out.println("||                Edit Booking                ||");
    		System.out.println("===============================================");
    		System.out.println("Current ticket quantity : " + newTicketQuantity);
    		System.out.println("Current movie seats     : " + newMovieSeat);
    		do {
    			System.out.println
    			("\nWhich information you want to modify?" +
				 "\n1. Ticket Quantity" +
				 "\n2. Movie Seat" );
    			System.out.print("Enter your option: ");
    			editOption = userChoice.valiUserChoice(input, 2);
   			
   				switch(editOption)
       			{
        			case 1: 
        				System.out.print("Enter the new ticket quantity: "); //modify correct ticket quantity
        				newTicketQuantity = input.nextInt();
        								
       				case 2: 
       					System.out.print("Enter the new movie seat: "); //modify correct movie seat
       					newMovieSeat = Hall_Seat_Map.getSeatDetail1(hallName, date, time, newTicketQuantity);
       					break;
       			}
   				System.out.println("Do you still want to modify booking infomation? (y / n): ");
   				continueEditChoice = input.next();
   			} while (continueEditChoice.equalsIgnoreCase("Y"));
    		
	   			int oldTicketQuantity = Integer.parseInt(item[6]);
	   			double oldTotalPrice = Double.parseDouble(item[8]);
	   			double newTotalPrice = (oldTotalPrice/oldTicketQuantity) * newTicketQuantity;
	   			
	   			item[6] = String.valueOf(newTicketQuantity);
	   			item[7] = String.valueOf(newMovieSeat);
	   			item[8] = String.valueOf(newTotalPrice);
	   			//Show the booking after insert the different information
	            System.out.println("");
	            System.out.println("===============================================");
	            System.out.println("||        BOOKING CONFIRMATION               ||");
	            System.out.println("===============================================");
	            System.out.println("Booking ID      : " 	+ item[0].trim());
	            System.out.println("Customer Name   : " 	+ item[1].trim());
	            System.out.println("Movie Name      : "		+ item[2].trim());
	            System.out.println("Date            : "		+ item[3].trim());
	            System.out.println("Time            : "		+ item[4].trim());
	            System.out.println("Hall Name       : " 	+ item[5].trim());
	            System.out.println("Ticket Quantity : " 	+ item[6].trim());
	            System.out.println("Seat Names      : " 	+ item[7].trim());
	            System.out.println("Total Price     : RM " 	+ item[8].trim());
	            System.out.println();    
	            
	            System.out.println("Comfirm changes? (y / n): ");
	            comfirmEditOption = input.next();
            
	            if (comfirmEditOption.equalsIgnoreCase("Y"))
	            {
	                // Delete existing booking and add new booking inside
	            	modifyBookingInFile(item[0], String.join(",", item));                
	            }
            }while(!comfirmEditOption.equalsIgnoreCase("Y"));
        }
	
	// Method to modify bookings inside the file
	private static void modifyBookingInFile(String bookingID, String modifiedBooking) {
        try {
            File inputFile = new File(bookingFile);
            Scanner scanner = new Scanner(inputFile);
            ArrayList<String> lines = new ArrayList<String>();

            // Read all bookings from the file into memory
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] bookingitem = line.split(",");
                // Check if the current line represents the booking to be modified
                if (bookingitem.length > 0 && bookingitem[0].trim().equals(bookingID)) {
                    lines.add(modifiedBooking); // Replace with modified booking
                } else {
                    lines.add(line);
                }
            }
            scanner.close();

            // Write all lines back to the file
            FileWriter writer = new FileWriter(bookingFile);
            for (String line : lines) {
                writer.write(line + System.lineSeparator());
            }
            writer.close();
            
            System.out.println("Booking successfully modified.");
        } catch (IOException e) {
            System.out.println("An error occurred while modifying the booking: " + e.getMessage());
        }
    }

	// Method to cancel bookings
	public static void cancelBooking()
	{
        boolean continueCancel = false;
        String choice;
        do
        {
            System.out.println("\n\n===============================================");
            System.out.println("||          CANCEL BOOKINGS                  ||");
            System.out.println("===============================================");
            System.out.print("Enter the booking ID: ");
            String deleteBooking = (input.next()).toUpperCase();
            
            viewBookingsAdmin(deleteBooking);//show the booking details
            ArrayList<String> lines = new ArrayList<>();
            ArrayList<String> idFound = new ArrayList<>();
            
            try
            {
                File readFile = new File(bookingFile); // Create a File object for reading
                Scanner inputFile = new Scanner(readFile); // Create a Scanner for reading the file
                
                String firstLine = inputFile.nextLine();
                lines.add(firstLine);
                
                while(inputFile.hasNextLine())
                {
                    String line = inputFile.nextLine();
                    int comma1 = line.indexOf(",");
                    String temp_bookingID = line.substring(0, comma1);
                    
                    if(!temp_bookingID.equals(deleteBooking))
                    {
                    	lines.add(line); // Add lines that don't match the delete booking to the list
                    	
                    }
                    
                    else
                    {
                        idFound.add(temp_bookingID);// Add the booking ID to the idFound list
                    }
                }
                
                inputFile.close();//close the inputFile
                
                do
                {
    	            System.out.print("Do you want to cancel this booking? (Y/N): ");
    	            choice = input.next().toUpperCase();
    	            if(choice.equals("Y"))
    	            {
    	            	continueCancel = true;
    	                
    	            }
    	            else if(choice.equals("N"))
    	            {
    	            	continueCancel = false;
    	            }
    	            else
    	            {
    	            	System.out.println("\nInvalid input.Please enter again.");
    	            }
                }while(!choice.equals("Y") && !choice.equals("N"));
                
                if(choice.equals("Y"))
                {
                    FileWriter fw = new FileWriter(bookingFile);// Create a FileWriter object
                    PrintWriter outputFile = new PrintWriter(fw);// Create a PrintWriter to write to the file
                    
                    // Write the updated lines back to the file
                    for (String line : lines)
                    {
                        outputFile.println(line);// rewrite the file without the deleted student's information
                    }
                    
                    outputFile.close();//close the outputFile
                    System.out.println("\nBooking has been cancel successfully");
                }
                else
                {
                    System.out.println("Failed to cancel booking");
                }
                
                do
                {
    	            System.out.print("Do you want to cancel another booking? (Y/N): ");
    	            choice = input.next().toUpperCase();
    	            if(choice.equals("Y"))
    	            {
    	            	continueCancel = true;
    	                
    	            }
    	            else if(choice.equals("N"))
    	            {
    	            	continueCancel = false;
    	            	break; // exit the loop if the admin doesn't want to cancel more booking 
    	            }
    	            else
    	            {
    	            	System.out.println("\nInvalid option. Please enter again.\n");
    	            }
                }while(!choice.equals("Y") && !choice.equals("N"));
            }
            
            catch (IOException exc)
            {
                System.out.println("File error: " + exc.getMessage());
            }
        } while(continueCancel == true);
    }
	
	public void writeToFile() 
	{
        try (FileWriter fw = new FileWriter(bookingFile, true)) {
            	
            fw.write(getBookingID() + "," + getCustomerName() + "," +getMovieName() + "," + getDate() + "," + getTime() + "," + getHall() + "," + getTicketQuantity() + "," + getSeat()+ "," + getPrice() + "\n"); 
            
            // Flush the writer to ensure data is written immediately
            fw.flush();
            
            System.out.println("Booking record written successfully.");
        } catch (IOException e) {
            // Print error message and stack trace
            System.err.println("Error writing to file: " + e.getMessage());
            e.printStackTrace();
        }
	}
	
	public void writeToFile(String addBooking) {
	    try (FileWriter fw = new FileWriter(bookingFile, true)) {
	        fw.append(addBooking).append("\n"); // Append booking record and add a newline character
	        // Flush the writer to ensure data is written immediately
	        fw.flush();
	        
	        System.out.println("Booking record written successfully.");
	    } catch (IOException e) {
	        // Print error message and stack trace
	        System.err.println("Error writing to file: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
}