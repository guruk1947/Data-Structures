package stack;

public class TwoCStudentStack {

	private int topA, topB;
	private Student[] arr;
	
	public TwoCStudentStack() {
		topA=-1;
		topB=10;
		arr= new Student[10];
	}
	public TwoCStudentStack(int d) {
		topA=-1;
		topB=d;
		arr= new Student[d];
	}
	
	public boolean isEmptyA() {
		if(topA==-1)
			return true;
		else return false;
	}
	public boolean isEmptyB() {
		if(topB==arr.length)
			return true;
		else return false;
	}
	public boolean isFull() {
		if(topB-topA==1)
			return true;
			return false;
	}
	public void pushA(Student d) {
		if(isFull()) {
			System.out.println("Stack overFlow...");
			return;
		}
		arr[++topA]=d;
		System.out.println(d+" pushed successfully in A");
	}
	public void pushB(Student d) {
		if(isFull()) {
			System.out.println("Stack overFlow...");
			return;
		}
		arr[--topB]=d;
		System.out.println(d+" pushed successfully in B");
	}
	public Student popA() {
		Student d=null;
		if(isEmptyA()) {
			System.out.println("Stack UnderFlow...A");
			return d;
		}
		d= arr[topA];
		arr[topA--]=null;
		return d;
	}
	public Student popB() {
		Student d=null;
		if(isEmptyB()) {
			System.out.println("Stack UnderFlow...B");
			return d;
		}
		d= arr[topB];
		arr[topB++]=null;
		return d;
	}
	public Student peekA() {
		Student d=null;
		if(isEmptyA()) {
			System.out.println("Stack UnderFlow...A");
			return d;
		}
		d= arr[topA];
		return d;
	}
	public Student peekB() {
		Student d=null;
		if(isEmptyB()) {
			System.out.println("Stack UnderFlow...B");
			return d;
		}
		d= arr[topB];
		return d;
	}
	public void displayA() {
		System.out.println("Displaying stack A");
		for(int i=0; i<=topA; i++) {
			System.out.println((i+1)+" "+arr[i]);
		}
	}
	public void displayB() {
		System.out.println("Displaying stack B");
		for(int i=arr.length-1; i>=topB; i--) {
			System.out.println((arr.length-i)+" "+arr[i]);
		}
	}
}
