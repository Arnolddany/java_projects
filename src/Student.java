import java.util.Objects;

public class Student {
    private int age;
    private int course;
    private String groupName; // Наименование группы студента
    private String fio;
    private int studentId; // номер студенческого билета
    private double middleMark; // средний бал
    public enum Status {
        studying, dismissed, academic
    }

    private Status status; // учебный статус
    public enum Sex {
        male, female
    }
    private final Sex sex;
    private static int count = 0;
    public Student(int age, String fio, String groupName, double middleMark, Sex sex){
        this.age = age;
        this.fio = fio;
        this.groupName = groupName;
        this.middleMark = middleMark;
        this.sex = sex;
        this.status = Status.studying;
        count++;
    }

    @Override
    public String toString() {
        return super.toString() + " {Курс: " + course + " ФИО: " + fio + " Возраст: " + age + "}";
    }
    public void viewHelloMessage(){
        System.out.println("Привет! Меня зовут " + fio + " я учусь на " + course + " курсе.");
    }
    public void viewStudentInfo(){
        System.out.println("Студент " + fio + " обучается на " + course + " кусе, номер студенческого билета " + studentId);
    }
    public static void printCount(){
        System.out.println("Колличество студентов: " + count);
    }
    public int getAge(){
        return age;
    }
    public int getCourse(){
        return course;
    }
    public String getFio(){
        return fio;
    }
    public  int getStudentId(){
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
    public void setMiddleMark(double middleMark) {
        if (middleMark>=0.0 && middleMark<=5.0){
            System.out.println("Ошибка! Средний бал не может быть меньше 0 и больше 5 баллов!");
        }
        this.middleMark = middleMark;
    }
    public void setCourse(int course){
        if (course>=1 && course<=4) {
            this.course = course;
        }
        else {
            System.out.println("Ошибка! Номер курса должен быть в диапазоне от 1 до 4!");
        }
    }
    public void setStudentId(int studentId){
        if (studentId>0){
            this.studentId = studentId;
        }
        else {
            System.out.println("Ошибка! Номер студенческого билета должен быть больше 0!");
        }
    }
    public void setAge(int age){
        if (age >= 16) {
            this.age = age;
        }
        else {
            System.out.println("Ошибка! Возраст должен быть больше 16 лет!");
        }
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Student) {
            Student student = (Student) obj;
            if (this.age == student.age && Objects.equals(this.fio, student.fio) && Objects.equals(this.groupName, student.groupName)) {
                result = true;
            }
        }
        return result;
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
