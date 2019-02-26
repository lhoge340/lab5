import java.util.ArrayList;

/**
 * Abstract shape class to define a polygon.
 *
 * @author Lynden
 * @version 2019-02-24
 */
public abstract class Polygon extends Shape
{
    /**
     * A list of the lengths of the sides of the polygons.
     */
    protected ArrayList<Double> sideLengths;

    /**
     * Initializes the sideLengths arraylist and sets the Shape's ID.
     *
     * @param id The created shape's name id.
     */
    public Polygon(String id)
    {
        super(id);
        sideLengths = new ArrayList<Double>();
    }

    /**
     * Calculates the perimeter of a polygon. That is, the sum of its side lengths.
     *
     * @return The perimeter of the polygon.
     */
    @Override
	public double getPerimeter()
    {
    	
    	double sideLength = 0;
    	double perimeter = 0;
    	
    	for (int i = 0; i < sideLengths.size(); i++)
    	{
    		sideLength = sideLengths.get(i);
    		perimeter = perimeter + sideLength;
    	}
    	
    	return perimeter;
    }
}
