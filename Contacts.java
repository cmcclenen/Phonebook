//Cayce McClenen - 260735309

public class Contacts
{
	protected String name, phone; // all contacts have at least a name and phone number
	public String getName() {
		return this.name;
	}


	public static class Friend extends Contacts 
	{
		private String address, birthdate; // Friends also have an address and birth date
		
		public Friend(String name, String phone, String address, String birthdate) //constructor 
		{
			this.name      = name;
			this.phone     = phone;
			this.address   = address;
			this.birthdate = birthdate;
		}
		
		public String toString() //will take the Friend's values and turn them into a string
		{
			return "Friend " + this.name + " " + this.phone + " " + this.address + " " + this.birthdate;
		}
	}

	public static class Acquaintance extends Contacts
	{
		public Acquaintance(String name, String phone)
		{
			this.name  = name;
			this.phone = phone;
		}
		
		public String toString() //will take the Acquaintance's values and turn them into a string
		{
			return "Acquaintance " + this.name + " " + this.phone;
		}
	}

	public static class Business extends Contacts
	{
		private String address, businessName; // Business's also have an address and business name
		
		public Business(String name, String phone, String address, String businessName)
		{
			this.name         = name;
			this.phone        = phone;
			this.address      = address;
			this.businessName = businessName;
		}
		
		public String toString() //will take the Business's values and turn them into a string
		{
			return "Business " + this.name + " " + this.phone + " " + this.address + " " + this.businessName;
		}
	}
}