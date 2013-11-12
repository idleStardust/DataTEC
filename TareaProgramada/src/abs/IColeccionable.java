package abs;

public interface IColeccionable 
{
	
	void setDato(IComparable pDato);
	
	IComparable getDato();
	
	void setHijo(IColeccionable pNodo);
	
	
}
