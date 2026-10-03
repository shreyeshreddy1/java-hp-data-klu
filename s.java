// 
// Student class











// import java.util.*;

// class Student {
//     public String name;   
//     private int age;     

//     public Student(String name, int age) {
//         this.name = name;
//         this.age = age;
//     }


//     public void displayStudentInfo() {
//         System.out.println("Student Age : " + age);
//     }


//     public void setAge(int newAge) {
//         age = newAge;
//         System.out.println("Age updated successfully!");
//     }
// }

// class Subject {
//     public String subjectName;  
//     private int marks;          


//     public Subject(String subjectName, int marks) {
//         this.subjectName = subjectName;
//         this.marks = marks;
//     }

//     public void displaySubjectInfo() {
//         System.out.println("Marks       : " + marks);
//     }


//     public void updateMarks(int newMarks) {
//         marks = newMarks;
//         System.out.println("Marks updated successfully!");
//     }
// }


// public class s {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         System.out.print("Enter student name: ");
//         String studentName = scanner.nextLine();
//         System.out.print("Enter student age: ");
//         int studentAge = scanner.nextInt();

//         Student student = new Student(studentName, studentAge);
//         student.displayStudentInfo();

//         System.out.println("-------------------------");
//         scanner.nextLine(); // Consume the leftover newline.

//         System.out.print("Enter subject name: ");
//         String subjectName = scanner.nextLine();
//         System.out.print("Enter marks: ");
//         int marks = scanner.nextInt();

//         Subject subject = new Subject(subjectName, marks);
//         subject.displaySubjectInfo();

//         scanner.close();
//     }
// }






// class Student {
//     private final int rollNum;
//     private final int age;

//     Student(int rollNum, int age) {
//         this.rollNum = rollNum;
//         this.age = age;
//     }

//     void displayInfo() {
//         System.out.println("Roll number: " + rollNum);
//         System.out.println("Age: " + age);
//     }
// }

// class Exam {
//     private final int fee;
//     private final int roomNo;

//     Exam(int fee, int roomNo) {
//         this.fee = fee;
//         this.roomNo = roomNo;
//     }

//     void displayInfo() {
//         System.out.println("Exam fee: " + fee);
//         System.out.println("Room number: " + roomNo);
//     }
// }

// public class s {
//     public static void main(String[] args) {
//         Student student = new Student(101, 20);
//         Exam exam = new Exam(500, 12);

//         student.displayInfo();
//         exam.displayInfo();
//     }
// }

