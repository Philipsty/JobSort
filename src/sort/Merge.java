package sort;

public class Merge {
	/**
	 * merge sort using Comparable
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortMerge ( Comparable[] x, int n ) {
		sort(x, 0, n-1);
	}
	
	/**
	 * recursively split the input into tow portions to sort them, then merge them 
	 * in a way to get the result sorted. the sort stop when one element remains in the portion
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param lo - the lower index of the portion to sort of the input array
	 * @param hi - the higher index of the portion to sort of the input array
	 */
	private static void sort(Comparable[] x, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = (lo + hi) / 2;
		sort(x, lo, mid);
		sort(x, mid+1, hi);
		merge(x, lo, mid, hi);
	}

	/**
	 * merge sorted portions in an array in a way the result is sorted
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param lo - the lower index of the first portion to sort of the input array
	 * @param mid / mid+1 - the higher/ lower index of the first/second portion to sort of the input array
	 * @param hi - the higher index of the second portion to sort of the input array
	 */
	public static void merge(Comparable[] x, int lo, int mid, int hi) {  // Merge a[lo..mid] with a[mid+1..hi].
		int i = lo, j = mid+1;
		Comparable aux[] = new Job[x.length];
		
		// Copy a[lo..hi] to aux[lo..hi]
		for (int k = lo; k <= hi; k++)  
			aux[k] = x[k];

		for (int k = lo; k <= hi; k++)  // Merge back to a[lo..hi]
			if      (i > mid)                  x[k] = aux[j++]; // copy the remaining element in the right portion
			else if (j > hi )                  x[k] = aux[i++]; // copy the remaining element in the left portion
			else if (Job.less(aux[j], aux[i])) x[k] = aux[j++]; // copy the smaller element from the right side
			else                               x[k] = aux[i++]; // copy the smaller element from the left side
	}

}
