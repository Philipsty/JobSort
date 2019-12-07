## JobSort
The CPU scheduler can aim for one of many different goals 
such as, ensuring the highest number of jobs are being processed 
during a time period, minimizing the amount of time each job has 
to wait, or ensuring that each job gets an equal amount of processing
time.
One common scheduling policy is shortest  job  first. If we have 
N jobs to complete at time t, each job j requiring jt seconds of 
processing time, then the job with the lowest processing time would 
be scheduled first.

JobSort implements three sorting algorithms for a number of scheduling problems
of  various  size. It uses insertion sort, Merge sort, and Heap sort.

It input file of jobs to sort. For this assignment, you are asked to sort
5 arrays of size 2^4, 2^6, 2^8, 2^10 and 2^12 elements respectively:
each element representing a job with a unique ID,an integer 
executiontime (in seconds), and an arrival time.

Job ADT stores each job's b’s ID,execution time, and arrival 
time together in an abstract  data type called  Job  that  implements 
the Comparable interface. 

## Testing
JUnit class that tests all of the sorting allgorithms

![screenshot 166](https://user-images.githubusercontent.com/16392778/30237398-5bc51d1c-94ff-11e7-811a-cfdd6350c695.png)
