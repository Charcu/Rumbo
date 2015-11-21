package rumbo.calculatePrice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rumbo.calculatePrice.pojos.Flight;
import rumbo.calculatePrice.pojos.InfantPrice;
import rumbo.calculatePrice.pojos.Pax;
import rumbo.calculatePrice.pojos.TotalPrice;
import rumbo.calculatePrice.utils.Utils;

/**
 * It calculates the price of a flight according to the origin, destination, date of the flight and the number of the people that flights
 * @author David Delgado
 *
 */
public class CalculatePrice
{
	private static List<Flight> listFlights = null;
	private static List<InfantPrice> listInfantPrices = null;

	/**
	 * Constructor. Initialize the variables from csv files
	 */
	public CalculatePrice()
	{
		if (listFlights == null)
			listFlights = Utils.readCSVFlights();
		if (listInfantPrices == null)
			 listInfantPrices = Utils.readCSVInfantPrices();
	}


	/**
	 * Get the available flights and its price
	 * @param origin: airport origin of the flight
	 * @param destination: airport destination of the flight
	 * @param flightDate: date of the flight departure
	 * @param pax: amount of people in this search of flights
	 * @return List of available flights and its price. Null if there isn't any available flights or input data are wrong
	 */
    public List<TotalPrice> searchFlightPrice(String origin, String destination, Date flightDate, Pax pax)
    {
    	System.out.println("Begin getFlightPrice method");
    	List<TotalPrice> totalPrices = null;

    	if (!Utils.isValidPax(pax)) {
    		System.out.println("Incorrect input data. Pax is not valid");
    		return null;
    	}
    	else if (flightDate == null)
    	{
    		System.out.println("Incorrect input data. flightDate can't be null");
    		return null;
    	}
    	else if (origin == null || destination == null)
    	{
    		System.out.println("Incorrect input data. origin or destination can't be null");
    		return null;
    	}


        List<Flight> flights = getFlights(origin, destination);

        if (!flights.isEmpty())
        {
           	totalPrices = calculatePrices(pax, flights, flightDate);
           	if (totalPrices == null)
           		System.out.println("Incorrect input data");
           	else
           		showResults(totalPrices);
        }
        else
        {
        	System.out.println("There are not any flights from " + origin + " to " + destination);
        }
        return totalPrices;
    }


    /**
     * Get all the flights with an origin and a destination
     * @param origin: airport origin of the flight
     * @param destination: airport destination of the flight
     * @return List of flights with this origin and destination. An empty list if there isn't any available flights
     */
	private List<Flight> getFlights(String origin, String destination)
    {
		System.out.println("Begin getFlights method");
    	List<Flight> resultList = new ArrayList<Flight>();
    	for (Flight flight : listFlights)
    	{
    		if (flight.getOrigin().equals(origin) && flight.getDestiation().equals(destination))
    		{
				resultList.add(flight);
    		}
    	}
		return resultList;
	}


	/**
	 * Calculate the price of a price according to the flight, the quantity of people and date of flight
	 * @param pax: number and type of people in the flight
	 * @param flights: list of available flights
	 * @param flightDate: date of the flight
	 * @return List with available flights and their price. An empty list if there isn't any flights. Null if input data are wrong
	 */
	private List<TotalPrice> calculatePrices(Pax pax, List<Flight> flights, Date flightDate)
	{
		System.out.println("Begin calculatePrices method");
		List <TotalPrice> result = new ArrayList<TotalPrice>();

		BigDecimal priceVariation = getPriceDateVariation(flightDate);
		if (priceVariation == null)
			return null; //Invalid date

		for (Flight flight : flights)
		{
			BigDecimal priceInfant = null;
			if (pax.getNumInfants() != 0)
				priceInfant = getPriceInfant(flight.getAirline());

			BigDecimal price = flight.getPrice();
			TotalPrice totalPrice = new TotalPrice();

			BigDecimal subtotal = priceVariation.multiply(price);
			//Children pay only 20% of the adult full price.
			//Project's documentation says "child: 20% discount of the price calculated according to the days to departure date rule" but later, in calculations,
			//it is used 20% of the total price (80% discount)--> IB2171, 543.9 € (150% of 259 + 2 * 20% of (150% of 259))
			BigDecimal subtotalPax = new BigDecimal(pax.getNumAdults() + pax.getNumChildren()*0.2).setScale(2, BigDecimal.ROUND_HALF_DOWN);
			subtotal = subtotal.multiply(subtotalPax);

			if (pax.getNumInfants() == 0)
			{
				//There are not any infants in the search
				totalPrice.setInfantAvailable(true);
				totalPrice.setTotalPrice(subtotal);
			}
			else if (priceInfant != null && pax.getNumInfants() != 0)
			{
				//There are infants in the search and the airline has infants prices
				totalPrice.setInfantAvailable(true);
				BigDecimal subtotalInfants = priceInfant.multiply(new BigDecimal(pax.getNumInfants()).setScale(2, BigDecimal.ROUND_HALF_DOWN));
				totalPrice.setTotalPrice(subtotal.add(subtotalInfants).setScale(2, BigDecimal.ROUND_HALF_DOWN));
			}
			else
			{
				//Airline doesn't have infant prices
				totalPrice.setInfantAvailable(false);
				totalPrice.setTotalPrice(null);
			}
			totalPrice.setFlight(flight.getAirline());
			result.add(totalPrice);
		}
		return result;
	}


	/**
	 * Get airline infant price.
	 * @param flight: name of the selected flight
	 * @return The infant price for the airline. Return null if the airline doesn't have infants price
	 */
	private BigDecimal getPriceInfant(String flight)
	{
		System.out.println("Begin getPriceInfant method");
		String airline = flight.substring(0, 2); //Airline name is in the two first characters of the flight
		for (InfantPrice infantPrice : listInfantPrices)
		{
			if (infantPrice.getIATACode().equals(airline))
				return infantPrice.getPrice();
		}
		return null;
	}


	/**
	 * Get the price variation of a flight in function of the date of the flight
	 * @param flightDate: date of the flight
	 * @return Price variation (0.8, 1, 1.2, 1.5). Null is flight date is before than today
	 */
	private BigDecimal getPriceDateVariation(Date flightDate)
	{
		System.out.println("Begin getPriceDateVariation method");
		long nowDate = new Date().getTime();
		long timeFlight = flightDate.getTime();
		long timeDifference = timeFlight - nowDate;
		int daysDifference = Long.valueOf(timeDifference / (24 * 60 * 60 * 1000)).intValue();

		if (timeDifference < 0 && daysDifference < 0) //Flight date is before than today
		{
			System.out.println("Flight date is before than today");
			return null;
		} else if (timeDifference < 0 && daysDifference == 0) { //Flight date is before than today
			System.out.println("Flight date is today");
		} else {
			daysDifference++; //There is a difference in milliseconds between flightDate and nowDate, I increase the variable in one day to compensate
			System.out.println("daysDifference " + daysDifference);
		}

		if (daysDifference > 30)
			return new BigDecimal(0.8).setScale(2, BigDecimal.ROUND_HALF_DOWN); //80% of base price
		else if (daysDifference >= 16)
			return new BigDecimal(1).setScale(2, BigDecimal.ROUND_HALF_DOWN); //100% of base price
		else if (daysDifference >= 3)
			return new BigDecimal(1.2).setScale(2, BigDecimal.ROUND_HALF_DOWN); //120% of base price
		else
			return new BigDecimal(1.5).setScale(2, BigDecimal.ROUND_HALF_DOWN); //150% of base price
	}


	/**
	 * Shows in console the flights and their prices
	 * @param totalPrices
	 */
	private void showResults(List<TotalPrice> totalPrices)
	{
		System.out.println("Begin showResults method");
		for (TotalPrice tPrice : totalPrices)
		{
			if (tPrice.isInfantAvailable())
				System.out.println("Flight " + tPrice.getFlight() + ": " + tPrice.getTotalPrice().setScale(2, BigDecimal.ROUND_HALF_DOWN) + " €");
			else
				System.out.println("Flight " + tPrice.getFlight() + " is not available");
		}
	}

}
