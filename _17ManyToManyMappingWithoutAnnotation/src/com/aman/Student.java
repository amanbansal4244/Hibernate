package com.aman;
import java.util.Set;
 /****
  * 
Applying many to many relationship between two pojo class objects is nothing but applying one to many relationship on both sides, which tends to Bi-Directional i mean many to many.

Example:

Let us see this, if we apply many to many association between two pojo class objects student and course, provided the relationship is one student may joined in multiple courses and one course contains lot of students (joined by multiple students)

Remember, when ever we are applying many to many relationship between two pojo class objects, on both sides  we need a collection property [As we are applying one to many from both the sides]

Note Points:
While applying many to many relationship between pojo classes,  a mediator table is mandatory in the database, to store primary key as foreign key both sides, we call this table as Join table
In many to many relationship join table contain foreign keys only
  */
public class Student {
 
 private int studentId;
 private String studentName;
 private int marks;
 
 private Set<Course> courses;
 
 public int getStudentId() {
 return studentId;
 }
 
 public void setStudentId(int studentId) {
 this.studentId = studentId;
 }
 
 public String getStudentName() {
 return studentName;
 }
 
 public void setStudentName(String studentName) {
 this.studentName = studentName;
 }
 
 public int getMarks() {
 return marks;
 }
 
 public void setMarks(int marks) {
 this.marks = marks;
 }
 
 public Set<Course> getCourses() {
 return courses;
 }
 
 public void setCourses(Set<Course> courses) {
 this.courses = courses;
 }
 
}
