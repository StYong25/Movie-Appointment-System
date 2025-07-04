package assignment;

import java.util.*;
import java.io.*;

public class Hall_Seat_Map {
private static final String bookingFile = "bookings.txt";
	
	//Method to get the hall seat details for booking
	public static String getSeatDetail1(String hallName, String date, String time, int quantity)
	{
		StringBuilder selectedSeat = new StringBuilder();
		
		//Define seat columns and rows
		String[] seatColumns = {"\n\t      1","2 ","3 ","4 ","5 ","6 ","7 ","8 ","9 "};
		
		String[] seatRows = {"A","B","C","D","E","F","G","H"};
		
		//Initialize 2-dimensional array of seat
		String[][] seat ={{"0", "0", "0", "0", "0", "0", "0", "0", "0"},
		                  {"0", "0", "0", "0", "0", "0", "0", "0", "0"},
		                  {"0", "0", "0", "0", "0", "0", "0", "0", "0"},
		                  {"0", "0", "0", "0", "0", "0", "0", "0", "0"},
		                  {"0", "0", "0", "0", "0", "0", "0", "0", "0"},
		                  {"0", "0", "0", "0", "0", "0", "0", "0", "0"},                 
		                  {"0", "0", "0", "0", "0", "0", "0", "0", "0"},             
		                  {"0", "0", "0", "0", "0", "0", "0", "0", "0"}};   
		
		
		StringBuilder previousSeat = getSeatNumber(hallName, date, time);
		
		markPreviousSeat(seat, previousSeat.toString());
		
		Scanner s = new Scanner(System.in);
		
		//Loop till required number of seats is fulfilled
		do
		{
			printHallSeatMap(seat, seatColumns, seatRows);
			try {
				System.out.println("\nPlease choose desired seat(row and column):  ");
				String input = s.next();
				input = input.toUpperCase();
			
				//Extract row and column from user input
				char row = input.charAt(0);
				int newCol = Integer.parseInt(input.substring(1)) - 1;
				int newRow = row - 'A';
			
				//Validation on seat availability
				if(newRow >= 0 && newRow < seatRows.length && newCol >= 0 && newCol < seatColumns.length)
				{
					if(seat[newRow][newCol].equals("0"))
					{
						seat[newRow][newCol] = "X";//Mark seat as selected
						selectedSeat.append(seatRows[newRow]).append(input.substring(1)).append(" ");
						printHallSeatMap(seat, seatColumns, seatRows);
						System.out.println("\nSelected successfully!!");
						quantity--;
						System.out.println("You still need to choose " + quantity + " seat.");
					}
					else
						System.out.println("The seat is not available, please choose another seat.");

				}
				else
					System.out.println("Please enter a valid seat!!");
			
			}catch(NumberFormatException e) {
				System.out.println("Please enter a valid seat!!");
			}
		}while(quantity > 0);//Keep looping until no more ticket left
		
		String[] selectedSeatArray = selectedSeat.toString().split("\\s+");
		
		Arrays.sort(selectedSeatArray);
		
		//Go through the sorted list of seat one by one
		StringBuilder seatString = new StringBuilder();
		for(String seats : selectedSeatArray)
		{
			seatString.append(seats).append(" ");
		}
		
		String formatSeat = seatString.substring(0, seatString.length() - 1);
		
		System.out.println("\nYour seats are: " + formatSeat);
		
		return formatSeat;//Return formatted sorted selected seat list
	}
	
	private static StringBuilder getSeatNumber(String hallName, String date, String selectedTime)
	{
		StringBuilder overallSeat = new StringBuilder();
		try
		{
			BufferedReader r = new BufferedReader(new FileReader(bookingFile));
			String lines;
			
			
			while((lines = r.readLine()) != null)
			{
				String[] elements = lines.split(",");
				String dateCheck = elements[3].trim();
				String timeCheck = elements[4].trim();
				String hallNameCheck = elements[5].trim();
				String seatsCheck = elements[7];
				
				if((dateCheck.equals(date)) && (timeCheck.equals(selectedTime)) && (hallNameCheck.equals(hallName)))
				{
					overallSeat.append(seatsCheck);
				}
			}
		}catch(IOException e)
			{
				e.printStackTrace();
			}
		return overallSeat;
	}

	
	//Method to display the hall seat map
	private static void printHallSeatMap(String[][] seatNum, String[]seatColumn, String[] seatRow)
	{
		System.out.println("");
		System.out.println("\t -----------------------------");
		System.out.println("\t |                           |");
		System.out.println("\t |                           |");
		System.out.println("\t |           SCREEN          |");
		System.out.println("\t |                           |");
		System.out.println("\t |                           |");
		System.out.println("\t -----------------------------");
		
		//Print seat column
		for(int i=0; i<seatColumn.length; i++)
			System.out.print(" " + seatColumn[i]);
		
		System.out.println("\n   	  ________________________________");
		
		//Print seat rows and seat numbers
		for(int i=0;i<seatRow.length; i++) 
		{
			System.out.print("\n    	 " + seatRow[i]+ " |");
			
			for(int j=0; j< seatNum[i].length; j++)
			{
				System.out.print("  " + seatNum[i][j]);
			}
			System.out.println(" |");
		}
	}
	
	//Method to mark previous booked seat number
	private static void markPreviousSeat(String[][] seatNum, String previousSeat)
	{
		if (previousSeat == null || previousSeat.trim().isEmpty()) {
	        // If previousSeat is null or empty, return early as there's nothing to process
	        System.out.println("No previously booked seats found.");
	        return;
	    }

	    // Split the previous seats based on space
	    String[] bookedSeat = previousSeat.split(" ");
	    
	    // Iterate through the booked seats
	    for (String seats : bookedSeat) {
	        // Skip any empty seats strings
	        if (seats.isEmpty()) {
	            continue;
	        }

	        try {
	            // Extract row and column
	            char row = seats.charAt(0);  // May throw exception if 'seats' is empty
	            int column = Integer.parseInt(seats.substring(1)) - 1;
	            int rowIndex = row - 'A';
	            
	            // Ensure rowIndex and column are within the valid bounds
	            if (rowIndex >= 0 && rowIndex < seatNum.length && column >= 0 && column < seatNum[rowIndex].length) {
	                seatNum[rowIndex][column] = "X";  // Mark the seat as booked
	            }
	        } catch (StringIndexOutOfBoundsException | NumberFormatException e) {
	            System.out.println("Invalid seat format detected: " + seats);
	        }
	    }
	}

}
