package view;

import model.logic.Modelo;

public class View 
{
	 /**
     * Metodo constructor
     */
    public View()
    {
    	
    }
    
	public void printMenu()
	{
		System.out.println("");
		System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Enter: (e.g., 1):");
		System.out.println("");
		System.out.println("1. Cargar Youtube Video en Arreglo Dinamico");
		System.out.println("2. Dar Requerimiento 1");
		System.out.println("3. Dar Requerimiento 2");
		System.out.println("4. Dar Requerimiento 3");
		System.out.println("5. Dar Requerimiento 4");
		System.out.println("6. Salir");



	}

	public void printMessage(String mensaje) {

		System.out.println(mensaje);
	}		
	
	

}
