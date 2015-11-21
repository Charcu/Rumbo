package rumbo.calculatePrice.pojos;

import java.math.BigDecimal;

/**
 * Pojo with airlines and the infant price for that airline
 * @author David Delgado
 *
 */
public class InfantPrice
{
	private String IATACode;
	private BigDecimal price;

	public String getIATACode() {
		return IATACode;
	}

	public void setIATACode(String iATACode) {
		IATACode = iATACode;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
