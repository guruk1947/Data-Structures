package listedList;

import java.util.Scanner;

public class CircularLL {

	IntListNode last;
	
	public CircularLL() {
		last = null;
	}
	
	public void insertFirst(int d) {
		IntListNode new_node= new IntListNode(d);
		if(last == null) {
			last = new_node;
			last.setNext(new_node);;
			return;
		}
		new_node.setNext(last.getNext());
		last.setNext(new_node);
		return;
	}
	public void insertLast(int d) {
		IntListNode new_node= new IntListNode(d);
		if(last == null) {
			last = new_node;
			last.setNext(new_node);;
			return;
		}
		new_node.setNext(last.getNext());
		last.setNext(new_node);
		last = new_node;
		return;
			}
	public int deleteFirst() {
		IntListNode itr;
		int d = -999;
		
		if(last==null) {
			return d;
		}
			
		if (last.getNext() == last) {
			d=last.getData();
			last.setNext(null);
			last = null;
			return d;
		}
		itr = last.getNext();
		d=itr.getData();
		last.setNext(itr.getNext());
		itr.setNext(null);
		itr = null;
		return d;
	}
	public int deleteLast() {
		IntListNode itr;
		int d = -999;
		
		if(last==null) {
			return d;
		}
			
		if (last.getNext() == last) {
			d=last.getData();
			last.setNext(null);
			last = null;
			return d;
		}
		itr = last.getNext();
		
		while(itr.getNext() != last)
			itr = itr.getNext();
		
		itr.setNext(last.getNext());
		last.setNext(null);
		d = last.getData();
		last = itr;
		return d;
			
	}

	public void insertByPos(int d,int pos) {
		IntListNode new_node = new IntListNode(d);
		if(last == null) {
			last = new_node;
		    last.setNext(new_node);
		    return ;
		}
		
		if(pos == 1) {
			new_node.setNext(last.getNext());
			last.setNext(new_node);
			return ; 
		}
		
		IntListNode itr = last.getNext();
		int i =1;
		do {
			if(i<pos-1) {
				itr = itr.getNext();
				i = i+1;
			}else {
				new_node.setNext(itr.getNext());
				itr.setNext(new_node);
				if(itr==last)
					last = new_node;
				return;
			}
			
		}while(itr != last.getNext()) ;
			System.out.println("invalid positin");
		return;
	
	}
	
	public int deleteByPos(int pos) {
		IntListNode itr;
		int d = -999;
		
		if(last==null) {
			return d;
		}
			
		if(pos==1) {
			d=last.getNext().getData();
			if(last.getNext()==last) {
				last.setNext(null);
				last=null;
				return d;
			}
			last.setNext(last.getNext().getNext());
		}
		
		itr = last.getNext();
		
		for(int i=1; i<pos-1 && itr!=last; i++) {
			itr=itr.getNext();
		}
		if(itr==last)
			return d;
		IntListNode deletable=itr.getNext();
		d=deletable.getData();
		itr.setNext(itr.getNext().getNext());
		if(deletable==last)
			last=itr;
		deletable.setNext(null);
		deletable=null;
		return d;
	
		
		
		
	}
	
	public String toString() {
		if(last==null) {
			return "list is empty ";	
		}
		IntListNode iter = last;
		String str = "List: ";
		do {
			iter = iter.getNext();
			str = str + " -> "+iter.getData();
			
		}while(iter!=last);
		return str;
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String ch;
		int data=0, before=0;
		int pos=0;
		System.out.println("Circular LinkedList  program");
		CircularLL c= new CircularLL();
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
//				c.insertBefore(data, before);
				break;
			}
			case "8":{
				System.out.println("Enter a Integer to Insert in sorted order");
				data=sc.nextInt();
//				c.insertSorted(data);
				break;
			}
			case "9":{
//				System.out.println("Node count: "+c.count());
				break;
			}
			case "10":{
//				c.displayAlternate();
				break;
			}
			case "11":{
				System.out.println(c);
				break;
			}
			case "12":{
//				c.reverseList();
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
