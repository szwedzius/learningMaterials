import java.util.Arrays;

public class Valid_Anagram_242 {

    public static boolean isAnagram(String s, String t) {
        final int CHAR_AMOUNT = 26;

        if(s.length() != t.length())
            return false;

        int [] first = new int[CHAR_AMOUNT];
        int [] second = new int [CHAR_AMOUNT];

        for(int i = 0; i < s.length(); i++){
            first[s.charAt(i) - 'a']++;
            second[t.charAt(i) - 'a']++;
        }

        return Arrays.equals(first,second);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("car", "rat"));
    }
}
