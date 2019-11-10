import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class testing {

    public static void main(String[] args) throws NumberFormatException {
        LinkedList<String> dict = new LinkedList<String>();

        // TIME TESTING
        long startTime = System.currentTimeMillis();
        try {

            read(dict);
            long endTime = (System.currentTimeMillis() - startTime);
            System.out.println("file read in: " + endTime + " ms" + " = " + endTime/1000 + " seconds" + " = " + (endTime/1000)/60 + " minutes " );

            writeFile(dict);
            endTime = (System.currentTimeMillis() - startTime);
            System.out.println("New file written in: " + endTime + " ms" + " = " + endTime/1000 + " seconds" + " = " + (endTime/1000)/60 + " minutes ");

            scanConsole(dict);
            endTime = (System.currentTimeMillis() - startTime);
            System.out.println("Console scanned in: " + endTime + " ms"+ " = " + endTime/1000 + " seconds" + " = " + (endTime/1000)/60 + " minutes ");
        }
        catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    public static void read(LinkedList dict) throws FileNotFoundException {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("unsortedDictTest.txt"));//0 milisecond
            String line = reader.readLine(); //1 milisecond
            int counter = 0;
            while (line != null) {

                if (dict.size() == 0) {
                    dict.add(line);

                }
                else {
                    if (!sortList(line, dict)) {
                        dict.add(line);
                    }
//                     System.out.println(dict.indexOf(line));
                }
                line = reader.readLine();
                /*
                counter++;
                if (counter > 1000) {
                    long endTime = System.currentTimeMillis();
                    long totalTime = endTime - startTime;
                    System.out.println(totalTime + " miliseconds elapsed or " + totalTime / 1000 + " seconds");
                    counter = 0;
                }
                 */
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(LinkedList dict) throws FileNotFoundException, UnsupportedEncodingException {

        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter("SortDictus.txt"));
            for (int i = 0; i < dict.size(); i++) {
                //System.out.println(dict.get(i));
                writer.write(dict.get(i).toString());
                writer.newLine();
            }
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean sortList(String inputvalue, List list)  {
        {
            boolean retorno = false;

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).toString().toLowerCase().compareTo(inputvalue.toLowerCase()) > 0) {
                    if (i == 0) {
                        list.add(0, inputvalue);
                    }
                    else {
                        list.add(i, inputvalue);
                    }
                    retorno = true;
                    break;
                }
            }
            return retorno;
        }
    }

    public static void scanConsole(LinkedList dict)   {

        Scanner scan = new Scanner(System.in);
        System.out.println("Please input a minimum of 0 and a maximum of 10 commands args separated by a space to find a word or index");
        String args = scan.nextLine();
        String[] comm = args.split(" ");
        if (comm.length > 10) {
            System.out.println("Only up to 10 commands are allowed!");

        } else {

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
                        System.out.println(dict.get(Integer.parseInt(comm[i])));
                    }

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
            }
        }

    }
}





    /*
        Scanner scan = new Scanner(System.in);
            for (int args = 0; args < 10; args++) { // hasta 10 args

                System.out.println("To find a word position input: word  (The word you want to find),"
                        + "To find a word at an index input: index (the index you want to find) or exit to finish looking.  ");

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
                            System.out.println(dict.get(index));
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
                    System.out.println(index);

                }   else if (tokens[0].equalsIgnoreCase("-1")){
                }

                    else if (tokens[0].equalsIgnoreCase("exit")) {
                    break;
                }
            scan.close();

        }


    */