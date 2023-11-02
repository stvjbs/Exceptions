package org.RedBlackTree;

public class Main<V extends Comparable<V>> {
    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();
        rbt.add(5);
        rbt.add(3);
        rbt.add(7);
        rbt.add(1);
        rbt.add(4);
        rbt.printColorTree();
    }
}
