package queue;

import java.util.Scanner;

import listedList.IntListNode;

public class LLQueue {

	IntListNode front=null, rear=null;
	
	public boolean isEmpty() {
		if(front==null)
			return true;
		return false;
	}
	public void enQueue(int d) {
		IntListNode new_node= new IntListNode(d);
		if(front==null) {
			front=rear=new_node;
			return;
		}
		rear.setNext(new_node);
		rear=new_node;
	}
	
	public int deQueue() {
		int d=-999;
		if(front==null) 
			return d;
		IntListNode deletable=front;
		d= deletable.getData();
		front=deletable.getNext();
		deletable.setNext(null);
		deletable=null;
		return d;
	}
	@Override
	public String toString() {
		String str="Queue-> ";
		if(front == null)
			return str+"Empty";
		IntListNode itr=front;
		while(itr!=null) {
			str=str+itr.getData()+"->";
			itr=itr.getNext();
		}
		
		return str;
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		char ch;
		int data;
		System.out.println("Queue using Links  program");
		LLQueue c= new LLQueue();
		do {
			

			System.out.println("1. EnQueue");
			System.out.println("2. Remove");
			System.out.println("3. Display Queue");
			System.out.println("4. Exit");
			ch=sc.next().charAt(0);
			switch (ch) {
			case '1': {
					System.out.println("Enter a Integer to Insert");
					data=sc.nextInt();
					c.enQueue(data);
					break;
			}
			case '2':{
				data=c.deQueue();
				if(data!=-999)
					System.out.println(data +" is deleted");
				break;
			}
			case '3':
				System.out.println(c);
			case '4':
				break;
			default:
				System.out.println("Enter correct Choice");
			}
		}while(ch!='4');
		
		
		sc.close();
	}
	
}
