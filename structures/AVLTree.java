package structures;

import java.util.ArrayList;

public class AVLTree<E extends Comparable<E>> {


    private class AVLNode<E> {
        private int height;
        private E data;
        private AVLNode<E> left, right;
        public int repeated;
        public AVLNode(E data) {
            this.data = data; repeated=1;
        }

    }

    public AVLNode<E> root;

    private int height(AVLNode<E> n) {
        return n == null ? -1 : n.height;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    private int getBalance(AVLNode<E> n) {
        return n == null ? 0 : height(n.left) - height(n.right);
    }

    private AVLNode<E> leftRotate(AVLNode<E> x) {
        AVLNode<E> y = x.right;
        AVLNode<E> z = y.left;

        y.left = x;
        x.right = z;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        return y;
    }

    private AVLNode<E> rightRotate(AVLNode<E> y) {
        AVLNode<E> x = y.left;
        AVLNode<E> z = x.right;
        x.right = y;
        y.left = z;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        return x;
    }

    public void insert(E data) {
        if (data == null) throw new IllegalArgumentException();
        root = insertHelper(root, data);
    }

    private AVLNode<E> insertHelper(AVLNode<E> n, E data) {
        if (n == null) return new AVLNode<>(data);
        if(n.data.compareTo(data)==0)findAny(n);
        if (n.data.compareTo(data) > 0) n.left = insertHelper(n.left, data);
        else if (n.data.compareTo(data) < 0) n.right = insertHelper(n.right, data);

        n.height = 1 + max(height(n.left), height(n.right));

        int balance = getBalance(n);

        if (balance > 1 && n.left.data.compareTo(data) > 0) return rightRotate(n);
        else if (balance < -1 && n.right.data.compareTo(data) < 0) return leftRotate(n);
        else if (balance > 1 && n.left.data.compareTo(data) < 0) {
            n.left = leftRotate(n.left);
            return rightRotate(n);
        }
        else if (balance < -1 && n.right.data.compareTo(data) > 0) {
            n.right = rightRotate(n.right);
            return leftRotate(n);
        }
        return n;
    }

    public void findAny(AVLNode<E> node){
        AVLNode<E> tmp = this.root;
        while(tmp!=null){
            if(node.data.compareTo(tmp.data)==0){
                tmp.repeated++;
                return;
            }
            else if(node.data.compareTo(tmp.data)>0){
                tmp = tmp.right;
            }
            else{
                tmp = tmp.left;
            }
        }
    }


    public void delete(E data) {
        if (data == null) throw new IllegalArgumentException();
        root = deleteHelper(root, data);
    }

    private AVLNode<E> deleteHelper(AVLNode<E> node, E data) {
        if (node.data.compareTo(data) > 0) node.left = deleteHelper(node.left, data);
        else if (node.data.compareTo(data) < 0) node.right = deleteHelper(node.right, data);
        else {
            if (node.left == null && node.right == null) {
                node = null;
            } else if (node.left == null || node.right == null) {
                if (node.left != null) node = node.left;
                else node = node.right;
            } else {
                AVLNode<E> p = findMin(node.left);
                node.data = p.data;
                node.left = deleteHelper(node.left, p.data);
            }
        }

        if (node == null) return null;
        node.height = max(height(node.left), height(node.right)) + 1;
        int balance = getBalance(node);

        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return node;
    }


    public void preOrden(AVLNode root){
        if(root!=null) {
            System.out.println(root.data+" ,");
            preOrden(root.left);
            preOrden(root.right);
        }
    }

    public void postOrden(AVLNode root){
        if(root!=null){
            postOrden(root.left);
            postOrden(root.right);
            System.out.println(root.data+" ,");
        }
    }

    public void niveles(AVLNode root){
        ArrayList<AVLNode> stack = new ArrayList<>();
        stack.add(root);
        while(!stack.isEmpty()){
            if(stack.get(0)!=null){
                AVLNode aux = stack.get(0);
                System.out.println("--------");
                System.out.println(aux.data);
                if(aux.left!=null) System.out.println(" hijoIzq: "+aux.left.data);
                if(aux.right!=null)System.out.println(" hijoDerecho: "+aux.right.data);
                System.out.println("---------");
                stack.add(aux.left);
                stack.add(aux.right);
                stack.remove(0);
            }
            else{
                stack.remove(0);
            }
        }
    }

    public void inorder(AVLNode root){
        if(root!=null){
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }


    public String findMinRepeated(){
        AVLNode tmp = this.findMin(this.root);
        if(tmp==null)return "0";
        return tmp.data.toString()+" "+tmp.repeated;
    }
    private AVLNode<E> findMin(AVLNode<E> node) {
        if (node==null)return null;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public String findMaxRepeated(){
        AVLNode tmp = this.findMax(this.root);
        if(tmp==null)return "0";
        return tmp.data.toString()+" "+tmp.repeated;
    }
    private AVLNode<E> findMax(AVLNode<E> node) {
        //System.out.println("aa "+node.data);
        if(node==null)return null;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public int findAnyRepeated(E data){
        AVLNode<E> node = new AVLNode<>(data);
        AVLNode<E> tmp = this.root;
        while(tmp!=null){
            if(node.data.compareTo(tmp.data)==0){
                return tmp.repeated;
            }
            else if(node.data.compareTo(tmp.data)>0){
                tmp = tmp.right;
            }
            else{
                tmp = tmp.left;
            }
        }
        return 0;
    }

    public int findAnyHeight(E data){
        AVLNode<E> node = new AVLNode<>(data);
        AVLNode<E> tmp = this.root;
        while(tmp!=null){
            if(node.data.compareTo(tmp.data)==0){
                return tmp.height;
            }
            else if(node.data.compareTo(tmp.data)>0){
                tmp = tmp.right;
            }
            else{
                tmp = tmp.left;
            }
        }
        return -1;
    }

    public AVLNode getNode(AVLNode<E> node){
        AVLNode<E> tmp = this.root;
        while(tmp!=null){
            if(node.data.compareTo(tmp.data)==0){
                return tmp;
            }
            else if(node.data.compareTo(tmp.data)>0){
                tmp = tmp.right;
            }
            else{
                tmp = tmp.left;
            }
        }
        return null;
    }

    public int inorderNodes(E string){
        AVLNode tmp = new AVLNode(string);
        tmp = getNode(tmp);
        if(tmp == null)return 0;
        return inorderNodes(tmp);
    }
    public int inorderNodes(AVLNode root){
        if(root!=null){
            return inorderNodes(root.left)+inorderNodes(root.right)+1;
        }
        return 0;
    }


}