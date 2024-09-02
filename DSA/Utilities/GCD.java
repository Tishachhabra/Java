public class GCDExample {

    // Method to calculate GCD of two numbers
    public static int gcd(int a, int b) {
        // Base case: if b is 0, gcd is a
        if (b == 0) {
            return a;
        }
        // Recursively calculate gcd
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int num1 = 56;
        int num2 = 98;

        int result = gcd(num1, num2);                                                  //not any particular order

        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + result);
    }
}
