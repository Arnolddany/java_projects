public class Elder extends Student {
    public Elder(int age, String fio, String groupName, double middleMark, Sex sex, int course, int studentId) {
        super(age, fio, groupName, middleMark, sex, course, studentId);
    }

    public Elder(Student student) {
        super(student.getAge(), student.getFio(), student.getGroupName(), student.getMiddleMark(), student.getSex(), student.getCourse(), student.getCourse());
    }

    public final void messageDirector() {
        System.out.println("Здравстуйте Директор! Вас беспокоит староста " + getFio());
    }
}
