package model.data_structures;

public class TablaSimbolos <K extends Comparable<K> ,V extends Comparable<V> > implements ITablaSimbolos<K,V> {

	
	
	private int N;
	private int M = 7; 
	private K[] keys; 
	private Lista[] vals; 
	private int reharsh;
	
	
	public TablaSimbolos()
	{
	keys = (K[]) new Comparable[M];
	vals =   new Lista[M];
	reharsh=0;
	}
	
	
	private int hash(K key)
	{
	return (key.hashCode() & 0x7fffffff) % M;
	}
	
	
	
	

	
	public void put(K key, V value) {
		// TODO Auto-generated method stub
		double con=(double)N/M;
		
		
		if (0.75< con)
		{
			resize(2*M); // double M (see text)
		
		}
		
		int i;
		for (i = hash(key); keys[i] != null; i = (i + 1) % M)
			if (keys[i].equals(key))
			{
				vals[i].addFirst( value );
				return;
			}
		
			keys[i]=  key;
			vals[i]=new Lista  (value);
			
			N++;

		
	}

	public ILista<V> get(K key) {
		// TODO Auto-generated method stub
		Lista<V> prov1= new Lista<>();
		int i;
		for (i =hash(key); keys[i] != null; i = (i + 1) % M)
			if (keys[i].equals(key))
				prov1=vals[i];
				
		return prov1;
	}

	public V remove(K key) {
		// TODO Auto-generated method stub
		int i;
		
		V rta=null;
		for (i =hash(key); keys[i] != null; i = (i + 1) % M)
			if (keys[i].equals(key))
			{
				rta=(V) vals[i].firtsElement();
				keys[i]=null;
				vals[i]=null;
				N--;
				return rta;
			}
		
		return rta;
	}

	public boolean contains(K key) {
		// TODO Auto-generated method stub
		int i;
		for (i =hash(key); keys[i] != null; i = (i + 1) % M)
			if (keys[i].equals(key))
				return true;
			
		
		return false;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		int i;
		for (i =0; i<M&&keys[i] != null; i++)
			return false;
					
		return true;
	}

	public int size() {
		// TODO Auto-generated method stub
		return M;
	}

	public ILista<K> keySet() {
		// TODO Auto-generated method stub
		Lista<K> prov1= new Lista<>();
		int i;
		for (i =0; i<M&&keys[i] != null; i++)
			prov1.addFirst(keys[i]);
		
		return prov1;
	}

	public ILista<V> valueSet() {
		// TODO Auto-generated method stub
		Lista<V> prov1= new Lista<>();
		int i;
		for (i =0; i<M&&keys[i] != null; i++)
				for(Node<V> y=(Node<V>) vals[i].firtsElement() ; y != null; y = y.getNext())
				prov1.addFirst(y.getItem());
				
		return prov1;
	}

}
