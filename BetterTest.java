import java.util.LinkedList;
import java.util.Random;

public class BetterTest {

    public static void main(String[] args) {

        BetterBST<Integer> bbst1 = new BetterBST<>();

        String str = "";
        for(int i = 0; i < 20; i++){
            Random rand = new Random();
            int x = rand.nextInt(20);
            str += x + " ";
            bbst1.insert(x);

        }
        System.out.println("insertion: " + str);
        // bbst1.insert(3);
        // bbst1.insert(1);
        // bbst1.insert(5);
        // bbst1.insert(4);
        // bbst1.insert(7);
        // bbst1.insert(6);
        // bbst1.insert(0);
        // bbst1.insert(5);
        // bbst1.insert(65);
        // bbst1.insert(55);
        // bbst1.insert(56);
        // bbst1.insert(80);
        // bbst1.insert(81);
        // bbst1.insert(82);
        Random rand2 = new Random();
        int value = rand2.nextInt(20);
        System.out.println("-----Original-----");
        System.out.println("infix: " + bbst1.infix());
        System.out.println("height: " + bbst1.height());
        System.out.println("Imbalance at: " + bbst1.imbalance());
        System.out.println("smallest greater than " + value + ": " + bbst1.smallestGreaterThan(value));
        System.out.println("level order traversal: " + bbst1.levelOrderTraversal());

        System.out.println("-----Mirrored-----");
        BetterBST<Integer> bbst2 = (BetterBST<Integer>) (bbst1.mirror());
        System.out.println("infix: " + bbst2.infix());
        System.out.println("height: " + bbst2.height());
        System.out.println("imbalance at: " + bbst2.imbalance());
        System.out.println("smallest greater than " + value + ": " + bbst2.smallestGreaterThan(value));
        System.out.println("level order traversal: " + bbst2.levelOrderTraversal());

        System.out.println("-----Original Again-----");
        System.out.println("infix: " + bbst1.infix());
        System.out.println("height: " + bbst1.height());
        System.out.println("Imbalance at: " + bbst1.imbalance());
        System.out.println("smallest greater than " + value + ": " + bbst1.smallestGreaterThan(value));
        System.out.println("level order traversal: " + bbst1.levelOrderTraversal());

        System.out.println("-----Mirrored Again-----");
        BetterBST<Integer> bbst3 = (BetterBST<Integer>) (bbst2.mirror());
        System.out.println("infix: " + bbst3.infix());
        System.out.println("height: " + bbst3.height());
        System.out.println("Imbalance at: " + bbst3.imbalance());
        System.out.println("smallest greater than " + value + ": " + bbst3.smallestGreaterThan(value));
        System.out.println("level order traversal: " + bbst3.levelOrderTraversal());

        System.out.println("-----Original (must be unchanged)-----");
        System.out.println("og infix: " + bbst1.infix());
        System.out.println("height: " + bbst1.height());
        System.out.println("Imbalance at: " + bbst1.imbalance());
        System.out.println("smallest greater than " + value + ": " + bbst1.smallestGreaterThan(value));
        System.out.println("level order traversal: " + bbst1.levelOrderTraversal());
       

    }

}