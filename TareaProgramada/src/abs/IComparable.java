package abs;

public interface IComparable 
{	
	public boolean menor(IComparable pComparable);
	
	public boolean mayor(IComparable pComparable);
	
	public boolean igual(IComparable pComparable);
	
	public boolean diferente(IComparable pComparable);
	
	public void print();
}
