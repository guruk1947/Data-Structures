package stack;

import java.util.Scanner;


import listedList.LinkedList;

public class LLStack {
	
	LinkedList l= new LinkedList();
	public void push(int d) {
		l.insertFirst(d);
	}
	public int pop() {
		return l.deleteFirst();
	}
	public boolean isEmpty() {
		if(l.getHead()==null)
			return true;
		return false;
	}
	public void display() {
		System.out.println(l);
	}
	public int peek() {
		if(l.getHead()!=null)
			return l.getHead().getData();
		return -999;
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		char ch;
		int data;
		System.out.println("Integer Stack usong linked list program");
		LLStack c= new LLStack();
		do {
			

			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Peek");
			System.out.println("4. Display Stack");
			System.out.println("5. Exit");
			ch=sc.next().charAt(0);
			switch (ch) {
			case '1': {
					System.out.println("Enter a integer to push");
					data=sc.nextInt();
					c.push(data);
					break;
			}
			case '2':{
				data=c.pop();
				if(data!=-999)
					System.out.println(data +" is popped");
				break;
			}
			case '3':{
				data=c.peek();
				if(data!=-999) {
					System.out.println(data+" is at peek");
				}
				break;
			}
			case '4':
				c.display();
			case '5':
				break;
			default:
				System.out.println("Enter correct Choice");
			}
		}while(ch!=5);
		
		
		sc.close();
	}
}
