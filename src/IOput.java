import kotlin.Pair;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            this.scnr = new Scanner(this.input);
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

    public Pair<LinkedList<LinkedList<String>>, LinkedList<int[][]>> readAdjacencyList(){

        String so_luong;
        String danh_sach;
        String dis;
        LinkedList<LinkedList<String>> nameList = new LinkedList<>();
        LinkedList<int[][]> adjacencyList = new LinkedList<>();
        int num=0;
        int i=0;

        while (this.scnr.hasNextLine()){

            so_luong = this.scnr.nextLine();

            danh_sach = this.scnr.nextLine();
            dis = this.scnr.nextLine();

            Pattern pattern = Pattern.compile("(\\d+)");
            Matcher matcher = pattern.matcher(so_luong);

            nameList.add(new LinkedList<String>());
            matcher.find();
            try {
                num = Integer.parseInt(matcher.group());

                pattern = Pattern.compile("([A-Z]\\d+|[A-Z]\\b)");
                matcher = pattern.matcher(danh_sach);

                // Find the name
                while (matcher.find()){
                    nameList.get(i).add(matcher.group());
                }

                int[][] connect = new int[num][num];
                for (int j=0; j<num; j++){
                    String ket_noi = this.scnr.nextLine();
                    pattern = Pattern.compile("[A-Z]\\d*");
                    matcher = pattern.matcher(ket_noi);
                    matcher.find();
                    String donvi = matcher.group();

                    pattern = Pattern.compile("([A-Z][0-9]*\\(\\d+\\))");
                    matcher = pattern.matcher(ket_noi);
                    while (matcher.find()){
                        Vertex canh = new Vertex(matcher.group());
                        connect[nameList.get(i).indexOf(donvi)][nameList.get(i).indexOf(canh.getName())] = canh.getWeight();
                    }
                }
                for (int k =0; k<num;k++) {
                    for (int l = 0; l < num; l++) {
                        System.out.print(connect[k][l]+" ");
                    }
                    System.out.print("\n");
                }

                adjacencyList.add(connect);
                i++;
                System.out.println("\n");
            } catch (Exception e) {

            }
            try {
                scnr.nextLine();
            } catch (NoSuchElementException e){

            }
        }
        System.out.println("Finish reading");
        return new Pair<>(nameList, adjacencyList);
    }

    public void printFile(){
        String line;
        while (this.scnr.hasNextLine()){
            line = this.scnr.nextLine();
            System.out.println(line);
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }
}
