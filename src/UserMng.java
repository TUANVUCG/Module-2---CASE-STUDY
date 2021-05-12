import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

public class UserMng {
    Scanner sc = new Scanner(System.in);
    List<User> userList = new ArrayList<>();

    public void registration() {
        try {
            read();
            User user = new User();
            user.inputInfo(userList);
            userList.add(user);
            System.out.println("Đăng kí thành công !");
            save();
        } catch (Exception e) {
            System.out.println("Chưa có tài khoản nào !");
        }
    }


    // Đăng nhập
    public String login() {
        read();
        System.out.println("ĐĂNG NHẬP");
        System.out.println("Nhập tên tài khoản : ");
        String acc = sc.nextLine();
        String role = null;
        boolean isAcc = false;
        int exit = -1;
        do {
            for (User user : userList) {
                if (user.getAcc().equals(acc)) {
                    isAcc = true;
                    role = user.getRole();
                    System.out.println("Nhập mật khẩu : ");
                    while (true) {
                        String pass = sc.nextLine();
                        if (user.getPass().equals(pass)) {
                            break;
                        }
                        System.out.println("Mật khẩu không đúng, mời nhập lại !");
                    }
                }
            }
            if (!isAcc) {
                System.out.println("Tài khoản không đúng, bạn có muốn đăng kí không ?");
                System.out.println("1. Đăng kí ngay ");
                System.out.println("2. Nhập lại !");
                String choice;
                choice = sc.nextLine();
                switch (choice) {
                    case "1":
                        registration();
                        role = login();
                        exit = 0;
                        break;
                    case "2":
                        login();
                        exit = 0;
                        break;
                }
            }
            if (isAcc) break;
        } while (exit != 0);
        return role;
    }


    public void save() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File file = new File("User.txt");
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(userList);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void read() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("User.txt");
            ois = new ObjectInputStream(fis);
            userList = (List<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
