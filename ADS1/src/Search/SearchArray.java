package Search;


import java.util.Scanner;

public class SearchArray {

	public static int search(int[] arr, int key) {
		
		for(int i=0; i<arr.length; i++) {
			if(key== arr[i])
				return i;
		}
		return -999;
	}
	public static int binarySearch(int arr[], int key) {
		int mid, low=0, high=arr.length-1;
		mid=(low+high)/2;
		while(arr[mid]!=key && low<high) {
			if(key<arr[mid])
				high=mid-1;
			else
				low=mid+1;
			mid=(low+high)/2;
		}
		
		if(arr[mid]==key)
			return mid;
		else return -999;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter size of an array: ");
		int size=sc.nextInt();
		int arr[]=new int[size];
		for(int i=0; i<arr.length; i++) {
			System.out.print("Enter data to insert: ");
			arr[i]=sc.nextInt();
		}
		System.out.println("Array: ");
		for(int i=0; i<arr.length; i++)
			System.out.println(arr[i]);
		
		System.out.print("Enter value to search: ");
		int data=sc.nextInt();
		int index=SearchArray.binarySearch(arr, data);
		if(index==-999)
			System.out.println("Search value not present ");
		else
			System.out.println("Search value is at index: "+index);
		
		sc.close();
	}
}
