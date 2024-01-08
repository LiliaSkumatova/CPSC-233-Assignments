/**
 * @author Lilia
 * @version jdk 11
 */

/**
 * concrete class that extends the Shape class. It has values 
 * to represent radius, origin.
 */
class Circle extends Shape {
	private double radius;
	 /**
	  * This constructor is used to new Circle
	  * Shape object with dimensions set to 0.0
	  */
	public Circle() {
        super();
        this.radius = 0;
    }

	/**
	 * This constructor is used to create a new Circle
	 * Shape object with user inputed dimensions 
	 * @param x is the x coordinate of origin point
	 * @param y is the y coordinate of origin point
	 * @param radius is the radius of circle
	 */
    public Circle(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    /**
	 * The setRadius method is used to set the radius of Circle
	 * of the origin
	 * @param radius is the radius of the Circle Shape
	 */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
	 * The getRadius method is used to get the radius of Circle
	 */
    public double getRadius() {
        return radius;
    }
    /**
	 * The area method calculates the area of the Circle
	 * @return a double the area of Circle
	 */
    @Override
    public double area() {
        return Math.PI * radius *radius;
    }
    /**
	 * The circumference method calculates the circumference
	 * of the Circle
	 * @return a double of the circumference
	 */
    @Override
    public double circumference() {
        return 2 * Math.PI * radius;
    }
    /**
	 * The toString method is used to return a string 
	 * which shows the current state of the Circle
	 * @return string of shapes current state
	 */
    @Override
    public String toString() {
    	return super.toString();
    }
	

}
