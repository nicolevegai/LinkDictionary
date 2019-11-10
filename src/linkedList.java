import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class linkedList {
    node head = null;
    // node a, b;
    static class node {
        String val;
        node next;

        public node(String val)
        {
            this.val = val;
        }
    }

    node sortedMerge(node a, node b)
    {
        node result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if (a.val.toString().toLowerCase().compareTo(b.val.toString().toLowerCase()) < 0) {
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

    void push(String new_data)
    {
        /* allocate node */
        node new_node = new node(new_data);

        /* link the old list off the new node */
        new_node.next = head;

        /* move the head to point to the new node */
        head = new_node;
    }

    // Utility function to print the linked list
    void printList(node headref, LinkedList<String> dict) throws UnsupportedEncodingException
    {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter("prueba.txt"));
            while (headref != null) {
                writer.write(headref.val);
                writer.newLine();
                // System.out.print(headref.val + " ");
                dict.add(headref.val);
                headref = headref.next;

            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void scanConsole(LinkedList dict) {

        Scanner scan = new Scanner(System.in);
        System.out.println("To find a word position input: word  (The word you want to find),"
                + "To find a word at an index input: index (the index you want to find) or exit to finish looking.  ");
        for (int args = 0; args < 10; args++) { // hasta 10 args


            String command = scan.nextLine();
            String[] tokens = command.split(" ");

            if (tokens[0].equalsIgnoreCase("index")) {
                int index = Integer.parseInt(tokens[1]);
                if (index < 0) {
                    System.out.println("Please input only positive numbers");
                } else {
                    if (index > dict.size()) {
                        System.out.println("-1");// si no existe ese numero

                    } else {
                        System.out.println(dict.get(index-1));
                    }
                }

            } else if (tokens[0].equalsIgnoreCase("word")) {
                int index = 0;
                while (!dict.get(index).toString().equalsIgnoreCase(tokens[1])) {
                    index++;
                    if (index > dict.size()) {
                        System.out.println("-1");// si no existe esa palabra
                    }
                }
                System.out.println(index+1);

            } else if (tokens[0].equalsIgnoreCase("-1")) {
            } else if (tokens[0].equalsIgnoreCase("exit")) {
                break;
            }
            scan.close();

        }
    }
    public static void main(String[] args)
    {
        LinkedList<String> dict = new LinkedList<String>();
        linkedList li = new linkedList();

        long startTime = System.currentTimeMillis();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("unsortedDictTest.txt"));//0 milisecond
            String line = reader.readLine(); //1 milisecond
            int counter = 0;
            while (line != null) {
                li.push(line);
                /*if (dict.size() == 0) {
                    dict.add(line);

                } else {
                    if (!sortList(line, dict)) {
                        dict.add(line);
                    }
//                     System.out.println(dict.indexOf(line));
                }*/
                line = reader.readLine();
            }
            reader.close();
//            System.out.println("END!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.println("file read in: " + endTime + " ms");


        // Apply merge Sort
        li.head = li.mergeSort(li.head);
        //System.out.print("\n Sorted Linked List is: \n");
        try {
            li.printList(li.head, dict);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        endTime = (System.currentTimeMillis() - startTime);
        System.out.println("New file written in: " + endTime + " ms"); //yaaa

        scanConsole(dict);
        endTime = (System.currentTimeMillis() - startTime);
        System.out.println("Console scanned in: " + endTime + " ms"); //yaaa
    }
}
