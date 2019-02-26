/**
 * Lab 6
 *
 * Class representing a Rectangle.
 * 
 * @author Lynden
 * @version 2019-02-24
 */
public class Rectangle extends Polygon
{
	/**
	 * Length of one set of parallel sides of the rectangle
	 */
	private double height;
	
	/**
	 * Length of the other set of parallel sides of the rectangle
	 */
	private double width;
	
	/**
	 * Constructor for the rectangle. Sets height and width member variables and sets
	 * all side lengths in Polygon sideLengths array.
	 * 
	 * @param height The length of one set of parallel sides of the Rectangle
	 * @param width The length of the other set of parallel sides of the Rectangle
	 */
	public Rectangle(String id, double height, double width)
	{
		super(id);
		this.height = height;
		this.width = width;
		
		sideLengths.add(height);
		sideLengths.add(height);
		sideLengths.add(width);
		sideLengths.add(width);
	}
	
	/**
	 * Gets the area of the Rectangle
	 * 
	 * @return the area of the triangle (height * width)
	 */
	@Override
	public double getArea()
	{
		return height * width;
	}
	
	/**
	 * Gets the shape type of the rectangle.
	 *
	 * @return The string "Rectangle"
	 */
	@Override
	public String getShapeType()
	{
		return "Rectangle";
	}
	

}
