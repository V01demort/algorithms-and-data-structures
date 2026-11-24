public class Task7 {
    public static void reverse(int[] arr, int n) {
        if (n == 0) return;
        System.out.print(arr[n - 1] + " ");
        reverse(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 2};
        reverse(arr, arr.length);
    }
}
