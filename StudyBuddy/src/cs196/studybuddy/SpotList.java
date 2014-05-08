package cs196.studybuddy;

import java.io.File;
import java.util.Locale;

/**
 * 
 * @author Ed Moore
 * 
 */
public class SpotList {

	private Spot[] spotList;
	private int size;

	public SpotList() {
		spotList = new Spot[30];
		size = 0;
	}

	public SpotList(File data) {

	}

	public SpotList search(String name) {
		name = name.toUpperCase(Locale.US);
		SpotList out = new SpotList();
		for (int i = 0; i < this.getSize(); i++) {
			if (spotList[i].getName().toUpperCase(Locale.US).indexOf(name) >= 0)
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
	public SpotList bestSpots(boolean isNorth, boolean tutors, boolean EWS) {
		SpotList bestSpots = new SpotList();

		for (int i = 0; i < this.getSize() - 1; i++) {
			Spot bestspot = this.spotList[i];
			if ((bestspot.getTutors() == true || bestspot.getTutors() == tutors)
					&& bestspot.getIsNorth() == isNorth
					&& (bestspot.getEWS() == true || bestspot.getEWS() == EWS)
					&& bestspot.isOpen()) {
				bestSpots.addSpot(bestspot);
			}
		}

		return bestSpots;
	}

	/*
	 * public static void sort(double[] data) { sort(data, 0, data.length-1); }
	 * 
	 * * Recursively sorts the sub array lo...hi using selection sort algorithm.
	 * * public static void sort(double[] data, int lo, int hi) { if (lo < hi){
	 * swap(data, lo, findMin(data, lo, hi)); sort(data, lo+1, hi); }
	 * 
	 * }
	 */
	public void sort() {
		sort(0, this.getSize());
	}

	public void sort(int lo, int size) {
		if (lo < size) {
			swap(lo, findBest());
			sort(lo + 1, size);
		}
	}

	public void swap(int lo, int hi) {
		Spot temp = spotList[lo];
		spotList[lo] = spotList[hi];
		spotList[hi] = temp;
	}

	/*
	 * public static int findMin(double[] data, int lo, int hi) { if (lo == hi)
	 * return lo; int min = findMin(data, lo + 1, hi); if (data[min] < data[lo])
	 * return min; return lo; }
	 */
	public int findBest(int lo, int size) {
		if (lo == size)
			return size;
		int best = findBest(lo + 1, size);
		if (this.spotList[best].compare(this.spotList[lo]) < 0)
			return best;
		return lo;
	}

	public int findBest() {
		return findBest(0, this.getSize() - 1);

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
