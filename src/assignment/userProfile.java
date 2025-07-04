package assignment;
import java.io.*;
import java.text.ParseException;
import java.util.Scanner;

public class userProfile {
	private String username;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String name) {
		username = name ;
	}
	
	private String password;
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String Password) {
		password = Password;
	}
	
	private int age;
	public int getAge() {
		return age;
	}
	
	public void setAge(int Age) {
		age = Age;
	}
	
	private String gender;
	public String getGender() {
		return gender;
	}
	
	public void setGender(String Gender) {
		gender = Gender;
	}
	
	private String email;
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String Email) {
		email = Email;
	}
	
	//might need to have other constructor
	//for register new acc
	public userProfile(String aUsername, String aPassword) {
		username = aUsername;
		password = aPassword;
	}
	
	//for login new acc
	public userProfile( String aUsername, String aPassword, int Age, String Gender, String Email) {
		username = aUsername;
		password = aPassword;
		age = Age;
		gender = Gender;
		email = Email;
	}

	// methods 
	private static final String userInfo = "User_Info.txt";
	private static final Scanner input = new Scanner(System.in);
	
	//save user info to file
	public void saveToFile(String role) {
		try {
			FileWriter writer = new FileWriter(userInfo,true);
			writer.write(role+","+username+","+ age+","+email+","+gender+","+password+"\n");
			writer.close();
			System.out.println("The profile information is successfully saved");
		}catch(IOException e) {
			System.err.println("Error: Unable to save the profile information");
			e.printStackTrace();
		}
	}
	
	public static void registerAcc(String role) {
		String name= null, gender = null, email=null, password = null, confirmPassword= null;
		boolean containUpper, containDigit, lengthCheck, containSpecial,samePassword,patternPassword, validPassword=false;
		boolean repeatagain =true;
		int age=0;
		
		do {
			System.out.println(">>>>>>>>>>>>");
			System.out.println(" ____                               __                 __                           \r\n"
					+ "/\\  _`\\                  __        /\\ \\__             /\\ \\__  __                    \r\n"
					+ "\\ \\ \\L\\ \\     __     __ /\\_\\    ___\\ \\ ,_\\ _ __    __ \\ \\ ,_\\/\\_\\    ___     ___    \r\n"
					+ " \\ \\ ,  /   /'__`\\ /'_ `\\/\\ \\  /',__\\ \\ \\//\\`'__\\/'__`\\\\ \\ \\/\\/\\ \\  / __`\\ /' _ `\\  \r\n"
					+ "  \\ \\ \\\\ \\ /\\  __//\\ \\L\\ \\ \\ \\/\\__, `\\ \\ \\\\ \\ \\//\\ \\L\\.\\\\ \\ \\_\\ \\ \\/\\ \\L\\ \\/\\ \\/\\ \\ \r\n"
					+ "   \\ \\_\\ \\_\\ \\____\\ \\____ \\ \\_\\/\\____/\\ \\__\\ \\_\\\\ \\__/.\\_\\ \\__\\\\ \\_\\ \\____/\\ \\_\\ \\_\\\r\n"
					+ "    \\/_/\\/ /\\/____/\\/___L\\ \\/_/\\/___/  \\/__/\\/_/ \\/__/\\/_/\\/__/ \\/_/\\/___/  \\/_/\\/_/\r\n"
					+ "                     /\\____/                                                        \r\n"
					+ "                     \\_/__/                                                         ");
			System.out.println(">>>>>>>>>>>>");
			
			//username
			do {
				System.out.println("**The name should not contains number or special characters.");
				System.out.println("Name:");
				name = input.nextLine();
				if (!name.matches("[a-zA-Z]+"))
					System.out.println("Invalid username. name cannot contains number or special characters.");
				
			}while (!name.matches("[a-zA-Z]+"));
			System.out.println();
			
			//password
			do {
				//initiate special condition for password to fulfill
				containUpper= false;// at least 1 Upper case letter
				containDigit = false;//at least 1 digit
				containSpecial = false;//at least 1 special character
				lengthCheck = false; //at least contains 8 characters long
				samePassword=false;// confrimPassword must same with password
				patternPassword = false;
				validPassword = false;
				
				System.out.println("Password:");
				password = input.nextLine();
				System.out.println("Confirm Password:");
				confirmPassword = input.nextLine();
				
				for (char ch: password.toCharArray()) {
					if (!containDigit && Character.isDigit(ch))
						containDigit = true;
					else if (!containUpper && Character.isUpperCase(ch))
						containUpper = true;
					else if (!containSpecial && !Character.isLetterOrDigit(ch))
						containSpecial = true;
					
					//check password structure valid
					if(containDigit && containUpper && containSpecial)
						patternPassword = true;
				}
				//check two password same and character long same
				if (confirmPassword.equals(password))
					samePassword = true;
				if((confirmPassword.length() >=8) && (password.length() >= 8))
					lengthCheck = true;
				
				//check all required condition are fulfilled
				if (patternPassword && samePassword &&lengthCheck)
					validPassword = true;
				else if(samePassword == false)
					System.out.println("Password and confirm password are not same.");
				else if (lengthCheck == false)
					System.out.println("The pasword must at least 8 characters long.");
				else if(patternPassword == false)
					System.out.println("Password must contains at least 1 uppercase letter, 1 digit and 1 special character.");
				
			}while (validPassword == false);
			System.out.println();
			
			//gender (M/F)
			do {
				System.out.println("Gender (M for male /F for female): ");
				gender = (input.next()).toUpperCase();
				
				if (!gender.equals("M") && !gender.equals("F"))
					System.out.println("Please enter 'M' for male or 'F' for female");
				
			}while (!gender.equals("M") && !gender.equals("F"));
			System.out.println();
			
			//age
			do {
				System.out.println("Age:");
				while (!input.hasNextInt()) {
					System.out.println("That's nor a valid number");
					System.out.println();
					System.out.println("Please enter again");
					age = input.nextInt();
				}
				age = input.nextInt();
				
				if (age< 1 || age>99)
					 System.out.println("Invalid input! please enter your age in range of 1 to 99");
	
			}while (age<1 || age>99);
			System.out.println();
			
			
			//email
			System.out.println("Email:");
			email = (input.nextLine()).trim();
			boolean isValidEmail = false;
			do {
				//find index of "@" and "."
				int atpos1 = 0, atpos2 = 0, dotpos1 = 0, dotpos2 = 0;

                // Find the position of "@" symbol
                atpos1 = email.indexOf("@");
                if (atpos1 == -1)
                    System.out.println("No '@' symbol found.");
                else {
                    atpos2 = email.lastIndexOf("@");
                    if (atpos1 == atpos2) {
                    	// Only one "@" symbol found
                    } else
                        System.out.println("More than one '@' symbol.");
                }

                // Find the position of "." symbol
                dotpos1 = email.indexOf(".");
                if (dotpos1 == -1)
                    System.out.println("No '.' symbol found.");
                else {
                    dotpos2 = email.lastIndexOf(".");
                    if (dotpos1 == dotpos2) {
                        // Only one "." symbol found
                    } else
                        System.out.println("More than one '.' symbol.");
                }

                // Check if both "@" and "." are present only once
                if (atpos1 == atpos2 && dotpos1 == dotpos2) {
                    isValidEmail = true;
                } else {
                    System.out.println("Invalid email format! Please enter a valid email: ");
                    email = input.nextLine();
                }
			}while(!isValidEmail);
			System.out.println();
			
			//present complete user registration info
			userProfile user = new userProfile(name,password,age,gender,email);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println(" ____                               __                 __                             ______             ___                                  __                           \r\n"
					+ "/\\  _`\\                  __        /\\ \\__             /\\ \\__  __                     /\\__  _\\          /'___\\                                /\\ \\__  __                    \r\n"
					+ "\\ \\ \\L\\ \\     __     __ /\\_\\    ___\\ \\ ,_\\ _ __    __ \\ \\ ,_\\/\\_\\    ___     ___     \\/_/\\ \\/     ___ /\\ \\__/  ___   _ __    ___ ___      __ \\ \\ ,_\\/\\_\\    ___     ___    \r\n"
					+ " \\ \\ ,  /   /'__`\\ /'_ `\\/\\ \\  /',__\\ \\ \\//\\`'__\\/'__`\\\\ \\ \\/\\/\\ \\  / __`\\ /' _ `\\      \\ \\ \\   /' _ `\\ \\ ,__\\/ __`\\/\\`'__\\/' __` __`\\  /'__`\\\\ \\ \\/\\/\\ \\  / __`\\ /' _ `\\  \r\n"
					+ "  \\ \\ \\\\ \\ /\\  __//\\ \\L\\ \\ \\ \\/\\__, `\\ \\ \\\\ \\ \\//\\ \\L\\.\\\\ \\ \\_\\ \\ \\/\\ \\L\\ \\/\\ \\/\\ \\      \\_\\ \\__/\\ \\/\\ \\ \\ \\_/\\ \\L\\ \\ \\ \\/ /\\ \\/\\ \\/\\ \\/\\ \\L\\.\\\\ \\ \\_\\ \\ \\/\\ \\L\\ \\/\\ \\/\\ \\ \r\n"
					+ "   \\ \\_\\ \\_\\ \\____\\ \\____ \\ \\_\\/\\____/\\ \\__\\ \\_\\\\ \\__/.\\_\\ \\__\\\\ \\_\\ \\____/\\ \\_\\ \\_\\     /\\_____\\ \\_\\ \\_\\ \\_\\\\ \\____/\\ \\_\\ \\ \\_\\ \\_\\ \\_\\ \\__/.\\_\\ \\__\\\\ \\_\\ \\____/\\ \\_\\ \\_\\\r\n"
					+ "    \\/_/\\/ /\\/____/\\/___L\\ \\/_/\\/___/  \\/__/\\/_/ \\/__/\\/_/\\/__/ \\/_/\\/___/  \\/_/\\/_/     \\/_____/\\/_/\\/_/\\/_/ \\/___/  \\/_/  \\/_/\\/_/\\/_/\\/__/\\/_/\\/__/ \\/_/\\/___/  \\/_/\\/_/\r\n"
					+ "                     /\\____/                                                                                                                                               \r\n"
					+ "                     \\_/__/                                                                                                                                                ");
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println("Name    : "+ user.getUsername());
			System.out.println("Password: "+ user.getPassword());
			System.out.println("Age     : "+ user.getAge());
			System.out.println("Gender  : "+ user.getGender());
			System.out.println("Email   : "+ user.getEmail());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			char confirm;
			do {
				System.out.println("Do you confirm all information is correct to proceed registration?('Y' for yes / 'N' for no)");
				confirm = ((input.nextLine()).toUpperCase()).charAt(0);
				if (confirm == 'Y') {
					// save to file
					System.out.println("Your Profile registration is success");
					user.saveToFile(role);
					repeatagain= false;
					break;
				}
				else if(confirm == 'N') {
					repeatagain = true;
					break;
				}
				
				if(confirm != 'Y' || confirm != 'N') {
					System.out.print("Invalid response. Please enter 'Y' for yes or 'N' for no >> ");
					confirm = ((input.nextLine()).toUpperCase()).charAt(0);
				}
			}while(confirm != 'Y' || confirm != 'N');
		}while(repeatagain);
		
	}
	
	public static void loginAcc(String role) throws ParseException {
        String email, password;
        char tryAgain;
        int loginAttempts = 0;
        BufferedReader reader = null;
        boolean loginSuccess = false;

        try {
            reader = new BufferedReader(new FileReader("User_Info.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File cannot be accessed.");
            e.printStackTrace();
            return; // Exit method if file not found
        }

        do {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(" __  __                                __                                     \r\n"
                + "/\\ \\/\\ \\                              /\\ \\                      __            \r\n"
                + "\\ \\ \\ \\ \\    ____     __   _ __       \\ \\ \\        ___      __ /\\_\\    ___    \r\n"
                + " \\ \\ \\ \\ \\  /',__\\  /'__`\\/\\`'__\\      \\ \\ \\  __  / __`\\  /'_ `\\/\\ \\ /' _ `\\  \r\n"
                + "  \\ \\ \\_\\ \\/\\__, `\\/\\  __/\\ \\ \\/        \\ \\ \\L\\ \\/\\ \\L\\ \\/\\ \\L\\ \\ \\ \\/\\ \\/\\ \\ \r\n"
                + "   \\ \\_____\\/\\____/\\ \\____\\\\ \\_\\         \\ \\____/\\ \\____/\\ \\____ \\ \\_\\ \\_\\ \\_\\\r\n"
                + "    \\/_____/\\/___/  \\/____/ \\/_/          \\/___/  \\/___/  \\/___L\\ \\/_/\\/_/\\/_/\r\n"
                + "                                                            /\\____/           \r\n"
                + "                                                            \\_/__/            ");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
                
            System.out.println("Enter Email>>");
            email = input.next();

            System.out.println("Enter Password>>");
            password = input.next();

            loginSuccess = CheckUserExist(email, password);

            if (loginSuccess) {
                System.out.println("\nLogin Successfully!");
                String line;
                try {
                    reader = new BufferedReader(new FileReader("User_Info.txt"));
                    while ((line = reader.readLine()) != null) {
                        String[] attributes = line.split(",");
                        String userIdentity = attributes[0].trim();
                        String name = attributes[1].trim();

                        if (line.contains(email) && line.contains(password)) {
                            if (userIdentity.equals("customer")) {
                                Booking.loginCustomer(name);
                            } else {
                                Booking.loginAdmin(name);
                            }
                            return; // Exit method after successful login
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                loginAttempts++;
                if (loginAttempts >= 3) {
                    System.out.println("Wrong password or email. You have exceeded the maximum number of attempts.");
                    System.out.println("Back to the main page...");
                    input.next(); // Wait for user input before returning to the main page
                    return;
                } else {
                    System.out.println("Wrong password or email!");
                    System.out.println("You have " + (3 - loginAttempts) + " chances left to try again.");
                    System.out.println("Do you want to try again? (Y/N)>>");
                    tryAgain = Character.toUpperCase(input.next().charAt(0));
                    if (tryAgain != 'Y') {
                    	loginAttempts = 0;
                        return; // Exit method if user chooses not to try again
                    }
                }
            }
        } while (loginAttempts < 3);
    }
	
	public static boolean CheckUserExist(String email, String password) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("User_Info.txt"));
			String line;
			while((line= reader.readLine())!= null) {
				String[] info = line.split(",");
				String userEmail = info[3].trim();
				String userPassword = info[5].trim();
				if (email.equals(userEmail)&& password.equals(userPassword)) {
					reader.close();
					return true;
				}
			}
			reader.close();
			return false;
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}
		
	}
}
