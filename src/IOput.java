import kotlin.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class IOput {

    private String path;
    private File input;
    private Scanner scnr;
    private String out;


    public IOput(String path, String pathOut) {

        this.path = path;
        this.out = pathOut;
        this.input = new File(this.path);
        try {
            this.scnr = new Scanner(input);
        } catch (FileNotFoundException var3) {
            var3.printStackTrace();
        }

    }

    public Pair<int[][], Integer> inputATable() {

        int size = scnr.nextInt();

        int[][] inputArray = new int[size][size];

        int count = size;

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                inputArray[i][j] = scnr.nextInt();
            }
        }

        return new Pair<int[][], Integer>(inputArray, size);

    }

    public LinkedList<String> inputName(int num) {

        LinkedList<String> inputArray = new LinkedList<String>();

        for (int i = 0; i < num; i++) {

            inputArray.add(scnr.next());

        }

        return inputArray;
    }

    public void outPutOld(String s, String sep) {
        try (FileWriter fw = new FileWriter(this.out, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.print(s);

            out.print(sep);
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    public void println(String s) {
        System.out.println(s);
        outPutOld(s, "\n");
    }

    public void printConnectionOfTable(Pair<ArrayList<Connection>, Integer> pair, LinkedList<String> nameList) {
        for (int i = 0; i < pair.getFirst().size(); i++) {
            println(nameList.get(pair.getFirst().get(i).ori)
                    + " <-> " +
                    nameList.get(pair.getFirst().get(i).des));
        }
        println("Cost: " + pair.getSecond());
    }

    public static void generateTable(String path){

    }

    public static void printInputTable(String path){

    }
}
