package assignments;

import java.util.Scanner;

import listedList.IntListNode;
import listedList.LinkedList;

public class SwapAdjacentNode {
	
	public static void nodeSwap(LinkedList l) {
		IntListNode itr=l.getHead();
		if(itr==null) return;
		while(itr.getNext()!=null) {
			int temp=itr.getData();
			itr.setData(itr.getNext().getData());
			itr=itr.getNext();
			itr.setData(temp);
			if(itr.getNext()!=null)
				itr=itr.getNext();
		}
		
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
