package listedList;

import java.util.Scanner;

public class DblyLL {

	private DblyNode head=null;

	public DblyNode getHead() {
		return head;
	}

	public void setHead(DblyNode head) {
		this.head = head;
	}
	
	public void insertFirst(int d) {
		DblyNode new_node= new DblyNode(d);
		if(head==null) {
			head=new_node;
			return;
		}
		new_node.setNext(head);
		head.setPrev(new_node);
		head=new_node;
	}
	public void insertLast(int d) {
		DblyNode new_node= new DblyNode(d);
		if(head==null) {
			head=new_node;
			return;
		} 
		DblyNode itr=head;
		while(itr.getNext()!=null)
			itr=itr.getNext();
		new_node.setPrev(itr);
		itr.setNext(new_node);
	}
	public int count() {
		int cnt=01;
		if(head==null)
			return 0;
		DblyNode itr=head;
		
		while(itr.getNext()!=null) {
			itr=itr.getNext();
			cnt++;
		}
		return cnt;
	}
	public void insertByPos(int d, int pos) {
		DblyNode new_node= new DblyNode(d);
		if(head==null) {
			head= new_node;
			return;
		}
		if(pos==1) {
			new_node.setNext(head);
			head.setPrev(new_node);
			head=new_node;
			return;
		}
		DblyNode itr=head;
		for(int i=1; i<pos-1 && itr.getNext()!=null; i++, itr=itr.getNext());
		new_node.setPrev(itr);
		new_node.setNext(itr.getNext());
		if(itr.getNext()!=null)
			itr.getNext().setPrev(new_node);
		itr.setNext(new_node);
	}
	public int deleteFirst() {
		int d=-999;
		if(head==null)
			return d;
		d=head.getData();
		head=head.getNext();
		if(head!=null)
			head.setPrev(null);
		return d;
	}
	public int deleteLast() {
		int d=-999;
		if(head==null)
			return d;
		DblyNode itr=head;
		while(itr.getNext()!=null)
			itr=itr.getNext();
		d=itr.getData();
		if(itr.getPrev()!=null) {
			itr.getPrev().setNext(null);
		}else {
			head=null;
		}
		itr=null;
		return d;
	}
	public int deleteByPos(int pos) {
		int d=-999;
		if(head==null)
			return d;
		if(pos==1) {
			d=head.getData();
			head=head.getNext();
			if(head!=null)
				head.setPrev(null);
			return d;
		}
		DblyNode itr=head;
		for(int i=1; i<pos; i++) {
			itr=itr.getNext();
			if(itr==null)
				break;
		}
		if(itr!=null) {
			d=itr.getData();
			itr.getPrev().setNext(itr.getNext());
			if(itr.getNext()!=null)
				itr.getNext().setPrev(itr.getPrev());
		}
		return d;
	}
	
	public void addToEmpty(int d) {
		if(head!=null)
			return;
		DblyNode new_node= new DblyNode(d);
		head= new_node;
	}
	public DblyLL createList(int n) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter integer to insert in List");
		DblyLL list= new DblyLL();
		for(int i=0; i<n; i++) {
			System.out.print("Enter "+(i+1)+" number: ");
			int d=sc.nextInt();
			list.insertLast(d);
		}
		return list;
	}
	public String toString() {
		if(head==null) {
			return "list is empty ";	
		}
		DblyNode iter = head;
		String str = "List: ";
		while(iter!=null) {
			str = str + " -> "+iter.getData();
			iter = iter.getNext();
		}
		return str;
	}
	
	public void reverseList() {
		if(head== null)
			return;
		DblyNode prev=null, next=null, itr=head;
		do {
			prev=itr.getPrev();
			itr.setPrev(itr.getNext());
			next=itr.getNext();
			itr.setNext(prev);
			if(next==null)
				head=itr;
			itr=next;
		}while(itr!=null);
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String ch;
		int data=0, before=0;
		int pos=0;
		System.out.println("Doubly Linked List  program");
		DblyLL c= new DblyLL();
		do {
			

			System.out.println("01. InsertFirst");
			System.out.println("02. InsertLast");
			System.out.println("03. Insert By position");
			System.out.println("04. Delete First");
			System.out.println("05. Delete Last");
			System.out.println("06. Delete By position");
			System.out.println("07. Add one data if list is empty (addToEmpty) ");
			System.out.println("08. Create new List");
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
				System.out.println("Enter a Position to Delete ");
				pos=sc.nextInt();
				data=c.deleteByPos(pos);
				if(data!=-999)
					System.out.println(data+" deleted");
				break;
			}
			case "7":{
				System.out.println("Enter a Integer to Insert");
				data=sc.nextInt();
				c.addToEmpty(data);
				break;
			}
			case "8":{
				System.out.println("Enter a number of data to insert in a list");
				data=sc.nextInt();
				DblyLL list= c.createList(data);
				System.out.println(list);
				break;
			}
			case "9":{
				System.out.println("Node count: "+c.count());
				break;
			}
//			case "10":{
//				c.displayAlternate();
//				break;
//			}
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
