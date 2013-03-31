Stopwatch
=========

Easy stopwatch

Light weight StopWatch 
- Minimal object creation 
- Print the task and time in descending order [The time consuming task will be printed first]
- Easy 2 use. 


Usages
Stopwatch sw = new Stopwatch(); 

  sw.start();
  
//  After Task 1 completion

    sw.measure("Task1"); 
   
//  After Task 2 completion

    sw.measure("Task2");
   
 // After Task 3 completion  
 
    sw.measure("Task3 Complete"); 
   
// It will print time consumed by task A, B and C in descending order

    sw.stop(); 
   
   
   
Example
    		
		Stopwatch sw = new Stopwatch();
    		
  		sw.start();  	
  		
		Thread.sleep(100);
		
		sw.measure("A");
		
		Thread.sleep(1000);
		
		sw.measure("B");
		
		Thread.sleep(10);
		
		sw.measure("C");
		
		sw.stop(true);
		
    
    
Result

Tasks   	-> time (seconds)

--------------------------------------

B 		-> 0.9998708270000001

A 		-> 0.09936619899999999

C 		-> 0.009950136

Sum(Tasks)	-> 1.109187162


Read more about Stopwatch here http://01ms.blogspot.com/2013/03/simple-java-stopwatch.html

    
    
    
    
