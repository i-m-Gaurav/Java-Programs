import java.util.ArrayList;

class Work {
	// array list to store the palindrome strings
	ArrayList<String> palindromeStrings = new ArrayList<String>();
	
	// variable to store the concatenated string
	String concatString = "";
	
	// variable to store the sum of numbers
	int numberSum = 0;

	// method to find the sum of numbers
	void calculateSumOfNumbers(String[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			try {
				numberSum = numberSum + Integer.parseInt(inputArray[i]);
			} catch (Exception e) {
				// ignore any non-numeric inputs
			}
		}
	}

	// method to check the palindrome string
	void checkPalindrome(String[] array) {
		for (int i = 0; i < array.length; i++) {
			try {
				int num = Integer.parseInt(array[i]);
			} catch (Exception e) {
				boolean isPalindrome = true;
				for (int j = 0; j < array[i].length() / 2; j++) {
					if (array[i].charAt(j) != array[i].charAt(array[i].length() - j - 1)) {
						isPalindrome = false;
						break;
					}
				}
				if (isPalindrome) {
					palindromeStrings.add(array[i]);
				}
			}
		}
	}

	// method to concatenate all the strings
	void concatenateStrings(String[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			concatString = concatString + inputArray[i];
		}
	}

	// method to display the final results
	void displayResults(String[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			System.out.println(inputArray[i] + " Length : " + inputArray[i].length());
			System.out.println();
		}

		System.out.println("Palindrome words      = " + palindromeStrings);
		System.out.println();

		System.out.println("Number of Arguments   = " + inputArray.length);
		System.out.println();

		System.out.println("All Merged Arguments  = " + concatString);
		System.out.println();

		System.out.println("Sum of Numbers        = " + numberSum);
	}
}

public class Gaurav {
	public static void main(String[] args) {
		Work work = new Work();
		work.checkPalindrome(args);
		work.concatenateStrings(args);
		work.calculateSumOfNumbers(args);
		work.displayResults(args);
	}
}
