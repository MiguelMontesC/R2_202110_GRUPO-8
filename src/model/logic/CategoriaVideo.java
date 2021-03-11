package model.logic;

public class CategoriaVideo implements Comparable<CategoriaVideo>
{
	private int CodigoVideo;
	
	private String NombreCodigoVideo;
	
	public CategoriaVideo(int cod, String nombre)
	{
		CodigoVideo = cod;
		NombreCodigoVideo = nombre;
		
	}

	public String getNombreCodigoVideo() {
		return NombreCodigoVideo;
	}

	public void setNombreCodigoVideo(String nombreCodigoVideo) {
		NombreCodigoVideo = nombreCodigoVideo;
	}

	public int getCodigoVideo() {
		return CodigoVideo;
	}

	public void setCodigoVideo(int codigoVideo) {
		CodigoVideo = codigoVideo;
	}

	@Override
	public int compareTo(CategoriaVideo o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String darNombreCateg(int Cod)
	{
		String res = "";
		if (CodigoVideo == Cod)
		{
			res = NombreCodigoVideo;
		}
		return res;
	}
}
