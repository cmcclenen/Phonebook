//Cayce McClenen - 260735309

public class ContactTester {
	public static void main(String[] args) {
	int i, mod;
	String s = "";

	ContactsBook book1 = new ContactsBook();
	ContactsBook book2 = new ContactsBook();


	String[] words = {"admiral", "alan", "amanda", "Ann", "Ban", "britten", "chris", "conny", "daniel", "david", "elgar" , "enix", "faust", "falkner", 
			"ghost", "gil galad","hope", "harrow", "indy", "igloo", "johnny", "jack", "Kenny", "kid", "lamon", "Lan", "mason", 
			"master", "nimrod", "Nils", "octo", "oli", "penny", "pop", "quas", "quest", "ron", "Rat", "Son", "Shine", "tele", "taut",
			"uncle", "underlord", "viper", "venomancer", "wex", "weather", "xylophone", "xiphos", "Ysgramor", "Yygdrasil", "zeno", "zelle", "1hkl", " lkasj"};
	String[] phones = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", 
			         "18", "19", "20", "21", "31", "41", "51", "61","1", "2", "3", "4", "5", "6", "7", "8", "9",
			         "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "31", "41", "51", "61", "101", "1234", "101", "1234", "41", "51"};

	//shows that newContact works correctly
	for(i = 0; i < 56; i++ ) 
	{
		mod = i % 3;
		if(mod == 0) 
		{
			book1.newAcquaintance(words[i], phones[i]);
		}
		else if(mod == 1) 
		{
			book1.newBusiness(words[i], phones[i], phones[i], words[i]);
		}
		else 
		{
			book1.newFriend(words[i], phones[i], phones[i], words[i]);
		}
	}
	
	for(i = 55; i > -1 ; i-- ) 
	{
		mod = i % 3;
		if(mod == 0) 
		{
			book2.newAcquaintance(words[i], phones[i]);
		}
		else if(mod == 1) 
		{
			book2.newBusiness(words[i], phones[i], phones[i], words[i]);
		}
		else 
		{
			book2.newFriend(words[i], phones[i], phones[i], words[i]);
		}
	}
	
	//shows that list all works
	System.out.println(book1.listAll());
	
	//print every SLL individually
	for(i = 0; i < 27; i++)
	{
		s = s + book1.getPhonebook().get(i).print();
	}
	
	//shows that listAll is equivalent to printing the every individual SLL in the ArrayList
	System.out.println(s.compareTo(book1.listAll()));	
	
	//shows that the ArrayLists are the same when constructed forward as when constructed backwards
	System.out.println(s.compareTo(book2.listAll()));
	
	
	//shows that the find works correctly
	System.out.println("Find admiral: " + book2.find("admiral"));
	System.out.println("Find Gendry: " + book1.find("Gendry"));
	System.out.println("Find 1hkl: " + book2.find("1hkl"));
	}
}

