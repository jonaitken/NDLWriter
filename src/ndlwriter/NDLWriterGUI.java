package ndlwriter;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.*;

import static javax.swing.GroupLayout.Alignment.*;

public class NDLWriterGUI extends JFrame implements ActionListener {
	protected JButton commitButton;
	
	protected JTextField myNodesTextField;
	protected JLabel myNodesLabel=new JLabel("How Many Nodes?");
	
	protected JTextField myRoutersTextField;
	protected JLabel myRoutersLabel=new JLabel("How Many Routers?");
	
	protected JTextField myRoutersMaxConnectionsTextField;
	protected JLabel myRoutersMaxConnectionsLabel=new JLabel("How Many Connections for Router?");
	
	protected JTextField myEdgesTextField;
	protected JLabel myEdgesLabel=new JLabel("How Many Links?");
	
	protected JTextField myConnectionSpeed;
	protected JLabel myConnectionSpeedLabel=new JLabel("Maximum Speed?");
	
	protected JComboBox myNetworkTypeSelector;
	protected JLabel myNetworkTypeSelectorLabel=new JLabel("What type?");;
	
	protected JTextField myLatitudeCentre;
	protected JLabel myLatitudeLabel=new JLabel("Center Latitude?");
	
	protected JTextField myLongitudeCentre;
	protected JLabel myLongitudeLabel=new JLabel("Center Longitude?");
	
	protected JTextField myRadius;
	protected JLabel myRadiusLabel=new JLabel("Radius?");
	
	protected JTextField myServerSources;
	protected JLabel myServerSourcesLabel=new JLabel("How Many Servers?");
	
	protected JTextField myServerSinks;
	protected JLabel myServerSinksLabel=new JLabel("How Many Sinks?");
	
	protected JTextField myServerWait;
	protected JLabel myServerWaitLabel=new JLabel("Wait Interval");
	
	protected JTextField myServerPacketLength;
	protected JLabel myServerPacketLengthLabel=new JLabel("Packet Length");
	
	protected JTextField myServerContentLength;
	protected JLabel myServerContentLengthLabel=new JLabel("Content Length");
	
	protected JTextField myConnectionMaxDelay;
	protected JLabel myConnectionMaxDelayLabel=new JLabel("Maximum Delay");
	
	protected JTextField myFileName;
	protected JLabel myFileNameLabel=new JLabel("File Name");
	
	
	protected int intNumberNodes;
	protected int intNumberRouters;
	protected int intNumberRouterConnections;
	protected int intNumberEdges;
	
	protected int intNumberServers;
	protected int intNumberServerConnections;
	
	
	private String[] networkStrings= { "Random", "Small World" };
	
	private double doublePropSpeed = 2e8;
	private double doubleLengthFiddleFactor = 1.5;
	
	public NDLWriterGUI() {
		int width = 800;
		int height = 600;
		this.setTitle("NDL Writer");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Content Pane
		JPanel fullContentPane = new JPanel();
		fullContentPane.setSize(width, height);
		fullContentPane.setOpaque(true); //content panes must be opaque
        this.setContentPane(fullContentPane);
        
        //Go Button
        commitButton = new JButton("Write File");
        commitButton.addActionListener(this);
        
        //Nodes text field
        myNodesTextField = new JTextField(1);
        myNodesTextField.addActionListener(this);
        myNodesTextField.setText("100");
        
        //Routers text field
        myRoutersTextField = new JTextField(1);
        myRoutersTextField.addActionListener(this);
        myRoutersTextField.setText("100");
        
        //Routers max connections text field
        myRoutersMaxConnectionsTextField = new JTextField(1);
        myRoutersMaxConnectionsTextField.addActionListener(this);
        myRoutersMaxConnectionsTextField.setText("30");
        
        //Connections speed text field
        myConnectionSpeed = new JTextField(1);
        myConnectionSpeed.addActionListener(this);
        myConnectionSpeed.setText("10e6");
        
        //Edges text field
        myEdgesTextField = new JTextField(1);
        myEdgesTextField.addActionListener(this);
        myEdgesTextField.setText("1000");
        
        //Create the combo box, select item at index 4.
        //Indices start at 0, so 4 specifies the pig.
        myNetworkTypeSelector = new JComboBox(networkStrings);
        myNetworkTypeSelector.setSelectedIndex(0);
        myNetworkTypeSelector.addActionListener(this);
        
        //Position fields
        myLatitudeCentre = new JTextField(1);
        myLatitudeCentre.addActionListener(this);
        myLatitudeCentre.setText("-1.05");
        
        myLongitudeCentre = new JTextField(1);
        myLongitudeCentre.addActionListener(this);
        myLongitudeCentre.setText("53.9");
        
        myRadius = new JTextField(1);
        myRadius.addActionListener(this);
        myRadius.setText("1000");
        
        //Server Content Stuff
        myServerSources = new JTextField(1);
        myServerSources.addActionListener(this);
    	myServerSources.setText("25");
        
    	myServerSinks = new JTextField(1);
    	myServerSinks.addActionListener(this);
    	myServerSinks.setText("25");
    	
    	myServerWait = new JTextField(1);
    	myServerWait.addActionListener(this);
    	myServerWait.setText("20.6e-3");
    	
    	myServerPacketLength = new JTextField(1);
    	myServerPacketLength.addActionListener(this);
    	myServerPacketLength.setText("1344");
    	
    	myServerContentLength = new JTextField(1);
    	myServerContentLength.addActionListener(this);
    	myServerContentLength.setText("1316");
    	
    	myConnectionMaxDelay = new JTextField(1);
    	myConnectionMaxDelay.addActionListener(this);
        myConnectionMaxDelay.setText("0.01");
    	
        myFileName = new JTextField(1);
        myFileName.addActionListener(this);
        myFileName.setText("Out.rdf");
        
        //Add everything
        
        //myNodesTextField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        //myNetworkTypeSelector.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        //commitButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                
        //create a GroupLayout object associate with the panel  
        GroupLayout grpLayout = new GroupLayout(fullContentPane); 
        fullContentPane.setLayout(grpLayout);  
        
        grpLayout.setAutoCreateGaps(true);      // specify automatic gap insertion  
        grpLayout.setAutoCreateContainerGaps(true);  
          
        //create the Horizontal and Vertical and sequential group  
        GroupLayout.SequentialGroup horizontalSeqGrp = grpLayout.createSequentialGroup();  
        GroupLayout.SequentialGroup verticalSeqGrp = grpLayout.createSequentialGroup();  
          
        //create two parallel group for adding the components in the horizontal sequential group  
        GroupLayout.ParallelGroup hParallelGroup1 = grpLayout.createParallelGroup(GroupLayout.Alignment.LEADING);  
        GroupLayout.ParallelGroup hParallelGroup2 = grpLayout.createParallelGroup(GroupLayout.Alignment.LEADING);  
        GroupLayout.ParallelGroup hParallelGroup3 = grpLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
        GroupLayout.ParallelGroup hParallelGroup4 = grpLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
        GroupLayout.ParallelGroup hParallelGroup5 = grpLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
        
        //add the labels horizontally
        hParallelGroup1.addComponent(myNodesLabel); 
        hParallelGroup2.addComponent(myRoutersLabel); 
        hParallelGroup3.addComponent(myRoutersMaxConnectionsLabel); 
        hParallelGroup4.addComponent(myEdgesLabel);
        hParallelGroup5.addComponent(myNetworkTypeSelectorLabel); 
       
          
        hParallelGroup1.addComponent(myConnectionSpeedLabel); 
        hParallelGroup2.addComponent(myLatitudeLabel); 
        hParallelGroup3.addComponent(myLongitudeLabel); 
        hParallelGroup4.addComponent(myRadiusLabel);
        
        //add the components  
        hParallelGroup1.addComponent(myNodesTextField); 
        hParallelGroup2.addComponent(myRoutersTextField); 
        hParallelGroup3.addComponent(myRoutersMaxConnectionsTextField); 
        hParallelGroup4.addComponent(myEdgesTextField);
        hParallelGroup5.addComponent(myNetworkTypeSelector); 
          
        //add two parallel groups sequentially in the horizontal sequential group  
        horizontalSeqGrp.addGroup(hParallelGroup1);  
        horizontalSeqGrp.addGroup(hParallelGroup2);  
        horizontalSeqGrp.addGroup(hParallelGroup3);
        horizontalSeqGrp.addGroup(hParallelGroup4);
        horizontalSeqGrp.addGroup(hParallelGroup5);
          
        //create one parallel group for adding the components in the vertical sequential group  
        GroupLayout.ParallelGroup vparallelGroup1 = grpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE);  
        GroupLayout.ParallelGroup vparallelGroup2 = grpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE);  
        GroupLayout.ParallelGroup vparallelGroup3 = grpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE);  
        GroupLayout.ParallelGroup vparallelGroup4 = grpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE);  
        GroupLayout.ParallelGroup vparallelGroup5 = grpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE);  
        GroupLayout.ParallelGroup vparallelGroup6 = grpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE);  
        GroupLayout.ParallelGroup vparallelGroup7 = grpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE);  
        GroupLayout.ParallelGroup vparallelGroup8 = grpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE);    
        
        
        //add the components  
        
        vparallelGroup1.addComponent(myNodesLabel);  
        vparallelGroup1.addComponent(myRoutersLabel);  
        vparallelGroup1.addComponent(myRoutersMaxConnectionsLabel);  
        vparallelGroup1.addComponent(myEdgesLabel);
        vparallelGroup1.addComponent(myNetworkTypeSelectorLabel);
        
        vparallelGroup2.addComponent(myNodesTextField);  
        vparallelGroup2.addComponent(myRoutersTextField);  
        vparallelGroup2.addComponent(myRoutersMaxConnectionsTextField);  
        vparallelGroup2.addComponent(myEdgesTextField);
        vparallelGroup2.addComponent(myNetworkTypeSelector);
        
        vparallelGroup3.addComponent(myConnectionSpeedLabel); 
        vparallelGroup3.addComponent(myLatitudeLabel); 
        vparallelGroup3.addComponent(myLongitudeLabel); 
        vparallelGroup3.addComponent(myRadiusLabel);
          
        //add this parallel group in the vertical sequential group  
        verticalSeqGrp.addGroup(vparallelGroup1);  
          
        //finally set the both sequential group to the grpLayout object  
        grpLayout.setHorizontalGroup(horizontalSeqGrp);  
        grpLayout.setVerticalGroup(verticalSeqGrp);  
        
        //add the new component in the hParallelGroup1  
        hParallelGroup1.addComponent(myConnectionSpeed);
        hParallelGroup2.addComponent(myLatitudeCentre); 
        hParallelGroup3.addComponent(myLongitudeCentre); 
        hParallelGroup4.addComponent(myRadius); 
        hParallelGroup5.addComponent(commitButton);       
        
        //add the component to the new group  
        vparallelGroup4.addComponent(myConnectionSpeed);
        vparallelGroup4.addComponent(myLatitudeCentre);  
        vparallelGroup4.addComponent(myLongitudeCentre);  
        vparallelGroup4.addComponent(myRadius);  
        vparallelGroup4.addComponent(commitButton);  
        
        //Sort server labels row out
        hParallelGroup1.addComponent(myServerSourcesLabel);
        hParallelGroup2.addComponent(myServerSinksLabel); 
        hParallelGroup3.addComponent(myServerWaitLabel); 
        hParallelGroup4.addComponent(myServerPacketLengthLabel); 
        hParallelGroup5.addComponent(myServerContentLengthLabel);       
        
        vparallelGroup5.addComponent(myServerSourcesLabel);
        vparallelGroup5.addComponent(myServerSinksLabel);  
        vparallelGroup5.addComponent(myServerWaitLabel);  
        vparallelGroup5.addComponent(myServerPacketLengthLabel);  
        vparallelGroup5.addComponent(myServerContentLengthLabel);
        
        //Sort servers row out
        hParallelGroup1.addComponent(myServerSources);
        hParallelGroup2.addComponent(myServerSinks); 
        hParallelGroup3.addComponent(myServerWait); 
        hParallelGroup4.addComponent(myServerPacketLength); 
        hParallelGroup5.addComponent(myServerContentLength);       
        
        vparallelGroup6.addComponent(myServerSources);
        vparallelGroup6.addComponent(myServerSinks);  
        vparallelGroup6.addComponent(myServerWait);  
        vparallelGroup6.addComponent(myServerPacketLength);  
        vparallelGroup6.addComponent(myServerContentLength);
        
        hParallelGroup1.addComponent(myConnectionMaxDelayLabel);
        hParallelGroup1.addComponent(myConnectionMaxDelay);
        vparallelGroup7.addComponent(myConnectionMaxDelayLabel);
        vparallelGroup8.addComponent(myConnectionMaxDelay);
        
        vparallelGroup7.addComponent(myFileNameLabel);
        vparallelGroup8.addComponent(myFileName);
        hParallelGroup2.addComponent(myFileNameLabel);
        hParallelGroup2.addComponent(myFileName);
        
        //add the new parallel group to the vertical sequential group  
        verticalSeqGrp.addGroup(vparallelGroup2); 
        verticalSeqGrp.addGroup(vparallelGroup3);  
        verticalSeqGrp.addGroup(vparallelGroup4);  
        verticalSeqGrp.addGroup(vparallelGroup5);   
        verticalSeqGrp.addGroup(vparallelGroup6);  
        verticalSeqGrp.addGroup(vparallelGroup7);   
        verticalSeqGrp.addGroup(vparallelGroup8);  
        
        this.pack();
		this.setVisible(true);
		this.setSize(width, height);
				
	}

	public void actionPerformed(ActionEvent myActionEvent) {
		if(myActionEvent.getSource() == commitButton) {
			this.doWriteOut();
		}
		
	}
	
	private void doWriteOut() {
		int intStringNetworkSelections=myNetworkTypeSelector.getSelectedIndex();
		String stringNetworkType=networkStrings[intStringNetworkSelections];
		System.out.println("\n"+stringNetworkType);
		
		intNumberNodes = (new Integer(myNodesTextField.getText())).intValue();
		intNumberRouters = (new Integer(myRoutersTextField.getText())).intValue();
		intNumberRouterConnections = (new Integer(myRoutersMaxConnectionsTextField.getText())).intValue();
		intNumberEdges = (new Integer(myEdgesTextField.getText())).intValue();
				
		double doubleConnectionSpeed = (new Double(myConnectionSpeed.getText())).doubleValue();
		
		double doubleCenterLatitude = (new Double(myLatitudeCentre.getText())).doubleValue();
		double doubleCenterLongitude = (new Double(myLongitudeCentre.getText())).doubleValue();
		double doubleOffsetRadius = (new Double(myRadius.getText())).doubleValue();
		
		System.out.println(intNumberNodes);
		System.out.println(intNumberEdges);
		
		ArrayList<Device> arrayListDevices = new ArrayList<Device>();
		ArrayList<Device> arrayListTerminalNodes = new ArrayList<Device>();
		ArrayList<Device> arrayListRouters = new ArrayList<Device>();
		
		String stringNetworkName="http://nodes0.domain.ac.uk#nodes";
		int intDevice=0;
		for(int intCounter=0;intCounter<intNumberNodes;intCounter++) {
			
			Device myDevice=new Device("http://nodes"+intDevice+".domain.ac.uk#nodes"+intDevice, 1);
			Position myPosition = this.calculatePositions(doubleCenterLatitude, doubleCenterLongitude, doubleOffsetRadius);
			myDevice.setLatitude(myPosition.getLatitude());
			myDevice.setLongitude(myPosition.getLongitude());
			arrayListDevices.add(myDevice);
			arrayListTerminalNodes.add(myDevice);
			intDevice++;
		}
		
		for(int intCounter=0;intCounter<intNumberRouters;intCounter++) {			
			Device myDevice=new Device("http://nodes"+intDevice+".domain.ac.uk#nodes"+intDevice, intNumberRouterConnections);
			Position myPosition = this.calculatePositions(doubleCenterLatitude, doubleCenterLongitude, doubleOffsetRadius);
			myDevice.setLatitude(myPosition.getLatitude());
			myDevice.setLongitude(myPosition.getLongitude());
			arrayListDevices.add(myDevice);
			arrayListRouters.add(myDevice);
			intDevice++;
		}
		
		this.writeFile(arrayListDevices, arrayListTerminalNodes, stringNetworkName, doubleConnectionSpeed);
		
		for(int intCounter=0;intCounter<arrayListDevices.size();intCounter++) {
			System.out.println();
			System.out.print("Device: "+arrayListDevices.get(intCounter).getDeviceName()+"\t Connections: "+arrayListDevices.get(intCounter).getConnections().size());
		}
	}
	
	private void writeFile(ArrayList<Device> arrayListDevices, ArrayList<Device> arrayListTerminalNodes, String stringNetworkName, double doubleConnectionSpeed) {
		try{
			// Create file 
			FileWriter fstream = new FileWriter(this.myFileName.getText());
			BufferedWriter out = new BufferedWriter(fstream);
			out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			out.newLine();
			out.write("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"");
			out.newLine();
			out.write("xmlns:rdfs=\"http://www.w3.org/2000/01/rdf-schema#\"");
			out.newLine();
			out.write("xmlns:ndl=\"http://www.science.uva.nl/research/sne/ndl#\"");
			out.newLine();
			out.write("xmlns:geo=\"http://www.w3.org/2003/01/geo/wgs84_pos#\"");
			out.newLine();
			out.write("xmlns:vc=\"http://www.w3.org/2001/vcard-rdf/3.0#\"");
			out.newLine();
			out.write("xml:base=\"http://trafficlight.uva.netherlight.nl/ndl/files/lighthouse.rdf\">");
			out.newLine();
			this.writeBag(arrayListDevices, stringNetworkName, out);
			
			this.writeDevices(arrayListDevices, out);
			
			//Setup Connections using type selector...
			
			if(networkStrings[0].contains(networkStrings[myNetworkTypeSelector.getSelectedIndex()])) {
				this.calculateConnectionsRandom(arrayListTerminalNodes, arrayListDevices, intNumberEdges, doubleConnectionSpeed);
			}
			else if(networkStrings[1].contains(networkStrings[myNetworkTypeSelector.getSelectedIndex()])) {
				this.calculateConnectionsSmallWorld(arrayListTerminalNodes, arrayListDevices, intNumberEdges, doubleConnectionSpeed);
			}
			
			this.writeConnections(arrayListDevices, out);
			
			this.calculateSoftwareConnectionsRandom(arrayListTerminalNodes);
			this.writeSoftwareConnections(arrayListTerminalNodes, out);
			
			this.calculateSoftwareSourceConnectionsRandom(arrayListTerminalNodes);
			this.writeSoftwareSourceConnections(arrayListTerminalNodes, out);
			
			//Write the exit and close
			out.write("</rdf:RDF>");
			
			//Close the output stream
			out.close();
		}
		catch (Exception e){//Catch exception if any
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	private void writeBag(ArrayList<Device> arrayListDevices, String stringNetworkName, BufferedWriter out) throws Exception {
		out.newLine();
		out.write("<rdf:Bag rdf:about=\""+stringNetworkName+"\">");
		out.newLine();
		for(int intCounter=0;intCounter<arrayListDevices.size();intCounter++) {
			out.write("\t<rdf:li rdf:resource=\""+arrayListDevices.get(intCounter).getDeviceName()+"\"/>");
			out.newLine();
		}
		
		//Close Bag
		out.write("</rdf:Bag>");
		out.newLine();
	}
	
	private void writeDevices(ArrayList<Device> myDevices, BufferedWriter out) throws Exception{
		for(int intCounter=0;intCounter<myDevices.size();intCounter++) {
			this.writeDevice(myDevices.get(intCounter), out);
		}
	}
	
	private void writeDevice(Device myDevice, BufferedWriter out) throws Exception {
		out.newLine();
		out.write("<ndl:Device rdf:about=\""+myDevice.getDeviceName()+"\">");
		out.newLine();
		out.write("\t<rdfs:label>"+ (myDevice.getDeviceName().split("#"))[1]+"</rdfs:label>");
		out.newLine();
		
		ArrayList<String> myInterfaces = myDevice.getInterfaces();
		
		for(int intCounter=0;intCounter<myInterfaces.size();intCounter++) {
			out.write("\t<ndl:hasInterface rdf:resource=\""+myInterfaces.get(intCounter)+"\"/>");
			out.newLine();
		}
		
		out.write("\t<geo:lat>"+ myDevice.getLatitude()+"</geo:lat>");
		out.newLine();
		out.write("\t<geo:long>"+ myDevice.getLongitude()+"</geo:long>");
		out.newLine();
		
		out.write("</ndl:Device>");
	}
	
	private void writeConnections(ArrayList<Device> myDevices, BufferedWriter out) throws Exception {
		for(int intDevicesCounter=0;intDevicesCounter<myDevices.size();intDevicesCounter++) {
			ArrayList<Connection> myConnections=myDevices.get(intDevicesCounter).getConnections();
			
			for(int intConnectionsCounter=0;intConnectionsCounter<myConnections.size();intConnectionsCounter++) {
				out.write("<ndl:Interface rdf:about=\""+myConnections.get(intConnectionsCounter).getSource()+"\">");
				out.newLine();
				out.write("\t<rdfs:label>"+myConnections.get(intConnectionsCounter).getSource().split("#")[1]+"</rdfs:label>");
				out.newLine();
				out.write("\t<ndl:connectedTo rdf:resource=\""+myConnections.get(intConnectionsCounter).getDestination()+"\"/>");
				out.newLine();
				out.write("<ndl:capacity rdf:datatype=\"http://www.w3.org/2001/XMLSchema#float\">"+myConnections.get(intConnectionsCounter).getConnectionSpeed()+"</ndl:capacity>");
				out.newLine();
				out.write("<ndl:latency rdf:datatype=\"http://www.w3.org/2001/XMLSchema#float\">"+myConnections.get(intConnectionsCounter).getConnectionLatency()+"</ndl:latency>");
				out.newLine();
				out.write("</ndl:Interface>");
				out.newLine();
				out.newLine();
			}			
		}
	}
	
	private void writeSoftwareConnections(ArrayList<Device> myDevices, BufferedWriter out) throws Exception {
		for(Device myDevice:myDevices) {
			for(Server myServer:myDevice.getServers()) {
				out.newLine();
				out.write("<ndl:VideoServer rdf:about=\""+myServer.getName()+"\">");
				out.newLine();
				out.write("\t<rdfs:label>"+myServer.getName().split("#")[1]+"</rdfs:label>");
				out.newLine();
				out.write("\t<ndl:videoServerWaitInterval rdf:datatype=\"http://www.w3.org/2001/XMLSchema#float\">"+myServer.getWait()+"</ndl:videoServerWaitInterval>");
				out.newLine();
				out.write("\t<ndl:videoServerPacketLength rdf:datatype=\"http://www.w3.org/2001/XMLSchema#float\">"+myServer.getPacketLength()+"</ndl:videoServerPacketLength>");
				out.newLine();
				out.write("\t<ndl:videoServerContentLength rdf:datatype=\"http://www.w3.org/2001/XMLSchema#float\">"+myServer.getContentLength()+"</ndl:videoServerContentLength>");
				out.newLine();
				out.write("</ndl:VideoServer>");
				out.newLine();
				out.newLine();
			}
		}
	}
	
	private void writeSoftwareSourceConnections(ArrayList<Device> myDevices, BufferedWriter out) throws Exception {
		for(Device myDevice:myDevices) {
			for(Sink mySink:myDevice.getSinks()) {
				out.newLine();
				out.write("<ndl:VideoServerConnection rdf:about=\""+mySink.getSinkName()+"\">");
				out.newLine();
				out.write("\t<rdfs:label>"+mySink.getSinkName().split("#")[1]+"</rdfs:label>");
				out.newLine();
				out.write("\t<ndl:applicationToServerConnection rdf:resource=\""+mySink.getSourceConnection()+"\"/>");
				out.newLine();
				out.write("\t<ndl:maxDelay rdf:datatype=\"http://www.w3.org/2001/XMLSchema#float\">"+mySink.getMaxDelay()+"</ndl:maxDelay>");
				out.newLine();
				out.write("</ndl:VideoServerConnection>");
				out.newLine();
				out.newLine();
			}
		}
	}
	
	private void calculateConnectionsRandom(ArrayList<Device> arrayListTerminalNodes, ArrayList<Device> arrayListDevices, int intNumberConnections, double doubleConnectionSpeed) {
		int intNumberDevices=arrayListDevices.size();
		
		for(int intCounter=0;intCounter<intNumberConnections;intCounter++) {
			boolean boolSet=false;
			
			while(!boolSet) {
		
				int intDestLocation=0;
				int intSourceLocation=0;
				
				while(intDestLocation==intSourceLocation) {
					double doubleRandomDeviceSource=Math.random()*(double)intNumberDevices;
					double doubleRandomDeviceDest=Math.random()*(double)intNumberDevices;
					intDestLocation=(new Double(doubleRandomDeviceDest)).intValue();
					intSourceLocation=(new Double(doubleRandomDeviceSource)).intValue();
				}
				
				String stringDest=arrayListDevices.get(intDestLocation).getFreePort();
				String stringSource=arrayListDevices.get(intSourceLocation).getFreePort();
				
				if(stringDest.compareTo("")!=0 && stringSource.compareTo("")!=0) {
					double doubleSourceLatitude=arrayListDevices.get(intSourceLocation).getLatitude();
					double doubleSourceLongitude=arrayListDevices.get(intSourceLocation).getLongitude();
					
					double doubleDestLatitude=arrayListDevices.get(intDestLocation).getLatitude();
					double doubleDestLongitude=arrayListDevices.get(intDestLocation).getLongitude();
					
					double doubleDistance=this.calculateDistance(doubleSourceLatitude, doubleSourceLongitude, doubleDestLatitude, doubleDestLongitude);
									
					double doubleLatency=(this.doubleLengthFiddleFactor)*doubleDistance/(this.doublePropSpeed);
				
					arrayListDevices.get(intDestLocation).addConnection(stringDest, stringSource, doubleConnectionSpeed, doubleLatency);
					arrayListDevices.get(intSourceLocation).addConnection(stringSource, stringDest, doubleConnectionSpeed, doubleLatency);
					boolSet=true;
				}				
			}
		}	
	}
	
	private void calculateConnectionsSmallWorld(ArrayList<Device> arrayListTerminalNodes, ArrayList<Device> arrayListDevices, int intNumberConnections, double doubleConnectionSpeed) {
		ArrayList<Device> arrayListTempDevices = new ArrayList<Device>(arrayListDevices);
		
		for(int intCounter=0;intCounter<intNumberConnections;intCounter++) {
			int intNumberDevices=arrayListTempDevices.size();

			boolean boolSet=false;
			
			while(!boolSet) {				
				int intDestLocation=0;
				int intSourceLocation=0;
				
				while(intDestLocation==intSourceLocation) {
					double doubleRandomDeviceSource=Math.random()*(double)intNumberDevices;
					double doubleRandomDeviceDest=Math.random()*(double)intNumberDevices;
					intDestLocation=(new Double(doubleRandomDeviceDest)).intValue();
					intSourceLocation=(new Double(doubleRandomDeviceSource)).intValue();
				}
				
				String stringDest=arrayListTempDevices.get(intDestLocation).getFreePort();
				String stringSource=arrayListTempDevices.get(intSourceLocation).getFreePort();
				
				if(stringDest.compareTo("")!=0 && stringSource.compareTo("")!=0) {
					double doubleSourceLatitude=arrayListTempDevices.get(intSourceLocation).getLatitude();
					double doubleSourceLongitude=arrayListTempDevices.get(intSourceLocation).getLongitude();
					
					double doubleDestLatitude=arrayListTempDevices.get(intDestLocation).getLatitude();
					double doubleDestLongitude=arrayListTempDevices.get(intDestLocation).getLongitude();
					
					double doubleDistance=this.calculateDistance(doubleSourceLatitude, doubleSourceLongitude, doubleDestLatitude, doubleDestLongitude);
									
					double doubleLatency=(this.doubleLengthFiddleFactor)*doubleDistance/(this.doublePropSpeed);
					
					String stringDestName=arrayListTempDevices.get(intDestLocation).getDeviceName();
					String stringSourceName=arrayListTempDevices.get(intSourceLocation).getDeviceName();
					
					int intDestLocationLookup=this.findDeviceIndex(stringDestName, arrayListDevices);
					int intSourceLocationLookup=this.findDeviceIndex(stringSourceName, arrayListDevices);
					
					arrayListDevices.get(intDestLocationLookup).addConnection(stringDest, stringSource, doubleConnectionSpeed, doubleLatency);
					arrayListDevices.get(intSourceLocationLookup).addConnection(stringSource, stringDest, doubleConnectionSpeed, doubleLatency);
					
					if(arrayListDevices.get(intDestLocationLookup).getNumberFreePorts()>0) {
						arrayListTempDevices.add(arrayListDevices.get(intDestLocationLookup));
					}
					if(arrayListDevices.get(intSourceLocationLookup).getNumberFreePorts()>0) {
						arrayListTempDevices.add(arrayListDevices.get(intSourceLocationLookup));
					}
					boolSet=true;
				}
			}
		}	
	}
	
	private int findDeviceIndex(String stringDeviceName, ArrayList<Device> arrayListToFind) {
		int intRetVal=0;
		
		for(int intCounter=0;intCounter<arrayListToFind.size();intCounter++) {
			if(stringDeviceName.contains(arrayListToFind.get(intCounter).getDeviceName())) {
				intRetVal=intCounter;
			}
		}
		
		return intRetVal;
	}
	
	private void calculateSoftwareConnectionsRandom(ArrayList<Device> arrayListDevices) {
		intNumberServers = (new Integer(myServerSources.getText())).intValue();
		intNumberServerConnections = (new Integer(myServerSinks.getText())).intValue();
		
		double doubleWaitInterval = (new Double(myServerWait.getText())).doubleValue();
		double doublePacketLength = (new Double(myServerPacketLength.getText())).doubleValue();
		double doubleContentLength = (new Double(myServerContentLength.getText())).doubleValue();
		
		for(int intCounter=0;intCounter<intNumberServers;intCounter++) {
			int intSize=arrayListDevices.size();
			
			int intPickPoint=(new Double(Math.random()*(double)intSize)).intValue();
			
			arrayListDevices.get(intPickPoint).addServer(doublePacketLength, doubleContentLength, doubleWaitInterval);			
		}
		
	}
	
	private void calculateSoftwareSourceConnectionsRandom(ArrayList<Device> arrayListDevices) {
		ArrayList<Server> arrayListServers = new ArrayList<Server>();
		for(Device myDevice:arrayListDevices) {
			for(Server myServer:myDevice.getServers()) {
				arrayListServers.add(myServer);
			}
		}
		
		for(int intCounter=0;intCounter<intNumberServerConnections;intCounter++) {
			int intPickPointSource=0;
			int intPickPointSink=0;
			intPickPointSource=(new Double(Math.random()*arrayListServers.size())).intValue();
			intPickPointSink=(new Double(Math.random()*arrayListDevices.size())).intValue();
			
			while(arrayListServers.get(intPickPointSource).getName().contains(arrayListDevices.get(intPickPointSink).getDeviceName())) {
				intPickPointSource=(new Double(Math.random()*arrayListServers.size())).intValue();
				intPickPointSink=(new Double(Math.random()*arrayListDevices.size())).intValue();
			}
			
			double doubleMaxDelay = (new Double(myConnectionMaxDelay.getText())).doubleValue();
			
			arrayListDevices.get(intPickPointSink).addSink(arrayListServers.get(intPickPointSource).getName(), doubleMaxDelay);
			
		}
	}
	
	private Position calculatePositions(double doubleCenterLatitude, double doubleCenterLongitude, double doubleOffsetRadius) {
			
		double oneDegreeInM=111319.9;
		
		double doublePositionShift=Math.random()*doubleOffsetRadius;
		
		double doubleAngle=Math.random()*2*Math.PI;
		
		if(doubleAngle>=2*Math.PI) {
			doubleAngle=0;
		}
		
		double deltaLatitude=Math.sqrt(Math.pow(doublePositionShift,2)/(1+Math.pow(Math.tan(doubleAngle), 2)));
		
		double deltaLongitude=Math.sqrt(Math.pow(doublePositionShift,2)-Math.pow(deltaLatitude, 2));
		
		if(doubleAngle>=0 && doubleAngle<=Math.PI/2) {
			//Do Nothing
		}
		
		if(doubleAngle>=Math.PI/2 && doubleAngle<=Math.PI) {
			deltaLatitude=-deltaLatitude;
		}
		
		if(doubleAngle>=Math.PI && doubleAngle<=3*Math.PI/2) {
			deltaLatitude=-deltaLatitude;
			deltaLongitude=-deltaLongitude;
		}
		
		if(doubleAngle>3*Math.PI/2 && doubleAngle<=2*Math.PI) {
			deltaLongitude=-deltaLongitude;
		}
		
		return new Position(doubleCenterLatitude+deltaLatitude/oneDegreeInM, doubleCenterLongitude+deltaLongitude/oneDegreeInM);
		
		
	}
	
	private double calculateDistance(double doubleLat1, double doubleLong1, double doubleLat2, double doubleLong2) {
		double doubleDistance = 0;
		double doubleEarthRadius = 6372.8e3;
		doubleLat1 = doubleLat1 * Math.PI / 180;
		doubleLong1 = doubleLong1 * Math.PI / 180;
		doubleLat2 = doubleLat2 * Math.PI / 180;
		doubleLong2 = doubleLong2 * Math.PI / 180;

		double deltaLong = doubleLong2 - doubleLong1;
		double deltaLat = doubleLat2 - doubleLat1;
		double a = Math.pow((Math.sin(deltaLat / 2)), 2)
				+ (Math.cos(doubleLat1) * Math.cos(doubleLat2) * (Math.pow(
						Math.sin(deltaLong / 2), 2)));
		double c = 2 * Math.asin(Math.sqrt(a));
		doubleDistance = doubleEarthRadius * c;

		return doubleDistance;
	}

}
