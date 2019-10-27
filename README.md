# Software Development
## LinkDictionary
    Pair Work made by: Juan Felipe Gonzalez and Nicole Vega 
    
This Repository is a project for our Software Development couse. We are creating a Dictionary of ordered words using linked lists. The idea of the project is for it to be done without the sorting method included in the java library. Therefore we had to create an algorithm that would sort the words by placing them in alphabetical order in the linked list, as they were read from the unsorted word list. 

![Dictionary](https://cdn-02.independent.ie/world-news/and-finally/article36675155.ece/c261e/AUTOCROP/w620/ipanews_a5b36655-afb2-4d5a-b4e2-fedfbd38de89_1)  
    

### Instructions
You will work in pairs to create a JAVA project to manage a dictionary built using Linked lists. 

  **1.**  First create a project on Github (follow the usual instructions).   
  **2.**  Clone the project on one’s computer.   
  **3.**  Both members will be coding in one’s computer.   
  **4.**  When they decide, they will commit the code, push it to a repository created by themselves and then the other member will fork it, clone it and start making modifications on the other’s computer. It doesn’t matter in which computer you are working, both of you will be all the time discussing the code and making modifications on just one computer. 


### Requisites:
* The application will be able to open a file called “unsorteddict.txt”
* This file will be a collection of words where each line contains a word
* The application will read the file line by line, in other words, it will read a new word each time a new line is read
  * Each time a new line is read, the new word will be inserted in the correct position of a data structure called “dictionary” that will be of a Linked list type
  * Therefore , this “dictionary” will be a sorted list of all the words read from the file
* After the “unsorteddict.txt” has been fully read, the application will create another file called “sorteddict.txt” which will contain all the words (one word per line) alphabetically ordered
* The application will also accept command line arguments, i.e. it could be executed as java LinkDictionary 23 butterfly
  * The application will accept a minimum of 0 arguments and a maximum of 10 arguments
  * If the argument is a number, the corresponding word placed in that position in the ordered linked list “dictionary” should be printed out on the console
  * If the argument is a word, the application should print out in the console the number that represent the order of that word inside the dictionary. If it doesn’t exist, it should write “-1”.
* Just traversing the list to find out one word inside the Linked list can be a slow process. Additionaly to the Linked list, other kind of data structures, algorithms or variables can be used to improve the search
  * If you want to opt for this points, create the code for the improved search method in a branch called “faster”. 
   * **IMPORTANT:** First deliver all the previous requisites, on “master”. Then create a new branch called “faster” and keep coding on this branch the new method





### The Files included in this Repository are:
  * [README.md](https://github.com/nicolevegai/LinkDictionary/blob/master/README.md)
  * [.gitignore](https://github.com/nicolevegai/LinkDictionary/blob/master/.gitignore)
  * [LinkDictionary.java](https://github.com/nicolevegai/LinkDictionary/blob/master/src/Linkdictionary.java)
  * [unsorteddict.txt](https://github.com/nicolevegai/LinkDictionary/blob/master/unsorteddict.txt)

#### To contact the collaborators please write us an email
    mvega.ieu2017@student.ie.edu
    jgonzalez.ieu2017@student.ie.edu
