/**
 * 
 */
package model.data_structures;

/**
 * @author Cumpu Grande
 *
 */
public class Lista <T extends Comparable <T>> implements ILista <T> {

	private Node<T> listFirst = null;
	private int listSize;


	public Lista (T item)
	{
		listFirst = new Node<T> (item) ;
		listSize = 1;
	}

	@Override
	public void addFirst(T element) {
		// TODO Auto-generated method stub
		if(listFirst == null)
		{
			listFirst = (Node<T>) element;
		}
		else
		{
			Node <T> newHead = new Node<> (element);
			newHead.setNextNode(listFirst);
			listFirst = newHead;
			listSize++;
		}
	}

	@Override
	public void addLast(T element) {
		// TODO Auto-generated method stub
		Node <T> newNode = new Node<> (element);
		if(listFirst == null) 
		{
			listFirst = newNode;
		}
		else 
		{
			Node <T> actual = listFirst;
			while(actual.getNext() != null) 
			{
				actual = actual.getNext();
			}
			actual.setNextNode(newNode);
		}
		listSize++;


	}

	@Override
	public void insertElement(T element, int pos) {
		// TODO Auto-generated method stub
		Node <T> actual= listFirst;
		int contador=1;
		boolean parar=false;

		if(pos==1)
		{
			this.addFirst(element);
		}
		else if (pos==listSize)
		{
			this.addLast(element);
		}
		else
		{
			while (actual.getNext()!= null&&!parar)
			{
				if(contador==pos-1)
				{
					Node<T> nuevo=new Node<>(element);
					Node<T> reemplazar= actual.getNext();
					actual.setNextNode(nuevo);
					nuevo.setNextNode(reemplazar);
					parar=true;
				}
				contador++;
				actual=actual.getNext();
			}
		}	

		listSize++;
	}

	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
		T rta= listFirst.getItem();
		Node<T> node =listFirst.getNext();
		listFirst = node;
		listSize--;
		return rta;
	}

	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		T rta = null;
		Node<T> actual = listFirst;

		if(listSize == 1)
		{
			rta = listFirst.getItem();
			listFirst = null;
			listSize--;
		}
		else
		{
			for (int i =2;i<listSize;i++)
			{
				actual = actual.getNext();
			}

			rta=actual.getNext().getItem();
			actual.setNextNode(null);
			listSize--;
		}
		return rta;
	}


	// Algo no me cuadra aca porque no se si actual avanza
	@Override
	public T deleteElement(int pos) 
	{
		T rta = null;
		Node<T> actual = listFirst;

		for(int i=0;i < listSize ;i++)
		{
			if (listSize == pos)
			{
				rta = actual.getItem();
				actual.getAnterior().setNextNode(actual.getNext());
				listSize --;
			}
		}
		return rta;
	}

	@Override
	public T firtsElement() {

		return listFirst.getItem();
	}

	@Override
	public T lastElement() throws Exception 
	{
		T rta = null;
		if (listFirst != null)
		{
			for(int i=0;i < listSize ;i++)
			{
				if(listFirst.getNext()== null)
				{
					rta = listFirst.getItem();
				}
			}
		}

		return rta;
	}


	@Override
	public T getElement(int pos) {

		T rta = null;
		if (listFirst != null)
		{
			for(int i=0;i < listSize ;i++)
			{
				if (listSize == pos)
				{
					rta = listFirst.getItem();
				}
			}
		}
		return rta;
	}

	@Override
	public int size() {
		return listSize;
	}

	@Override
	public boolean isEmpty() {

		boolean rta = false;
		if(listFirst != null)
		{
			rta = true;
		}
		return rta;
	}

	@Override
	public int isPresent(T elemento) 
	{
		int rta = 0;
		if(listFirst != null)
		{
			for(int i=0;i < listSize ;i++)
			{
				if(listFirst.getItem().equals(elemento))
				{
					rta = listSize;
				}
		}

		}
		return rta;
	}

	@Override
	public void exchange(int n, int m) 
	{
		Node<T> actual = listFirst;
		
		if (actual != null)
		{
			for (int i =0; i <listSize; i++)
			{
				if (listSize == n)
				{
					n = m;
				}
				else if (listSize +1 == n)
				{
					m = n;
				}
					
			}
		}

	}

	@Override
	public void changeInfo(int n, T elemento) 
	{
		Node<T> actual = listFirst;

		if (actual != null)
		{
			for (int i =0; i <listSize; i++)
			{
				if(listSize == n )
				{
					actual.setItem(elemento);
				}
			}
		}
	}
	
	
	public ILista subLista (int size)
	{
		Node firstSubList = listFirst;
		Lista subLista = new Lista((T) firstSubList);
		
		for(int i=0; i<size; i++)
		{
			
			subLista.addFirst((T) firstSubList.getNext());
		}
		
		return subLista;
	}
	
	
}
