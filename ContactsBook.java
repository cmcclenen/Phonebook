//Cayce McClenen - 260735309

import java.util.ArrayList;

public class ContactsBook {
	
	//our ContactBook will have an ArrayList which stores a linked list for every letter of the alphabet 
	//and an additional list for names not starting with letters
	//it will start as empty, and once we add a list it will be not empty. 
	private ArrayList<ContactsSLL> phonebook = new ArrayList<ContactsSLL>(27);
	private boolean isEmpty;

	public ArrayList<ContactsSLL> getPhonebook() //returns the ContactBook's phone book
	{
		return this.phonebook;
	}

	public ContactsBook() //initializes the contactbook as empty, and fills it with empty ArrayLists
	{
		this.isEmpty = true;
		ContactsSLL list;
		int i;
		for(i = 0; i < 27; i++) 
			
		{
			list = new ContactsSLL();
			phonebook.add(i, list);
		}
	}
	
	//adds a new ContactNode at the specified index of the ArrayList
	public ContactsSLL insert(int index, ContactsNode node) {
		ContactsSLL tmp = this.phonebook.get(index); //get the SLL at this index
		tmp.insert(node); // insert the Node to the SLL
		return tmp; // return the updated SLL
	}
	
	//will return a string which is a concatenation of all Contact's values contained within the ArrayList
	public String listAll() 
	{
		ContactsSLL tmp;
		int i;
		String s = "";
		if(this.isEmpty) //if the ArrayList is empty, return nothing i.e. ""
		{
			return s;
		}
		else 
		{
			for(i = 0; i < 27; i++) //iterate through the arrayList
			{
				tmp = phonebook.get(i); //iterate through the SLL
				if(tmp != null) 
				{
					s = s + tmp.print(); 
				}
			}
			return s; // return the concatenation
		}
	}
	
	//search an ArrayList for a particular name
	public String find(String name) 
	{
		int index = index(name); //get the index of the name
		ArrayList<ContactsSLL> phonebook = this.getPhonebook();
		ContactsSLL list = phonebook.get(index);
		
		if(index  == -1 ) //if we got the error code, the name isn't in the list so return "Not found."
		{
			return "Not Found." ; 
		}
		else if(list == null) //if the list at this index if empty, the name isn't in the list so return "Not Found."
		{
		return "Not Found.";
		}
		else 
		{
			return list.find(name); //if the index is valid and a SLL exists at this index, search the SLL
		}
	}
	
	//insert a new friend to the ArrayList
	public void newFriend(String name, String phone, String address, String birthdate) 
	{
		
		Contacts friend = new Contacts.Friend(name, phone, address, birthdate); //create a new friend 
		ContactsNode friendNode = new ContactsNode(friend); //create a new friend node out of the friend
		int index = index(friend.getName()); //get the index of the friend
		if(index<0) 
		{
			//do nothing
		}
		
		else 
		{
			//replace the SLL at index with the SLL which contains the new node
			this.phonebook.set(index, this.phonebook.get(index).insert(friendNode));
			this.isEmpty = false;
		}
	}

	//insert a new Business to the ArrayList
	public void newBusiness(String name, String phone, String address, String businessName) 
	{
		Contacts business = new Contacts.Business(name, phone, address, businessName); //create a new business 
		int index = index(business.getName()); //create a new business node out of the business
		ContactsNode businessNode = new ContactsNode(business); //get the index of the business
		if(index<0)
		{	
			//do nothing
		}
		else 
		{
			//replace the SLL at index with the SLL which contains the new node
			this.phonebook.set(index, this.phonebook.get(index).insert(businessNode));
			this.isEmpty = false;
		}
	}
	
	//insert a new Acquaintance to the ArrayList
	public void newAcquaintance(String name, String phone) 
	{
		Contacts acquaintance = new Contacts.Acquaintance(name, phone);//create a new acquaintance 
		int index = index(acquaintance.getName()); //create a new acquaintance node out of the acquaintance
		ContactsNode acquaintanceNode = new ContactsNode(acquaintance); //get the index of the acquaintance
		if(index<0)
		{	
			//do nothing
		}
		else 
		{
			//replace the SLL at index with the SLL which contains the new node
			this.phonebook.set(index, this.insert(index, acquaintanceNode));
			this.isEmpty = false;
		}
	}
	
	//our hash function. Will match the name of the contact with an index in the ArrayList by first letter.
	//index 26 is reserved for any characters entered with aren't letters i.e. "123" "3lk" " lkj" etc.
	//-1 is an error code in case the name is somehow empty so that we don't try to add something empty to our phone book
	public static int index(String s) 
	{
		if(s.charAt(0)=='A' || s.charAt(0) == 'a') {
			return 0;
		}
		else if(s.charAt(0)=='B' || s.charAt(0) == 'b') {
			return 1;
		}
		else if(s.charAt(0)=='C' || s.charAt(0) == 'c') {
			return 2;
		}
		else if(s.charAt(0)=='D' || s.charAt(0) == 'd') {
			return 3;
		}
		else if(s.charAt(0)=='E' || s.charAt(0) == 'e') {
			return 4;
		}
		else if(s.charAt(0)=='F' || s.charAt(0) == 'f') {
			return 5;
		}
		else if(s.charAt(0)=='G' || s.charAt(0) == 'g') {
			return 6;
		}
		else if(s.charAt(0)=='H' || s.charAt(0) == 'h') {
			return 7;
		}
		else if(s.charAt(0)=='I' || s.charAt(0) == 'i') {
			return 8;
		}
		else if(s.charAt(0)=='J' || s.charAt(0) == 'j') {
			return 9;
		}
		else if(s.charAt(0)=='K' || s.charAt(0) == 'k') {
			return 10;
		}
		else if(s.charAt(0)=='L' || s.charAt(0) == 'l') {
			return 11;
		}
		else if(s.charAt(0)=='M' || s.charAt(0) == 'm') {
			return 12;
		}
		else if(s.charAt(0)=='N' || s.charAt(0) == 'n') {
			return 13;
		}
		else if(s.charAt(0)=='O' || s.charAt(0) == 'o') {
			return 14;
		}
		else if(s.charAt(0)=='P' || s.charAt(0) == 'p') {
			return 15;
		}
		else if(s.charAt(0)=='Q' || s.charAt(0) == 'q') {
			return 16;
		}
		else if(s.charAt(0)=='R' || s.charAt(0) == 'r') {
			return 17;
		}
		else if(s.charAt(0)=='S' || s.charAt(0) == 's') {
			return 18;
		}
		else if(s.charAt(0)=='T' || s.charAt(0) == 't') {
			return 19;
		}
		else if(s.charAt(0)=='U' || s.charAt(0) == 'u') {
			return 20;
		}
		else if(s.charAt(0)=='V' || s.charAt(0) == 'v') {
			return 21;
		}
		else if(s.charAt(0)=='W' || s.charAt(0) == 'w') {
			return 22;
		}
		else if(s.charAt(0)=='X' || s.charAt(0) == 'x') {
			return 23;
		}
		else if(s.charAt(0)=='Y' || s.charAt(0) == 'y') {
			return 24;
		}
		else if(s.charAt(0)=='Z' || s.charAt(0) == 'z') {
			return 25;
		}
		else if(s=="") {
			return -1;
		}
		else {
			return 26;
		}
	}
}
