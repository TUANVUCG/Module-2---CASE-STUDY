import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ClassMng classMng = new ClassMng();

        testIQ();

        showFirstMenu(classMng);
    }

    private static void workLikeAStudent(ClassMng classMng) {
        String choose;
        do {
            showStudentMenu();
            choose = sc.nextLine();
            switch (choose) {
                case "1":
                    classMng.showAllStudentList();
                    break;
                case "2":
                    showStudentList(classMng);
                    break;
                case "3":
                    classMng.showStudentHasScholarShip();
                    break;
                case "4":
                    findStudent(classMng);
                    break;
                case "5":
                    sortStudentByGpa(classMng);
                    break;
                case "6":
                    showFirstMenu(classMng);
                    break;
                case "0":
                    System.out.println("GOODBYE !!!");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Nhập sai !");
                    break;
            }
        } while (true);
    }

    private static void workLikeATeacher(ClassMng classMng) {
        String choose;
        do {
            showTeacherMenu();
            choose = sc.nextLine();
            switch (choose) {
                case "1":
                    classMng.showClassInfo();
                    break;
                case "2":
                    findTeacher(classMng);
                    break;
                case "3":
                    addStudent(classMng);
                    break;
                case "4":
                    findStudent(classMng);
                    break;
                case "5":
                    editStudent(classMng);
                    break;
                case "6":
                    removeStudent(classMng);
                    break;
                case "7":
                    sortStudentByGpa(classMng);
                    break;
                case "8":
                    classMng.showStudentHasScholarShip();
                    break;
                case "9":
                    showFirstMenu(classMng);
                    break;
                case "0":
                    System.out.println("GOODBYE !!!");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Nhập sai !");
                    break;
            }
        } while (true);
    }

    private static void workLikeABoss(ClassMng classMng) {
        String choose;
        do {
            showBossMenu();
            choose = sc.nextLine();
            switch (choose) {
                case "1":
                    classMng.addClass();
                    break;
                case "2":
                    classMng.showClassInfo();
                    break;
                case "3":
                    findClass(classMng);
                    break;
                case "4":
                    editClass(classMng);
                    break;
                case "5":
                    removeClass(classMng);
                    break;
                case "6":
                    saveClass(classMng);
                    break;
                case "7":
                    readClass(classMng);
                    break;
                case "8":
                    findTeacher(classMng);
                    break;
                case "9":
                    removeTeacher(classMng);
                    break;
                case "10":
                    addStudent(classMng);
                    break;
                case "11":
                    findStudent(classMng);
                    break;
                case "12":
                    editStudent(classMng);
                    break;
                case "13":
                    removeStudent(classMng);
                    break;
                case "14":
                    sortStudentByGpa(classMng);
                    break;
                case "15":
                    classMng.showStudentHasScholarShip();
                    break;
                case "16":
                    showFirstMenu(classMng);
                    break;
                case "0":
                    System.out.println("GOODBYE !!!");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Nhập sai !");
                    break;
            }
        } while (true);
    }

    private static void findStudent(ClassMng classMng) {
        System.out.println("Nhập tên, mã SV, sđt hoặc email cần tìm : ");
        String findStu = sc.nextLine();
        classMng.showStudent(findStu);
    }

    private static void showStudentList(ClassMng classMng) {
        System.out.println("Nhập tên lớp :");
        String name = sc.nextLine();
        classMng.showStudentList(name);
    }

    private static void sortStudentByGpa(ClassMng classMng) {
        classMng.sortStudentByGPA();
        classMng.showClassInfo();
    }

    private static void editStudent(ClassMng classMng) {
        System.out.println("Nhập tên, mã SV, sđt hoặc email cần sửa : ");
        String editStu = sc.nextLine();
        classMng.showStudent(editStu);
        classMng.editStudent(editStu);
    }

    private static void addStudent(ClassMng classMng) {
        classMng.showClassInfo();
        System.out.println("Nhập tên lớp học muốn thêm sinh viên : ");
        String className = sc.nextLine();
        classMng.addStudent(className);
    }

    private static void findTeacher(ClassMng classMng) {
        classMng.showClassInfo();
        System.out.println("Nhập tên hoặc mã giảng viên cần tìm ");
        String findTeacher = sc.nextLine();
        classMng.showTeacher(findTeacher);
    }

    private static void removeStudent(ClassMng classMng) {
        System.out.println("Nhập tên, mã SV, sđt hoặc email cần xóa : ");
        String removeStu = sc.nextLine();
        classMng.removeStudent(removeStu);
    }

    private static void removeTeacher(ClassMng classMng) {
        System.out.println("Nhập tên hoặc mã giảng viên cần sửa ");
        String editTeacher = sc.nextLine();
        classMng.editTeacher(editTeacher);
    }

    private static void readClass(ClassMng classMng) {
        classMng.read();
        classMng.showClassInfo();
    }

    private static void saveClass(ClassMng classMng) {
        classMng.save();
        System.out.println("Đã lưu !");
    }

    private static void removeClass(ClassMng classMng) {
        System.out.println("Nhập tên lớp cần xóa");
        String remove = sc.nextLine();
        classMng.editClass(remove);
    }

    private static void editClass(ClassMng classMng) {
        classMng.showClassInfo();
        System.out.println("Nhập tên lớp cần sửa");
        String edit = sc.nextLine();
        classMng.editClass(edit);
    }

    private static void findClass(ClassMng classMng) {
        System.out.println("Nhập tên lớp cần tìm");
        String find = sc.nextLine();
        classMng.showClass(find);
    }

    private static void showStudentMenu() {
        System.out.println("1. Hiển thị thông tin các lớp học");
        System.out.println("2. Hiển thị danh sách sinh viên theo tên lớp");
        System.out.println("3. Hiển thị danh sách sinh viên đạt học bổng");
        System.out.println("4. Tìm sinh viên");
        System.out.println("5. Sắp xếp sinh viên theo điểm từ cao đến thấp");
        System.out.println("6. Quay lại menu chính ");
        System.out.println("0. Thoát chương trình");
    }

    private static void showTeacherMenu() {
        System.out.println("1. Hiển thị thông tin các lớp học");
        System.out.println("2. Tìm giảng viên ");
        System.out.println("3. Thêm sinh viên vào lớp");
        System.out.println("4. Tìm sinh viên");
        System.out.println("5. Sửa thông tin sinh viên");
        System.out.println("6. Xóa thông tin sinh viên");
        System.out.println("7. Sắp xếp sinh viên theo điểm từ cao đến thấp");
        System.out.println("8. Hiển thị danh sách sinh viên đạt học bổng ");
        System.out.println("9. Quay lại menu chính ");
        System.out.println("0. Thoát chương trình");
    }

    private static void showBossMenu() {
        System.out.println("1. Thêm lớp học");
        System.out.println("2. Hiển thị tất cả lớp học");
        System.out.println("3. Tìm thông tin lớp học");
        System.out.println("4. Sửa thông tin lớp học");
        System.out.println("5. Xóa thông tin lớp học");
        System.out.println("6. Lưu thông tin các lớp học");
        System.out.println("7. Đọc thông tin các lớp học");
        System.out.println("8. Tìm giảng viên ");
        System.out.println("9. Sửa thông tin giảng viên ");
        System.out.println("10. Thêm sinh viên vào lớp");
        System.out.println("11. Tìm sinh viên");
        System.out.println("12. Sửa thông tin sinh viên");
        System.out.println("13. Xóa thông tin sinh viên");
        System.out.println("14. Sắp xếp sinh viên theo điểm từ thấp đến cao");
        System.out.println("15. Hiển thị danh sách sinh viên đạt học bổng ");
        System.out.println("16. Quay lại menu chính ");
        System.out.println("0. Thoát chương trình");
    }

    private static void showFirstMenu(ClassMng classMng) {
        choice();
        String choice = sc.nextLine();
        do {
            if(choice.equals("1")){
                login("student","student");
                workLikeAStudent(classMng);
            }
            if (choice.equals("2")) {
                login("teacher","teacher");
                workLikeATeacher(classMng);
            }
            if (choice.equals("3")) {
                login("boss","boss");
                workLikeABoss(classMng);
            }
            if (choice.equals("0")) {
                System.out.println("GOODBYE !");
                System.exit(0);
                return;
            }
            if (!choice.equals("1") && !choice.equals("2")) {
                System.err.println("Nhập sai !");
                showFirstMenu(classMng);
            }
        } while (true);
    }

    private static void login(String acc, String pass) {
        while (true) {
            System.out.println("Nhập tài khoản ");
            String input = sc.nextLine();
            if (input.equals(acc)) {
                break;
            }
            System.err.println("Tài khoản không chính xác ");
        }
        while (true){
            System.out.println("Nhập mật khẩu");
            String inputPass = sc.nextLine();
            if(inputPass.equals(pass)){
                break;
            }
            System.err.println("Mật khẩu không chính xác ");
        }
    }

    private static void choice() {
        System.out.println("Bạn là ai trong cuộc đời này ?");
        System.out.println("1. Sinh viên quèn");
        System.out.println("2. Giảng viên");
        System.out.println("3. Trùm");
        System.out.println("0. Thoát chương trình ");
    }

    private static void testIQ() {
        System.out.println("Test IQ tẹo nào");
        System.out.println("Bạn năm nay bao nhiêu tuổi rồi ?");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Vậy nếu bạn sinh ra 10 năm trước thì bạn bao nhiêu tuổi ?");
        int answer;
        do {
            answer = Integer.parseInt(sc.nextLine());
            if (answer != 10) {
                System.err.println("Gà !");
            }
        } while (answer != 10);
        System.out.println("Thông minh đấy, ta bắt đầu thôi nào. LẸT GÂU !!! ");
        System.out.println("=========oOo=========");
    }
}
