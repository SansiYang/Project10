package project10;

import java.util.Random;

public class test1 {

	public static void main(String[] args) {
		// int [] a=new int[]{1};
		//基本类型：boolean  byte  short  char  int  long  float  double
		//引用型：String
		
		Student [] students=new Student[10];
		Random r=new Random();
		
		Address a1=new Address("湖南","湘潭");
		Address a2=new Address("湖南","长沙");
		
		for(int i=0;i<students.length;i++) {
			if((i+1)%2==0) {
				students[i]=new Student(r.nextInt(100),"胡"+r.nextInt(100),a2);
			}else {
				students[i]=new Student(r.nextInt(100),"胡"+r.nextInt(100),a1);
			}
			
		}
		for(int i=0;i<students.length;i++) {
			Student s=students[i];
			System.out.println(s.toString());
			//System.out.println(s.getName()+"\t"+s.getId()+"\t"+s.getAddress().getProvince()+"\t"+s.getAddress().getCity()	);
		}
		
		//Stutent s4=stedents[4];

	}

}

class Address{
	private String province;
	private String city;
	public Address(String province, String city) {
		super();
		this.province = province;
		this.city = city;
	}
	public Address() {
		super();
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	//返回这个类对象的详细信息
	public String toString() {
		return province+"\t"+city;
	}
}


class Student{
	private int id;
	private String name;
	private Address address;
	
	public Student() {
		super();
	}
	
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Student(int id, String name,Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address=address;
	}
	
	//返回类对象的详细信息
	public String toString() {
		return id+"\t"+name;
	}
	
	
}
