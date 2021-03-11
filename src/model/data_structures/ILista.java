/**
 * 
 */
package model.data_structures;

/**
 * @author Beba
 *
 */
public interface ILista  <T extends Comparable <T>> {

	/**
	 * Agrega un elemento al inicio de la lista.
	 * @param elemento a agregar.
	 */
	void addFirst(T element);
	
	/**
	 * Agrega un elemento al final de la lista.
	 * @param elemento a agregar.
	 */
	void addLast(T element);
	
	/**
	 * Agrega un elemento en la posici�n pos si la posici�n es una posici�n v�lida.
	 * @param elemento a agregar.
	 * @param posici�n donde se agrega.
	 * @throws Exception 
	 */
	void insertElement(T element, int pos) throws Exception;
	
	/**
	 * Elimina el primer elemento. 
	 * @return El elemento eliminado.
	 */
	T removeFirst();
	
	/**
	 * Elimina el �ltimo elemento. 
	 * @return El elemento eliminado.
	 */
	T removeLast();
	
	/**
	 * Elimina el elemento de una posici�n v�lida.
	 * @param posici�n del elemento que se va a eliminar.
	 * @return el elemento eliminado.
	 */
	T deleteElement(int pos);
	
	/**
	 * Retorna el primer elemento.
	 * @return primer elemento.
	 */
	T firtsElement();
	
	/**
	 * Retorna el �ltimo elemento.
	 * @return �ltimo elemento.
	 */
	T lastElement() throws Exception;
	
	/**
	 * Retorna el elemento en una posici�n v�lida.
	 * @param posici�n del elemento
	 * @return elemento en la posici�n dada.
	 */
	T getElement(int pos);

	/**
	 * Retorna el n�mero de datos del arreglo
	 * @return N�mero de datos del arreglo
	 */
	int size();
	
	/**
	 * Retorna si la lista esta o no vac�a
	 * @return true si el arreglo No tiene datos. false de lo contrario.
	 */
	boolean isEmpty();
	
	/**
	 * Retorna la posici�n v�lida de un elemento.
	 * @param elemento que se busca.
	 * @return la posici�n v�lida del elemento. Si no se encuentra el elemento, el valor retornado es -1
	 */
	int isPresent(T elemento);
	
	/**
	 * Intercambia la informaci�n de los elementos en dos posiciones v�lidas.
	 * @param primer posici�n.
	 * @param segunda posici�n.
	 * 
	 */
	void exchange(int i, int j);
	
	/**
	 * Actualiza el elemento en una posici�n v�lida.
	 * @param posici�n del elemento.
	 * @param elemento que va a reemplazar.
	 */
	void changeInfo(int i, T elemento);
	
	/**
	 * Crear una sublista de la lista original (this).
	 * Los elementos se toman en el mismo orden como aparecen en la lista original (this).
	 * @param número de elementos que contendrá la sublista. Si el número es superior al tamaño
	 * original de la lista, se obtiene una copia de la lista original.
	* @return sublista creada con la misma representación de la lista original (this).
	 */ 
	public ILista subLista (int numeroElementos);
}
