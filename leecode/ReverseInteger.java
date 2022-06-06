/**
* https://leetcode.com/problems/reverse-integer/
 */

public class ReverseInteger {

    private static int reverse(int x) {
        int nv = 0;
        while (x != 0) {
            int y = x % 10;
            if (overflow(nv, y)) 
                return 0;
            nv = nv * 10 + y;
            x /= 10;

        }
        return  nv;
    }
    public static boolean overflow(int x, int y) {
        return x > 0 ? overflowMax(x, y) : overflowMin(x, y);
    }
    /**
     * 2^31 -1 (2147483647) is the max integer value that's why we have this < 7 requirement
     * 
     * @param x
     * @param y
     * @return
     */
    public static boolean overflowMax(int x, int y) {
        return x > Integer.MAX_VALUE/10 || x == Integer.MAX_VALUE/10 && y > 7;
    }

    /**
     * -2^31 (-2147483648) is the min integer value tha's why we have this < 8 requirement
     * 
     * @param x
     * @param y
     * @return
     */
    public static boolean overflowMin(int x, int y) {
        return x < Integer.MIN_VALUE/10 || x < Integer.MIN_VALUE/10 && y < -8;
    }

    public static void main(String[] args) {
        int value = -123;
        System.out.println("value :" + value);
        System.out.println("new value:" + reverse(value));
    }
}
