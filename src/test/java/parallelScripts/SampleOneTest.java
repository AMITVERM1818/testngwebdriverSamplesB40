package parallelScripts;

import org.testng.annotations.Test;

public class SampleOneTest {
 
	
	@Test
	public void testOne() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Test11 in SampleOne..." + id);
  }
	
	@Test
	public void testTwo() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Test12 in SampleOne..." + id);
  }
	
	@Test(invocationCount = 8, threadPoolSize = 3, timeOut = 5000)
	public void testThree() {
	  long id = Thread.currentThread().getId();
	  System.out.println("Test13 in SampleOne..." + id);
  }

}
