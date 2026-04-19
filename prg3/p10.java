/*
 Write a Java Program for Counting the number of words in a string using user defined
function countWords()
*/
package String_Functions;

public class p10 {
	 public static int countWords(String str) {
	        if (str == null || str.trim().isEmpty()) return 0;
	        return str.trim().split("\\s+").length;
	    }

	    public static void main(String[] args) {
	        System.out.println("Word Count: " + countWords("Hello world java"));
	    }
}
