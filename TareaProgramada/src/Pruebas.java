import types.Integer2;
import listas.ExcepcionIndice;
import listas.ListaDobleCircular;


public class Pruebas 
{
	public static void main(String[] args) throws ExcepcionIndice 
	{
		ListaDobleCircular l = new ListaDobleCircular();
		l.add(new Integer2 (2) );
		l.add(new Integer2 (7) );
		l.add(new Integer2 (2) );
		l.add(new Integer2 (4) );
		l.remove(new Integer2(2));
		l.remove(new Integer2(2));
		l.remove(new Integer2(7));
		l.remove(new Integer2(4));
		l.remove(new Integer2(2));
		l.print();
	}
}
