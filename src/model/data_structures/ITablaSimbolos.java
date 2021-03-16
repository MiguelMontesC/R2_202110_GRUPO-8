package model.data_structures;

public interface ITablaSimbolos <K extends Comparable<K>,V>  {
	
    void put(K key,V value) ;
	
	ILista<V> get(K key);
	
	V remove(K key);
	
	boolean contains(K key);
	
	boolean isEmpty();
	
	int size();
	
	ILista<K> keySet();
	
	ILista<V> valueSet();
	
}
