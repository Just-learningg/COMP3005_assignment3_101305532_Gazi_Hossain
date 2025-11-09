import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
///Gazi hossain - 101305532
/// COMP3005 - Assignment 3


public class main{
    public static void main(String[] args) {
        //change it as needed
        String url = "jdbc:postgresql://localhost:5432/studentsDB";
        String user = "postgres";
        String pass = "admin";
        try {
            //uncomment line if driver fails to load automatically or running older java version
            //Class.forName("org.postgresql.Driver");

            //first we establish connection
            Connection connection = DriverManager.getConnection(url, user, pass);
            if(connection != null){
                System.out.println("Connected to the DataBase Successfully!");
            }else{
                System.out.println("Failed connect to the DataBase");
            }
            //now we create a statement to execute sql commmands
            Statement statement = connection.createStatement();

            //it is important to pass the statement object to every function to execute a query
            //call the functions to test them
            getAllstudent(statement);
            addStudent(statement, "gazi", "hossain", "hossain@gmail.com","2005-02-28");
            getAllstudent(statement);
            deleteStudent(statement, 1);
            getAllstudent(statement);
            updateStudentEmail(statement,2, "gazi@gmail.com");
            getAllstudent(statement);



        } catch (Exception e) {}
    }

    //getallstudents functions
    static void getAllstudent(Statement statement){

        //we have to use a try-catch to handle sql exceptions(during the query)
        try {
            //first we get the data using SELECT and save it in resultset
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
            //now we use a while loop to iterate over everything and print each row
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("student_id") + " \t");
                System.out.print(resultSet.getString("first_name") + " \t");
                System.out.print(resultSet.getString("last_name") + " \t");
                System.out.print(resultSet.getString("email") + " \t");
                System.out.println(resultSet.getDate("enrollment_date"));

            }
            System.out.println("All student printed!\n");

        }catch (Exception e){}
    }


    //addstudent function
    static void addStudent(Statement statement, String first, String Last, String email, String date){

        System.out.println("Adding new student");
        //again we need to use a try-catch
        try {
            //first we create INSERT statement as a string and use placeholders to pass the given parameters
            String sql = String.format(
                    "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES ('%s', '%s', '%s', '%s')", first, Last, email, date);
            //now we execute the INSERT statement
            statement.executeUpdate(sql);
            System.out.println("Student added!\n");
        }catch (Exception e){}

    }

    //updatestudent function
    static void updateStudentEmail(Statement statement, int id, String newEmail){
        //we are going to use the same strategy for this function
        try{
            //create the UPDATE statement and use placeholders(s for email cause its a string and d for id because its a int)
            String sql = String.format("UPDATE students SET email='%s' WHERE student_id=%d",newEmail,id);
            //pass UPDATE statement and execute
            statement.executeUpdate(sql);
            System.out.println("Student email updated!\n");

        }catch (Exception e){}
    }

    //deletestudent function
    static  void deleteStudent(Statement statement, int id){
        //we once again use the same strategy
        try {
            //create the DELETE statement
            String sql = String.format("DELETE FROM students WHERE student_id=%d", id);
            //pass it and execute
            statement.executeUpdate(sql);
            System.out.println("Deleted student\n");
        } catch (Exception e){}



    }

}
