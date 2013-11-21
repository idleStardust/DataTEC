package listas;

public interface ICollection < T >
{
	void add(T pElement);
	
	void remove(T pElement);
	
	void search(T pElement);
	
	void isEmpty();
	
	void print();
}
