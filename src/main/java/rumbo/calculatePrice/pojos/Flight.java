package rumbo.calculatePrice.pojos;

import java.math.BigDecimal;

/**
 * Pojo with flight data
 * @author David Delgado
 *
 */
public class Flight
{
	private String origin;
	private String destiation;
	private String airline;
	private BigDecimal price;

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestiation() {
		return destiation;
	}

	public void setDestiation(String destiation) {
		this.destiation = destiation;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
