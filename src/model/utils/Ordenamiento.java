package model.utils;

import java.util.Comparator;

import model.data_structures.ILista;

public class Ordenamiento <T extends Comparable <T>> 
{

	public final void ordenarMergeSort(ILista<T> lista, Comparator<T> criterio, boolean ascendente)
		{
			int size = lista.size();
			if(size > 1)
			{
				int mid = size/2;
				
				ILista<T> left = (ILista<T>) lista.subLista(mid);
				ILista<T> right = (ILista<T>) lista.subLista(mid);
				
				ordenarMergeSort(left, criterio, ascendente);
				ordenarMergeSort(right, criterio, ascendente);
				
				
				int i,j,k;
				i=j=k= 1;
				
				int leftelements = left.size();
				int rightelements = right.size();
				
				while(i <= leftelements && j <= rightelements)
				{
					T elemi = left.getElement(i);
					T elemj = right.getElement(j);
				
					
					int factorComparacion = (ascendente?1:-1) * criterio.compare(elemi, elemj);
					
					if(factorComparacion <= 0) 
					{
						lista.changeInfo(k, elemi);
						i++;
					}
					else
					{
						lista.changeInfo(k, elemj);
						j++;
					}
					k++;
				}
				
		
				while(i <= leftelements)
				{
					lista.changeInfo(k, left.getElement(i));
					i++;
					k++;
				}
				
				while(j <= rightelements)
				{
					lista.changeInfo(k, right.getElement(j));
					j++;
					k++;
				}
			}
		}

	
	private final int partition(ILista<T> lista, Comparator<T> criterio, boolean ascendente, int lo, int hi)
		{
			int follower, leader;
			follower = leader = lo;
			while (leader < hi)
			{
				int factorComparacion = (ascendente?1:-1) * criterio.compare(lista.getElement(leader), lista.getElement(hi));
				if(factorComparacion < 0)
				{
					lista.exchange(follower, leader);
					follower ++;
				}
				leader ++;
			}
			lista.exchange(follower, hi);
			return follower;
		}
		
		
		private final void sort(ILista<T> lista, Comparator<T> criterio, boolean ascendente, int lo, int hi)
		{
			if(lo >= hi)
				return;
			int pivot = partition(lista, criterio, ascendente, lo, hi);
			sort(lista, criterio, ascendente, lo, pivot - 1);
			sort(lista, criterio, ascendente, pivot +1, hi);
		}
		
		
		public final void ordenarQuickSort(ILista<T> lista, Comparator<T> criterio, boolean ascendente)
		{
			sort(lista, criterio, ascendente, 1, lista.size());
		}
		
	
	public final void ordenarSeleccion(ILista<T> lista, Comparator<T> criterio, boolean ascendente)
	{
		for (int i = 1; i < lista.size(); i ++)
		{
			int posMayorMenor = i;
			
			for (int j = i+1; j <= lista.size(); j++)
			{
				int factorComparacion = (ascendente?1:-1) *criterio.compare(lista.getElement(j), lista.getElement(posMayorMenor));
				
				if (factorComparacion < 0)
					posMayorMenor = j;
			}
			
			lista.exchange(posMayorMenor, i);
		}
	}
	
	public final void ordenarInsercion(ILista<T> lista, Comparator<T> criterio, boolean ascendente)
	 {
		int n = lista.size();
		
		for (int i = 1+1; i <= n; i++)
		{
			boolean enPosicion = false;
			
			for (int j = i; j > 1 && !enPosicion; j -= 1)
			{
				int factorComparacion = (ascendente?1:-1) *criterio.compare(lista.getElement(j), lista.getElement(j-1));
				
				if (factorComparacion < 0)
					lista.exchange(j, j-1);
				
				else
					enPosicion = true;
			}
		}
	 }

}
