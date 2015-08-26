package ndlwriter;

public class Sink {
	private String stringSinkName;
	private String stringConnectedTo;
	private double doubleMaxDelay;
	public Sink(String stringSinkName, String stringConnectedTo, double doubleMaxDelay) {
		this.stringSinkName=stringSinkName;
		this.doubleMaxDelay=doubleMaxDelay;
		this.stringConnectedTo=stringConnectedTo;
	}
	
	double getMaxDelay() {
		return this.doubleMaxDelay;
	}
	
	String getSinkName() {
		return this.stringSinkName;
	}
	
	String getSourceConnection() {
		return this.stringConnectedTo;
	}
}
