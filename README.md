# Software Development
## LinkDictionary TESTING
    Pair Work made by: Juan Felipe Gonzalez and Nicole Vega 
    
    This branch is the testing of our LinkDictionary program. Our goal is to find inefficienncies in the code to improve it. 
    
    

### Instructions
You will work in pairs to create a JAVA project to manage a dictionary built using Linked lists. 

  **1.**  First create a project on Github (follow the usual instructions).   
  **2.**  Clone the project on one’s computer.   
  **3.**  Both members will be coding in one’s computer.   
  **4.**  When they decide, they will commit the code, push it to a repository created by themselves and then the other member 


### Requisites:


### The Files included in this Repository are:
  * [README.md](https://github.com/nicolevegai/LinkDictionary/blob/test/README.md)
  * [.gitignore](https://github.com/nicolevegai/LinkDictionary/blob/test/.gitignore)
  * [LinkDictionary.java](https://github.com/nicolevegai/LinkDictionary/blob/test/src/Linkdictionary.java)
  * [testQuickSort.java](https://github.com/nicolevegai/LinkDictionary/blob/test/src/testQuicksort.java) 
  * [unsorteddict.txt](https://github.com/nicolevegai/LinkDictionary/blob/test/unsorteddict.txt)
  * [sorteddict.txt](https://github.com/nicolevegai/LinkDictionary/blob/test/sorteddict.txt)
 
 ## Our Testing
 ### Finding Inefficiencies
 
 We found that the most inefficient part of our code is the sortList method. We realized that using CurrentTimeMills() method we printed how much it took for 1000 words to be sorted. And the times where increasing with each iteration. 
    
     counter++;
                if(counter > 1000){
                    long endTime   = System.currentTimeMillis();
                    long totalTime = endTime - startTime;
                    System.out.println( totalTime + " miliseconds elapsed or " + totalTime/1000+ " seconds");
                    counter =0;
                }
 
 
| Iteration |  Number of Words   |  Miliseconds | Seconds|
|------------|:-----------------:|-------------:|---------:|
| 1          |  1000             | 194          |0|
| 2          |  2000             | 1503         |1|
| 3          |  3000             | 5114         |5|
| 4          |  4000             | 10725        |10|
| 5          |  5000             | 20572        |20
| 6          |  6000             | 36160        |36|
| 7          |  7000             | 57063        |57|
| 8          |  8000             | 87368        |87|
| 9          |  9000             |  135479      | 135|
| 10         |  10000            |  203354      | 203|


In this table, we can see the time it takes to sort up to 10000 words. 

![graph](/Users/nicolevega/Documents/IE\ UNIVERSITY/3rd\ Year/Software\ Development/Imagen\ 1.jpg)
 

#### To contact the collaborators please write us an email
    mvega.ieu2017@student.ie.edu
    jgonzalez.ieu2017@student.ie.edu
