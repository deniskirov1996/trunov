import java.util.Scanner;
import java.util.*;
public  class Student {
    private int id;
    private String name;
    private int age;
    private char sex;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setCity(String address) {
        this.address = address;
    }

    public Student(int id, String name, int age, char sex, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }

    public Student()
    { //  System.out.println("id");
   // Scanner i = new Scanner(System.in);
    //setId(i.nextInt());

        System.out.println("Введите имя");
        Scanner n = new Scanner(System.in);
        setName(n.nextLine());
        System.out.println("Введите возраст");
        Scanner a = new Scanner(System.in);
        setAge(a.nextInt());
        System.out.println("Введите пол");
        Scanner s = new Scanner(System.in);
        setSex(s.next().charAt(0));
        System.out.println("Введите адрес");
        Scanner ad = new Scanner(System.in);
        setCity(ad.nextLine());

    }
}