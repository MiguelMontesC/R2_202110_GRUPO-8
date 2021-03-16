package model.data_structures;

public class NodoTS <K extends Comparable<K>, V> implements Comparable<NodoTS<K,V>>{

	
	private NodoTS<K,V> next;
	private Node<V> nodeTS;
	private K key;
	private V value; 
	
	public NodoTS(K pKey, V pValue)
	{
		next = null;
		nodeTS=null;
		key = pKey; 
		value = pValue; 
	}
	
	public Node<V> getNodeTS() 
	{
	return nodeTS;
	}
	
	public void setMyNode ( Node<V> pNode) 
	{
		nodeTS = pNode;
	}
	
	public NodoTS<K, V> getNext() 
	{
	return next;
	}
	
	public void setNextNode ( NodoTS<K, V> pNext) 
	{
	this.next = pNext;
	}
	
	public K getKey()
	{
	return key;
	}
	
	public V getValue()
	{
		return value;
	}
	
	public void setKey(K pKey)
	{
		this.key = pKey;
	}
	
	public void setValue(V pValue)
	{
		this.value = pValue;
	}

	
	@Override
	public int compareTo(NodoTS<K, V> otro)
	{
	return this.key.compareTo( otro.key );
	}

	

}
