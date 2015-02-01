import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Graph {

	Vertex[] adjLists;

	//constructor
	public Graph(String file) throws FileNotFoundException
	{


		Scanner sc=new Scanner(new File(file));

		String graphType=sc.next();
		boolean undirected=true;
		if(graphType.equals("directed"))
		{
			undirected=false;
		}

		adjLists=new Vertex[sc.nextInt()];


		//read Vertices
		for(int v=0;v<adjLists.length;v++)
		{
			adjLists[v]=new Vertex(sc.next(),null);
		}
		//read edges
		while(sc.hasNext())
		{
			//read Vertex names and Translate into Vertex numbers
			int v1=indexForName(sc.next());
			int v2=indexForName(sc.next());

			//add v2 to front of v1's adjacency List and
			//add v1 to front of v2's adjacency List 
			adjLists[v1].adjList=new Neighbour(v2, adjLists[v1].adjList); //inserting at the head of the linked list!
			if(undirected==true)
			{
				adjLists[v2].adjList=new Neighbour(v1, adjLists[v2].adjList); //inserting at the head of the linked list!
			}	
		}
	}

	int indexForName(String name)
	{
		for(int v=0;v<adjLists.length;v++)
		{
			if(adjLists[v].name.equals(name))
			{
				return v;
			}
		}
		return -1;	
	}

	public void print()
	{
		System.out.println();
		for(int v=0;v<adjLists.length;v++)
		{
			System.out.println(adjLists[v].name);
			for(Neighbour nbr=adjLists[v].adjList;nbr!=null;nbr=nbr.next )
			{
				System.out.println("==>"+adjLists[nbr.vertexNum].name);
			}
			System.out.println("\n");
		}


	}
	//Place the graph.txt on your Desktop and use the following path
	//Path ->   C:\Users\sangam\Desktop\graph.txt
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter graph input file name:");
		String file=sc.nextLine();
		Graph graph=new Graph(file);
		graph.print();

	}

}
