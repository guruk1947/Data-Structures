package binarySearchTree;

import java.util.Queue;
import java.util.Scanner;

import binaryTree.BTNode;
import binaryTree.BTQueueLL;


public class BST {

	private BTNode root;
	
	public BST() {
		root = null;
	}
	public BTNode getRoot() {
		return root;
	}
	public void setRoot(BTNode root) {
		this.root = root;
	}
	public void preOrder() {
		preOrderTraversal(root);
	}
	private void preOrderTraversal(BTNode r) {
		if(r==null) return;
		System.out.print(" ->"+r.getData());
		preOrderTraversal(r.getLeft());
		preOrderTraversal(r.getRight());
	}
	public void inOrder() {
		inOrderTraversal(root);
	}
	private void inOrderTraversal(BTNode r) {
		if(r==null) return;
		
		inOrderTraversal(r.getLeft());
		System.out.print(" ->"+r.getData());
		inOrderTraversal(r.getRight());
	}
	public void postOrder() {
		postOrderTraversal(root);
	}
	private void postOrderTraversal(BTNode r) {
		if(r==null) return;
		
		postOrderTraversal(r.getLeft());
		
		postOrderTraversal(r.getRight());
		System.out.print(" ->"+r.getData());
	}
	public static boolean isIdentical(BST t1, BST t2) {
		if(t1.getRoot()==null || t2.getRoot()==null)
			return false;
		BTNode itr1=t1.getRoot();
		BTNode itr2=t2.getRoot();
		Queue <BTNode> q1=new java.util.LinkedList<BTNode>();
		Queue <BTNode> q2=new java.util.LinkedList<BTNode>();
		q1.add(itr1);
		q2.add(itr2);
		while(!q1.isEmpty() && !q2.isEmpty()) {
			itr1=q1.remove();
			itr2=q2.remove();
			if(itr1.getData() != itr2.getData())
				return false;
			if(itr1.getLeft()!=null)
				q1.add(itr1.getLeft());
			if(itr1.getRight()!=null)
				q1.add(itr1.getRight());
			if(itr2.getLeft()!=null)
				q2.add(itr2.getLeft());
			if(itr2.getRight()!=null)
				q2.add(itr2.getRight());
		}
		if(q1.isEmpty() && q2.isEmpty())
			return true;		
		return false;
	}
	private void swap(BTNode n) {
		BTNode temp=n.getLeft();
		n.setLeft(n.getRight());
		n.setRight(temp);
	}
	public void mirror() {
		if(root==null) return;
		BTNode itr=root;
		Queue <BTNode> q=new java.util.LinkedList<BTNode>();
		q.add(itr);
		while(!q.isEmpty()) {
			itr=q.remove();
			swap(itr);
			if(itr.getLeft()!=null)
				q.add(itr.getLeft());
			if(itr.getRight()!=null)
				q.add(itr.getRight());
		}
	}
	public int levelCount() {
		if(root ==null) return -1;
		BTNode itr=root;
		int cnt=-1;
		Queue <BTNode> q=new java.util.LinkedList<BTNode>();
		BTNode dummy= new BTNode(-99);
		q.add(itr);
		q.add(dummy);
		while(!q.isEmpty()){
			itr=q.remove();
			if(itr.getData()==-99) {
				q.add(dummy);
				cnt++;
				itr=q.remove();
			}
			if(itr.getLeft()!=null)
				q.add(itr.getLeft());
			if(itr.getRight()!=null)
				q.add(itr.getRight());
		}
		return cnt;
	}
	public void insert_NonRecursive(int d) {
		BTNode new_node = new BTNode(d);
		if(root==null) {
			root=new_node;
			return;
		}
		BTNode itr=root;
		BTNode parent=root;
		while(itr!=null) {
			parent=itr;
			if(d<itr.getData())
				itr=itr.getLeft();
			else if(d>itr.getData())
				itr=itr.getRight();
			else {
				System.out.println("Duplicate entry...");
				return;
			}
		}
		if(d<parent.getData())
			parent.setLeft(new_node);
		else
			parent.setRight(new_node);
	}
	public boolean BSTSearch(int d) {
		if(root==null) return false;
		BTNode itr=root;
		while(itr!=null) {
			if(itr.getData()==d)
				return true;
			else if(d<itr.getData())
				itr=itr.getLeft();
			else
				itr=itr.getRight();
		}
		return false;
	}
	public void insertRecursiveWrapper(int d) {
		root=insertRecursive(root, d);
	}
	private BTNode insertRecursive(BTNode r, int d) {
		if(r==null)
			return new BTNode(d);
		else if(d<r.getData())
			r.setLeft(insertRecursive(r.getLeft(), d));
		else if(d>r.getData())
			r.setRight(insertRecursive(r.getRight(), d));
		else
			System.out.println("Duplicate Data..");
		return r;
	}
	public int findHeightWrapper() {
		return findHeight(root);
	}
	private int findHeight(BTNode r) {
		int h_left, h_right;
		if(r==null) return 0;
		h_left=findHeight(r.getLeft());
		h_right=findHeight(r.getRight());
		if(h_left>h_right)
			return h_left+1;
		else
			return h_right+1;
	}
	public void display_level_wise() {
		if(root==null) {
			return;
		}
		BTNode itr=root;
		BTQueueLL q=new BTQueueLL();
		q.enQueue(itr);
		while(!q.isEmpty()) {
			itr=q.deQueue();
			System.out.println(itr.getData());
			if(itr.getLeft()!=null) {
				q.enQueue(itr.getLeft());
			}
			if(itr.getRight()!=null) {
				q.enQueue(itr.getRight());
			}
		}
	}
	public int min() {
		int min=0;
		if(root==null) return min;
		BTNode itr=root;
		while(itr.getLeft()!=null)
			itr=itr.getLeft();
		min=itr.getData();
		return min;
	}
	public int max() {
		int max=0;
		if(root==null) return max;
		BTNode itr=root;
		while(itr.getRight()!=null)
			itr=itr.getRight();
		max=itr.getData();
		return max;
	}
	public void delWrap(int d) {
		root=delete(root, d);
	}
	private BTNode delete(BTNode r, int d) {
		if(r==null) {
			System.out.println("Data not found...");
			return null;
		}
		BTNode deletable, succ;
		if(d<r.getData())
			r.setLeft(delete(r.getLeft(), d));
		else if(d>r.getData())
			r.setRight(delete(r.getRight(), d));
		else {
			if(r.getLeft()!=null && r.getRight()!=null) {
				succ=r.getRight();
				while(succ.getLeft()!=null)
					succ=succ.getLeft();
				r.setData(succ.getData());
				r.setRight(delete(r.getRight(), succ.getData()));
			}
			else {
				deletable=r;
				if(r.getLeft()!=null)
					r=r.getLeft();
				else if(r.getRight()!=null)
					r=r.getRight();
				else
					r=null;
			}
				
		}
		deletable=null;
		
		return r;
	}
	
	public static void main(String[] args) {
		Queue <BST> q=new java.util.LinkedList<BST>();
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Binary tree program");
		String ch1, ch2;
		do {
			System.out.println("01. Add a Binary Tree");
			System.out.println("02. Check if initial 2 trees are idential");
			System.out.println("03. Exit");
			System.out.println("Enter your choice");
			ch1=sc.next();
			switch (ch1) {
			case "1":{
				BST b=new BST();
				q.add(b);
				int data;
				do {
					System.out.println("\n\n");
					System.out.println("01. Insert Non Recursive");
					System.out.println("02. Search data Non Recursive");
					System.out.println("03. Insert Recursive");
					System.out.println("04. Find Height");
					System.out.println("05. PreOrder Traversal Display");
					System.out.println("06. InOrder Traversal Display");
					System.out.println("07. PostOrder Traversal Display");
					System.out.println("08. Display level wise");
					System.out.println("09. Mirror the tree");
					System.out.println("10. Count tree levels");
					System.out.println("11. Find min");
					System.out.println("12. Find max");
					System.out.println("13. Delete a node");
					System.out.println("14. Exit");
					System.out.println("Enter your choice");
					ch2=sc.next();
					switch (ch2) {
						case "1": {
							System.out.print("Enter integer to insert: ");
							data=sc.nextInt();
							b.insert_NonRecursive(data);
							break;
						}
						case "2":{
							System.out.print("Enter integer to search: ");
							data=sc.nextInt();
							if(b.BSTSearch(data))
								System.out.println(data+" is present");
							else
								System.out.println(data+" is absent");
							break;
						}
						case "3":{
							System.out.print("Enter integer to insert: ");
							data=sc.nextInt();
							b.insertRecursiveWrapper(data);
							break;
						}
						case "4":{
							System.out.println("Height of BST is: "+b.findHeightWrapper());
							break;
						}
						case "5":{
							b.preOrder();
							break;
						}
						case "6":{
							b.inOrder();
							
							break;
						}
						case "7":{
							b.postOrder();
							
							break;
						}
						case "8":{
							b.display_level_wise();
							
							break;
						}
						case "9":{
							b.mirror();
							break;
						}
						case "10":{
							int cnt=b.levelCount();
							if(cnt==-1) System.out.println("Tree not present");
							else System.out.println("Level count: "+cnt);
						}
						case "11":{
							int min=b.min();
							if(min==0)
								System.out.println("Null tree...");
							else
								System.out.println("Min: "+min);
							break;
						}
						case "12":{
							int max=b.max();
							if(max==0)
								System.out.println("No tree Found");
							else
								System.out.println("MAX: "+max);
							break;
						}
						case "13":{
							System.out.print("Enter integer to delete: ");
							data=sc.nextInt();
							b.delWrap(data);
							break;
						}
						
						case "14":{
							break;
						}
						default: System.out.println("Invalid entry...");
					}
				}while(!ch2.equals("14"));
				break;
			}
			case "2":{
				int treeCnt=0;
				BST t1,t2;
				if(!q.isEmpty()) {
					t1=q.remove();
					treeCnt++;
					if(!q.isEmpty()) {
						t2=q.remove();
						treeCnt++;
						if(isIdentical(t1, t2))
							System.out.println("Trees are Identical");
						else
							System.out.println("Trees are not identical");
					}
				}
				
				if(treeCnt!=2)
					System.out.println("Two Binary trees are not available");
				break;
				
			}
			case "3": break;
			default: System.out.println("Enter correct choice");
			}
		}while(!ch1.equals("3"));
			
		sc.close();
	}
}
