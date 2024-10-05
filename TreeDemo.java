package treeDemo;

public class TreeDemo {
	   
	public static void main(String[] args){
		      
		BinarySearchTree t1  = new BinarySearchTree();
		t1.insert( 24);
		t1.insert(80);
		t1.insert(18);
		t1.insert(9);
		t1.insert(90);
		t1.insert(22);
		     
		
		//Traversals
		System.out.println("pre-order :   ");
		t1.preOrderTraversal(t1.root);
		System.out.print("\n");
		
		
		t1.delete(t1.root, 90);
		System.out.println("in-order :   ");
		t1.inOrderTraversal(t1.root);
		System.out.print("\n");
		
		
		System.out.println("Post-order : ");
		t1.postOrderTraversal(t1.root);
		System.out.println("\n");
		
		
		//Test other methods 
		System.out.println("Checking if the value 80 is in the tree : " +t1.find(t1.root, 80) + "\n");
		
		System.out.println("The max integer in the tree is : " + t1.getMax(t1.root) + "\n");
		
		System.out.println("The minimum integer in the tree is : " + t1.getMin(t1.root) + "\n");
		
		System.out.println();
		
		
		           
		     
	
	}  
}

	class BinarySearchTree{

	   Node root;
	  
	   
	   /*
	   recursive insert method
		
	   */
	   /*
	   inserts a node into the tree
	   */
	   public void insert(int value){
	      //tree is empty
	      if(root == null){
	         root = new Node(value);
	         return;
	      }else{
	         Node current = root;
	         Node parent = null;
	         
	         while(true){
	            parent = current;
	            
	            if(value < current.value){
	               current = current.left;
	               if(current == null){
	                  parent.left = new Node(value);
	                  return;
	               }
	            }else{
	               current = current.right;
	               if(current == null){
	                  parent.right = new Node(value);
	                  return;
	               }
	            }
	           
	         }//closing while
	      
	      }//closing main if-else 
	   }
	   
	   /*
	   pre-order traversal
	   Prints the value of every node preorder
	   */
	   public void preOrderTraversal(Node root){
		   //implement in here
	        if (root != null) {
	            System.out.print(root.value + " ");
	            preOrderTraversal(root.left);
	            preOrderTraversal(root.right);
	        }
		   
	   }

	   
	   
	   /*
	   in-order traversal
	   */
	   public void inOrderTraversal(Node root){
		   //implement in here
	        if (root != null) {
	            inOrderTraversal(root.left);
	            System.out.print(root.value + " ");
	            inOrderTraversal(root.right);
	        }
	
	   }
	   
	   
	   
	   /*
	   post-order traversal
	   */
	  
	   public void postOrderTraversal(Node root){
		   //implement in here
	        if (root != null) {
	            postOrderTraversal(root.left);
	            postOrderTraversal(root.right);
	            System.out.print(root.value + " ");
	        }
		   
	   }
	   
	   
	   
	   /*
	   a method to find the node in the tree
	   with a specific value
	   */
	   public boolean find(Node root, int key){
		 //implement in here
	        if (root == null) {
	            return false;
	        }
	        if (root.value == key) {
	            return true;
	        } else if (key < root.value) {
	            return find(root.left, key);
	        } else {
	            return find(root.right, key);
	        }
		  
	   }
	   
	   
	   
	   /*
	   a method to find the node in the tree
	   with a smallest key
	   */
	   public int getMin(Node root){
      //implement in here
	        if (root == null) {
	            return Integer.MIN_VALUE; // or throw an exception
	        }
	        Node current = root;
	        while (current.left != null) {
	            current = current.left;
	        }
	        return current.value;
	      
	   }
	  
	  
	  
	   /*
	   a method to find the node in the tree
	   with a largest key
	   */
	   public int getMax(Node root){
		   //implement in here
	       if (root == null) {
	            return Integer.MAX_VALUE; // or throw an exception
	        }
	        Node current = root;
	        while (current.right != null) {
	            current = current.right;
	        }
	        return current.value;
	   }
	   
	   
	   
	   /*
	   this method will not compile until getMax
	   is implemented
	   */
	   public Node delete(Node root, int key){
	      
	      if(root == null){
	        
	    	  return root;
	      
	      }else if(key < root.value){
	      
	    	  root.left = delete(root.left, key);
	      
	      }else if(key > root.value){
	      
	    	  root.right = delete(root.right, key);
	      
	      }else{
	      
	    	  //node has been found
	         
	    	  if(root.left==null && root.right==null){
	          
	    		//case #1: leaf node
	            root = null;
	         
	    	  }else if(root.right == null){
	          
	    		//case #2 : only left child
	            root = root.left;
	         
	    	  }else if(root.left == null){
	          
	    		//case #2 : only right child
	            root = root.right;
	         
	    	  }else{
	          
	    		//case #3 : 2 children
	            root.value = getMax(root.left);
	            root.left = delete(root.left, root.value);
	         
	    	  }
	      
	      }
	      
	      return root;  
	   
	   }
	   
	   class Node{
		   int value;
		   Node left, right;
		   
		   public Node(int value){
		      this.value = value;
		      left = null;
		      right = null;
		   }

		}
	  
	   
	   
	   
	}