package com.jda.advancecCore;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.jda.util.Utility;

public class mainmethod {
	private static String path = "/home/bridgelabz/Desktop";

	public static void getInput(Inventory obj) {
		System.out.println("Please enter the name of the commodity");
		obj.setName(Utility.getString());
		System.out.println("Please enter the price of the commodity");
		obj.setPrice(Utility.getInt());
		System.out.println("Please enter the weight of the commodity");
		obj.setWeight(Utility.getInt());
		Utility.getString();
	}

	public static String ConvertToJSON(List<Inventory> allobj)
	      throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String convertedToJSON = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(allobj);
		return convertedToJSON;
	}

	public static void writeToFile(String convertedToJSON) throws IOException {
		FileWriter file = new FileWriter(path + "/details.json");
		file.write(convertedToJSON);
		file.close();
	}

	public static void calculate(List<Inventory> allobj) {
		for (Inventory x : allobj) {
			System.out.print("The amount of money it will cost to buy" + x.getName() + " is :");
			System.out.println(x.getPrice() * x.getWeight());
		}
	}

	public static void main(String args[]) throws JsonGenerationException, JsonMappingException, IOException {
		List<Inventory> allobj = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Inventory obj = new Inventory();
			getInput(obj);
			allobj.add(obj);
		}
		String str = ConvertToJSON(allobj);
		writeToFile(str);
		calculate(allobj);
	}
}
