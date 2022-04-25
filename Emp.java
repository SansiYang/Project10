package project10;

public class Emp {
	private String name;
	private int empNo;
	
	public String toString() {
		return "Emp [name="+name+","+"empNo="+empNo+"]";
	}
	
	

	public Emp() {
		super();
	}



	public Emp(String name, int empNo) {
		super();
		this.name = name;
		this.empNo = empNo;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	

}
