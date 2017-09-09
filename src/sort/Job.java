package sort;

public class Job implements Comparable<Job>{
	private String jobID;
	private int processingTime;
	private int arrivalTime;
	
	/**This is the constructor for the job class
	 *it sets the job's id, processing time and arrical time
	 */
	public Job(String id, int pTime, int aTime)
	{
		this.jobID = id;
		this.processingTime = pTime;
		this.arrivalTime = aTime;
	}
	
	/**this function return the processing time*/
	public int getProcessingTime()
	{
		return this.processingTime;
	}
	/**this function sets the processing time to input t*/
	public void setProcessingTime(int t)
	{
		this.processingTime = t;
	}
	
	/**this function returns the arrival time*/
	public int getArrivalTime()
	{
		return this.arrivalTime;
	}
	/**This function sets the arrival time to t*/
	public void setArrivalTime(int t)
	{
		this.arrivalTime = t;
	}
	/**this function returns the jobID*/
	public String getJobID()
	{
		return this.jobID;
	}
	/**this function sets the jobId to input id*/
	public void setJobID(String id)
	{
		this.jobID = id;
	}
	
	/**
	 * This method compare the current job with another job
	 * @param other: the job to compare with the current job
	 * @return returns -1 when current job (this) is less than the parameter other
	 *                  1 when current job (this) is greater than the parameter other
	 *                  0 when current job (this) is equal to the parameter other
	 */
	@Override
	public int compareTo(Job other)
	{
		if (this == other) 
			return 0;
		if (this.arrivalTime < other.arrivalTime)
			return -1;
		if (this.arrivalTime > other.arrivalTime)
			return 1;
		if (this.processingTime < other.processingTime)
			return -1;
		if (this.processingTime > other.processingTime)
			return 1;
		return 0;
	}
	
	/** this function return a job as formated string like 
	 * {jobIB,jobProcessingTime,arrivalTime}
	 */
	public String toString()
	{
		return String.format("{%s,%d,%d}", jobID, processingTime, arrivalTime);
	}
	
	/**
	 * This method compare two jobs job1 and job2
	 * @param job1: a job to compare it with the second parameter job2
	 * @param job2: a job to compare it with the first parameter job1
	 * @return returns -1 when job1 is less than job2
	 *                  1 when job1 is greater than job2
	 *                  0 when job1 is equal to job2
	 */
	public static int compareTo(Job job1, Job job2) 
	{
		if (job1 == job2) 
			return 0;
		if (job1.getArrivalTime() < job2.getArrivalTime())
			return -1;
		if (job1.getArrivalTime() > job2.getArrivalTime())
			return 1;
		if (job1.getProcessingTime() < job2.getProcessingTime())
			return -1;
		if (job1.getProcessingTime() > job2.getProcessingTime())
			return 1;
		return 0;
	}
	
	/**
	 * This method test if a job is less than another job
	 * @param v: first job
	 * @param w: second job 
	 * @return returns true if v is less than w, false if not
	 */
	public static boolean less(Comparable v, Comparable w)
	{
		 return v.compareTo(w) < 0;  
	} 
	
	/**
	 * This method exchange 2 elements in an array of comparable (Job)
	 * @param a: array of Comparable (Job)
	 * @param i: index of first element to exchange
	 * @param j: index of first element to exchange
	 * @return returns nothing
	 */
	// this method swap elements of array at positions i and j
    public static void exch(Comparable[] a, int i, int j)
    {
		 Comparable t = a[i]; 
		 a[i] = a[j]; 
		 a[j] = t;  
	} 
}
