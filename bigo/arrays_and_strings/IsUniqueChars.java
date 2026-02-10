package arrays_and_strings;

import java.util.HashSet;

public class IsUniqueChars {
    public static void main(String[] args) {
        System.out.println("micah contains all unique characters: "+isUnique("micah"));
        System.out.println("aysha contains all unique characters: "+isUnique("aysha"));
        System.out.println("noah contains all unique characters: "+isUnique("noah"));
        System.out.println("nixon contains all unique characters: "+isUnique("nixon"));
    }

    private static boolean isUnique(String str) {
        HashSet<Character> chars = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            Character current = str.charAt(i);
            if (chars.contains(current)){
                return true;
            } else {
                chars.add(current);
            }
        }
        return false;
    }
}
