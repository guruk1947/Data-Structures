package stack;

import java.util.Scanner;

public class Student {

	private int roll;
	private String name;
	private int cls;
	private Scanner sc= new Scanner(System.in);
	
	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", cls=" + cls + "]";
	}
	public Student() {
		super();
		System.out.println("Enter stuednt info");
		System.out.println("Enter Student roll");
		roll=sc.nextInt();
		System.out.println("Enter Student name");
		name=sc.next();
		System.out.println("Enter Stuednt Class between 1-10");
		cls=sc.nextInt();
	}
	
	
}
