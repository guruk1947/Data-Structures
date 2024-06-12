package stack;

import java.util.Scanner;

public class StudentStackMain {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		char ch;
		Student data;
		System.out.println("Student Stack program");
		System.out.println("Enter Size of Student Stack");
		int size=sc.nextInt();
		StudentStack c= new StudentStack(size);
		do {
			

			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Peek");
			System.out.println("4. Display Stack");
			System.out.println("5. Exit");
			ch=sc.next().charAt(0);
			switch (ch) {
			case '1': {
					data=new Student();
					c.push(data);
					break;
			}
			case '2':{
				data=c.pop();
				if(data!=null)
					System.out.println(data +" is popped");
				break;
			}
			case '3':{
				data=c.peek();
				if(data!=null) {
					System.out.println(data+" is at peek");
				}
				break;
			}
			case '4':{
				System.out.println(c);
				break;}
			case '5':
				break;
			default:
				System.out.println("Enter correct Choice");
			}
		}while(ch!='5');
		
		
		sc.close();
	}
}
