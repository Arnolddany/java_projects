import java.util.ArrayList;
import java.util.Objects;

public class Student {
    private int age;
    private int course;
    private String groupName; // Наименование группы студента
    private String fio;
    private int studentId; // номер студенческого билета
    private double middleMark; // средний бал
    private static ArrayList<Integer> idsStudent = new ArrayList<>();

    public enum Language {
        german, japanese, french, italian, english, korean, chinese
    }

    public enum Status {
        studying, dismissed, academic
    }


    private Language studiedLanguage;
    private Status status; // учебный статус

    public enum Sex {
        male, female
    }

    private Sex sex;
    private static int count = 0;

    protected Student(int age, String fio, String groupName, double middleMark, Sex sex, int course, int studentId, Language studiedLanguage) {
        this.age = age;
        this.fio = fio;
        this.groupName = groupName;
        this.middleMark = middleMark;
        this.sex = sex;
        this.status = Status.studying;
        this.course = course;
        this.studentId = studentId;
        idsStudent.add(studentId);
        this.studiedLanguage = studiedLanguage;
        count++;
    }

    protected Student(int age, String fio, String groupName, double middleMark, Sex sex, int course, Language studiedLanguage) {
        this.age = age;
        this.fio = fio;
        this.groupName = groupName;
        this.middleMark = middleMark;
        this.sex = sex;
        this.status = Status.studying;
        this.course = course;
        int max = getMaxStudentId(idsStudent);
        this.studentId = ++max;
        idsStudent.add(studentId);
        this.studiedLanguage = studiedLanguage;
        count++;
    }

    private Student() {
    }

    public static Student createStudent(int age, String fio, String groupName, double middleMark, Sex sex, int course, int studentId, Language studiedLanguage) {
        Student result = null;
        boolean success = false;
        if (studentId == 0) {
            result = new Student(age, fio, groupName, middleMark, sex, course, studiedLanguage);
        } else {
            for (Integer id : idsStudent) {
                if (id == studentId) {
                    success = true;
                    break;
                }
            }
            if (!success) {
                result = new Student(age, fio, groupName, middleMark, sex, course, studentId, studiedLanguage);
            } else {
                String err = String.format("Ошибка! Номер студенческого %d уже используется!", studentId);
                System.out.println(err);
            }
        }


        return result;
    }

    public int getMaxStudentId(ArrayList<Integer> idsStudent) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < idsStudent.size(); i++) {
            if (idsStudent.get(i) > max) {
                max = idsStudent.get(i);
            }

        }
        return max;
    }

    public static Student createForEquals(int age, String fio, String groupName, double middleMark, Sex sex, int course, int studentId, Language studiedLanguage) {
        Student student = new Student();
        student.age = age;
        student.fio = fio;
        student.groupName = groupName;
        student.middleMark = middleMark;
        student.sex = sex;
        student.course = course;
        student.studentId = studentId;
        student.studiedLanguage = studiedLanguage;

        return student;
    }

    @Override
    public String toString() {
        return super.toString() + " {Курс: " + course + " ФИО: " + fio + " Возраст: " + age + "}";
    }

    public void viewHelloMessage() {
        System.out.println("Привет! Меня зовут " + fio + " я учусь на " + course + " курсе.");
    }

    public void viewStudentInfo() {
        System.out.println("Студент " + fio + " обучается на " + course + " кусе, номер студенческого билета " + studentId);
    }

    public static void printCount() {
        System.out.println("Колличество студентов: " + count);
    }

    public int getAge() {
        return age;
    }

    public int getCourse() {
        return course;
    }

    public String getFio() {
        return fio;
    }

    public int getStudentId() {
        return studentId;
    }

    public static int getCount() {
        return count;
    }

    public String getGroupName() {
        return groupName;
    }

    public Sex getSex() {
        return sex;
    }

    public Status getStatus() {
        return status;
    }

    public double getMiddleMark() {
        return middleMark;
    }

    public Language getStudiedLanguage() {
        return studiedLanguage;
    }

    public void setMiddleMark(double middleMark) {
        if (middleMark >= 0.0 && middleMark <= 5.0) {
            System.out.println("Ошибка! Средний бал не может быть меньше 0 и больше 5 баллов!");
        }
        this.middleMark = middleMark;
    }

    public void setCourse(int course) {
        if (course >= 1 && course <= 4) {
            this.course = course;
        } else {
            System.out.println("Ошибка! Номер курса должен быть в диапазоне от 1 до 4!");
        }
    }

    public void setAge(int age) {
        if (age >= 16) {
            this.age = age;
        } else {
            System.out.println("Ошибка! Возраст должен быть больше 16 лет!");
        }
    }

    @Override

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Student student2) {
            return (this.age == student2.age) && Objects.equals(this.fio, student2.fio) && Objects.equals(this.groupName, student2.groupName) && (this.studentId == student2.studentId);
        }
        return false;
    }

    public void setStatusStudying() {
        this.status = Status.studying;
    }

    public void setStatusDismissed() {
        this.status = Status.dismissed;
    }

    public void setStatusAcademic() {
        this.status = Status.academic;
    }
}
