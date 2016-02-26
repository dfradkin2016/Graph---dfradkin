/**
This is a "stupid" traveling salesman.
It creates a bunch of points with random distances between them.
The distances between points are not related.
Starting from the first point, it chooses the shortest distance to a point it has not visited yet.
This way, it goes to every point in a relatively quick path, although not the fastest.
It does not return to where it started from.

@author	Daria Fradkin
@version	February 17, 2016
*/
import java.util.ArrayList;
import java.lang.Math;

public class STravelingSalesman
{
	//All points within the "map", all vertexes
	private static ArrayList<Vertex<String>> all;
	
	/**
	Initializes the list of vertexes.
	Calls join to connect the points.
	*/
	private static void init()
	{
		all = new ArrayList<Vertex<String>>();
		Vertex<String> ny = new Vertex<String>("New York");
		all.add(ny);
		Vertex<String> tokyo = new Vertex<String>("Tokyo");
		all.add(tokyo);
		Vertex<String> paris = new Vertex<String>("Paris");
		all.add(paris);
		Vertex<String> moscow = new Vertex<String>("Moscow");
		all.add(moscow);
		Vertex<String> la = new Vertex<String>("Los Angeles");
		all.add(la);
		Vertex<String> chicago = new Vertex<String>("Chicago");
		all.add(chicago);
		Vertex<String> athens = new Vertex<String>("Athens");
		all.add(athens);
		Vertex<String> denver = new Vertex<String>("Denver");
		all.add(denver);
		join();
	}
	
	/**
	Joins the points with random lengths.
	*/
	private static void join()
	{
		for (int i = 0; i < all.size(); i++)
		{
			//only need to connect with what comes afterwards
			//because every pair only needs to be called once because
			//connect connects forwards and backwards
			for (int j = i + 1; j < all.size(); j++)
			{
				//Connect is from vertex class
				//Connects them forwards and backwards.
				all.get(i).connect(all.get(j), (int) (Math.random()*100));
			}
		}
	}
	
	/**
	Checks if all points have been visited.
	
	@return	true if all visited
	*/
	private static boolean allVisited()
	{
		for (int i = 0; i < all.size(); i++)
		{
			if (!all.get(i).beenVisited())
				return false;
		}
		return true;
	}
	
	/**
	Method with main algorithm
	*/
	private static void traverse()
	{
		//starts at first point
		Vertex<String> current = all.get(0);
		//keeps track of best path
		int best = 0;
		//stops when all points visited
		while (!allVisited())
		{
			//Print is to see that it is running correctly
			print(current);
			//best starts at nonexistent path
			best = all.size() + 1;
			for (int i = 0; i < current.pointers().size(); i++)
			{
				if (!current.pointers().get(i).beenVisited())
				{
					//if its the first unvisited point
					//cant call get(best) because index out of bounds
					if (best == all.size() + 1)
					{
						best = i;
					}
					else
					{
						if (current.costs().get(i) < current.costs().get(best))
						{
							best = i;
						}
					}
				}
			}
			current.setVisited(true);
			//if there was a path that was not visited
			//only not called when on last iteration
			if (! (best == all.size() + 1))
				current = current.pointers().get(best);
		}
	}
	
	/**
	Print method.
	Prints out where you are and what you are options with their lengths
	*/
	private static void print(Vertex<String> current)
	{
		System.out.println("You are currently in " + current.value());
		System.out.println("Your options are:");
		for (int i = 0; i < current.pointers().size(); i++)
		{
			//only prints if it is not visited yet
			if (!current.pointers().get(i).beenVisited())
			{
				System.out.println(current.pointers().get(i).value() + current.costs().get(i));
			}
		}
	}
	
	/**
	Main method.
	Calls other methods.
	*/
	public static void main(String[] Args)
	{
		init();
		traverse();
	}

}