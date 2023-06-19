package bigo;

import java.util.Arrays;

public class Example7 {
    /**
     * O(N*s*log(s)) + O(s*N*log(N)) => O(Ns(log(s) + log(N)))
     * @param args
     */
    public static void main(String[] args) {
        String[] strings = { "baa", "bac", "bbb", "cab", "abazaba" };
        
        /**
         * Iterate through array and sort each string. 
         * For loop runs in O(N) time.
         */
        for (int i = 0; i < strings.length; i++) {
            char[] charArray = strings[i].toCharArray();
            /**
             * Each string is sorted in s*log(s) time, where s represents the 
             * length of the string.
             */ 
            Arrays.sort(charArray, 0, charArray.length);
            strings[i] = new String(charArray);
        }

        /**
         * If the array was comprised of integers, the sorting algorithm
         * would run in O(N*log(N)) time because the work involved in comparing two integers
         * is constant. However, since the array is comprised of variable length
         * strings, each comparision could take upwards of O(s) time. In other words,
         * the runtime of the sorting of the strings is impacted by the size of each string. 
         * For example, it could be that the longest string
         * within the array is compared against every other. Therefore,
         * the sorting of sorted strings is O(s*N*log(N)) time.
         */
        Arrays.sort(strings, 0, strings.length);   
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
