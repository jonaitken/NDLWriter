package ndlwriter;

public class Connection {
	private String stringSource;
	private String stringDestination;
	private double doubleConnectionSpeed;
	private double doubleConnectionLatency;
	
	public Connection() {
		
	}
	
	public void setSource(String mySource) {
		this.stringSource=mySource;
	}
	
	public void setDestination(String myDest) {
		this.stringDestination=myDest;
	}
	
	public String getSource() {
		return this.stringSource;
	}
	
	public String getDestination() {
		return this.stringDestination;
	}
	
	public double getConnectionSpeed() {
		return this.doubleConnectionSpeed;
	}
	
	public double getConnectionLatency() {
		return this.doubleConnectionLatency;
	}
	
	public void setConnectionSpeed(double doubleConnectionSpeed) {
		this.doubleConnectionSpeed=doubleConnectionSpeed;
	}
	
	public void setConnectionLatency(double doubleConnectionLatency) {
		this.doubleConnectionLatency=doubleConnectionLatency;
	}
}
