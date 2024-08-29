package stack;

import java.util.Arrays;

public class CharStack {

	private int top;
	private char[] arr;
	
	public CharStack() {
		top=-1;
		arr= new char[10];
	}
	public CharStack(int d) {
		top=-1;
		arr= new char[d];
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
	public void push(char d) {
		if(isFull()) {
			System.out.println("Stack overFlow...");
			return;
		}
		arr[++top]=d;
		System.out.println(d+" push successful");
	}
	public char pop() {
		char d='#';
		if(isEmpty()) {
			System.out.println("Stack UnderFlow...");
			return d;
		}
		d= arr[top--];
		return d;
	}
	public char peek() {
		char d='#';
		if(isEmpty()) {
			System.out.println("Stack UnderFlow...");
			return d;
		}
		d= arr[top];
		return d;
	}
	@Override
	public String toString() {
		return "CharStack [arr=" + Arrays.toString(arr) + "]";
	}
	
}
