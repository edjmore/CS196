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
}
