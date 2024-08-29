package assignments;

import java.util.LinkedList;
import java.util.Queue;

public class StringCompare {
public static void main(String[] args) {
	String str0="guru:gur";
	String str[]=str0.split(":");
	Queue<Character> q0= new LinkedList<Character>();
	Queue<Character> q1= new LinkedList<Character>();
		

//	char[] c= new char[str[0].length()];
	for(int i=0; i<str[0].length(); i++) {
		q0.add(str[0].charAt(i));
	}
//	for(char c1:c)
//		System.out.print(c1+" ");
//	char[] c1= new char[str[1].length()];
	for(int i=0; i<str[1].length(); i++) {
		q1.add(str[1].charAt(i));
	}
	int flag=0;
	for(int i=0; i<q0.size() && i<str[1].length(); i++) {
		char c1=q0.remove();
		char c2=q1.remove();
		if(c1!=c2) 
			flag=1;
		
	}
	System.out.println(str[0].length());
	System.out.println(str[1].length());
	if(flag==0) {
		if(str[0].length() >str[1].length())
			System.out.println("String 1 is greater than 2");
		else if(str[0].length() <str[1].length())
			System.out.println("String 2 is greater than 1");
		else
			System.out.println("Both strings have equal length");
	}else {
		System.out.println("String characters are unequal...");
	}
	
}
}
