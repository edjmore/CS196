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
	 */
	public void addSpot(Spot spot) {
		Spot[] temp;
		if (this.spotList.length == this.size) {
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

	/**
	 * 
	 * @param minWifiSpeed
	 * @param maxFoodDistance
	 * @param tutors
	 * @return
	 */
	public SpotList bestSpots(double minWifiSpeed, double maxFoodDistance,
			boolean tutors) {
		SpotList bestSpots = new SpotList();
		for (int k = 0; k < this.getSize(); k++) {
			Spot spot = spotList[k];
			if (spot.getWifiSpeed() >= minWifiSpeed
					&& spot.getFoodDistance() <= maxFoodDistance
					&& spot.getTutors() == tutors)
				bestSpots.addSpot(spot);
		}
		return bestSpots;
	}

	/**
	 * 
	 * @param list
	 * @return
	 */
	public String[] toString(SpotList list) {
		String[] output = new String[list.getSize()];
		for (int k = 0; k < output.length; k++) {
			Spot spot = list.spotList[k];
			output[k] = spot.toString();
		}
		return output;
	}
}
