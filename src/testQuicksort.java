import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class testQuicksort {

    LinkedList<String> dict = new LinkedList<String>();

    public static void main(String args[]) throws NumberFormatException {



        // TIME TESTING
        long startTime = System.currentTimeMillis();

        sortList();
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.println("Time to sort Linked List: " + endTime + "ms");

        try {

            read();
            endTime = (System.currentTimeMillis() - startTime);
            System.out.println("file read in: " + endTime + "ms");

            writeFile();
            endTime = (System.currentTimeMillis() - startTime);
            System.out.println("New file written in: " + endTime + "ms");

            scanConsole();
            endTime = (System.currentTimeMillis() - startTime);
            System.out.println("Console scanned in: " + endTime + "ms");


        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

    public static void read()throws FileNotFoundException {

                try {
                    BufferedReader reader = new BufferedReader(new FileReader("unsorteddict.txt"));//0 milisecond
                    String line = reader.readLine(); //1 milisecond
                    int counter = 0;
                    while (line != null) {

                        if (dict.size() == 0) {
                            dict.add(line);

                        } else {
                            if (!sortList(line, dict)) {
                                dict.add(line);
                            }
                            // System.out.println(dict.indexOf(line));
                        }
                        line = reader.readLine();
                        counter++;
                        if (counter > 1000) {
                            long endTime = System.currentTimeMillis();
                            long totalTime = endTime - startTime;
                            System.out.println(totalTime + " miliseconds elapsed or " + totalTime / 1000 + " seconds");
                            counter = 0;
                        }
                    }


                    reader.close();
                    System.out.println("END!!!");


                } catch (IOException e) {
                    e.printStackTrace()
                }

            }
    public static void createLinkedList() {



        }

    public static void writeFile() throws FileNotFoundException, UnsupportedEncodingException {

            BufferedWriter writer = new BufferedWriter(new FileWriter("prueba.txt"));
            for (int i = 0; i < dict.size(); i++) {
                System.out.println(dict.get(i));
                writer.write(dict.get(i).toString());
                writer.newLine();
            }

            writer.close();

            }


    public static boolean sortList(String inputvalue, List list) {
        boolean retorno = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toString().toLowerCase().compareTo(inputvalue.toLowerCase()) > 0) {
                if (i == 0) {
                    list.add(0, inputvalue);
                } else {
                    list.add(i, inputvalue);
                }
                retorno = true;
                break;
            }
        }
        return retorno;
    }

    public static void scanConsole() throws FileNotFoundException {
        try {


            Scanner scan = new Scanner(System.in);
            for (int arg = 0; arg < 10; arg++) { // hasta 10 args
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

                } else if (tokens[0].equalsIgnoreCase("exit")) {
                    break;
                }
            }
            scan.close();
        } catch (IOException e) {
            e.printStackTrace()
        }

    }
}





