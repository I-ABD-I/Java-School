package recursion;

public class Strings {
    public static boolean isPalindrome(String s) { // O(n) as length is O(1) and substring is O(1) and for each char
                                                   // we call those functions
        if (s.length() <= 1) {
            return true;
        }
        return s.charAt(0) == s.charAt(s.length() - 1) && isPalindrome(s.substring(1, s.length() - 1));
    }

    public static boolean isPalindromeRotated(String s, int n) { // O(n^2) for each char in s we call isPalindrome which
                                                                 // is O(n)
        if (n == s.length())
            return false;
        return isPalindrome(s) || isPalindromeRotated(s.charAt(s.length() - 1) + s.substring(0, s.length() - 1), n + 1);
    }

    public static void main(String[] args) {

        System.out.println(isPalindrome("abba"));
        System.out.println(isPalindrome("abca"));

        System.out.println(isPalindromeRotated("223113", 0));
        System.out.println(isPalindromeRotated("1234", 0));

    }
}
