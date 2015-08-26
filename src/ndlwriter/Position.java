package ndlwriter;

public class Position {

	private double doubleLatitude;
	private double doubleLongitude;
	public Position(double doubleLatitude, double doubleLongitude) {
		this.doubleLatitude=doubleLatitude;
		this.doubleLongitude=doubleLongitude;
	}
	
	public double getLatitude() {
		return this.doubleLatitude;
	}
	
	public double getLongitude() {
		return this.doubleLongitude;
	}
}
