public class HowMany {
    /**
     * Write a program HowMany.java that takes a variable number of command-line arguments
     * and prints how many there are.
     * @param args
     */
    public static void main(String[] args) {
        int n = args.length;
        System.out.print("You entered " + n + " command-line argument");
        if (n == 1) System.out.println(".");
        else        System.out.println("s.");
    }
}
