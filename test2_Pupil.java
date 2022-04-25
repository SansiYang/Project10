package project10;

import java.util.Random;
import java.util.Scanner;

public class test2_Pupil {
	public static void main(String[] args) {
		PupilManager pm = new PupilManager();
		pm.showAll();
		pm.toString();
		
		System.out.println("添加一个学生");
		Pupil p=new Pupil("张三",20);
		pm.add(p);
		
		pm.add(new Pupil("张三",22));
		pm.add(new Pupil("张三",24));
		
		System.out.println("总共有"+pm.size()+"个学生，他们是：");
		pm.showAll();
		
		System.out.println("请输入要查找的姓名：");
		Scanner sc=new Scanner(System.in);
		String name=sc.nextLine();
		
		pm.find(name);
		
		System.out.println("开始修改！");
		pm.modify("张三",50);
		pm.showAll();
		
		System.out.println("排序");
		pm.sort();
		
		pm.showAll();

	}

}

class PupilManager {
	private int length = 5;
	private Pupil[] students = new Pupil[length];
	private int index; // 实际有多少学生

	// 构造方法 初始化length个学生
	public PupilManager() {
		// 初始化姓名（由两字组成，百家姓+一个汉字）和年龄（随机20-30）
		//Pupil[] pupils = new Pupil[length];
		char[] chs = new char[] { '赵', '刘', '张', '杨', '李', '胡', '王', '陈', '周' };
		Random r = new Random();
		for (int i = 0; i < students.length; i++) {
			// 生成姓
			int chsIndex = r.nextInt(chs.length);
			String firstName = chs[chsIndex] + "";
			// 生成名
			int cha = 0x9FA5 - 0x4E00;
			int ming = r.nextInt(cha) + 0x4E00;
			String secondName = (char) ming + "";
			// 生成年龄
			int age = r.nextInt(10) + 20;

			Pupil p = new Pupil(firstName + secondName, age);

			// 将p存入Students中
			students[i] = p;
			index++;
		}

	}

	//输出所有
	public void showAll() {
		for (int i = 0; i < index; i++) {
			System.out.println(students[i].toString());
		}
	}

	// 排序
	public void sort() {
		//
		for (int i = 0; i < size() - 1; i++) {
			for (int j = 1; j < size() - 1; j++) {
				if (students[j].getAge() < students[j - 1].getAge()) {
					Pupil temp = students[j];
					students[j] = students[j - 1];
					students[j - 1] = temp;
				}
			}
		}
	}

	// 修改年龄
	public void modify(String name, int NewAge) {
		// 修改第一个满足name的学生的姓名
		int nameIndex = find(name, 0);
		if (nameIndex == -1) {
			System.out.println("查无此人！");
			return;
		}
		Pupil p = students[nameIndex];
		p.setAge(NewAge);
		System.out.println("修改成功，新的学生信息为：" + p); // p相当于 p.toString();
	}

	// 根据姓名查找学生
	public void find(String name) {
		int index = 0;
		do {
			index = find(name, index);
			if (index == -1) {
				break;
			}
			Pupil p = students[index];
			System.out.println(p.toString());
			index++;
		} while (true);
	}

	public int find(String name, int startIndex) {
		int index = -1;
		for (int i = startIndex; i < size(); i++) {
			Pupil p = students[i];
			if (p.getName().equals(name)) {
				index = i;
				break;
			}
		}
		return index;
	}

	// 添加学生
	public void add(Pupil student) {
		if (index >= students.length) {
			System.out.println("动态数组已满，开始自扩容。。。");
			// 产生新的数组，长度是原数组的两倍
			Pupil[] newArray = new Pupil[students.length * 2];
			// 将原数组的数据复制到新数组中
			for (int i = 0; i < students.length; i++) {
				newArray[i] = students[i];
			}
			students = newArray;
		}

		students[index] = student;
		index++;
	}

	// 获取动态数组实际元素个数
	public int size() {
		return index;
	}

	// 获取数组的容量
	public int capacity() {
		return students.length;
	}
}

class Pupil {
	private String name;
	private int age;

	// 有参构造方法
	public Pupil(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	// 无参构造方法
	public Pupil() {
		super();
	}

	// get 和 set
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// toString
	public String toString() {
		return "Pupil [name=" + name + ", age=" + age + "]";
	}

}
