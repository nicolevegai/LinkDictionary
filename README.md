# Software Development
## LinkDictionary Coding Principles
    Pair Work made by: Juan Felipe Gonzalez and Nicole Vega 
    

This branch is to add the coding principles to our  LinkDictionary program. Our goal is to make our program understandable and easy to follow. 

## Requisites:

* Refactor all your code by applying the code principles one by one.
* Edit the README file indicating all the code principles applied and snapshots of examples (a few lines in each case) of how was the code before and after those principles applied.
* If some principle cannot be applied to your project, indicate it in the README as well and justify why.
           
### Coding Principles

#### Coding Principle 1: Meaningful Names
During the testing phase of our project we often used names that we understood and were easy to understand such as “list” or “dict” referring to the LinkedList we had just created and changed it throughout the process. We often changed it to sort through bugs and errors we found. However in order to apply the first coding principle we had to refactor all of these variables and some methods. 
For example:
   
    LinkedList<String> indexLinkedListDictionary = new LinkedList<String>();

Was previously: 
    
    LinkedList<String> dict = new LinkedList<String>();

Also, we applied this coding principle when creating an array that holds all the arguments that were inputed by the user. We used to call it comm and it was not clear so we refactor it and now the array holding this argumenst is called arrayOfArgumentsInputed which is more clear. 

     String argumentsInputed = scan.nextLine();
            String[] arrayOfArgumentsInputed = argumentsInputed.split(" ");
            if (arrayOfArgumentsInputed.length > 10) {
                System.out.println("Only up to 10 commands are allowed!");
                
Was previously: 

     String args = scan.nextLine();
        String[] comm = args.split(" ");
        if (comm.length > 10) {
            System.out.println("Only up to 10 commands are allowed!");

#### Coding Principle 2: Keep functions small
The functions that we have are all usually quite small, and to the point. A good example of this would be the method that we use to find the middle of the list.

    public static node getMiddleOfLinkedList(node head) {
        if (head == null)
            return head;
    
        node slow = head, fast = head;
    
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

#### Coding Principle 3: Avoid redundant commenting
Many of the comments we used to indicate the time it took to do a part of the reading, writing, sorting were used to find bottlenecks in the process and for us to be able to improve upon such bottlenecks. There were often comments like
    
    // 4ms
Or 
    
    // si no existe esa palabra
These are not needed for the end product and would serve no use for another person reading the code. All of these type of comments were removed. We still decided to keep some of the comments that indicate the purpose of a part of the code, since the logic behind the mergesort is often complicated. 

#### Coding Principle 4: Single Responsibility Principle
We didn’t have to change anything here, all of our functions have only one task they have to accomplish. The only thing that we weren’t able to make a single responsibility was the main method. This is because when we were doing the reading of the file and trying to pass each word within a function to the method addValueToLinkedList it didn’t work, because we were trying to make reference to a non-static variable from a non-static context. 

#### Coding Principle 5: Don’t Repeat Yourself
We have turned all of the things that need to be repeated into methods that we can reuse later. This can be seen in the mergeSortedLists, that compares the nodes and then merges the left and right lists that are already sorted. 
   
    node mergeSortedLists(node a, node b) {
        node result = null;
    
        if (a == null)
            return b;
        if (b == null)
            return a;
    
    
        if (a.nodeValue.toString().toLowerCase().compareTo(b.nodeValue.toString().toLowerCase()) < 0) {
            result = a;
            result.next = mergeSortedLists(a.next, b);
        }
        else {
            result = b;
            result.next = mergeSortedLists(a, b.next);
        }
        return result;
    }

#### Coding Principle 6: Keep your code simple
I feel like most of the code is quite simple, besides the logic that is needed in order to understand the actual merge sorting. Below are the links for the mergesort and the fast and slow pointer to find the middle. 
https://www.geeksforgeeks.org/merge-sort/
https://helloacm.com/how-to-compute-the-middle-of-the-linked-list-using-fast-and-slow-pointer/

#### Coding Principle 7: You Aint Gonna Need IT
Some variables and counters we used to test the speed of the app and the places where it was crashing were no longer needed when we finished. 
Example:

    int counter = 0;
    // System.out.print(headref.val + " ");

There were also some parts of the code that were commented that we used, however we left them there just in case we would need them later or maybe if something went wrong we could always come back to the code that we had before. These were also deleted. 
               
                /*if (dict.size() == 0) {
                    dict.add(line);

                } else {
                    if (!sortList(line, dict)) {
                        dict.add(line);
                    }
                     System.out.println(dict.indexOf(line));
                }*/

#### To contact the collaborators please write us an email
    mvega.ieu2017@student.ie.edu
    jgonzalez.ieu2017@student.ie.edu
