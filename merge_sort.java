/**************************************************************************************
 * Count inversion in a array
 * Using merge sort algorithm and recursive implement
 * Time complicity O(nlog(n))
 * Sorted array is in 'number' 
 * Message printed out is the number of inversions in the input data
 **************************************************************************************/

import java.io.File;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileInputStream;

public class Merge_sort {
	public static long Count(int[] A){
		if(A.length == 1)	{
			return 0;
		}
		else {
			//divide array into two parts
			int[] first = new int[A.length / 2];
			int[] second = new int[A.length - A.length / 2];
			System.arraycopy(A, 0, first, 0, first.length);
			System.arraycopy(A, first.length, second, 0, second.length);
			return Count(first) + Count(second) + merge(first, second, A);
		}
	}
	
	private static long merge(int[] first, int[] second, int[] a) {
		long count = 0;
		int first_index = 0;
		int second_index = 0;
		int merge_index = 0;
		//merge two sorted array
		while(first_index < first.length && second_index < second.length){
			if(first[first_index] < second[second_index]) {
				a[merge_index] = first[first_index];
				first_index ++;
			}else {
				a[merge_index] = second[second_index];
				second_index ++;
				//count inversions
				count += (first.length - first_index);
			}
			merge_index ++;
		}
		System.arraycopy(first, first_index, a, merge_index, first.length - first_index);
		System.arraycopy(second, second_index, a, merge_index, second.length - second_index);
		return count;
	}
}