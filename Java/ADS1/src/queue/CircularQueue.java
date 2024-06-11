package queue;

import java.util.LinkedList;
import java.util.Scanner;

public class CircularQueue {

	int front,rear;
	int arr[];
	
	public CircularQueue() {
		front= -1;
		rear=-1;
		arr = new int[10];
	}
	public CircularQueue(int s) {
		front= -1;
		rear=-1;
		arr = new int[s];
	}
	
	public boolean isEmpty() {
		if((front == -1))
			return true;
		return false;
	}
	public boolean isFull() {
		if(((front==0)&&(rear == arr.length-1))||(front==rear+1))
			return true;
		return false;
	}
	public void insert(int d) {
		if(isFull()) {
			System.out.println("Full..");
			return ;
		}
		if(front == -1)
			front = 0;
		if(rear == arr.length-1)
			rear=0;
		else 
			rear = rear + 1;
		arr[rear]=d;
		
	}
	public int remove() {
		int d= -999;
		if(isEmpty()) {
			System.out.println("Queue is Empty..");
			return d;
		}
		d = arr[front];
		if(front==rear) {       //Empty Condition
			front=rear=-1;
		}else if(front==arr.length-1) {
			front = 0;
		}else {
			front=front+1;
		}
		
		return d;
	}
	public int peek() {
		int d= -999;
		if(isEmpty()) {
			System.out.println("Queue is Empty..");
			return d;
		}
		d = arr[front];
		
		return d;
	}
	public static void main(String[] args) {
		LinkedList<Integer> l= new LinkedList<Integer>();
		
		Scanner sc= new Scanner(System.in);
		char ch;
		int data;
		System.out.println("CircularQueue  program");
		System.out.println("Enter Size of CircularQueue");
		int size=sc.nextInt();
		CircularQueue c= new CircularQueue(size);
		do {
			

			System.out.println("1. Insert");
			System.out.println("2. Remove");
			System.out.println("3. Peek");
			System.out.println("4. Display Stack");
			System.out.println("5. Exit");
			ch=sc.next().charAt(0);
			switch (ch) {
			case '1': {
					System.out.println("Enter a Integera to Insert");
					data=sc.nextInt();
					c.insert(data);
					break;
			}
			case '2':{
				data=c.remove();
				if(data!=-999)
					System.out.println(data +" is REmoved");
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
				System.out.println(c);
			case '5':
				break;
			default:
				System.out.println("Enter correct Choice");
			}
		}while(ch!='5');
		
		
		sc.close();
	}
	
}
