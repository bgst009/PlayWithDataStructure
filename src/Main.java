public class Main {

    public static void main(String[] args) throws IllegalAccessException {
	// write your code here
        Array array = new Array(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        array.add(1,100);
        array.addFirst(-1);
        System.out.println(array);

        array.remove(0);
        System.out.println(array);

        array.removeFirst();
        System.out.println(array);

    }
}
