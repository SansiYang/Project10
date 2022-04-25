package project10;

public class Manager extends Emp {
	private int allowance;  //²¹Öú
	private String rights;  //È¨ÏÞ
	
	
	public String toString() {
		return getEmpNo()+"\t"+getName()+"\t"+allowance+"\t"+rights;
	}
	
	
	public Manager(String name,int empNo,int allowance, String rights) {
		super(name,empNo);
		this.allowance = allowance;
		this.rights = rights;
	}
	
	
	
	public Manager() {
		super();
	}



	public int getAllowance() {
		return allowance;
	}
	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}
	public String getRights() {
		return rights;
	}
	public void setRights(String rights) {
		this.rights = rights;
	}
	

}
