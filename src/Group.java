import java.util.ArrayList;
import java.util.Objects;

public class Group{
    private String groupName;
    private int course;
    private int countStudents;
    private static int countGroup = 0;
    private static int countCourse1 = 0;
    private static int countCourse2 = 0;
    private static int countCourse3 = 0;
    private static int countCourse4 = 0;
    private String specialization;
    private boolean elderAvailability; // наличие старосты в группе
    private ArrayList<Student> studentsGroup = new ArrayList<>();
    public Group(String groupName, int countStudents, String specialization) {
        this.groupName = groupName;
        this.countStudents = countStudents;
        this.specialization = specialization;
        countGroup++;
    }

    @Override
    public String toString() {
        return super.toString() + " Наименование группы: " + groupName + " Курс: " + course + " Колличество студентов: " + countStudents + " Специальность: " + specialization;
    }
    public void getCountStudent() {
        System.out.println("В группе " + groupName + " " + countStudents + " студентов.");
    }
    public static void getCountGroup() {
        System.out.println("Колличество групп: " + countGroup);
    }
    public static void getCountCourse() {
        System.out.println("Колличество групп 1 курса: " + countCourse1);
        System.out.println("Колличество групп 2 курса: " + countCourse2);
        System.out.println("Колличество групп 3 курса: " + countCourse3);
        System.out.println("Колличество групп 4 курса: " + countCourse4);
    }

    public void getStudents() {
        System.out.println("Студенты группы " + groupName + ": ");
        for (Student student : studentsGroup) {
            if (Objects.equals(groupName, student.getGroupName())) {
                System.out.println(student.getFio());
            }
        }
    }
    // Получить список студентов женского пола
    public void getFemaleStudents() {
        System.out.println("Студенты женского пола в группе " + groupName + ":");
        for (Student student : studentsGroup) {
            if (Student.Sex.female == student.getSex()){
                System.out.println(student.getFio());
            }
        }
    }
    // Получить список студентов мужского пола
    public void getMaleStudents() {
        System.out.println("Студенты мужского пола в группе " + groupName + ":");
        for (Student student : studentsGroup) {
            if (Student.Sex.male == student.getSex()){
                System.out.println(student.getFio());
            }
        }
    }
    // Получить список совершеннолетних студентов мужского пола
    public void getMaleStudentsFullAge() {
        System.out.println("Совершенноление студенты мужского пола в группе " + groupName + ":");
        for (Student student : studentsGroup) {
            if (Student.Sex.male == student.getSex() && student.getAge() >= 18) {
                System.out.println(student.getFio());
            }
        }
    }
    // Получить список совершеннолетних студентов женского пола
    public void getFemaleStudentsFullAge() {
        System.out.println("Совершенноление студенты женского пола в группе " + groupName + ":");
        for (Student student : studentsGroup) {
            if (Student.Sex.female == student.getSex() && student.getAge() >= 18) {
                System.out.println(student.getFio());
            }
        }
    }
    // Получить студентов со средним баллом отлично
    public void getMarkExcellent() {
        System.out.println("Студенты студенты со средним баллом 'Отлично' группы " + groupName + ":");
        for (Student student : studentsGroup) {
            if (student.getMiddleMark() == 5.0) {
                System.out.println(student.getFio());
            }
        }
    }
    // Получить студентов со средним баллом хорошо
    public void getMarkGood() {
        System.out.println("Студенты студенты со средним баллом 'Хорошо' группы " + groupName + ":");
        for (Student student : studentsGroup) {
            if (student.getMiddleMark() >= 4.0 && student.getMiddleMark() < 5.0) {
                System.out.println(student.getFio());
            }
        }
    }
    // Получить студентов со средним баллом удовлетворительно
    public void getMarkSatisfactory() {
        System.out.println("Студенты студенты со средним баллом 'Удовлетворительно' группы " + groupName + ":");
        for (Student student : studentsGroup) {
            if (student.getMiddleMark() >= 3.0 && student.getMiddleMark() < 4.0) {
                System.out.println(student.getFio());
            }
        }
    }
    // Получить индекс элемента ArrayList
    public int getIndex(String fio) {
        int index = 0;
        for (Student student : studentsGroup) {
            if (Objects.equals(fio, student.getFio())) {
                break;
            }
            else {
                index++;
            }
        }
        return index;
    }
    // Добавить студента
    public void addStudent(int age, String fio, String groupName,  double middleMark, Student.Sex sex) {
        studentsGroup.add(new Student(age, fio, groupName, middleMark, sex));
    }
    // Показать/получить студента
    public Student getStudentsGroup(String fio) {
        return  studentsGroup.get(getIndex(fio));
    }
    // Добавить старосту
    public void addElder(int age, String fio, String groupName,  double middleMark, Student.Sex sex) {
            if (!elderAvailability) {
                studentsGroup.add(new Elder(age, fio, groupName, middleMark, sex));
                elderAvailability = true;
                System.out.println("В группу " + groupName + " добавлена староста " + fio);
            } else {
                System.out.println("Ошибка! В группе уже есть староста!");
            }
    }
    // Показать/получить старосту
    public Elder getElder(String fio) {
        return (Elder) studentsGroup.get(getIndex(fio));
    }
    // Отчислить студента
    public void dismissStudent(String fio) {
        studentsGroup.get(getIndex(fio)).setStatusDismissed();
        System.out.println("Студент " + studentsGroup.get(getIndex(fio)).getFio() + " отчислен!");

    }
    // Отправить студента в академический отпуск
    public void academicStudent(String fio) {
        studentsGroup.get(getIndex(fio)).setStatusAcademic();
        System.out.println("Студент " + studentsGroup.get(getIndex(fio)).getFio() + " отправлен в академический отпуск!");

    }
    // Восстановить студента
    public void studyingStudent(String fio) {
        studentsGroup.get(getIndex(fio)).setStatusStudying();
        System.out.println("Студент " + studentsGroup.get(getIndex(fio)).getFio() + " восстановлен в учебный график!");
    }
    // Получить список отчисленных студентов
    public void getDismissedStudent() {
        System.out.println("Отчисленные студенты группы " + groupName + ":");
        for (Student student : studentsGroup) {
            if (Student.Status.dismissed == student.getStatus()) {
                System.out.println(student.getFio());
            }
        }
    }
    // Получить список обучающихся студентов
    public void getStudyingStudent() {
        System.out.println("Обучающиеся студенты группы " + groupName + ":");
        for (Student student : studentsGroup) {
            if (Student.Status.studying == student.getStatus()) {
                System.out.println(student.getFio());
            }
        }
    }
    // Получить список студентов находящихся в академическом отпуске
    public void getAcademicStudent() {
        System.out.println("Студенты группы " + groupName + " находящиеся в академическом отпуске:");
        for (Student student : studentsGroup) {
            if (Student.Status.academic == student.getStatus()) {
                System.out.println(student.getFio());
            }
        }
    }
    public int getCourse() {
        return course;
    }
    public String getSpecialization() {
        return specialization;
    }
    public String getGroupName() {
        return groupName;
    }
    public void setCourse(int course) {
        if (course == 1) {
            this.course = course;
            countCourse1++;
        }
        else if (course == 2) {
            this.course = course;
            countCourse2++;
        }
        else if (course == 3) {
            this.course = course;
            countCourse3++;
        }
        else if (course == 4) {
            this.course = course;
            countCourse4++;
        }
        else {
            System.out.println("Ошибка курс должен быть 0т 1 до 4!");
        }
    }
    public void setCountStudents(int countStudents) {
        if (countStudents>0) {
            this.countStudents = countStudents;
        }
        else {
            System.out.println("Ошибка! Колличество студентов в группе не может быть меньше 0!");
        }
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}