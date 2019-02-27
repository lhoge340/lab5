import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for shapes and their comparators.
 *
 * @author Lynden
 * @version 2019-02-26
 */
public class ShapeTest
{
	//==================================================================================================================
	// Basic Shape Testing:
	//==================================================================================================================
    /**
     * Tests for the square class.
     */
	@Test
	public void SquareTest()
	{
		Shape sqr = new Square("Square1", 3.0);
		Assert.assertEquals("Square area incorrect.", 9.0, sqr.getArea(), 0.0001);
		Assert.assertEquals("Square perimeter incorrect.", 12.0, sqr.getPerimeter(), 0.0001);
		Assert.assertEquals("Square type incorrect.", "Square", sqr.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Square1", sqr.getId());
	}

	/**
     * Tests for the rectangle class.
     */
	@Test
	public void RectangleTest()
	{
		Shape rct = new Rectangle("Rectangle1", 2.0, 4.0);
		Assert.assertEquals("Rectangle area incorrect.", 8.0, rct.getArea(), 0.0001);
		Assert.assertEquals("Rectangle perimeter incorrect.", 12.0, rct.getPerimeter(), 0.0001);
		Assert.assertEquals("Rectangle type incorrect.", "Rectangle", rct.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Rectangle1", rct.getId());
		
	}

	/**
     * Tests for the EquilateralTriangle class.
     */
	@Test
	public void TriangleTest()
	{
		Shape trng = new EquilateralTriangle("Triangle1", 2.0);
		Assert.assertEquals("Triangle area incorrect.", 1.732, trng.getArea(), 0.0001);
		Assert.assertEquals("Triangle perimeter incorrect", 6.0, trng.getPerimeter(), 0.0001);
		Assert.assertEquals("Triangle type incorrect.", "EquilateralTriangle", trng.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Triangle1", trng.getId());
	}

	/**
     * Tests for the trapezoid class. Also test that IDs are done correctly.
     */
	@Test
	public void TrapezoidTest()
	{
		Shape trpzd1 = new Trapezoid("Trapezoid1", 20.0, 15.0, 30.0, 55.0);
		Assert.assertEquals("Trapezoid area incorrect.", 510.0, trpzd1.getArea(), 0.0001);
		Assert.assertEquals("Trapezoid perimeter incorrect.", 120.0, trpzd1.getPerimeter(), 0.0001);
		Assert.assertEquals("Trapezoid type incorrect.", "Trapezoid", trpzd1.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Trapezoid1", trpzd1.getId());
		
		Shape trpzd2 = new Trapezoid("Trapezoid2", 5.0, 3.0, 4.0, 8.0);
		Assert.assertEquals("Trapezoid area incorrect.", 18.0, trpzd2.getArea(), 0.0001);
		Assert.assertEquals("Trapezoid perimeter incorrect.", 20.0, trpzd2.getPerimeter(), 0.0001);
		Assert.assertEquals("Trapezoid type incorrect.", "Trapezoid", trpzd2.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Trapezoid2", trpzd2.getId());
		
	}

	/**
     * Tests for the ellipse class. Also test that IDs are done correctly.
     */
	@Test
	public void EllipseTest()
	{
		Shape circ = new Ellipse("Ellipse1", 3.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3.0*3.0, circ.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(3, 2) + Math.pow(3, 2)) / 2),
				circ.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circ.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse1", circ.getId());

		Shape circs = new Ellipse("Ellipse2", 5.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3*5, circs.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(5.0, 2) + Math.pow(3.0, 2)) / 2),
				circs.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circs.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse2", circs.getId());
	}

	/**
     * Tests for the circle class. Also test that IDs are done correctly.
     */
	@Test
	public void CircleTest()
	{
		Shape crcl = new Circle("Circle1", 3.0);
		Assert.assertEquals("Circle area incorrect.", Math.PI*3.0*3.0, crcl.getArea(), 0.0001);
		Assert.assertEquals("Circle perimeter incorrect.", 2 * Math.PI * 3.0, crcl.getPerimeter(), 0.0001);
		Assert.assertEquals("Circle type incorrect.", "Circle", crcl.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Circle1", crcl.getId());
		
		Shape crcl2 = new Circle("Circle2", 4.0);
		Assert.assertEquals("Circle area incorrect.", Math.PI*4.0*4.0, crcl2.getArea(), 0.0001);
		Assert.assertEquals("Circle perimeter incorrect.", 2 * Math.PI * 4.0, crcl2.getPerimeter(), 0.0001);
		Assert.assertEquals("Circle type incorrect.", "Circle", crcl2.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Circle2", crcl2.getId());
		
	}

	/**
	 * Tests for Shape's toString().
	 */
	@Test
	public void ShapeToStringTest()
	{
		// TODO: complete this...
		Shape rct = new Rectangle("Rectangle1", 2.0, 4.0);
		String expectedRectangle = "Rectangle:	 ID = Rectangle1	 area = 8.000	 perimeter = 12.000";
		String actualRectangle = rct.toString();
		Assert.assertEquals(expectedRectangle, actualRectangle);
		
		Shape crcl2 = new Circle("Circle2", 4.0);
		String expectedCircle = String.format("Circle:	 ID = Circle2	 area = %.3f	 perimeter = %.3f",
				Math.PI*4.0*4.0, 2*Math.PI*4.0);
		String actualCircle = crcl2.toString();
		Assert.assertEquals(expectedCircle, actualCircle);
		
 
	}

	//==================================================================================================================
	// Comparisons:
	//==================================================================================================================
	/**
     * Tests for the Shape Area Comparator class.
     */
	@Test
	public void CompareAreaTest()
	{
	    // Test equals:
		Shape rect = new Rectangle("R1", 3.0,3.0);
		Shape sqr = new Square("S1", 3.0);
		ShapeAreaComparator sc = new ShapeAreaComparator();
		Assert.assertEquals("ShapeAreaComparator should find shapes equal.", 0, sc.compare(rect, sqr));
		Assert.assertTrue("ShapeAreaComparator should find shapes equal.", sc.equals(rect, sqr));

		// Test equal perimeter, different area:
        Shape rect2 = new Rectangle("R2", 1.0, 9.0);
        Shape sqr2 = new Square("S2", 5.0);
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect2, sqr2));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(rect2, sqr2));

        // Test unequal perimeter and area:
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect, sqr2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(sqr2, rect));
	}

	/**
     * Tests for the Shape Perimter Comparator class.
     */
	@Test
	public void ComparePerimeterTest()
	{
		//Test equals:
		Shape rect = new Rectangle("R1", 4.0, 4.0);
		Shape sqr = new Square("S1", 4.0);
		ShapePerimeterComparator sc = new ShapePerimeterComparator();
		Assert.assertEquals("ShapePerimeterComparator should find shapes equal.", 0, sc.compare(rect, sqr));
		Assert.assertTrue("ShapePerimeterComparator should find shapes equal.", sc.equals(rect, sqr));
		
		//Test equal area, different perimeter
		Shape rect2 = new Rectangle("R2", 8.0, 2.0);
		Shape sqr2 = new Square("S2", 4.0);
		Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", 1, sc.compare(rect2, sqr2));
		Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", -1, sc.compare(sqr2, rect2));
		Assert.assertFalse("ShapePerimeterComparator incorrectly finds shapes equal.", sc.equals(sqr2, rect2));
		
		
		//Test unequal area and perimeter
		Shape rect3 = new Rectangle("R3", 3.0, 2.0);
		Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", -1, sc.compare(rect3, sqr2));
		Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect3));
		Assert.assertFalse("ShapePerimeterComparator incorrectly finds shapes equal.", sc.equals(sqr2, rect3));
		
	}

	/**
	 * Tests the natural ordering of shapes (compareTo in shape)
	 */
	@Test
    public void NaturalCompareTest()
    {
		//Test unequal areas
		Shape rect = new Rectangle("R1", 4.0, 2.0);
		Shape sqr = new Square("S1", 4.0);
		Assert.assertEquals("ShapeNaturalComparator gave incorrect ordering.", -1, rect.compareTo(sqr));
		Assert.assertEquals("ShapeNaturalComparator gave incorrect ordering.", 1, sqr.compareTo(rect));
		
		//Test equal areas but unequal perimeters
		Shape rect2 = new Rectangle("R2", 8.0, 2.0);
		Assert.assertEquals("ShapeNaturalComparator gave incorrect ordering.", 1, rect2.compareTo(sqr));
		Assert.assertEquals("ShapeNaturalComparator gave incorrect ordering.", -1, sqr.compareTo(rect2));
		
		//Tests equal areas and equal perimeters
		Shape rect3 = new Rectangle("R3", 4.0, 4.0);
		Assert.assertEquals("ShapeNaturalComparator should find shapes equal.", 0, rect3.compareTo(sqr));
		Assert.assertEquals("ShapeNaturalComparator should find shapes equal.", 0, sqr.compareTo(rect3));
    }
}
