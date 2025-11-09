# COMP3005_assignment3_101305532_Gazi_Hossain
JAVA JDBC crud application that connects to local postgres server for assignment 3 COMP3005
This application includes functions
1) getAllStudent()
   - Gets all the students from studentsDB
2) addStudent()
   - Adds a student to the database
3) updateStudentEmail()
   - Updates the student's email for the given student_id
4) deleteStudent()
   - Deletes the student for the given student_id
  
#How to run
- Make sure to have a datebase in pgadmin that aligns with the requirements for this application
        - i.e. have a table name students, have 5 columns as - student_id, first_name, last_name, email, enrollment_date
- Update the username, password or database name(url) as needed
- After running the program
      - It will print all the students
      = add students to the database
      - delete students
      - update student's email
      
