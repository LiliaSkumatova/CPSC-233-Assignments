/**
 * @author Lilia
 * @version jdk 11
 */

/**
 * abstract class that extends from the object class
 * Contains a point that represents the shape's origin
 */
public abstract class Shape {
	private Point origin;
	//constructor that initializes values to 0
	/**
	  * This constructor is used to create a
	  * new point object
	  */
	public Shape() {
		this.origin = new Point();
	}
	/**
	 * This constructor is used to create a point object
	 * with parameters for the x and y coordinates
	 * @param xCoordinate is the x coordinate of point
	 * @param yCoordinate is the y coordinate of point
	 */
	public Shape(double xCoordinate, double yCoordinate) {
		this.origin = new Point(xCoordinate,yCoordinate);
	}
	
	/**
	 * The getOrigin method is used to get the origin of shape
	 */
	public Point getOrigin() {
		return this.origin;
	}
	/**
	 * The setOrigin method is used to set the x and y 
	 * of the origin
	 * @param x is the x coordinate of origin
	 * @param y is the y coordinate of origin
	 */
	public void setOrigin(double x, double y) {
		this.origin.setX_Y_coordinate(x, y);
	}
	/**
	 * The move method is used to move the origin point
	 * according to delta x and delta y
	 * @param deltaX is the x delta used to move origin point
	 * @param deltaY is the y delta used to move origin point
	 */
	public void move(double deltaX, double deltaY) {
		this.origin.move(deltaX, deltaY);
	}
	/**
	 * The distance method is used to calculate the distance between
	 * two different shapes
	 * @param shape2 is an object passed
	 */
	public double distance (Shape shape2) {
		//the distance between the two shapes is calculated
		double distanceX = this.origin.getX_coordinate()-shape2.getOrigin().getX_coordinate();
		double distanceY = this.origin.getY_coordinate()-shape2.getOrigin().getY_coordinate();
		return Math.sqrt((distanceX*distanceY)+(distanceY*distanceX));
	}
	
	
	/**
	 * The area method is an abstract method that is 
	 * Redefined in the subclasses to calculate the 
	 * area of the shape
	 */
	public abstract double area();
	/**
	 * The circumference method is an abstract method that is 
	 * Redefined in the subclasses to calculate the circumference 
	 * of shape
	 */
    public abstract double circumference();
    /**
	 * The toString method is used to return a string 
	 * which shows the current state of the shape
	 * @return string of shapes current state
	 */
    public String toString() {
    	double x = origin.getX_coordinate();
    	double y = origin.getY_coordinate();
    	return "( " + x + "," + y +" )";
    	
    }

}
