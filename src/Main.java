public class Main { // Определяет класс
    public static void main(String[] args) { // определяет метод
        Group group41 = new Group("П420",28, "Программисты");
        Group group21 = new Group("Р218", 25, "Радисты");
        group41.setCourse(4);
        group21.setCourse(2);
        System.out.println(group41);
        group41.getCountStudent();
        Group.getCountGroup();
        Group.getCountCourse();


        group41.addStudent(19, "Валерия Попова", "П420", 4.6, Student.Sex.female);
        group41.getStudentsGroup("Валерия Попова").setCourse(4);
        group41.getStudentsGroup("Валерия Попова").setStudentId(128);

        group21.addStudent(17, "Данила Шишков","Р218", 3.8, Student.Sex.male);
        group21.getStudentsGroup("Данила Шишков").setCourse(2);
        group21.getStudentsGroup("Данила Шишков").setStudentId(183);




        group41.getStudentsGroup("Валерия Попова").viewHelloMessage();
        group21.getStudentsGroup("Данила Шишков").viewStudentInfo();
//
        System.out.println(group41.getStudentsGroup("Валерия Попова"));
        System.out.println(group21.getStudentsGroup("Данила Шишков"));
//
        group41.addElder(16, "Маша Смирнова", "П420", 5.0, Student.Sex.female);
        group41.getElder("Маша Смирнова").messageDirector();

        group41.getElder("Маша Смирнова").setCourse(4);
        group41.getElder("Маша Смирнова").messageDirector();
//
//
        group41.addStudent(17, "Саша Петров", "П420", 3.2, Student.Sex.male);
        group41.addStudent(17, "Николай Смирнов", "П420", 4.5, Student.Sex.male);
//
        group41.getStudents();
        System.out.println();
        group21.getStudents();
        System.out.println();
        group41.dismissStudent("Валерия Попова");
        group41.getDismissedStudent();
        System.out.println();
        group41.academicStudent("Николай Смирнов");
        group41.getAcademicStudent();
        System.out.println();
        group41.getStudyingStudent();
        System.out.println();
        group41.getFemaleStudentsFullAge();
        System.out.println();
        group41.getMarkExcellent();
        System.out.println();
        group41.getMarkGood();
        System.out.println();
        group41.getMarkSatisfactory();

        /*for (int i = 0; i < 30; i++) {
            group41.getStudentsGroup().add(new Student(i, String.valueOf(i),"П420", Student.Sex.male));

        }
        group41.getStudents();
        System.out.println();

        for (int i = 0; i < 30; i++) {
            group21.getStudentsGroup().add(new Student(i+30, String.valueOf(i+30),"Р218", Student.Sex.female));
        }
        group21.getStudents();*/

      }
}