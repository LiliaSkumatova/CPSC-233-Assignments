/**
 * @author Lilia
 * @version jdk 11
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	//variables
	/**
	 * origin of Shape
	 */
	private int newOrigin;
	/**
	 * the radius of Circle
	 * the width of Rectangle
	 * the length of Rectangle
	 */
	private double radius, width, length;
	private Scanner input = new Scanner(System.in);
	/**
	 * objects variable to keep track of number of variables
	 */
	private int objects = 0;
	/**
	 * wrongInput has String saved to re use during wrong input in menu
	 */
	private String wrongInput = "There is no shape at that index";
	/**
	 * arrayList to save the different Shape objects
	 */
	private ArrayList<Shape> shapesList = new ArrayList<>();
 
	/**
	 * gettingInput method contains the main menu
	 * @throws InterruptedException
	 */
	public void gettingInput() throws InterruptedException {
		 
		 boolean quit = false;
		 //while loop used to keep looping until user decides to quit
		 while (!quit) {
				int choice = 0;
				// menu1 method
				choice = menu1();
				//switch case
				switch (choice) 
				{
				case 1:
					//creatingShapes method
					creatingShapes();
					break;
				case 2:
					//setOrigin method
					setOrigin();
					break;
				case 3:
					//setDimensions method
					setDimensions();
					break;
				case 4:
					//displayCurrentState method
					displayCurrentState();
					break;
				case 5:
					//moveObject method
					moveObject();
					break;
				case 6:
					//distanceBetweenObjects
					distanceBetweenObjects();
					break;
				case 7:
					//destroyObject method
					destroyObject();
					break;
				case 8:
					//listCurrentObjects method
					listCurrentObjects();
					break;
				case 9:
					quit = true;
					break;
				default:
					System.out.println("Wrong input try again");
				}//end switch
				
		 }//end while loop
	}
	/**
	 * listCurrentObjects method is used to iterate throug ArrayList and print
	 * the all the Shapes current States
	 */
	private void listCurrentObjects() {
		for(int x = 0; x < shapesList.size(); x++) {
			//printState method
			printState(shapesList.get(x));
		}
	}

	/**
	 * destroyObject method is used to destroy an object from the ArrayList 
	 * @throws InterruptedException
	 */
	private void destroyObject() throws InterruptedException {
		try {
	        //destroy any object
	        System.out.println("There are " + objects + " shapes");
	        //asks what object the user want's to destroy
	        System.out.println("Which object would you like to destroy: ");
	        newOrigin = input.nextInt();
	        Shape tmpShape = shapesList.get(newOrigin-1);
	        //removes the object from ArrayList
	        boolean removed =shapesList.remove(tmpShape);
	        //checks if the object exists to set it to null
	        if(removed) {
	        	System.out.println("The object: " + tmpShape + " has been destroyed");
	        	//destroys object
	        	tmpShape = null;
	        	objects -= 1;
	        	System.gc();
	        	//pause the execution of the current thread for a 1000 millisecond
	    		Thread.sleep(1000);
	        }else {
	        	System.out.println("This shape does not exist already");
	        }
			}catch(IndexOutOfBoundsException e) {
				System.out.println(wrongInput);
			}
		
	}

	/**
	 * distanceBetweenObjects method is used to calculate the distance between two
	 * Shapes from the ArrayList
	 */
	private void distanceBetweenObjects() {
		try {
	        //Compute and display the distance between any two objects
	        System.out.println("There are " + objects + " shapes");
	        //asks for the first shape
	        System.out.println("What is the first shape: ");
	        int shape1 = input.nextInt();
	        //asks for the second shape
	        System.out.println("What is the second shape: ");
	        int shape2 = input.nextInt();
	        System.out.println("The distance between the two shapes is: " 
	      	+ shapesList.get(shape1-1).distance(shapesList.get(shape2-1)) );
	        //Calculates the distance
			}catch(IndexOutOfBoundsException e) {
				System.out.println(wrongInput);
			}
		
	}

	/**
	 * moveObject method is used to move the origin of a Shape in the ArrayList
	 */
	private void moveObject() {
		try {
	        //move any object according to user-specified delta x and delta y
	        System.out.println("There are " + objects + " shapes");
	        //asks what shape use would like to move
	        System.out.println("Which object would you like to move: ");
	        newOrigin = input.nextInt();
	       System.out.println(" original position: " + shapesList.get(newOrigin-1));
	      //Ask user for delta x and delta y values
	      		System.out.println("Enter the delta x value: ");
	      		double delta_x = input.nextDouble();
	      		System.out.println("Enter the delta y value: ");
	      		double delta_y = input.nextDouble();
	        shapesList.get(newOrigin-1).move(delta_x, delta_y);
	        //prints new position to screen
	        System.out.println(" new position: " + shapesList.get(newOrigin-1));
			}catch(IndexOutOfBoundsException e) {
				System.out.println(wrongInput);
			}
		
	}

	/**
	 * displayCurrentStat method is used to display the Shape the
	 * user chooses by showing the origin and either the radius or length and width
	 * also displying the area and circumference
	 */
	private void displayCurrentState() {
		try {
	        //Display current state of any object
	        System.out.println("There are " + objects + " shapes");
	        System.out.println("Which object would you like to see current state: ");
	        newOrigin = input.nextInt();
	        
	        Shape tmpShape = shapesList.get(newOrigin-1);
	        //call printState method
	        printState(tmpShape);
			}catch(IndexOutOfBoundsException e) {
				System.out.println(wrongInput);
			}
		
	}

	/**
	 * printState method is used to print the the Shape to screen
	 * method determines if the Shape is Circle or Rectangle
	 * Prints origin, area, circumference and radius or width plus length
	 * @param shape is the object passed through
	 */
	private void printState(Shape shape) {
		if (shape instanceof Circle) {
        	System.out.println("Shape Circle :\n" + " origin point: " + shape.toString() 
        	+ "\nThe radius: " + ((Circle) shape).getRadius() 
        	+"\nThe area: " + shape.area() 
        	+"\nThe circumference: " + shape.circumference());
        }else {
        	System.out.println("Shape Rectangle :\n" + " origin point: " + shape.toString() 
        	+ "\nThe width: " +  ((Rectangle) shape).getWidth() 
        	+ "\nThe length: " + ((Rectangle) shape).getLength()
        	+"\nThe area: " + shape.area() 
        	+"\nThe circumference: " + shape.circumference());
        }//end else
		
	}

	/**
	 * setDimensions method is used to change the dimensions of any shape
	 * in the ArrayList that the user chooses
	 */
	private void setDimensions() {
		try {
	        //Set dimensions for any object
	        System.out.println("There are " + objects + " shapes");
	        System.out.println("Which object would you like to set a different dimensions for: ");
	        newOrigin = input.nextInt();
	        //figure out what shape
	        //Need to know what shape to determine if radius or width and lenth are
	        //changed
	        //if circle set radius
	        if (shapesList.get(newOrigin-1) instanceof Circle) {
	        	System.out.println("What is the new radius: ");
	        	radius = input.nextDouble();
	        	((Circle) shapesList.get(newOrigin-1)).setRadius(radius);
	        }else {
	        	//if rectangle set width and length
	        	System.out.println("Rectangle");
	        	System.out.println("What is the new width: ");
	        	width = input.nextDouble();
	        	System.out.println("What is the new length: ");
	        	length = input.nextDouble();
	        	((Rectangle) shapesList.get(newOrigin-1)).setBoth(width, length);
	        }//end else
			}catch(IndexOutOfBoundsException e) {
				System.out.println(wrongInput);
			}
		
	}

	/**
	 * setOrigin method is used to change the origin of any shape
	 * in the ArrayList that the user chooses
	 */
	private void setOrigin() {
		try{
	        //Set origin point of any shape
	        System.out.println("There are " + objects + " shapes");
	        //asks user what shape they would like to set origin for
	        System.out.println("Which object would you like to set a different origin point for: ");
	        newOrigin = input.nextInt();
	        //set's new x coordinate
	        System.out.println("What is the new x value: ");
	        double newX = input.nextDouble();
	        //set's new y coordinate
	        System.out.println("What is the new y value: ");
	        double newY = input.nextDouble();
	        //Changes the origin
	        shapesList.get(newOrigin-1).setOrigin(newX, newY);
			}catch(IndexOutOfBoundsException e) {
				System.out.println(wrongInput);
			}
		
	}

	/**
	 * menu1 method is used to print the menu to screen
	 * @return the user's input
	 */
	private int menu1() {
		System.out.println("1. Create Circles and Rectangles");
		System.out.println("2. Set new origin point for any Circle or Rectangle");
		System.out.println("3. Set the new dimensions for any shape ");
		System.out.println("4. Display current state for a shape");
		System.out.println("5. Move any shape");
		System.out.println("6. Compute distance  between any two shapes ");
		System.out.println("7. Destroy any shape");
		System.out.println("8. List the current states of all shapes");
		System.out.println("9. Quit");
		System.out.println("What is your choice ");
		return input.nextInt();
		
	}

	/**
	 * creatingShapes method is used to print the second menu to screen and ask user
	 * what type of object they would like to create
	 */
	public void creatingShapes() {
		boolean exit = true;
        if(objects == 10) {
        	System.out.println("Can't create more then 10 objects");
        }
        while (objects < 10 && exit) {
        	//print second menu
        	int choice = 0;
        	System.out.println("1. Create Circle with specified dimensions");
			System.out.println("2. Create Circle with default dimensions");
			System.out.println("3. Create Rectangle with specified dimensions ");
			System.out.println("4. Create Rectangle with default dimensions");
			System.out.println("5. Done creating shapes");
			System.out.println("What is your choice ");
			choice = input.nextInt();

			switch (choice) 
			{
			//Circle specific dimensions
			case 1:
				//need x, y, and radius
				System.out.println("Enter x coordinate: ");
				double xCircle = input.nextDouble();
				System.out.println("Enter y coordinate: ");
				double yCircle = input.nextDouble();
				System.out.println("Enter radius: ");
				radius = input.nextDouble();
				Circle specificCircle = new Circle(xCircle,yCircle,radius);
				System.out.println(specificCircle);
				shapesList.add(specificCircle);
				System.out.println(specificCircle);
				objects += 1;
				break;
			//circle default
			case 2:
				//Creates a default circle with dimensions all being 0.0
				Circle defaultCircle = new Circle();
				System.out.println(defaultCircle);
				shapesList.add(defaultCircle);
				objects += 1;
				break;
			//rectangle specific dimensions
			case 3:
				//need x, y, and radius
				//Asks the user for the specific dimensions
				System.out.println("Enter x of origin point: ");
				double xRectangle = input.nextDouble();
				System.out.println("Enter y of origin point: ");
				double yRectangle= input.nextDouble();
				System.out.println("Enter the width: ");
				width= input.nextDouble();
				System.out.println("Enter the length: ");
				length = input.nextDouble();
				Rectangle specificRectangle = new Rectangle(xRectangle,yRectangle,width, length);
				System.out.println(specificRectangle);
				shapesList.add(specificRectangle);
				objects += 1;
				break;
			//rectangle default
			case 4:
				//creates a default Rectangle Shape with all dimensions being 0.0
				Rectangle defaultRectangle = new Rectangle();
				System.out.println(defaultRectangle);
				shapesList.add(defaultRectangle);
				objects += 1;
				break;
			//nothing
			case 5:
				//exits once user decides they have created enough shapes
				exit = false;
				break;
			default:
				System.out.println("Wrong input try again");

			}// end switch
        	
        }//end while loop
        
	}
	
}
