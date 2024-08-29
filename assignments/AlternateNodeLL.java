package assignments;

import java.util.Scanner;

import listedList.IntListNode;
import listedList.LinkedList;

public class AlternateNodeLL {

	public static void nodeSwap(LinkedList l) {
		LinkedList l1= new LinkedList();
		LinkedList l2= new LinkedList();
		IntListNode itr=l.getHead(), tempItr=null;
		if(itr==null) return;
		int flag=0;
		while(itr!=null) {
			l1.insertLast(itr.getData());
			itr=itr.getNext();
			if(flag==0)
				tempItr=l1.getHead();
			else
				tempItr=tempItr.getNext();
			flag=1;
			if(itr!=null) {
				l2.insertLast(itr.getData());
				itr=itr.getNext();
			}				
		}
		l.setHead(l1.getHead());
		tempItr.setNext(l2.getHead());
		
		
	}
	

	public static void main(String[] args) {
		LinkedList l= new LinkedList();
		
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter size for list 1: ");
		int size=sc.nextInt();
		for(int i=0; i<size; i++) {
			System.out.print("Enter 0-9 integer: ");
			int data=sc.nextInt();
			l.insertLast(data);
		}
		nodeSwap(l);
		System.out.println(l);
	}
}
