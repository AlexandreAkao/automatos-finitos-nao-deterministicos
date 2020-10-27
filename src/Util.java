public class Util {
    public static boolean testAB(Character a, Character b) {
        if (a != null) return a.equals(b);
        if (b != null) return b.equals(a);
        return true;
    }
}
