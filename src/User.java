import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User implements Serializable {
    private String acc;
    private String pass;
    private String role;

    public User() {
    }

    public User(String acc, String pass, String role) {
        this.acc = acc;
        this.pass = pass;
        this.role = role;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void inputInfo(List<User> userList) {
        Scanner sc = new Scanner(System.in);
        inputRole(sc);

        inputAcc(userList, sc);

        inputPass(userList, sc);
    }

    private void inputPass(List<User> userList, Scanner sc) {
        System.out.println("Mật khẩu phải trên 5 kí tự, không chứ kí tự đặc biệt");
        System.out.print("Nhập mật khẩu : ");
        while (true) {
            pass = sc.nextLine();
            String regex = "^\\w{5,}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(pass);
            if (matcher.find()) {
                System.out.println("Xác nhận mật khẩu");
                boolean isConfirm = false;
                do {
                    String confirm = sc.nextLine();
                    if(pass.equals(confirm)){
                        isConfirm = true;
                    }
                    else {
                        System.err.println("Không khớp, mời xác nhận lại !");
                    }
                }while (!isConfirm);
                break;
            }
            System.err.println("Mật khẩu không đúng");
        }
    }

    private void inputAcc(List<User> userList, Scanner sc) {
        System.out.print("Nhập tài khoản : ");
        System.out.println("Tài khoản phải trên 5 kí tự, không chứ kí tự đặc biệt");
        while (true) {
            acc = sc.nextLine();
            boolean isFind = false;
            for (User user : userList) {
                if (user.getAcc().equals(acc)) {
                    isFind = true;
                    break;
                }
            }
            String regex = "^\\w{5,}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(acc);
            if (matcher.find()) {
                if (!isFind)
                    break;
                else {
                    System.err.println("Tài khoản đã tồn tại !");
                    continue;
                }
            }
            System.err.println("Tài khoản không đúng");
        }
    }

    private void inputRole(Scanner sc) {
        System.out.println("Bạn là ai trong cuộc đời này : ");
        System.out.println("1. Sinh viên quèn\n" +
                "2. Giảng viên\n" +
                "3. I'm Trùm");
        String choose;
        do {
            choose = sc.nextLine();
            switch (choose) {
                case "1":
                    role = "student";
                    break;
                case "2":
                    role = "teacher";
                    break;
                case "3":
                    role = "boss";
                    break;
                default:
                    System.err.println("Nhập sai !");
            }
        } while (!(choose.equals("1")) && !(choose.equals("2")) && !(choose.equals("3")));
    }
}

