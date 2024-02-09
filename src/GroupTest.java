import org.junit.jupiter.api.Assertions;

class GroupTest {

    @org.junit.jupiter.api.Test
    void addStudentWithoutId() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(16, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1, Student.Language.english);
        myGroup.addStudent(17, "Dany", myGroup.getGroupName(), 4.7, Student.Sex.male, myGroup.getCourse(), 2, Student.Language.italian);
        myGroup.addStudent(16, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 0, Student.Language.english);
        myGroup.printStudents();
    }

    @org.junit.jupiter.api.Test
    void getAllStudentsByCondition() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(16, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1, Student.Language.english);
        myGroup.addStudent(17, "Dany", myGroup.getGroupName(), 4.7, Student.Sex.male, myGroup.getCourse(), 2, Student.Language.italian);
        myGroup.addStudent(18, "Polina", myGroup.getGroupName(), 3.6, Student.Sex.female, myGroup.getCourse(), 3, Student.Language.french);
        myGroup.addStudent(20, "Sasha", myGroup.getGroupName(), 5.0, Student.Sex.male, myGroup.getCourse(), 4, Student.Language.chinese);
        myGroup.addStudent(16, "Maria", myGroup.getGroupName(), 4.9, Student.Sex.female, myGroup.getCourse(), 5, Student.Language.german);
        myGroup.addStudent(16, "Maksim", myGroup.getGroupName(), 3.5, Student.Sex.male, myGroup.getCourse(), 6, Student.Language.japanese);
        myGroup.addStudent(18, "Elena", myGroup.getGroupName(), 3.0, Student.Sex.female, myGroup.getCourse(), 7, Student.Language.english);
        myGroup.addStudent(20, "Vanya", myGroup.getGroupName(), 3.4, Student.Sex.male, myGroup.getCourse(), 8, Student.Language.french);
        myGroup.addStudent(19, "Kristina", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 9, Student.Language.english);
        myGroup.addStudent(19, "Katya", myGroup.getGroupName(), 4.8, Student.Sex.female, myGroup.getCourse(), 10, Student.Language.chinese);
        myGroup.addStudent(17, "Lida", myGroup.getGroupName(), 4.1, Student.Sex.female, myGroup.getCourse(), 11, Student.Language.german);
        myGroup.printAllByConditions(18, 25, 0.0, 5.0, Student.Sex.male, Student.Status.studying);
        myGroup.printSortByMark();
    }

    @org.junit.jupiter.api.Test
    void getAllStudentsBySort() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(16, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1, Student.Language.english);
        myGroup.addStudent(17, "Dany", myGroup.getGroupName(), 4.7, Student.Sex.male, myGroup.getCourse(), 2, Student.Language.italian);
        myGroup.addStudent(18, "Polina", myGroup.getGroupName(), 3.6, Student.Sex.female, myGroup.getCourse(), 3, Student.Language.french);
        myGroup.addStudent(20, "Sasha", myGroup.getGroupName(), 5.0, Student.Sex.male, myGroup.getCourse(), 4, Student.Language.chinese);
        myGroup.addStudent(16, "Maria", myGroup.getGroupName(), 4.9, Student.Sex.female, myGroup.getCourse(), 5, Student.Language.german);
        myGroup.addStudent(16, "Maksim", myGroup.getGroupName(), 3.5, Student.Sex.male, myGroup.getCourse(), 6, Student.Language.japanese);
        myGroup.addStudent(18, "Elena", myGroup.getGroupName(), 3.0, Student.Sex.female, myGroup.getCourse(), 7, Student.Language.english);
        myGroup.addStudent(20, "Vanya", myGroup.getGroupName(), 3.4, Student.Sex.male, myGroup.getCourse(), 8, Student.Language.french);
        myGroup.addStudent(19, "Kristina", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 9, Student.Language.english);
        myGroup.addStudent(19, "Katya", myGroup.getGroupName(), 4.8, Student.Sex.female, myGroup.getCourse(), 10, Student.Language.chinese);
        myGroup.addStudent(17, "Lida", myGroup.getGroupName(), 4.1, Student.Sex.female, myGroup.getCourse(), 11, Student.Language.german);
        myGroup.printSortByMark();
    }

    @org.junit.jupiter.api.Test
    void getAllStudiedLanguageInGroup() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(16, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1, Student.Language.english);
        myGroup.addStudent(17, "Dany", myGroup.getGroupName(), 4.7, Student.Sex.male, myGroup.getCourse(), 2, Student.Language.italian);
        myGroup.addStudent(18, "Polina", myGroup.getGroupName(), 3.6, Student.Sex.female, myGroup.getCourse(), 3, Student.Language.french);
        myGroup.addStudent(20, "Sasha", myGroup.getGroupName(), 5.0, Student.Sex.male, myGroup.getCourse(), 4, Student.Language.chinese);
        myGroup.addStudent(16, "Maria", myGroup.getGroupName(), 4.9, Student.Sex.female, myGroup.getCourse(), 5, Student.Language.german);
        myGroup.addStudent(16, "Maksim", myGroup.getGroupName(), 3.5, Student.Sex.male, myGroup.getCourse(), 6, Student.Language.japanese);
        myGroup.addStudent(18, "Elena", myGroup.getGroupName(), 3.0, Student.Sex.female, myGroup.getCourse(), 7, Student.Language.english);
        myGroup.addStudent(20, "Vanya", myGroup.getGroupName(), 3.4, Student.Sex.male, myGroup.getCourse(), 8, Student.Language.french);
        myGroup.addStudent(19, "Kristina", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 9, Student.Language.english);
        myGroup.addStudent(19, "Katya", myGroup.getGroupName(), 4.8, Student.Sex.female, myGroup.getCourse(), 10, Student.Language.chinese);
        myGroup.addStudent(17, "Lida", myGroup.getGroupName(), 4.1, Student.Sex.female, myGroup.getCourse(), 11, Student.Language.german);
        myGroup.printStudiedLanguage();
    }

    @org.junit.jupiter.api.Test
    void addElderFromStudents() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(19, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1, Student.Language.english);
        myGroup.addStudent(19, "Maria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 2, Student.Language.english);
        myGroup.addStudent(19, "Kseniya", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 3, Student.Language.english);
        myGroup.addStudent(19, "Natasha", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 4, Student.Language.english);
        myGroup.addStudent(19, "Polina", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 5, Student.Language.english);
        myGroup.addElder(19, "Natasha", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 4, Student.Language.english);
        myGroup.printStudents();
        System.out.println(myGroup.getElder());
    }

    @org.junit.jupiter.api.Test
    void dismissStudent() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(21, "Ivanov Ivan Ivanovich", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1, Student.Language.english);
        myGroup.addStudent(19, "Ivanov Ivan Ivanovich", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 2, Student.Language.english);
        myGroup.addStudent(20, "Ivanov Ivan Ivanovich", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 3, Student.Language.english);
        myGroup.addStudent(18, "Ivanov Ivan Ivanovich", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 4, Student.Language.english);
        myGroup.dismissStudent("Ivanov Ivan Ivanovich", 1);
        myGroup.printStudents();
    }

    @org.junit.jupiter.api.Test
    void addStudentAndElder() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(19, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1, Student.Language.english);
        myGroup.addElder(19, "Dany", myGroup.getGroupName(), 4.7, Student.Sex.male, myGroup.getCourse(), 2, Student.Language.english);
        myGroup.printStudents();
        myGroup.printCountStudents();
    }

    @org.junit.jupiter.api.Test
    void addStudentAndTransformElder() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(19, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1, Student.Language.english);
        myGroup.addElder(19, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 2, Student.Language.english);
        myGroup.printStudents();
        myGroup.printCountStudents();
    }


    @org.junit.jupiter.api.Test
    void addDuplicateStudent() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(19, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1, Student.Language.english);
        myGroup.addStudent(19, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1, Student.Language.english);
    }

    @org.junit.jupiter.api.Test
    void getElders() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addElder(19, "Polina", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1, Student.Language.english);
        myGroup.addStudent(19, "Dany", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 2, Student.Language.english);
        System.out.println(myGroup.getElder());
    }

    @org.junit.jupiter.api.Test
    void getElderFromStudent() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(19, "Polina", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1, Student.Language.english);
        myGroup.getElder();
    }

    @org.junit.jupiter.api.Test
    void getElderUnknown() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(19, "Polina", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1, Student.Language.english);
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
        myGroup.addStudent(19, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1, Student.Language.english);
        myGroup.dismissStudent("Polina", 1);
    }

    @org.junit.jupiter.api.Test
    void academicUndefinedStudent() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(19, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1, Student.Language.english);
        myGroup.academicStudent("Polina", 1);
    }

    @org.junit.jupiter.api.Test
    void studyingUndefinedStudent() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(19, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1, Student.Language.english);
        System.out.println(myGroup.studyingStudent("Polina", 1));
    }

    @org.junit.jupiter.api.Test
    void getUnknownStudent() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(19, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1, Student.Language.english);
        System.out.println(myGroup.getIndex("Ivanov Ivan", 1));
    }

    @org.junit.jupiter.api.Test
    void addElderDelElder() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(19, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1, Student.Language.english);
        myGroup.addElder(19, "Dany", myGroup.getGroupName(), 4.5, Student.Sex.male, myGroup.getCourse(), 2, Student.Language.english);
        myGroup.dismissStudent("Dany", 2);
        myGroup.addElder(19, "Polina", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 3, Student.Language.english);
        myGroup.printStudents();
    }

    @org.junit.jupiter.api.Test
    void setNotUniqueId() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(19, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 1, Student.Language.english);
        myGroup.addStudent(19, "Dany", myGroup.getGroupName(), 4.5, Student.Sex.male, myGroup.getCourse(), 1, Student.Language.english);
        myGroup.printStudents();
    }

    @org.junit.jupiter.api.Test
    void printStatus() {
        Group myGroup = new Group("My", "Test", 2);
        myGroup.addStudent(19, "Valeria", myGroup.getGroupName(), 4.5, Student.Sex.female, myGroup.getCourse(), 5, Student.Language.english);
        myGroup.printStatusStudent("Valeria", 5);
        myGroup.academicStudent("Valeria", 5);
        myGroup.printStatusStudent("Valeria", 5);
    }
}