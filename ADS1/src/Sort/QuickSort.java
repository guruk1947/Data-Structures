package Sort;

import java.util.Scanner;

public class QuickSort {
	public static void quickS(int arr[]) {
		quickSort(arr, 0, arr.length-1);
	}

	private static void quickSort(int[] arr, int low, int high) {
		int pivotLoc;
		if(low>=high) return;
		pivotLoc=partition(arr, low, high);
		quickSort(arr, low, pivotLoc-1);
		quickSort(arr, pivotLoc+1, high);
		
	}
	private static int partition(int[] arr, int low, int high) {
		int left=low, right=high,temp,pivot=arr[low];
		while(left<=high) {
			while((arr[left]<=pivot) && left<high)
				left++;
			while(arr[right]>pivot)
				right--;
			if(left<right) {
				temp=arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
				left++;
				right--;	
			}
			else left++;
		}
		arr[low]=arr[right];
		arr[right]=pivot;
		return right;
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
			System.out.print(arr[i]+" > ");
		quickS(arr);
		System.out.println("Sorted array: ");
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" > ");
	}
}
