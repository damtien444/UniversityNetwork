import java.util.Scanner;

class GUI {
    public static void showMenu(){
        System.out.println("Please, select one of these: \n");
        System.out.println("1. Generate connection tables of the university's building and room connection.\n");
        System.out.println("2. Review the connection tables.\n");
        System.out.println("3. Compute and generate smallest weight connections instruction using prim algorithm.\n");
        System.out.println("4. Exit the program.\n");
    }
    public static void main(String args[]) {

        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        do {
            showMenu();
            int input = scanner.nextInt();
            String pathIn = "input.txt";
            String pathOut = "output.txt";
            switch (input) {
                case 1:
                    System.out.println("Please specify the input path of the file you want to save the INPUT!\n");
                    System.out.println("Default path will be input.txt in the same folder of the program.\n");
                    pathIn = scanner.next();
                    if (pathIn == "") pathIn = "input.txt";
                    IOput.generateTable(pathIn);
                    break;
                case 2:
                    IOput.printInputTable(pathIn);
                    break;
                case 3:
                    System.out.println("Please specify the input path of the file you want to save the OUTPUT!\n");
                    System.out.println("Default path will be output.txt in the same folder of the program.\n");
                    pathOut = scanner.next();
                    if (pathOut == "") pathOut = "input.txt";
                    Prim.run(pathIn, pathOut);
                    break;
                case 4:
                    System.out.println("Exiting!");
                    exit = true;
                    break;
            }

        } while (!exit);
    }
}