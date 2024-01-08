/**
 * @author Lilia
 * @version jdk 11
 */

/**
 * Represent a point in a Cartesian coordinate system
 * There can be many points in a Cartesian coordinate system
 */
public class Point {
	//instance variables
	/**
	 * the x coordinate of the point
	 * the y coordinate of the point
	 */
	private double xCoordinate, yCoordinate;
	/**
	 * the id to keep track of each points unique id
	 */
	private int pointId;
	/**
	 * the instances to keep track of active instances
	 */
	private static int instances = 0;

	/**
	 * This constructor is used to set the x and y
	 * coordinate at a specified point
	 * @param x is the x coordinate of point
	 * @param y is the y coordinate of point
	 */
	public Point(double x, double y) {
		this.xCoordinate = x;
		this.yCoordinate = y;
		instances++;
		this.pointId=instances;
	}
	/**
	   * This constructor is used to set the x and y
	   * coordinates both to 0.0 as there are no parameters
	   */
	public Point() {
		this.xCoordinate = 0.0;
		this.yCoordinate = 0.0;
		instances++;
		this.pointId=instances;
	}
	
	/**
	 * The setX_coordinate method is used to set the x value of point
	 * @param x_coordinate is the x coordinate of point
	 */
	public void setX_coordinate(double xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	/**
	 * The setY_coordinate method is used to set the y value of point
	 * @param y_coordinate is the y coordinate of point
	 */
	public void setY_coordinate(double yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	/**
	 * The setX_Y_coordinate method is used to set the x and y value of point
	 * @param x_coordinate is the x coordinate of point
	 * @param y_coordinate is the y coordinate of point
	 */
	public void setX_Y_coordinate(double xCoordinate, double yCoordinate) {
		//invokes the above two methods
		this.setX_coordinate(xCoordinate);
		this.setY_coordinate(yCoordinate);
	}
	/**
	 * The getY_coordinate method is used to get the y value of point
	 * @return the y coordinate of point
	 */
	public double getY_coordinate() {
		return yCoordinate;
	}
	/**
	 * The getX_coordinate method is used to get the x value of point
	 * @return the x coordinate of point
	 */
	public double getX_coordinate() {
		return xCoordinate;
	}
	/**
	 * The move method is used to move the points
	 * according to delta x and delta y
	 * @param delta_x is the x delta used to move point
	 * @param delta_y is the y delta used to move point
	 */
	public void move(double delta_x, double delta_y) {
		setX_Y_coordinate(xCoordinate + delta_x, yCoordinate + delta_y);
	}
	
	/**
	 * The distance method is used to calculate the distance between the points and
	 * a point pass in as parameter.
	 * This method is an instance method
	 * @param secondPoint is a reference to an object with x and y coordinate
	 * @return distance a double of the calculated distance
	 */
	public double distance(Point secondPoint) {
		/**the x coordinate of first point
		 */
		double x1= xCoordinate;
		/**the y coordinate of first point
		 */
		double y1= yCoordinate;
		/**the x coordinate of second point
		 */
		double x2= secondPoint.getX_coordinate();
		/**the y coordinate of second point
		 */
		double y2= secondPoint.getY_coordinate();
		/**the distance between the two points
		 */
		double distance = Math.sqrt((y1 - y2) * (y1 - y2) +(x1 - x2) * (x1 - x2));
		return distance;
	}
	
	
	
	/**
	 * the pointId method is used to return the id of points
	 */
	public int pointID() {
		return pointId;	
	}
	
	/**
	 * The numberInstances method is used to return the number
	 * of instances that are active
	 */
	public static int numberInstances() {
		return instances;
	}
	/**
	 * The finalize method is called by the garbage collector on an object when 
	 * garbage collection determines that there are no more references to 
	 * the object
	 * @throws Throwable
	 */
	@Override
	protected void finalize() throws Throwable{ 
		super.finalize();
		instances--;
	}
	
	/**
	 * The distance method is used to calculate the distance between two
	 * points passed as parameters. Is a class method.
	 * @param firstPoint is a reference to an object with x and y coordinate
	 * @param secondPoint is a reference to an object with x and y coordinate
	 * @return distance a double of the calculated distance
	 */
	public static double distance(Point firstPoint, Point secondPoint) {
		return firstPoint.distance(secondPoint);
		
	} 
	
	
}//end class
