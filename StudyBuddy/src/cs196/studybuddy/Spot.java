package cs196.studybuddy;

/**
 * 
 * @author Ed Moore
 * 
 */
public class Spot {

	private String name;
	private double wifiSpeed;
	private double foodDistance;
	private boolean tutors;

	public Spot() {
		name = "No data";
		wifiSpeed = 0;
		foodDistance = 0;
		tutors = false;
	}

	/**
	 * 
	 * @param name
	 * @param wifiSpeed
	 * @param food
	 * @param tutors
	 */
	public Spot(String name, double wifiSpeed, double foodDistance,
			boolean tutors) {
		this.name = name;
		this.wifiSpeed = wifiSpeed;
		this.foodDistance = foodDistance;
		this.tutors = tutors;
	}

	public String getName() {
		return this.name;
	}

	public double getWifiSpeed() {
		return this.wifiSpeed;
	}

	public double getFoodDistance() {
		return this.foodDistance;
	}

	public boolean getTutors() {
		return this.tutors;
	}

	public String toString() {
		String tutorOut = "";
		if (this.tutors)
			tutorOut = "Available";
		else
			tutorOut = "Unavailable";
		return name + ":\nWifi Speed: " + this.wifiSpeed + "(units)		Tutors: "
				+ tutorOut + "\nClosest Food: " + this.foodDistance;
	}
}
