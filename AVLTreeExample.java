// Name: John Kerstetter
// Class: CS 240
// Assignment: Lab 5

import java.util.Random;

public class AVLTreeExample {

    // main method
    public static void main(String[] args) {
        AVLNode rootNode = new AVLNode(0);

        Random rand = new Random();
        
        for (int i: rand.ints(50, 0, 100).toArray()) {
            rootNode = AVLTree.insert(rootNode, i);
        }

        // rootNode = AVLTree.insert(rootNode, 10);
        // rootNode = AVLTree.insert(rootNode, 20);
        // rootNode = AVLTree.insert(rootNode, 25);
        // rootNode = AVLTree.insert(rootNode, 30);
        // rootNode = AVLTree.insert(rootNode, 40);
        // rootNode = AVLTree.insert(rootNode, 50);

        AVLTree.traverseInOrder(rootNode);
    }
}
