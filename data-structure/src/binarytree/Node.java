package binarytree;

import java.util.Scanner;

public class Node {
    Node left;
    Node right;
    int data;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void insert(int value) {
        if (value <= this.data) {
            if (this.left == null) {
                left = new Node(value);
            } else {
                left.insert(value);
            }
        } else {
            if (this.right == null) {
                right = new Node(value);
            } else {
                right.insert(value);
            }
        }
    }

    public boolean contain(int value) {
        if (value == this.data) {
            return true;
        } else if (value < this.data) {
            if (this.left == null) {
                return false;
            } else {
                return this.left.contain(value);
            }
        } else {
            if (this.right == null) {
                return false;
            } else  {
                return this.right.contain(value);
            }
        }
    }

    public void printInorder() {
        if (this.left != null) {
            this.left.printInorder();
        }
        System.out.println(this.data);
        if (this.right != null) {
            this.right.printInorder();
        }
    }

    public boolean checkBinarySearchTree(Node root) {
        return checkBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean checkBinarySearchTree(Node root, int min, int max) {
        if (root == null) { // reach to left or right == null, return true
            return true;
        }
        if (root.data < min || root.data > max) {
            return false;
        }
        return checkBinarySearchTree(root.left, min, root.data - 1) && checkBinarySearchTree(root.right, root.data + 1, max);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Node root = new Node(scanner.nextInt());
        while(scanner.hasNextInt()) { // exit: ctrl + D (EOF - 입력 종료)
            int value = scanner.nextInt();
            root.insert(value);
        }
        scanner.close();

        root.printInorder();

        System.out.println("Is Binary Search Tree? " + root.checkBinarySearchTree(root));
    }
}
