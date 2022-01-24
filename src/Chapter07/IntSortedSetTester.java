package Chapter07;

public class IntSortedSetTester {
    public static void main(String[] args) {
        IntSortedSet s1 = new IntSortedSet(20);

        s1.add(20);
        s1.add(18);
        s1.add(21);
        s1.add(25);

        System.out.println("s1 = " + s1);

    }
}
