import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student extends Person {
    private String studentId;
    private String email;
    private String phoneNumber;
    private double theoryMark;
    private double practiceMark;

    public Student() {
    }

    public Student(String studentId, String email, String phoneNumber, double theoryMark, double practiceMark) {
        this.studentId = studentId;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.theoryMark = theoryMark;
        this.practiceMark = practiceMark;
    }

    public Student(String name, String gender, String birthOfDate, String address, String studentId, String email, String phoneNumber, double theoryMark, double practiceMark) {
        super(name, gender, birthOfDate, address);
        this.studentId = studentId;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.theoryMark = theoryMark;
        this.practiceMark = practiceMark;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getTheoryMark() {
        return theoryMark;
    }

    public void setTheoryMark(float theoryMark) {
        this.theoryMark = theoryMark;
    }

    public double getPracticeMark() {
        return practiceMark;
    }

    public void setPracticeMark(float practiceMark) {
        this.practiceMark = practiceMark;
    }

    public void inputStudentInfo(List<Classroom> classroomList) {
        super.inputPersonInfo();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã sinh viên (ví dụ CG1234) : ");
        while (true) {
            studentId = sc.nextLine();
            boolean idFind = false;
            for (int i = 0; i < classroomList.size(); i++) {
                for (int j = 0; j < classroomList.get(i).getStudentList().size(); j++) {
                    if (classroomList.get(i).getStudentList().get(j).getStudentId().equalsIgnoreCase(studentId)) {
                        idFind = true;
                    }
                }
            }
            String regex = "^CG\\d{4}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(studentId);
            if (matcher.find()) {
                if (!idFind)
                    break;
                else {
                    System.err.println("Mã sinh viên này đã tồn tại !");
                    continue;
                }
            }
            System.err.println("Mã sinh viên không đúng");
        }

        System.out.print("Nhập email (ví dụ : abc@abc.abc) : ");
        while (true) {
            email = sc.nextLine();
            boolean emailFind = false;
            for (int i = 0; i < classroomList.size(); i++) {
                for (int j = 0; j < classroomList.get(i).getStudentList().size(); j++) {
                    if (classroomList.get(i).getStudentList().get(j).getEmail().equalsIgnoreCase(email)) {
                        emailFind = true;
                    }
                }
            }
            String regex = "^[a-zA-Z]+[a-zA-Z0-9]*@[a-z]+(\\.[a-zA-Z0-9]+)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if (matcher.find()) {
                if (!emailFind)
                    break;
                else {
                    System.err.println("Email này đã được sử dụng, vui lòng nhập email khác !!!");
                    continue;
                }
            }
            System.err.println("Email không đúng !!!");
        }

        System.out.print("Nhập số điện thoại ( số điện thoại gồm 10 hoặc 11 chữ số viết liền ) :  ");
        while (true) {
            phoneNumber = sc.nextLine();
            boolean numFind = false;
            for (int i = 0; i < classroomList.size(); i++) {
                for (int j = 0; j < classroomList.get(i).getStudentList().size(); j++) {
                    if (classroomList.get(i).getStudentList().get(j).getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                        numFind = true;
                    }
                }
            }
            String regex = "^[(09)(03)]\\d{9,10}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(phoneNumber);
            if (matcher.find()) {
                if (!numFind)
                    break;
                else {
                    System.err.println("Số điện thoại này đã được sử dụng, vui lòng nhập số điện thoại khác !");
                    continue;
                }
            }
            System.err.println("Số điện thoại không đúng !!!");
        }

        System.out.print("Nhập điểm lý thuyết : ");
        while (true) {
            theoryMark = Double.parseDouble(sc.nextLine());
            if (theoryMark >= 0 && theoryMark <= 10) {
                break;
            } else {
                System.err.println("Điểm từ 0 đến 10 !");
            }
        }

        System.out.print("Nhập điểm thực hành : ");
        while (true) {
            practiceMark = Double.parseDouble(sc.nextLine());
            if (practiceMark >= 0 && practiceMark <= 10) {
                break;
            } else {
                System.err.println("Điểm từ 0 đến 10 !");
            }
        }
    }

    public void showStudentInfo() {
        System.out.println(this.toString());
    }

    public double findGPA() {
        return (theoryMark + (practiceMark * 2)) / 3;
    }


    @Override
    public String toString() {
        return super.toString() + String.format("%-25s%-30s%-25s%-25.1f%-25.1f%-25.1f", studentId, email, phoneNumber, theoryMark, practiceMark, findGPA());
    }
}
