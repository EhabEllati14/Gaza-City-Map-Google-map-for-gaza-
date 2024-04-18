package application;

import java.util.LinkedList;

public class Vertex implements Comparable<Vertex> {
	 private String cityname; // name of city
	 private Vertex previousvertex ; // the previous vertex for it to use it in path and other things 
	private double longitude; // from the file we store the long. and late. for each vertex 
	private double latitude;
	private double x;
	private double y;
	private double distance=Double.MAX_VALUE; // the distance between the 2 vertexes 
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	// we use the max-value because the distance is could be large !!
	 private boolean isKnown; // like this if the vertex is known or unknown 
	// during the graph traversal .
	
	 private  LinkedList<Edge> edgelinked=new LinkedList<Edge>() ;
	
	// we store them as when we read them from file
	Vertex(String cityname,double latitude,double longitude,double x,double y,boolean isKnown, Vertex previousvertex){
		this.cityname=cityname;
		this.latitude=latitude;
		this.longitude=longitude;
		this.x=x;
		this.y=y;
		this.isKnown=isKnown;
		this.previousvertex=previousvertex;
		
	}

//	Vertex(String cityname,double latitude,double longitude,double x,double y,boolean isKnown, Vertex previous){
//		this.cityname=cityname;
//		this.latitude=latitude;
//		this.longitude=longitude;
//		this.x=x;
//		this.y=y;
//		this.isKnown=isKnown;
//		
//	}
//	
	public String getCityname() {
		return cityname;
	}

	public Vertex getPreviousvertex() {
		return previousvertex;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getDistance() {
		return distance;
	}

	public boolean isKnown() {
		return isKnown;
	}


	public LinkedList<Edge> getEdge() {
		return edgelinked;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public void setPreviousvertex(Vertex previousvertex) {
		this.previousvertex = previousvertex;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public void setVisit(boolean isKnown) {
		this.isKnown = isKnown;
	}

	public void setEdge(LinkedList<Edge> edgelinked) {
		this.edgelinked = edgelinked;
	}
	
	// here we write a method for findedge return true or false 
	// if it has an edge we write that we have an edge if its not 
	// the method takes the city name 
	
	
	public  boolean FindifhaveAdj(Vertex c) {
		 for(int i=0; i<edgelinked.size() ;i++) {
			 if(edgelinked.get(i).getOne().getCityname().equalsIgnoreCase(c.getCityname())|| edgelinked.get(i).getTwo().getCityname().equalsIgnoreCase(c.cityname)) {
				return true;
			 }
		 }
		 return false;
	}
	
	
	public String ttoString() {
		String r = cityname+":";
		for (int i = 0; i < edgelinked.size(); i++) {
		System.out.println("with "+edgelinked.get(i).getTwo().getCityname() + " The dis ya ehabbb   "+edgelinked.get(i).getCost());
		}
		return r;
	}

	@Override
	public int compareTo(Vertex o) {
		
		return Double.compare(this.distance,o.getDistance());
	}
	
	
	
	
	

}
