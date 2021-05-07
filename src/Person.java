import java.io.Serializable;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person implements Serializable {

    private String name;
    private String gender;
    private String birthOfDate;
    private String address;

    public Person() {
    }

    public Person(String name, String gender, String birthOfDate, String address) {
        this.name = name;
        this.gender = gender;
        this.birthOfDate = birthOfDate;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(String birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void inputPersonInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên : ");
        name = sc.nextLine();

        System.out.println("Nhập giới tính : ");
        System.out.println("1. Nam");
        System.out.println("2. Nữ");
        while (true) {
            String choose = sc.nextLine();
            if (choose.equals("1")) {
                gender = "Nam";
                break;
            } else if (choose.equals("2")) {
                gender = "Nữ";
                break;
            } else {
                System.err.println("Nhập sai !");
            }
        }

        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
        while(true)

    {
        birthOfDate = sc.nextLine();
        String regex = "^\\d{2}/\\d{2}/\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(birthOfDate);
        if (matcher.find()) {
            break;
        } else {
            System.err.println("Nhập ngày sinh theo mẫu dd/MM/yyyy !!!");
        }
    }

        System.out.print("Nhập địa chỉ : ");
    address =sc.nextLine();
}

    public void showPersonInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return String.format("%-30s%-12s%-20s%-20s", name, gender, birthOfDate, address);
    }
}
