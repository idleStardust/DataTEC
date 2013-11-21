package listas;

public interface IAbstractList <T> extends ICollection<T>
{	
	public void addInOrder(T pElemento);
	
	public void addEnd(T pElemento);
	
	public void addStart(T Elemento);
	
	public void add(T pElemento, int pIndice );
}
