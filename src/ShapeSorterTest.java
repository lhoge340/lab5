import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for ShapeSorter.
 * Implicitly tests that the comparators are implemented correctly.
 *
 * @author Lynden
 * @version 2019-02-24
 */
public class ShapeSorterTest
{
	/**
	 * Test that shapes are added correctly.
	 */
	@Test
	public void AddShapeTest()
	{
		ShapeSorter sorter = new ShapeSorter();

		Shape a = new Rectangle("test", 3, 3);
		Shape b = new EquilateralTriangle("test2", 4);
		Shape c = new Square("test3", 3);
		Shape d = new Circle("test4", 1.5);

		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);

		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), a);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), b);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), c);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), d);
	}

	/**
	 * Tests sorting via the default ordering.
	 */
	@Test
	public void SortShapesDefaultTest()
	{
		ShapeSorter sorter = new ShapeSorter();
		
		Shape a = new Rectangle("test", 8, 2);  //a = 16, p = 20
		Shape b = new EquilateralTriangle("test2", 4); //6.928
		Shape c = new Square("test3", 4); //a = 16, p = 16
		Shape d = new Circle("test4", 1.5); //7.06

		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);
		
		sorter.sortShapes();
		
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), b);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), d);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), c); 
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), a);

	}

	/**
	 * Tests sorting by area ordering.
	 */
	@Test
	public void SortShapesAreaTest()
	{
		ShapeSorter sorter = new ShapeSorter();
		
		Shape a = new Rectangle("test", 3, 3);  //a = 9
		Shape b = new EquilateralTriangle("test2", 4); //6.928
		Shape c = new Square("test3", 4); //16
		Shape d = new Circle("test4", 1.5); //7.06

		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);
		
		sorter.sortShapes(new ShapeAreaComparator());
		
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), b);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), d);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), a); 
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), c);

	}

	/**
	 * Tests sorting by perimeter ordering.
	 */
	@Test
	public void SortShapesPerimeterTest()
	{
		ShapeSorter sorter = new ShapeSorter();
		
		Shape a = new Rectangle("test", 3, 3);  //12
		Shape b = new EquilateralTriangle("test2", 4); //12
		Shape c = new Square("test3", 4); //16
		Shape d = new Circle("test4", 1.5); //9.2

		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);
		
		sorter.sortShapes(new ShapePerimeterComparator());
		
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), d);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), a);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), b); 
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), c);
	}

	/**
	 * Tests the toString.
	 */
	@Test
	public void ToStringTest()
	{
		ShapeSorter sorter = new ShapeSorter();
		
		Shape a = new Rectangle("test", 3, 3); 
		Shape c = new Square("test3", 4);
		
		sorter.addShape(a);
		sorter.addShape(c);
		
		String expected = "Rectangle:	 ID = test	 area = 9.000	 perimeter = 12.000Square:	 ID"
				+ " = test3	 area = 16.000	 perimeter = 16.000";
		String actual = sorter.toString();
		
		Assert.assertEquals(expected, actual);
	}
}
