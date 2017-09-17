//********************************************************************************************************
// CLASS: OnCampusStudent.java (classname.java)
//
// DESCRIPTION
// Contains the subclass of Student for On Campus Student. 
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Fall 2017
// Project Number: p02
//
// AUTHOR
// Nicholes Gonzalez (nagonza6@asu.edu)
//********************************************************************************************************
package student.data.main;

public class OnCampusStudent extends Student {
	
	private boolean mResident; 
	private double mProgramFee; 
	
	public OnCampusStudent(String pID, String pFName, String pLName) {
		super(pID, pFName, pLName);
	}

	
	@Override
	public void calcTuition() {
		
		double t; 
		
		if(this.getResidency() == true) {
			
			t = TuitionConstants.ONCAMP_RES_BASE;
		
		} else {
		
			t = TuitionConstants.ONCAMP_NONRES_BASE;
	
		}
		
		t = t + getProgramFee();
		
		if (this.getCredits() > TuitionConstants.ONCAMP_MAX_CREDITS ){
			
			t = t + (getCredits() - TuitionConstants.ONCAMP_MAX_CREDITS) * TuitionConstants.ONCAMP_ADD_CREDITS; 
			
		}
		
		this.setTution(t);
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


	public boolean getResidency() {
		return mResident;
	}


	public void setResidency(boolean pResident) {
		this.mResident = pResident;
	}


	public double getProgramFee() {
		return mProgramFee;
	}


	public void setProgramFee(double pProgramFee) {
		this.mProgramFee = pProgramFee;
	} 
	
}
