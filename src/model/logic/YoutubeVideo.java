package model.logic;

import java.util.Comparator;
import java.util.Date;

import model.data_structures.ArregloDinamico;

/**
 * @author miguelmontes
 *
 */

public class YoutubeVideo implements Comparable<YoutubeVideo> {
	/**
	 * Identificador del video
	 */
	private String id;

	/**
	 * Fecha en el que el video se volvio destacado
	 */
	private Date trendingDate;

	/**
	 * Titulo del video
	 */
	private String titulo;

	/**
	 * Titulo del canal
	 */
	private String tituloCanal;

	/**
	 * Categoria del video
	 */
	private int categoriaId;

	/**
	 * Fecha de publicacion del video
	 */
	private Date publishingTime;

	/**
	 * Arraylist que contiene los tags del video
	 */
	private ArregloDinamico<String> tags;

	/**
	 * Numero de views del video
	 */
	private int numeroViews;

	/**
	 * Numero de likes del video
	 */
	private int numeroLikes;

	/**
	 * Numero de dislikes del video
	 */
	private int numeroDislikes;
	
	/**
	 * Nombre de la categoria del video
	 */
	private String nombreCategoria;
	
	/**
	 * Nombre del pais de procedencia del video
	 */
	private String pais;
	
	
	
	

	public YoutubeVideo(String Identificador, Date fechaTrending, String tit, String titCan, int Catego, Date publi,
			ArregloDinamico<String> ttt, int numeroV, int numeroL, int numeroD, String Pai, String nombreCat) 
	{
		id = Identificador;
		trendingDate = fechaTrending;
		titulo = tit;
		tituloCanal = titCan;
		categoriaId = Catego;
		publishingTime = publi;
		tags = ttt;
		numeroViews = numeroV;
		numeroLikes = numeroL;
		numeroDislikes = numeroD;
		nombreCategoria = nombreCat;
		pais = Pai;
		

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getTrendingDate() {
		return trendingDate;
	}

	public void setTrendingDate(Date trendingDate) {
		this.trendingDate = trendingDate;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTituloCanal() {
		return tituloCanal;
	}

	public void setTituloCanal(String tituloCanal) {
		this.tituloCanal = tituloCanal;
	}

	public int getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(int categoriaId) {
		this.categoriaId = categoriaId;
	}

	public Date getPublishingTime() {
		return publishingTime;
	}

	public void setPublishingTime(Date publishingTime) {
		this.publishingTime = publishingTime;
	}

	public ArregloDinamico <String> getTags() {
		return tags;
	}

	public void setTags(ArregloDinamico<String> tags) {
		this.tags = tags;
	}

	public int getNumeroViews() {
		return numeroViews;
	}

	public void setNumeroViews(int numeroViews) {
		this.numeroViews = numeroViews;
	}

	public int getNumeroLikes() {
		return numeroLikes;
	}

	public void setNumeroLikes(int numeroLikes) {
		this.numeroLikes = numeroLikes;
	}

	public int getNumeroDislikes() {
		return numeroDislikes;
	}

	public void setNumeroDislikes(int numeroDislikes) {
		this.numeroDislikes = numeroDislikes;
	}

	/**
	 * 
	 */

	@Override
	public int compareTo(YoutubeVideo o) 
	{
	 return 0;
	}


	public String getPais() {
		return pais;
	}

	public void setPais (String Pais) {
		this.pais = Pais;
	}


	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCatego) {
		this.nombreCategoria = nombreCatego;
	}


	


	//Comparador alterno de 2 videos por número de likes
	public static class ComparadorXLikes implements Comparator<YoutubeVideo> 
	{

		/** Comparador alterno de acuerdo al número de likes
		 * @return valor 0 si video1 y video2 tiene los mismos likes.
	 valor negativo si video1 tiene menos likes que video2.
	 valor positivo si video1 tiene más likes que video2. */


		@Override
		public int compare(YoutubeVideo o1, YoutubeVideo o2) {
			int i = 0;
			if (o1.getNumeroLikes()>o2.getNumeroLikes())
			{
				i = 1;
			}
			else if (o1.getNumeroLikes() < o2.getNumeroLikes())
			{
				i = -1;
			}

			return i;
		}
	}
	
	//Comparador alterno de 2 videos por número de likes
		public static class ComparadorXViews implements Comparator<YoutubeVideo> 
		{

			/** Comparador alterno de acuerdo al número de likes
			 * @return valor 0 si video1 y video2 tiene los mismos likes.
		 valor negativo si video1 tiene menos likes que video2.
		 valor positivo si video1 tiene más likes que video2. */


			@Override
			public int compare(YoutubeVideo o1, YoutubeVideo o2) {
				int i = 0;
				if (o1.getNumeroViews()>o2.getNumeroViews())
				{
					i = 1;
				}
				else if (o1.getNumeroViews() < o2.getNumeroViews())
				{
					i = -1;
				}

				return i;
			}
		}
}
