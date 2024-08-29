package assignments;

import java.util.Scanner;

import listedList.IntListNode;
import listedList.LinkedList;

public class MergeSortedList {

	public static LinkedList merge(LinkedList l1, LinkedList l2) {
		LinkedList l= new LinkedList();
		IntListNode itr1=l1.getHead();
		IntListNode itr2=l2.getHead();
		while(itr1!=null && itr2!=null) {
			if(itr1.getData()<itr2.getData()) {
				l.insertLast(itr1.getData());
				itr1=itr1.getNext();
			}
			else if(itr1.getData()>itr2.getData()) {
				l.insertLast(itr2.getData());
				itr2=itr2.getNext();
			}
		}
		while(itr1!=null) {
			l.insertLast(itr1.getData());
			itr1=itr1.getNext();
		}
		while(itr2!=null) {
			l.insertLast(itr2.getData());
			itr2=itr2.getNext();
		}
		
		return l;
	}
	public static void main(String[] args) {
		LinkedList l1= new LinkedList();
		LinkedList l2= new LinkedList();
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter size for list 1: ");
		int size=sc.nextInt();
		System.out.println("Enter sorted integer list: ");
		for(int i=0; i<size; i++) {
			int data=sc.nextInt();
			l1.insertLast(data);
		}
		System.out.print("Enter size for list 2: ");
		size=sc.nextInt();
		System.out.println("Enter sorted integer list: ");
		for(int i=0; i<size; i++) {
			int data=sc.nextInt();
			l2.insertLast(data);
		}
		l1=merge(l1, l2);
		System.out.println(l1);
	}
}
