import static org.junit.jupiter.api.Assertions.*;

class GroupTest {

    @org.junit.jupiter.api.Test
    void addElderFromStudents() {
        Group myGroup = new Group("My",  "Test", 2);
        myGroup.addStudent(19, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse());
        myGroup.addStudent(19, "Maria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse());
        myGroup.addStudent(19, "Kseniya", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse());
        myGroup.addStudent(19, "Natasha", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse());
        myGroup.addStudent(19, "Polina", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse());
        myGroup.addElder(19, "Natasha", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse());
        myGroup.printStudents();
        System.out.println(myGroup.getElder("Natasha"));
    }

    @org.junit.jupiter.api.Test
    void addDuplicateStudent () {
        Group myGroup = new Group("My",  "Test", 2);
        myGroup.addStudent(19, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse());
        myGroup.addStudent(19, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse());
    }

    @org.junit.jupiter.api.Test
    void getElderFromStudent() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(19, "Polina", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse());
        myGroup.getElder("Polina");
    }

    @org.junit.jupiter.api.Test
    void getElderUnknown() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(19, "Polina", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse());
        myGroup.getElder("Ivanov Ivan Ivanovich");
    }
}