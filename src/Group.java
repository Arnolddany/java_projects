import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

public class Group {
    private final String groupName;
    private int course;
    private final String specialization;
    private boolean elderAvailability; // наличие старосты в группе
    private final ArrayList<Student> studentsGroup = new ArrayList<>();
    public static ArrayList<Group> groups = new ArrayList<>();

    static class PersonComparator implements java.util.Comparator<Student> {

        @Override
        public int compare(Student student1, Student student2) {
            return (int) (student1.getMiddleMark() - student2.getMiddleMark());
        }
    }

    public Group(String groupName, String specialization, int course) {
        this.groupName = groupName;
        this.course = course;
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return super.toString() + " Наименование группы: " + groupName + " Курс: " + course + " Колличество студентов: " + studentsGroup.size() + " Специальность: " + specialization;
    }

    public static void printCountGroup() {
        System.out.println("Колличество групп: " + groups.size());
    }

    // Печать колличесва групп по курсам
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

    // Печать колличества студентов в группе
    public void printCountStudents() {
        System.out.println("В группе " + groupName + " количество студентов: " + studentsGroup.size());
    }

    // Печать всех студентов группы
    public void printStudents() {
        System.out.println("Студенты группы " + groupName + ": ");
        for (Student student : studentsGroup) {
            if (Objects.equals(groupName, student.getGroupName()) && (student.getStatus() == Student.Status.studying)) {
                System.out.println("Номер студенческого: " + student.getStudentId() + " " + student.getFio() + " Возраст: " + student.getAge());
            }
        }
    }

    // печать списка студентов по условию
    public void printAllByConditions(int ageFrom, int ageTo, double markMore, double markLess, Student.Sex sex, Student.Status status) {
        System.out.println("Студенты группы " + groupName + ":");
        for (Student student : studentsGroup) {
            if ((student.getAge() >= ageFrom) && (student.getAge() <= ageTo) && (student.getMiddleMark() >= markMore) && (student.getMiddleMark() <= markLess) && (student.getSex() == sex) && (student.getStatus() == status)) {
                System.out.println("№" + student.getStudentId() + " " + student.getFio());
            }
        }
    }

    // Получение статуса обучения студента
    public void printStatusStudent(String fio, int studentId) {
        Student student = getStudentGroup(fio, studentId);
        String result = student.getFio() + " Номер студенческого билета: " + student.getStudentId();
        switch (student.getStatus()) {
            case studying -> result += " Статус: Обучается";
            case academic -> result += " Статус: В академическом отпуске";
            case dismissed -> result += " Статус: Отчислен";
            default -> throw new IllegalArgumentException("Неизвестный статус!");
        }
        System.out.println(result);
    }

    // Сортировка студентов по среднему баллу
    public void printSortByMark() {
        Comparator<Student> compareByMark = Comparator.comparing(Student::getMiddleMark).reversed();
        ArrayList<Student> sortedStudentGroup = studentsGroup.stream().sorted(compareByMark).collect(Collectors.toCollection(ArrayList::new));
        for (Student student : sortedStudentGroup) {
            System.out.println(student.getFio() + " Средний балл: " + student.getMiddleMark() + " Номер студенческого билета: " + student.getStudentId());
        }
    }

    // Получить все языки, которые изучаются в группе
    public void printStudiedLanguage() {
        Collection<Student> uniqueLanguages = studentsGroup.stream().collect(Collectors.toMap(Student::getStudiedLanguage, p -> p, (p, q) -> p)).values();
        System.out.println("В группе " + groupName + " изучают:");
        for (Student student : uniqueLanguages) {
            switch (student.getStudiedLanguage()) {
                case english -> System.out.println("Английский язык");
                case french -> System.out.println("Французкий язык");
                case german -> System.out.println("Немецкий язык");
                case chinese -> System.out.println("Китайский язык");
                case italian -> System.out.println("Итальянский язык");
                case japanese -> System.out.println("Японский язык");
                case korean -> System.out.println("Корейский язык");
            }
        }
    }

    // Получить индекс элемента ArrayList
    public int getIndex(String fio, int studentId) {
        int index = 0;
        for (Student student : studentsGroup) {
            if (Objects.equals(fio, student.getFio()) && (studentId == student.getStudentId())) {
                return index;
            } else {
                index++;
            }
        }
        return -1;
    }

    // Добавить студента
    public void addStudent(int age, String fio, String groupName, double middleMark, Student.Sex sex, int course, int studentId, Student.Language studiedLanguage) {
        boolean successSearch = false;
        Student tStudent = Student.createForEquals(age, fio, groupName, middleMark, sex, course, studentId, studiedLanguage);
        for (Student student : studentsGroup) {
            if (Objects.equals(student, tStudent)) {
                successSearch = true;
                break;
            }
        }
        if (!successSearch) {
            Student student = Student.createStudent(age, fio, groupName, middleMark, sex, course, studentId, studiedLanguage);
            if (student != null) {
                studentsGroup.add(student);
                System.out.println("Студент добавлен!");
            } else {
                System.out.println("Ошибка создания студента!");
            }
        } else {
            System.out.println("Ошибка! Такой студент уже был добавлен!");
        }
    }

    // Показать/получить студента
    public Student getStudentGroup(String fio, int studentId) {
        boolean successSearch = false;
        int index = -1;
        for (Student student : studentsGroup) {
            if ((Objects.equals(fio, student.getFio())) && (studentId == student.getStudentId())) {
                index = getIndex(fio, studentId);
                successSearch = true;
            }
        }
        if (successSearch && (index >= 0)) {
            return studentsGroup.get(getIndex(fio, studentId));
        } else {
            System.out.println("Такого студента не существует в системе!");
            return null;
        }
    }

    // Добавить старосту
    public void addElder(int age, String fio, String groupName, double middleMark, Student.Sex sex, int course, int studentId, Student.Language studiedLanguage) {
        boolean successSearch = false;
        if (!elderAvailability) {
            Student tStudent = Student.createStudent(age, fio, groupName, middleMark, sex, course, studentId, studiedLanguage);
            for (Student student : studentsGroup) {
                if (Objects.equals(tStudent, student)) {
                    successSearch = true;
                    break;
                }
            }
            if (successSearch) {
                studentsGroup.set(getIndex(fio, studentId), new Elder(tStudent));
                System.out.println("Студент " + fio + " назначен старостой в группу " + groupName);
            } else {
                studentsGroup.add(new Elder(age, fio, groupName, middleMark, sex, course, studentId, studiedLanguage));
                System.out.println("В группу " + groupName + " добавлен староста " + fio);
            }
            elderAvailability = true;
        } else {
            System.out.println("Ошибка! В группе уже есть староста!");
        }
    }

    // Показать/получить старосту
    public Elder getElder() {
        Elder elder = null;
        for (Student student : studentsGroup) {
            if (student instanceof Elder studentElder) {
                elder = studentElder;
            }
        }
        return elder;
    }

    // Отчислить студента
    public void dismissStudent(String fio, int studentId) {
        boolean successSearch = false;
        int index = -1;
        boolean thisElder = false;
        for (Student student : studentsGroup) {
            if ((Objects.equals(fio, student.getFio())) && studentId == student.getStudentId()) {
                index = getIndex(fio, studentId);
                successSearch = true;
                if (student instanceof Elder) {
                    thisElder = true;
                }
            }
        }
        if (successSearch && (index >= 0)) {
            studentsGroup.get(getIndex(fio, studentId)).setStatusDismissed();
            System.out.println("Студент " + studentsGroup.get(getIndex(fio, studentId)).getFio() + " отчислен!");
            if (thisElder) {
                elderAvailability = false;
            }
        } else {
            System.out.println("Такого студента не существует в системе!");
        }
    }

    // Отправить студента в академический отпуск
    public void academicStudent(String fio, int studentId) {
        boolean successSearch = false;
        int index = -1;
        for (Student student : studentsGroup) {
            if ((Objects.equals(fio, student.getFio())) && (studentId == student.getStudentId())) {
                index = getIndex(fio, studentId);
                successSearch = true;
            }
        }
        if (successSearch && (index >= 0)) {
            studentsGroup.get(getIndex(fio, studentId)).setStatusAcademic();
            System.out.println("Студент " + studentsGroup.get(getIndex(fio, studentId)).getFio() + " отправлен в академический отпуск!");
        } else {
            System.out.println("Такого студента не существует в системе!");
        }
    }

    // Восстановить студента
    public boolean studyingStudent(String fio, int studentId) {
        boolean successSearch = false;
        for (Student student : studentsGroup) {
            if ((Objects.equals(fio, student.getFio())) && (studentId == student.getStudentId())) {
                successSearch = true;
                break;
            }
        }
        if (successSearch) {
            studentsGroup.get(getIndex(fio, studentId)).setStatusStudying();
            System.out.println("Студент " + studentsGroup.get(getIndex(fio, studentId)).getFio() + " восстановлен в учебный график!");
            return successSearch;
        } else {
            return successSearch;
        }
    }

    // Получить список отчисленных студентов
    public void printDismissedStudent() {
        System.out.println("Отчисленные студенты группы " + groupName + ":");
        for (Student student : studentsGroup) {
            if (Student.Status.dismissed == student.getStatus()) {
                System.out.println(student.getFio());
            }
        }
    }

    // Получить список студентов находящихся в академическом отпуске
    public void printAcademicStudent() {
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
        } else {
            System.out.println("Ошибка курс должен быть 0т 1 до 4!");
        }
    }
}
