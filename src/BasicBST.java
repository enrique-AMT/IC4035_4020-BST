import java.util.Scanner;

public class BasicBST {
	private class BST{
		Node root;
		private class Node{
			int key;
			Node left, right;
			
			private Node(int key){
				this.key=key;
			}
		}
		public BST(int key){
			root= new Node(key);
		}
		
		public Node insert(int key){
			insert(key, root);
			return root;
		}
		public Node insert(int key, Node x){
			if (x == null) {
	            x = new Node(key);
	        }
	        if (key > x.key) {
	           x.right= insert(key, x.right);
	        } else if (key < x.key) {
	           x.left= insert(key, x.left);
	        } else {
	            x.key = key;
	        }
	        return x;
		}
		public void check(int key){
			check(key, root);
		}
		public void check(int key, Node x){
			if(key==x.key){
				System.out.println("yes");
				return;
			}
			if (key > x.key) {
	            check(key, x.right);
	        } 
			else if (key < x.key) {
	            check(key, x.left);
	        } 
	        else {
	            System.out.println("no");
	            return;
	        }
			
		}
	}
	private static int i=0;
	private static BST p;
	public static void main(String[] args){
		Scanner in= new Scanner(System.in);
		while(in.hasNextLine()){
			in.nextLine();
			int m= in.nextInt();
			int n=in.nextInt();
			processor(m, n);
		}
		
	}
	
	public static void processor(int m, int n){
		switch(m){
		case 1: add(n);
		case 2: p.check(n);
		default: return;
		}
	}
	
	private static void check(int n){
		//if contains
		//System.out.println("yes");
		//if not
		p.check(n);
	}
	
	private static void add(int n){
		//adds root if queries==0
		if(i==0)
			p= (new BasicBST()).new BST(n);
		//if not, insert into the BST
		else
		p.insert(n);
	}
	
	
}
