import java.util.Arrays;
import java.util.Scanner;



public class SortingApp {
	public static void main(String[] args) {


		Scanner scan = new Scanner(System.in);
		System.out.println("Enter length of your array: ");
		int arrlength = scan.nextInt();
		scan.nextLine();


		System.out.println("Enter your array which you want to be sorted: ");
		int[] arr = new int[arrlength];
		for(int i=0; i<arrlength;i++){
		System.out.println("Enter parameter number " + (i+1));
		arr[i] = scan.nextInt();

}


		
		System.out.println("Before: " + Arrays.toString(arr));
		//selectionSort(arr);
		//System.out.println("After selection sort: " + Arrays.toString(arr));
		// insertionSort(arr);
		// System.out.println("After insertion sort: " + Arrays.toString(arr));
		int[] sortedArr = countingSort(arr);
		System.out.println("After counting sort: " + Arrays.toString(sortedArr));
	}

	private static void selectionSort(int[] arr) {
		int min;
		for(int idx = 0; idx < arr.length - 1; idx++) {
			min = idx;

			for(int scan = idx+1; scan < arr.length; scan++) {
				if(arr[scan] < arr[min]) {
					min = scan;
				}
			}

			swap(arr, idx, min);

		}
	}


	private static void insertionSort(int[] arr) {
		int scan;
		for(int idx = 1; idx < arr.length; idx++) {
			scan = idx;
			while(scan > 0 && arr[scan] < arr[scan-1]) {
				swap(arr, scan, scan-1);
				scan--;
			}
		}

	}

	private static int[] countingSort(int[] arr) {
		int max = findMax(arr); // linear

		if(max == Integer.MIN_VALUE) {
			return new int[] {};
		}

		int[] counts = new int[max + 1];
		// First preprocessing step: linear
		for(int num : arr) {
			counts[num]++;
		}

		// second preprocessing step: linear
		for(int idx = 1; idx < counts.length; idx++) {
			counts[idx] = counts[idx-1] + counts[idx];
		}
		int[] sortedArray = new int[arr.length];
		int current, sortedIdx;
		for(int idx = arr.length - 1; idx >= 0; idx--) {
			current = arr[idx];
			counts[current]--;
			sortedIdx = counts[current];
			sortedArray[sortedIdx] = current;
		}
		
		return sortedArray;
	}

	private static int findMax(int[] arr) {
		// return Collections.max(Arrays.asList(arr));
		int max = Integer.MIN_VALUE;

		for(int num : arr) {
			if(num > max) {
				max = num;
			}
		}		
		
		return max;
	}


	private static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

}