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

	public SpotList search(String name) {
		SpotList out = new SpotList();
		for (int i = 0; i < this.getSize(); i++) {
			if (spotList[i].getName().indexOf(name) >= 0)
				out.addSpot(spotList[i]);
		}
		return out;
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
	public SpotList bestSpots(double maxFoodDistance, boolean tutors) {
		SpotList bestSpots = new SpotList();
		for (int i = 0; i < this.getSize(); i++) {
			Spot spot = spotList[i];
			if (spot.getTutors() == tutors) {
				bestSpots.addSpot(spot);
			} else if (spot.getFoodDistance() <= maxFoodDistance) {
				bestSpots.addSpot(spot);
			}
		}
		return bestSpots;
	}

	public void sort(double food, boolean tutors) {
		sort(food, tutors, 0, getSize());
	}

	public void sort(double maxFoodDistance, boolean tutors, int lo, int hi) {
		if (lo < hi) {
			swap(lo, findBest(maxFoodDistance, tutors, hi));
			sort(maxFoodDistance, tutors, lo + 1, hi);
		}
	}

	public void swap(int lo, int hi) {
		Spot temp = spotList[lo];
		spotList[lo] = spotList[hi];
		spotList[hi] = temp;
	}

	public int findBest(double food, boolean tutors, int size) {
		Spot spot = spotList[size - 1];
		int spotIndex = size - 1;
		if (size == 1)
			return spotIndex;
		int bestIndex = findBest(food, tutors, size - 1);
		Spot best = spotList[bestIndex];
		if (spot.compareTo(best, food, tutors) >= 0)
			return spotIndex;
		return bestIndex;
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
