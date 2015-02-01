
public class Neighbour {

	public int vertexNum;
	public Neighbour next;
	
	public Neighbour(int vnum,Neighbour nbr)
	{
		this.vertexNum=vnum;
		this.next=nbr;
	}
}
