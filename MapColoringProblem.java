import java.io.FileNotFoundException;

//This class implements the map coloring problem.


public class MapColoringProblem {

	Graph graph;
	int[] color_config_array;//this array holds the color number for each vertex corresponding to the index
	//For example - if the number of colors is 3 . Then then different colours will be repreented by numbers 1,2 and 3.
	
	
	//this method prints which vertex will be of which color
	public void printConfiguration()
	{
		for(int i=0;i<color_config_array.length;i++)
		{
			System.out.println("The " +(i+1)+"(th) vertex will be colored in color number "+color_config_array[i]);
		}
	}
	
	
	//this method colors the graph using recursive backtracking in all possible combinations and returns true of the graph can 
	//be colored in the given number of colors
	public boolean colorGraph(int vertex_num,int number_of_colours)
	{
		if(vertex_num==graph.adjLists.length)//base condition
		{
			return checkGraph();
		}
		for(int i=1;i<=number_of_colours;i++)
		{
			color_config_array[vertex_num]=i;
			if(colorGraph(vertex_num+1,number_of_colours)==true)
			{
				return true;
			}
		}
		return false;
	}
	
	//this method  returns true of graph is colored properly and false otherwise
	public boolean checkGraph()
	{
		boolean result=true;
		int no_Of_vertex=graph.adjLists.length;
		for(int i=0;i<no_Of_vertex;i++)
		{
			int color_of_vertex=color_config_array[i];
			Neighbour neighbour=graph.adjLists[i].adjList;
			while(neighbour!=null)
			{
				if(color_of_vertex==color_config_array[neighbour.vertexNum])
				{
					result=false;
					return result;
				}
				neighbour=neighbour.next;
			}
			
		}
		return result;
	}
	
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String path="C:\\Users\\sangam\\Desktop\\graph.txt";
		MapColoringProblem  mapColoringProblem=new MapColoringProblem();
		mapColoringProblem.graph=new Graph(path);
		int no_Of_vertex=mapColoringProblem.graph.adjLists.length;
		mapColoringProblem.color_config_array=new int[no_Of_vertex];
		
		int number_of_colours=3;//this can be changed as per the user input
		boolean result=mapColoringProblem.colorGraph(0, number_of_colours);//0 is because we have to start the coloring from zeroth vertex 
		if(result == true)
		{
			System.out.println("The combination is ");
			mapColoringProblem.printConfiguration();
		}
		else
		{
			System.out.println("the graph cannot be colored in these many given colours");	
		}
		
		

	}

}
