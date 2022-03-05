package climatechange;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Tester {

	public static void main(String[] args) {
		
		WeatherImp weatherTest = new WeatherImp();
		//weatherTest.writeSubjectHeaderInFile("/Users/neelthakkar/hw3proj/MidtermTwo/data/TestCSVVl.csv", "hi");
		
	ArrayList<ITemperature> data  =  weatherTest.readDataFromFile("/Users/neelthakkar/hw3proj/MidtermTwo/data/world_temp_2000-2016.csv");
		
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
//		 //TODO Auto-generated method stub
//		
		ClimateAnalyzeImp climate = new ClimateAnalyzeImp();
//		
//		ITemperature lowestMonth = climate.getLowestTempByMonth("Greenland", 2);
//		System.out.print(lowestMonth.getCountry());
//		System.out.print(lowestMonth.getCountry3LetterCode());
//		System.out.print(lowestMonth.getMonth());
//		System.out.print(lowestMonth.getYear());
//		System.out.println(lowestMonth.getTemperature(true));
//		
//		
//		ITemperature highestMonth = climate.getHighestTempByMonth("Kuwait", 2);
//		System.out.print(highestMonth.getCountry());
//		System.out.print(highestMonth.getCountry3LetterCode());
//		System.out.print(highestMonth.getMonth());
//		System.out.print(highestMonth.getYear());
//		System.out.println(highestMonth.getTemperature(true));
////		
////		ITemperature lowestYear = climate.getLowestTempByYear("Greenland", 2002);
////		System.out.print(lowestYear.getCountry());
////		System.out.print(lowestYear.getCountry3LetterCode());
////		System.out.print(lowestYear.getMonth());
////		System.out.print(lowestYear.getYear());
////		System.out.println(lowestYear.getTemperature(true));
//		
//		ITemperature highestYear = climate.getHighestTempByYear("Kuwait", 2016);
//		System.out.print(highestYear.getCountry());
//		System.out.print(highestYear.getCountry3LetterCode());
//		System.out.print(highestYear.getMonth());
//		System.out.print(highestYear.getYear());
//		System.out.println(highestYear.getTemperature(true));
		
//		//Tree Set Logic
//		Set<Integer> hi = new TreeSet<Integer>();
//		hi.add(6);
//		hi.add(8);
//		hi.add(1);
//		hi.add(7);
//		
//		for(Integer g:hi) {
//			System.out.println(g);
//		}
//		
//
//		
//		
//		
//		TreeSet<ITemperature> rng =  climate.getTempWithinRange("Russia", 15 , 16);
//	
//		for(ITemperature element: rng) {
//			System.out.println(element.getTemperature(true));
//			}
//			System.out.println( "Size is:   " + rng.size());
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
		
		
		 ArrayList<ITemperature>  hi = climate.allCountriesGetTop10HighestTemp(2);
		 for (ITemperature c:hi) {
				System.out.print(c.getCountry());
				System.out.print(c.getCountry3LetterCode());
				System.out.print(c.getMonth());
				System.out.print(c.getYear());
				System.out.println(c.getTemperature(true));
		 }
		 
		
//			ArrayList<ITemperature> allCountriesGetTop10HighestTemp = climate.allCountriesGetTop10HighestTemp(7);
//			for(int element  = 0  ; element < 10; element ++) {
//				System.out.print(allCountriesGetTop10HighestTemp.get(element).getCountry() + " ");
//				System.out.print(allCountriesGetTop10HighestTemp.get(element).getCountry3LetterCode()+ " ");
//				System.out.print(allCountriesGetTop10HighestTemp.get(element).getMonth()+ " ");
//				System.out.print(allCountriesGetTop10HighestTemp.get(element).getYear()+ " ");
//				System.out.println(allCountriesGetTop10HighestTemp.get(element).getTemperature(true));
//				
//			}
//			
//			System.out.println("¨˙ˆ¨ˆˆ∫∂∫∂∫∂∫∫∂∫∂∆∫ø´ø´∆˜ƒø√");
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
//
//					
//			
//			
			
			
			
			
		
		
		
		
		
		
	}

}
