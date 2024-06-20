package queue;

import java.util.Scanner;



public class IntQueue {

	int front,rear;
	int arr[];
	
	public IntQueue() {
		front= -1;
		rear=-1;
		arr = new int[10];
	}
	public IntQueue(int s) {
		front= -1;
		rear=-1;
		arr = new int[s];
	}
	
	public boolean isEmpty() {
		if((front == -1) || (front-rear == 1))
			return true;
		return false;
	}
	public boolean isFull() {
		if((rear == arr.length-1))
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
		front=front+1;
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
		Scanner sc= new Scanner(System.in);
		char ch;
		int data;
		System.out.println("IntQueue  program");
		System.out.println("Enter Size of IntQueue");
		int size=sc.nextInt();
		IntQueue c= new IntQueue(size);
		do {
			

			System.out.println("1. Insert");
			System.out.println("2. Remove");
			System.out.println("3. Peek");
			System.out.println("4. Display Queue");
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
