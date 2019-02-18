import java.sql.*;
import java.util.Scanner;

public class DB_people {

    public static void delete() {
        Connection conn = MyConnection.getConnection();
        Statement st = null;
        int iddelete = 0;
        System.out.println("Введите ID для удаления");
        Scanner delete = new Scanner(System.in);
        iddelete = delete.nextInt();
        try {
            st = conn.createStatement();
            st.execute("DELETE FROM Human where ID =" + iddelete +";\n" +
                    "vacuum;");
            System.out.println("Эллемент "+iddelete+" удален");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public static void viewbyname() {
        Connection conn = MyConnection.getConnection();
        Statement st = null;
        ResultSet rs = null;
        String name = null;
        System.out.println("Введите имя для поиска");
        Scanner delete = new Scanner(System.in);
        name = delete.nextLine();
          try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM Human where NAME ='" + name +"';\n");
            while (rs.next()) {
                System.out.println(rs.getInt("ID") + "\t" +
                        rs.getString("NAME") + "\t" +
                        rs.getInt("AGE") + "\t" +
                        rs.getString("SEX") + "\t" +
                        rs.getString("ADDRESS"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }




    public static void viewbyadr() {
        Connection conn = MyConnection.getConnection();
        Statement st = null;
        ResultSet rs = null;
        String addr = null;
        System.out.println("Введите адрес для поиска");
        Scanner delete = new Scanner(System.in);
        addr = delete.nextLine();
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM Human where ADDRESS ='" + addr +"';\n");
            while (rs.next()) {
                System.out.println(rs.getInt("ID") + "\t" +
                        rs.getString("NAME") + "\t" +
                        rs.getInt("AGE") + "\t" +
                        rs.getString("SEX") + "\t" +
                        rs.getString("ADDRESS"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public static void createTableHuman() {
        Connection conn = MyConnection.getConnection();
        Statement st = null;
        try {
            st = conn.createStatement();
            st.execute("CREATE TABLE IF NOT EXISTS Human(\n" +
                    "   ID INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "   NAME TEXT,\n" +
                    "   AGE INT,\n" +
                    "   SEX TEXT,\n" +
                    "   ADDRESS TEXT\n" +
                    ");");
            System.out.println("Таблица создана");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void startadding() {
        Connection conn = MyConnection.getConnection();
        Statement st = null;
        try {
            st = conn.createStatement();
            st.execute("INSERT INTO Human (NAME, AGE, SEX, ADDRESS)\n" +
                    "VALUES \n"+
                    //
                    "('Vlad', 22, 'm', 'Krasnodar'),\n"+
                    "('Miha', 22, 'm', 'Odincovo'),\n"+
                    "('Dimon', 23, 'm', 'Lybercy'),\n"+
                    "('Denis', 22, 'm', 'Mytishi'),\n"+
                    "('Alex', 22, 'm', 'Msk');");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void drop() {

        Connection conn = MyConnection.getConnection();
        Statement st = null;
        try {
            st = conn.createStatement();
            st.execute("Drop table Human;");
            System.out.println("Созданная таблица удалена");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void add(String name, int age, char sex, String address) {

        String sql = "INSERT INTO Human (NAME, AGE, SEX, ADDRESS)  \n" +
                "VALUES (?, ?, ?, ?);";
        Connection conn = MyConnection.getConnection();
        PreparedStatement pr = null;
        try {
            pr = conn.prepareStatement(sql);
           // pr.setInt(1, id);
            pr.setString(1, name);
            pr.setInt(2, age);
            pr.setString(3, String.valueOf(sex));
            pr.setString(4, address);
            pr.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }


    public static void view() {
        Connection conn = MyConnection.getConnection();
        Statement st = null;
        ResultSet rs = null;
        String Sql = "Select * from Human";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(Sql);
            while (rs.next()) {
                System.out.println(rs.getInt("ID") + "\t" +
                        rs.getString("NAME") + "\t" +
                        rs.getInt("AGE") + "\t" +
                        rs.getString("SEX") + "\t" +
                        rs.getString("ADDRESS"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

    class MyConnection {
        public static Connection getConnection() {
            Connection conn = null;
            try {
                conn = DriverManager.getConnection("jdbc:sqlite:Human");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }
    }

