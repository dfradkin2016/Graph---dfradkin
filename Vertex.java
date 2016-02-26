/**
Vertex class.
Part of a graph.
Each vertex holds two ArrayLists - one with all the pointers it connects to,
and one with their lengths.
Only holds lengths as integers.

@author	Daria Fradkin
@version	February 10, 2016
*/

import java.util.ArrayList;

public class Vertex<E>
{
	private E value;
	private ArrayList<Vertex<E>> pointers;
	private ArrayList<Integer> costs;
	private boolean beenVisited;
	
	/**
	Constructor.
	Simple, just a value.
	
	@param	v Value
	*/
	public Vertex(E v)
	{
		value = v;
		pointers = new ArrayList<Vertex<E>>();
		costs = new ArrayList<Integer>();
		beenVisited = false;
	}
	
	//2 way
	/**
	Connector
	Connects forwards and backwards with the same length
	
	@param	v	other Vertex
	@param	c	cost
	*/
	public void connect(Vertex v, int c)
	{
		//could also call this.add(v, c) for next two lines
		pointers.add(v);
		costs.add(c);
		//needs to use add because pointers and costs are private in other Vertex
		//(if there was no accessor (but there is))
		v.add(this, c);
	}
	
	/**
	1-way connector
	From this vertex to another, but not back
	
	@param	v	other Vertex
	@param	c	cost
	*/
	public void add(Vertex v, Integer c)
	{
		pointers.add(v);
		costs.add(c);
	}
	
	/**
	Value accessor
	
	@return	Value
	*/
	public E value()
	{
		return value;
	}
	
	/**
	Value modifier
	
	@param	v	Value
	*/
	public void setValue(E v)
	{
		value = v;
	}
	
	/**
	Pointers accessor.
	Unnecessary method
	
	@return	pointers list
	*/
	public ArrayList<Vertex<E>> pointers()
	{
		return pointers;
	}
	
	/**
	Costs accessor.
	Unnecessary method
	
	@return	costs list
	*/
	public ArrayList<Integer> costs()
	{
		return costs;
	}
	
	/**
	Checks if the point has been visited.
	
	@return	true if been visited
	*/
	public boolean beenVisited()
	{
		return beenVisited;
	}
	
	/**
	beenVisited modifier
	sets beenVisited to boolean
	
	@param	b	beenVisited
	*/
	public void setVisited(boolean b)
	{
		beenVisited = b;
	}
	
	/**
	beenVisited modifier
	Sets to the opposite of what it is now
	
	@param	b	beenVisited
	*/
	public void changeVisited(boolean b)
	{
		beenVisited = !beenVisited;
	}
}