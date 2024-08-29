package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import listedList.LinkedList;

public class BinaryTree {

	private BTNode root=null;

	public BTNode getRoot() {
		return root;
	}

	public void setRoot(BTNode root) {
		this.root = root;
	}
	public BTNode createNode(int d) {
		return new BTNode(d);
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
	public void insert_level_wise(int d) {
		BTNode new_node= new BTNode(d);
		if(root==null) {
			root=new_node;
			return;
		}
		BTNode itr=root;
		BTQueueLL q=new BTQueueLL();
		q.enQueue(itr);
		while(!q.isEmpty()) {
			itr=q.deQueue();
			if(itr.getLeft()==null) {
				itr.setLeft(new_node);
				return;
			}else {
				q.enQueue(itr.getLeft());
			}
			if(itr.getRight()==null) {
				itr.setRight(new_node);
				return;
			}else {
				q.enQueue(itr.getRight());
			}
		}
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
	public static boolean isIdentical(BinaryTree t1, BinaryTree t2) {
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
		int cnt=0;
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
	
	public static void main(String[] args) {
		Queue <BinaryTree> q=new java.util.LinkedList<BinaryTree>();
		
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
				BinaryTree b=new BinaryTree();
				q.add(b);
				int data;
				do {
					System.out.println("\n\n");
					System.out.println("01. Insert level wise");
					System.out.println("02. PreOrder Traversal Display");
					System.out.println("03. InOrder Traversal Display");
					System.out.println("04. PostOrder Traversal Display");
					System.out.println("05. Display level wise");
					System.out.println("06. Mirror the tree");
					System.out.println("07. Count tree levels");
					System.out.println("08. Exit");
					System.out.println("Enter your choice");
					ch2=sc.next();
					switch (ch2) {
						case "1": {
							System.out.print("Enter integer to insert: ");
							data=sc.nextInt();
							b.insert_level_wise(data);
							
							break;	
							
							
						}
						case "2":{
							b.preOrder();
							break;
						}
						case "3":{
							b.inOrder();
							
							break;
						}
						case "4":{
							b.postOrder();
							
							break;
						}
						case "5":{
							b.display_level_wise();
							
							break;
						}
						case "6":{
							b.mirror();
							break;
						}
						case "7":{
							int cnt=b.levelCount();
							if(cnt==-1) System.out.println("Tree not present");
							else System.out.println("Level count: "+cnt);
						}
						case "8":{
							break;
						}
						default: System.out.println("Invalid entry...");
					}
				}while(!ch2.equals("8"));
				break;
			}
			case "2":{
				int treeCnt=0;
				BinaryTree t1,t2;
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
