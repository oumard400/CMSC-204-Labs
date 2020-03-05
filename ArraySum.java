package Recursion;

/**
 * 
 * @author oumar
 *
 */
public class ArraySum {
	
	private int sum;

	//recursive method to calculate sum of an array
	public int sumOfArray(Integer[] myArray, int index) {
		
	     if (index == 0) {
	         sum = myArray[0];
	     }
	     else {
	    	 sum = myArray[index] + sumOfArray(myArray,(index-1));
	     }
	     return sum;
	}

}
