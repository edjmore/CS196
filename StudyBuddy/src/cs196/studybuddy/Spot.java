package cs196.studybuddy;



/**
 * @author Ed Moore
 * 
 */
public class Spot {

	private String name;
	private boolean isNorth;
	private Coffee closestCoffee;
	private boolean tutors;
	private Food closestFood;

	public Spot() {
		name = "";
		closestCoffee = null;
		tutors = false;
	}

	/**
	 * 
	 * @param name
	 * @param wifiSpeed
	 * @param food
	 * @param tutors
	 */
	public Spot(String name, Coffee closestCoffee,
			boolean tutors, boolean isNorth) {
		this.name = name;
		this.tutors = tutors;
		this.isNorth = isNorth;
		this.closestCoffee = closestCoffee;
	}

	public int compareTo(Spot other, boolean isNorth, boolean tutors) {
		int score = 0;
		if (other.getTutors() == true)
			score--;
		if (this.getTutors() == true)
			score++;
		if (this.getIsNorth() == isNorth)
			score++;
		if (other.getIsNorth() == isNorth)
			score--;

		return score >= 0 ? 1 : -1;

	}

	/**
	 * public double getWifiSpeed() { return this.wifiSpeed; }
	 */

	public String getName() {
		return this.name;
	}

	public Coffee getCoffee(){
		return this.closestCoffee;
	}

	public boolean getTutors() {
		return this.tutors;
	}

	public boolean getIsNorth() {
		return this.isNorth;
	}
	
	public Food getFood(){
		return this.closestFood;
	}

	public String toString() {
		String returnable = name;
		
		if(this.tutors) returnable = returnable + "\n Tutors: Available";
		else returnable = returnable + " \n Tutors: Unavailable";
		
		if(closestCoffee != null) returnable = returnable + "\n Closest Coffee: " + this.closestCoffee.getName();
		else returnable = returnable +"\n Closest Coffee: None";
		
		if(closestFood != null) returnable = returnable + "\n Closest Food: " + this.closestFood.getName();
		else returnable = returnable +"\n Closest Food: None";
		
		return returnable;
		
		
	}

}
