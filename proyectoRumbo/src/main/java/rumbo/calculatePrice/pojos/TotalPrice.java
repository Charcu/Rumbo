package rumbo.calculatePrice.pojos;

import java.math.BigDecimal;

/**
 * Pojo with the results of the flight search
 * @author David Delgado
 *
 */
public class TotalPrice
{
	private String flight;
	private BigDecimal totalPrice;
	private boolean infantAvailable; //True if there are infants in the search and the airline has infant price

	public String getFlight() {
		return flight;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean isInfantAvailable() {
		return infantAvailable;
	}

	public void setInfantAvailable(boolean infantAvailable) {
		this.infantAvailable = infantAvailable;
	}

}
