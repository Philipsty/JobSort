package sort;

public class Heap {
	/**
	 * heap sort using Comparable
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortHeap ( Comparable[] xx, int n ) {
		// create an array with one more cell that holds the same jobs and keep index 0 empty
		Comparable x[] = new Comparable[n + 1];
		for (int i = 1; i <= n; i++) 
			x[i] = xx[i-1];
		
		// construct the heap
		for (int k = n/2; k >= 1; k--)      
			sink(x, k, n); 
		
		// extract element from the heap (root) and put them from end to begin in xx
		int i = 1;
		while (n > 1)   {
			xx[n-i] = x[1]; // copy current max (root) in its position in xx
			Job.exch(x, 1, n--); // copy last element in the heap in the root
			sink(x, 1, n);   	// rearrange the heap if the last exchange violate the heap rule
		}
		// copy the last element
		xx[0] = x[1];
	}

	/**
	 * top-down reheapify the heap, rearrange the element of the heap after removing the 
	 * biggest element at the root
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param k - the position to start the process (root of sub-heap)
	 * @param n - the size of the input array
	 */
	private static void sink(Comparable[] x, int k, int n) {
		while (2*k <= n)   {
			int j = 2*k;      
			if (j < n && Job.less(x[j], x[j+1])) j++; // make j the index of bigger child
			if (!Job.less(x[k], x[j])) break; // if the parent is bigger than children exit
			Job.exch(x, k, j);
			k = j;   
		} 
	}
}