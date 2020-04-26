
class ClassOneTask extends Thread                                 // Class 1 , where Thread 1 is created
{

	public void run()
	{
		System.out.println("\n" + Thread.currentThread().getName() + "Started..");  // To display the name of the current thread executing
		for(int i=0;i<5;i++)
		{
			System.out.println("Hey!!");
			try 
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "Ended..");
	}

}
class ClassTwoTask extends Thread                                  // Class 2 , where Thread 2 is created
{

	public void run()
	{
		System.out.println("\n" + Thread.currentThread().getName()+ "Started....!");   // To display the name of the current running thread
		for(int i=0;i<5;i++)
		{
			System.out.println("Hello....!!");
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+ "Ended....!");
	}

}

public class MultiThreadingExample                                 // Main Thread of the class is created here
{

	public static void main(String args[]) throws InterruptedException
	{

		long start = System.currentTimeMillis();                   // To calculate the executing time for the start

		System.out.println(Thread.currentThread().getName() + "Started..!");
		
		ClassOneTask T1 = new ClassOneTask();
		T1.start();

		ClassTwoTask T2 = new ClassTwoTask();
		T2.start();	

		T1.join();													// Join method is used to wait for the other thread to die or
		T2.join();													// - or to finish the execution of the current thread
        
		long l = System.currentTimeMillis() - start;                // To calculate the execution time only of the thread and not the system time2
		System.out.println("\n Total time taken by the thread to execute (Seconds) is : " + l );  

		System.out.println("\n"+Thread.currentThread().getName() + "Ends..!");
	}

}
