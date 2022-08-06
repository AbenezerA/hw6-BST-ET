/* Abenezer Amanuel
 * ata2152
 * 3/2/2021
 * This class implements a stack using a resizable array
*/

import java.util.LinkedList;

public class BetterBST<T extends Comparable<? super T>> extends 
                                            BinarySearchTree<T> {
    
    private int height;
    private LinkedList<T> pointsOfImbalance = new LinkedList<>();
    private String infixString = "";

    public BetterBST() {

    }
    
    //public driver for height
    public int height() {
        return height(root);
    }

    //compares height of left and right subtrees and returns the max
    private int height(BinaryNode<T> t) {

        if(t == null)
            return -1;
        
        int leftHeight = height(t.left);
        int rightHeight = height(t.right);

        return 1 + (Math.max(leftHeight, rightHeight));

    }

    private static final int ALLOWED_IMBALANCE = 1;

    //public driver for imbalance, creates a fresh linkedlist to store points
    //of imbalance and returns the data of the first (treated as a queue)
    public T imbalance() {      
        pointsOfImbalance.clear();
        imbalance(root);

        if(!(pointsOfImbalance.isEmpty())){
            //System.out.println("points of imbalance: " + pointsOfImbalance);
            return pointsOfImbalance.poll();
        } else
            return null;
    }

    //recursively checks for imbalance starting from deepest left-most node
    //direction of traversal is left then right then up
    private void imbalance(BinaryNode<T> t) {

        if(t == null)
            return ;
        
        imbalance(t.left);
        imbalance(t.right);

        int leftHeight = height(t.left);
        int rightHeight = height(t.right);

        if(Math.abs(leftHeight - rightHeight) > ALLOWED_IMBALANCE) {
            pointsOfImbalance.add(t.data);
        } else
            return;

    }

    //public driver for smallestGreaterThan, applies it to the root
    public T smallestGreaterThan(T t) {
        return smallestGreaterThan(t, root);
    }

    //recursively finds the smallest node that has data greater than 't'
    private T smallestGreaterThan(T t, BinaryNode<T> n) {

        if(n == null || ((n.left == null && n.right == null)
            && ((n.data).compareTo(t) < 0)))
            return null;

        if((n.data).compareTo(t) > 0 && n.left == null ||
          (n.data).compareTo(t) > 0 && smallestGreaterThan(t, n.left) == null)
              return n.data;

        if((n.data).compareTo(t) > 0)
            return smallestGreaterThan(t, n.left);
        else 
            return smallestGreaterThan(t, n.right);

    }

    //creates a copy of a binarytree object from its root
    //used to prevent changing our instance when mirroring
    private BinaryNode<T> copy(BinaryNode<T> t) {

        if(t == null)
            return t;

        BinaryNode<T> root = new BinaryNode<>(t.data);
        root.left = copy(t.left);
        root.right = copy(t.right);

        return root;

    }

    //public driver for mirror, creates a copy of our instance tree and
    //applies mirror on the root of this new tree
    public BinarySearchTree<T> mirror() {
        BinarySearchTree<T> mirroredBBST = new BetterBST<>();
        BinaryNode<T> temp = copy(root);
        mirroredBBST.root = mirror(temp);

        return mirroredBBST;
    }

    //mirrors a tree working from its root down
    private BinaryNode<T> mirror(BinaryNode<T> t) {

        if(t == null)
            return t;

        BinaryNode<T> left = mirror(t.left);
        BinaryNode<T> right = mirror(t.right);
        t.left = right;
        t.right = left;

        return t;

    }

    //returns a linked list of the nodes of our tree in level-order
    public LinkedList<BinaryNode<T>> levelOrderTraversal() {

        LinkedList<BinaryNode<T>> tempQueue = new LinkedList<>();
        LinkedList<BinaryNode<T>> levelOrderQueue = new LinkedList<>();

        if(root == null)
            return levelOrderQueue;
        else
            tempQueue.add(root);

        while(!(tempQueue.isEmpty())) {
            BinaryNode<T> temp = tempQueue.poll();
            levelOrderQueue.add(temp);
            
            if(temp == null)
                break;
                
            if(temp.left != null)
                tempQueue.add(temp.left); 
            
            if(temp.right != null)
                tempQueue.add(temp.right);
        }
        return levelOrderQueue;

    }
    
    //public driver for printing the infix of our tree for testing purposes
    public String infix() {
        infixString = "";
        return infix(root);
    }

    //recursively builds up the infix expression then returns it
    private String infix(BinaryNode<T> t) {

        if(t != null) {
            
            infix(t.left);           
            infixString += t.data + " ";
            infix(t.right);   

        }
        //removes any extraneous white space before returning
        return infixString.trim();

    }

}
