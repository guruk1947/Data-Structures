package assignments;

import java.util.Scanner;

import listedList.IntListNode;
import listedList.LinkedList;

public class SplitLL {
	
	public static LinkedList[] splitByNum(LinkedList l, int n) {
		LinkedList[] ll=new LinkedList[2];
		ll[0]=new LinkedList();
		ll[1]=new LinkedList();
		IntListNode itr=l.getHead();
		while(itr!=null && itr.getData()!=n) {
			ll[0].insertLast(itr.getData());;
			itr=itr.getNext();
		}
		System.out.println(ll[0]);
		System.out.println(ll[1]);
		
		while(itr!=null) {
			ll[1].insertLast(itr.getData());
			itr=itr.getNext();
		}
		System.out.println(ll[0]);
		System.out.println(ll[1]);

		return ll;
	}

	public static void main(String[] args) {
		LinkedList l= new LinkedList();
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter size for list 1: ");
		int size=sc.nextInt();
		System.out.println("Enter sorted integer list: ");
		for(int i=0; i<size; i++) {
			int data=sc.nextInt();
			l.insertLast(data);
		}
		System.out.print("Enter a number where LL will split: ");
		int n=sc.nextInt();
		LinkedList[] ll=new LinkedList[2];
		ll=splitByNum(l, n);
		if(ll[0]!=null || ll[1]!=null) {
			System.out.println(ll[0]);
			System.out.println(ll[1]);
		}
		else System.out.println("Entered number is not in the list");
		sc.close();
	}
}
