import java.io.*;
import java.util.*;

public class ClassMng implements Serializable,Regex_FileName_String{
    Scanner sc = new Scanner(System.in);
    List<Classroom> classroomList = new ArrayList<>();

    // Thêm lớp học
    public void addClass() {
        try{
            read();
            Classroom classroom = new Classroom();
            classroom.inputInfo(classroomList);
            classroomList.add(classroom);
            save();
        }catch (Exception e){
            System.out.println("Hiện chưa có lớp nào trong danh sách !");
        }
    }

    // Hiển thị thông tin lớp học
    public void showClassInfo() {
        read();
        for (Classroom classroom : classroomList) {
            classroom.showInfo();
        }
    }

    // Tìm thông tin lớp học bằng tên lớp
    public int findClass(String name) {
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
    public void showClass(String name) {
        int index = findClass(name);
        if (index != -1) {
            classroomList.get(index).showInfo();
        }
    }

    // Sửa thông tin lớp học bằng tên
    public void editClass(String name) {
        int index = findClass(name);
        if (index != -1) {
            Classroom classroom = new Classroom();
            classroom.inputInfo(classroomList);
            classroomList.set(index, classroom);
        }
        save();
    }

    // Xóa thông tin lớp học bằng tên
    public void removeClass(String name) {
        int index = findClass(name);
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
        save();
    }

    // Ghi thông tin lớp học
    public void save() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(CLASS_FILE_NAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(classroomList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Đọc thông tin lớp học
    public void read() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(CLASS_FILE_NAME);
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
    public int findTeacher(String input) {
        read();
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
    public void showTeacher(String input) {
        int index = findTeacher(input);
        if (index != -1) {
            System.out.printf("%-25s%-18s%-20s%-17s%-25s%-28s%-21s%-19s", "Họ tên", "Giới tính", "Ngày sinh", "Quê quán",
                    "Mã giảng viên", "Lương/giờ", "Số giờ dạy", "Thực lĩnh");
            System.out.println();
            classroomList.get(index).getTeacher().showInfo();
        }
    }

    // Sửa thông tin giảng viên bằng tên hoặc mã giảng viên
    public void editTeacher(String input) {
        int index = findTeacher(input);
        if (index != -1) {
            Teacher teacher = new Teacher();
            teacher.inputInfo(classroomList);
            classroomList.get(index).setTeacher(teacher);
        }
        save();
    }

    // Sinh viên
    // Thêm sinh viên vào lớp
    public void addStudent(String className) {
        read();
        boolean isFind = false;
        for (Classroom classroom : classroomList) {
            if (classroom.getClassName().equalsIgnoreCase(className)) {
                Student student = new Student();
                student.inputInfo(classroomList);
                classroom.getStudentList().add(student);
                isFind = true;
            }
        }
        if (!isFind) {
            System.err.println("Không tìm thấy tên lớp phù hợp !");
        }
        save();
    }

    // Tìm kiếm sinh viên
    public int[] findStudent(String input) {
        int[] pos = {-1, -1};
        for (int i = 0; i < classroomList.size(); i++) {
            for (int j = 0; j < classroomList.get(i).getStudentList().size(); j++) {
                Student student = classroomList.get(i).getStudentList().get(j);
                if (findStudent(input, student)) {
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
    public void showStudent(String input) {
        read();
        int[] pos = findStudent(input);
        if (pos[0] != -1 && pos[1] != -1) {
            Student student = classroomList.get(pos[0]).getStudentList().get(pos[1]);
            if (findStudent(input, student)) {
                showStudentTitle();
                System.out.println();
                student.showInfo();
            }
        }
    }

    // Sửa thông tin sinh viên bằng tên hoặc mã sinh viên, sđt, email
    public void editStudent(String input) {
        read();
        int[] pos = findStudent(input);
        if (pos[0] != -1 && pos[1] != -1) {
            Student student = classroomList.get(pos[0]).getStudentList().get(pos[1]);
            if (findStudent(input, student)) {
                Student s = new Student();
                s.inputInfo(classroomList);
                classroomList.get(pos[0]).getStudentList().set(pos[1], s);
            }
        }
        save();
    }

    private boolean findStudent(String input, Student student) {
        return student.getName().equalsIgnoreCase(input) || student.getStudentId().equalsIgnoreCase(input) || student.getPhoneNumber().equalsIgnoreCase(input) || student.getEmail().equalsIgnoreCase(input);
    }

    // Xóa sinh viên bằng tên hoặc mã sinh viên, sđt, email
    public void removeStudent(String input) {
        read();
        int[] pos = findStudent(input);
        if (pos[0] != -1 && pos[1] != -1) {
            Student student = classroomList.get(pos[0]).getStudentList().get(pos[1]);
            if (findStudent(input, student)) {
                showStudent(input);
                System.out.println("Bạn có chắc muốn xóa không ?");
                System.out.println("1. Có, chắc cmn chắn");
                System.out.println("2. À mà thôi, đùa đấy");
                String answer;
                do {
                    answer = sc.nextLine();
                    if (answer.equals("1")) {
                        System.out.println("Xóa thật đấy nhé, không đùa đâu ?");
                        System.out.println("1. Biết rồi, khổ lắm, nói mãi");
                        System.out.println("2. Nước đi này mình đi sai, cho mình đi lại nhé");
                        String ans;
                        do{
                            ans = sc.nextLine();
                            if(ans.equals("1")){
                                classroomList.get(pos[0]).getStudentList().remove(pos[1]);
                                System.err.println("Xóa rồi nhóe !");
                                break;
                            }
                            else if (ans.equals("2")) {
                                System.err.println("Vậy hoy, hem xóa nữa");
                                break;
                            }
                            else {
                                System.err.println("Nhập lại bạn êi ");
                            }
                        }while (true);
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
        save();
    }

    // Lấy ra sinh viên điểm cao nhất lớp và thấp nhất lớp
    // Sắp xếp sinh viên theo điểm từ cao xuống thấp
    public void sortStudentByGPA() {
        read();
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
        save();
    }

    // Hiển thị danh sách sinh viên của tất cả các lớp
    public void showAllStudentList(){
        read();
        for(Classroom classroom : classroomList){
            System.out.println("TÊN LỚP : "+ classroom.getClassName());
            System.out.println("----------------");
            showStudentTitle();
            for(Student student : classroom.getStudentList()){
                student.showInfo();
            }
            System.out.println("===============================================");
        }
    }

    // Hiển thị danh sách sinh viên bằng cách nhập tên lớp
    public void showStudentList(String name){
        read();
        boolean isFind = false;
        for(Classroom classroom : classroomList){
            if(classroom.getClassName().equalsIgnoreCase(name)){
                System.out.println("TÊN LỚP : "+ classroom.getClassName());
                System.out.println("----------------");
                showStudentTitle();
                for(Student student : classroom.getStudentList()){
                    student.showInfo();
                    isFind = true;
                }
            }
        }
        if(!isFind){
            System.err.println("Không thấy tên lớp phù hợp !");
        }
    }

    // Hiển thị sinh viên được học bổng
    public void showStudentHasScholarShip(){
        read();
        for(Classroom classroom : classroomList){
            for(Student student : classroom.getStudentList()){
                if(student.classifyStudent().equals("ĐẠT HỌC BỔNG")){
                    System.out.println("TÊN LỚP : "+ classroom.getClassName());
                    System.out.println("--------------------");
                    showStudentTitle();
                    student.showInfo();
                }
            }
        }
    }

    private void showStudentTitle() {
        System.out.println("THÔNG TIN SINH VIÊN : ");
        System.out.printf("%-25s%-18s%-20s%-17s%-35s%-22s%-25s%-27s%-29s%-25s%-25s", "Họ tên", "Giới tính", "Ngày sinh", "Quê quán",
                "Mã sinh viên", "Email", "Số điện thoại", "Điểm lý thuyết", "Điểm thực hành", "Điểm trung bình","Phân loại");
        System.out.println();
    }

    // Hiển thị sinh viên điểm cao nhất và thấp nhất lớp
    public void showMaxAndMixGPA(String className) {
        read();
        sortStudentByGPA();
        boolean isFind = false;
        for (Classroom classroom : classroomList) {
            if (classroom.getClassName().equalsIgnoreCase(className)) {
                System.out.println("Sinh viên có điểm thấp nhất : ");
                classroom.getStudentList().get(0).showInfo();
                System.out.println("Sinh viên có điểm cao nhất : ");
                classroom.getStudentList().get(classroom.getStudentList().size() - 1).showInfo();
                isFind = true;
            }
        }
        if (!isFind) {
            System.err.println("Không tìm thấy tên lớp !");
        }
    }
}
