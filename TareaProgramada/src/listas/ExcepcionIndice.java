package listas;

@SuppressWarnings("serial")
public class ExcepcionIndice extends Exception
{
	public ExcepcionIndice(int x)
	{
		super("Indice fuera del Rango: Indice " + x + " No valido" );
	}
}
