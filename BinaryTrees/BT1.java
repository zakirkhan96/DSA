package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class BT1 {
    public static class Node {
        int data;
        Node left , right;

        Node(int data){
            this.data = data;
            this.right = this.left = null;
        }
    }

    public static class BinaryTree {

        static int index = -1;
        
        public Node buildtree (int nodes[]){
            index++;
            
            if (nodes[index] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[index]);
            newNode.left = buildtree(nodes);
            newNode.right = buildtree(nodes);

            return newNode;
        }

        public void preOrder(Node root){
            if (root == null) {
                return;
            }

            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public  void inOrder(Node root){
            if (root == null) {
                return;
            }

            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public void postOrder(Node root){
            if (root == null) {
                return;
            }
        
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public void levelOrder(Node root){
            Queue<Node> q = new LinkedList<>();

            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();

                if (currNode == null) {

                    System.out.println();

                    if (q.isEmpty()) {

                        break;

                    }else{

                        q.add(null);

                    }
                }else{

                    System.out.print(currNode.data + " ");

                    if (currNode.left != null) {

                        q.add(currNode.left);

                    }

                    if (currNode.right != null) {
                    
                        q.add(currNode.right);
                    
                    }
                }
            }
        }
    
        
        public static void main(String[] args) {
            int nodes[] = {1 , 2 , 4 , -1 , -1 , 5 , -1 , -1 , 3 , -1 , 6 , -1 , -1};
        
            BinaryTree tree = new BinaryTree();
            Node root = tree.buildtree(nodes);
        
            System.out.println("Post-Order traversal: ");
            tree.postOrder(root);
            System.out.println("");
            System.out.println("In-Order traversal: ");
            tree.inOrder(root);
            System.out.println("");
            System.out.println("Pre-Order traversal");
            tree.preOrder(root);
            System.out.println("Level-Order traversal: ");
            tree.levelOrder(root);

        }
    }
}
