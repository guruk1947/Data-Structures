package binaryTree;

import java.util.Scanner;

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
	public static void main(String[] args) {
		BinaryTree b=new BinaryTree();
		b.setRoot(b.createNode(10));
		b.getRoot().setLeft(b.createNode(20));
		b.getRoot().getLeft().setLeft(b.createNode(30));
		b.getRoot().getLeft().setRight(b.createNode(40));
		b.getRoot().setRight(b.createNode(50));
		b.getRoot().getRight().setRight(b.createNode(60));
		Scanner sc= new Scanner(System.in);
		System.out.println("Binary tree traversal program");
		String ch;
		do {
			System.out.println("\n\n");
			System.out.println("01. PreOrder Traversal");
			System.out.println("02. InOrder Traversal");
			System.out.println("03. PostOrder Traversal");
			System.out.println("04. Exit");
			System.out.println("Enter your choice");
			ch=sc.next();
			switch (ch) {
				case "1": {
						b.preOrder();
						break;
				}
				case "2":{
					b.inOrder();
					
					break;
				}
				case "3":{
					b.postOrder();
					
					break;
				}
				case "4":{
					break;
				}
				default: System.out.println("Invalid entry...");
			}
		}while(!ch.equals("4"));
		sc.close();
	}
	
}
