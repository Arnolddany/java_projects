public class Elder extends Student {
    public Elder(int age, String fio, String groupName,  double middleMark, Sex sex, int course) {
        super(age, fio, groupName, middleMark, sex, course);
    }

    public final void messageDirector(){
        System.out.println("Здравстуйте Директор! Вас беспокоит староста " + getFio());
    }
}
