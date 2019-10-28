# Software Development
## LinkDictionary TESTING
    Pair Work made by: Juan Felipe Gonzalez and Nicole Vega 
    

This branch is the testing of our LinkDictionary program. Our goal is to find inefficienncies in the code to improve it. And then test how our program runs with ...... 
   
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


In this table, we can observe the time it takes to sort up to 10000 words. As the number of words increases so does the time. In the graph below we can see the clear positive tendency. 

![graph](https://scontent-mad1-1.xx.fbcdn.net/v/t1.0-9/74911445_10215327754609687_4745440164837326848_n.jpg?_nc_cat=111&_nc_oc=AQmINfYRU50j1KjxSYQYizQRFwtkUwo25s4F1weLTbdY9kJUpGtlmpwAxgDisKo_sj4&_nc_ht=scontent-mad1-1.xx&oh=18514017dd7700126c97d1e68801abb4&oe=5E19D30E)

After realizing that what was maing inefficient to our code was the sorting method we decided to look for another sorting algorithm. We found that [merge sorting](https://www.geeksforgeeks.org/merge-sort-for-linked-list/) works well with linked lists. 

### Improvements
#### Sort list faster


 

#### To contact the collaborators please write us an email
    mvega.ieu2017@student.ie.edu
    jgonzalez.ieu2017@student.ie.edu
