package process;

import connection.DBConnection;
import entity.Student;

import java.security.PublicKey;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class DBProcess {

    private static Connection connection = DBConnection.getConnection();
   // private static Statement statement=null;

    private static PreparedStatement preparedStatement = null;
    
    private static ResultSet resultSet=null;

    public static void createStudentTable(){
        try {
            String query = "CREATE TABLE student(studentId INT PRIMARY KEY NOT NULL, name VARCHAR(255), surname VARCHAR(250)," +
                    "birthdate INT, studentNumber VARCHAR(20))";
            preparedStatement= connection.prepareStatement(query);
            preparedStatement.execute();
            System.out.println("Student table has created succesfully !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        finally {
            if (preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        DBConnection.closeConnection();


    }


    public static void insertStudent(List <Student> listOfStudents){
        String query="INSERT INTO student(studentId, name, surname, birthdate, studentNumber) VALUES(?,?,?,?,?)";
        try {


            preparedStatement=connection.prepareStatement(query);

            for(Student student : listOfStudents){
                preparedStatement.setInt(1,student.getStudentId());
                preparedStatement.setString(2, student.getName());
                preparedStatement.setString(3,student.getSurname());
                preparedStatement.setInt(4,student.getBirthDate());
                preparedStatement.setInt(5,student.getStudentNumber() );

                preparedStatement.addBatch();
            }


            preparedStatement.executeBatch();
            System.out.println("Data Insert has succesfully !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static  void updateStudent(Student student){
        String query = ("UPDATE student SET name=?, surname=?, birthdate=?, studentNumber=? WHERE studentId=?");
        try {
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setInt(3,student.getBirthDate());
            preparedStatement.setInt(4  ,student.getStudentNumber());
            preparedStatement.setInt(5  ,student.getStudentId());
            preparedStatement.executeUpdate();

            System.out.println("Data update has succesfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnection.closeConnection();
        }


    }
     public static void deleteStudent(Integer id){
        String query="DELETE FROM student where studentId=?";
         try {
             preparedStatement=connection.prepareStatement(query);

             preparedStatement.setInt(1,id);
             preparedStatement.execute();

             System.out.println("Delete from DataBase has succesfully");
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
         finally {
             DBConnection.closeConnection();
         }
     }

     public static void findStudentById(){
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter student's Id");
         int studentId = sc.nextInt();

         String query = "SELECT * FROM student WHERE studentId=?";

         try {
             preparedStatement=connection.prepareStatement(query);
             preparedStatement.setInt(1,studentId);

              resultSet = preparedStatement.executeQuery();
             System.out.println("Find By Id has Succesfully !");

             if (resultSet.next()){
                 Integer id = resultSet.getInt(1);
                 String name = resultSet.getString(2);
                 String surName=resultSet.getString(3);
                 int birtDay= resultSet.getInt(4);
                 int student_Id=resultSet.getInt(5);

                 System.out.println(id + " " + name + " "+ surName + " " +birtDay+ " " +student_Id);
             }
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
         finally {
             DBConnection.closeConnection();
         }

     }


     public static void findStudentLikeName(){
         Scanner scanner = new Scanner(System.in);
         System.out.println("Enter a litte letter: ");
         String letter=scanner.nextLine();

         String query = "SELECT * FROM student WHERE name LIKE '"+letter+"%'" ;

         try {

             preparedStatement=connection.prepareStatement(query);
             resultSet=preparedStatement.executeQuery();

             while (resultSet.next()){
                 String name= resultSet.getString(2);
                 String surname =resultSet.getString(3);

                 System.out.println(name + " " + surname);
             }


         } catch (SQLException e) {
             throw new RuntimeException(e);
         }

     }
}
