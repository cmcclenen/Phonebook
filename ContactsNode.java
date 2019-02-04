//Cayce McClenen - 260735309

public class ContactsNode 
{
	//Contact nodes have a contact and a reference to another contact
	private Contacts contact;
	private ContactsNode next;

	public ContactsNode(Contacts contact) // constructor
	{
		this.contact = contact;
		this.next    = null;
	}

	public Contacts getContact() // returns the contact of the ContactNode it is called on
	{
		return this.contact;
	}


	public ContactsNode getNext() // returns the next of the ContactNode it is called on
	{
		return this.next;
	}

	public void setContact(Contacts contact) //changes the value of the contact of the node it is called on
	{
		this.contact = contact;
	}



	public void setNext(ContactsNode next) //changes the value of the next of the node it is called on
	{
		this.next = next;
	}
}




