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
	public SpotList bestSpots(boolean isNorth, boolean tutors) {
		SpotList bestSpots = new SpotList();
		for (int i = 0; i < this.getSize(); i++) {
			Spot spot = spotList[i];
			if (spot.getTutors() == tutors && spot.getIsNorth() == isNorth) {
				bestSpots.addSpot(spot);
			}
		}
		return bestSpots;
	}

	public void sort(boolean isNorth, boolean tutors) {
		sort(isNorth, tutors, 0, getSize());
	}

	public void sort(boolean isNorth, boolean tutors, int lo, int hi) {
		if (lo < hi) {
			swap(lo, findBest(isNorth, tutors, hi));
			sort(isNorth, tutors, lo + 1, hi);
		}
	}

	public void swap(int lo, int hi) {
		Spot temp = spotList[lo];
		spotList[lo] = spotList[hi];
		spotList[hi] = temp;
	}

	public int findBest(boolean isNorth, boolean tutors, int size) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (spotList[i].getIsNorth() == isNorth
					&& spotList[i].getTutors() == tutors)
				count = i;
		}
		return count;
	}

	public int findBest(boolean n, boolean t) {
		return findBest(n, t, getSize());

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
