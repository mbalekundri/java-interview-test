package com.mphasis.interview.rbs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

// https://howtodoinjava.com/java/forkjoin-framework-tutorial-forkjoinpool-example/
// https://www.youtube.com/watch?v=fGuvosd-L98 [Important]
public class ForkAndJoinTest {

    // Sum up 1 to 100 using 2 threads
    public static void main(String[] args) {

	try (var inputVal = new Scanner(System.in)) {
	    System.out.println("Enter Range of Long");

	    String integerString = inputVal.nextLine();
	    System.out.println("Input range is: 1 to " + integerString);
	    
	    int numberOfProcessors = Runtime.getRuntime().availableProcessors();

	    ForkJoinPool pool = new ForkJoinPool(numberOfProcessors);

	    final Long value = Long.valueOf(integerString);

	    if (value <= 10) {
		System.out.println("Simple task. No need of fork join");
		Long sum = 0L;
		System.out.println(Thread.currentThread());
		for (Long i = 1L; i <= value; i++) {
		    sum += i;
		}
		System.out.println("sum of numbers between 1 and " + value + " is :: " + sum);
	    } else if (value > 10) {
		System.out.println("Complex task. Use Fork join");

		System.out.println("Enter number of threads");

		String threadNumberStr = inputVal.nextLine();

		System.out.println("Input number of threads is: " + threadNumberStr);

		Integer threads = Integer.valueOf(threadNumberStr);

		ForkAndJoinTest test = new ForkAndJoinTest();

		List<SumTask> preparedTasks = test.prepareAndForkTask(value, threads);

		// Stream
		Long sum2 = preparedTasks.stream().map(t -> t.join()).reduce(Long::sum).get();
		System.out.println("Sum of all tasks via stream:" + sum2);

	    }
	} catch (NumberFormatException e) {
	    e.printStackTrace();
	}
    }

    private List<SumTask> prepareAndForkTask(Long value, Integer threads) {

	List<SumTask> tasksList = new ArrayList<>();
	Long start = 1l;
	Long chunchSize = value / threads;
	Long end = 0L;
	for (Long i = 1L; i <= threads; i++) {
	    end += chunchSize;
	    SumTask task = new SumTask("task_" + i, start, end);
	    task.fork();
	    tasksList.add(task);
	    start = end + 1;
	}
	return tasksList;
    }

}

class MyForkJoinTask extends ForkJoinTask<Long> {

    @Override
    public Long getRawResult() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    protected void setRawResult(Long value) {
	// TODO Auto-generated method stub

    }

    @Override
    protected boolean exec() {
	// TODO Auto-generated method stub
	return false;
    }

}

class SumTask extends RecursiveTask<Long> {

    private static final long serialVersionUID = 1L;

    private String taskName;
    private Long start;
    private Long end;

    SumTask(String taskName, Long start, Long end) {
	this.taskName = taskName;
	this.start = start;
	this.end = end;
    }

    @Override
    protected Long compute() {
	Long sum = 0L;
	System.out.println(Thread.currentThread());
	for (Long i = start; i <= end; i++) {
	    sum += i;
	}
	System.out.println(taskName + " :: sum of " + start + " and " + end + " is :: " + sum);
	return sum;
    }
}

class SumAction extends RecursiveAction {

    private static final long serialVersionUID = 1L;

    private String taskName;
    private Long start;
    private Long end;

    SumAction(String taskName, Long start, Long end) {
	this.taskName = taskName;
	this.start = start;
	this.end = end;
    }

    @Override
    protected void compute() {
	Long sum = 0L;
	for (Long i = start; i <= end; i++) {
	    sum += i;
	}
	System.out.println(taskName + " :: sum of " + start + " and " + end + " is :: " + sum);
    }
}

class SumCallable implements Callable<Long> {

    private String taskName;
    private Long start;
    private Long end;

    SumCallable(String taskName, Long start, Long end) {
	this.taskName = taskName;
	this.start = start;
	this.end = end;
    }

    @Override
    public Long call() throws Exception {
	Long sum = 0L;
	for (Long i = start; i <= end; i++) {
	    sum += i;
	}
	System.out.println(taskName + " :: sum of " + start + " and " + end + " is :: " + sum);
	return sum;
    }

}
