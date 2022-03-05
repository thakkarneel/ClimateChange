package climatechange;

public class TemperatureImp implements ITemperature {

	private String country;
	private String code;
	private String month;	
	private int year;
	private double temp;


	//Contructor of type ITemperture
	
	public TemperatureImp(String country, String code, String month, int year, double temp){
		this.country = country;
		this.code = code;
		this.month = month;
		this.year = year;
		this.temp = temp;
	}
	
	//initialize
	@Override
	public String getCountry() {
		return country;

	}

	@Override
	public String getCountry3LetterCode() {
		// TODO Auto-generated method stub
		return code;
	}

	@Override
	public String getMonth() {
		// TODO Auto-generated method stub
		return month;
	}

	@Override
	public int getYear() {
		// TODO Auto-generated method stub
		return year;
	}

	@Override
	public double getTemperature(boolean getFahrenheit) {

		
		if(getFahrenheit == false) {

	         return (temp-32)*(0.5556);
		}
		return temp;
	}
	
	
}
