package cs196.studybuddy;

/**
 * 
 * @author Ed Moore
 * 
 */
public class SpotList {

	private Spot[] spotList;
	private int size;

	public SpotList() {
		spotList = new Spot[10];
		size = 0;
	}

	/**
	 * 
	 * @param spot
	 * @return
	 */
	public void addSpot(Spot spot) {
		Spot[] temp;
		if (this.spotList.length == this.getSize()) {
			temp = new Spot[this.spotList.length * 2];
			for (int k = 0; k < this.size; k++)
				temp[k] = this.spotList[k];
			temp[size] = spot;
			size++;
			this.spotList = temp;
		} else {
			this.spotList[size] = spot;
			size++;
		}
	}

	public int getSize() {
		return this.size;
	}

	public Spot spotPeek(int index) {
		return this.spotList[index];
	}

	/**
	 * 
	 * @param minWifiSpeed
	 * @param maxFoodDistance
	 * @param tutors
	 * @return a new SpotList with only the bestSpots in it
	 */
	public SpotList bestSpots(double minWifiSpeed, double maxFoodDistance,
			boolean tutors) {
		SpotList bestSpots = new SpotList();
		for (int k = 0; k < this.getSize(); k++) {
			Spot spot = spotList[k];
			if (spot.getWifiSpeed() >= minWifiSpeed
					&& spot.getFoodDistance() <= maxFoodDistance) {
				if (tutors && spot.getTutors()) {
					bestSpots.addSpot(spot);
				} else if (!tutors) {
					bestSpots.addSpot(spot);
				}
			}
		}
		if (bestSpots.getSize() == 0) {
			bestSpots.addSpot(new Spot("VOID", 0, 0, true));
			return bestSpots;
		}
		return bestSpots;
	}

	/**
	 * 
	 * @param list
	 * @return a SpotList converted to a String array where each string is a
	 *         Spot toString()
	 */
	public String[] toStringArray() {
		String[] output = new String[this.getSize()];
		for (int k = 0; k < output.length; k++) {
			Spot spot = this.spotList[k];
			output[k] = spot.toString();
		}
		return output;
	}
}
