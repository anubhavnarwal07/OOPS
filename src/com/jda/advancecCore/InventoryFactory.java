package com.jda.advancecCore;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
public class InventoryFactory {

	 public static List<Inventory> jsonToObject(String path) throws JsonParseException, JsonMappingException, IOException
		{
			ObjectMapper mapper = new ObjectMapper();
			List<Inventory> data = mapper.readValue(new File(path), new TypeReference<ArrayList<Inventory>>(){});
			return data;
	 }
	 public static void calculate(List<Inventory> allobj)
	 {
		 for(Inventory x: allobj)
		 {
				System.out.print("The amount of money it will cost to buy" + x.getName() + " is :");
				System.out.println(x.getPrice() * x.getWeight());
		 }
	 }
	 public static void main(String args[]) throws JsonParseException, JsonMappingException, IOException
	  {   String path = "/home/bridgelabz/Desktop/details.json";
	  List<Inventory> allobj = new ArrayList<>();
	  allobj = jsonToObject(path);
	  calculate(allobj);
	  }
}
