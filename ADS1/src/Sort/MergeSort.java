package Sort;

import java.util.Scanner;

public class MergeSort {
	private static void merge1(int[] arr, int tar[], int low1, int high1, int low2, int high2) {
		int i=low1, j=low2, k=low1;
		while(i<=high1 && j<=high2) {
			if(arr[i]<arr[j]) {
				tar[k]=arr[i];
				i++;
				k++;
			}
			else if(arr[j]<arr[i]) {
				tar[k]=arr[j];
				j++;
				k++;
			}
			else {
				tar[k]=arr[j];
				i++;j++;k++;
			}
		}
		while(i<=high1) {
			tar[k]=arr[i];
			i++;k++;
		}
		while(j<=high2) {
			tar[k]=arr[j];
			j++;k++;
		}
	}

	public static void copyArr(int[] arr, int[] temp ,int low ,int high) {
		for(int i=low;i<=high; i++)
			arr[i]=temp[i];
	}
	private static void mergeSort(int[] arr, int low, int high) {
		int temp[]=new int[arr.length];
		if(low>=high) return;
		int mid=(low+high)/2;
		
		mergeSort(arr, low, mid);
		mergeSort(arr, mid+1, high);
		merge1(arr, temp, low, mid, mid+1, high);
		copyArr(arr, temp, low, high);
	}
	public static void mergeSortWrap(int arr[]) {
		
		mergeSort(arr, 0, arr.length-1);
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter size of an array: ");
		int size=sc.nextInt();
		int[] arr= {9, 4, 7, 6, 3, 1, 5};
//		int arr[]=new int[size];
//		for(int i=0; i<arr.length; i++) {
//			System.out.print("Enter data to insert: ");
//			arr[i]=sc.nextInt();
//		}
		System.out.println("Array: ");
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" > ");
		mergeSortWrap(arr);
		
		System.out.println("Sorted array: ");
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" > ");
	}

}
