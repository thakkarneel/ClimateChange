package climatechange;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class WeatherImp implements IWeatherIO {

	@Override
	public ArrayList<ITemperature> readDataFromFile(String fileName) {
		
		ArrayList<ITemperature> data = new ArrayList<ITemperature>();
		
		//read filename
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    String line;
		    br.readLine();
		    while ((line = br.readLine()) != null) {
		    	String[] values = line.split(", ");
		    	
		    	//calls into contructor
		    	TemperatureImp tee = new TemperatureImp(values[3], values[4], values[2], Integer.parseInt(values[1]), Double.parseDouble(values[0]));
		    	data.add(tee);
		    	//System.out.println(line);
//		        String[] values = line.split(",");
//		        data.add(Arrays.asList(values));
		    }
		} catch (Exception e){
			System.out.println(e);
			
		}
				
				
		// TODO Auto-generated method stub
		 return data;
		
	}

	@Override
	public void writeSubjectHeaderInFile(String filename, String subject) {
		// TODO Auto-generated method stub
		
		try {
		      FileWriter myWriter = new FileWriter(filename);
		      //PrintWriter pWriter = new PrintWriter(myWriter);
		      myWriter.write(subject+", ");
		      myWriter.write("Temperature, Year, Month_Avg, Country, Country_Code");
		      myWriter.close();

		  
		      //System.out.println("Successfully wrote to the file.");
		      //System.out.println(myWriter);
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		     // e.printStackTrace();
		    }
		
	}

	@Override
	public void writeDataToFile(String filename, String topic, ArrayList<ITemperature> theWeatherList) throws IOException {


		//file path
		String filePath = "data/" + filename+"_"+topic;
		

		
		//create new file
		File f = new File(filePath);
		f.createNewFile();
		FileWriter  fw = new FileWriter(filePath);
		
		//header
		fw.write("Temperature C°, Temperature F°, Year, Month_Avg, Country, Country_Code");
		//new line
		fw.write(System.getProperty( "line.separator" ));
		 
		//add everything to arraylist
		for (ITemperature i :theWeatherList) {
			double fah = Math.round(i.getTemperature(true)*100/100);
			double cel = Math.round(i.getTemperature(false)*100/100);
			fw.write(cel+" C°, " + fah + " F°, " + i.getYear() + ", " + i.getMonth() + ", " + i.getCountry() + ", " + i.getCountry3LetterCode());
			fw.write(System.getProperty( "line.separator" ));
			
		}
		
		fw.close();
		// pw.close();

		
		
		
	}

}

