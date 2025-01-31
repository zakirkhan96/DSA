package BinarySearchTrees;

public class BinarySearchTrees {
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

    public void InOrder(Node root){
        if (root == null) {
            return;
        }

        InOrder(root.left);
        System.out.print(root.data + " ");
        InOrder(root.right);
    }

    public void searchTree(Node root , int data){
        if (root.data == data) {
            System.out.println("Data is Found: " + root.data);
            return;
        }
        if (root.data > data) {
            searchTree(root.left, data);
            return;
        }
        if(root.data < data){
            searchTree(root.right, data);
            return;
        }else{
            System.out.println("Data not found: " + data);
            return;
        }
    }

    public void main(String[] args) {
        int nodes[] = {5 , 1 , 3 , 4, 2 , 7};

        Node root = null;

        for (int i = 0; i < nodes.length; i++) {
            root = buildTree(root , nodes[i]);
        }

        InOrder(root);
        System.out.println();

        searchTree(root, 1);
        searchTree(root, 7);
        searchTree(root, 3);
        searchTree(root, 9);
    }
}