package assignments;

import listedList.IntListNode;
import listedList.LinkedList;

public class OddEvenLL {
	public static void oddEven(LinkedList l) {
		IntListNode itr=l.getHead();
		if(itr==null) return;
		LinkedList l1=new LinkedList();
		LinkedList l2=new LinkedList();
		while(itr!=null) {
			if(itr.getData()%2==0) 
				l2.insertLast(itr.getData());
			else l1.insertLast(itr.getData());
			IntListNode deletable=itr;
			itr=itr.getNext();
			deletable.setNext(null);
			deletable=null;
		}
		itr=l1.getHead();
		while(itr.getNext()!=null) 
			itr=itr.getNext();
		itr.setNext(l2.getHead());
		l.setHead(l1.getHead());
		
		
	}

public static void main(String[] args) {
	LinkedList l1= new LinkedList();
	
	for(int i=1; i<=10; i++)
		l1.insertLast(i);
	oddEven(l1);
	System.out.println(l1);
}
}
