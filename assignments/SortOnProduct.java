package assignments;

import java.util.Scanner;

public class SortOnProduct {



		public static void bubbleSort(int[] arr) {
				int i, j, temp, flag=0;
				for(i=arr.length-1; i>0; i--) {
					flag=0;
					for(j=0; j<i; j++) {
						if(arr[j]>arr[j+1]) {
							temp=arr[j];
							arr[j]=arr[j+1];
							arr[j+1]=temp;
							flag=1;
						}
					}
					if(flag==0)
						break;
				}
		}
		public static void selectionSort(int []arr) {
			int i, j, min, temp;
			for(i=0; i<arr.length-1; i++) {
				min=i;
				for(j=i+1; j<arr.length; j++) {
					if(arr[j] < arr[min])
						min=j;
				}
				if(min!=i) {
					temp=arr[i];
					arr[i]=arr[min];
					arr[min]=temp;
				}
			}
		}
		public static void insertionSort(int[] arr) {
			int i, j, k;
			for(i=1; i<arr.length; i++) {
				k=arr[i];
				for(j=i-1; j>=0 && k<arr[j]; j--) {
					arr[j+1]=arr[j];
				}
				arr[j+1]=k;
			}
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
			insertionSort(arr);
			System.out.println("Sorted array: ");
			for(int i=0; i<arr.length; i++)
				System.out.print(arr[i]+" > ");
			
		}
	}



