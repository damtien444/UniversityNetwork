import kotlin.Pair;


import java.util.ArrayList;
import java.util.LinkedList;


public class Prim {

    public static Pair<ArrayList<Connection>, Integer> primCal(int[][] input, int vNum) {

        int MAX = 10000;

        ArrayList<Connection> connectionArrayList = new ArrayList<>();

        int[][] matrix = new int[vNum][vNum];
        // Matrix of connection

        int[] reached = new int[vNum];
        // array of reached V

        int min;
        // set the original size

        int u = 0;
        int v = 0;
        // initialize coordinate in the matrix

        int total = 0;

        for (int i = 0; i < vNum; i++) {

            reached[i] = 0;
            // khoi tao mang reached

            for (int j = 0; j < vNum; j++) {
                // truyen mang vao
                matrix[i][j] = input[i][j];

                if (matrix[i][j] == 0) {
                    matrix[i][j] = MAX;
                    // neu khong reach duoc thi de gia tri infinity
                }
            }
        }

        reached[0] = 1;
        // chon vi tri bat dau

        for (int counter = 0; counter < vNum - 1; counter++) {
            min = MAX;
            for (int i = 0; i < vNum; i++)
                if (reached[i] == 1)
                    for (int j = 0; j < vNum; j++)
                        if (reached[j] != 1) if (min > matrix[i][j]) {
                            min = matrix[i][j];
                            u = i;
                            v = j;
                        }

            reached[v] = 1;
            total += min;

            connectionArrayList.add(new Connection(u, v));
        }

        return new Pair<>(connectionArrayList, total);
    }


    public static void run(String input, String output) {

        IOput io = new IOput(input, output);
        // Tao vat the doc file

        System.out.println("Reading from input.txt");

        Pair<int[][], Integer> table = io.inputATable();
        LinkedList<String> nameBuilding = io.inputName(table.getSecond());
        // Khoi tao va doc vao block input cho toan truong

        Pair<ArrayList<Connection>, Integer> result = primCal(table.getFirst(), table.getSecond());
        // Khoi tao ket qua cho toan truong

        LinkedList<Pair<int[][], Integer>> tableList = new LinkedList<>();
        // Khoi tao danh sach input cho moi khu

        LinkedList<Pair<ArrayList<Connection>, Integer>> resultList = new LinkedList<>();
        // Khoi tao danh sach output cho moi khu

        LinkedList<LinkedList<String>> nameList = new LinkedList<>();

        for (int i = 0; i < table.getSecond(); i++) {
            tableList.add(io.inputATable());
            nameList.add(io.inputName(tableList.get(i).getSecond()));
        }
        // doc vao cac bang gia tri va danh sach cac ten

        for (Pair<int[][], Integer> tableB : tableList) {
            resultList.add(primCal(tableB.getFirst(), tableB.getSecond()));
        }
        // Tinh toan cac khu


        System.out.println("Finish compute!");

        // Print to files
        io.println("\nSuggested connection for the University!");
        io.printConnectionOfTable(result, nameBuilding);

        for (int i = 0; i < resultList.size(); i++) {
            io.println("\nSuggested connection for " + nameList.get(i) + "!");
            io.printConnectionOfTable(resultList.get(i), nameList.get(i));
        }

        System.out.println("\nWrite result to file \"output.txt\"");


        // that GUI must generate an input file and trigger this file to generate output
        // then read from that output and generate GUI



    }

}