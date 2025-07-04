// Movie.java
package assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MovieBooking {
	// Instance variable
    private String name;
    private String genre;
    private String language;
    private int duration;
    private double price;
    private String description;
    private String date;
    private String time;
    private String view;
    private String ratings;
    
    private static final String movieFile = "Movie List.txt";
    
 // Setter methods
    public void setDate(int selectedDate) {
    	if (selectedDate == 1)
			date = "23/05/2024 (Fri)";
    	else if (selectedDate == 2)
			date = "24/08/2024 (Sat)";
    	else if (selectedDate == 3)
			date = "25/08/2024 (Sun)";
    	else if (selectedDate == 4)
			date = "26/08/2024 (Mon)";
    	else if (selectedDate == 5)
			date = "27/08/2024 (Tue)";

    }
    public void setTime(int selectedTime) {
    	if(selectedTime == 1)
			time = "Morning (10:00 am)";
    	else if(selectedTime == 2)
			time = "Evening (3:00 pm)";
    	else if(selectedTime == 3)
			time = "Night (8:00 pm)";
    	else if(selectedTime == 4)
			time = "Midnight (1:00 am)";
    }

    // Getter methods
    public String getName() {
        return name;
    }
    public String getGenre() {
        return genre;
    }
    public String getLanguage() {
        return language;
    }
    public int getDuration() {
        return duration;
    }
    public double getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }
    public String getDate() {
        return date;
    }
    public String getTime() {
        return time;
    }
    public String getRatings() {
        return ratings;
    }
    public String getView() {
    	return view;
    }
    
    

    // Constructor
    public MovieBooking(String name, String genre, String language, int duration, double price, String description, String view, String ratings) {
        this.name = name;
        this.genre = genre;
        this.language = language;
        this.duration = duration;
        this.price = price;
        this.description = description;
        this.view = view;
        this.ratings = ratings;
    }

    public static ArrayList<MovieBooking> getMovie() {
        ArrayList<MovieBooking> movieList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(movieFile))) {
            String line;
            StringBuilder movieData = new StringBuilder();

            while ((line = br.readLine()) != null) {
                if (!line.isBlank()) {
                    if (line.startsWith("(Movie")) {
                        if (movieData.length() > 0) {
                            MovieBooking movie = changeMovie(movieData.toString());
                            if (movie != null) {
                                movieList.add(movie);
                            }
                            movieData.setLength(0); // Clear the StringBuilder for the next movie
                        }
                    }
                    movieData.append(line).append("\n");
                }
            }

            // Add the last movie
            if (movieData.length() > 0) {
                MovieBooking movie = changeMovie(movieData.toString());
                if (movie != null) {
                    movieList.add(movie);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return movieList;
    }

    private static MovieBooking changeMovie(String data) {
    	String[] lines = data.split("\n");
        String name = null, genre = null, language = null, description = null, view = null, ratings = null;
        int duration = 0;
        double price = 0.0;

        StringBuilder descriptionBuilder = new StringBuilder(); // StringBuilder to build the description

        boolean isDescription = false; // Flag to indicate when we are reading the description

        for (String line : lines) {
            if (line.startsWith("Movie Name")) {
                name = line.substring(line.indexOf(":") + 1).trim();
            } else if (line.startsWith("Genre")) {
                genre = line.substring(line.indexOf(":") + 1).trim();
            } else if (line.startsWith("Language")) {
                language = line.substring(line.indexOf(":") + 1).trim();
            } else if (line.startsWith("Duration")) {
                duration = Integer.parseInt(line.substring(line.indexOf(":") + 1, line.indexOf(" minutes")).trim());
            } else if (line.startsWith("Price")) {
                price = Double.parseDouble(line.substring(line.indexOf("RM") + 2).trim());
            } else if (line.startsWith("Total View")) {
                view = line.substring(line.indexOf(":") + 1).trim();
            } else if (line.startsWith("Rating")) {
                ratings = line.substring(line.indexOf(":") + 1).trim();
            } else if (line.startsWith("Description")) {
                isDescription = true; // Start reading the description from the next lines
                continue; // Skip the "Description" header line
            } else if (isDescription && line.startsWith("(Movie")) {
                isDescription = false; // Stop reading the description if a new movie header is found
                continue; // Skip the movie header line
            }

            if (isDescription) {
                // Append non-metadata lines to the description
                descriptionBuilder.append(line.trim()).append("\n");
            }
        }

        // Set the description from the StringBuilder
        description = descriptionBuilder.toString().trim();

        // Check if any required field is missing
        if (name != null && genre != null && language != null && description != null && duration > 0 && price > 0) {
            // Return the constructed Movie object
            return new MovieBooking(name, genre, language, duration, price, description, view, ratings);
        } else {
            // Return null if any required field is missing
            return null;
        }
    }

    // Function to print selected movie details
    @Override
    public String toString() {
        String[] descriptionLines = description.split("\n"); // Split the description into lines
        StringBuilder descriptionBuilder = new StringBuilder();

        for (String line : descriptionLines) {
            descriptionBuilder.append("\t").append(line.trim()).append("\n"); // Add each line with indentation
        }

        return  "Movie Name    : " + name + "\n" +
                "Genre         : " + genre + "\n" +
                "Language      : " + language + "\n" +
                "Duration      : " + duration + " minutes\n" +
                "Price(RM)     : " + price + "\n" +
                "Total View    : " + view + "\n" +
                "Ratings       : " + ratings + "\n\n" +
                "Description:\n" + descriptionBuilder.toString(); // Append formatted description
    }
}