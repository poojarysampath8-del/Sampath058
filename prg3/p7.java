/*
 Write a Java Program for Shortening a string to a specified length and adds an ellipsis
using user defined function truncate()
*/
package String_Functions;

public class p7 {
    public static String truncate(String str, int maxLength) {
        if (str == null) return null;
        return str.length() > maxLength ? str.substring(0, maxLength) + "..." : str;
    }

    public static void main(String[] args) {
        System.out.println("Truncated: " + truncate("Hello World", 5));
    }
}
