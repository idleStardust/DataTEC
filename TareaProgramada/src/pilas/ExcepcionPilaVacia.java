package pilas;

@SuppressWarnings("serial")
public class ExcepcionPilaVacia extends Exception
{
	public ExcepcionPilaVacia() 
	{
		super("Error 404: Pila Vacia");
	}
}
