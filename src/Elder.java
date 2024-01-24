public class Elder extends Student {
    public Elder(int age, String fio, String groupName,  double middleMark, Sex sex){
        super(age, fio, groupName, middleMark, sex);
    }
    public final void messageDirector(){
        System.out.println("Здравстуйте Директор! Вас беспокоит староста " + getFio());
    }
}
