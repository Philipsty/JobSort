package sort;

public class Insertion {
	/**
	 * regular insertion sort
	 * @param x - the input array containing processing times of jobs that need to be sorted.
	 */
	//this function
	public static void sortInsert ( Job[] x ) {
		  int N = x.length;
		  
	      for (int i = 1; i < N; i++)
	      {  // Insert a[i] among a[i-1], a[i-2], a[i-3]... .. 
	    	  // swap elements while they are not in ascending order
	    	  for (int j = i; j > 0 && Job.compareTo(x[j], x[j-1]) < 0; j--)
	    	  {
	    		  Job.exch(x, j, j-1);  
	    	  } 
	      }
	}

	/**
	 * insertion sort using Comparable
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortComparable ( Comparable[] x, int n ) {
	      for (int i = 1; i < n; i++)
	      {  // Insert a[i] among a[i-1], a[i-2], a[i-3]... a[0] 
	    	  for (int j = i; j > 0 && Job.less(x[j], x[j-1]); j--)
	    	  {
	    		  Job.exch(x, j, j-1);      
	    	  } 
	      }
	}
	

	/**
	 * optimized insertion sort
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortBinary ( Comparable[] x, int n ) {
	      for (int i = 1; i < n; i++)
	      {  // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
	    	  int pos = getInsertPosBinarySearch(x, 0, i-1, i);
	    	  if (pos != i) 
	    	  { // if element is not in its location
		    	  Comparable c = x[i];
	    		  for (int j = i; j > pos; j--)
	    		  {
	    			  x[j] = x[j-1];      
	    		  }
	    		  x[pos] = c;
	    	  }
	      }
	}
	
	/**
	 * returns where to insert the element at index ivalue in the sorted part
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param low - the low index of the sorted part of the input array
	 * @param high - the high index of the sorted part of the input array
	 * @param ivalue - the index of the element to insert into the sorted portion of the input array
	 */
	private static int getInsertPosBinarySearch(Comparable[] x, int low, int high, int ivalue) {
		int middle= (low + high) / 2;
		
		while (low <= high ) {
			// we found the element to insert int the sorted part so insert to its right side
			if (x[middle].compareTo(x[ivalue]) == 0)
				return middle + 1;
			if ( x[middle].compareTo(x[ivalue]) < 0)
				low = middle + 1;
			else
				high = middle - 1;
			middle = (low + high) / 2;
		} 
		// the element to insert is greater than the element at position middle
		if (middle < low)
			return low;
		else // the element to insert is less than the element at position middle
			return middle;
	}
	
}