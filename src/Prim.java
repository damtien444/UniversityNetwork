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

        System.out.println("Reading from input.txt");

        Pair read = io.readAdjacencyList();

        System.out.println("\nComputing!");

        LinkedList name = (LinkedList) read.getFirst();
        LinkedList table = (LinkedList) read.getSecond();

        LinkedList<Pair<ArrayList<Connection>, Integer>> result = new LinkedList<>();

        for (int i=0; i<name.size();i++){
            result.add(primCal((int[][]) table.get(i),(((int[][]) table.get(i)).length)));
            io.println("\nSuggested connection for: "+name.get(i));
            io.printConnectionOfTable(result.get(i), (LinkedList<String>) name.get(i));
        }

        System.out.println("Finish compute!");

        System.out.println("\nWrite result to file \""+io.getOut()+"\"");


    }

}