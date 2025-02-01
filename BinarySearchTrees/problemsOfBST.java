package BinarySearchTrees;

import java.util.ArrayList;

public class problemsOfBST {
    public class Node {
        int data;
        Node left , right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public Node buildTree(Node root , int data){
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (root.data > data) {
            root.left = buildTree(root.left, data);
        }else{
            root.right = buildTree(root.right, data);
        }

        return root;
    }

    public void printInOrder(Node root){
        if (root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    public Node Delete(Node root , int val){

        if (root.data > val) {
            root.left = Delete(root.left, val);
        }

        else if (root.data < val) {
            root.right = Delete(root.right, val);
        }
        else{

            if (root.left == null && root.right == null ) {
                return null;
            }

            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }

            Node IOS = inOrderSuccessor(root.right);
            root.data = IOS.data;
            root.right = Delete(root.right, IOS.data);
        }

        return root;
    }

    public Node inOrderSuccessor(Node root){
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public void printInRange(Node root , int x , int y){
        if (root == null) {
            return;
        }

        if (root.data >= x && root.data <= y) {
            printInRange(root.left, x, y);
            System.out.print(root.data + " ");
            printInRange(root.right, x, y);
        }
        else if (root.data >= y) {
            printInRange(root.left, x, y);
        }
        else{
            printInRange(root.right, x, y);
        }
    }

    public void printRoot2Leaf(Node root , ArrayList<Integer> path){
        if (root == null) {
            return;
        }

        path.add(root.data);

        if (root.left == null && root.right == null) {
            printPath(path);
        }else{
            printRoot2Leaf(root.left, path);
            printRoot2Leaf(root.right, path);
        }
        path.remove(path.size() - 1);
    }

    public void printPath(ArrayList<Integer> path){
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }

    public void main(String[] args) {
        int nodes[] = {5 , 1 , 3 , 4, 2 , 7};

        Node root = null;

        for (int i = 0; i < nodes.length; i++) {
            root = buildTree(root , nodes[i]);
        }

        // print In-Order list of Nodes of tree
        printInOrder(root);
        System.out.println();

        // Deleting a Node in BST
        Delete(root, 3);
        printInOrder(root);

        // print a NODE in GIVEN RANGE
        printInRange(root, 3, 5);

        // Print path from root to Every leaf Node
        printRoot2Leaf(root, new ArrayList<>());

    }
}