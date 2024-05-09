package test.logi_in;


import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class  DBdetails {
    private static Connection connect() {

        try {
            return getConnection("jdbc:mysql://localhost:3306/busmangement", "root", "@fahim*117#1127");

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static ResultSet executeQuery1(String query) throws SQLException {
        Connection conn = getConnection("jdbc:mysql://localhost:3306/busmangement", "root", "@fahim*117#1127");
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public static boolean userlogin(String Email, String Password){

        Connection con = connect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM student_info WHERE student_email=? AND student_password=?");
            ps.setString(1,Email);
            ps.setString(2,Password);
            ResultSet res = ps.executeQuery();
            return res.next();
            
        }catch (Exception e){
            e.printStackTrace();
            return false;

        }

    }
    public  static boolean ath_available_busname(String bus_nm){
        try (Connection con2 = connect();
             PreparedStatement pstmt2 = con2.prepareStatement("INSERT INTO avilable_busp (bus_name) VALUES (?)")) {

            pstmt2.setString(1, bus_nm);
            //pstmt2.setString(3, bus_nm1);
            int rowsInserted1 = pstmt2.executeUpdate();

            return rowsInserted1 > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
    public  static boolean signup(String Emailsd, String signPassword){
        try (Connection con = connect();
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO student_info (student_email, student_password) VALUES (?, ?)")) {

            pstmt.setString(1, Emailsd);
            pstmt.setString(2, signPassword);
            int rowsInserted = pstmt.executeUpdate();

            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }


    public static boolean ath_userlogin(String Email1, String Password1){

        Connection con1 = connect();
        try {
            PreparedStatement ps1 = con1.prepareStatement("SELECT * FROM bus_authority WHERE ath_username=? AND ath_password=?");
            ps1.setString(1,Email1);
            ps1.setString(2,Password1);
            ResultSet res1 = ps1.executeQuery();
            return res1.next();

        }catch (Exception e){
            e.printStackTrace();
            return false;

        }

    }
    public  static boolean ath_signup(String Emailsd1, String signPassword1){
        try (Connection con2 = connect();
             PreparedStatement pstmt2 = con2.prepareStatement("INSERT INTO bus_authority (ath_username, ath_password) VALUES (?, ?)")) {

            pstmt2.setString(1, Emailsd1);
            pstmt2.setString(2, signPassword1);
            int rowsInserted1 = pstmt2.executeUpdate();

            return rowsInserted1 > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
    public  static boolean ath_busname(String bus_nm, int capacity){
        try (Connection con2 = connect();
             PreparedStatement pstmt2 = con2.prepareStatement("INSERT INTO add_bus (bus_name, bus_capacity) VALUES (?, ?)")) {

            pstmt2.setString(1, bus_nm);
            pstmt2.setInt(2, capacity);
            //pstmt2.setString(3, bus_nm1);
            int rowsInserted1 = pstmt2.executeUpdate();

            return rowsInserted1 > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public  static boolean ath_assign_busname(String bus_nm, String houre,String minute,String ampm ,String rout){
        try (Connection con2 = connect();
             PreparedStatement pstmt2 = con2.prepareStatement("INSERT INTO assign_busn (bus_nam,houre,minute,am_pm,route) VALUES (?, ?, ?, ?, ?)")) {

            pstmt2.setString(1, bus_nm);
            pstmt2.setString(2, houre);
            pstmt2.setString(3, minute);
            pstmt2.setString(4, ampm);
            pstmt2.setString(5, rout);
            int rowsInserted1 = pstmt2.executeUpdate();

            return rowsInserted1 > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
    public  static boolean student_assign_busname(String bus_nm, String houre,String minute,String ampm ,String rout){
        try (Connection con2 = connect();
             PreparedStatement pstmt2 = con2.prepareStatement("INSERT INTO student_prt_bus (bus_nam,houre,minute,am_pm,route) VALUES (?, ?, ?, ?, ?)")) {

            pstmt2.setString(1, bus_nm);
            pstmt2.setString(2, houre);
            pstmt2.setString(3, minute);
            pstmt2.setString(4, ampm);
            pstmt2.setString(5, rout);
            int rowsInserted1 = pstmt2.executeUpdate();

            return rowsInserted1 > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
   /* public  static boolean student_delete_busname(String bus_nm, String houre,String minute,String ampm ,String rout){
        try (Connection con2 = connect();
             PreparedStatement pstmt2 = con2.prepareStatement("INSERT INTO student_prt_bus (bus_nam,houre,minute,am_pm,route) VALUES (?, ?, ?, ?, ?)")) {

            pstmt2.setString(1, bus_nm);
            pstmt2.setString(2, houre);
            pstmt2.setString(3, minute);
            pstmt2.setString(4, ampm);
            pstmt2.setString(5, rout);
            int rowsInserted1 = pstmt2.executeUpdate();

            return rowsInserted1 > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }*/
    public  static boolean card_checker(String bus_nm){
        try (Connection con2 = connect();
             PreparedStatement pstmt2 = con2.prepareStatement("INSERT INTO card_chk (bus_namp) VALUES (?)")) {

            pstmt2.setString(1, bus_nm);
            int rowsInserted1 = pstmt2.executeUpdate();

            return rowsInserted1 > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    /*public static boolean ath_check_bus(String bus_name) {

        Connection con1 = connect();
        try {
            PreparedStatement ps1 = con1.prepareStatement("SELECT * FROM add_bus WHERE bus_name=?");
            ps1.setString(1, bus_name);
            //ps1.setString(2,Password1);
            ResultSet res1 = ps1.executeQuery();
            return res1.next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }

    }*/
    public  static boolean ontrip(String bus_nme){
        try (Connection con2 = connect();
             PreparedStatement pstmt2 = con2.prepareStatement("INSERT INTO on_trip (bus_nme) VALUES (?)")) {

            pstmt2.setString(1, bus_nme);
            int rowsInserted1 = pstmt2.executeUpdate();

            return rowsInserted1 > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
    public static boolean deleteBus(String busName) {
        Connection con1 = connect();
        try {
            PreparedStatement preparedStatement = con1.prepareStatement("DELETE FROM avilable_busp WHERE bus_name=?");
            preparedStatement.setString(1, busName);
           int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Bus deleted successfully.");
                return true;
            } else {
                System.out.println("No bus found with the provided name.");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        /*
        try {
            PreparedStatement ps1 = con1.prepareStatement("SELECT * FROM add_bus WHERE bus_name=?");
            ps1.setString(1, bus_name);
            //ps1.setString(2,Password1);
            ResultSet res1 = ps1.executeQuery();
            return res1.next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }*/

    }
    public  static boolean delete_assign(String bus_nm){
        try (Connection con2 = connect();
             PreparedStatement pstmt2 = con2.prepareStatement("DELETE FROM assign_busn WHERE bus_nam = ?")) {

            pstmt2.setString(1, bus_nm);
            int rowsInserted1 = pstmt2.executeUpdate();

            if (rowsInserted1 > 0) {
                System.out.println("Bus deleted successfully.");
                return true;
            } else {
                System.out.println("No bus found with the provided name.");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
    public  static boolean Student_delete_assign(String bus_nm){
        try (Connection con2 = connect();
             PreparedStatement pstmt2 = con2.prepareStatement("DELETE FROM student_prt_bus WHERE bus_nam = ?")) {

            pstmt2.setString(1, bus_nm);
            int rowsInserted1 = pstmt2.executeUpdate();

            if (rowsInserted1 > 0) {
                System.out.println("Bus deleted successfully.");
                return true;
            } else {
                System.out.println("No bus found with the provided name.");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }


    public static boolean Offtrip(String busname) {
        Connection con1 = connect();
        try {
            PreparedStatement preparedStatement = con1.prepareStatement("DELETE FROM on_trip WHERE bus_nme=?");
            preparedStatement.setString(1, busname);
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Bus deleted successfully.");
                return true;
            } else {
                System.out.println("No bus found with the provided name.");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static boolean card_delet(String busname) {
        Connection con1 = connect();
        try {
            PreparedStatement preparedStatement = con1.prepareStatement("DELETE FROM card_chk WHERE bus_namp=?");
            preparedStatement.setString(1, busname);
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Bus deleted successfully.");
                return true;
            } else {
                System.out.println("No bus found with the provided name.");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    /*public class BusDatabaseHandler {
        public static StudentBoardController.BusInfo searchBus(int primaryKey) {
            Connection con1 = connect(); // Assuming connect() method exists to establish a database connection
            try {
                PreparedStatement preparedStatement = con1.prepareStatement("SELECT * FROM assign_busn WHERE route = ?");
                preparedStatement.setInt(1, primaryKey);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    String busName = resultSet.getString("bus_name");
                    String busType = resultSet.getString("bus_type");
                    String busRoute = resultSet.getString("bus_route");
                    int capacity = resultSet.getInt("capacity");
                    int fare = resultSet.getInt("fare");

                    return new StudentBoardController.BusInfo(busName,primaryKey, capacity, fare, busType, busRoute);
                } else {
                    System.out.println("No bus found with the provided primary key.");
                    return null;
                }

            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            } finally {
                // Close resources
                try {
                    con1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/

/*    public static ResultSet searchDatabase(String query) throws SQLException {
        Connection connection = connect();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM documents WHERE title LIKE ?");
        statement.setString(1, "%" + query + "%");
        return statement.executeQuery();
    }
*/

/*public static ResultSet searchDatabaseByRoute(String rout) throws SQLException {
    Connection connection = connect();
    PreparedStatement statement = connection.prepareStatement("");
    statement.setString(1,rout);
    return statement.executeQuery();
}*/


/*
    public static boolean findRowByPrimaryKey(int primaryKey) {
        Connection conn = connect();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // 1. Establish connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");

            // 2. Construct SQL Query
            String sql = "SELECT * FROM your_table WHERE primary_key_column = ?";

            // 3. Prepare Statement
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, primaryKey); // Assuming primary key is an integer

            // 4. Execute Query
            rs = stmt.executeQuery();

            // 5. Retrieve Results
            if (rs.next()) {
                // Retrieve data from result set
                int id = rs.getInt("primary_key_column");
                String name = rs.getString("name");
                // Retrieve other columns as needed

                // Display or process the retrieved data
                System.out.println("ID: " + id + ", Name: " + name);
                // Display in JavaFX UI as needed
                return true; // Row found
            } else {
                System.out.println("Row not found with primary key: " + primaryKey);
                return false; // Row not found
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Exception occurred
        } finally {
            // 6. Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
*/
   /* public boolean assign_data(String route){

        Connection con = connect();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM assign_busn WHERE route = ?");
            ps.setString(1,route);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                String busNam = res.getString("bus_nam");
                int houre = res.getInt("houre");
                int minute = res.getInt("minute");
                String amPm = res.getString("am_pm");
                return new BusDetails(busNam, houre, minute, amPm, route);
            }
            return res.next();

        }catch (Exception e){
            e.printStackTrace();
            return false;

        }

    }*/


    public  static boolean avilable_bs(String bus_nme){
        try (Connection con2 = connect();
             PreparedStatement pstmt2 = con2.prepareStatement("INSERT INTO avilable_busp (bus_name) VALUES (?)")) {

            pstmt2.setString(1, bus_nme);
            int rowsInserted1 = pstmt2.executeUpdate();

            return rowsInserted1 > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

}



   /* public static void ath_avilable_busname(String bus_nm){
        try (Connection con2 = connect();
             PreparedStatement pstmt2 = con2.prepareStatement("INSERT INTO avileable_bus (bus_nam) VALUES (?)")) {

            pstmt2.setString(1, bus_nm);

            int rowsInserted1 = pstmt2.executeUpdate();



        } catch (Exception e) {
            e.printStackTrace();

        }

    }*/

   /* public static void populateTableView(TableView<User> tableView) {
        ObservableList<User> bus_names = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT email FROM users")) {

            while (rs.next()) {
                users.add(new User(rs.getString("email")));
            }

            tableView.setItems(bus_names);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    */

    /*public boolean login(String username, String password) {
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users WHERE username=? AND password=?")) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean signup(String username, String password) {
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO Users (username, password) VALUES (?, ?)")) {
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }*/



