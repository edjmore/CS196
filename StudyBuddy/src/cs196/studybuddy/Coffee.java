package cs196.studybuddy;

public class Coffee {
	private String name;
	private long distance;
	private long openTime;
	private long closeTime;
	
	public Coffee(){
		name = "";
		distance = 0;
		openTime = 0;
		closeTime = 0;
	}
	
	public Coffee(String name, long distance, long openTime, long closeTime){
		this.name = name;
		this.distance = distance;
		this.openTime = openTime;
		this.closeTime = closeTime;
	}
	
	public String getName(){
		return this.name;
	}
	
	public long getDistance(){
		return this.distance;
	}
	
	public long getOpenTime(){
		return this.openTime;
	}
	
	public long getCloseTime(){
		return this.closeTime;
	}
}
