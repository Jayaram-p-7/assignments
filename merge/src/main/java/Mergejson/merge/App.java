package Mergejson.merge;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.*;

public class App {
	public static void main(String[] args) {
		String data_path = "/home/jayarap/Desktop/data/";
		String merge_path = "/home/jayarap/Desktop/merge/";
		try {
			
			JSONParser parser = new JSONParser();
			final File folder = new File(data_path);
			File[] files = folder.listFiles();

			JSONObject merge = new JSONObject();
			JSONArray mergearray = new JSONArray();
			for (File f : files) 
			{
				Object obj = parser.parse(new FileReader(data_path + f.getName()));
				JSONObject jsonObject = (JSONObject) obj;

				JSONArray array = (JSONArray) jsonObject.get("strikers");

				mergearray.addAll(array);
			}
			merge.put("strickers", mergearray);
			System.out.println(merge);
			
			FileWriter file = new FileWriter(merge_path+"merge.json");
	        file.write(merge.toJSONString());
	        file.close();
	        
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
