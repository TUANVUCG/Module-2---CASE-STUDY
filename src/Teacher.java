import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Teacher extends Person implements MyInterface {
    private double salaryOneHour;
    private double hourOnMonth;
    private String teacherId;


    public Teacher() {
    }

    public Teacher(String className, double salaryOneHour, double hourOnMonth) {
        this.salaryOneHour = salaryOneHour;
        this.hourOnMonth = hourOnMonth;
    }

    public Teacher(String name, String gender, String birthOfDate, String address, String className, double salaryOneHour, double hourOnMonth,String teacherId) {
        super(name, gender, birthOfDate, address);
        this.salaryOneHour = salaryOneHour;
        this.hourOnMonth = hourOnMonth;
        this.teacherId = teacherId;
    }

    public double getSalaryOneHour() {
        return salaryOneHour;
    }

    public void setSalaryOneHour(double salaryOneHour) {
        this.salaryOneHour = salaryOneHour;
    }

    public double getHourOnMonth() {
        return hourOnMonth;
    }

    public void setHourOnMonth(double hourOnMonth) {
        this.hourOnMonth = hourOnMonth;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public void inputInfo(List<Classroom> classroomList) {
        super.inputPersonInfo();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã giảng viên (ví dụ TC1234) : ");
        while (true) {
            teacherId = sc.nextLine();
            boolean isFind = false;
            for (Classroom classroom : classroomList) {
                if (classroom.getTeacher().getTeacherId().equalsIgnoreCase(teacherId)) {
                    isFind = true;
                    break;
                }
            }
            String regex = "^TC\\d{4}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(teacherId);
            if (matcher.find()) {
                if (!isFind)
                    break;
                else {
                    System.err.println("Mã giảng viên đã tồn tại !");
                    continue;
                }
            }
            System.err.println("Mã giảng viên không đúng");
        }


        System.out.print("Nhập lương một giờ dạy : ");
        salaryOneHour = Double.parseDouble(sc.nextLine());

        System.out.print("Nhập số giờ dạy trong tháng : ");
        hourOnMonth = Double.parseDouble(sc.nextLine());
    }

    public double findSalary() {
        return salaryOneHour * hourOnMonth;
    }

    @Override
    public void showInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-20s%-15.1f%19.1f%20.1f",teacherId,salaryOneHour,hourOnMonth,findSalary());
    }
}
