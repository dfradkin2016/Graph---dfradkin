//Daria Fradkin
//February 11, 2016

import java.util.ArrayList;
import java.lang.Math;

public class STravelingSalesman
{
	private static ArrayList<Vertex<String>> all;
	
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
	
	private static void join()
	{
		for (int i = 0; i < all.size(); i++)
		{
			for (int j = i + 1; j < all.size(); j++)
			{
				all.get(i).connect(all.get(j), (int) (Math.random()*100));
			}
		}
	}
	
	private static boolean allVisited()
	{
		for (int i = 0; i < all.size(); i++)
		{
			if (!all.get(i).beenVisited())
				return false;
		}
		return true;
	}
	
	private static void traverse()
	{
		//System.out.println("h");
		Vertex<String> current = all.get(0);
		int best = 0;
		while (!allVisited())
		{
			print(current);
			best = all.size() + 1;
			for (int i = 0; i < current.pointers().size(); i++)
			{
				if (!current.pointers().get(i).beenVisited())
				{
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
			if (! (best == all.size() + 1))
				current = current.pointers().get(best);
		}
	}
	
	private static void print(Vertex<String> current)
	{
		System.out.println("You are currently in " + current.value());
		System.out.println("Your options are:");
		for (int i = 0; i < current.pointers().size(); i++)
		{
			if (!current.pointers().get(i).beenVisited())
			{
				System.out.println(current.pointers().get(i).value() + current.costs().get(i));
			}
		}
	}
	
	public static void main(String[] Args)
	{
		init();
		traverse();
	}

}