package stack;

import java.util.Arrays;

public class StringStack {

	private int top;
	private String[] arr;
	
	public StringStack() {
		top=-1;
		arr= new String[10];
	}
	public StringStack(int d) {
		top=-1;
		arr= new String[d];
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
	public void push(String d) {
		if(isFull()) {
			System.out.println("Stack overFlow...");
			return;
		}
		arr[++top]=d;
		System.out.println(d+" pushed successfully");
	}
	public String pop() {
		String d=null;
		if(isEmpty()) {
			System.out.println("Stack UnderFlow...");
			return d;
		}
		d= arr[top];
		arr[top--]=null;
		return d;
	}
	public String peek() {
		String d=null;
		if(isEmpty()) {
			System.out.println("Stack UnderFlow...");
			return d;
		}
		d= arr[top];
		return d;
	}
	@Override
	public String toString() {
		return "StringStack [arr=" + Arrays.toString(arr) + "]";
	}
	
}
