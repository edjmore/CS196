package cs196.studybuddy;



/**
 * @author Ed Moore
 * 
 */
public class Spot {

	private String name;
	private boolean isNorth;
	private String coffeeFar;
	private String coffeeNear;
	private boolean tutors;

	public Spot() {
		name = "";
		coffeeFar = "";
		coffeeNear = "";
		tutors = false;
	}

	/**
	 * 
	 * @param name
	 * @param wifiSpeed
	 * @param food
	 * @param tutors
	 */
	public Spot(String name, String coffeeFar, String coffeeNear,
			boolean tutors, boolean isNorth) {
		this.name = name;
		this.coffeeNear = coffeeNear;
		this.coffeeFar = coffeeFar;
		this.tutors = tutors;
		this.isNorth = isNorth;
	}

	public int compareTo(Spot other, boolean isNorth, boolean tutors) {
		int score = 0;
		if (other.getTutors() == false)
			score--;
		if (this.getTutors() == false)
			score++;
		if (this.getCoffeeFar() == null)
			score++;
		if (this.getCoffeeNear() == null)
			score++;
		if (other.getCoffeeFar() == null)
			score--;
		if (other.getCoffeeNear() == null)
			score--;

		return score >= 0 ? 1 : -1;

	}

	/**
	 * public double getWifiSpeed() { return this.wifiSpeed; }
	 */

	public String getName() {
		return this.name;
	}

	public String getCoffeeFar() {
		return this.coffeeFar;
	}

	public String getCoffeeNear() {
		return this.coffeeNear;
	}

	public boolean getTutors() {
		return this.tutors;
	}

	public boolean getIsNorth() {
		return this.isNorth;
	}

	public String toString() {
		return name + "\nTutors: " + this.tutors != null && this.tutors == true ? "Available"
				: "Unavailable" + "\nClosest Coffee: " + this.coffeeFar != null ? this.coffeeNear
						: "None" + "\nCoffee Shops: " + this.coffeeFar != null ? this.coffeeFar
								: "None";
	}
}
