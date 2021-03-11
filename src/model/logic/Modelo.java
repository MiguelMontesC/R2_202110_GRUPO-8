package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import model.data_structures.ArregloDinamico;
import model.data_structures.ILista;
import model.data_structures.Lista;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private ArregloDinamico<YoutubeVideo> datos;

	private ArregloDinamico<CategoriaVideo> Arreglocateg;
	private YoutubeVideo youtube;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo() {
		datos = new ArregloDinamico<YoutubeVideo>(100000000);
		Arreglocateg = new ArregloDinamico<CategoriaVideo>(1000);
	}

	public void cargarDatosArregloDinamico() throws ParseException 
	{
		FileReader arhcCVS=null;
		FileReader arhcCVS2=null;
		CSVReader csvReader=null;
		CSVReader csvReader2 =null;

		try
		{
			//lectura de categoria
			arhcCVS2= new FileReader("data/category-id.csv");
			com.opencsv.CSVParser conPuntoYComa2 = new CSVParserBuilder().withSeparator('\t').build();
			csvReader2 = new CSVReaderBuilder(arhcCVS2).withCSVParser(conPuntoYComa2).build();


			String[] palabra2 = csvReader2.readNext();
			palabra2= csvReader2.readNext();

			while (palabra2 != null)
			{
				// crear la categoria objeto
				int codigoVideo = Integer.parseInt(palabra2[0]);
				String nameCodigo = palabra2[1];
				nameCodigo = nameCodigo.trim();

				CategoriaVideo catego = new CategoriaVideo(codigoVideo, nameCodigo);				
				Arreglocateg.addLast(catego);
				palabra2 = csvReader2.readNext();
			}
			csvReader2.close();

			// lectura de videos
			arhcCVS= new FileReader("data/videos-small.csv");
			com.opencsv.CSVParser conPuntoYComa = new CSVParserBuilder().withSeparator(',').build();
			csvReader =new CSVReaderBuilder(arhcCVS).withCSVParser(conPuntoYComa).build();


			String[] palabra=csvReader.readNext();
			palabra =csvReader.readNext();

			while (palabra !=null )
			{	
				try {

					String id= palabra[0];

					SimpleDateFormat aaa = new SimpleDateFormat("dd.MM.yyyy");
					SimpleDateFormat bbb = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

					Date trendingDate = aaa.parse(palabra[1]);		
					String titulo = palabra[2];
					String tituloCanal = palabra[3];
					int catego = Integer.parseInt(palabra[4]);
					Date publishingTime = bbb.parse(palabra[5]);

					ArregloDinamico <String> ttt = new ArregloDinamico<String>(1000);
					String array = palabra[6];
					String [] dividir = array.split("|");
					for (int i =0; i < dividir.length; i++)
					{
						String meter = dividir [i];
						ttt.addFirst(meter);
					}

					int numeroV = Integer.parseInt(palabra[7]);
					int numeroL = Integer.parseInt(palabra[8]);

					int numeroD = Integer.parseInt(palabra[9]);
					String diez = palabra[16];
					String once = "";

					for (int i = 0; i < Arreglocateg.size(); i++)
					{
						CategoriaVideo cat = Arreglocateg.firtsElement();
						once = cat.darNombreCateg(catego);
					}
					youtube = new YoutubeVideo (id,trendingDate,  titulo, tituloCanal,catego,publishingTime , ttt, numeroV, numeroL, numeroD, diez, once);
					datos.addLast(youtube);
					//System.out.println(datos.size());
				}
				catch (Exception e)
				{
					// error pasando de csv a youtube
					System.out.println("Error leyendo video");
				}
				try
				{
					palabra =csvReader.readNext();

				}
				catch (Exception e)
				{
					palabra =csvReader.readNext();
					// no lee la linea y sigue 
					System.out.println("Lee siguiente video");
				}
			}
			csvReader.close();
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (CsvValidationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("El tamaño de el arreglo es" + datos.size());
	}

	public ArregloDinamico<YoutubeVideo> cargar_NUMERO_DatosEnArregloDinamico(int num, ArregloDinamico <YoutubeVideo> lista) 
	{
		if (num > lista.size())
			num = lista.size();
		{
			return (ArregloDinamico<YoutubeVideo>) lista.subLista(num);
		}
	}

	public ArregloDinamico <YoutubeVideo> requerimiento1(String nombreC ,String pais )
	{
		ArregloDinamico <YoutubeVideo> arreglo1 = new ArregloDinamico<YoutubeVideo> (100000);
		for (int i = 0; i < datos.size(); i++)
		{
			YoutubeVideo yyyvvv = datos.firtsElement();
			if (yyyvvv.getNombreCategoria() == nombreC && yyyvvv.getPais() == pais)
			{
				datos.agregar(yyyvvv);;
			}
		}
		return arreglo1;
	}

	public ArregloDinamico <YoutubeVideo> requerimiento2(String Pais)
	{
		ArregloDinamico <YoutubeVideo> arreglo2 = new ArregloDinamico<YoutubeVideo> (100000);
		for (int i = 0; i < datos.size(); i++)
		{
			YoutubeVideo yyyvvv = datos.darElemento(i);
			if (yyyvvv.getPais().equals(Pais))
			{
				arreglo2.agregar(yyyvvv);;
			}
		}
		return arreglo2;

	}

	public ArregloDinamico <YoutubeVideo> requerimiento3( String catNombre)
	{
		ArregloDinamico <YoutubeVideo> arreglo3 = new ArregloDinamico<YoutubeVideo> (100000);
		for (int i = 0; i < datos.size(); i++)
		{
			YoutubeVideo yyyvvv = datos.darElemento(i);
			if (yyyvvv.getNombreCategoria().equals(catNombre))
			{
				arreglo3.agregar(yyyvvv);;
			}
		}
		return arreglo3;

	}

	public ArregloDinamico <YoutubeVideo> requerimiento4(String Pais, String tag)
	{
		ArregloDinamico <YoutubeVideo> arreglo4 = new ArregloDinamico<YoutubeVideo> (100000);
		for (int i = 0; i < datos.size(); i++)
		{
			YoutubeVideo yyyvvv = datos.darElemento(i);
			ArregloDinamico <String> tags = yyyvvv.getTags();
			for (int j= 0; j < tags.size(); j++)
			{
				String tagA = tags.darElemento(j);

				if (yyyvvv.getPais() == Pais && tagA == tag)
				{
					arreglo4.agregar(yyyvvv);;
				}
			}
		}
		return arreglo4;
	}

	public YoutubeVideo darMasTendencia(ArregloDinamico<YoutubeVideo> arreglo)
	{
		int mayor = 0;
		int cont = 0;
		YoutubeVideo res = arreglo.firtsElement();
		for (int i = 0; i < arreglo.size(); i++)
		{
			for (int j = i+1; j < arreglo.size(); j++)
			{
				res = arreglo.darElemento(i);
				if(res.getTitulo().equals(arreglo.darElemento(j).getTitulo()))
				{
					cont ++;
				}
				if(cont > mayor)
				{
					mayor = cont;
					res = arreglo.darElemento(i);
				}
			}
		}
			return res;
		}

	}
