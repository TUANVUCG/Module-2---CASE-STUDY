import java.util.ArrayList;
import java.util.List;
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
                    System.out.println("Nhập tên lớp :");
                    String name = sc.nextLine();
                    classMng.showStudentListByClassName(name);
                    break;
                case "3":
                    classMng.showStudentHasScholarShip();
                    break;
                case "4":
                    System.out.println("Nhập tên, mã SV, sđt hoặc email cần tìm : ");
                    String findStu = sc.nextLine();
                    classMng.showStudentByNameOrIdOrPhoneOrEmail(findStu);
                    break;
                case "5":
                    classMng.sortStudentByGPA();
                    classMng.showClassInfo();
                    break;
                case "6":
                    showFirstMenu(classMng);
                    break;
                case "0":
                    System.out.println("GOODBYE !!!");
                    break;
                default:
                    System.err.println("Nhập sai !");
                    break;
            }
        } while (!(choose.equals("0")));
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
                    classMng.showClassInfo();
                    System.out.println("Nhập tên hoặc mã giảng viên cần tìm ");
                    String findTeacher = sc.nextLine();
                    classMng.showTeacherByNameOrId(findTeacher);
                    break;
                case "3":
                    classMng.showClassInfo();
                    System.out.println("Nhập tên lớp học muốn thêm sinh viên : ");
                    String className = sc.nextLine();
                    classMng.addStudent(className);
                    break;
                case "4":
                    System.out.println("Nhập tên, mã SV, sđt hoặc email cần tìm : ");
                    String findStu = sc.nextLine();
                    classMng.showStudentByNameOrIdOrPhoneOrEmail(findStu);
                    break;
                case "5":
                    System.out.println("Nhập tên, mã SV, sđt hoặc email cần sửa : ");
                    String editStu = sc.nextLine();
                    classMng.showStudentByNameOrIdOrPhoneOrEmail(editStu);
                    classMng.editStudentByNameOrIdOrPhoneOrEmail(editStu);
                    break;
                case "6":
                    System.out.println("Nhập tên, mã SV, sđt hoặc email cần xóa : ");
                    String removeStu = sc.nextLine();
                    classMng.removeStudentByNameOrIdOrPhoneOrEmail(removeStu);
                    break;
                case "7":
                    classMng.sortStudentByGPA();
                    classMng.showClassInfo();
                    break;
                case "8":
                    classMng.showStudentHasScholarShip();
                    break;
                case "9":
                    showFirstMenu(classMng);
                    break;
                case "0":
                    System.out.println("GOODBYE !!!");
                    break;
                default:
                    System.err.println("Nhập sai !");
                    break;
            }
        } while (!(choose.equals("0")));
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
                    System.out.println("Nhập tên lớp cần tìm");
                    String find = sc.nextLine();
                    classMng.showClassByName(find);
                    break;
                case "4":
                    classMng.showClassInfo();
                    System.out.println("Nhập tên lớp cần sửa");
                    String edit = sc.nextLine();
                    classMng.editClassByName(edit);
                    break;
                case "5":
                    System.out.println("Nhập tên lớp cần xóa");
                    String remove = sc.nextLine();
                    classMng.editClassByName(remove);
                    break;
                case "6":
                    classMng.saveClassInfo();
                    System.out.println("Đã lưu !");
                    break;
                case "7":
                    classMng.readClassInfo();
                    classMng.showClassInfo();
                    break;
                case "8":
                    System.out.println("Nhập tên hoặc mã giảng viên cần tìm ");
                    String findTeacher = sc.nextLine();
                    classMng.showTeacherByNameOrId(findTeacher);
                    break;
                case "9":
                    System.out.println("Nhập tên hoặc mã giảng viên cần sửa ");
                    String editTeacher = sc.nextLine();
                    classMng.editTeacherByNameOrId(editTeacher);
                    break;
                case "10":
                    System.out.println("Nhập tên lớp học muốn thêm sinh viên : ");
                    String className = sc.nextLine();
                    classMng.addStudent(className);
                    break;
                case "11":
                    System.out.println("Nhập tên, mã SV, sđt hoặc email cần tìm : ");
                    String findStu = sc.nextLine();
                    classMng.showStudentByNameOrIdOrPhoneOrEmail(findStu);
                    break;
                case "12":
                    System.out.println("Nhập tên, mã SV, sđt hoặc email cần sửa : ");
                    String editStu = sc.nextLine();
                    classMng.showStudentByNameOrIdOrPhoneOrEmail(editStu);
                    classMng.editStudentByNameOrIdOrPhoneOrEmail(editStu);
                    break;
                case "13":
                    System.out.println("Nhập tên, mã SV, sđt hoặc email cần xóa : ");
                    String removeStu = sc.nextLine();
                    classMng.removeStudentByNameOrIdOrPhoneOrEmail(removeStu);
                    break;
                case "14":
                    classMng.sortStudentByGPA();
                    classMng.showClassInfo();
                    break;
                case "15":
                    classMng.showStudentHasScholarShip();
                    break;
                case "16":
                    showFirstMenu(classMng);
                    break;
                case "0":
                    System.out.println("GOODBYE !!!");
                    break;
                default:
                    System.err.println("Nhập sai !");
                    break;
            }
        } while (!(choose.equals("0")));
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
        System.out.println("Chức vụ của bạn là gì ?");
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
