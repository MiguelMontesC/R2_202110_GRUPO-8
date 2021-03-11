package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico <T extends Comparable <T>>  implements ILista <T>, Comparable <ArregloDinamico <T>>
{
		/**
		 * Capacidad maxima del arreglo
		 */
        private int tamanoMax;
		/**
		 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
		 */
        private int tamanoAct;
        /**
         * Arreglo de elementos de tamaNo maximo
         */
        private T elementos[ ];

        /**
         * Construir un arreglo con la capacidad maxima inicial.
         * @param max Capacidad maxima inicial
         */
		public ArregloDinamico( int max )
        {
               elementos = (T[]) new Comparable [max];
               tamanoMax = max;
               tamanoAct = 0;
        }
        
		public void agregar( T dato )
        {
               if ( tamanoAct == tamanoMax )
               {  // caso de arreglo lleno (aumentar tamaNo)
                    tamanoMax = 2 * tamanoMax;
                    T [ ] copia = (T[]) elementos;
                    elementos = (T[]) new Comparable [tamanoMax];
                    for ( int i = 0; i < tamanoAct; i++)
                    {
                     	 elementos[i] = (T) copia[i];
                    } 
            	    System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
               }	
               elementos[tamanoAct] = dato;
               tamanoAct++;
       }

		public int darCapacidad() {
			return tamanoMax;
		}

		public int darTamano() {
			return tamanoAct;
		}

		public T darElemento(int i) {
			// TODO implementar
			T element = null;
			if (i>0 && i< tamanoAct)
			{
				element = (T) elementos[i];
			}
			
			return element;
		}


		public T buscar(T dato) 
		{
			// TODO implementar
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			
			T rta = null;
			boolean stop=false;
			
            for ( int i = 0; i < tamanoAct && stop==false; i++)
            {
            	T objeto= (T) elementos[i];
            	
             	 if (  dato.compareTo(objeto)==0)
             	 {
             		rta = objeto;
             		stop = true;
             	 }
            } 
			return rta;
		}
		
		
		public T eliminar(T dato)
		{
			// TODO implementar
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			T rta=null;
			boolean stop=false;
            for ( int i = 0; i < tamanoAct && stop==false; i++)
            {
            	T objeto= (T) elementos[i];
             	 if (  dato.compareTo(objeto)==0)
             	 {
             		rta=objeto;
             		
             		for (int j=i;j< tamanoAct;j++)
             		{
             			if (j!=tamanoAct-1)
             				{
             				elementos[j]=elementos[j+1];
             				}
             			else
             			{
             				elementos[j]=null;
             			}
             		}
             		
             		stop=true;
             		tamanoAct=tamanoAct-1;
             	 }
            } 
			return rta;
		}
		
		
		public T[] invertir() {
			// TODO Auto-generated method stub
			T[]  copia = (T[]) new Comparable [tamanoAct] ;

			for(int i=0; i<tamanoAct; i++)
			{
				for (int j=tamanoAct; j>-1; j--)
				{
					copia[i]= elementos[j];
				}
				
			}
			return copia;
		}

		
		
		@Override
		public int compareTo(ArregloDinamico<T> o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		
		public void expandArray() 
		{
			T[] expanded = (T[]) new Object[5+tamanoAct]; ;
			for (int i = 0; i < elementos.length; i++)
			{
			expanded[i] = (T) elementos[i];
			}
			tamanoMax=5+tamanoAct;
			elementos = null;
			elementos = expanded;
			}
		
		public void addFirst(T dato)
		{
			if(elementos[0] == null)
			{
				elementos[0]= dato;
			}
			else
			{
				if ( tamanoMax == tamanoAct )
				{
				expandArray();
				}
				for(int i=tamanoAct; i>0;i--)
				{
					elementos[i]= elementos[i-1];
				}
				elementos[0]=dato;
			}
			 tamanoAct++;
		}
		
		public void addLast(T dato)
		{
			   if ( tamanoAct == tamanoMax )
	           {  // caso de arreglo lleno (aumentar tamaNo)
	                tamanoMax = 2 * tamanoMax;
	                Object [ ] copia = elementos;
	                elementos = (T[]) new Object [tamanoMax]; 
	                for ( int i = 0; i < tamanoAct; i++)
	                {
	                 	 elementos[i] = (T) copia[i];
	                } 
	        	    System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
	           }	
	           elementos[tamanoAct] = dato;
	           tamanoAct++;
		}

		public void insertElement(T dato, int pos) throws Exception 
		{
			if (pos < 1 || pos > tamanoAct)
			{
				throw new Exception("no se puede eliminar el objeto de la posicion"+pos);
			}
			
			if ( tamanoMax == tamanoAct )
			{
			expandArray();
			}
			
	        for ( int i = tamanoAct; i > pos-1; i--)
	        {
	        	
	         			
	         	elementos[i]=elementos[i-1];
	         			
	         }
	         		
	         elementos[pos]=dato;
	         		
	         tamanoAct++;
	         	 
	         
			
		}
		
		public T removeFirst() {
			
			T primero = (T) elementos[0];
			for(int i = 0; i < tamanoAct ; i++)
			{
				if (i!=tamanoAct-1)
					{
					elementos[i]=elementos[i+1];
					}
				else
				{
					elementos[i]=null;
				}
			}
			tamanoAct=tamanoAct-1;
			return primero;
		}
		
		public T removeLast()
		{
			T ultimo = (T) elementos[tamanoAct-1];
			elementos[tamanoAct-1] = null; 
			tamanoAct--;
			return ultimo;
		}
		
		public T deleteElement(int pos)
		{
			T eliminado = (T) elementos[pos-1]; 
			for(int i = pos-1  ; i <tamanoAct ; i++)
			{
				if (i!=tamanoAct-1)
					{
					elementos[i]=elementos[i+1];
					}
				else
				{
					elementos[i]=null;
				}
					
					
				
			}
			tamanoAct=tamanoAct-1;
			return eliminado;
		}
		
		public T firtsElement()
		{
			return (T) elementos[0];
		}
		
		public T lastElement()
		{
			return (T) elementos[tamanoAct - 1];
		}
		
		public T getElement(int pos)
		{
			return (T) elementos[pos];
		}

		public int size()
		{
			return tamanoAct;
		}
	
		public boolean isEmpty()
		{
			if(tamanoAct == 0)
			{
				return true;
			}
			return false;
		}
		
		
		public int isPresent(T elemento)
		{
			int rta = -1;
			for(int i = 0; i < tamanoAct && rta == -1; i++)
			{
				T comparar = (T) elementos[i];
				if(elemento.compareTo(comparar) == 0)
				{
					rta = i+1;
				}
			}
			return rta; 
		}
		
		public void exchange(int i, int j)
		{
			T copia = (T) elementos[i];
			elementos[i] = elementos[j];
			elementos[j] = copia; 
		}
		
		public void changeInfo(int i, T elemento)
		{
			elementos[i-1] = elemento; 			
		}

		@Override
		public ILista subLista(int size) 
		{
			ArregloDinamico <T> subLista = new ArregloDinamico<T>(size);

			for(int i=0, j=0; j<size; i++, j++)
			{
				subLista.addFirst( elementos [i]);
			}
			return subLista;
		}

}
