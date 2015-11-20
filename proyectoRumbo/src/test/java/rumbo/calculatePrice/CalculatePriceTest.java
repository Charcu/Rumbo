package rumbo.calculatePrice;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import rumbo.calculatePrice.pojos.Pax;
import rumbo.calculatePrice.pojos.TotalPrice;

public class CalculatePriceTest
{

/////////////////////	TEST OF DATES	///////////////////////////
	/**
	 * AMS to FRA, more than 30 days to flight date, 1 adult
	 */
	@Test
	public void testDateOne()
	{
		try {
			System.out.println("testDateOne: AMS to FRA, more than 30 days to flight date, 1 adult");
			CalculatePrice calcPrice = new CalculatePrice();
			String origin = "AMS";
			String destination = "FRA";
			Pax pax = new Pax(1, 0, 0);
			Date flightDate = getAddDaysToNow(31);
			List<TotalPrice> flightPrice = calcPrice.searchFlightPrice(origin, destination, flightDate, pax);

			Assert.assertNotNull(flightPrice);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


	/**
	 * AMS to FRA, 30 days to flight date, 1 adult
	 */
	@Test
	public void testDateTwo()
	{
		try {
			System.out.println("testDateTwo: AMS to FRA, 30 days to flight date, 1 adult");
			CalculatePrice calcPrice = new CalculatePrice();
			String origin = "AMS";
			String destination = "FRA";
			Pax pax = new Pax(1, 0, 0);
			Date flightDate = getAddDaysToNow(30);
			List<TotalPrice> flightPrice = calcPrice.searchFlightPrice(origin, destination, flightDate, pax);

			Assert.assertNotNull(flightPrice);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


	/**
	 * AMS to FRA, 16 days to flight date, 1 adult
	 */
	@Test
	public void tesDateThree()
	{
		try {
			System.out.println("tesDateThree: AMS to FRA, 16 days to flight date, 1 adult");
			CalculatePrice calcPrice = new CalculatePrice();
			String origin = "AMS";
			String destination = "FRA";
			Pax pax = new Pax(1, 0, 0);
			Date flightDate = getAddDaysToNow(16);
			List<TotalPrice> flightPrice = calcPrice.searchFlightPrice(origin, destination, flightDate, pax);

			Assert.assertNotNull(flightPrice);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


	/**
	 * AMS to FRA, 15 days to flight date, 1 adult
	 */
	@Test
	public void testDateFour()
	{
		try {
			System.out.println("testDateFour:  AMS to FRA, 15 days to flight date, 1 adult");
			CalculatePrice calcPrice = new CalculatePrice();
			String origin = "AMS";
			String destination = "FRA";
			Pax pax = new Pax(1, 0, 0);
			Date flightDate = getAddDaysToNow(15);
			List<TotalPrice> flightPrice = calcPrice.searchFlightPrice(origin, destination, flightDate, pax);

			Assert.assertNotNull(flightPrice);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


	/**
	 * AMS to FRA, 3 days to flight date, 1 adult
	 */
	@Test
	public void testDateFive()
	{
		try {
			System.out.println("testDateFive:  AMS to FRA, 3 days to flight date, 1 adult");
			CalculatePrice calcPrice = new CalculatePrice();
			String origin = "AMS";
			String destination = "FRA";
			Pax pax = new Pax(1, 0, 0);
			Date flightDate = getAddDaysToNow(3);
			List<TotalPrice> flightPrice = calcPrice.searchFlightPrice(origin, destination, flightDate, pax);

			Assert.assertNotNull(flightPrice);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


	/**
	 * AMS to FRA, less than 3 days to flight date, 1 adult
	 */
	@Test
	public void testDateSix()
	{
		try {
			System.out.println("testDateSix: AMS to FRA, less than 3 days to flight date, 1 adult");
			CalculatePrice calcPrice = new CalculatePrice();
			String origin = "AMS";
			String destination = "FRA";
			Pax pax = new Pax(1, 0, 0);
			Date flightDate = getAddDaysToNow(2);
			List<TotalPrice> flightPrice = calcPrice.searchFlightPrice(origin, destination, flightDate, pax);

			Assert.assertNotNull(flightPrice);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}



///////////////////////////		TEST NUMBER OF PEOPLE  //////////////////////////////

	/**
	 * LHR to IST, 14 days to flight date, 0 adults, 0 children, 0 infants
	 */
	@Test
	public void testPeopleOne()
	{
		try {
			System.out.println("testPeopleOne: LHR to IST, 14 days to flight date, 0 adults, 0 children, 0 infants");
			CalculatePrice calcPrice = new CalculatePrice();
			String origin = "LHR";
			String destination = "IST";
			Date flightDate = getAddDaysToNow(14);
			Pax pax = new Pax(0, 0, 0);
			List<TotalPrice> flightPrice = calcPrice.searchFlightPrice(origin, destination, flightDate, pax);

			Assert.assertNotNull(flightPrice);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


	/**
	 * LHR to IST, 14 days to flight date, 0 adults, 0 children, 1 infants
	 */
	@Test
	public void testPeopleTwo()
	{
		try {
			System.out.println("testPeopleTwo: LHR to IST, 14 days to flight date, 0 adults, 0 children, 1 infants");
			CalculatePrice calcPrice = new CalculatePrice();
			String origin = "LHR";
			String destination = "IST";
			Date flightDate = getAddDaysToNow(14);
			Pax pax = new Pax(0, 0, 1);
			List<TotalPrice> flightPrice = calcPrice.searchFlightPrice(origin, destination, flightDate, pax);

			Assert.assertNotNull(flightPrice);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


	/**
	 * LHR to IST, 14 days to flight date, 0 adults, 1 child, 0 infants
	 */
	@Test
	public void testPeopleThree()
	{
		try {
			System.out.println("testPeopleThree: LHR to IST, 14 days to flight date, 0 adults, 1 child, 0 infants");
			CalculatePrice calcPrice = new CalculatePrice();
			String origin = "LHR";
			String destination = "IST";
			Date flightDate = getAddDaysToNow(14);
			Pax pax = new Pax(0, 1, 0);
			List<TotalPrice> flightPrice = calcPrice.searchFlightPrice(origin, destination, flightDate, pax);

			Assert.assertNotNull(flightPrice);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


	/**
	 * LHR to IST, 14 days to flight date, 0 adults, 1 child, 1 infant
	 */
	@Test
	public void testPeopleFour()
	{
		try {
			System.out.println("testPeopleFour: LHR to IST, 14 days to flight date, 0 adults, 1 child, 1 infant");
			CalculatePrice calcPrice = new CalculatePrice();
			String origin = "LHR";
			String destination = "IST";
			Date flightDate = getAddDaysToNow(14);
			Pax pax = new Pax(0, 1, 1);
			List<TotalPrice> flightPrice = calcPrice.searchFlightPrice(origin, destination, flightDate, pax);

			Assert.assertNotNull(flightPrice);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	/**
	 * LHR to IST, 14 days to flight date, 1 adults, 0 children, 0 infants
	 */
	@Test
	public void testPeopleFive()
	{
		try {
			System.out.println("testPeopleFive: LHR to IST, 14 days to flight date, 1 adults, 0 children, 0 infants");
			CalculatePrice calcPrice = new CalculatePrice();
			String origin = "LHR";
			String destination = "IST";
			Date flightDate = getAddDaysToNow(14);
			Pax pax = new Pax(1, 0, 0);
			List<TotalPrice> flightPrice = calcPrice.searchFlightPrice(origin, destination, flightDate, pax);

			Assert.assertNotNull(flightPrice);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


	/**
	 * LHR to IST, 14 days to flight date, 1 adults, 0 children, 1 infant
	 */
	@Test
	public void testPeopleSix()
	{
		try {
			System.out.println("testPeopleSix: LHR to IST, 14 days to flight date, 1 adults, 0 children, 1 infant");
			CalculatePrice calcPrice = new CalculatePrice();
			String origin = "LHR";
			String destination = "IST";
			Date flightDate = getAddDaysToNow(14);
			Pax pax = new Pax(1, 0, 1);
			List<TotalPrice> flightPrice = calcPrice.searchFlightPrice(origin, destination, flightDate, pax);

			Assert.assertNotNull(flightPrice);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


	/**
	 * LHR to IST, 14 days to flight date, 1 adults, 1 child, 0 infants
	 */
	@Test
	public void testPeopleSeven()
	{
		try {
			System.out.println("testPeopleSeven: LHR to IST, 14 days to flight date, 1 adults, 1 child, 0 infants");
			CalculatePrice calcPrice = new CalculatePrice();
			String origin = "LHR";
			String destination = "IST";
			Date flightDate = getAddDaysToNow(14);
			Pax pax = new Pax(1, 1, 1);
			List<TotalPrice> flightPrice = calcPrice.searchFlightPrice(origin, destination, flightDate, pax);

			Assert.assertNotNull(flightPrice);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


	/**
	 * LHR to IST, 14 days to flight date, 1 adult, 1 child, 1 infant
	 */
	@Test
	public void testPeopleEight()
	{
		try {
			System.out.println("testPeopleEight: LHR to IST, 14 days to flight date, 1 adult, 1 child, 1 infant");
			CalculatePrice calcPrice = new CalculatePrice();
			String origin = "LHR";
			String destination = "IST";
			Date flightDate = getAddDaysToNow(14);
			Pax pax = new Pax(1, 1, 1);
			List<TotalPrice> flightPrice = calcPrice.searchFlightPrice(origin, destination, flightDate, pax);

			Assert.assertNotNull(flightPrice);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


///////////////////		TEST NO AVAILABLE FLGHTS	 //////////////////////

	/**
	 * CDG to FRA. No flights available
	 */
	@Test
	public void testNoFlights()
	{
		try {
			System.out.println("testNoFlights: CDG to FRA. No flights available");
			CalculatePrice calcPrice = new CalculatePrice();
			String origin = "CDG";
			String destination = "FRA";
			Date flightDate = getAddDaysToNow(14);
			Pax pax = new Pax(0, 1, 1);
			List<TotalPrice> flightPrice = calcPrice.searchFlightPrice(origin, destination, flightDate, pax);

			Assert.assertNull(flightPrice); //There are,'t any flights from CDG to FRA
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


///////////////////		TEST NULL DATA	  //////////////////////

	/**
	* LHR to IST. Pax is null
	*/
	@Test
	public void testNullDataOne()
	{
		try {
			System.out.println("testNullDataOne: LHR to IST. Pax is null");
			CalculatePrice calcPrice = new CalculatePrice();
			String origin = "LHR";
			String destination = "IST";
			Date flightDate = getAddDaysToNow(14);
			Pax pax = null;
			List<TotalPrice> flightPrice = calcPrice.searchFlightPrice(origin, destination, flightDate, pax);

			Assert.assertNull(flightPrice);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


	/**
	* null to IST. Origin is null
	*/
	@Test
	public void testNullDataTwo()
	{
		try {
			System.out.println("testNullDataTwo: null to IST. Origin is null");
			CalculatePrice calcPrice = new CalculatePrice();
			String origin = null;
			String destination = "IST";
			Date flightDate = getAddDaysToNow(14);
			Pax pax = new Pax(1, 1, 1);
			List<TotalPrice> flightPrice = calcPrice.searchFlightPrice(origin, destination, flightDate, pax);

			Assert.assertNull(flightPrice);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


	/**
	* LHR to null. Destination is null
	*/
	@Test
	public void testNullDataThree()
	{
		try {
			System.out.println("testNullDataThree: LHR to null. Destination is null");
			CalculatePrice calcPrice = new CalculatePrice();
			String origin = "LHR";
			String destination = null;
			Date flightDate = getAddDaysToNow(14);
			Pax pax = new Pax(1, 1, 1);
			List<TotalPrice> flightPrice = calcPrice.searchFlightPrice(origin, destination, flightDate, pax);

			Assert.assertNull(flightPrice);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


	/**
	* LHR to IST. Flight date is null
	*/
	@Test
	public void testNullDataFour()
	{
		try {
			System.out.println("testNullDataFour: LHR to IST. Flight date is null");
			CalculatePrice calcPrice = new CalculatePrice();
			String origin = "LHR";
			String destination = "IST";
			Date flightDate = null;
			Pax pax = new Pax(1, 1, 1);
			List<TotalPrice> flightPrice = calcPrice.searchFlightPrice(origin, destination, flightDate, pax);

			Assert.assertNull(flightPrice);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


	/**
	* All input data are null
	*/
	@Test
	public void testNullDataFive()
	{
		try {
			System.out.println("testNullDataFive: All input data are null");
			CalculatePrice calcPrice = new CalculatePrice();
			String origin = null;
			String destination = null;
			Date flightDate = null;
			Pax pax = null;
			List<TotalPrice> flightPrice = calcPrice.searchFlightPrice(origin, destination, flightDate, pax);

			Assert.assertNull(flightPrice);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


///////////////////		TEST WRONG INPUT DATA	  //////////////////////


	/**
	* LHR to AAA. Destination doesn't exist
	*/
	@Test
	public void testWrongDataOne()
	{
		try {
			System.out.println("testWrongDataOne: LHR to AAA. Destination doesn't exist");
			CalculatePrice calcPrice = new CalculatePrice();
			String origin = "LHR";
			String destination = "AAA";
			Date flightDate = getAddDaysToNow(14);
			Pax pax = new Pax(1, 1, 1);
			List<TotalPrice> flightPrice = calcPrice.searchFlightPrice(origin, destination, flightDate, pax);

			Assert.assertNull(flightPrice);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


	/**
	* AAA to MAD. Origin doesn't exist
	*/
	@Test
	public void testWrongDataTwo()
	{
		try {
			System.out.println("testWrongDataTwo: AAA to MAD. Origin doesn't exist");
			CalculatePrice calcPrice = new CalculatePrice();
			String origin = "AAA";
			String destination = "MAD";
			Date flightDate = getAddDaysToNow(14);
			Pax pax = new Pax(1, 1, 1);
			List<TotalPrice> flightPrice = calcPrice.searchFlightPrice(origin, destination, flightDate, pax);

			Assert.assertNull(flightPrice);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


	/**
	* BCN to MAD. Date of flight is before than today
	*/
	@Test
	public void testWrongDataThree()
	{
		try {
			System.out.println("testWrongDataThree: BCN to MAD. Date of flight is before than today");
			CalculatePrice calcPrice = new CalculatePrice();
			String origin = "BCN";
			String destination = "MAD";
			Date flightDate = getAddDaysToNow(-1);
			Pax pax = new Pax(1, 1, 1);
			List<TotalPrice> flightPrice = calcPrice.searchFlightPrice(origin, destination, flightDate, pax);

			Assert.assertNull(flightPrice);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


	/**
	* BCN to MAD. Number of people is negative
	*/
	@Test
	public void testWrongDataFour()
	{
		try {
			System.out.println("testWrongDataFour: BCN to MAD. Number of people is negative");
			CalculatePrice calcPrice = new CalculatePrice();
			String origin = "BCN";
			String destination = "MAD";
			Date flightDate = getAddDaysToNow(40);
			Pax pax = new Pax(-1, -1, -1);
			List<TotalPrice> flightPrice = calcPrice.searchFlightPrice(origin, destination, flightDate, pax);

			Assert.assertNull(flightPrice);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


///////////////////		TEST CORRECT INPUT DATA	  //////////////////////

	/**
	 * BCN to MAD, less than 3 days to flight date, 1 adult, 2 children. This test is in the documentation
	 */
	@Test
	public void testOKOne()
	{
		try {
			System.out.println("testOKOne: BCN to MAD, less than 3 days to flight date, 1 adult, 2 children");
			CalculatePrice calcPrice = new CalculatePrice();
			String origin = "BCN";
			String destination = "MAD";
			Date flightDate = getAddDaysToNow(2);
			Pax pax = new Pax(1, 2, 0);
			List<TotalPrice> flightPrice = calcPrice.searchFlightPrice(origin, destination, flightDate, pax);

			Assert.assertNotNull(flightPrice);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


	/**
	 * BCN to MAD, flight is today, 1 adult, 2 children.
	 */
	@Test
	public void testOKTwo()
	{
		try {
			System.out.println("testOKTwo: BCN to MAD, flight is today, 1 adult, 2 children");
			CalculatePrice calcPrice = new CalculatePrice();
			String origin = "BCN";
			String destination = "MAD";
			Date flightDate = getAddDaysToNow(0);
			Pax pax = new Pax(1, 2, 0);
			List<TotalPrice> flightPrice = calcPrice.searchFlightPrice(origin, destination, flightDate, pax);

			Assert.assertNotNull(flightPrice);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}


	/**
	 * Add a number of days to actual date
	 * @param days: Number of dates
	 * @return Now date plus number of days
	 */
	private Date getAddDaysToNow(int days)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, days);
		return new Date(cal.getTimeInMillis());
	}
}

