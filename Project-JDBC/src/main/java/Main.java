import connection.DBConnection;
import entity.Student;
import process.DBProcess;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//         DBConnection.getConnection();
//         DBConnection.closeConnection();

        Scanner sc = new Scanner(System.in);


        Student student1 = new Student(6, "Cavid", "Azizov", 1990, 1420264);
        Student student2 = new Student(7, "Amil", "Ahmadov", 1985, 52162);
        Student student3 = new Student(9, "Allahverdi", "Qarayev", 1999, 891526);

        List<Student> listOfStudents = new ArrayList<>();
        listOfStudents.add(student1);
        listOfStudents.add(student2);
        listOfStudents.add(student3);
        DBProcess.insertStudent(listOfStudents);


        Student updateStudent = new Student(6, "Kamil", "Ahmadov", 1994, 58255);
        DBProcess.updateStudent(updateStudent);


        DBProcess.createStudentTable();


        System.out.println("Enter Id which you want delete");
        DBProcess.deleteStudent(sc.nextInt());


        DBProcess.findStudentById();

        DBProcess.findStudentLikeName();


    }
}
