/**
 * Lab 6
 *
 * Class representing a Square.
 * 
 * @author Lynden
 * @version 2019-02-26
 */
public class Square extends Rectangle
{
	
	/**
	 * Constructor for the square. A square is a specific type of rectangle for which the
	 * height and width is equal.
	 *
	 * The square should pass information to the rectangle's super constructor.
	 * 
	 * @param size The length of the side of the square, which is the same for all four sides
	 */
	public Square(String id, double size)
	{
		super(id, size, size);
	}
	
	/**
	 * Gets the shape type of the square.
	 *
	 * @return The string "Square"
	 */
	@Override
	public String getShapeType()
	{
		return "Square";
	}
	
}
