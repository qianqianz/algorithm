/**************************************************************************************
 * Implement of insertion sort algorithm
 * Time complexity O(n + d), d is the number of inversions
 * 	for i ← 1 to length(A)
 *  	j ← i
 *		key ← A[i]
 *  	while j > 0 and A[j-1] > A[j]
 *      	A[j] ← A[j-1]
 *        	j ← j - 1
 *		A[j] ← key
 **************************************************************************************/
public class Inertion_sort {
	public static void Insertion_sort(int[] A){
		for(int i = 1; i < A.length; i++) {
			int j = i;
			int key = A[i];
			while(j > 0 && (A[j-1] > key)) {
				A[j] = A[j-1];
				j--;
			}
			A[j] = key;
		}
	}
}