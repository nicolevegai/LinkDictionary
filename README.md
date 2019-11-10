# Software Development
## LinkDictionary TESTING
    Pair Work made by: Juan Felipe Gonzalez and Nicole Vega 
    

This branch is the testing of our LinkDictionary program. Our goal is to find inefficienncies in the code to improve it. And then test how our program runs with the new text files when the user inputs -1 and to see if the file generated with our algorithm sorts the program in a way that the words are in the same position as in sortedDictTest.txt. 

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
    
 
 ## Our Testing
 
 ### Performance test
 
 #### Placing Timers to find Inneficiencies 
 We placed timers to see in how much different methods where finished. 
 
**sortList()**

We found that the most inefficient part of our code is the sortList method. We realized that using CurrentTimeMills() method we printed how much it took for 1000 words to be sorted. And the times where increasing with each iteration. For 10000 words the time elapsed is 3:38 minutes. 
    
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



##### read(dict)

We repeated the read() method 10 times and found little time variances between them. The average time is 3,222 minutes (193370,7 ms) because of the bottleneck found in the sortlist() method. In the graphs below we can observe a more detail of each repetition. 
        
      read(dict);
            endTime = (System.currentTimeMillis() - startTime);
            System.out.println("file read in: " + endTime + " ms");
            
| Number of repetitions of method   |  Time elapsed in ms| 
|------------|:-----------------:|
| 1     |   193037 | 
| 2     |   186160 |
| 3     |   187814 |
| 4     |   183752 |
| 5     |   189252  |
| 6     |   186344 |
| 7     |  203919  |
| 8     |   197364 |
| 9     |   200170 |
| 10    |  205895  |
| Average   |   193370,7 |
| Maximum    |   205895 |
| Minimum   |  183752  |
            
 ![imagen](https://scontent-mad1-1.xx.fbcdn.net/v/t1.0-9/75594548_10215436820296261_46527028530249728_n.jpg?_nc_cat=102&_nc_oc=AQkuxf_1i7aKH27YHmeoHntlTxea876BlYwjw5nm2LAcZiPvoYmE_6fG2EFVU91kMvI&_nc_ht=scontent-mad1-1.xx&oh=ff4e1d61fd5e4081b2df418ea0f56c6f&oe=5E419D41)    
 
##### writeFile(dict)
We repeated the writeFile() method 10 times and found little time variances between them. The average time is 3,225 minutes (193528,1  ms) just 0,005 minutes more in average after the read() method is finished so we can see that it is really fast and efficient!. In the graphs below we can observe a more detail of each repetition. 
        
        
        writeFile(dict);
            endTime = (System.currentTimeMillis() - startTime);
            System.out.println("New file written in: " + endTime + " ms"); 
            
| Number of repetitions of method   |  Time elapsed in ms| 
|------------|:-----------------:|
| 1     |  193191  | 
| 2     |  186317  |
| 3     |  187971  |
| 4     |  183908  |
| 5     |   189414  |
| 6     | 186495  |
| 7     |  204076 |
| 8     |   197510 |
| 9     |  200341  |
| 10    |   206058 |
| Average   |  193528,1  |
| Maximum    |  206058  |
| Minimum   |  183908 |
  
   ![imagen](https://scontent-mad1-1.xx.fbcdn.net/v/t1.0-9/75388387_10215436820256260_8607807862179102720_n.jpg?_nc_cat=103&_nc_oc=AQmSZ2zhfRoZMxgnDeaEr60khocM_FvyBUtV_kVvyHcBlanrb0Mkn5_qd8v76ESLwUo&_nc_ht=scontent-mad1-1.xx&oh=5c8668c7ef5e8a88d98b3a483938b2ac&oe=5E512CAA)
 
##### scanConsole()

The scan console time depends in how much time the user inputs a value for the program to print. To test this we input an argument as soon as "Please input a minimum of 0 and a maximum of 10 commands args separated by a space to find a word or index" adding the same number of inputs ( 1 2 ). The average time is 3,38 minutes (203144,7778 ms). We repeated this method 10 times and in the graphs below we can observe a more detail of each repetition. 

    scanConsole(dict);
            endTime = (System.currentTimeMillis() - startTime);
            System.out.println("Console scanned in: " + endTime + " ms"); //yaaa
 

 | Number of repetitions of method   |  Time elapsed in ms| 
|------------|:-----------------:|
| 1     |  214245  | 
| 2     |   191291 |
| 3     |   191298 |
| 4     |   187006 |
| 5     |  194548  |
| 6     |  188438 |
| 7     |   225179 |
| 8     |   219338 |
| 9     |   221024 |
| 10    |   210181 |
| Average   |  203144,7778  |
| Maximum   |  225179  |
| Minimum   |  187006   |

![imagen](https://scontent-mad1-1.xx.fbcdn.net/v/t1.0-9/72756057_10215436819576243_4840895074256551936_n.jpg?_nc_cat=107&_nc_oc=AQl12wGr8v77jb4roHPN3f0YVdlb4tW03h9jFYH8CE_cZScFssfGkPTR21uKEa1CPvg&_nc_ht=scontent-mad1-1.xx&oh=5b573717842b671ebf67f243fe7e89c7&oe=5E4F31DF)

### Improvements

#### Sort list faster

After realizing that what was making inefficient to our code was the sorting method we decided to look for another sorting algorithm. We found that [merge sorting](https://www.geeksforgeeks.org/merge-sort-for-linked-list/) works well with linked lists. 
The merge method drastically improved performance times, however it is important to note that without allocating large amounts of ram to the JVM it will not work and most likely throw an exception. 

To check how we applied merge sorting go to final branch in the [Linkedlist class](https://github.com/nicolevegai/LinkDictionary/blob/final/src/linkedList.java)
#### Scanned Arguments 

We realized that we could hold in an array all the arguments that were inputed to print them all at the same time instead of doing it one per one. To do this we edited the method scanConsole() so it accepted a minimum of 0 and a maximum of 10 arguments and printed their index where a word was found or the index of word at the same time. 

     Scanner scan = new Scanner(System.in);
            System.out.println("Please input a minimum of 0 and a maximum of 10 commands args separated by a space to find a word or index");
            String args = scan.nextLine();
            String[] comm = args.split(" ");
            if (comm.length > 10) {
                System.out.println("Only up to 10 commands are allowed!");
                }
                 else {        
                        System.out.println(dict.get(Integer.parseInt(comm[i])));
                    }
                    catch (Exception e) {
                  int index = 0;
                    while (!dict.get(index).toString().equalsIgnoreCase(comm[i])) {
                        index++;
                        if (index > dict.size()) {
                            System.out.println("-1");// si no existe esa palabra
                        }
                    }
                    System.out.println(index);
                }
                
#### Screenshot of Outputs

![imagen](https://scontent-mad1-1.xx.fbcdn.net/v/t1.0-9/74614874_10215436107358438_5641640779693686784_n.jpg?_nc_cat=110&_nc_oc=AQmyfNPxPUO4sQaixjYBhD9M1lzDcYSXeOBNIJUuuJnvWIerIH4gHS2xQU9EU_bL0ec&_nc_ht=scontent-mad1-1.xx&oh=3249eca5eefa0e88347b04cc9c58bd6e&oe=5E620D0A)




### Verification Test 

To do the Verification Test in the scanConsole() method we added an if clause were if -1 was inputed then the test started. The test consisted in checking line per line (10,000 words) if the words in the file SortDictus.txt (created by us) were in the same position as in sortedDictTest.txt. 

       for (int i = 0; i < comm.length ; i++){
                try {
                    if (Integer.parseInt(comm[i]) == -1) {

                        BufferedReader readsortedus = new BufferedReader(new FileReader("SortDictus.txt"));
                        BufferedReader readunsortchelu = new BufferedReader(new FileReader("sortedDictTest.txt"));

                        String firstl = readsortedus.readLine();
                        String secondl = readunsortchelu.readLine();

                        boolean is = true;
                        int lineNum = 1;

                        while (firstl != null || secondl != null) {
                            if (firstl == null || secondl == null) {
                                is = false;
                                break;
                            }
                            else if (!firstl.equalsIgnoreCase(secondl)) {
                                is = false;
                                break;
                            }

                            firstl = readsortedus.readLine();
                            secondl = readunsortchelu.readLine();
                            lineNum++;
                        }

                        if (is) {
                            System.out.println("Files are exactly the same! :)");
                        }
                        else {
                            System.out.println("The files are not the same. SortDictus has " + " ( "+ firstl + " )"  + " and sortedDictTest has " + "( " + secondl+ " )" + " in the line " + lineNum + ":(" );
                        }
                        readsortedus.close();
                        readunsortchelu.close();
                    }
              }                
   

     
  #### Verification Test Screenshot 
   ![imagen](https://scontent-mad1-1.xx.fbcdn.net/v/t1.0-9/74675005_10215436153679596_2565502996624441344_n.jpg?_nc_cat=104&_nc_oc=AQkn6ipgKM24JWeGX3oj4U_wzr5OqX8AxnuKfq8TsIDUQG41gYC0waMDl6tMP9mj5bs&_nc_ht=scontent-mad1-1.xx&oh=9948e0f201335512bc71786f8b5f3d17&oe=5E430903)
   
 #### Verification of words 
 Here we can see that the words in the file SortDictus.txt and sortedDictTest.txt are in the same position
 ![imagen](https://scontent-mad1-1.xx.fbcdn.net/v/t1.0-9/72159719_10215437510513516_6590964350385651712_n.jpg?_nc_cat=103&_nc_oc=AQlsEmX1RQS0uIGI0RU1dOfeARObmPambGLNVe-t6diuS5Qdvs_b588S8MUKpWpjc9E&_nc_ht=scontent-mad1-1.xx&oh=b51521b0f5cb853483b0f4cf48e1aee1&oe=5E5032B4)
           

#### To contact the collaborators please write us an email
    mvega.ieu2017@student.ie.edu
    jgonzalez.ieu2017@student.ie.edu
