import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		 // YOUR CODE HERE
        if (str == null || str.isEmpty()) return 0;

        int max = 1;
        int current = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                current++;
                if (current > max) {
                    max = current;
                }
            } else {
                current = 1;
            }
        }
        return max;
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
        // YOUR CODE HERE
        if (str == null || str.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isDigit(c)) {
                int count = c - '0';
                if (i + 1 < str.length()) {
                    char next = str.charAt(i + 1);
                    for (int j = 0; j < count; j++) {
                        sb.append(next);
                    }
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		// YOUR CODE HERE
        if (a == null || b == null || len <= 0) return false;
        if (len > a.length() || len > b.length()) return false;

        Set<String> seen = new HashSet<>();

        for (int i = 0; i <= a.length() - len; i++) {
            seen.add(a.substring(i, i + len));
        }

        for (int i = 0; i <= b.length() - len; i++) {
            if (seen.contains(b.substring(i, i + len))) {
                return true;
            }
        }

        return false;
	}
}
