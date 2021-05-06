import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ClassMng classMng = new ClassMng();
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
        String choose;
        do {
            System.out.println("1. Thêm lớp học");
            System.out.println("2. Hiển thị tất cả lớp học");
            System.out.println("3. Tìm thông tin lớp ");
            System.out.println("4. Sửa thông tin lớp ");
            System.out.println("5. Xóa thông tin lớp ");
            System.out.println("6. Lưu thông tin các lớp học");
            System.out.println("7. Đọc thông tin các lớp học");
            System.out.println("8. Tìm giảng viên ");
            System.out.println("9. Sửa thông tin giảng viên ");
            System.out.println("10. Thêm sinh viên vào lớp");
            System.out.println("11. Tìm sinh viên");
            System.out.println("12. Sửa thông tin sinh viên");
            System.out.println("13. Xóa thông tin sinh viên");
            System.out.println("14. Sắp xếp sinh viên theo điểm từ cao đến thấp");
            System.out.println("0. Thoát chương trình");
            choose = sc.nextLine();
            switch (choose) {
                case "1":
                    classMng.addClass();
                    break;
                case "2":
                    classMng.showClassInfo();
                    break;
                case "3":
                    System.out.println("Nhập tên lớp");
                    String find = sc.nextLine();
                    classMng.showClassByName(find);
                    break;
                case "4":
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
                    System.out.println("Nhập tên lớp học muốn thêm ");
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
}
