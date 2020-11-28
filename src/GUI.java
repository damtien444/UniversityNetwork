import java.util.InputMismatchException;
import java.util.Scanner;

class GUI {
    public static void showMenu(){
        System.out.println("\n\nPlease, select one of these: \n");
        System.out.println("1. Print Adjacency Input Table\n");
        System.out.println("2. Compute and generate smallest weight connections instruction using prim algorithm.\n");
        System.out.println("3. Exit the program.\n");
    }
    public static void main(String args[]) {

        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        do {
            showMenu();
            int input;
            while (true) {
                try {
                    input = scanner.nextInt();
                } catch (InputMismatchException e) {
                    scanner.next();
                    System.out.println("Invalid input!");
                    continue;
                }
                break;
            }
            String pathIn = "input_new.txt";
            String pathOut = "output.txt";
            IOput iOput = new IOput(pathIn, pathOut);
            switch (input) {
                case 1:
                    iOput.printFile();
                    break;
                case 2:
                    System.out.println("Please specify the  path of the file you want to save the OUTPUT!\n");
                    System.out.println("Default path will be output.txt in the same folder of the program.\n");
//                    scanner.next();
                    pathOut = scanner.next();
                    if (pathOut.isEmpty()) pathOut = "output.txt";
                    Prim.run(pathIn, pathOut);
                    break;
                case 3:
                    System.out.println("Exiting!");
                    exit = true;
                    break;
            }

        } while (!exit);

    }
}