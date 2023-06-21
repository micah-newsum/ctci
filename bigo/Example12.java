package bigo;

public class Example12 {
    public static void main(String[] args) {
        permutation("car");
    }

    static void permutation(String str) {
        permutation(str, "");
    }

    /**         
     * 
     * Pseudo code:
     * permutation("car", "")
     *      for i to "car".length:
     *          permutation("ar", "c")
     *              for i to "ar".length:
     *                  permutation("r", "ca")
     *                      for i to "r".length:
     *                          permutation("", "car")
     *                              print "car"
     *                  i = 1
     *                  permutation("a", "cr")
     *                      for i to "a".length:
     *                          ...
     *          
     * 
     * 
     *      
     * @param str
     * @param prefix
     */
    private static void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }
}
