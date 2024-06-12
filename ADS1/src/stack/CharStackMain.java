package stack;

import java.util.Scanner;

public class CharStackMain {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		char ch;
		char data;
		System.out.println("Character Stack program");
		System.out.println("Enter Size of Character Stack");
		int size=sc.nextInt();
		CharStack c= new CharStack(size);
		do {
			

			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Peek");
			System.out.println("4. Display Stack");
			System.out.println("5. Exit");
			ch=sc.next().charAt(0);
			switch (ch) {
			case '1': {
					System.out.println("Enter a character to push");
					data=sc.next().charAt(0);
					c.push(data);
					break;
			}
			case '2':{
				data=c.pop();
				if(data!='#')
					System.out.println(data +" is popped");
				break;
			}
			case '3':{
				data=c.peek();
				if(data!='#') {
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
