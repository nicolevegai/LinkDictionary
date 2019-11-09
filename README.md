# Software Development
## LinkDictionary TESTING
    Pair Work made by: Juan Felipe Gonzalez and Nicole Vega 
    

This branch is the testing of our LinkDictionary program. Our goal is to find inefficienncies in the code to improve it. And then test how our program runs with 

## Requisites:

#### Performance test
  * Using System.currentTimeMillis() to evaluate timing in different parts of your code
  * Find bottlenecks and look for a new solution to them. 
    
    **To deliver:**
    * Place several timers to control what time it takes to do certain tasks. Do printouts to see that info on the console
    * Since some tasks take a variable amount of time, calculate the average, maximum and minimum of certain tasks to have a better understanding of the limitations of our algorithms 
    * Find bottlenecks and fix them 
                                       
#### Verification test
  * Create a test with known values
  * https://tinyurl.com/yxkho8uz
  * Use unsortedDictTest as a test input and check against the values in sortedDictTest
     * You can check random values from your sorted list against the sortedDictTest 
     * What’s the problem of testing random values?
     * How much it takes to test the 10,000 words?
     * Does it worth it?   
    
    **To deliver:**
     * Add code that performs a verification test when the value “-1” is passed to the program as an argument
      * Why don’t we choose the word “test” as an argument to activate the test?
     * Check with several words that the position matches
     * Performs a full test of the 10,000 words
     
     __Check against different inputs__
     * Inputs not expected
     * Numbers beyond the limits, etc. 
    

### The Files included in this Repository are:
  * [README.md](https://github.com/nicolevegai/LinkDictionary/blob/test/README.md)
  * [.gitignore](https://github.com/nicolevegai/LinkDictionary/blob/test/.gitignore)
  * [LinkDictionary.java](https://github.com/nicolevegai/LinkDictionary/blob/test/src/Linkdictionary.java)
  * [testQuickSort.java](https://github.com/nicolevegai/LinkDictionary/blob/test/src/testQuicksort.java) 
  * [unsorteddict.txt](https://github.com/nicolevegai/LinkDictionary/blob/test/unsorteddict.txt)
  * [sorteddict.txt](https://github.com/nicolevegai/LinkDictionary/blob/test/sorteddict.txt)
 
 ## Our Testing
 
 ### Performance test
 
 #### Placing Timers to find Inneficiencies 
 We placed timers to see in how much different methods where finished. 
 
**sortList()**

We found that the most inefficient part of our code is the sortList method. We realized that using CurrentTimeMills() method we printed how much it took for 1000 words to be sorted. And the times where increasing with each iteration. For 10000 words the time elapsed is 2:03 minutes.  
    
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


##### read(dict)
        
      read(dict);
            endTime = (System.currentTimeMillis() - startTime);
            System.out.println("file read in: " + endTime + " ms");
            
| Number of repetitions of method   |  Time elapsed in ms| 
|------------|:-----------------:|
| 1     |   288310 | 
| 2     |   186160 |
| 3     |   187814 |
| 4     |   183752 |
| 5     |   189252  |
| 6     |    |
| 7     |    |
| 8     |    |
| 9     |    |
| 10    |    |
| Average   |    |
| Maximum    |    |
| Minimum   |    |
            
##### writeFile(dict)
        
        writeFile(dict);
            endTime = (System.currentTimeMillis() - startTime);
            System.out.println("New file written in: " + endTime + " ms"); 
            
| Number of repetitions of method   |  Time elapsed in ms| 
|------------|:-----------------:|
| 1     |  288479  | 
| 2     |  186317  |
| 3     |  187971  |
| 4     |  183908  |
| 5     |   189414  |
| 6     |    |
| 7     |    |
| 8     |    |
| 9     |    |
| 10    |    |
| Average   |    |
| Maximum    |    |
| Minimum   |    |
            
 
##### scanConsole()

    scanConsole(dict);
            endTime = (System.currentTimeMillis() - startTime);
            System.out.println("Console scanned in: " + endTime + " ms"); //yaaa
 

 | Number of repetitions of method   |  Time elapsed in ms| 
|------------|:-----------------:|
| 1     |   305544 | 
| 2     |   191291 |
| 3     |   191298 |
| 4     |   187006 |
| 5     |  194548  |
| 6     |    |
| 7     |    |
| 8     |    |
| 9     |    |
| 10    |    |
| Average   |    |
| Maximum    |    |
| Minimum   |    |
            

### Improvements

#### Sort list faster
 
 
 

### Verification Test 

Add code that performs a verification test when the value “-1” is passed to the program as an argument
     * Why don’t we choose the word “test” as an argument to activate the test?
     * Check with several words that the position matches
     * Performs a full test of the 10,000 words


 

#### To contact the collaborators please write us an email
    mvega.ieu2017@student.ie.edu
    jgonzalez.ieu2017@student.ie.edu
