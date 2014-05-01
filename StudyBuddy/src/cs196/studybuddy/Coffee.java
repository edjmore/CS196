package cs196.studybuddy;

import android.text.format.Time;


public class Coffee {
	private String name;
	private int openTime;
	private int closeTime;
	
	public Coffee(){
		name = "";
		openTime = 0;
		closeTime = 0;
	}
	
	public Coffee(String name, int openTime, int closeTime){
		this.name = name;
		this.openTime = openTime;
		this.closeTime = closeTime;
	}
	
	public String getName(){
		return this.name;
	}
	
	
	public int getOpenTime(){
		return this.openTime;
	}
	
	public int getCloseTime(){
		return this.closeTime;
	}
	public boolean isOpen(){
		boolean open = false;
		Time now = new Time();
		now.setToNow();
		if( now.hour >= this.openTime && now.hour < this.closeTime) open = true;
		return open;
		
	}
}

