public class Task9 {
    public static int count(String s) {
        if (s.equals("")) return 0;
        return 1 + count(s.substring(1));
    }

    public static void main(String[] args) {
        System.out.println(count("hello"));
    }
}
