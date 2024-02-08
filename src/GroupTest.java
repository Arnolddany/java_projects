import org.junit.jupiter.api.Assertions;

class GroupTest {

    @org.junit.jupiter.api.Test
    void getAllStudentsByCondition() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(16, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1);
        myGroup.addStudent(17, "Dany", myGroup.getGroupName(), 4.7, Student.Sex.male, myGroup.getCourse(), 2);
        myGroup.addStudent(18, "Polina", myGroup.getGroupName(), 3.6, Student.Sex.female, myGroup.getCourse(), 3);
        myGroup.addStudent(20, "Sasha", myGroup.getGroupName(), 5.0, Student.Sex.male, myGroup.getCourse(), 4);
        myGroup.addStudent(16, "Maria", myGroup.getGroupName(), 4.9, Student.Sex.female, myGroup.getCourse(), 5);
        myGroup.addStudent(16, "Maksim", myGroup.getGroupName(), 3.5, Student.Sex.male, myGroup.getCourse(), 6);
        myGroup.addStudent(18, "Elena", myGroup.getGroupName(), 3.0, Student.Sex.female, myGroup.getCourse(), 7);
        myGroup.addStudent(20, "Vanya", myGroup.getGroupName(), 3.4, Student.Sex.male, myGroup.getCourse(), 8);
        myGroup.addStudent(19, "Kristina", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 9);
        myGroup.addStudent(19, "Katya", myGroup.getGroupName(), 4.8, Student.Sex.female, myGroup.getCourse(), 10);
        myGroup.addStudent(17, "Lida", myGroup.getGroupName(), 4.1, Student.Sex.female, myGroup.getCourse(), 11);
        myGroup.printAll(18, 25, 0.0, 5.0, Student.Sex.male, Student.Status.studying);
    }

    @org.junit.jupiter.api.Test
    void addElderFromStudents() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(19, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1);
        myGroup.addStudent(19, "Maria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 2);
        myGroup.addStudent(19, "Kseniya", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 3);
        myGroup.addStudent(19, "Natasha", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 4);
        myGroup.addStudent(19, "Polina", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 5);
        myGroup.addElder(19, "Natasha", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 4);
        myGroup.printStudents();
        System.out.println(myGroup.getElder());
    }

    @org.junit.jupiter.api.Test
    void dismissStudent() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(21, "Ivanov Ivan Ivanovich", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1);
        myGroup.addStudent(19, "Ivanov Ivan Ivanovich", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 2);
        myGroup.addStudent(20, "Ivanov Ivan Ivanovich", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 3);
        myGroup.addStudent(18, "Ivanov Ivan Ivanovich", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 4);
        myGroup.dismissStudent("Ivanov Ivan Ivanovich", 1);
        myGroup.printStudents();
    }

    @org.junit.jupiter.api.Test
    void addStudentAndElder() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(19, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1);
        myGroup.addElder(19, "Dany", myGroup.getGroupName(), 4.7, Student.Sex.male, myGroup.getCourse(), 2);
        myGroup.printStudents();
        myGroup.printCountStudents();
    }

    @org.junit.jupiter.api.Test
    void addStudentAndTransformElder() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(19, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1);
        myGroup.addElder(19, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 2);
        myGroup.printStudents();
        myGroup.printCountStudents();
    }


    @org.junit.jupiter.api.Test
    void addDuplicateStudent() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(19, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1);
        myGroup.addStudent(19, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1);
    }

    @org.junit.jupiter.api.Test
    void getElders() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addElder(19, "Polina", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1);
        myGroup.addStudent(19, "Dany", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 2);
        System.out.println(myGroup.getElder());
    }

    @org.junit.jupiter.api.Test
    void getElderFromStudent() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(19, "Polina", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1);
        myGroup.getElder();
    }

    @org.junit.jupiter.api.Test
    void getElderUnknown() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(19, "Polina", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1);
        Assertions.assertNull(myGroup.getElder(), "Ожидали Null");
        Elder result = myGroup.getElder();
        if (result != null) {
            System.out.println(result.getStatus());
        } else {
            System.out.println("Нет старосты!");
        }
    }

    @org.junit.jupiter.api.Test
    void dismissUndefinedStudent() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(19, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1);
        myGroup.dismissStudent("Polina", 1);
    }

    @org.junit.jupiter.api.Test
    void academicUndefinedStudent() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(19, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1);
        myGroup.academicStudent("Polina", 1);
    }

    @org.junit.jupiter.api.Test
    void studyingUndefinedStudent() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(19, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1);
        System.out.println(myGroup.studyingStudent("Polina", 1));
    }

    @org.junit.jupiter.api.Test
    void getUnknownStudent() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(19, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1);
        System.out.println(myGroup.getIndex("Ivanov Ivan", 1));
    }

    @org.junit.jupiter.api.Test
    void addElderDelElder() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(19, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1);
        myGroup.addElder(19, "Dany", myGroup.getGroupName(), 4.5, Student.Sex.male, myGroup.getCourse(), 2);
        myGroup.dismissStudent("Dany", 2);
        myGroup.addElder(19, "Polina", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 3);
        myGroup.printStudents();
    }

    @org.junit.jupiter.api.Test
    void setNotUniqueId() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(19, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1);
        myGroup.addStudent(19, "Dany", myGroup.getGroupName(), 4.5, Student.Sex.male, myGroup.getCourse(), 1);
        myGroup.printStudents();
    }

    @org.junit.jupiter.api.Test
    void printStatus() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(19, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 5);
        myGroup.printStatusStudent("Valeria", 5);
        myGroup.academicStudent("Valeria", 5);
        myGroup.printStatusStudent("Valeria", 5);
    }

    @org.junit.jupiter.api.Test
    void printService() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.printAll();
    }
}