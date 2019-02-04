//Cayce McClenen - 260735309

import java.util.Scanner;

public class ContactsMain {

	public static void main(String args[]) 
	{
		ContactsBook phonebook = new ContactsBook(); //make a new phone book
		Scanner scanner = new Scanner(System.in);
		String option; 	// corresponds to the option the user inputs
		boolean loop = true; // will keep the phone book running until the user quits
	
		while(loop == true) 
		{
			mainMenu(); // print the main menu
			
			option     = scanner.nextLine();
				
				if(option.equals("1")) //if they choose to add a contact, call newContact
				{
					newContact(option, scanner, phonebook);
				}
			
				else if(option.equals("2")) // if they choose to find a contact, call findContact
				{
					findContact( scanner, phonebook);
				}
			
				else if(option.equals("3")) // if they choose to list all, call listAll
				{		
					System.out.println(phonebook.listAll());
				}
	
				else if(option.equals("4")) // if they choose to quit, call quit and set loop = false to break the loop and exit the program
				{
					quit(scanner);
					loop = false; 
				}
	
				else // if they type something we didn't account for
				{
					//do nothing, and the loop will start over
				}
			}
		}
	

	public static void mainMenu() //prints the main menu
	{
		System.out.println("Please type 1, 2, 3 or 4 to choose an option!");
		System.out.println("1. New Contact");
		System.out.println("2. Find Contact");
		System.out.println("3. List All");
		System.out.println("4. Quit");
	}
	
	//handles all i/o for the New Contact task
	public static void newContact(String option, Scanner scanner, ContactsBook phonebook) {
		String n, p, a, b; // name, phone number, address, business name/birthday,
		boolean loop = true; // will continue to loop until they select a valid option
		
		System.out.println("Please type 1, 2, 3, or 4 to choose an option!");
		System.out.println("1. Acquaintance");
		System.out.println("2. Business");
		System.out.println("3. Friend");
		System.out.println("4. Go back");
		option = scanner.nextLine(); // take the users input
			
		while(loop == true)
		{
			
			if(option.equals("1")) //if they chose acquaintance, scan in the name and number
			{
				System.out.println("Please enter the person's name.");
				n = scanner.nextLine();
		
				System.out.println("Please enter the person's phone number.");
				p = scanner.nextLine();
		
				phonebook.newAcquaintance(n, p); // add the new contact to the phone book
				loop = false;
			}
			
			else if(option.equals("2"))  //if they chose business, scan in the name, number, address, and name of their business
			{
				System.out.println("Please enter the person's name.");
				n = scanner.nextLine();
		
				System.out.println("Please enter the person's phone number.");
				p = scanner.nextLine();
		
				System.out.println("Please enter the person's address");
				a = scanner.nextLine();
		
				System.out.println("Please enter the name of the person's business.");
				b = scanner.nextLine();
		
				phonebook.newBusiness(n, p, a, b);
				loop = false;
			}
			
			else if(option.equals("3"))//if they chose friend, scan in the name, number, address, and birthdate
			{	
				System.out.println("Please enter the person's name.");
				n = scanner.nextLine();
		
				System.out.println("Please enter the person's phone number.");
				p = scanner.nextLine();
		
				System.out.println("Please enter the person's address");
				a = scanner.nextLine();
		
				System.out.println("Please enter the person's birthdate.");
				b = scanner.nextLine();
		
				phonebook.newBusiness(n, p, a, b);
				loop = false;
			}
			
			else if(option.equals("4")) //if they chose to go back, break out of the loop and go back
			{ 
				loop = false;
			}
			
			else //if they entered something we didn't account for, ask for their input again
			{
				System.out.println("Please type 1, 2, 3, or 4 to choose an option!");
				System.out.println("1. Acquaintance");
				System.out.println("2. Business");
				System.out.println("3. Friend");
				System.out.println("4. Go back");
				option     = scanner.nextLine();
			}	
		}
	}
	
	//handles all i/o for the Find task 
	public static void findContact( Scanner scanner, ContactsBook phonebook)
	{
		String n;
		boolean loop = true;
		
		while(loop == true)
		{
			System.out.println("Please enter the person's full name, or enter 2 to go back.");
			n = scanner.nextLine();
			
			if(n.equals("2"))
			{
				loop = false;
			}
			
			else 
			{
				System.out.println(phonebook.find(n));
				loop = false;
			}
		}
	}
	
	//calls listAll on our phone book
	public static void listAll(ContactsBook phonebook) {
		System.out.println(phonebook.listAll());
	}
	
	//takes care of all tidying up left to do
	public static void quit(Scanner scanner) {
		scanner.close(); //close the scanner
	}
}

