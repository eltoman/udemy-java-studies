package application;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Program {

    static Set<Integer> students = new HashSet<>();

    public static void main(String args[]){
        studentsQuantity();
    }

    private static void studentsQuantity(){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many students for course A? ");
        int quantityCourseA = sc.nextInt();
        readStudents(quantityCourseA, sc);

        System.out.print("How many students for course B? ");
        int quantityCourseb = sc.nextInt();
        readStudents(quantityCourseb, sc);

        System.out.print("How many students for course C? ");
        int quantityCoursec = sc.nextInt();
        readStudents(quantityCoursec, sc);

        System.out.print("Total Students: " + students.size());

        sc.close();
    }

    private static void readStudents(int number, Scanner sc ){
        for (int i = 0; i < number; i++){
            System.out.print("Student " + (i+1) +" Code: ");
            students.add(sc.nextInt());
        }
    }
}
