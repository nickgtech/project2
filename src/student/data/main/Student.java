//********************************************************************************************************
// CLASS: Student.java (classname.java)
//
// DESCRIPTION
// Contains the Student abstract class which implements comparable and is to be extended by Online/OnCampus
// Student classes. 
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Fall 2017
// Project Number: p02
//
// AUTHOR
// Nicholes Gonzalez (nagonza6@asu.edu)
//********************************************************************************************************
package student.data.main;

public abstract class Student implements Comparable<Student> {

	private int mCredits; 
	private String mFname; 
	private String mID; 
	private String mLname; 
	private double mTution;	
	
	public Student (String pID, String pLName, String pFName) {
		this.mFname = pFName;
		this.mLname =pLName;
		this.mID = pID;
	}
	
	public void calcTuition(){
		//WILL BE OVERRIDDEN BY CHILDREN
	}; 
	
	public int getCredits() {
		return mCredits;
	}
	public void setCredits(int pCredits) {
		this.mCredits = pCredits;
	}
	public String getFname() {
		return mFname;
	}
	public void setFname(String pFname) {
		this.mFname = pFname;
	}
	public String getID() {
		return mID;
	}
	public void setID(String pID) {
		this.mID = pID;
	}
	public String getLname() {
		return mLname;
	}
	public void setLname(String pLname) {
		this.mLname = pLname;
	}
	public double getTution() {
		return mTution;
	}
	protected void setTution(double pTution) {
		this.mTution = pTution;
	}
}
