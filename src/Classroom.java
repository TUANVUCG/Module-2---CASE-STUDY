import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Classroom implements Serializable {

    private String className;
    private Teacher teacher = new Teacher();
    private List<Student> studentList = new ArrayList<>();

    public Classroom() {
    }

    public Classroom(String className, Teacher teacher, List<Student> studentList) {
        this.className = className;
        this.teacher = teacher;
        this.studentList = studentList;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void inputClassInfo(List<Classroom> classroomList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên lớp ( ví dụ : VU1234 ) ");
        while (true) {
            className = sc.nextLine();
            boolean isFind = false;
            for (int i = 0 ; i < classroomList.size();i++) {
                if (classroomList.get(i).getClassName().equalsIgnoreCase(className)) {
                    isFind = true;
                    break;
                }
            }
            String regex = "^VU\\d{4}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(className);
            if (matcher.find()) {
                if (!isFind)
                    break;
                else {
                    System.err.println("Tên lớp đã tồn tại !");
                    continue;
                }
            }
            System.err.println("Tên lớp không đúng");
        }

        System.out.println("Nhập thông tin giảng viên : ");
        teacher.inputTeacherInfo(classroomList);

        System.out.println("Nhập thông tin sinh viên :  ");
        System.out.println("Nhập số sinh viên trong lớp : ");
        int number = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < number; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i+1) + " ");
            Student stu = new Student();
            stu.inputStudentInfo(classroomList);
            studentList.add(stu);
        }
    }

    public void showClassInfo() {
        System.out.println("Tên lớp : " + className);
        System.out.println("-------------------");
        System.out.println();


        System.out.println("Thông tin giảng viên ");
        System.out.printf("%-25s%-18s%-20s%-17s%-25s%-28s%-21s%-19s","Họ tên","Giới tính","Ngày sinh","Quê quán",
                "Mã giảng viên","Lương/giờ","Số giờ dạy","Thực lĩnh");
        System.out.println();
        teacher.showTeacherInfo();
        System.out.println("-------------------");
        System.out.println();



        System.out.println("Thông tin sinh viên : ");
        System.out.printf("%-25s%-18s%-20s%-17s%-35s%-22s%-25s%-27s%-29s%-25s","Họ tên","Giới tính","Ngày sinh","Quê quán",
                "Mã sinh viên","Email","Số điện thoại","Điểm lý thuyết","Điểm thực hành","Điểm trung bình");
        System.out.println();
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i));
        }
        System.out.println("-------------------");
    }

}
