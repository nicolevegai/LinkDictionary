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
            reader = new BufferedReader(new FileReader("unsorteddict.txt"));
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
    static int partition(int[] array, int begin, int end) {
    int pivot = end;

    int counter = begin;
    for (int i = begin; i < end; i++) {
        if (array[i] < array[pivot]) {
            int temp = array[counter];
            array[counter] = array[i];
            array[i] = temp;
            counter++;
        }
    }
    int temp = array[pivot];
    array[pivot] = array[counter];
    array[counter] = temp;

    return counter;
}

public static void quickSort(int[] array, int begin, int end) {
    if (end <= begin) return;
    int pivot = partition(array, begin, end);
    quickSort(array, begin, pivot-1);
    quickSort(array, pivot+1, end);
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

