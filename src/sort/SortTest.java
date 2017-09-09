package sort;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import static org.junit.Assert.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

//Note: I commented out the additional cases 2^14, 2^16, 2^18 so that
//the program runs smoother

//this class uses J unit and test the insertion,merge and heap sorting
public class SortTest { 
//	Job x4[], x6[], x8[], x10[], x12[];
	static Job[] x4 = new Job[16];
	static Job[] x6 = new Job[64];
	static Job[] x8 = new Job[256];
	static Job[] x10 = new Job[1024];
	static Job[] x12 = new Job[4096];
	
	static Job[] x14 = new Job[16384];
	static Job[] x16 = new Job[65536];
	static Job[] x18 = new Job[262144];

	static Writer wr;

	public static boolean isSorted(Comparable x[]) {
		for (int i = 1; i < x.length; i++) {
			if (Job.less(x[i], x[i-1]))
				return false; 
		}
		return true;
	}
	public static void getData(Scanner input, Job x[]) {
		String line;
		StringTokenizer st;

		//read the first line of jobs
		line = input.nextLine();
		// extract jobs information
		st = new StringTokenizer(line, ",{}");
		for (int i = 0; i < x.length; i++) {
			x[i] = new Job(st.nextToken(), Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()));
		}
	}
	
	@BeforeClass
	public static void setUp() throws Exception {
		Scanner input= new Scanner(new File("./data/a2_in.txt"));

		getData(input, x4);
		getData(input, x6);
		getData(input, x8);
		getData(input, x10);
		getData(input, x12);
		getData(input, x14);
		getData(input, x16);
		getData(input, x18);
		
		
		
		try {
			File f = new File("./data/a2_out.txt");
			wr = new BufferedWriter(new FileWriter(f));
			wr.write("Sorting Method, 2^4, 2^6, 2^8, 2^10, 2^12, 2^14, 2^16, 2^18\r\n");
			System.out.println("Sorting Method, 2^4, 2^6, 2^8, 2^10, 2^12, 2^14, 2^16, 2^18");
		} catch (IOException exp) {
			System.out.println("Error in creation of the output file: " + exp.getMessage());
		}

	}

	@AfterClass
	public static void tearDown() {
		if (wr != null)
			try {
				wr.close();
			} catch (IOException e) {
				System.out.println("Error in closing the output file: "+e.getMessage());
			}
	}

	@Test
	public void testInsertSort() {
		Stopwatch timer;
		double elapTime;
		try {
			wr.write("sortInsert");
			System.out.print("sortInsert");

			timer = new Stopwatch();
			Insertion.sortInsert(x4);
			elapTime = timer.elapsedTime();
			wr.write(","+elapTime);
			System.out.print(","+elapTime);
			assertEquals(16,x4.length);
			assertTrue(isSorted(x4));

			timer = new Stopwatch();
			Insertion.sortInsert(x6);
			elapTime = timer.elapsedTime();
			System.out.print(","+elapTime);
			wr.write(","+elapTime);
			assertEquals(64,x6.length);
			assertTrue(isSorted(x6));
			
			timer = new Stopwatch();
			Insertion.sortInsert(x8);
			elapTime = timer.elapsedTime();
			wr.write(","+elapTime);
			System.out.print(","+elapTime);
			assertEquals(256,x8.length);
			assertTrue(isSorted(x8));
			
			timer = new Stopwatch();
			Insertion.sortInsert(x10);
			elapTime = timer.elapsedTime();
			wr.write(","+elapTime);
			System.out.print(","+elapTime);
			assertEquals(1024,x10.length);
			assertTrue(isSorted(x10));

			timer = new Stopwatch();
			Insertion.sortInsert(x12);
			elapTime = timer.elapsedTime();
			wr.write(","+elapTime);
			System.out.print(","+elapTime);
			assertEquals(4096,x12.length);
			assertTrue(isSorted(x12));

//			timer = new Stopwatch();
//			Insertion.sortInsert(x14);
//			elapTime = timer.elapsedTime();
//			wr.write(","+elapTime);
//			System.out.print(","+elapTime);
//			assertEquals(16384,x14.length);
//			assertTrue(isSorted(x14));
//			
//			timer = new Stopwatch();
//			Insertion.sortInsert(x16);
//			elapTime = timer.elapsedTime();
//			wr.write(","+elapTime);
//			System.out.print(","+elapTime);
//			assertEquals(65536,x16.length);
//			assertTrue(isSorted(x16));
//			
//			timer = new Stopwatch();
//			Insertion.sortInsert(x18);
//			elapTime = timer.elapsedTime();
//			wr.write(","+elapTime);
//			System.out.print(","+elapTime);
//			assertEquals(262144,x18.length);
//			assertTrue(isSorted(x18));
			
			System.out.println();
			wr.write("\r\n");
			
		} catch (IOException e) {
			System.out.println("Error in write to the output file: " + e.getMessage());
		}
	}

	@Test
	public void testInsertComparable() {	
		Stopwatch timer;
		double elapTime;
		try {
			wr.write("sortComparable");
			System.out.print("sortComparable");

			timer = new Stopwatch();
			Insertion.sortComparable(x4, x4.length);
			elapTime = timer.elapsedTime();
			wr.write(","+elapTime);
			System.out.print(","+elapTime);
			assertEquals(16,x4.length);
			assertTrue(isSorted(x4));

			timer = new Stopwatch();
			Insertion.sortComparable(x6, x6.length);
			elapTime = timer.elapsedTime();
			wr.write(","+elapTime);
			System.out.print(","+elapTime);
			assertEquals(64,x6.length);
			assertTrue(isSorted(x6));

			timer = new Stopwatch();
			Insertion.sortComparable(x8, x8.length);
			elapTime = timer.elapsedTime();
			wr.write(","+elapTime);
			System.out.print(","+elapTime);
			assertEquals(256,x8.length);
			assertTrue(isSorted(x8));

			timer = new Stopwatch();
			Insertion.sortComparable(x10, x10.length);
			elapTime = timer.elapsedTime();
			wr.write(","+elapTime);
			System.out.print(","+elapTime);
			assertEquals(1024,x10.length);
			assertTrue(isSorted(x10));

			timer = new Stopwatch();
			Insertion.sortComparable(x12, x12.length);
			elapTime = timer.elapsedTime();
			wr.write(","+elapTime);
			System.out.print(","+elapTime);
			assertEquals(4096,x12.length);
			assertTrue(isSorted(x12));
			
//			timer = new Stopwatch();
//			Insertion.sortComparable(x14, x14.length);
//			elapTime = timer.elapsedTime();
//			wr.write(","+elapTime);
//			System.out.print(","+elapTime);
//			assertEquals(16384,x14.length);
//			assertTrue(isSorted(x14));
//			
//			timer = new Stopwatch();
//			Insertion.sortComparable(x16, x16.length);
//			elapTime = timer.elapsedTime();
//			wr.write(","+elapTime);
//			System.out.print(","+elapTime);
//			assertEquals(65536,x16.length);
//			assertTrue(isSorted(x16));
//			
//			timer = new Stopwatch();
//			Insertion.sortComparable(x18, x18.length);
//			elapTime = timer.elapsedTime();
//			wr.write(","+elapTime);
//			System.out.print(","+elapTime);
//			assertEquals(262144,x18.length);
//			assertTrue(isSorted(x18));
			
			System.out.println();
			wr.write("\r\n");
			
		} catch (IOException e) {
			System.out.println("Error in write to the output file: " + e.getMessage());
		}
		
	}

	@Test
	public void testInsertBinary() {
		Stopwatch timer;
		double elapTime;
		try {
			wr.write("sortBinary");
			System.out.print("sortBinary");

			timer = new Stopwatch();
			Insertion.sortBinary(x4, x4.length);
			elapTime = timer.elapsedTime();
			wr.write(","+elapTime);
			System.out.print(","+elapTime);
			assertEquals(16,x4.length);
			assertTrue(isSorted(x4));

			timer = new Stopwatch();
			Insertion.sortBinary(x6, x6.length);
			elapTime = timer.elapsedTime();
			wr.write(","+elapTime);
			System.out.print(","+elapTime);
			assertEquals(64,x6.length);
			assertTrue(isSorted(x6));

			timer = new Stopwatch();
			Insertion.sortBinary(x8, x8.length);
			elapTime = timer.elapsedTime();
			wr.write(","+elapTime);
			System.out.print(","+elapTime);
			assertEquals(256,x8.length);
			assertTrue(isSorted(x8));

			timer = new Stopwatch();
			Insertion.sortBinary(x10, x10.length);
			elapTime = timer.elapsedTime();
			wr.write(","+elapTime);
			System.out.print(","+elapTime);
			assertEquals(1024,x10.length);
			assertTrue(isSorted(x10));

			timer = new Stopwatch();
			Insertion.sortBinary(x12, x12.length);
			elapTime = timer.elapsedTime();
			wr.write(","+elapTime);
			System.out.print(","+elapTime);
			assertEquals(4096,x12.length);
			assertTrue(isSorted(x12));	

//			timer = new Stopwatch();
//			Insertion.sortBinary(x14, x14.length);
//			elapTime = timer.elapsedTime();
//			wr.write(","+elapTime);
//			System.out.print(","+elapTime);
//			assertEquals(16384,x14.length);
//			assertTrue(isSorted(x14));	
//
//			timer = new Stopwatch();
//			Insertion.sortBinary(x16, x16.length);
//			elapTime = timer.elapsedTime();
//			wr.write(","+elapTime);
//			System.out.print(","+elapTime);
//			assertEquals(65536,x16.length);
//			assertTrue(isSorted(x16));	
//
//			timer = new Stopwatch();
//			Insertion.sortBinary(x18, x18.length);
//			elapTime = timer.elapsedTime();
//			wr.write(","+elapTime);
//			System.out.print(","+elapTime);
//			assertEquals(262144,x18.length);
//			assertTrue(isSorted(x18));	

			System.out.println();
			wr.write("\r\n");
		} catch (IOException e) {
			System.out.println("Error in write to the output file: " + e.getMessage());
		}
	}

	@Test
	public void testMergeSort() {	
		Stopwatch timer;
		double elapTime;
		try {
			wr.write("sortMerge");
			System.out.print("sortMerge");

			timer = new Stopwatch();
			Merge.sortMerge(x4, x4.length);
			elapTime = timer.elapsedTime();
			wr.write(","+elapTime);
			System.out.print(","+elapTime);
			assertEquals(16,x4.length);
			assertTrue(isSorted(x4));

			timer = new Stopwatch();
			Merge.sortMerge(x6, x6.length);
			elapTime = timer.elapsedTime();
			wr.write(","+elapTime);
			System.out.print(","+elapTime);
			assertEquals(64,x6.length);
			assertTrue(isSorted(x6));

			timer = new Stopwatch();
			Merge.sortMerge(x8, x8.length);
			elapTime = timer.elapsedTime();
			wr.write(","+elapTime);
			System.out.print(","+elapTime);
			assertEquals(256,x8.length);
			assertTrue(isSorted(x8));

			timer = new Stopwatch();
			Merge.sortMerge(x10, x10.length);
			elapTime = timer.elapsedTime();
			wr.write(","+elapTime);
			System.out.print(","+elapTime);
			assertEquals(1024,x10.length);
			assertTrue(isSorted(x10));

			timer = new Stopwatch();
			Merge.sortMerge(x12, x12.length);
			elapTime = timer.elapsedTime();
			wr.write(","+elapTime);
			System.out.print(","+elapTime);
			assertEquals(4096,x12.length);
			assertTrue(isSorted(x12));
			
//			timer = new Stopwatch();
//			Merge.sortMerge(x14, x14.length);
//			elapTime = timer.elapsedTime();
//			wr.write(","+elapTime);
//			System.out.print(","+elapTime);
//			assertEquals(16384,x14.length);
//			assertTrue(isSorted(x14));
//
//			timer = new Stopwatch();
//			Merge.sortMerge(x16, x16.length);
//			elapTime = timer.elapsedTime();
//			wr.write(","+elapTime);
//			System.out.print(","+elapTime);
//			assertEquals(65536,x16.length);
//			assertTrue(isSorted(x16));
//
//			timer = new Stopwatch();
//			Merge.sortMerge(x18, x18.length);
//			elapTime = timer.elapsedTime();
//			wr.write(","+elapTime);
//			System.out.print(","+elapTime);
//			assertEquals(262144,x18.length);
//			assertTrue(isSorted(x18));

			System.out.println();
			wr.write("\r\n");
			
		} catch (IOException e) {
			System.out.println("Error in write to the output file: " + e.getMessage());
		}
		
	}

	@Test
	public void testHeapSort() {	
		Stopwatch timer;
		double elapTime;
		try {
			wr.write("sortHeap");
			System.out.print("sortHeap");

			timer = new Stopwatch();
			Heap.sortHeap(x4, x4.length);
			elapTime = timer.elapsedTime();
			wr.write(","+elapTime);
			System.out.print(","+elapTime);
			assertEquals(16,x4.length);
			assertTrue(isSorted(x4));

			timer = new Stopwatch();
			Heap.sortHeap(x6, x6.length);
			elapTime = timer.elapsedTime();
			wr.write(","+elapTime);
			System.out.print(","+elapTime);
			assertEquals(64,x6.length);
			assertTrue(isSorted(x6));

			timer = new Stopwatch();
			Heap.sortHeap(x8, x8.length);
			elapTime = timer.elapsedTime();
			wr.write(","+elapTime);
			System.out.print(","+elapTime);
			assertEquals(256,x8.length);
			assertTrue(isSorted(x8));

			timer = new Stopwatch();
			Heap.sortHeap(x10, x10.length);
			elapTime = timer.elapsedTime();
			wr.write(","+elapTime);
			System.out.print(","+elapTime);
			assertEquals(1024,x10.length);
			assertTrue(isSorted(x10));

			timer = new Stopwatch();
			Heap.sortHeap(x12, x12.length);
			elapTime = timer.elapsedTime();
			wr.write(","+elapTime);
			System.out.print(","+elapTime);
			assertEquals(4096,x12.length);
			assertTrue(isSorted(x12));	

//			timer = new Stopwatch();
//			Heap.sortHeap(x14, x14.length);
//			elapTime = timer.elapsedTime();
//			wr.write(","+elapTime);
//			System.out.print(","+elapTime);
//			assertEquals(16384,x14.length);
//			assertTrue(isSorted(x14));	
//
//			timer = new Stopwatch();
//			Heap.sortHeap(x16, x16.length);
//			elapTime = timer.elapsedTime();
//			wr.write(","+elapTime);
//			System.out.print(","+elapTime);
//			assertEquals(65536,x16.length);
//			assertTrue(isSorted(x16));	
//
//			timer = new Stopwatch();
//			Heap.sortHeap(x18, x18.length);
//			elapTime = timer.elapsedTime();
//			wr.write(","+elapTime);
//			System.out.print(","+elapTime);
//			assertEquals(262144,x18.length);
//			assertTrue(isSorted(x18));	

			System.out.println();
			wr.write("\r\n");

		} catch (IOException e) {
			System.out.println("Error in write to the output file: " + e.getMessage());
		}
	}

}
