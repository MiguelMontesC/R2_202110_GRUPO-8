package model.data_structures;

public class Node  <T extends Comparable <T>> {

	private Node<T> anterior;
	private Node<T> next;
	private T item;
	
	
	public Node (T item)
	{
	next = null;
	this.item = item;
	}
	
	public Node<T> getNext() 
	{
	return next;
	}
	
	public Node<T> getAnterior()
	{
		return anterior;
	}
	
	public void setNextNode ( Node<T> next) 
	{
	this.next = next;
	}
	
	public T getItem()
	{
	return item;
	}
	
	public void setItem (T item)
	{
	this.item = item;
	}
}
