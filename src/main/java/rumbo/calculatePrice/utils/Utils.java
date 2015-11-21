package rumbo.calculatePrice.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import rumbo.calculatePrice.pojos.Flight;
import rumbo.calculatePrice.pojos.InfantPrice;
import rumbo.calculatePrice.pojos.Pax;


/**
 * Class with utils and auxiliary methods
 * @author David Delgado
 *
 */
public class Utils
{
	/**
	 * Read a csv file that keeps flights information
	 * @return A list with flight data. An empty list if there aren't any flights in the file
	 */
	public static List<Flight> readCSVFlights()
    {
		System.out.println("Begin readCSVFlights method");
    	String csvFile = "resources/flights.csv";
    	System.out.println("Csv file to read: " + csvFile);
    	BufferedReader br = null;
    	String line = "";
    	String token = ",";
    	List<Flight> resultList = new ArrayList<Flight>();
    	try
    	{
    		br = new BufferedReader(new FileReader(csvFile));
    		while ((line = br.readLine()) != null)
    		{
    			String[] csvElement = line.split(token);
    			Flight flight = new Flight();
    			flight.setOrigin(csvElement[0]);
    			flight.setDestiation(csvElement[1]);
    			flight.setAirline(csvElement[2]);
    			flight.setPrice(new BigDecimal(csvElement[3]).setScale(2, BigDecimal.ROUND_HALF_DOWN));
    			resultList.add(flight);
    		}

    	} catch (FileNotFoundException fe) {
    		System.err.println("File " + csvFile + " not found");
    		fe.printStackTrace();
    	} catch (IOException ioe) {
    		System.err.println("An error has happened reading the file " + csvFile);
    		ioe.printStackTrace();
    	} finally {
    		if (br != null) {
    			try {
    				br.close();
    			} catch (IOException e) {
    				System.err.println("An error has happened reading the file " + csvFile);
    				e.printStackTrace();
    			}
    		}
    	}
    	return resultList;
    }


	public static List<InfantPrice> readCSVInfantPrices()
    {
		System.out.println("Begin readCSVInfantPrices method");
    	String csvFile = "resources/infantPrices.csv";
    	System.out.println("Csv file to read: " + csvFile);
    	BufferedReader br = null;
    	String line = "";
    	String token = ",";
    	List<InfantPrice> resultList = new ArrayList<InfantPrice>();
    	try
    	{
    		br = new BufferedReader(new FileReader(csvFile));
    		while ((line = br.readLine()) != null)
    		{
    			String[] csvElement = line.split(token);
    			InfantPrice infantPrice = new InfantPrice();
    			infantPrice.setIATACode(csvElement[0]);
    			infantPrice.setPrice(new BigDecimal(csvElement[1]).setScale(2, BigDecimal.ROUND_HALF_DOWN));
    			resultList.add(infantPrice);
    		}

    	} catch (FileNotFoundException fe) {
    		System.err.println("File " + csvFile + " not found");
    		fe.printStackTrace();
    	} catch (IOException ioe) {
    		System.err.println("An error has happened reading the file " + csvFile);
    		ioe.printStackTrace();
    	} finally {
    		if (br != null) {
    			try {
    				br.close();
    			} catch (IOException e) {
    				System.err.println("An error has happened reading the file " + csvFile);
    				e.printStackTrace();
    			}
    		}
    	}
    	return resultList;
    }


	/**
	 * Check if Pax is null or any of its attributes is negative
	 * @param pax Object to check
	 * @return False id Pax is null or any of its attributes is negative
	 */
	public static boolean isValidPax(Pax pax)
	{
		if (pax == null || pax.getNumAdults() < 0 || pax.getNumChildren() < 0 || pax.getNumInfants() < 0)
			return false;

		return true;
	}
}
