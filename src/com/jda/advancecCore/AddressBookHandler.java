package com.jda.advancecCore;

import java.util.ArrayList;
import java.util.List;
import com.jda.util.Utility;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class AddressBookHandler {
	private static String path = "/home/bridgelabz/Desktop/MyFiles";
	private static String newPath = path;
	private static List<String> allAddressBooksNames = Utility.allFilesInFolder(path);
	private static List<AddressBook> allWorkingAddressBooks = new ArrayList<>();
	static int k = 5;

	public static void createAddressBook() throws IOException {
		System.out.println("enter the name of the addressbook you want to create");
		String name = Utility.getString();
		List<String> allAddressBooksNames = Utility.allFilesInFolder(path);
		while (k ==5) {
			
			for (String x : allAddressBooksNames) {
				if ((x.equals(name + ".json"))) {
					System.out.println("please enter a new name for the address book ");
					k = 5;
					break;
				} 	k=0;
					} 

			name = Utility.getString();
		}
		newPath += "/" + name + ".json";
		File file = new File(newPath);
		file.createNewFile();
		allAddressBooksNames.add(name + ".json");

	}

	public static void openAddressBook() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		List<Person> person = new ArrayList<>();
		System.out.print(allAddressBooksNames);
		System.out.print("\nEnter the name of the address book:");
		String name = Utility.getString();
		try {
			person = mapper.readValue(new File(path + "/" + name + ".json"), new TypeReference<ArrayList<Person>>() {
			});
		} catch (IOException e) {
			person = new ArrayList<Person>();
		}
		AddressBook addressBook = new AddressBook(name);
		while (true) {
			System.out.println("1. Create a new person \n 2. ");
			System.out.println("2. Edit exisiting information");
			System.out.println("3. Delete a person");
			System.out.println("4. Sort by last name");
			System.out.println("5. Sort by zip");
			System.out.println("6. Go back to main menu");
			System.out.print("Enter choice :");
			int ans = Utility.getInt();
			Utility.getString();
			if (ans != 6) {
				switch (ans) {
				case 1: {
					person = addressBook.addField(person);
				}
					break;
				case 2: {
					person = addressBook.editField(person);
				}
					break;
				case 3: {
					person = addressBook.deleteField(person);
				}
					break;
				case 4: {
					person = addressBook.sortbyLastname(person);
				}
					break;
				case 5: {
					person = addressBook.sortbyZip(person);
				}
					break;
				}
			} else {
				break;
			}
		}
		addressBook.setAllPersons(person);
		allWorkingAddressBooks.add(addressBook);
	}

	public static void saveAddressBook() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		if (allWorkingAddressBooks.size() == 1) {
			String allInfo = mapper.writerWithDefaultPrettyPrinter()
			      .writeValueAsString(allWorkingAddressBooks.get(0).getAllPersons());
			FileWriter file = new FileWriter(path + "/" + allWorkingAddressBooks.get(0).getNameofAddressBook() + ".json");
			System.out.println(allInfo);
			file.write(allInfo);
			file.close();
		} else {
			System.out.println("Enter the name of the file to be saved:");
			String name = Utility.getString();
			for (AddressBook x : allWorkingAddressBooks) {
				if (x.getNameofAddressBook().equals(name)) {
					String allInfo = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(x.getAllPersons());
					FileWriter file = new FileWriter(path + "/" + x.getNameofAddressBook() + ".json");
					System.out.println(allInfo);
					file.write(allInfo);
					file.close();
					break;
				}
			}
		}
	}

	public static void closeAddressBook() throws JsonGenerationException, JsonMappingException, IOException {
		if (allWorkingAddressBooks.size() == 1) {
			System.out.println("Press y if you want to save the file and n otherwise");
			String decision = Utility.getString();
			Utility.getString();
			if (decision.equals("y")) {
				saveAddressBook();
			}
			allWorkingAddressBooks.remove(0);
		} else {
			System.out.println("Address Books currently open are:");
			for (AddressBook x : allWorkingAddressBooks) {
				System.out.println(x.getNameofAddressBook());
			}
			System.out.println("Enter the Address Book name you want to close:");
			String name = Utility.getString();
			System.out.println("Press y if you want to save the file and n otherwise");
			String decision = Utility.getString();
			if (decision.equals("y")) {
				saveAddressBook();
			}
			allWorkingAddressBooks.remove(name);
		}
	}

	public static void main(String[] args) throws IOException {

		while (true) {
			System.out.println("What do you want to do Miss User ? ");
			System.out.println("1. Create address book");
			System.out.println("2. Open address book");
			System.out.println("3. Close address book");
			System.out.println("4. Save address book");
			System.out.println("5. Quit");
			System.out.print("Enter choice :");
			int ans = Utility.getInt();
			Utility.getString();
			if (ans != 5) {
				switch (ans) {
				case 1: {
					System.out.println("hi");
					createAddressBook();
					break;
				}

				case 2: {
					openAddressBook();
				}
					break;
				case 3: {
					closeAddressBook();
				}
					break;
				case 4: {
					saveAddressBook();
				}
					break;
				}
			} else {
				break;
			}
		}
	}

}
