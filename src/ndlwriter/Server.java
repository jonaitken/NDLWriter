package ndlwriter;

public class Server {

	String stringName;
	double doubleWaitInterval;
	double doublePacketLength;
	double doubleContentLength;
		
	public Server(String stringName, double doubleWaitInterval, double doublePacketLength, double doubleContentLength) {
		this.stringName=stringName;
		this.doubleContentLength=doubleContentLength;
		this.doublePacketLength=doublePacketLength;
		this.doubleWaitInterval=doubleWaitInterval;
	}
	
	public String getName() {
		return this.stringName;
	}
	
	public double getWait() {
		return this.doubleWaitInterval;
	}
	
	public double getContentLength() {
		return this.doubleContentLength;
	}
	
	public double getPacketLength() {
		return this.doublePacketLength;
	}
	
	
}
