import java.util.*;
public class People {

    public static void view() {
     DB_people.view();
    }


    public static void delete() {
    DB_people.delete();
    }


    public static void main(String[] args) {
       DB_people.createTableHuman();
       DB_people.startadding();
        String event = "";

        do {
            System.out.println("Выберите действие: /add;/delete;/view;/find;/end");
            Scanner in = new Scanner(System.in);
            event = in.nextLine();
            if (event.equals("/view")) {
                view();
            }
            else if (event.equals("/add")){
            Student st = new Student();
            DB_people.add(st.getName(),st.getAge(),st.getSex(),st.getAddress());


            }

            else if (event.equals("/find")){
               int choise;
               System.out.println("1 - поиск по имени, 2 - поиск по адресу");
                Scanner ch = new Scanner(System.in);
                choise = ch.nextInt();
                if (choise == 1){
                  DB_people.viewbyname();
                }
                else if (choise == 2){
                    DB_people.viewbyadr();
                }
                else {
                    System.out.println("Введено не верное значение");
                }
            }
            else if (event.equals("/end")){
                System.out.println("До свидания");
            }

            else if (event.equals("/delete")){
                delete();
            }

            else {
                System.out.println("Введена неверная команда");
            }

        }
        while ( ! event.equals("/end"));
        DB_people.drop();

    }


}

