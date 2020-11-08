public class AVLNode<T extends Comparable<?super T>>{
    public T value;
    public AVLNode<T> leftSon;
    public AVLNode<T> rightSon;
    public int height;

    public AVLNode(T value){
        this.value = value;
        this.leftSon = null;
        this.rightSon = null;
        this.height = -1;
    }
}

public class AVLTree<T extends Comparable<?super T>> {

    public AVLNode<T> root;

    public AVLTree(){
        this.root = null;
    }
   public void rotateRight(AVLNode y) {
    	ode x = y.left;
    		Node z = x.right;
    	x.right = y;
    	y.left = z;
    	updateHeight(y);
    	updateHeight(x);
    	return x;
    }
    public void rotateLeft(AVLNode y) {
    	Node x = y.right;
   	Node z = x.left;
    	x.left = y;
    	y.right = z;
    	updateHeight(y);
    	updateHeight(x);
    	return x;;
    }
    public void Treerebalance(Node z) {
    	updateHeight(z);
    	int balance = getBalance(z);
    	if (balance > 1) {
        	if (height(z.right.right) > height(z.right.left)) {
            		z = rotateLeft(z);
        	} else {
            	z.right = rotateRight(z.right);
            	z = rotateLeft(z);
       		 }
    	} else if (balance < -1) {
        	if (height(z.left.left) > height(z.left.right))
            		z = rotateRight(z);
        	else {
            		z.left = rotateLeft(z.left);
            		z = rotateRight(z);
        }
    }
    	return z;
    }

    public void Treedelete(AVLNode node, int key) {
    	if (node == null) {
        	return AVLnode;
    	} else if (node.key > key) {
        	node.left = delete(node.left, key);
    	} else if (node.key < key) {
        	node.right = delete(node.right, key);
    	} else {
        	if (node.left == null || node.right == null) {
            		node = (node.left == null) ? node.right : node.left;
        	} else {
            		AVLNode mostLeftChild = mostLeftChild(node.right);
            		node.key = mostLeftChild.key;
            		node.right = delete(node.right, node.key);
       		}
    	}
    	if (node != null) {
        	node = rebalance(node);
    	}
    	return AVLnode;
	}




    public void insert(T value){
        this.root = this.insert(value, this.root);
    }

    private AVLNode<T> insert(T value, AVLNode<T> node){
        if(node == null){
            return new AVLNode<>(value);
        }else{
            int resultCompare = node.value.compareTo(value);
            if(resultCompare == 1) {
                node.leftSon = this.insert(value, node.rightSon);
            }  // > - 1
            else if(resultCompare == -1) {
                node.rightSon = this.insert(value, node.leftSon);
            } // < -1
            else {}
            return node; // == 0
        }
    }
	

   

    public T findMin(){
        return this.findMin(this.root).value;
    }

    private AVLNode<T> findMin(AVLNode<T> node){
        if(node.leftSon == null)
            return node;
        else
            return this.findMin(node.leftSon);
    }

    public T findMax(){
        return this.findMin(this.root).value;
    }

    public AVLNode<T> findMax(AVLNode<T> node){
        if(node.rightSon == null)
            return node;
        else
            return this.findMin(node.rightSon);
    }

    //public boolean contains(T value){

    //}

    public void makeEmpty(){
        this.root = null;
    }

    public boolean isEmpty(){
        return this.root == null;
    }
    
    public void preOrder(TreeNode<T>root) {
        if(root!=null){
		System.out.print(root.value +", ");
		preOrder(root.leftSon);
		preOrder(root.rightSon);
        }
    }
 
    public void postOrder(TreeNode<T>root) {
        if(root!=null){
		postOrder(root.leftSon);
		postOrder(root.rightSon);
        System.out.print(root.value +", ");
        }
    }
 
    public void InOrder(TreeNode<T>root) {
        if(root!=null){
		InOrder(root.leftSon);
		System.out.print(root.value +", ");
        InOrder(root.rightSon);
        }
        
    }
    
    public void levelOrder(TreeNode<T>root) {
        Queue<TreeNode<String>> cola =new Queue <> ();
	    cola.enqueue(root.value);
	    While(!cola.isEmpty()); {
		    TreeNode<String> aux=cola.dequeue();
		    System.out.print(aux.value +", ");
		    If (aux.leftSon != null); {
			    cola.enqueue (aux.leftSon);
		    }
		    If (aux.rightSon != null); {
			cola.enqueue (aux.rightSon);
		    }
        }

    }   
}


class TreeNode<T>{
    public T value;
    public TreeNode<T> leftSon;
    public TreeNode<T> rightSon;
    TreeNode(T value){
        this.value = value;
    }
}

