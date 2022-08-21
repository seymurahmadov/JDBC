package entity;


public class Student {
    private Integer studentId;
    private String name;
    private String surname;
    private Integer birthDate;
    private Integer studentNumber;

    public Student(Integer studentId, String name, String surname, Integer birthDate, Integer studentNumber) {
        this.setStudentId(studentId);
        this.setName(name);
        this.setSurname(surname);
        this.setBirthDate(birthDate);
        this.setStudentNumber(studentNumber);
    }


    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Integer birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }
}
