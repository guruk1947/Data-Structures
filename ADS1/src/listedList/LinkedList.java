package listedList;

import java.util.Scanner;



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
		
	public void insertByPos(int d, int pos) {
		IntListNode new_node = new IntListNode(d);
		if(head==null) {
			head=new_node;
			return;
		}
		if(pos==1) {
			new_node.setNext(head);
			return;
		}
		IntListNode itr =head;
		for(int i=1; i<pos-1 && itr.getNext()!=null; i++,itr=itr.getNext());
		new_node.setNext(itr.getNext());
		itr.setNext(new_node);
				
	}
	
	public int deleteFirst() {
		int d=-999;
		IntListNode deletable;
		if(head==null)
			return d;
		if(head.getNext()==null) {
			d=head.getData();
			head=null;
			return d;
		}
		deletable=head;
		d=head.getData();
		head=head.getNext();
		deletable=null;
		return d;
	}
	
	public int deleteLast() {
		int d=-999;
		IntListNode deletable;
		if(head==null)
			return d;
		if(head.getNext()==null) {
			d=head.getData();
			head=null;
			return d;
		}
		IntListNode itr=head;
		while(itr.getNext().getNext()!=null) {
			itr=itr.getNext();
		}
		deletable=itr.getNext();
		d=deletable.getData();
		deletable=null;
		itr.setNext(deletable);
		return d;
	}
	
	public int deleteByPos(int pos) {
		int d=-999;
		IntListNode deletable;
		if(head==null)
			return d;
		if(pos==1) {
			d=head.getData();
			deletable=head;
			head=head.getNext();
			deletable=null;
			return d;
		}
		IntListNode itr= head;
		for(int i=1; i<pos-1 && itr.getNext()!=null; i++, itr=itr.getNext());
		if(itr.getNext()!=null) {
			deletable=itr.getNext();
			d=deletable.getData();
			itr.setNext(deletable.getNext());
			deletable=null;
		}
		return d;
	}
	public void insertBefore(int d, int before) {
		IntListNode new_node= new IntListNode(d);
		if(head==null)
			return;
		if(head.getData()==before) {
			new_node.setNext(head);
			head=new_node;
			return;
		}
		IntListNode itr= head;
		while(itr.getNext()!=null && itr.getNext().getData()!=before) {
			itr=itr.getNext();
		}
		if(itr.getNext()!=null) {
			new_node.setNext(itr.getNext());
			itr.setNext(new_node);
		}
	}
	
	public void insertSorted(int d) {
		IntListNode new_node = new IntListNode(d);
		if(head==null || d<head.getData()) {
			new_node.setNext(head);
			head=new_node;
			return;
		}
		IntListNode itr=head;
		while(itr.getNext()!=null && d>itr.getNext().getData()) {
			itr=itr.getNext();
		}
		new_node.setNext(itr.getNext());
		itr.setNext(new_node);
		
	}
	public int count() {
		int cnt=0;
		if(head==null)
			return 0;
		IntListNode itr=head;
		while(itr!=null) {
			cnt++;
			itr=itr.getNext();
		}
		return cnt;
	}
	public void reverseList() {
		IntListNode prev=null, next, itr=head;
		while(itr!=null) {
			next=itr.getNext();
			itr.setNext(prev);
			prev=itr;
			itr=next;
		}
		head=prev;
	}
	public void displayAlternate() {
		if(head==null) {
			System.out.println("Empty list");
			return;
		}
		IntListNode itr= head;
		while(itr!=null) {
			System.out.println(itr.getData()+" ");
			if(itr.getNext()!=null) {
				itr=itr.getNext().getNext();
			}else {
				itr=itr.getNext();
			}
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

	public void recursiveReverse() {
		
	}
	
	public IntListNode getHead() {
		return head;
	}
	
	public static void main(String[] args) {
		
		
		Scanner sc= new Scanner(System.in);
		String ch;
		int data=0, before=0;
		int pos=0;
		System.out.println("LinkedList  program");
		LinkedList c= new LinkedList();
		do {
			

			System.out.println("01. InsertFirst");
			System.out.println("02. InsertLast");
			System.out.println("03. Insert By position");
			System.out.println("04. Delete First");
			System.out.println("05. Delete Last");
			System.out.println("06. Delete By position");
			System.out.println("07. Insert before a value");
			System.out.println("08. Insert Sorted");
			System.out.println("09. Count Nodes");
			System.out.println("10. Display Alternate Nodes");
			System.out.println("11. Display Whole Linked List");
			System.out.println("12. Reverse the Linked List");
			System.out.println("13. Exit");
			ch=sc.next();
			switch (ch) {
			case "1": {
					System.out.println("Enter a Integer to Insert");
					data=sc.nextInt();
					c.insertFirst(data);
					break;
			}
			case "2":{
				System.out.println("Enter a Integer to Insert");
				data=sc.nextInt();
				c.insertLast(data);
				
				break;
			}
			case "3":{
				System.out.println("Enter a Integer to Insert");
				data=sc.nextInt();
				System.out.println("Enter a Position to Insert");
				pos=sc.nextInt();
				c.insertByPos(data, pos);
				
				break;
			}
			case "4":{
				data=c.deleteFirst();
				if(data!=-999)
				System.out.println(data+" deleted");
				break;
			}
			case "5":{
				data=c.deleteLast();
				if(data!=-999)
				System.out.println(data+" deleted");
				break;
			}
			case "6": {
				System.out.println("Enter a Position to Insert");
				pos=sc.nextInt();
				data=c.deleteByPos(pos);
				if(data!=-999)
					System.out.println(data+" deleted");
				break;
			}
			case "7":{
				System.out.println("Enter a Integer to Insert");
				data=sc.nextInt();
				System.out.println("Insert Before Following value");
				before=sc.nextInt();
				c.insertBefore(data, before);
				break;
			}
			case "8":{
				System.out.println("Enter a Integer to Insert in sorted order");
				data=sc.nextInt();
				c.insertSorted(data);
				break;
			}
			case "9":{
				System.out.println("Node count: "+c.count());
				break;
			}
			case "10":{
				c.displayAlternate();
				break;
			}
			case "11":{
				System.out.println(c);
				break;
			}
			case "12":{
				c.reverseList();
				break;
			}
			case "13":
				break;
			default:
				System.out.println("Enter correct Choice");
					
				}
		}while(!ch.equals("13"));
		
		
		sc.close();
	}
}
