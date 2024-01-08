/**
 * @author Lilia
 * @version jdk 11
 */

/**
 * concrete class that extends the Shape class. It has values 
 * to represent width, length, origin.
 */
class Rectangle extends Shape {
	    private double width;
	    private double length;
	    
	    /**
		  * This constructor is used to new rectangle
		  * Shape object with dimensions set to 0.0
		  */
	    public Rectangle() {
	    	//creates origin
	    	super();
	    	this.length=0.0;
	    	this.width=0.0;
	    }
	    //constructor with user values
	    /**
		 * This constructor is used to create a new rectangle
		 * Shape object with user inputed dimensions 
		 * @param x is the x coordinate of origin point
		 * @param y is the y coordinate of origin point
		 * @param width is the width of the rectangle
		 * @param length is the length of the rectangle
		 */
	    public Rectangle(double x, double y, double width, double length) {
	    	super(x,y);
	    	this.length=length;
	    	this.width=width;	
	    }
	    /**
		 * The getWidth method is used to get the width of rectangle
		 */
		public double getWidth() {
			return width;
		}
		/**
		 * The setWidth method is used to set the width of rectangle
		 * of the origin
		 * @param width is the width of the rectangle Shape
		 */
		public void setWidth(double width) {
			this.width = width;
		}
		/**
		 * The getLength method is used to get the length of rectangle
		 */
		public double getLength() {
			return length;
		}
		/**
		 * The setLength method is used to set the length of rectangle
		 * of the origin
		 * @param length is the length of the rectangle Shape
		 */
		public void setLength(double length) {
			this.length = length;
		}
		/**
		 * The setBoth method is used to set the length and width of rectangle
		 * of the origin
		 * @param width is the width of the rectangle
		 * @param length is the length of the rectangle Shape
		 */
	   public void setBoth(double width, double length) {
		   //invokes the two methods above
		   this.setLength(length);
		   this.setWidth(width);
	   }
	   
	   /**
		 * The area method calculates the area of the rectangle
		 * @return a double the area of the rectangle
		 */
	   @Override
	   public double area() {
		   return length*width;
	   }
	   
	   /**
		 * The circumference method calculates the circumference
		 * of the rectangle
		 * @return a double of the circumference
		 */
	   @Override
	   public double circumference() {
		   return 2*(length+width);
	   }
	   /**
		 * The toString method is used to return a string 
		 * which shows the current state of the rectangle
		 * @return string of shapes current state
		 */
	   @Override
	    public String toString() {
	        return super.toString();
	    }

}
