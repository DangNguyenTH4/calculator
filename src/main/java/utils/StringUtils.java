package utils;

public class StringUtils {
  public static int countMatches(final CharSequence str, final char ch) {
    if (isEmpty(str)) {
      return 0;
    }
    int count = 0;
    // We could also call str.toCharArray() for faster look ups but that would generate more garbage.
    for (int i = 0; i < str.length(); i++) {
      if (ch == str.charAt(i)) {
        count++;
      }
    }
    return count;
  }
  public static boolean isEmpty(final CharSequence cs) {
    return cs == null || cs.length() == 0;
  }
}
