/**
 * Java-1 Homework-5
 *
 * @author Timofei Tokarev
 * @version dated 24.07.18
 */

public class Office {

    static Person arrPerson[]=new Person[5];

    public static void main(String[] args) {

        arrPerson[0]=new Person("Irzicho z Podebrad","Developer");
        arrPerson[0].setGender(Person.MAN);
        arrPerson[0].setAge(51);
        arrPerson[0].setWage(90000);
        arrPerson[0].setPhoneNum("89610550555");

        arrPerson[1]=new Person("Alexey Popovich","Designer");
        arrPerson[1].setGender(Person.MAN);
        arrPerson[1].setAge(32);
        arrPerson[1].setWage(70000);
        arrPerson[1].setPhoneNum("89610525555");

        arrPerson[2]=new Person("Garrigue Masaryk","UX/UI designer");
        arrPerson[2].setGender("Man");
        arrPerson[2].setAge(42);
        arrPerson[2].setWage(110000);
        arrPerson[2].setPhoneNum("89610555535");

        arrPerson[3]=new Person("Valentina Tereshkova","Back-end developer");
        arrPerson[3].setGender(Person.WOMAN);
        arrPerson[3].setAge(45);
        arrPerson[3].setWage(100000);
        arrPerson[3].setPhoneNum("89990554555");

        arrPerson[4]=new Person("Frida Kahlo","Front-end developer");
        arrPerson[4].setGender(Person.WOMAN);
        arrPerson[4].setAge(47);
        arrPerson[4].setWage(80000);
        arrPerson[4].setPhoneNum("89170554955");
        System.out.println("__________________________________");
        cycle();
    }
    static void cycle(){
        for (int i=0;i<arrPerson.length;i++){
            if (arrPerson[i].getAge()>=40)
                arrPerson[i].showAll();
        }
    }
}
 class Person{

    public String name;
    public String job;
    public static final String MAN="Man";
    public static final String WOMAN="Woman";
    private String gender;
    private String phoneNum="not exist";
    private int wage=15000;
    private int age=18;



    public Person(String name,String job){
        this.name=name;
        this.job=job;
        show();
    }
    public void show(){
        System.out.println("Name: "+name+", Job: "+job);
    }
    void showAll(){
        System.out.println("Name: "+name+", Job: "+job+", Sex: "+gender+", Age: "+age+", Wage: "+wage+", Phone: "+phoneNum);
        System.out.println("------------------------------------------------------");
    }
    void setPhoneNum(String num){
        if ((num.charAt(0)=='8'&& num.charAt(1)=='9')||
                (num.charAt(0)=='+'&& num.charAt(1)=='7'&& num.charAt(2)=='9'))
            phoneNum=num;
    }
     String getPhoneNum(){
         return phoneNum;
     }
    void setGender(String gender){
        if (gender==MAN || gender==WOMAN)
            this.gender=gender;
    }
    String getGender(){
        return gender;
    }

    void setWage(int wage){
        if (wage>=15000 && wage<200000)
            this.wage=wage;
    }
    int getWage(){
        return wage;
    }
    void setAge(int age){
        if (age>=18 && ((age<65 && gender==MAN) || age<63))
            this.age=age;
    }
    int getAge(){
        return age;
    }
    void setName(String name){
        this.name=name;
    }
    String getName(){
        return name;
    }
}
