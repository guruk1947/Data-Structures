package stack;

import java.util.Arrays;

public class StudentStack {

	private int top;
	private Student[] arr;
	
	public StudentStack() {
		top=-1;
		arr= new Student[10];
	}
	public StudentStack(int d) {
		top=-1;
		arr= new Student[d];
	}
	
	public boolean isEmpty() {
		if(top==-1)
			return true;
		else return false;
	}
	public boolean isFull() {
		if(top==arr.length-1)
			return true;
			return false;
	}
	public void push(Student d) {
		if(isFull()) {
			System.out.println("Stack overFlow...");
			return;
		}
		arr[++top]=d;
		System.out.println(d+" pushed successfully");
	}
	public Student pop() {
		Student d=null;
		if(isEmpty()) {
			System.out.println("Stack UnderFlow...");
			return d;
		}
		d= arr[top];
		arr[top--]=null;
		return d;
	}
	public Student peek() {
		Student d=null;
		if(isEmpty()) {
			System.out.println("Stack UnderFlow...");
			return d;
		}
		d= arr[top];
		return d;
	}
	@Override
	public String toString() {
		return "StudentStack [arr=" + Arrays.toString(arr) + "]";
	}
	
}
