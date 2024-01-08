import java.util.Scanner;

public class Grades {

	public static void main(String[] args) {
		//import scanner
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the course code: ");
		//Saves the course code as a String
		String courseCode = keyboard.nextLine();
		//boolean value to control the while loop 
		boolean checkingInput = true;
		//The count of how many grades are entered 
		int numOfGrades = 0;
		//The total sum of grades
		int sumOfGrades = 0;
		//The min value
		int minGrade = 100;
		//The max value
		int maxGrade = 0;
		//Letter Distribution
		int letterAplus = 0, letterA = 0, letterAminus = 0, letterBplus = 0, letterB = 0, letterBminus = 0;
		int letterCplus = 0, letterC = 0, letterCminus = 0, letterDplus = 0, letterD = 0, letterF = 0;
		//keeps looping while true
		while(checkingInput) {
			//try catch used to make sure the input form user is an integer
			try {
				//Ask user to input the grades
				System.out.println("Enter the grade as integer or a negative to exit: ");
				//Saves the inputed grade in a temporally variable to use for other calculations
				int tmpGrade = keyboard.nextInt();
				//checks the sentinel value
				if(tmpGrade < 0) {
					//makes the while loop be exited
					checkingInput = false;
				//checks that the grade is not higher then the max grade 100
				}else if (tmpGrade > 100) {
					System.out.println("Grade must be between 0-100");
					// does nothing with the input as it was not correct therefore
					//ask for the user to enter the grade again
				//runs when the correct input is inputed
				}else {
					//Adds a 1 every time to the grades inputed
					numOfGrades++;
					//Adds the grade to the sum of all grades
					sumOfGrades = sumOfGrades + tmpGrade;
					
					//Finding the minimum value
					if(tmpGrade <= minGrade) {
						//changes the minGrade so that the if statement is only entered when
						//the inputed grade is smaller
						minGrade = tmpGrade;
						
					//Is finding the maximum value
					}//end check for min value
					if (tmpGrade >= maxGrade) {
						//changes the maxGrade so that the if statement is only entered when
						//the inputed grade is bigger
						maxGrade = tmpGrade;
					}//end check for max value
					
					//Distribution of letter grade
					//check the grade what numbers it is between and adds a one to the letter based on the range
					if(94 < tmpGrade && tmpGrade <101) {
						letterAplus++;
					}else if (89 < tmpGrade && tmpGrade <95) {
						letterA++;
					}else if (84 < tmpGrade && tmpGrade <90) {
						letterAminus++;
					}else if (79 < tmpGrade && tmpGrade <85) {
						letterBplus++;
					}else if (74 < tmpGrade && tmpGrade <80) {
						letterB++;
					}else if (69 < tmpGrade && tmpGrade <75) {
						letterBminus++;
					}else if (64 < tmpGrade && tmpGrade <70) {
						letterCplus++;
					}else if (59 < tmpGrade && tmpGrade <65) {
						letterC++;
					}else if (54 < tmpGrade && tmpGrade <60) {
						letterCminus++;
					}else if (49 < tmpGrade && tmpGrade <55) {
						letterDplus++;
					}else if (44 < tmpGrade && tmpGrade <50) {
						letterD++;
					}else {
						letterF++;
					}
					
				}//end else
			//the catch is used for when the input is not an integer
			}catch (Exception e) {
				//asks the user to try again
				System.out.println("Wrong input try again!");
				keyboard.next();
			}//end catch
		}//end while
		//close the scanner
		keyboard.close();
		double averageOfGrades = (double)sumOfGrades/numOfGrades;
		String letterAverage;
		//calculating the letter for average of class
		if(95.0 < averageOfGrades && averageOfGrades <=100) {
			letterAverage = "A+";
		}else if (90 <= averageOfGrades && averageOfGrades <=95) {
			letterAverage = "A";
		}else if (85 <= averageOfGrades && averageOfGrades <=90) {
			letterAverage = "A-";
		}else if (80 <= averageOfGrades && averageOfGrades <=85) {
			letterAverage = "B+";
		}else if (75 <= averageOfGrades && averageOfGrades <=80) {
			letterAverage = "B";
		}else if (70 <= averageOfGrades && averageOfGrades <=75) {
			letterAverage = "B-";
		}else if (65 <= averageOfGrades && averageOfGrades <=70) {
			letterAverage = "C+";
		}else if (60 <= averageOfGrades && averageOfGrades <=65) {
			letterAverage = "C";
		}else if (55 <= averageOfGrades && averageOfGrades <=60) {
			letterAverage = "C-";
		}else if (50 <= averageOfGrades && averageOfGrades <=55) {
			letterAverage = "D+";
		}else if (45 <= averageOfGrades && averageOfGrades <=50) {
			letterAverage = "D";
		}else {
			letterAverage = "F";
		}
		
		//Display the course code then statistics
		System.out.println("Course Code: " + courseCode);
		System.out.println("Total number of grades: " + numOfGrades);
		System.out.println("The sum of all grades: " + sumOfGrades);
		System.out.println("The max grade: " + maxGrade);
		System.out.println("The min grade: " + minGrade);
		System.out.println("The average: " + averageOfGrades + " The average letter grade: " + letterAverage );

		//print out the distribution of grades
		System.out.println("\nDistribution of letter grade");
		System.out.printf("%-20s %-20s\n", "Letter Grade", "Students");
		System.out.printf("%-5s %-15s %-15s\n", "A+", "95-100", letterAplus);
		System.out.printf("%-5s %-15s %-15s\n", "A", "90-95", letterA);
		System.out.printf("%-5s %-15s %-15s\n", "A-", "85-90", letterAminus);
		System.out.printf("%-5s %-15s %-15s\n", "B+", "80-85", letterBplus);
		System.out.printf("%-5s %-15s %-15s\n", "B", "75-80", letterB);
		System.out.printf("%-5s %-15s %-15s\n", "B-", "70-75", letterBminus);
		System.out.printf("%-5s %-15s %-15s\n", "C+", "65-70", letterCplus);
		System.out.printf("%-5s %-15s %-15s\n", "C", "60-65", letterC);
		System.out.printf("%-5s %-15s %-15s\n", "C-", "55-60", letterCminus);
		System.out.printf("%-5s %-15s %-15s\n", "D+", "50-55", letterDplus);
		System.out.printf("%-5s %-15s %-15s\n", "D", "45-50", letterD);
		System.out.printf("%-5s %-15s %-15s\n", "F", "0-45", letterF);
	}//end main


}//end class
