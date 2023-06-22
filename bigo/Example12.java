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
     *      for i to i < "car".length:
     *          i = 0
     *          permutation("ar", "c")
     *              for i to i < "ar".length:
     *                  i = 0
     *                  permutation("r", "ca")
     *                      for i to "r".length:
     *                          i = 0
     *                          permutation("", "car")
     *                              print "car" 
     *                  i = 1
     *                  permutation("a", "cr")
     *                      for i to i < "a".length:
     *                          i = 0
     *                          permutation("", "cra")
     *                              print "cra" 
     *          i = 1
     *          permutation("cr", "a")
     *              for i to i < "cr".length:
     *                  i = 0
     *                  permutation("r", "ac")
     *                      for i; i < "r".length:
     *                          i = 0
     *                          permutation("", "acr")
     *                              print "acr" 
     *                  i = 1
     *                  permutation("c", "ar")
     *                      for i to i < "c".length:
     *                          i = 0
     *                          permutation("", "arc")
     *                              print "arc" 
     *          i = 2
     *          permutation("ca", "r")
     *              for i < "ca".length:
     *                  i = 0
     *                  permutation("a", "rc")
     *                      for i < "a".length:
     *                          i = 0
     *                          permutation("", "rca")
     *                              print "rca"
     *                  i = 1
     *                  permutation("c", "ra")
     *                      for i < "c".length:
     *                          i = 0
     *                          permutation("", "rac")
     *                              print "rac"
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
