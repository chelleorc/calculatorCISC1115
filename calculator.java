/*LaToya Anderson
 * CISC 1115
 * March 18, 2018
 * 
 * Program allows user to calculate simple 
 * operations
 */
import java.util.Scanner;
import java.io.*;

public class calculator {

	public static void main(String[] args) throws IOException{

		//Holds operation as character
		char oper;
		String str;
		boolean notDone = true;
		PrintWriter outputFile = new PrintWriter("/home/latoya/eclipse-" + 
			"workspace/Calculator/NumCalc.txt");
		
		//File myFile = new File("/home/latoya/eclipse-workspace/Calculator/Values.txt");

		Scanner keyboard = new Scanner(System.in);
		//Scanner inputFile = new Scanner(myFile);
	
		//while(inputFile.hasNext()){
		do {
			
			//calls menu to print to console
			menu();
			
			//Prints title to file
			outputFile.println("Calculations");
			outputFile.println();
			
			System.out.print("Choose an operation: ");
			str = keyboard.next();
			oper = str.charAt(0);
			
			switch(oper) {
				case '+':
					addition(oper,outputFile);
					break;
				case '-':
					subtraction(oper,outputFile);
					break;
				case '*':
					multiplication(oper,outputFile);
					break;
				case '/':
					division(oper,outputFile);
					break;
				case '%':
					remainder(oper,outputFile);
					break;
				case 'A':
				case 'a':
					average(oper,outputFile);
					break;
				case 'X':
				case 'x':
					maxNum(oper,outputFile);
					break;
				case 'M':
				case 'm':
					minNum(oper,outputFile);
					break;
				case 'S':
				case 's':
					square(oper,outputFile);
					break;
				case 'Q':
				case 'q':
					notDone = quit(oper);
					break;
				default:
					System.out.println(oper + " is not an operation. Try again.");
				}			

			
		}while(notDone);
		//}	
		//System.out.println(inputFile);
		
		keyboard.close();
		//inputFile.close();
		outputFile.flush();
		outputFile.close();
		
	}
	
	/*Input - 
	 * Process - 
	 * Output - Prints results to file
	 * 			void return
	 
	public static void printFile() throws IOException{
		
		PrintWriter outputFile = new PrintWriter("c:/home/latoya/eclipse"
				+ "workspace/Calculator/NumCalc.txt");
		outputFile.
	}*/
	/*Input - Receive Q or q to char e
	 * Process - ends calculator
	 *Output - Returns false 
	 */
	public static boolean quit(char e){
	
		System.out.println("Your calculator has closed.");
		return false;
	}
	
	/*Input - Displays menu options
	 * Process - Prints menu to file
	 * Output - void return
	 */
	public static void menu() {
		System.out.println("Choose one of "
			+ "the operations listed: ");
		System.out.println("+, -, *, /, %");
		System.out.println("A (average)");
		System.out.println("M (minimum number)");
		System.out.println("X (maximum number)");
		System.out.println("S (square)");
		System.out.println("Q (quit)");
	}
	
	/*Input - Receives + to char a
	 * Process - Adds two numbers
	 * Output - Returns sum to main
	 */
	public static void addition (char a, PrintWriter out1) {
		int addend1, addend2, sum;
		
		Scanner keyboard = new Scanner (System.in);
		System.out.print("Enter two numbers to be summed: ");

		addend1 = keyboard.nextInt();
		addend2 = keyboard.nextInt();
		
		//Calculates sum
		sum = addend1 + addend2;
		
		out1.println(addend1 + "+" + addend2 + "=" + sum);
		out1.println();

	}
	
	/* Input - char oper - char s
	 * Process - Subtracts user entered values 
	 * Output - prints calculation
	 * 			void return
	 */
	public static void subtraction(char s,PrintWriter out1) {
		int minuend, subtrahend,difference;
		
		Scanner keyboard = new Scanner(System.in);
		
		//User enters numbers to subtract
		
		System.out.print("Enter two numbers to find difference: ");
		minuend = keyboard.nextInt();
		subtrahend = keyboard.nextInt();

		difference = minuend - subtrahend;
		out1.println( minuend + "-" + subtrahend + " = " + difference);

	}
	
	/*Input - char oper - char m
	 * Process - multiplies two user-entered numbers
	 * Output - prints calculation
	 * 			void return
	 */
	public static void multiplication (char m,PrintWriter out1) {
		int multiplier,multiplicand,product;
		
		System.out.print("Enter two numbers to "
				+ "be multiplied: ");
		Scanner keyboard = new Scanner(System.in);
		multiplier = keyboard.nextInt();
		multiplicand = keyboard.nextInt();
		
		//equation for multiplication
		product = multiplier * multiplicand;
		
		out1.println(multiplier + "*" + multiplicand + " = " + product);
		
	}
	
	/*Input - char oper - char d
	 * Process - divides two user-entered numbers
	 * 			 checks if dividing by 0
	 * Output - if false then prints result
	 * 			void return
	 */
	public static void division (char d,PrintWriter out1){
		int divisor, dividend;
		double quotient;
		
		System.out.print("Enter two numbers to be divided: ");
		Scanner keyboard = new Scanner(System.in);
		divisor = keyboard.nextInt();
		dividend = keyboard.nextInt();
		
		//prevents user from dividing by 0
		while(dividend == 0){
			out1.println(divisor + "/" + dividend + 
					" is not possible.");
			System.out.println(divisor + "/" + dividend + 
				" is not possible. Try again.");
			
			out1.println();
			
			System.out.print("Re-enter second number to find quotient: ");
			//divisor = keyboard.nextInt();
			dividend = keyboard.nextInt();
	
		}
		quotient = (double)divisor/dividend;
		out1.println(divisor + "/" + dividend + " = " + quotient);
		out1.println();
		
	}
	/*Input - char oper - char r
	 * Process - finds remainder of two user-entered numbers
	 *			checks if dividing by 0
	 * Output - if false it prints result
	 * 			if true, returns to main
	 * 			void return
	 */
	public static void remainder(char r,PrintWriter out1) {
		int divisor, dividend,modulo;
		
		System.out.print("Enter two numbers to find remainder: ");
		Scanner keyboard = new Scanner(System.in);
		divisor = keyboard.nextInt();
		dividend = keyboard.nextInt();
		
		//Prevents user from dividing by 0
		while(dividend == 0) {
			out1.println(divisor + "%" + dividend + 
					" is not possible.");
			System.out.println(divisor + "%" + dividend + 
					" is not possible. Try again.");
			System.out.print("Re-enter second number to find remainder: ");
			
			dividend = keyboard.nextInt();
			System.out.println();
			
		}
			modulo = divisor%dividend;
			out1.println(divisor + "%"+ dividend + " = " + modulo);
			out1.println();
	}
	
	/*Input - char oper - char a
	 * Process - Calculates average
	 * Output - Prints result
	 * 			void return
	 */
	public static void average(char a,PrintWriter out1) {
		//user-entered number
		int num1, num2;
		double avg;
		final int COUNT = 2;
		
		System.out.print("Enter two numbers to find average: ");
		Scanner keyboard = new Scanner(System.in);
		num1 = keyboard.nextInt();
		num2 = keyboard.nextInt();
		
		avg = (double)(num1 + num2)/COUNT;
		out1.print("(" +num1 + "+" + num2 + ")" + "/" + COUNT + " = " + avg);
		out1.println();
	}
	/*Input - char oper - char m
	 * Process - Finds max of two user-entered numbers
	 * Output - Prints result
	 * 			void return
	 */
	public static void maxNum(char m,PrintWriter out1) {
		int num1, num2;
		
		System.out.print("Enter two numbers to find highest number: ");
		Scanner keyboard = new Scanner(System.in);
		num1 = keyboard.nextInt();
		num2 = keyboard.nextInt();
		
		//finds highest of two numbers
		if(num1 > num2)	
			out1.println(num1 + " is higher than "+ num2);
		else
			out1.println(num2 + " is the higher " + num1);
		out1.println();
	}
	
	/*Input - char oper - char m
	 * Process - Finds max of two user-entered numbers
	 * Output - Prints result
	 * 			void return
	 */
	public static void minNum(char m,PrintWriter out1) {
		int num1, num2;
		
		System.out.print("Enter two numbers to find lowest number: ");
		Scanner keyboard = new Scanner(System.in);
		num1 = keyboard.nextInt();
		num2 = keyboard.nextInt();
		
		//finds lowest of two numbers
		if(num1 < num2)	
			out1.println(num1 + " is the lower than " + num2);
		else
			out1.println(num2 + " is the lower than " + num1);
		out1.println();
	}
	
	/*Input - char oper - char s
	 * Process - Calculates square of user-entered number
	 * Output - Prints result 
	 * 			void return
	 */
	public static void square(char s,PrintWriter out1) {
		int num, product;
		
		System.out.print("Enter a number to be squared: ");
		Scanner keyboard = new Scanner(System.in);
		num = keyboard.nextInt();
		
		//squares user-entered number
		product = num*num;
		out1.print(num + "*" + num +" = " + product);
		out1.println();
	}
	
}
