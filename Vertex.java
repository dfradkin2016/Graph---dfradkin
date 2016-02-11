//February 10, 2016
//Daria Fradkin

import java.util.ArrayList;

public class Vertex<E>
{
	private E value;
	private ArrayList<Vertex> pointers;
	private ArrayList<Integer> costs;
	private boolean beenVisited;
	
	/*
	Constructor.
	*/
	public Vertex(E v)
	{
		value = v;
		pointers = new ArrayList<Vertex>();
		costs = new ArrayList<Integer>();
		beenVisited = false;
	}
	
	//2 way
	public void connect(Vertex v, int c)
	{
		pointers.add(v);
		costs.add(c);
		v.add(this, c);
	}
	
	//1 way
	//from this vertex to another, but not back
	//1-directional
	public void add(Vertex v, Integer c)
	{
		pointers.add(v);
		costs.add(c);
	}
	
	//public void traverse()
	{
		
	}
	
	public E value()
	{
		return value;
	}
	
	public void setValue(E v)
	{
		value = v;
	}
	
	public ArrayList<Vertex> pointers()
	{
		return pointers;
	}
	
	public ArrayList<Integer> costs()
	{
		return costs;
	}
	
	public boolean beenVisited()
	{
		return beenVisited;
	}
	
	public void setVisited(boolean b)
	{
		beenVisited = b;
	}
	
	public void changeVisited(boolean b)
	{
		beenVisited = !beenVisited;
	}
}