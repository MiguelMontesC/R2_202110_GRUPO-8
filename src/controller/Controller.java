package controller;

import java.text.ParseException;
import java.util.Scanner;

import model.data_structures.ArregloDinamico;
import model.logic.Modelo;
import model.logic.YoutubeVideo;
import model.utils.Ordenamiento;
import view.View;

public class Controller 
{
	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;
	
	private Ordenamiento ordenamiento;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	public void run() throws ParseException
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option) {					
			case 1:
				view.printMessage("--------- Cargar YoutubeVideo en Arreglo Dinamico ");
				modelo.cargarDatosArregloDinamico();
				view.printMessage("Se ha cargado con Exito en el Arreglo Dinamico");
				break;
				

			case 2:
				view.printMessage("--------- Escriba el nombre de la categoria elegida ---------");
				String nombreC = lector.next();
				view.printMessage("--------- Escriba el nombre del pais elegido ---------");
				String pais = lector.next();
				ArregloDinamico <YoutubeVideo> arre = modelo.requerimiento1(nombreC, pais);
				view.printMessage("--------- Escriba el numero de videos que quiere ver en Arreglo Dinamico ---------");
				int num = lector.nextInt();
				ArregloDinamico <YoutubeVideo> sublista = (ArregloDinamico<YoutubeVideo>) modelo.cargar_NUMERO_DatosEnArregloDinamico(num,arre);
				ordenamiento.ordenarSeleccion(sublista, new YoutubeVideo.ComparadorXViews(), true);
				view.printMessage("");
				view.printMessage("Se ha completado con exito el proceso estos son los resultados");
				view.printMessage("");
				for (int i =0; i < sublista.size(); i ++)
				{
					YoutubeVideo video = sublista.firtsElement();
					System.out.println("Titulo del Video" + video.getTitulo() + "Fecha Trending" + video.getTrendingDate() + "Titulo Canal" + video.getTituloCanal() + "Fecha de Publicacion" + video.getPublishingTime() + "Numero de Views" + video.getNumeroViews() + "Numero de Likes" + video.getNumeroLikes()  + "Numero de Dislikes" + video.getNumeroDislikes());
				}
				
			case 3: 
				
				view.printMessage("--------- Escriba el nombre del pais elegido ---------");
				String Pais = lector.next();
				ArregloDinamico <YoutubeVideo> arreglo = modelo.requerimiento2(Pais);
				
				YoutubeVideo video = null;
				for (int i =0; i < arreglo.size(); i ++)
				{
					// video = arreglo.firtsElement().getTrendingDate().getTime()<;
				}
				
				
				view.printMessage("");
				view.printMessage("Se ha completado con exito el proceso estos son los resultados");
				view.printMessage("");
				
				System.out.println("Titulo del Video" + video.getTitulo() + "Fecha Trending" + video.getTrendingDate() + "Titulo Canal" + video.getTituloCanal() + "Fecha de Publicacion" + video.getPublishingTime() + "Numero de Views" + video.getNumeroViews() + "Numero de Likes" + video.getNumeroLikes()  + "Numero de Dislikes" + video.getNumeroDislikes());


			case 4:
				
				
			break;
				
			case 5:
				view.printMessage("--------- Escriba el nombre de la categoria elegida ---------");
				String PAIS = lector.next();
				view.printMessage("--------- Escriba el tag elegido ---------");
				String TAG = lector.next();
				ArregloDinamico <YoutubeVideo> arreg = modelo.requerimiento4(PAIS, TAG);
			
				view.printMessage("--------- Escriba el numero de videos que quiere ver en Arreglo Dinamico ---------");
				int numer = lector.nextInt();
				ArregloDinamico <YoutubeVideo> sublistaaa = (ArregloDinamico<YoutubeVideo>) modelo.cargar_NUMERO_DatosEnArregloDinamico(numer,arreg);
				
				ordenamiento.ordenarSeleccion(sublistaaa, new YoutubeVideo.ComparadorXLikes(), true);
				view.printMessage("");
				view.printMessage("Se ha completado con exito el proceso estos son los resultados");
				view.printMessage("");
				for (int i =0; i < sublistaaa.size(); i ++)
				{
					YoutubeVideo videocuarto = sublistaaa.firtsElement();
					System.out.println("Titulo del Video" + videocuarto.getTitulo() + "Fecha Trending" + videocuarto.getTrendingDate() + "Titulo Canal" + videocuarto.getTituloCanal() + "Fecha de Publicacion" + videocuarto.getPublishingTime() + "Numero de Views" + videocuarto.getNumeroViews() + "Numero de Likes" + videocuarto.getNumeroLikes()  + "Numero de Dislikes" + videocuarto.getNumeroDislikes());
				}
				
			break;
			
			case 6:
				view.printMessage("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break;
			
			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;

			}

		}
	}
}
