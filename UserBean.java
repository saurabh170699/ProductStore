package Test1;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserBean implements Serializable 
{
	private String uName,pWord, fName, lName, Addr, mId;
	private long PhNo;
	
	public UserBean() {
		super();
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getpWord() {
		return pWord;
	}

	public void setpWord(String pWord) {
		this.pWord = pWord;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAddr() {
		return Addr;
	}

	public void setAddr(String addr) {
		Addr = addr;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public long getPhNo() {
		return PhNo;
	}

	public void setPhNo(long phNo) {
		PhNo = phNo;
	}
	
	
	

}
