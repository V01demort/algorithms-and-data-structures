public class Task1 {
    public static void printDigits(int n) {
        if (n >= 10) printDigits(n / 10);
        System.out.println(n % 10);
    }

    public static void main(String[] args) {
        printDigits(5481);
    }
}
