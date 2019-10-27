import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Linkdictionary {

    public static void main(String args[]) throws NumberFormatException {
        long startTime = System.nanoTime();
        
        BufferedReader reader;
        LinkedList<String> dict = new LinkedList<String>();
        try {
            //
            reader = new BufferedReader(new FileReader("/Users/nicolevega/LinkDictionary_Pair/unsorteddict.txt"));
            String line = reader.readLine();
            while (line != null) {
                if (dict.size() == 0) {
                    dict.add(line);
                } else {
                    if (!sortList(line, dict)) {
                        dict.add(line);
                    }
                }
                line = reader.readLine();
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("prueba3.txt"));
            for (int i = 0; i < dict.size(); i++) {
                System.out.println(dict.get(i));
                writer.write(dict.get(i).toString());
                writer.newLine();
            }

            writer.close();

            System.out.println("END!!!");
            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println(totalTime + " nanoseconds elapsed");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

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
