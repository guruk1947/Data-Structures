package assignments;

import java.util.Scanner;

import listedList.IntListNode;
import listedList.LinkedList;

public class AddDigitsLL {

	public static int LLtoInt(LinkedList l) {
		int n=0;
		IntListNode itr=l.getHead();
		int cnt=0;
		while(itr!=null) {
			cnt++;
			int mul=1;
			if(cnt!=1) mul=10;
			n*=mul;
			n+=itr.getData();
			itr=itr.getNext();
		}
		return n;
	}
	public static void main(String[] args) {
		LinkedList l1= new LinkedList();
		LinkedList l2= new LinkedList();
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter size for list 1: ");
		int size=sc.nextInt();
		for(int i=0; i<size; i++) {
			System.out.print("Enter 0-9 integer: ");
			int data=sc.nextInt();
			l1.insertLast(data);
		}
		System.out.print("Enter size for list 2: ");
		size=sc.nextInt();
		for(int i=0; i<size; i++) {
			System.out.print("Enter 0-9 integer: ");
			int data=sc.nextInt();
			l2.insertLast(data);
		}
//		System.out.println(l1);
//		System.out.println(l2);
		int n1=LLtoInt(l1);
		int n2=LLtoInt(l2);
		System.out.println(n1+"  "+n2);
		int sum = n1+n2;
		System.out.println("Sum of to integers"+sum);
		l1.setHead(null);
		while(sum%10 != 0) {
			l1.insertFirst(sum%10);
			sum/=10;
		}
			System.out.println(l1);
		
		sc.close();
	}
}
