//********************************************************************************************************
// CLASS: OnlineStudent.java (classname.java)
//
// DESCRIPTION
// Contains the subclass of student for Online Student. 
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Fall 2017
// Project Number: p02
//
// AUTHOR
// Nicholes Gonzalez (nagonza6@asu.edu)
//********************************************************************************************************
package student.data.main;

public class OnlineStudent extends Student {
	
	private boolean mTechFee;
	
	public OnlineStudent(String pID, String pFName, String pLName) {
		super(pID, pFName, pLName);
	}

	@Override
	public int compareTo(Student stud) {
		
		String myID = this.getID();
		String studID = stud.getID();
		
		double doubMyId = Double.parseDouble(myID);
		double doubStudId = Double.parseDouble(studID);
		
		if( doubMyId < doubStudId) {
			return -1;
		}
		
		if(doubMyId > doubStudId) {
			return 1;
		}
		
		return 0;
	}
	
	@Override
	public void calcTuition() {
		double t = getCredits() * TuitionConstants.ONLINE_CREDIT_BASE;
		
		if (this.getTechFee() == true) {
			t  = t + TuitionConstants.ONLINE_TECH_FEE;
		} 
		
		this.setTution(t);
		
	}

	public boolean getTechFee() {
		return mTechFee;
	}

	public void setTechFee(boolean mTechFee) {
		this.mTechFee = mTechFee;
	}

}
