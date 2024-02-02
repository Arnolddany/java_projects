import com.sun.net.httpserver.Authenticator;

import java.util.ArrayList;
import java.util.Objects;

public class Group{
    private String groupName;
    private int course;
    private String specialization;
    private boolean elderAvailability; // наличие старосты в группе
    private ArrayList<Student> studentsGroup = new ArrayList<>();
    public static ArrayList<Group> groups = new ArrayList<>();
    public Group(String groupName, String specialization, int course) {
        this.groupName = groupName;
        this.course = course;
        this.specialization = specialization;
        groups.add(new Group(groupName, specialization, course));
    }
    @Override
    public String toString() {
        return super.toString() + " Наименование группы: " + groupName + " Курс: " + course + " Колличество студентов: " + studentsGroup.size() + " Специальность: " + specialization;
    }
    public static void printCountGroup() {
        System.out.println("Колличество групп: " + groups.size());
    }
    public static void printCountCourse() {
        int countCourse1 = 0;
        int countCourse2 = 0;
        int countCourse3 = 0;
        int countCourse4 = 0;

        for (Group group : groups) {
            if (group.getCourse() == 1) {
                countCourse1++;
            } else if (group.getCourse() == 2) {
                countCourse2++;
            } else if (group.getCourse() == 3) {
                countCourse3++;
            } else {
                countCourse4++;
            }
        }
        System.out.println("Колличество групп 1 курса: " + countCourse1);
        System.out.println("Колличество групп 2 курса: " + countCourse2);
        System.out.println("Колличество групп 3 курса: " + countCourse3);
        System.out.println("Колличество групп 4 курса: " + countCourse4);
    }

    public void printCountStudents() {
        System.out.println("В группе " + groupName + " количество студентов: " + studentsGroup.size());
    }

    public void printStudents() {
        System.out.println("Студенты группы " + groupName + ": ");
        for (Student student : studentsGroup) {
            if (Objects.equals(groupName, student.getGroupName())) {
                System.out.println(student.getFio());
            }
        }
    }

    public int getStudentsQuantity() {
        return studentsGroup.size();
    }

    // Получить список студентов женского пола
    public void printFemaleStudents() {
        System.out.println("Студенты женского пола в группе " + groupName + ":");
        for (Student student : studentsGroup) {
            if (Student.Sex.female == student.getSex()){
                System.out.println(student.getFio());
            }
        }
    }
    // Получить список студентов мужского пола
    public void printMaleStudents() {
        System.out.println("Студенты мужского пола в группе " + groupName + ":");
        for (Student student : studentsGroup) {
            if (Student.Sex.male == student.getSex()){
                System.out.println(student.getFio());
            }
        }
    }
    // Получить список совершеннолетних студентов мужского пола
    public void printMaleStudentsFullAge() {
        System.out.println("Совершенноление студенты мужского пола в группе " + groupName + ":");
        for (Student student : studentsGroup) {
            if (Student.Sex.male == student.getSex() && student.getAge() >= 18) {
                System.out.println(student.getFio());
            }
        }
    }
    // Получить список совершеннолетних студентов женского пола
    public void printFemaleStudentsFullAge() {
        System.out.println("Совершенноление студенты женского пола в группе " + groupName + ":");
        for (Student student : studentsGroup) {
            if (Student.Sex.female == student.getSex() && student.getAge() >= 18) {
                System.out.println(student.getFio());
            }
        }
    }
    // Получить студентов со средним баллом отлично
    public void printMarkExcellent() {
        System.out.println("Студенты студенты со средним баллом 'Отлично' группы " + groupName + ":");
        for (Student student : studentsGroup) {
            if (student.getMiddleMark() == 5.0) {
                System.out.println(student.getFio());
            }
        }
    }
    // Получить студентов со средним баллом хорошо
    public void printMarkGood() {
        System.out.println("Студенты студенты со средним баллом 'Хорошо' группы " + groupName + ":");
        for (Student student : studentsGroup) {
            if (student.getMiddleMark() >= 4.0 && student.getMiddleMark() < 5.0) {
                System.out.println(student.getFio());
            }
        }
    }
    // Получить студентов со средним баллом удовлетворительно
    public void printMarkSatisfactory() {
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
    public void addStudent(int age, String fio, String groupName,  double middleMark, Student.Sex sex, int course) {
        boolean successSearch = false;
        for (Student student : studentsGroup) {
            if ((age == student.getAge()) && Objects.equals(fio, student.getFio()) && (middleMark == student.getMiddleMark()) && (sex == student.getSex())) {
                successSearch = true;
                break;
            }
        }
        if (!successSearch) {
            studentsGroup.add(new Student(age, fio, groupName, middleMark, sex, course));
            System.out.println("Студент добавлен!");
        } else {
            System.out.println("Ошибка! Такой студент уже был добавлен!");
        }
    }
    // Показать/получить студента
    public Student getStudentGroup(String fio) {
        return  studentsGroup.get(getIndex(fio));
    }
    // Добавить старосту
    public void addElder(int age, String fio, String groupName,  double middleMark, Student.Sex sex, int course) {
        boolean successSearch = false;
        int index = -1;
        if (!elderAvailability) {
                for (Student student : studentsGroup) {
                        if ((age == student.getAge()) && Objects.equals(fio, student.getFio()) && (middleMark == student.getMiddleMark()) && (sex == student.getSex())) {
                            index = getIndex(fio);
                            successSearch = true;
                        }
                }
        } else {
            System.out.println("Ошибка! В группе уже есть староста!");
        }
        if ((successSearch) && (index >= 0)) {
            Student student1 = studentsGroup.get(getIndex(fio));
            studentsGroup.set(getIndex(fio), new Elder(student1.getAge(), student1.getFio(), student1.getGroupName(), student1.getMiddleMark(), student1.getSex(), student1.getCourse()));
            elderAvailability = true;
            System.out.println("Студент " + fio + " назначен старостой в группу " + groupName);
        } else {
            studentsGroup.add(new Elder(age, fio, groupName, middleMark, sex, course));
            elderAvailability = true;
            System.out.println("В группу " + groupName + " добавлена староста " + fio);
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
        if ((course >= 1) && (course <= 4)) {
            this.course = course;
        }
        else {
            System.out.println("Ошибка курс должен быть 0т 1 до 4!");
        }
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
