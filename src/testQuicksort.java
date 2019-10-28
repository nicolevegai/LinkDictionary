import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class testQuicksort {
    public static void main(String args[]) throws NumberFormatException {
        long startTime = System.currentTimeMillis();

        LinkedList<String> dict = new LinkedList<String>;

        BufferedReader reader;



        try {
            //
            long readertime = System.currentTimeMillis();
            reader = new BufferedReader(new FileReader("unsorteddict.txt"));
            long endTimered   = System.currentTimeMillis();
            long totalTime = endTimered - readertime;
            System.out.println(totalTime + " miliseconds elapsed");
            String line = reader.readLine();
            while (line != null) {
                if (dict.size() == 0) {
                    dict.add(line);
                } else {
                    if (!sortList(line, dict)) {
                        dict.add(line);
                    }
                    System.out.println(dict.indexOf(line));
                }
                line = reader.readLine();
            }

            long endTime   = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            System.out.println(totalTime + " miliseconds elapsed");
            reader.close();
            System.out.println("END!!!");

            BufferedWriter writer = new BufferedWriter(new FileWriter("prueba.txt"));
            for (int i = 0; i < dict.size(); i++) {
                System.out.println(dict.get(i));
                writer.write(dict.get(i).toString());
                writer.newLine();
            }

            writer.close();





            Scanner scan = new Scanner(System.in);

            for (int arg = 0; arg<10 ; arg++) { // hasta 10 args
                System.out.println("To find a word position input: word  (The word you want to find)," + "To find a word at an index input: index (the index you want to find) or exit to finish looking.  ");
                String command = scan.nextLine();
                String[] tokens = command.split(" ");
                if (tokens[0].equalsIgnoreCase("index")) {
                    int index = Integer.parseInt(tokens[1]);
                    if (index > dict.size()) {
                        System.out.println("-1");// si no existe ese numero
                    } else {
                        System.out.println(dict.get(index));
                    }
                } else if (tokens[0].equalsIgnoreCase("word")) {
                    int index = 0;
                    while (!dict.get(index).equalsIgnoreCase(tokens[1])) {
                        index++;
                        if (index > dict.size()) {
                            System.out.println("-1");// si no existe esa palabra
                        }
                    }
                    System.out.println(index);

                } else if(tokens[0].equalsIgnoreCase("exit")){
                    break;
                }
            }
            scan.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*
    public class linkedList {
    node head = null;
    // node a, b;
    static class node {
        int val;
        node next;

        public node(int val)
        {
            this.val = val;
        }
    }

    node sortedMerge(node a, node b)
    {
        node result = null;
        /* Base cases
        if (a == null)
            return b;
        if (b == null)
            return a;

    // Pick either a or b, and recur
        if (a.val <= b.val) {
        result = a;
        result.next = sortedMerge(a.next, b);
    }
        else {
        result = b;
        result.next = sortedMerge(a, b.next);
    }
        return result;
}

    node mergeSort(node h)
    {
        // Base case : if head is null
        if (h == null || h.next == null) {
            return h;
        }

        // get the middle of the list
        node middle = getMiddle(h);
        node nextofmiddle = middle.next;

        // set the next of middle node to null
        middle.next = null;

        // Apply mergeSort on left list
        node left = mergeSort(h);

        // Apply mergeSort on right list
        node right = mergeSort(nextofmiddle);

        // Merge the left and right lists
        node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    // Utility function to get the middle of the linked list
    public static node getMiddle(node head)
    {
        if (head == null)
            return head;

        node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    void push(int new_data)
    {
        //allocate node
        node new_node = new node(new_data);

       //link the old list off the new node
        new_node.next = head;

        //move the head to point to the new node
       //head = new_node;
    }

    // Utility function to print the linked list
    void printList(node headref)
    {
        while (headref != null) {
            System.out.print(headref.val + " ");
            headref = headref.next;
        }
    }

    public static void main(String[] args)
    {

        linkedList li = new linkedList();

         * Let us create a unsorted linked list to test the functions
         * created. The list shall be a: 2->3->20->5->10->15

        li.push(15);
        li.push(10);
        li.push(5);
        li.push(20);
        li.push(3);
        li.push(2);

        // Apply merge Sort
        li.head = li.mergeSort(li.head);
        System.out.print("\n Sorted Linked List is: \n");
        li.printList(li.head);
    }
}

     */

    public static boolean sortList(String inputvalue, List list){
        boolean retorno = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toString().toLowerCase().compareTo(inputvalue.toLowerCase()) > 0) {
                if(i == 0){
                    list.add(0, inputvalue);
                }else{
                    list.add(i, inputvalue);
                }
                retorno = true;
                break;
            }
        }
        return retorno;
    }
}

