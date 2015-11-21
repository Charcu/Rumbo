package rumbo.calculatePrice.pojos;

/**
 * Pojo with number of people in the searched flight
 * @author David Delgado
 *
 */
public class Pax
{
	private int numAdults;
	private int numChildren;
	private int numInfants;

	public Pax(int numAdults, int numChildren, int numInfants)
	{
		this.numAdults = numAdults;
		this.numChildren = numChildren;
		this.numInfants = numInfants;
	}

	public int getNumAdults() {
		return numAdults;
	}

	public void setNumAdults(int numAdults) {
		this.numAdults = numAdults;
	}

	public int getNumChildren() {
		return numChildren;
	}

	public void setNumChildren(int numChildren) {
		this.numChildren = numChildren;
	}

	public int getNumInfants() {
		return numInfants;
	}

	public void setNumInfants(int numInfants) {
		this.numInfants = numInfants;
	}
}
