//********************************************************************************************************
// CLASS: Main.java (classname.java)
//
// DESCRIPTION
// The main class. Contains the main method as well as the methods that control the File I/O
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Fall 2017
// Project Number: p02
//
// AUTHOR
// Nicholes Gonzalez (nagonza6@asu.edu)
//********************************************************************************************************
package student.data.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    /**
     *  Instantiate a Main object and call run() on the object.
     */
    public static void main(String[] args) {
        try {
			run();
		} catch (FileNotFoundException e) {
			System.out.println("Sorry, could not open 'p02-students.txt' for reading. Stopping.");
			e.printStackTrace();
			System.exit(0);
		}
    }

    /**
     * Calculates the tuition for each student. Write an enhanced for loop that iterates over each Student in
     * pStudentList. For each Student, call calcTuition() on that Student. Note: this is a polymorphic method
     * call.
     *
     * PSEUDOCODE
     * EnhancedFor each student in pStudentList Do
     *     student.calcTuition()
     * End EnhancedFor
     */
    private static void calcTuition(List<Student> pStudentList) {
       for (Student s : pStudentList) {
    	   s.calcTuition();
       } 
    }

    /**
     * Reads the student information from "p02-students.txt" and returns the list of students as an ArrayList
     * <Student> object.
     *
     * PSEUDOCODE
     * Declare and create an ArrayList<Student> object named studentList.
     * Open "p02-students.txt" for reading using a Scanner object named in.
     * While in.hasNext() returns true Do
     *     String studentType <- read next string from in
     *     If studentType is "C" Then
     *         studentList.add(readOnCampusStudent(in))
     *     Else
     *         studentList.add(readOnlineStudentW(in))
     *     End If
     * End While
     * Close the scanner
     * Return studentList
     */
    private static List<Student> readFile() throws FileNotFoundException {
		
    	List<Student> studentList = new ArrayList<>();
		Scanner in = new Scanner(new File("p02-students.txt"));
		
		while(in.hasNextLine()) {
			
			String studentType = in.next();
			
			if(studentType.equals("C")) {
				
				studentList.add(readOnCampusStudent(in));
				
			} else { 
				
				studentList.add(readOnlineStudent(in));
				
			}
		}
		
		in.close();
    	return studentList;   
    }

    /**
     * Reads the information for an on-campus student.
     *
     * PSEUDOCODE
     * Declare String object id and assign pIn.next() to id
     * Declare String object named lname and assign pIn.next() to lname
     * Declare String object named fname and assign pIn.next() to fname
     * Declare and create an OnCampusStudent object. Pass id, fname, and lname as params to ctor.
     * Declare String object named res and assign pIn.next() to res
     * Declare double variable named fee and assign pIn.nextDouble() to fee
     * Declare int variable named credits and assign pIn.nextInt() to credits
     * If res.equals("R") Then
     *    Call setResidency(true) on student
     * Else
     *    Call setResidency(false) on student
     * End If
     * Call setProgramFee(fee) on student
     * Call setCredits(credits) on student
     * Return student
     */
    private static OnCampusStudent readOnCampusStudent(Scanner pIn) {
		
    	String id = pIn.next();
		String lName = pIn.next();
		String fName = pIn.next();
		String res = pIn.next();
		double fee = pIn.nextDouble();
		int credits = pIn.nextInt();
		
		OnCampusStudent ocStudent = new OnCampusStudent(id, lName, fName);
		
		if (res.equals("R")){
			ocStudent.setResidency(true);
		} else {
			ocStudent.setResidency(false);
		}
		
		ocStudent.setProgramFee(fee);
		ocStudent.setCredits(credits);
		
    	return ocStudent;

    }

    /**
     * Reads the information for an online student.
     *
     * PSEUDOCODE
     * Declare String object id and assign pIn.next() to id
     * Declare String object named lname and assign pIn.next() to lname
     * Declare String object named fname and assign pIn.next() to fname
     * Declare and create an OnlineStudent object. Pass id, fname, lname as params to the ctor.,
     * Declare String object named fee and assign pIn.next() to fee
     * Declare int variable named credits and assign pIn.nextInt() to credits
     * If fee.equals("T")) Then
     *     Call setTechFee(true) on student
     * Else
     *     Call setTechFee(false) on student
     * End If
     * Call setCredits(credits) on student
     * Return student
     */
    private static OnlineStudent readOnlineStudent(Scanner pIn) {
    	String id = pIn.next();
		String lName = pIn.next();
		String fName = pIn.next();
		String fee = pIn.next();
		int credits = pIn.nextInt();
		
		OnlineStudent olStudent = new OnlineStudent(id, lName, fName);
		
		if (fee.equals("T")){
			olStudent.setTechFee(true);
		} else {
			olStudent.setTechFee(false);
		}
		
		olStudent.setCredits(credits);
		
    	return olStudent;
        
    }

    /**
     *  Calls other methods to implement the sw requirements.
     *
     * PSEUDOCODE
     * Declare ArrayList<Student> object named studentList
     * try
     *     studentList = readFile()
     *     calcTuition(studentList)
     *     Call Sorter.insertionSort(studentList, Sorter.SORT_ASCENDING) to sort the list
     *     writeFile(studentList)
     * catch FileNotFoundException
     *     Print "Sorry, could not open 'p02-students.txt' for reading. Stopping."
     *     Call System.exit(-1)
     * @throws FileNotFoundException 
     */
    private static void run() throws FileNotFoundException {
        List<Student> studentList = new ArrayList<>(); 
        studentList = readFile();
        calcTuition(studentList);
        Sorter.insertionSort(studentList, Sorter.SORT_ASCENDING);
        writeFile(studentList);
    }

    /**
     *  Writes the output file to "p02-tuition.txt" per the software requirements.
     *
     * PSEUDOCODE
     * Declare and create a PrintWriter object named out. Open "p02-tuition.txt" for writing.
     * EnhancedFor each student in pStudentList Do
     *     out.print(student id + " " + student last name + " " + student first name)
     *     out.printf("%.2f%n" student tuition)
     * End EnhancedFor
     * Close the output file
     */
    private static void writeFile(List<Student> pStudentList) throws FileNotFoundException {
        
    	PrintWriter out = new PrintWriter(new File("p02-tuition.txt")); 
        
    	for (Student s : pStudentList) {
			double tuition = s.getTution();
    		out.print(s.getID() + " " + s.getLname() + " " + s.getFname() + " ");
    		out.printf("%.2f%n", tuition);
    	}
    	
    	out.close();
    }
}