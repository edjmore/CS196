package cs196.studybuddy;

import android.text.format.Time;

public class Food {
	private String name;
	private int openTime;
	private int closeTime;

	public Food() {
		name = "";
		openTime = 0;
		closeTime = 0;
	}

	public Food(String name, int openTime, int closeTime) {
		this.name = name;
		this.openTime = openTime;
		this.closeTime = closeTime;
	}

	public String getName() {
		return this.name;
	}

	public int getOpenTime() {
		return this.openTime;
	}

	public int getCloseTime() {
		return this.closeTime;
	}

	public boolean isOpen() {
		boolean isopen = false;
		Time now = new Time();
		now.setToNow();
		int hour = now.hour;
		int min = now.minute;
		int time = (hour * 100) + min;
		if (time >= this.openTime && time < this.closeTime)
			isopen = true;
		return isopen;

	}

}
