import java.io.*;
import java.util.*;

public class ClassMng {
    Scanner sc = new Scanner(System.in);
    List<Classroom> classroomList = new ArrayList<>();

    // Thêm lớp học
    public void addClass() {
        readClassInfo();
        Classroom classroom = new Classroom();
        classroom.inputClassInfo(classroomList);
        classroomList.add(classroom);
        saveClassInfo();
    }

    // Hiển thị thông tin lớp học
    public void showClassInfo() {
        readClassInfo();
        for (Classroom classroom : classroomList) {
            classroom.showClassInfo();
        }
    }


    // Tìm thông tin lớp học bằng tên lớp
    public int findClassByName(String name) {
        int index = -1;
        for (int i = 0; i < classroomList.size(); i++) {
            if (classroomList.get(i).getClassName().equalsIgnoreCase(name)) {
                index = i;
            }
        }
        if (index == -1) {
            System.err.println("Không tìm thấy !!!");
        }
        return index;
    }

    // Hiển thị thông tin lớp học bằng tên
    public void showClassByName(String name) {
        int index = findClassByName(name);
        if (index != -1) {
            classroomList.get(index).showClassInfo();
        }
    }

    // Sửa thông tin lớp học bằng tên
    public void editClassByName(String name) {
        int index = findClassByName(name);
        if (index != -1) {
            Classroom classroom = new Classroom();
            classroom.inputClassInfo(classroomList);
            classroomList.set(index, classroom);
        }
        saveClassInfo();
    }

    // Xóa thông tin lớp học bằng tên
    public void removeClassByName(String name) {
        int index = findClassByName(name);
        if (index != -1) {
            System.out.println("Bạn có chắc muốn xóa không ?");
            System.out.println("1. Có, chắc cmn chắn ");
            System.out.println("2. Thôi, đùa đấy !");
            String answer;
            do{
                answer = sc.nextLine();
                if(answer.equals("1")){
                    classroomList.remove(index);
                    System.err.println("Xóa rồi nhé !");
                    break;
                }
                else if(answer.equals("2")){
                    System.err.println("Vậy hoy, hem xóa nữa !");
                    break;
                }
                else {
                    System.err.println("Nhập lại bạn êi !");
                }
            }while(true);
        }
        saveClassInfo();
    }

    // Ghi thông tin lớp học
    public void saveClassInfo() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("Class.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(classroomList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Đọc thông tin lớp học
    public void readClassInfo() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("Class.txt");
            ois = new ObjectInputStream(fis);
            classroomList = (List<Classroom>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Giảng viên
    // Tìm kiếm giảng viên bằng tên hoặc mã giảng viên
    public int findTeacherByNameOrId(String input) {
        readClassInfo();
        int index = -1;
        for (int i = 0; i < classroomList.size(); i++) {
            Teacher teacher = classroomList.get(i).getTeacher();
            if (teacher.getTeacherId().equalsIgnoreCase(input) || teacher.getName().equalsIgnoreCase(input)) {
                index = i;
            }
        }
        if (index == -1) {
            System.err.println("Không tìm thấy giảng viên phù hợp !!!");
        }
        return index;
    }

    // Hiển thị thông tin giảng viên bằng tên hoặc mã giảng viên
    public void showTeacherByNameOrId(String input) {
        int index = findTeacherByNameOrId(input);
        if (index != -1) {
            System.out.printf("%-25s%-18s%-20s%-17s%-25s%-28s%-21s%-19s", "Họ tên", "Giới tính", "Ngày sinh", "Quê quán",
                    "Mã giảng viên", "Lương/giờ", "Số giờ dạy", "Thực lĩnh");
            System.out.println();
            classroomList.get(index).getTeacher().showTeacherInfo();
        }
    }

    // Sửa thông tin giảng viên bằng tên hoặc mã giảng viên
    public void editTeacherByNameOrId(String input) {
        int index = findTeacherByNameOrId(input);
        if (index != -1) {
            Teacher teacher = new Teacher();
            teacher.inputTeacherInfo(classroomList);
            classroomList.get(index).setTeacher(teacher);
        }
        saveClassInfo();
    }

    // Sinh viên
    // Thêm sinh viên vào lớp
    public void addStudent(String className) {
        readClassInfo();
        boolean isFind = false;
        for (Classroom classroom : classroomList) {
            if (classroom.getClassName().equalsIgnoreCase(className)) {
                Student student = new Student();
                student.inputStudentInfo(classroomList);
                classroom.getStudentList().add(student);
                isFind = true;
            }
        }
        if (!isFind) {
            System.err.println("Không tìm thấy tên lớp phù hợp !");
        }
        saveClassInfo();
    }

    // Tìm kiếm sinh viên
    public int[] findStudent(String input) {
        int[] pos = {-1, -1};
        for (int i = 0; i < classroomList.size(); i++) {
            for (int j = 0; j < classroomList.get(i).getStudentList().size(); j++) {
                Student student = classroomList.get(i).getStudentList().get(j);
                if (findStudentByInput(input, student)) {
                    pos[0] = i;
                    pos[1] = j;
                }
            }
        }
        if (pos[0] == -1) {
            System.err.println("Không tìm thấy sinh viên phù hợp");
        }
        return pos;
    }

    // Hiển thị thông tin sinh viên bằng tên hoặc mã sinh viên, sđt, email
    public void showStudentByNameOrIdOrPhoneOrEmail(String input) {
        readClassInfo();
        int[] pos = findStudent(input);
        if (pos[0] != -1 && pos[1] != -1) {
            Student student = classroomList.get(pos[0]).getStudentList().get(pos[1]);
            if (findStudentByInput(input, student)) {
                System.out.printf("%-25s%-18s%-20s%-17s%-35s%-22s%-25s%-27s%-29s%-25s", "Họ tên", "Giới tính", "Ngày sinh", "Quê quán",
                        "Mã sinh viên", "Email", "Số điện thoại", "Điểm lý thuyết", "Điểm thực hành", "Điểm trung bình");
                System.out.println();
                student.showStudentInfo();
            }
        }
    }

    // Sửa thông tin sinh viên bằng tên hoặc mã sinh viên, sđt, email
    public void editStudentByNameOrIdOrPhoneOrEmail(String input) {
        readClassInfo();
        int[] pos = findStudent(input);
        if (pos[0] != -1 && pos[1] != -1) {
            Student student = classroomList.get(pos[0]).getStudentList().get(pos[1]);
            if (findStudentByInput(input, student)) {
                Student s = new Student();
                s.inputStudentInfo(classroomList);
                classroomList.get(pos[0]).getStudentList().set(pos[1], s);
            }
        }
        saveClassInfo();
    }

    private boolean findStudentByInput(String input, Student student) {
        return student.getName().equalsIgnoreCase(input) || student.getStudentId().equalsIgnoreCase(input) || student.getPhoneNumber().equalsIgnoreCase(input) || student.getEmail().equalsIgnoreCase(input);
    }

    // Xóa sinh viên bằng tên hoặc mã sinh viên, sđt, email
    public void removeStudentByNameOrIdOrPhoneOrEmail(String input) {
        readClassInfo();
        int[] pos = findStudent(input);
        if (pos[0] != -1 && pos[1] != -1) {
            Student student = classroomList.get(pos[0]).getStudentList().get(pos[1]);
            if (findStudentByInput(input, student)) {
                showStudentByNameOrIdOrPhoneOrEmail(input);
                System.out.println("Bạn có chắc muốn xóa không ?");
                System.out.println("1. Có, chắc cmn chắn");
                System.out.println("2. À mà thôi, đùa đấy");
                String answer;
                do {
                    answer = sc.nextLine();
                    if (answer.equals("1")) {
                        classroomList.get(pos[0]).getStudentList().remove(pos[1]);
                        System.err.println("Xóa rồi nhóe !");
                        break;
                    }
                    else if (answer.equals("2")) {
                        System.err.println("Vậy hoy, hem xóa nữa");
                        break;
                    }
                    else {
                        System.err.println("Nhập lại bạn êi ");
                    }
                }while (true);
            }
        }
        saveClassInfo();
    }


    // Lấy ra sinh viên điểm cao nhất lớp và thấp nhất lớp
    // Sắp xếp sinh viên theo điểm từ cao xuống thấp
    public void sortStudentByGPA() {
        readClassInfo();
        for (Classroom classroom : classroomList) {
            Collections.sort(classroom.getStudentList(), new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    if (o1.findGPA() < o2.findGPA()) {
                        return 1;
                    }
                    return -1;
                }
            });
        }
        saveClassInfo();
    }

    // Hiển thị sinh viên điểm cao nhất và thấp nhất lớp
    public void showMaxAndMixGPA(String className) {
        readClassInfo();
        sortStudentByGPA();
        boolean isFind = false;
        for (Classroom classroom : classroomList) {
            if (classroom.getClassName().equalsIgnoreCase(className)) {
                System.out.println("Sinh viên có điểm thấp nhất : ");
                classroom.getStudentList().get(0).showStudentInfo();
                System.out.println("Sinh viên có điểm cao nhất : ");
                classroom.getStudentList().get(classroom.getStudentList().size() - 1).showStudentInfo();
                isFind = true;
            }
        }
        if (!isFind) {
            System.err.println("Không tìm thấy tên lớp !");
        }
    }
}
