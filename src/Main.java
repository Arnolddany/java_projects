public class Main { // Определяет класс
    public static void main(String[] args) { // определяет метод
        Group group41 = new Group("П420", "Программисты", 4);
        Group.groups.add(group41);
        Group group21 = new Group("Р218",  "Радисты",4);
        Group.groups.add(group21);
        group41.setCourse(4);
        group21.setCourse(2);
        System.out.println(group41);
        group41.printCountStudents();
        Group.printCountGroup();
        Group.printCountCourse();


        group41.addStudent(19, "Валерия Попова", "П420", 4.6, Student.Sex.female, group41.getCourse());
        group41.getStudentGroup("Валерия Попова").setStudentId(128);

//        group21.addStudent(17, "Данила Шишков","Р218", 3.8, Student.Sex.male, group21.getCourse());
//        group21.getStudentsGroup("Данила Шишков").setStudentId(183);




        group41.getStudentGroup("Валерия Попова").viewHelloMessage();
 //       group21.getStudentsGroup("Данила Шишков").viewStudentInfo();

        System.out.println(group41.getStudentGroup("Валерия Попова"));
   //     System.out.println(group21.getStudentsGroup("Данила Шишков"));

        group41.addElder(16, "Маша Смирнова", "П420", 5.0, Student.Sex.female, group41.getCourse());
        group41.getElder("Маша Смирнова").setCourse(4);
        group41.getElder("Маша Смирнова").messageDirector();


        group41.addStudent(17, "Саша Петров", "П420", 3.2, Student.Sex.male, group41.getCourse());
        group41.addStudent(17, "Николай Смирнов", "П420", 4.5, Student.Sex.male, group41.getCourse());

        group41.printStudents();
        System.out.println();
        group21.printStudents();
        System.out.println();
        group41.dismissStudent("Валерия Попова");
        group41.getDismissedStudent();
        System.out.println();
        group41.academicStudent("Николай Смирнов");
        group41.getAcademicStudent();
        System.out.println();
        group41.getStudyingStudent();
        System.out.println();
        group41.printFemaleStudentsFullAge();
        System.out.println();
        group41.printMarkExcellent();
        System.out.println();
        group41.printMarkGood();
        System.out.println();
        group41.printMarkSatisfactory();

        //1
        group21.addStudent(19, "Valeria", "Р218", 4.6, Student.Sex.female, group21.getCourse());
        group21.addStudent(19, "Polina", "Р218", 5.0, Student.Sex.female, group21.getCourse());
        group21.addElder(19, "Valeria", "Р218", 4.6, Student.Sex.female, group21.getCourse());
        System.out.println(group21.getStudentGroup("Valeria"));
       // group21.getElder("Valeria");
        group21.printStudents();
        group21.printCountStudents();

//        index = group21.getIndex("Ivanov Ivan");
//        System.out.println("index: " + index);
        //2
  //      group21.getElder("Polina");
        //3
  //      group21.getElder("Ivanov Ivan");
        //4
//        group21.dismissStudent("Ivanov Ivan");
//        group21.academicStudent("Ivanov Ivan");
//        group21.studyingStudent("Ivanov Ivan");
        //5
        System.out.println();
        Group.printCountCourse();
        group21.setCourse(1);

        System.out.println();
        Group.printCountCourse();
        System.out.println();
        group21.setCourse(2);

        Group.printCountCourse();
        group21.setCourse(1);

    }
}