
public class Vertex {
	
	String name;
	Neighbour adjList;
	
	public Vertex(String name,Neighbour neighbours)
	{
		this.name=name;
		this.adjList=neighbours;
	}

}
