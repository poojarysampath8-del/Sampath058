/*
 Write a Java Program for Reversing the characters in a string using user defined function
reverseString().
*/
package String_Functions;

public class p3 {
	 public static String reverseString(String str) {
	        if (str == null) return null;
	        return new StringBuilder(str).reverse().toString();
	    }

	    public static void main(String[] args) {
	        System.out.println("Reverse: " + reverseString("hello"));
	    }
}
