import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Bqueue{
	public static void main(String []args)
	{ 
		producer p = new producer(); //thread producer
		p.start();
		ExecutorService poolProducer = Executors.newSingleThreadExecutor(); //pool of the thread producer 
		poolProducer.execute(p);
		
		//Configure the number of consumer thread here
		//for example: I have taken taken random consuming threads
		  
		//create instance of Random class 
         Random rand = new Random(); 
  
        // Generate random integers in range 0 to 10 
		final int consumernumber = rand.nextInt(10);;
		ExecutorService poolConsumer = Executors.newCachedThreadPool();
		
		// creating specified number of consumer thread
		for (int i = 0; i < consumernumber; i++) {
			Consumer cr = new Consumer();
			cr.start();
			poolConsumer.execute(cr);
		}
	}
}
 // Queue act as blocking Queue
class Queue 
{
	private static List<Integer> queue =  new ArrayList<Integer>();
	// configure the size of queue
	private static final int limit = 10;
	
	// intitally number of elements in queue
	private static int number = 0;
	
	// initial value added in queue
	private static int value = 0;
	// locking object used to acheive synchronization
	public static Object lock =  new Object();
	
	// Putting into the queue
	static boolean put()
	{
		// checking the limit of the queue
		if(number <= limit)
		{
			queue.add(value);
			System.out.println("New added value "+(value++) +" in queue at "+number++);
			//notifying all the threads which is in waiting state
			lock.notifyAll();
			return true;
		}
		return false;
	}
	
	// Taking from the queue from the front
	static boolean take()
	{
		if(number > 0)
		{
			int value = queue.remove(0);
			System.out.println("Dequeued value "+value+" in queue at "+(--number));
			lock.notify();
			return true;
		}
		return false;
	}	
}
// producer thread  
class producer extends Thread
{
	public void run()
	{
		while(true)
		{
			synchronized (Queue.lock) {
				System.out.print(this.getName()+"  "); 
				
				if(!Queue.put())
				{
					System.out.println("Queue is full. No task is already taken by any of the consumer");
					try {
						Queue.lock.wait();
					} catch(InterruptedException e) {
						System.out.println(e.getMessage());
					}
				}
			}

			try {
				Thread.sleep(3);
			}catch (Exception e) {
			}
		}
	}
}


//consumer thread
class Consumer extends Thread
{
	public void run()
	{
		while(true)
		{
			synchronized (Queue.lock) {
				System.out.print(this.getName()+" - ");
				if(!Queue.take())
				{  
					System.out.println("Queue is empty. There is no task present in the Queue");
					try {
						Queue.lock.wait();
					} catch(InterruptedException e) {
						System.out.println(e.getMessage());
					}
				}
			}
			
			try {
				Thread.sleep(100);
			}catch (Exception e) {
			}
		}
	}
}