package listedList;

import java.util.Scanner;

import queue.IntQueue;

public class LinkedList {

	IntListNode head;
	
	public LinkedList() {
		head = null;
	}
	public void insertFirst(int d) {
		IntListNode new_node = new IntListNode(d);
		if(head==null) {
			head = new_node;
			return;
		}
		new_node.setNext(head);
		head = new_node;
		return;
	}
	public void insertLast(int d) {
		IntListNode new_node = new IntListNode( d);
		if(head==null) {
			head=new_node;
			return ;
		}
		IntListNode iter = head;
		
		while(iter!=null) {
			if(iter.getNext()==null) {
				iter.setNext(new_node);
				break;
			}else
			iter = iter.getNext();
		}
		
		
		
		
	}
	public String toString() {
		if(head==null) {
			return "list is empty ";	
		}
		IntListNode iter = head;
		String str = "List: ";
		while(iter!=null) {
			str = str + " -> "+iter.getData();
			iter = iter.getNext();
		}
		return str;
	}

	
	public static void main(String[] args) {
		
		
		Scanner sc= new Scanner(System.in);
		char ch;
		int data=0;
		System.out.println("LinkedList  program");
		LinkedList c= new LinkedList();
		do {
			

			System.out.println("1. InsertFirst");
			System.out.println("2. InsertLast");
			System.out.println("3. Peek");
			System.out.println("4. Display Stack");
			System.out.println("5. Exit");
			ch=sc.next().charAt(0);
			switch (ch) {
			case '1': {
					System.out.println("Enter a Integera to Insert");
					data=sc.nextInt();
					c.insertFirst(data);
					break;
			}
			case '2':{
				System.out.println("Enter a Integera to Insert");
				data=sc.nextInt();
				c.insertLast(data);
				
				break;
			}
			case '3':{
//				data=c.peek();
				if(data!=-999) {
					System.out.println(data+" is at peek");
				}
				break;
			}
			case '4':
				System.out.println(c);
			case '5':
				break;
			default:
				System.out.println("Enter correct Choice");
			}
		}while(ch!='5');
		
		
		sc.close();
	}
}
