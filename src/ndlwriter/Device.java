package ndlwriter;

import java.util.ArrayList;

public class Device {

	private String stringDeviceName;
	private double doubleLatitude;
	private double doubleLongitude;
	private ArrayList<String> arrayListInterfaces;
	private ArrayList<Connection> arrayListConnections;
	private ArrayList<String> arrayListAvailableInterfaces;
	
	private ArrayList<Server> arrayListServers;
	private ArrayList<Sink> arrayListSinks;
	
	public Device(String stringDeviceName, int intNumberOfInterfaces) {
		this.stringDeviceName=stringDeviceName;
		arrayListInterfaces=new ArrayList<String>();
		arrayListAvailableInterfaces=new ArrayList<String>();
		arrayListConnections=new ArrayList<Connection>();
		arrayListServers=new ArrayList<Server>();
		arrayListSinks=new ArrayList<Sink>();
		for(int intCounter=0;intCounter<intNumberOfInterfaces;intCounter++) {
			this.addInterface();
		}
		
	}
	
	String getDeviceName() {
		return this.stringDeviceName;
	}
	
	double getLatitude() {
		return this.doubleLatitude;
	}
	
	double getLongitude() {
		return this.doubleLongitude;
	}
	
	void setLongitude(double doubleLongitude) {
		this.doubleLongitude=doubleLongitude;
	}
	
	void setLatitude(double doubleLatitude) {
		this.doubleLatitude=doubleLatitude;
	}
	
	private void addInterface() {
		this.arrayListInterfaces.add(this.stringDeviceName+":eth"+(this.arrayListInterfaces.size()+1));	
		this.arrayListAvailableInterfaces.add(this.stringDeviceName+":eth"+(this.arrayListAvailableInterfaces.size()+1));
	}
	
	ArrayList<String> getInterfaces() {
		return this.arrayListInterfaces;
	}
	
	ArrayList<Connection> getConnections() {
		return this.arrayListConnections;
	}
	
	void addConnection(String mySource, String myDest, double doubleConnectionSpeed, double doubleLatency) {
		Connection myConnection = new Connection();
		myConnection.setDestination(myDest);
		myConnection.setSource(mySource);
		myConnection.setConnectionSpeed(doubleConnectionSpeed);
		myConnection.setConnectionLatency(doubleLatency);
		this.arrayListConnections.add(myConnection);
		for(int intCounter=0;intCounter<this.arrayListAvailableInterfaces.size();intCounter++) {
			if(arrayListAvailableInterfaces.get(intCounter).contentEquals(mySource)) {
				arrayListAvailableInterfaces.remove(intCounter);
			}
		}
	}
	
	String getFreePort() {
		String stringFreePort="";
		if(arrayListAvailableInterfaces.size()!=0) {
			stringFreePort=this.arrayListAvailableInterfaces.get(0);
		}
		return stringFreePort;
	}
	
	int getNumberFreePorts() {
		return this.arrayListAvailableInterfaces.size();
	}
	
	void addServer(double doublePacketLength, double doubleContentLength, double doubleWaitInterval) {
		Server myServer=new Server(this.stringDeviceName+":VidServ"+(this.arrayListServers.size()+1), doubleWaitInterval, doublePacketLength, doubleContentLength);
		this.arrayListServers.add(myServer);
	}
	
	void addSink(String stringConnectedTo, double doubleMaxDelay) {
		Sink mySink=new Sink(this.stringDeviceName+":VidServerConnection"+(this.arrayListSinks.size()+1),stringConnectedTo,doubleMaxDelay);
		this.arrayListSinks.add(mySink);
	}
	
	ArrayList<Server> getServers() {
		return this.arrayListServers;
	}
	
	ArrayList<Sink> getSinks() {
		return this.arrayListSinks;
	}
	
}
