import java.util.ArrayList;

public class Main {

  private static double testSet(Set<String> set, String filename) {

    long startTime = System.nanoTime();

    System.out.println(filename);
    ArrayList<String> words = new ArrayList<>();
    if (FileOperation.readFile(filename, words)) {
      System.out.println("Total words: " + words.size());

      for (String word : words) {
        set.add(word);
      }
      System.out.println("Total different words: " + set.getSize());
    }
    long endTime = System.nanoTime();

    double seconds = (endTime - startTime) / 1000000000.0;
    return seconds;
  }

  public static void main(String[] args) {

    String filename = "pride-and-prejudice.txt";

    BSTSet<String> bstSet = new BSTSet<>();
    double time1 = testSet(bstSet, filename);
    System.out.println("BST Set: " + time1 + " s");

    System.out.println();

    LinkedListSet<String> linkedListSet = new LinkedListSet<>();
    double time2 = testSet(linkedListSet, filename);
    System.out.println("Linked List Set: " + time2 + " s");

    AVLSet<String> avlSet = new AVLSet<>();
    double time3 = testSet(avlSet, filename);
    System.out.println("AVL Set: " + time3 + " s");
    /*
        pride-and-prejudice.txt
        Total words: 125901
        Total different words: 6530
        BST Set: 0.4179655 s

        pride-and-prejudice.txt
        Total words: 125901
        Total different words: 6530
        Linked List Set: 15.6691239 s
    */
  }
}
