package climatechange;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ClimateAnalyzeImp implements IClimateAnalyzer {
	
	
	
	WeatherImp weatherTest = new WeatherImp();
	ArrayList<ITemperature> data  =  weatherTest.readDataFromFile("/Users/neelthakkar/hw3proj/MidtermTwo/data/world_temp_2000-2016.csv");
	HashMap<Integer, String> numMonthDictionary = new HashMap<Integer, String>();
	HashMap< String, Integer> monthNumDictionary = new HashMap<String, Integer>();
	
	
	//Hashmaps to get Month or number of month
	public ClimateAnalyzeImp( ) {
	    numMonthDictionary.put(1, "Jan");
	    numMonthDictionary.put(2, "Feb");
	    numMonthDictionary.put(3, "Mar");
	    numMonthDictionary.put(4, "Apr");
	    numMonthDictionary.put(5, "May");
	    numMonthDictionary.put(6, "Jun");
	    numMonthDictionary.put(7, "Jul");
	    numMonthDictionary.put(8, "Aug");
	    numMonthDictionary.put(9, "Sep");
	    numMonthDictionary.put(10, "Oct");
	    numMonthDictionary.put(11, "Nov");
	    numMonthDictionary.put(12, "Dec");
	    
		monthNumDictionary.put("Jan",1);
		monthNumDictionary.put("Feb",2);
	    monthNumDictionary.put("Mar",3);
	    monthNumDictionary.put("Apr",4);
	    monthNumDictionary.put("May",5);
	    monthNumDictionary.put("Jun",6);
	    monthNumDictionary.put("Jul",7);
	    monthNumDictionary.put("Aug",8);
	    monthNumDictionary.put("Sep",9);
	    monthNumDictionary.put("Oct",10);
	    monthNumDictionary.put("Nov",11);
	    monthNumDictionary.put("Dec",12);
	}
	
	

	@Override
	//input country and month
	public ITemperature getLowestTempByMonth(String country, int month) {

		ITemperature minObj = null;
		double min = Integer.MAX_VALUE;
		//loop through data
		for(ITemperature i: data) {
			//if objects country and month   matches input
			if(i.getCountry().equals(country) && i.getMonth().equals(numMonthDictionary.get(month))){			
				if(i.getTemperature(true) < min ) {
					min = i.getTemperature(true);
					minObj = i;
					//if temps equal check by year
				} else if(i.getTemperature(true) == min ) {
					if (i.getYear()<minObj.getYear()) {
						minObj = i;
						
					}
				}
				
			}
	
			
		}
 
		return minObj;
	}

	@Override
	public ITemperature getHighestTempByMonth(String country, int month) {
		//System.out.println(data.size());
		
		//System.out.println(numMonthDictionary.get(2));
		ITemperature maxObj = null;
		double max = Integer.MIN_VALUE;
		//checks parampeter
		for(ITemperature i: data) {
			if(i.getCountry().equals(country) && i.getMonth().equals(numMonthDictionary.get(month))){			
				if(i.getTemperature(true) > max ) {
					max = i.getTemperature(true);
					maxObj = i;
				} else if(i.getTemperature(true) == max ) {
					if (i.getYear()<maxObj.getYear()) {
						maxObj = i;
						
					}
				}
				
			}
	
			
		}
		//return highest temp by month
		return maxObj;
	}
	
	
	

	@Override
	public ITemperature getLowestTempByYear(String country, int year) {
		
		ITemperature minObj = null;
		double min = Integer.MAX_VALUE;
		//cycles through data
		for(ITemperature i: data) {
			//if country equals country and year equals year
			if(i.getCountry().equals(country) && i.getYear() == year){
				
				
				if(i.getTemperature(true)  <  min) {
					min = i.getTemperature(true);
					minObj = i;		
				}
				else if (i.getTemperature(true)  ==  min) {
					
					if ((monthNumDictionary.get(i.getMonth()) <   monthNumDictionary.get(minObj.getMonth()))){
						minObj=i;
						
						
					}
		
			}
				
		}
	}

		
		//return lowest temp by year
		return minObj;
	}

	@Override
	// gets highest temp by year
	public ITemperature getHighestTempByYear(String country, int year) {
		
		ITemperature maxObj = null;
		double max = Integer.MIN_VALUE;
		for(ITemperature i: data) {
			if(i.getCountry().equals(country) && i.getYear() == year){
			
				
				if(i.getTemperature(true)  >  max) {
					max = i.getTemperature(true);
					maxObj = i;		
				}
				else if (i.getTemperature(true)  ==  max) {
					
					if ((monthNumDictionary.get(i.getMonth()) <   monthNumDictionary.get(maxObj.getMonth()))){
						maxObj=i;
						
						
					}
				}
				
			}
		}
			
		return maxObj;

	}
	

	@Override
	public TreeSet<ITemperature> getTempWithinRange(String country, double rangeLowTemp, double rangeHighTemp) {
		// TODO Auto-generated method stub
		//create new treeset
		TreeSet<ITemperature> tempWithinRange  = new TreeSet<ITemperature>(new TempComp());
		//Cycle through data
		for (ITemperature i: data) {
			//if country equals country
			if(i.getCountry().equals(country)) {
				//if data falls between range
				if((rangeLowTemp <= i.getTemperature(true)) && (i.getTemperature(true) <=  rangeHighTemp)) {
					//then add data
					tempWithinRange.add(i);
				
			}
				
			}
	
		
	
	      }
		return tempWithinRange;
	}

	@Override
	
	//Lowesttemp by Country
	public ITemperature getLowestTempYearByCountry(String country) {
		// TODO Auto-generated method stub
		double min = Integer.MAX_VALUE;
		ITemperature minObj = null;
		//Cycle through data
		for (ITemperature i: data) {
			//If country matches continue
			if(i.getCountry().equals(country)) {
				//
				if(i.getTemperature(true)< min) {
					min = i.getTemperature(true);
					minObj =i;
				}
				//if temps equals
				else if (i.getTemperature(true)== min) {
					
				
//					ITemperature maxObj = null;
					//check by year and make sure year is an earlier data
					if (i.getYear() !=(minObj.getYear())) {
						//Go by earlier year
						if (i.getYear() < (minObj.getYear())) {
							minObj = i;
						}
					}
					//lastly  then check by month
					else if ((monthNumDictionary.get(i.getMonth()) <   monthNumDictionary.get(minObj.getMonth()))){
						minObj=i;
					
				}
			}
		}
			
		
		
	}
		return minObj;
	}
	
	public ITemperature getHighestTempYearByCountry(String country) {
		
		
		double max = Integer.MIN_VALUE;
		ITemperature maxObj = null;
		for (ITemperature i: data) {
			if(i.getCountry().equals(country)) {
				
				if(i.getTemperature(true)>max) {
					max = i.getTemperature(true);
					maxObj =i;
				}
				
				else if (i.getTemperature(true)== max) {
					
				

					
					if (i.getYear() !=(maxObj.getYear())) {
						//Go by earlier year
						if (i.getYear() < (maxObj.getYear())) {
							maxObj = i;
						}
					}
					else if ((monthNumDictionary.get(i.getMonth()) <   monthNumDictionary.get(maxObj.getMonth()))){
						maxObj=i;
					
					}
				}
			}
			
		}
		return maxObj;
	}
		
		
		


	@Override
//We want top 10 lowest temperatures
	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp(int month) {
		
		ArrayList<ITemperature> top10LowestTemp = new ArrayList<ITemperature>();
		ArrayList<ITemperature> uni10 = new ArrayList<ITemperature>();
		HashSet<String> cuntry=new HashSet<String>();
		
		
		
		
		
		double min = Integer.MIN_VALUE;
		for(ITemperature i: data) {
			if(monthNumDictionary.get(i.getMonth()) == month){
				//add to arraylist - top10LowestTemp if conditions are met
				top10LowestTemp.add(i);
				}
			}
		// sort greatest to least
		Collections.sort(top10LowestTemp, new Comparator<ITemperature>() {
			@Override
			//sort by temperature
		    public int compare(ITemperature o1, ITemperature o2) {      
		        return Double.compare(o2.getTemperature(true),o1.getTemperature(true));
		    }
		});
		//least to greatest with the reverse 
		Collections.reverse(top10LowestTemp);
		//top10HighestTemp is  sorted high to low
		for (ITemperature e: top10LowestTemp) {
			//If hashset does not have the country add to it and add the object to the new array
			if(cuntry.contains(e.getCountry())==false) {
				uni10.add(e);
				cuntry.add(e.getCountry());}
			//fill ten unique country
			if(uni10.size()==10) {
				break;
			
				
			}
		}
		
		// TODO Auto-generated method stub
		
		return uni10;
	}
	
	
	
	
	
	

	@Override
	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp(int month) {
		
		ArrayList<ITemperature> top10HighestTemp = new ArrayList<ITemperature>();
		ArrayList<ITemperature> uni10 = new ArrayList<ITemperature>();
		HashSet<String> cuntry=new HashSet<String>();
		
		
		double min = Integer.MIN_VALUE;
		for(ITemperature i: data) {
			if(monthNumDictionary.get(i.getMonth()) == month){								
					top10HighestTemp.add(i);
									 
			}
								
		}
		
		Collections.sort(top10HighestTemp, new Comparator<ITemperature>() {
			@Override
		    public int compare(ITemperature o1, ITemperature o2) {      
		        return Double.compare(o2.getTemperature(true),o1.getTemperature(true));
		    }
		});
		
		// Collections.reverse(top10HighestTemp);
		//top10HighestTemp is  sorted high to low
		for (ITemperature e: top10HighestTemp) {
			//If hashset does not have the country add to it and add the object to the new array
			if(cuntry.contains(e.getCountry())==false) {
				uni10.add(e);
				cuntry.add(e.getCountry());}
			//fill ten unique country
			if(uni10.size()==10) {
				break;
			
				
			}
		}
		
		// TODO Auto-generated method stub
		
		return uni10;
			
	}

	
	
	@Override
	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp() {
		ArrayList<ITemperature> top10LowestTemp = new ArrayList<ITemperature>();
		ArrayList<ITemperature> uni10 = new ArrayList<ITemperature>();
		HashSet<String> cuntry=new HashSet<String>();
		
		
		
		
		
		double min = Integer.MIN_VALUE;
		for(ITemperature i: data) {
//			if(monthNumDictionary.get(i.getMonth()) == month){
				top10LowestTemp.add(i);
//				}
			}
		// Collections.sort(top10LowestTemp);
		Collections.sort(top10LowestTemp, new Comparator<ITemperature>() {
			@Override
		    public int compare(ITemperature o1, ITemperature o2) {      
		        return Double.compare(o2.getTemperature(true),o1.getTemperature(true));
		    }
		});
		
		Collections.reverse(top10LowestTemp);
		//top10HighestTemp is  sorted high to low
		for (ITemperature e: top10LowestTemp) {
			//If hashset does not have the country add to it and add the object to the new array
			if(cuntry.contains(e.getCountry())==false) {
				uni10.add(e);
				cuntry.add(e.getCountry());}
			//Stop after 10 filled
			if(uni10.size()==10) {
				break;
			
				
			}
		}
		
		// TODO Auto-generated method stub
		
		return uni10;
		

	}

	
	@Override
	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp() {
		ArrayList<ITemperature> top10HighestTemp = new ArrayList<ITemperature>();
		ArrayList<ITemperature> uni10 = new ArrayList<ITemperature>();
		HashSet<String> cuntry=new HashSet<String>();
		
		
		double min = Integer.MIN_VALUE;
		for(ITemperature i: data) {
			//if(monthNumDictionary.get(i.getMonth()) == month){								
					top10HighestTemp.add(i);
									 
			
								
		}
		
		Collections.sort(top10HighestTemp, new Comparator<ITemperature>() {
			@Override
		    public int compare(ITemperature o1, ITemperature o2) {      
		        return Double.compare(o2.getTemperature(true),o1.getTemperature(true));
		    }
		});
		
		// Collections.reverse(top10HighestTemp);
		//top10HighestTemp is  sorted high to low
		for (ITemperature e: top10HighestTemp) {
			//If hashset does not have the country add to it and add the object to the new array
			if(cuntry.contains(e.getCountry())==false) {
				uni10.add(e);
				cuntry.add(e.getCountry());}
			//10 filled then stop, will be 10 unique
			if(uni10.size()==10) {
				break;
			
				
			}
		}
		

		
		return uni10;
		

	}

	
	
	@Override
	public ArrayList<ITemperature> allCountriesGetAllDataWithinTempRange(double lowRangeTemp, double highRangeTemp) {

		
		ArrayList<ITemperature> tempRange = new ArrayList<ITemperature>();
	
		ArrayList<ITemperature> uni10 = new ArrayList<ITemperature>();
		HashSet<String> cuntry=new HashSet<String>();
		//get data within range
		for (ITemperature i: data) {
			if((lowRangeTemp <= i.getTemperature(true)) && (i.getTemperature(true) <=  highRangeTemp)) {
				tempRange.add(i);
				
			}
		}
		//sort least to greatest
			Collections.sort(tempRange, new Comparator<ITemperature>() {

			@Override
			public int compare(ITemperature o1, ITemperature o2) {
		       
			        return Double.compare(o1.getTemperature(true),o2.getTemperature(true));//least to greatest
			    }

			});
			
	
			
			//hashset containing unique contryies only
			for (ITemperature e: tempRange) {
				
				if(cuntry.contains(e.getCountry())==false) {
					uni10.add(e);
					cuntry.add(e.getCountry());}

				
					
				}
			
		return uni10;
	}
	
	
	
	
	
		
	@Override
	public ArrayList<ITemperature> allCountriesTop10TempDelta(int month, int year1, int year2) {
		
		ArrayList<ITemperature> uni10 = new ArrayList<ITemperature>();
		HashSet<String> cuntry=new HashSet<String>();
		
		ArrayList <ITemperature> deltas = new ArrayList();

		ArrayList <ITemperature> yee1 = new ArrayList();
		ArrayList <ITemperature> yee2 = new ArrayList();
		
		//if month matches add year to respective arraylist
		for(ITemperature i: data) {
			if(monthNumDictionary.get(i.getMonth()) == month) {
				
				if(i.getYear()==year1) {
					yee1.add(i);
				}
				else if (i.getYear()==year2) {
					yee2.add(i);
				}
			}
		}
		//makes sure countries are matching 
		for( ITemperature y1: yee1) {
			for( ITemperature y2: yee2) {
				if(y1.getCountry().equals(y2.getCountry())) {
					double delt = Math.abs(y1.getTemperature(true)-y2.getTemperature(true));
					TemperatureImp diff = new TemperatureImp(y1.getCountry(), y1.getCountry3LetterCode(), y1.getMonth(), y2.getYear(), delt);
					//add diff objec ot delta
					deltas.add(diff);
			}
		}
				
				

				
		}
		//sort delta
		Collections.sort(deltas, new Comparator<ITemperature>() {

		    @Override
		    public int compare(ITemperature o1, ITemperature o2) {
		       
		        return Double.compare(o2.getTemperature(true),o1.getTemperature(true));
		    }

		});
		
		Collections.reverse(deltas);
		//top10HighestTemp is  sorted high to low
		for (ITemperature e: deltas) {
			//unique countries
			if(cuntry.contains(e.getCountry())==false) {
				uni10.add(e);
				cuntry.add(e.getCountry());}
			
			if(uni10.size()==10) {
				break;
			
				
			}
		
		
		// TODO Auto-generated method stub
		}
		return uni10;
		
	}
		
	
	
	
	

	@Override
	public void runClimateAnalyzer() {
//		 TASK A ----	TASK A	  ----		TASK A  ----		TASK A  ----	TASK A	  ----	TASK A
		
		WeatherImp weather = new WeatherImp();
		
		
		System.out.println("TASK A1:      ");
		
		System.out.println("");
		System.out.println("  ");
		
		
		
		  Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		  
		  
		  
		  System.out.println("Enter a country: ");
		  String country = myObj.nextLine();  // Read user input
		  
		  //month
		 
		  
		  // int month = 0;
		 
		  try {
			  
			  
			  int month = 0;
			  
			  try {
				  while (!(month >= 1 && month <= 12 ) )  {
					  
					  System.out.print("Enter a month as a number between 1 to 12 to find lowest and highest tempreture in that month with that given country: ");
					  month = myObj.nextInt();
					  
				  } 
			  } catch (Exception e) {
				  System.out.println("Invalid month entered. Enter a month as a number between 1 to 12 to find lowest and highest tempreture in that month with that given country: ");
				  month = myObj.nextInt();
			  }
			  
			
			  
			  ITemperature lowest = getLowestTempByMonth(country, month);  // Output user input
			  ITemperature highest = getHighestTempByMonth(country, month); 
			  System.out.println("Lowest temperature in that month with that given country is: " +lowest.getTemperature(true) + 
					  "  Highest temperature in that month with that given country is: " +highest.getTemperature(true));
			  System.out.println("");
			  ArrayList<ITemperature> low = new ArrayList<ITemperature>() ;
			  low.add(lowest);
			  ArrayList<ITemperature> high = new ArrayList<ITemperature>() ;
			  high.add(highest);
			  
				try {
					weather.writeDataToFile("A1", "LowTempByMonth.csv",  low);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				  
				try {
					weather.writeDataToFile("A1", "HighTempByMonth.csv",  high);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
		  }
		  }
		  
		 
		  
			  catch (Exception e) {
			      System.out.println("Enter Country First letter Captial");
			      ClimateAnalyzeImp climate = new ClimateAnalyzeImp();
					
				climate.runClimateAnalyzer();
		
			     // break;
			      
				  
//				  System.out.println("Enter a country: ");
//				  String cont = myObj.nextLine();  // Read user input
//			      
//				  int month = Integer.parseInt(myObj.nextLine()); 
//				  ITemperature lowest = getLowestTempByMonth(cont, month);  // Output user input
//				  ITemperature highest = getHighestTempByMonth(cont, month); 
//				  System.out.println("Lowest temperature in that month with that given country is: " +lowest.getTemperature(true) + 
//						  "  Highest temperature in that month with that given country is: " +highest.getTemperature(true));
//				  System.out.println("");
			      
		  }
		  

		  

		  
		  System.out.println("DONE");
		  System.out.println("________________________________________________________________________________________");
		  System.out.println("TASK A2");
		  
		  
		  

		//  String country = country;
		  
		  //year
		  System.out.print("Enter a year to find lowest and highest tempreture in that year for " + country + ": ");
		  int year = myObj.nextInt(); 
		  ITemperature lowestYear = getLowestTempByYear( country,  year);  // Output user input
		  ITemperature highestYear = getHighestTempByYear(country, year); 
		  System.out.println("Lowest temperature that year with that given country is: " +lowestYear.getTemperature(true) +  
				 "  Highest temperature in that year with that given country is: " +highestYear.getTemperature(true));; 
				 // "  Highest temperature that year with that given country is: " +highestYear.getTemperature(true));			 
		  System.out.println("");
		  
		  ArrayList<ITemperature> lowTempYear = new ArrayList<ITemperature>() ;
		  lowTempYear.add(lowestYear);
		  ArrayList<ITemperature> highTempYear = new ArrayList<ITemperature>() ;
		  highTempYear.add(highestYear);
		  
			try {
				weather.writeDataToFile("A2", "LowTempByYear.csv",  lowTempYear);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			  
			try {
				weather.writeDataToFile("A2", "HighTempByYear.csv",  highTempYear);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
		  
		  System.out.println("DONE");
		  System.out.println("________________________________________________________________________________________");
		  System.out.println("TASK A3");
		  
		  
		  
		  System.out.println("Enter a range for tempretures  between lowerBound and UpperBounds");
		  System.out.println("Enter a temperature (Celcius) lowerBound: ");
		  int lowerBound = myObj.nextInt();
		  System.out.println("Enter a temperature (Celcius) upperBound: ");
		  int upperBound = myObj.nextInt();
		  TreeSet<ITemperature> bound = getTempWithinRange(country, lowerBound, upperBound);		  
		  for (ITemperature b:bound) {
			  System.out.println(b.getTemperature(true));		  
		  }
		  
		  ArrayList<ITemperature> bd = new ArrayList<ITemperature>() ;
		  
		  for (ITemperature b:bound) {
			  bd.add(b);		  
		  }
		  
		  
			try {
				weather.writeDataToFile("A3", "TempBound.csv",  bd);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  
		  System.out.println("DONE");
		  System.out.println("________________________________________________________________________________________");
		  System.out.println("TASK A4");
		  
		  System.out.println("Year with the lowest temperature and for the year with the highest temperature reading");
		  
		  ITemperature lowestTemp = getLowestTempYearByCountry(country);
		  ITemperature highestTemp = getHighestTempYearByCountry(country);
		  System.out.println("Year with lowest Temperature:    " + lowestTemp.getYear());
		  System.out.println("Year with highest Temperature:    " + highestTemp.getYear());
		  
		  ArrayList<ITemperature> lowTempCountry = new ArrayList<ITemperature>() ;
		  lowTempCountry.add(lowestTemp);
		  ArrayList<ITemperature> highTempCountry = new ArrayList<ITemperature>() ;
		  highTempCountry.add(highestTemp);
		  
			try {
				weather.writeDataToFile("A4", "LowTempByYear.csv",  lowTempCountry);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			  
			try {
				weather.writeDataToFile("A4", "HighTempByYear.csv",  highTempCountry);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
		  
		  
		  
		  System.out.println("DONE");
		  System.out.println("________________________________________________________________________________________");
		  System.out.println("TASK B1");
		  
		  
		  
		  System.out.println("Enter a month as a number to find lowest and highest top 10 tempretures in that month : ");
		  int monthz = myObj.nextInt(); 
  
			ArrayList<ITemperature> allCountriesGetTop10HighestTemp = allCountriesGetTop10HighestTemp(monthz);
			ArrayList<ITemperature> allCountriesGetTop10LowestTemp = allCountriesGetTop10LowestTemp(monthz);
			
			
			
			try {
				weather.writeDataToFile("B1", "Low.csv",  allCountriesGetTop10LowestTemp);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				weather.writeDataToFile("B1", "High.csv",  allCountriesGetTop10HighestTemp);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//public void writeDataToFile(String filename, String topic, ArrayList<ITemperature> theWeatherList) throws IOException;

			// Output user input
			System.out.println("LOWEST: ");
			for(ITemperature e: allCountriesGetTop10LowestTemp) {
				System.out.println(e.getCountry() + " ");
//				System.out.print(e.getCountry3LetterCode()+ " ");
//				System.out.print(e.getMonth()+ " ");
//				System.out.print(e.getYear()+ " ");
//				System.out.println(e.getTemperature(true));
			}
			
			System.out.println("");
			System.out.println("");
			
			
			
			System.out.println("HIGHEST: ");
			for(ITemperature e: allCountriesGetTop10HighestTemp) {
				System.out.println(e.getCountry() + " ");
//				System.out.print(e.getCountry3LetterCode()+ " ");
//				System.out.print(e.getMonth()+ " ");
//				System.out.print(e.getYear()+ " ");
//				System.out.println(e.getTemperature(true));
			}
			System.out.println("");
			System.out.println("");	
			
			
			System.out.println("DONE");
			  System.out.println("________________________________________________________________________________________");
			  System.out.println("TASK B2");
			  
			System.out.println("Top 10 countries with the lowest temperature reading between 2000 and 2016");
			
			ArrayList<ITemperature> all_Low = allCountriesGetTop10LowestTemp();
			System.out.println("LOWEST: ");
			
			//System.out.println("SIZE: " + all_Low.size());
			
			for(ITemperature e: all_Low) {
				System.out.println(e.getCountry() + " ");
//				System.out.print(e.getCountry3LetterCode()+ " ");
//				System.out.print(e.getMonth()+ " ");
//				System.out.print(e.getYear()+ " ");
//				System.out.println(e.getTemperature(true));
			}
			
			System.out.println("");
			System.out.println("");			
			System.out.println("Top 10 countries with the Highest temperature reading between 2000 and 2016");
			
			ArrayList<ITemperature> all_High = allCountriesGetTop10HighestTemp();
			System.out.println("HIGHEST: ");
			
			//System.out.println("SIZE: " + all_Low.size());
			
			for(ITemperature e: all_High) {
				System.out.println(e.getCountry() + " ");
//				System.out.print(e.getCountry3LetterCode()+ " ");
//				System.out.print(e.getMonth()+ " ");
//				System.out.print(e.getYear()+ " ");
//				System.out.println(e.getTemperature(true));
			}
			
//			ArrayList<ITemperature> allCountriesGetTop10HighestTemp = allCountriesGetTop10HighestTemp(monthz);
//			ArrayList<ITemperature> allCountriesGetTop10LowestTemp = allCountriesGetTop10LowestTemp(monthz);
			
			
			
			try {
				weather.writeDataToFile("B2", "TenLowAllCountry.csv",  all_Low);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				weather.writeDataToFile("B2", "TenHighAllCountry.csv",  all_High);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.out.println("");
			System.out.println("");
			
			
			System.out.println("DONE");
			  System.out.println("________________________________________________________________________________________");
			  System.out.println("TASK B3");
			  
			
			System.out.println("We will get all countries within the given range. ");
			System.out.println("Enter LowerBound Temperature:    ");
			int lBound = myObj.nextInt();
			
			System.out.println("Enter UpperBound Temperature:	 ");
			int uBound = myObj.nextInt();
			
			
			ArrayList<ITemperature> allCountryRange = allCountriesGetAllDataWithinTempRange(lBound, uBound);
			for(ITemperature e: allCountryRange) {
				System.out.println(e.getCountry() + " ");
//				System.out.print(e.getCountry3LetterCode()+ " ");
//				System.out.print(e.getMonth()+ " ");
//				System.out.print(e.getYear()+ " ");
//				System.out.println(e.getTemperature(true));
			}
			
			System.out.println("");
			System.out.println("");
			System.out.println("");
			
			try {
				weather.writeDataToFile("B3", "AllCountryBound.csv",  allCountryRange);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.out.println("DONE");
			  System.out.println("________________________________________________________________________________________");
			  System.out.println("TASK C1");
			  
			System.out.println("The top 10 countries with the largest change in temperature in the same month between two different years");
			System.out.println("Enter Month: ");
			int mth = myObj.nextInt();
			System.out.println("Enter First  Year: ");
			int year1 = myObj.nextInt();
			System.out.println("Enter Second  Year: ");
			int year2 = myObj.nextInt();
			
			
			
			
			ArrayList<ITemperature> delt = allCountriesTop10TempDelta(mth, year1, year2);
			
			for(ITemperature e: delt) {
				System.out.println(e.getCountry() + " ");
//				System.out.print(e.getCountry3LetterCode()+ " ");
//				System.out.print(e.getMonth()+ " ");
//				System.out.print(e.getYear()+ " ");
//				System.out.println(e.getTemperature(true));
			}
			
			try {
				weather.writeDataToFile("C1", "AllCountriesTop10TempDelta.csv",  delt);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.out.println("DONE");
			  System.out.println("________________________________________________________________________________________");
			  System.out.println("");
			  
			  
			
	
		
		
	}
	
	
	
public static void main(String[] args) {
		
	//WeatherImp weatherTest = new WeatherImp();
		//weatherTest.writeSubjectHeaderInFile("/Users/neelthakkar/hw3proj/MidtermTwo/data/world_temp_2000-2016.csv", "Hi");
		
	//ArrayList<ITemperature> data  =  weatherTest.readDataFromFile("/Users/neelthakkar/hw3proj/MidtermTwo/data/world_temp_2000-2016.csv");
		
//		for(ITemperature i: data) {
//			System.out.print(i.getCountry());
//			System.out.print(i.getCountry3LetterCode());
//			System.out.print(i.getMonth());
//			System.out.print(i.getYear());
//			System.out.println(i.getTemperature(true));
//			
//		}
//		
//		
//		System.out.println(data.size());
		 //TODO Auto-generated method stub
		
		ClimateAnalyzeImp climate = new ClimateAnalyzeImp();
		
		climate.runClimateAnalyzer();
		
//		ITemperature lowestMonth = climate.getLowestTempByMonth("Greenland", 2);
//		System.out.print(lowestMonth.getCountry() + " ");
//		System.out.print(lowestMonth.getCountry3LetterCode() + " ");
//		System.out.print(lowestMonth.getMonth() + " ");
//		System.out.print(lowestMonth.getYear() + " ");
//		System.out.println(lowestMonth.getTemperature(true));
//		
//		
//		ITemperature highestMonth = climate.getHighestTempByMonth("Kuwait", 7);
//		System.out.print(highestMonth.getCountry());
//		System.out.print(highestMonth.getCountry3LetterCode());
//		System.out.print(highestMonth.getMonth());
//		System.out.print(highestMonth.getYear());
//		System.out.println(highestMonth.getTemperature(true));
//		
//		ITemperature lowestYear = climate.getLowestTempByYear("Greenland", 2002);
//		System.out.print(lowestYear.getCountry());
//		System.out.print(lowestYear.getCountry3LetterCode());
//		System.out.print(lowestYear.getMonth());
//		System.out.print(lowestYear.getYear());
//		System.out.println(lowestYear.getTemperature(true));
//		
//		ITemperature highestYear = climate.getHighestTempByYear("Kuwait", 2016);
//		System.out.print(highestYear.getCountry());
//		System.out.print(highestYear.getCountry3LetterCode());
//		System.out.print(highestYear.getMonth());
//		System.out.print(highestYear.getYear());
//		System.out.println(highestYear.getTemperature(true));
//		
////		//Tree Set Logic
////		Set<Integer> hi = new TreeSet<Integer>();
////		hi.add(6);
////		hi.add(8);
////		hi.add(1);
////		hi.add(7);
////		
////		for(Integer g:hi) {
////			System.out.println(g);
////		}
//		
//
//		
//		
//		
//		TreeSet<ITemperature> rng =  climate.getTempWithinRange("Russia", 15 , 16);
//	
//		for(ITemperature element: rng) {
//			//System.out.println(element.getTemperature(true));
//			}
//			//System.out.println( "Size is:   " + rng.size());
//
//			
//			
//			
//			ITemperature LowestTempYearByCountry = climate.getLowestTempYearByCountry("Rwanda");
//			System.out.print(LowestTempYearByCountry.getCountry() + " ");
//			System.out.print(LowestTempYearByCountry.getCountry3LetterCode()+ " ");
//			System.out.print(LowestTempYearByCountry.getMonth()+ " ");
//			System.out.print(LowestTempYearByCountry.getYear()+ " ");
//			System.out.println(LowestTempYearByCountry.getTemperature(true));
//			
//			ArrayList<ITemperature> allCountriesGetTop10HighestTemp = climate.allCountriesGetTop10HighestTemp(7);
//			for(int element  = 0  ; element < 10; element ++) {
//				System.out.print(allCountriesGetTop10HighestTemp.get(element).getCountry() + " ");
//				System.out.print(allCountriesGetTop10HighestTemp.get(element).getCountry3LetterCode()+ " ");
//				System.out.print(allCountriesGetTop10HighestTemp.get(element).getMonth()+ " ");
//				System.out.print(allCountriesGetTop10HighestTemp.get(element).getYear()+ " ");
//				System.out.println(allCountriesGetTop10HighestTemp.get(element).getTemperature(true));
//				
//			}
//			for(ITemperature element: allCountriesGetTop10HighestTemp) {
//				System.out.println(element.getCountry() + " ");
//				System.out.print(element.getCountry3LetterCode()+ " ");
//				System.out.print(element.getMonth()+ " ");
//				System.out.print(element.getYear()+ " ");
//				System.out.println(element.getTemperature(true));
//			}
//			
//			System.out.println("-------------------------------------------");
//			
//
//			ArrayList<ITemperature> top10HighestDeltaTemp = climate.allCountriesTop10TempDelta(2,2014,2016 );
//			for(ITemperature element: top10HighestDeltaTemp) {
//				System.out.print(element.getCountry() + " ");
//				System.out.print(element.getCountry3LetterCode()+ " ");
//				System.out.print(element.getMonth()+ " ");
//				System.out.print(element.getYear()+ " ");
//				System.out.println(element.getTemperature(true));
//			}

					
			
			
			
			
			
			
		
		
		
		
		
		
	}
	
	
	

}










class TempComp implements Comparator<ITemperature>{

	@Override
	public int compare(ITemperature o1, ITemperature o2) {
		// TODO Auto-generated method stub
		if  (o1.getTemperature(false) > o2.getTemperature(false)) {
			return -1;}
		else {
				return 1;
		}

		
	}
	
}





