/**
 * @author Lilia
 * @version jdk 17

 */
import java.util.Scanner;

/**
 * Is used to test the Point class
 */
public class Test {

	/**
	 * The entry point for creating and executing client code
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		//variables and methods
		Scanner keyboard = new Scanner(System.in);
		/**
		 * the x coordinate inputed by user
		 */
		double x;
		/**
		 * the y coordinate inputed by user
		 */
		double y;
		/**
		 * the delta x inputed by user
		 */
		double delta_x;
		/**
		 * the delta y inputed by user
		 */
		double delta_y;
		//Instantiate Point 1
		System.out.println("Enter the x coordinate for point 1");
		x = keyboard.nextDouble();
		System.out.println("Enter the y coordinate for point 1");
		y = keyboard.nextDouble();
		Point point1 = new Point(x,y);
		
		//Instantiate Point 2
		System.out.println("Enter the x coordinate for point 2");
		x = keyboard.nextDouble();
		System.out.println("Enter the y coordinate for point 2");
		y = keyboard.nextDouble();
		Point point2 = new Point(x,y);
		
		//Instantiate Point 3
		System.out.println("Enter the x coordinate for point 3");
		x = keyboard.nextDouble();
		System.out.println("Enter the y coordinate for point 3");
		y = keyboard.nextDouble();
		Point point3 = new Point(x,y);
		
		//Ask user for delta x and delta y values
		System.out.println("Enter the delta x value: ");
		delta_x = keyboard.nextDouble();
		System.out.println("Enter the delta y value: ");
		delta_y = keyboard.nextDouble();
		//shift all three points using move method
		point1.move(delta_x, delta_y);
		point2.move(delta_x, delta_y);
		point3.move(delta_x, delta_y);
		
		//print IDS
		//coordinate values of three points
		//Also number of active instances (use toString())
		System.out.println("Coordinate Information:");
		System.out.printf("%-10s %-10s\n", "ID: " + point1.pointID(),
				"Value: " + "(" + point1.getX_coordinate() +"," + point1.getY_coordinate() + ")");
		System.out.printf("%-10s %-10s\n", "ID: " + point2.pointID(),
				"Value: " + "(" + point2.getX_coordinate() +"," + point2.getY_coordinate() + ")");
		System.out.printf("%-10s %-10s\n", "ID: " + point3.pointID(),
				"Value: " + "(" + point3.getX_coordinate() +"," + point3.getY_coordinate() + ")");
		System.out.println("Number of active instances: " + Point.numberInstances());
		
		/**
		 * Instantiate another point using coordinates 0.0
		 */
		Point point4 = new Point();  
		
		//calculate distance from the new point to the three points above
		//use the instance method for the 1st 2 points
		System.out.println("Distances from the three points and the new point (0.0,0.0): ");
		System.out.printf("%-10s %-10s\n", "Point 1: ",String.format("%.2f",point4.distance(point1)));
		System.out.printf("%-10s %-10s\n", "Point 2: ",String.format("%.2f",point4.distance(point2)));
		//use class method for the third
		System.out.printf("%-10s %-10s\n", "Point 3: ",String.format("%.2f",Point.distance(point3, point4)));
		
		
		/**
		 * the averages of the x coordinate of all points
		 */
		double averageOfX = (point1.getX_coordinate() + point2.getX_coordinate() + point3.getX_coordinate())/3;
		/**
		 * the averages of the y coordinate of all points
		 */
		double averageOfY = (point1.getY_coordinate() + point2.getY_coordinate() + point3.getY_coordinate())/3;
		Point point5 = new Point(averageOfX, averageOfY);
		//print its ID, and values, also number of active instances
		System.out.println("New Point Information:");
		System.out.printf("%-10s %-10s\n", "ID: " + point5.pointID(),
				"Value: " + "(" + String.format("%.2f",point5.getX_coordinate()) +"," +
		String.format("%.2f",point5.getY_coordinate()) + ")");
		System.out.println("Number of active instances: " + Point.numberInstances());
		
		//Delete references to the first three points, and force garbage collection
		point1 = null;
		point2 = null;
		point3 = null;
		System.gc();
		//pause the execution of the current thread for a 1000 millisecond
		Thread.sleep(1000);
		//print number of active instances
		System.out.println("Number of active instances: " + Point.numberInstances());
	}//end main

}//end class
