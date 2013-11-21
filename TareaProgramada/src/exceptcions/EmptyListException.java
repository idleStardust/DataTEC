package exceptcions;

@SuppressWarnings("serial")
public class EmptyListException extends RuntimeException
{
	public EmptyListException()
	{
		this( "List" );
	}
	
	public EmptyListException( String name )
	{
		super( name + " is empty" ); // call superclass constructor
	}
}
