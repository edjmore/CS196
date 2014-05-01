package cs196.studybuddy;

import android.text.format.Time;

/**
 * @author Ed Moore
 * 
 */
public class Spot {

	private String name;
	private boolean isNorth;
	private Coffee closestCoffee;
	private boolean tutors;
	private boolean EWS;
	private Food closestFood;
	private int open;
	private int close;

	public Spot() {
		name = "";
		closestCoffee = null;
		tutors = false;
		EWS = false;
		open = 0;
		close = 0;
	}

	/**
	 * 
	 * @param name
	 * @param wifiSpeed
	 * @param food
	 * @param tutors
	 */
	public Spot(String name, Coffee closestCoffee, Food closestFood,
			boolean tutors, boolean isNorth, boolean EWS, int open, int close) {
		this.name = name;
		this.tutors = tutors;
		this.isNorth = isNorth;
		this.closestCoffee = closestCoffee;
		this.closestFood = closestFood;
		this.open = open;
		this.close = close;
		this.EWS = EWS;
	}

	public int compare(Spot other) {
		int score = 0;
		if (other.getTutors() == true)
			score -= 3;
		if (other.getCoffee().isOpen())
			score--;

		if (other.getEWS() == EWS)
			score -= 2;
		if (other.getFood().isOpen())
			score--;
		if (this.getTutors() == true)
			score += 3;

		if (this.getEWS() == EWS)
			score += 2;
		if (this.getCoffee().isOpen())
			score++;
		if (this.getFood().isOpen())
			score++;
		return score >= 0 ? 1 : -1;

	}

	/**
	 * public double getWifiSpeed() { return this.wifiSpeed; }
	 */

	public String getName() {
		return this.name;
	}

	public Coffee getCoffee() {
		return this.closestCoffee;
	}

	public boolean getTutors() {
		return this.tutors;
	}

	public boolean getIsNorth() {
		return this.isNorth;
	}

	public Food getFood() {
		return this.closestFood;
	}

	public int getOpen() {
		return this.open;
	}

	public int getClose() {
		return this.close;
	}

	public boolean getEWS() {
		return this.EWS;
	}

	public String toString() {
		String returnable = name;

		if (this.tutors)
			returnable = returnable + "\nTutors: Available";
		else
			returnable = returnable + " \nTutors: Unavailable";

		if (closestCoffee != null && closestCoffee.isOpen())
			returnable = returnable + "\nCoffee: "
					+ this.closestCoffee.getName() + "  (OPEN)";
		else if (!closestCoffee.isOpen())
			returnable = returnable + "\nCoffee: "
					+ this.closestCoffee.getName() + "  (CLOSED)";
		else
			returnable = returnable + "\nCoffee: None";

		if (closestFood != null && closestFood.isOpen())
			returnable = returnable + "\nFood: " + this.closestFood.getName()
					+ "  (OPEN)";
		else if (!closestFood.isOpen())
			returnable = returnable + "\nFood: " + this.closestFood.getName()
					+ "  (CLOSED)";
		else
			returnable = returnable + "\nClosest Food: None";

		if (EWS)
			returnable = returnable + "\nEWS: Available";
		else
			returnable = returnable + " \nEWS: Unavailable";

		return returnable;

	}

	public boolean isOpen() {
		boolean isopen = false;
		Time now = new Time();
		now.setToNow();
		int hour = now.hour;
		int min = now.minute;
		int time = (hour * 100) + min;
		if (time >= this.open && time < this.close)
			isopen = true;
		return isopen;

	}

}