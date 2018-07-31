package com.jda.advancecCore;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import com.jda.util.Utility;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
public class AddressBook {
	private List<Person> allPersons = new ArrayList<>();
	private String NameofAddressBook;
	public List<Person> getAllPersons() {
		return this.allPersons;
	}

	public void setAllPersons(List<Person> allPersons) {
		this.allPersons = allPersons;
	}
	public String getNameofAddressBook()
	{
		return this.NameofAddressBook;
	}
	public void setNameofAddressBook(String a)
	{
		this.NameofAddressBook = a;
	}
	public AddressBook(String a)
	{
		this.NameofAddressBook =a;
	}
	public List<Person> addField(List<Person> person) {
		Person field = new Person();
		System.out.println("Enter the name");
		field.setname(Utility.getString());

		System.out.println("Enter the address:");
		field.setaddress(Utility.getString());

		System.out.println("Enter the city");
		field.setcity(Utility.getString());

		System.out.println("Enter the state");
		field.setstate(Utility.getString());

		System.out.println("Enter the zip code :");
		field.setzip(Utility.getInt());

		System.out.println("Enter the phone number please:");
		field.setphoneNumber(Utility.getInt());
		
		person.add(field);
		return person;
	}

	public List<Person>  editField(List<Person> person) {
		System.out.println("Enter the name of the user ");
		 String name = Utility.getString();
		for (Person p : person) {
			if (p.getname().equals(name)) {
				System.out.println(
				      "Enter 1 to change phone number , 2 to change Address, 3 to change the city and 4 to change the state");
				int input = Utility.getInt();
				Utility.getString();
				switch (input) {
				case 1: {
					System.out.println("Please enter the new phone number");
					int num = Utility.getInt();
					p.setphoneNumber(num);
					break;
				}
				case 2: {
					System.out.println("Please enter the new address");
					String str = Utility.getString();
					p.setaddress(str);
					break;
				}
				case 3: {
					System.out.println("Please enter the new city");
					String str = Utility.getString();
					p.setcity(str);
				break;}
				case 4: {
					System.out.println("Please enter the new state");
					String str = Utility.getString();
					p.setstate(str);
				break;}
			}
		}
	} return person;
	}

	public List<Person> deleteField(List<Person> person) {
		System.out.println("Enter the name of the user you want to delete");
		String str = Utility.getString();
		for (Person p : person) {
			
			if (p.getname().equals(str)) {
				person.remove(p);
			}
		}
		return person;
	}



class NameComparator implements Comparator<Person> {
	@Override
	public int compare(Person arg0, Person arg1) {
		String lastName1 = arg0.getname().split(" ")[1];
		String lastName2 = arg1.getname().split("  ")[1];
		if (lastName1.compareTo(lastName2) < 0)
			return -1;
		else if (lastName1.compareTo(lastName2) > 0)
			return 1;
		else if (lastName1.equals(lastName2)) {
			String firstName1 = arg0.getname().split(" ")[0];
			String firstName2 = arg0.getname().split(" ")[0];
			if (firstName1.compareTo(firstName2) < 0)
				return -1;
			else
				return 1;
}
	return 0;	}
}

class zipComparator implements Comparator<Person> {
	@Override
	public int compare(Person c1, Person c2) {
		if (c1.getZip() < c1.getZip()){
			return -1; }
		 else if(c1.getZip() < c1.getZip())
		 {	return 1;
		} else {
		String lastName1 = c1.getname().split(" ")[1];
		String lastName2 = c2.getname().split(" ")[1];
		if (lastName1.compareTo(lastName2) < 0) {
			return -1;
		} else if (lastName1.compareTo(lastName2) > 0) {
			return 1;
		} else if (lastName1.equals(lastName2)) {
			String firstName1 = c1.getname().split(" ")[0];
			String firstName2 = c2.getname().split(" ")[0];
			if (firstName1.compareTo(firstName2) < 0) {
				return -1;
			} else {
				return 1;
			}
		}
		return 0;
	}
}
}
public List<Person> sortbyZip(List<Person> allPersons)
{
	Collections.sort(allPersons, new zipComparator());
	return allPersons;
}
public List<Person>  sortbyLastname(List<Person> allPersons)
{
	Collections.sort(allPersons, new NameComparator());
	return allPersons;
}
public void print()
{ for(Person x: allPersons)
{ System.out.println("Name : " + x.getname());
}
}
	}

