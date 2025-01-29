package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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

        public void SumOfLevel(Node root , int k){
            int level = 0;
            int  sum =  0;
            Queue<Node> q2 = new LinkedList<>();

            q2.add(root);
            q2.add(null);

            while (!q2.isEmpty()) {
                Node currNode = q2.remove();

                if (currNode == null) {

                    level++;

                    if (q2.isEmpty()) {

                        break;

                    }else{

                        q2.add(null);

                    }
                }else{

                    if (level == k) {
                        sum += currNode.data;
                    }

                    if (currNode.left != null) {

                        q2.add(currNode.left);

                    }

                    if (currNode.right != null) {
                    
                        q2.add(currNode.right);
                    
                    }
                }
            }

            System.out.println("The sum of Nodes at level " + level + " is : " + sum);
        }
    
        public int CountOfNode(Node root){
            if (root == null) {
                return 0;
            }

            int leftNodes = CountOfNode(root.left);
            int rightNodes = CountOfNode(root.right);

            return leftNodes + rightNodes + 1;
        }

        public int SumOfNodes(Node root){
            if (root == null) {
                return 0;
            }

            int leftSumOfNodes = SumOfNodes(root.left);
            int rightSumOfNodes = SumOfNodes(root.right);

            return leftSumOfNodes + rightSumOfNodes + root.data;
        }

        public int heightOfTree(Node root){
            if (root == null) {
                return 0;
            }

            int leftHeight = heightOfTree(root.left);
            int rightHeight = heightOfTree(root.right);

            int myHeight = Math.max(leftHeight, rightHeight) + 1;

            return myHeight;
        }

        public class TreeInfo {
            int ht , diam;

            TreeInfo(int ht , int diam){
                this.diam = diam;
                this.ht = ht;
            }
        }

        public TreeInfo diameter(Node root){
            if (root == null) {
                return new TreeInfo(0, 0);
            }

            TreeInfo leftDiam = diameter(root.left);
            TreeInfo rightDiam = diameter(root.right);

            int myHeight2 = Math.max(leftDiam.ht, rightDiam.ht) + 1;

            int diam = leftDiam.diam;
            int diam2 = rightDiam.diam;
            int diam3 = leftDiam.ht + rightDiam.ht + 1;

            int myDiam = Math.max(Math.max(diam, diam2), diam3);
            TreeInfo myInfo = new TreeInfo(myHeight2, myDiam);

            return myInfo;
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

            // Now on its operation on Binary tree
            System.out.println("Operations of Tree:");
            System.out.println("Count of Nodes in a tree: ");
            System.out.println(tree.CountOfNode(root));

            System.out.println("Sum Of Nodes in tree: ");
            System.out.println(tree.SumOfNodes(root));

            System.out.println("Height of tree: ");
            System.out.println(tree.heightOfTree(root));

            System.out.println("Diameter of Tree: ");
            System.out.println(tree.diameter(root).diam);

            System.out.println("Enter the level to calculate sum fo Nodes at that level: ");
            Scanner scanner = new Scanner(System.in);
            int k = scanner.nextInt();
            tree.SumOfLevel(root, k);
            scanner.close();

        }
    }
}
