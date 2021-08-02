import java.util.*;

public class VerifyAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length == 0)
            return false;

        HashMap<Character, Integer> map = new HashMap();

        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            boolean isOrder = isAleanOrder(map, words[i], words[i + 1]);
            if (!isOrder)
                return false;
        }
        return true;
    }

    private boolean isAleanOrder(HashMap<Character, Integer> map, String wordOne, String wordTwo) {
        int m = wordOne.length();
        int n = wordTwo.length();
        int i = 0;

        while (i < m && i < n) {
            int firstChar = map.get(wordOne.charAt(i));
            int secondChar = map.get(wordTwo.charAt(i));
            if (firstChar != secondChar) {
                return firstChar < secondChar;
            }
            i++;
        }
        return m <= n;
    }

    public static void main(String[] args) {
        VerifyAlienDictionary vAlienDictionary = new VerifyAlienDictionary();
        boolean result = vAlienDictionary.isAlienSorted(new String[] { "hello", "leetcode" },
                "hlabcdefgijkmnopqrstuvwxyz");
        System.out.println("The result: " + result);
    }
}