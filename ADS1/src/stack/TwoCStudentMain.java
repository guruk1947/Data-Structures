package stack;

import java.util.Scanner;

public class TwoCStudentMain {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		char ch;
		Student data;
		System.out.println("Double ended Student Stack program");
		System.out.println("Enter Size of Double ended Student Stack");
		int size=sc.nextInt();
		TwoCStudentStack c= new TwoCStudentStack(size);
		do {
			

			System.out.println("1. PushA");
			System.out.println("2. PopA");
			System.out.println("3. PeekA");
			System.out.println("4. Display Stack A");
			System.out.println("5. PushB");
			System.out.println("6. PopB");
			System.out.println("7. PeekB");
			System.out.println("8. Display Stack B");
			System.out.println("9. Exit");
			ch=sc.next().charAt(0);
			switch (ch) {
			case '1': {
					data=new Student();
					c.pushA(data);
					break;
			}
			case '2':{
				data=c.popA();
				if(data!=null)
					System.out.println(data +" is popped from A");
				break;
			}
			case '3':{
				data=c.peekA();
				if(data!=null) {
					System.out.println(data+" is at peek in A");
				}
				break;
			}
			case '4':{
				c.displayA();
				break;}
			case '5': {
				data=new Student();
				c.pushB(data);
				break;
			}
			case '6':{
				data=c.popB();
				if(data!=null)
					System.out.println(data +" is popped from B");
				break;
			}
			case '7':{
				data=c.peekB();
				if(data!=null) {
					System.out.println(data+" is at peek in B");
				}
				break;
			}
			case '8':{
				c.displayB();
				break;}
			case '9':
				break;
			default:
				System.out.println("Enter correct Choice");
			}
		}while(ch!='9');
		
		
		sc.close();
	}
}
