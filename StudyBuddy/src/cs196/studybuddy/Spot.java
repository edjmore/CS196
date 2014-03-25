package cs196.studybuddy;

/**
 * 
 * @author Ed Moore
 * 
 */
public class Spot {

	private String name;
	private double wifiSpeed;
	private boolean food;
	private boolean tutors;

	public Spot() {
		name = "No data";
		wifiSpeed = 0;
		food = false;
		tutors = false;
	}

	/**
	 * 
	 * @param name
	 * @param wifiSpeed
	 * @param food
	 * @param tutors
	 */
	public Spot(String name, double wifiSpeed, boolean food, boolean tutors) {
		this.name = name;
		this.wifiSpeed = wifiSpeed;
		this.food = food;
		this.tutors = tutors;
	}

	public String getName() {
		return this.name;
	}

	public double getWifiSpeed() {
		return this.wifiSpeed;
	}

	public boolean getFood() {
		return this.food;
	}

	public boolean getTutors() {
		return this.tutors;
	}

}
