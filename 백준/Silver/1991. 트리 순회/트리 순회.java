import java.io.*;
import java.util.*;

class Main{
    
    static Node head = new Node('A', null, null);
    
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        while(n --> 0){
            st = new StringTokenizer(br.readLine());
            
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            
            insertNode(head, root, left, right);
        }
        
        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
        System.out.println();
    }
    
    static class Node{
        char parent;
        Node left, right;
        
        public Node(char parent, Node left, Node right){
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }
    
    static void insertNode(Node temp, char root, char left, char right){
        if(temp.parent == root){
            temp.left = (left == '.' ? null : new Node(left, null, null));
            temp.right = (right == '.' ? null : new Node(right, null, null));
        }
        else{
            if(temp.left != null) insertNode(temp.left, root, left, right);
            if(temp.right != null) insertNode(temp.right, root, left, right);
        }
    }
    
    static void preOrder(Node node){
        if(node == null) return;
        System.out.print(node.parent);
        preOrder(node.left);
        preOrder(node.right);
    }
    
    static void inOrder(Node node){
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.parent);
        inOrder(node.right);
    }
    
    static void postOrder(Node node){
        if(node == null) return;
        postOrder(node.left);       
        postOrder(node.right);
        System.out.print(node.parent);
    }
}