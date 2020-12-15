import java.util.InputMismatchException;
import java.util.Scanner;

class GUI {
    public static void showMenu(){
        System.out.println("\n\nLàm ơn chọn một trong số các lựa chọn ở dưới \n");
        System.out.println("1. Xem lại file dữ liệu đã nạp.\n");
        System.out.println("2. Tính và sinh ra danh sách kết nối có tổng trọng số nhỏ nhất.\n");
        System.out.println("3. Thoát chương trình.\n");
    }
    public static void main(String args[]) {

        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Trường Đại Học Bách Khoa có nhiều khu, phòng giảng đường đặc biệt khác nhau. " +
                "\nTổ quản trị mạng của nhà trường cần xây dựng một sơ đồ mạng tối ưu để kết nối tất cả các khu với nhau. " +
                "\nMột khu có thể kết nối được một số khu, một số khác thì không. " +
                "\nTrong một khu, các phòng có thể kết nối được với nhau hoặc không.");

        System.out.println("\n\nFile đọc từ input_new.txt chứa cùng thư mục với chương trình.");
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
                    System.out.println("Nhập vào file bạn muốn chương trình viết kết quả lên.\n");
//                    System.out.println("Default path will be output.txt in the same folder of the program.\n");
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