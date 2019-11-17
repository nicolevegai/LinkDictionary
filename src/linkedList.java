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
        BufferedWriter writer_InNewFile;
        try {
            writer_InNewFile = new BufferedWriter(new FileWriter("SortedDictMergeSort.txt"));
            while (headReference != null) {
                writer_InNewFile.write(headReference.nodeValue);
                writer_InNewFile.newLine();
                indexLinkedListDictionary.add(headReference.nodeValue);
                headReference = headReference.next;

            }
            writer_InNewFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void argumentsInput(LinkedList indexLinkedListDictionary) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Please input a minimum of 0 and a maximum of 10 commands args separated by a space to find a word or index");
        String argumentsInputed = scan.nextLine();
        String[] arrayOfArgumentsInputed = argumentsInputed.split(" ");
        if (arrayOfArgumentsInputed.length > 10) {
            System.out.println("Only up to 10 commands are allowed!");
        }
        else {

            for (int userArgument = 0; userArgument < arrayOfArgumentsInputed.length ; userArgument++){
                try {
                    if (Integer.parseInt(arrayOfArgumentsInputed[userArgument]) == -1) {

                        BufferedReader readSortedDictMadeByMergeSort = new BufferedReader(new FileReader("SortedDictMergeSort.txt"));
                        BufferedReader readSortedDictGivenToTest = new BufferedReader(new FileReader("sortedDictTest.txt"));

                        String lineSortedDictMergeSort = readSortedDictMadeByMergeSort.readLine();
                        String lineinSortDictTest = readSortedDictGivenToTest.readLine();

                        boolean linesAreTheSame = true;
                        int PositionOfLine = 1;


                        while (lineSortedDictMergeSort != null || lineinSortDictTest != null) {
                            if (lineSortedDictMergeSort == null || lineinSortDictTest == null) {
                                linesAreTheSame = false;
                                break;
                            }
                            else if (!lineSortedDictMergeSort.equalsIgnoreCase(lineinSortDictTest)) {
                                linesAreTheSame = false;
                                break;
                            }

                            lineSortedDictMergeSort = readSortedDictMadeByMergeSort.readLine();
                            lineinSortDictTest = readSortedDictGivenToTest.readLine();
                            PositionOfLine++;
                        }

                        if (linesAreTheSame) {
                            System.out.println("Files are exactly the same! :)");
                        }
                        else {
                            System.out.println("The files are not the same. SortDictus has " + " ( "+ lineSortedDictMergeSort + " )"  + " and sortedDictTest has " + "( " + lineinSortDictTest+ " )" + " in the line " + PositionOfLine + ":(" );
                        }
                        readSortedDictMadeByMergeSort.close();
                        readSortedDictGivenToTest.close();
                    }
                    else {

                        if ( Integer.parseInt(arrayOfArgumentsInputed[userArgument]) < -1) {
                            System.out.println("-1");
                        }
                        else if (userArgument < arrayOfArgumentsInputed.length){
                            System.out.println("-1");
                        }
                        else {
                            System.out.println(indexLinkedListDictionary.get(Integer.parseInt(arrayOfArgumentsInputed[userArgument])));
                        }
                    }
                }
                catch (Exception e) {
                    int indexinLinkedListDict = 0;
                    while (!indexLinkedListDictionary.get(indexinLinkedListDict).toString().equalsIgnoreCase(arrayOfArgumentsInputed[userArgument])) {
                        indexinLinkedListDict++;
                        if (indexinLinkedListDict > indexLinkedListDictionary.size()) {
                            System.out.println("-1");
                        }
                    }
                    System.out.println(indexinLinkedListDict + 1);
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

        argumentsInput(indexLinkedListDictionary);
        endTime = (System.currentTimeMillis() - startTime);
        System.out.println("Console scanned in: " + endTime + " ms");
    }
}
