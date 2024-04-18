package application;

public class Edge {
   private  Vertex one ;
   private Vertex two ;
   private  double cost ;
    
    Edge(Vertex one , Vertex two, double cost){
    	this.one=one;
    	this.two=two;
    	this.cost=cost;
    }

	public Vertex getOne() {
		return one;
	}

	public Vertex getTwo() {
		return two;
	}

	public double getCost() {
		return cost;
	}

	public void setOne(Vertex one) {
		this.one = one;
	}

	public void setTwo(Vertex two) {
		this.two = two;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
}
