import java.util.ArrayList;

/**
 * Lab 6
 *
 * Class representing an equilateral Triangle.
 *
 * @author Lynden
 * @version 2019-02-26
 */
public class EquilateralTriangle extends Polygon
{
    /**
     * Length of the sides of the equilateral triangle.
     */
    private double sideLength;

	/**
	 * Constructor for the equilateral triangle. Sets sideLength member variable and sets
	 * all side length in Polygon sidelengths array.
	 *
	 * @param sidelength The length of the triangle sides.
	 */
	public EquilateralTriangle(String id, double sideLength)
	{
		super(id);
		this.sideLength = sideLength;
		
		for (int i = 0; i < 3; i++)
		{
			sideLengths.add(sideLength);
		}
	}

	/**
	 * Gets the area of the triangle.
	 *
	 * @return The area of the triangle (b*h/2 = sidelength*sidelength*root(3)/4)
	 */
	@Override
	public double getArea()
	{
		double area = (sideLength * sideLength) / 2;
		
		return area;
	}

	/**
	 * Gets the shape type of the triangle.
	 *
	 * @return The string "EquilateralTriangle"
	 */
	@Override
	public String getShapeType()
	{
		return "EquilateralTriangle";
	}
}
