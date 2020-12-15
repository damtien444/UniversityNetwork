import java.util.ArrayList;

public class Prim {

    public static Pair<ArrayList<Vertex>, Integer> primCal(int[][] input, int vNum) {

        int MAX = 10000;

        ArrayList<Vertex> vertexArrayList = new ArrayList<>();
        int[][] matrix = new int[vNum][vNum];
        int[] reached = new int[vNum];
        int min;
        int u = 0;
        int v = 0;
        int total = 0;

        for (int i = 0; i < vNum; i++) {
            reached[i] = 0;
            for (int j = 0; j < vNum; j++) {
                matrix[i][j] = input[i][j];
                if (matrix[i][j] == 0) {
                    matrix[i][j] = MAX;
                }
            }
        }

        reached[0] = 1;
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
            vertexArrayList.add(new Vertex(u, v));
        }
        return new Pair<>(vertexArrayList, total);
    }


    public static void run(String input, String output) {

        IOput io = new IOput(input, output);

        System.out.println("Reading from input.txt");

        Pair read = io.readAdjacencyList();

        System.out.println("\nComputing!");

        ArrayList name = (ArrayList) read.first;
        ArrayList table = (ArrayList) read.second;

        ArrayList<Pair<ArrayList<Vertex>, Integer>> result = new ArrayList<>();

        for (int i=0; i<name.size();i++){
            result.add(primCal((int[][]) table.get(i),(((int[][]) table.get(i)).length)));
            io.println("\nSuggested connection for: "+name.get(i));
            io.printConnectionOfTable(result.get(i), (ArrayList<String>) name.get(i));
        }

        System.out.println("Finish compute!");

        System.out.println("\nWrite result to file \""+io.getOut()+"\"");


    }

}