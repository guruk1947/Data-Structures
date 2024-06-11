package stack;

import java.util.Scanner;

public class CheckHtmlExp {

		private static boolean match(String c1,String c2) {
			if((c1.equals(">")) || (c1.equals(c2)))
				return true;
			return false;
		}
		private static String tagName(String exp,char tag) {
			char flag;
			String c=null;
//			int index=0,index1=0,index2=0;
			int index = 0;
			for(int i=0;i<exp.length()-1;i++) {
				
				flag=exp.charAt(i);
				if((flag==tag))
				{
					int index1 =exp.indexOf(" ", i);
					int index2 =exp.indexOf(">", i);
					if(index1<index2 && index1>0) {
						index=index1;
					}else if(index2>0){
						index=index2;
					}
					if(index>i)
					c=exp.substring((i+1), index);
					System.out.println("0"+c);
					break;
					
				}}
			return c;
		}
		public static boolean check(String exp) {
			char tag;
			String c1, c2=null;
			StringStack st = new StringStack();
			for(int i=0;i<exp.length();i++) {
				
				tag=exp.charAt(i);
				if((tag=='<'))
				{
					c2 = tagName(exp,tag);
					if(c2==null) {
						System.out.println("Invalid expr");
						return false;
					}
					st.push(c2);
					c2=null;
				}
				if(tag=='/' ) {
					if(st.isEmpty())
					{	System.out.println("closing are Extra..");
					   	return false;}
					c1=st.pop();
					if(exp.charAt(i+1)=='>') {
						c2 = String.valueOf(exp.charAt(i+1));
					}else {
						c2=tagName(exp, tag);
						if(c2==null) {
							System.out.println("Invalid expr");
							return false;
						}
						if(!match(c1,c2))
						{
							System.out.println("mismatch..");
							return false;
						}
						System.out.println("2"+c2);
					}
				}
					
			}
			if(st.isEmpty()) {
				return true;
			}else {
				System.out.println("Opening are Extra..");
				return false;

			}
		}
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			
			boolean b = check(str);
			if(b)
				System.out.println("Exp is valid..");
			else {
				System.out.println("Exp is invalid..");
			}
			sc.close();
		}
	}


