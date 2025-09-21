public class SumOfTwoDice {
    /**
     * Generate 2 integers between 1 and 6, and print their sum.
     * @param args
     */
    public static void main(String[] args) {
        int SIDES = 6;
        int a = 1 + (int)(Math.random() * SIDES);
        int b = 1 + (int)(Math.random() * SIDES);
        System.out.println(a + b);
    }
}
