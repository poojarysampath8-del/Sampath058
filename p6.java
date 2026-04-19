/*
 Write a Java Program for Capitalizing the first letter of each word. using user defined
function capitalizeWords()
*/
package String_Functions;

public class p6 {
	 public static String capitalizeWords(String str) {
	        if (str == null || str.isEmpty()) return str;
	        StringBuilder result = new StringBuilder();
	        String[] words = str.split("\\s+");
	        for (String word : words) {
	            if (!word.isEmpty()) {
	                result.append(Character.toUpperCase(word.charAt(0)))
	                      .append(word.substring(1).toLowerCase())
	                      .append(" ");
	            }
	        }
	        return result.toString().trim();
	    }

	    public static void main(String[] args) {
	        System.out.println("Capitalized: " + capitalizeWords("hello world"));
	    }
}
