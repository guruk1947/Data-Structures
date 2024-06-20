package Sort;

import java.util.Scanner;

public class HeapSort {

	public static void heapSort(int[] arr) throws InterruptedException  {
		int n=arr.length;
		int temp;
		for(int i=(n/2)-1; i>=0; i--)
			heapify(arr, n, i);
		System.out.print("arr[0] the lasgest number.. ");
		System.out.println(arr[0]);
		for(int i=n-1; i>=0; i--) {
			temp= arr[0];
			arr[0]=arr[i];
			arr[i]=temp;			
			System.out.println("Swapping.. ");
			Thread.sleep(4000);
			System.out.println(arr[i]);
			heapify(arr, i-1, 0);
		}
		
	}
	private static void heapify(int[] arr, int n, int p) {
		int left=2*p+1;
		int right=2*p+2;
		int largest=p, temp;
		if(left<n && arr[left]>arr[p])
			largest=left;
		if(right<n && arr[right]> arr[largest])
			largest=right;
		if(p!=largest) {
			temp=arr[p];
			arr[p]=arr[largest];
			arr[largest]=temp;
			heapify(arr, n, largest);
		}
	}
	public static void main(String[] args) throws InterruptedException {
//		Scanner sc=new Scanner(System.in);
//		System.out.print("Enter size of an array: ");
//		int size=sc.nextInt();
//		int arr[]=new int[size];
//		for(int i=0; i<arr.length; i++) {
//			System.out.print("Enter data to insert: ");
//			arr[i]=sc.nextInt();
//		}
		int[] arr = {6,5,10,2,8,7};
		System.out.println("Array: ");
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" > ");
		heapSort(arr);
		System.out.println("Sorted array: ");
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" > ");
	}
}
