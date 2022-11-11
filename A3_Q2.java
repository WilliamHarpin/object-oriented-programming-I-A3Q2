// -----------------------------------
// Assignment 3
// Written by: William Harpin 40212540 on March 10th
// For Comp 248 Section U - Winter 2022
// -----------------------------------

/*
This program will first prompt the user for their courses and grades. Firstly, it will verify if the user has entered "0", and if that is the case,
it will respond with an appropriate message. It will then fill a 1D char array with the user's string input. Using various for loops and nested loops,
it will process the initial 1D array into two other 1D arrays, one for course names and one for grades. It will then take the 1D array for course names
fill a 2D array, with the different course names on sequential rows. It will also process the 1D grades array and calculate the sum of these grades, to
later be used in calculating the average. Once the average in calculated, the series of if statements will define which letter grade the student receives.
The program will then output the list of course names by reading them out of the 2D array, will print out the student's number average, and will print out
the student's letter average.
*/



import java.util.Scanner;

public class A3_Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//Welcome message
	System.out.println("Welcome to Student Courses Grade Program!");
	System.out.println("-----------------------------------------");
	System.out.println("Please enter the courses you are taking this semester (course|grade and separated by a semicolon):");
	
	//Obtain user input
	Scanner input = new Scanner(System.in);	
	String userInput = input.nextLine();
	
	//Initialize the various arrays that will be needed to complete this program (except the 2d array)
	char[] initialArray = userInput.toCharArray();
	char[] coursesArray = new char[initialArray.length];
	int[] gradesArray = new int[userInput.length()];
	
	//If the user inputs a 0, print appropriate message and use an exit code to terminate the program
	if (userInput.equals("0")) {
		System.out.println("\nYou are not taking any course now!");
		System.out.println("\nThank you for using Student Courses Grade Program!");
		System.exit(0);
	}
	
	
	//This loop will skip over the grades and symbols and will only assign the course names to the coursesArray array.
	int i = 0;
	int p = 0;
	int longestName = 0;
	for (i = 0; i < initialArray.length; i++, p++) {
		if (initialArray[i] == '|') {
			if (i > longestName) {
				longestName = i;
			}
			for (;initialArray[i] != ';';) {
				i++;
			}
		}
		coursesArray[p] = initialArray[i];
	}
		
	
	//This loop will assign only the grades to the gradesArray array and will also assign the sum of these grades to sumOfGrades variable to be used later on when calculating the average grade.
	int j = 0;
	int k;
	int quantityGrades = 0;
	double sumOfGrades = 0;
	String emptyString = "";
	for (i = 0; i < initialArray.length; i++) {
		if (initialArray[i] == '|') {
			j++;
			quantityGrades++;
				for (k = 1; k <= 4; k++) {
					if (initialArray[i + k] == ';') {
						break;
					}
					emptyString += initialArray[i + k];
					gradesArray[i] = Integer.valueOf(emptyString);	
				}
			sumOfGrades = sumOfGrades + gradesArray[i];
			emptyString = "";
		}
	}
	
	i = 0; p = 0;
	
	//Initializing the 2d character array
	char[][] charArray2D = new char[longestName + 1][quantityGrades];
	
	//This loop will assign the values of coursesArray into their appropriate positions in the charArray2D
	for (j = 0; j < quantityGrades; j++) {
		for (p = 0; p <= longestName; i++, p++) {
			if (coursesArray[i] == ';') {
				i++;
				break;
			}
			charArray2D[p][j] = coursesArray[i];
		}
	}
	
	//Calculation of the average grade
	double avgGrade = sumOfGrades / quantityGrades;
	
	//Assigning the appropriate grade letter to the variable gradeLetter, in accordance to the average
	String gradeLetter;
	if (avgGrade >= 88) {
		gradeLetter = "A";
	}
	else if (avgGrade >= 80) {
		gradeLetter = "B";
	}
	else if (avgGrade >= 67) {
		gradeLetter = "C";
	}
	else if (avgGrade >= 60) {
		gradeLetter = "D";
	}
	else {
		gradeLetter = "F";
	}
		
	
	System.out.println("\nHere is the list of courses you are taking: \n");
	i = 0;
	j = 0;
	
	//This loop will print out the course number with the appropriate course name
	int numCourse = 1;
	for (k = 0; k < quantityGrades; k++) {
		System.out.print("No." + numCourse + " ");
		numCourse++;
		
		while (j < numCourse) {
			System.out.print(charArray2D[i][j]);
			if (i == longestName) {
				i=0;
				j++;
				System.out.println();
				break;
			}
			i++;
		}
	}
	
	//Printing out the student's number average, followed by their letter average, followed by a farewell message
	System.out.printf("The average of your courses: %.2f and the average courses letter grade is: %s%n" , avgGrade, gradeLetter);
	System.out.println("\nThank you for using Student Courses Program!");
	
	
	input.close();
		
	}

}
