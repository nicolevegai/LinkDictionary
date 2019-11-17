import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class linkedList {
    node head = null;
    // node a, b;
    static class node {
        String nodeValue;
        node next;

        public node(String nodeValue) {
            this.nodeValue = nodeValue;
        }
    }
    node mergeSort(node headNode) {
        if (headNode == null || headNode.next == null) {
            return headNode;
        }

        // get the middle of the list
        node middle = getMiddleOfLinkedList(headNode);
        node nextofmiddle = middle.next;

        // set the next of middle node to null
        middle.next = null;

        // Apply mergeSort on left list
        node left = mergeSort(headNode);

        // Apply mergeSort on right list
        node right = mergeSort(nextofmiddle);

        // Merge the left and right lists
        node sortedlist = mergeSortedLists(left, right);
        return sortedlist;
    }

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

    void addValueToLinkedList(String new_data) {
        // allocate new node
        node new_node = new node(new_data);

        // link the old list to the new node
        new_node.next = head;

        // move the head to point to the new node
        head = new_node;
    }

    void createLinkedListDictionaryText(node headReference, LinkedList<String> indexLinkedListDictionary) throws UnsupportedEncodingException {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter("SortedDictionary.txt"));
            while (headReference != null) {
                writer.write(headReference.nodeValue);
                writer.newLine();
                indexLinkedListDictionary.add(headReference.nodeValue);
                headReference = headReference.next;

            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void scanConsole(LinkedList indexLinkedListDictionary) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Please input a minimum of 0 and a maximum of 10 commands args separated by a space to find a word or index");
        String args = scan.nextLine();
        String[] comm = args.split(" ");
        if (comm.length > 10) {
            System.out.println("Only up to 10 commands are allowed!");
        }
        else {

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
                    else {

                        if ( i < -1) {
                            System.out.println("NOT VALID NUMBER!!");
                        }
                        else if (i < comm.length){
                            System.out.println("NOT VALID NUMBER!!");
                        }
                        else {
                            System.out.println(indexLinkedListDictionary.get(Integer.parseInt(comm[i])));
                        }
                    }
                }
                catch (Exception e) {
                    int index = 0;
                    while (!indexLinkedListDictionary.get(index).toString().equalsIgnoreCase(comm[i])) {
                        index++;
                        if (index > indexLinkedListDictionary.size()) {
                            System.out.println("-1");// si no existe esa palabra
                        }


                    }
                    System.out.println(index);
                }
            }
        }
    }

    public static void main(String[] args) {

        LinkedList<String> indexLinkedListDictionary = new LinkedList<String>();
        linkedList linkedListDictionary = new linkedList();

        long startTime = System.currentTimeMillis();

        //Read the file with the words
        try {
            BufferedReader reader = new BufferedReader(new FileReader("unsortedDictTest.txt"));
            String line = reader.readLine();
            while (line != null) {
                linkedListDictionary.addValueToLinkedList(line);
                line = reader.readLine();
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.println("file read in: " + endTime + " ms");


        // Apply merge Sort
        linkedListDictionary.head = linkedListDictionary.mergeSort(linkedListDictionary.head);
        try {
            linkedListDictionary.createLinkedListDictionaryText(linkedListDictionary.head, indexLinkedListDictionary);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        endTime = (System.currentTimeMillis() - startTime);
        System.out.println("New file written in: " + endTime + " ms");

        scanConsole(indexLinkedListDictionary);
        endTime = (System.currentTimeMillis() - startTime);
        System.out.println("Console scanned in: " + endTime + " ms");
    }
}
