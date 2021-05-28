public class Main {
    public static void main(String[] args) {
        String a = "laba";
        String b = "laba";
        String c = new String("laba");
        String d = "l" + "aba";
        String e = "";
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a == d);
        char[] labaArray = new char[]{'l', 'a', 'b', 'a'};
        System.out.println (a == e);
        System.out.println (a == "laba");
    }
}