# COMP3005_assignment3_101305532_Gazi_Hossain
JAVA JDBC CRUD application that connects to local postgres server for assignment 3 COMP3005
This application includes functions
1) getAllStudent()
   - Retrieves and prints all rows from the students table
2) addStudent()
   - Inserts a new student row into the students table
3) updateStudentEmail()
   - Inserts a new student row into the students table
4) deleteStudent()
   - Inserts a new student row into the students table
  
#How to run
- Make sure to have a database in pgAdmin that matches the required schema
             - have a table name students(if not change it in the source code accordingly)
            -  have 5 columns as - student_id, first_name, last_name, email, enrollment_date
- Update the connection detail(DB url, username and password) in source code to match for your local setup
- After running the program
      1) It will print all the existing students in the DB
      2) add a student to the database
      3) delete a student by the given id
      4) update a student's email by the given id

NOTES:
   - make sure PostgresSQL is running locally
   - when adding a student use formatted data as "YYYY-MM-DD"
      
