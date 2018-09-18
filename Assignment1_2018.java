/****************************************************************************
 *
 * Created by: Julie Nguyen
 * Created on: Sept 2018
 * Created for: ICS4U
 * This program "blows up" the string the user inputs 
 * Code from github (link found in assignment pdf)
 *
 ****************************************************************************/

import java.util.Scanner;

public class Assignment1_2018 {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		//scanner variable to allow user input
		
		System.out.print("To blow up a string is to replace each digit in the string with copies of the character that follow said digit.\nThe number of copies are equal to the value of the digit.\n\nEnter a string to blow up: ");
		//prints out explanation of what it means to 'blow up' as string and asks for user input 
		
		String userInput = scanner.nextLine();
		//allows and collects user input in following line
		
		String output;
		//declaring variable for output
		
		output = blowup(userInput);
		//output is assigned the blowup of userInput
		
		System.out.print(output);
		//prints output (result of user string blowup)
		
	}
	
	public static String blowup(String str) {
	    //main procedure used to blow up string
		if (str.length() != 0) {
			//check if string length is NOT 0 (if there is a string)
	            if (!Character.isDigit(str.charAt(0))) {
	                return Character.toString(str.charAt(0)) + blowup(str.substring(1));
	        	/* 
	        	 * if the character at index 0 of the string is a digit, then return the character to its initial index
	        	 * blowup the substring following the index of that character 
	        	 */
	        }
	        else if (str.length() > 1) {
	            return blowupHelper(Integer.parseInt(Character.toString(str.charAt(0))), str.charAt(1)) + blowup(str.substring(1));
	            /*
	             * if the character is NOT a digit and the string length is greater than 1
	             * parse for integer in string 
	             * return character to its initial index in string, return subsequent character to its initial index
	             * use blowup on substring at index of following character 
	             */
	        }
	    }
	    return "";
	    //returns empty string when string length IS 0 (when there is no string); also for when there is no character to right
	}
	
	
	private static String blowupHelper(int num, char ch) {
	    /*
	     * procedure used for creating repetitions (copies) in new string
	     * parameters are number and character
	     */
		String repetitions = "";
	    //string variable created for copies
		for (int i = 0; i < num; i++) {
			repetitions += ch;
			/*
			 * initialize variable i (counter) at 0
			 * condition is while i is less than number, increment i by 1
			 */
		}
	    return repetitions;
	    //return statement; returns copies
	}
}
