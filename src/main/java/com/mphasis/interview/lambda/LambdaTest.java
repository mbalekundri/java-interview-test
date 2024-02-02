package com.mphasis.interview.lambda;

public class LambdaTest {

    public static void main(String[] args) {

	LambdaTest test = new LambdaTest();
	test.execute();

    }

    public void execute() {

//	() ->  System.out.println("Hello!!!") ;
	M1 m1 = () -> System.out.println("Hello!!!");
	m1.m1();

//	(n1,n2) -> System.out.println(n1+n2);
	M2 m2 = (n1, n2) -> System.out.println(n1 + n2);
	m2.m2(6, 7);

	Runnable runner = () -> {
	    System.out.println(Thread.currentThread().getName()+" Runnable with Lambda expression Started.");
	    for (int i = 1; i <= 10; i++) {
		System.out.println(Thread.currentThread().getName()+" Value: "+i);
		try {
		    Thread.sleep(1000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }

	    System.out.println(Thread.currentThread().getName()+" Runnable with Lambda expression completed.");
	};
	
	(new Thread(runner)).start();
	(new Thread(runner)).start();

    }

    public void m1() {
	System.out.println("Hello!!!");
    }

    public void sum(Integer n1, Integer n2) {
	System.out.println(n1 + n2);
    }

    public Integer sumUp(Integer n1, Integer n2) {
	return (n1 + n2);
    }

}

@FunctionalInterface
interface M1 {
    void m1();
}

@FunctionalInterface
interface M2 {
    void m2(Integer n1, Integer n2);
}
