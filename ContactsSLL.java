//Cayce McClenen - 260735309

public class ContactsSLL {
	
	//our ContactSLL has a head and a tail
	private ContactsNode head;
	private ContactsNode tail;

	
	public ContactsSLL() //constructor initializes an empty SLL
	{
		this.head = null;
		this.tail = null;
	}
	
	//iterates through the list, returns the concatenation of all of the node's contact's toStrings
	public String print() 
	{
		String s = ""; //initializes the string as empty
		ContactsNode tmp = this.head; //start at the head
		
		while(tmp != null) //if the head isn't empty, start iterating until you reach the tail.getNext
		{
			s = s + tmp.getContact().toString() + "\n"; //concatenate the strings as you go
			tmp = tmp.getNext(); //go to the next node in the list
		}
		return s; // if the head is empty, will return "", otherwise, it will return a string of some sort
	}

	//returns the the SLL with the node inserted in the correct position
	//will insert a new node into the list in O(m) time where m is the number of elements in the list
	//it takes this time because we are inserting the nodes alphabetically, allowing us to both find contacts and list them easier/faster
	public ContactsSLL insert(ContactsNode node) 
	{
		boolean inserted=false; //this ensure we only insert a node once
		ContactsNode tmp = this.head; //start with the head
		if(tmp==null)  //if the list is empty, make the node the head and tail
		{
			this.head = node;
			this.tail = node;
			inserted = true;
		}
		
		else if(tmp == this.tail) //if the list is a 1 node list, compare to the tmp
		{
			if( node.getContact().getName().compareToIgnoreCase(tmp.getContact().getName()) <= 0) //if the node belongs before tmp alphabetically
			{
				//make node the new head, update pointers
				this.head = node;
				node.setNext(tmp);
				inserted = true;
			
			}
			else 
			{
				//make node the new tail, update pointers
				this.tail = node;
				tmp.setNext(node);
				inserted = true;
				
			}
		}
		
		//if we have a multiple node list, first compare node with the head
		else if(tmp.getContact().getName().compareToIgnoreCase(node.getContact().getName()) > 0) // if node belongs before head alphabetically
		{
		node.setNext(tmp);
		this.head = node;
		inserted = true;
		}
		
		//if the node shouldn't be the new head, iterate through the list until you find its place
		else 
		{

			while(tmp.getNext()!= null && inserted == false) //we will compare the node to tmp and tmp.next. If it belongs between them, insert it.
			{
				int compareToCurrent = tmp.getContact().getName().compareToIgnoreCase(node.getContact().getName()); //will be < 0 if tmp belongs before node
				int compareToNext    = tmp.getNext().getContact().getName().compareToIgnoreCase(node.getContact().getName()); //will be > 0 if tmp.next belongs after node
				
				if((compareToCurrent== 0) || (compareToCurrent < 0 && compareToNext  > 0)) // if the node belongs between tmp and tmp.next
				{	
					//insert it, update pointers
					node.setNext(tmp.getNext());
					tmp.setNext(node);
					inserted = true;
				}
				else if(tmp.getNext() == this.tail) 
					//if we reach the tail, we know the node should be the tail, otherwise it would've been placed inserted in the step prior
					//where tmp.next = tail 
				{
					//make the node the tail, update pointers
						this.tail.setNext(node);
						this.tail = node;
						inserted = true;
				}
				else//if the node doesn't belong here, continue iterating through the list
				{
					tmp = tmp.getNext();
				}
			}
		}
		return this; //return the updates SLL
	}

	//takes O(m) time where m is the number of elements in the SLL
	//iterates through the SLL until it finds the node which matches the name. if there is no match, it will say "Not Found."
	public String find(String name)
	{
		ContactsNode tmp = this.head; //start with the head
		while(tmp != null) //iterate through the list until we reach the end
		{
			//if the search name matches the node's contacts' name, return the contact's values as a string
			if(tmp.getContact().getName().equals(name)) 
			{
				return tmp.getContact().toString();
			}
			//if it doesn't match, continue iterating through
			else 
			{
				tmp = tmp.getNext();
			}
		}
		//if it is never found
		return "Not found.";
	}
}


