//ENCAPSULATION


//parent class

class Student1 {
      int rollNum=105;
     private int age=20;
     void m1()
    {                                                    // inheritence = extends parent class -->> child class
        System.out.println(age);
        System.out.println(rollNum);
    }
    void m2(){
        System.out.println("Sree_Ram");
    }
}


//child class 


class Exam extends Student1{
    public int fee=1000;
    private int roomNo=405;
    Exam(int a,int b){
        System.out.println(a+b);
    }
    //firstly void k1{}
    void m1()
    {
        System.out.println("java");
    }
    void k2(){
        System.out.println("Maths");
    }
}

//firstly class name is KLH

class KLHB{
    static{
        System.out.println("KLH Exam ");
    }
    public static void main(String[] args) {
    Exam E= new Exam(10,20);
    //Student1 s=new Student1();
    //s.rollNum=102;
    //System.out.println(s.rollNum);
    //System.out.println(s.m1());
    //System.out.println(s.age);             //private variable cannot access public method
    //Student1 s= new Student1();
   // Exam E= new Exam();
    //System.out.println(E.fee);
   // System.out.println(E.rollNum);
    //E.m1();
    //E.m1();

    //E.k1();
    }
}