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
     *          i = 0
     *          permutation("ar", "c")
     *              for i to "ar".length:
     *                  i = 0
     *                  permutation("r", "ca")
     *                      for i to "r".length:
     *                          i = 0
     *                          permutation("", "car")
     *                              print "car" <----
     *                  i = 1
     *                  permutation("a", "cr")
     *                      for i to "a".length:
     *                          i = 0
     *                          permutation("", "cra")
     *                              print "cra" <----
     *          i = 1
     *          permutation("cr", "a")
     *              for i; i < "cr".length:
     *                  i = 0
     *                  permutation("r", "ac")
     *                      for i; i < "r".length:
     *                          i = 0
     *                          permutation("", "acr")
     *                              print "acr" <----
     *          i = 2
     *                          
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
