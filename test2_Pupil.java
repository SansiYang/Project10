package project10;

import java.util.Random;
import java.util.Scanner;

public class test2_Pupil {
	public static void main(String[] args) {
		PupilManager pm = new PupilManager();
		pm.showAll();
		pm.toString();
		
		System.out.println("���һ��ѧ��");
		Pupil p=new Pupil("����",20);
		pm.add(p);
		
		pm.add(new Pupil("����",22));
		pm.add(new Pupil("����",24));
		
		System.out.println("�ܹ���"+pm.size()+"��ѧ���������ǣ�");
		pm.showAll();
		
		System.out.println("������Ҫ���ҵ�������");
		Scanner sc=new Scanner(System.in);
		String name=sc.nextLine();
		
		pm.find(name);
		
		System.out.println("��ʼ�޸ģ�");
		pm.modify("����",50);
		pm.showAll();
		
		System.out.println("����");
		pm.sort();
		
		pm.showAll();

	}

}

class PupilManager {
	private int length = 5;
	private Pupil[] students = new Pupil[length];
	private int index; // ʵ���ж���ѧ��

	// ���췽�� ��ʼ��length��ѧ��
	public PupilManager() {
		// ��ʼ����������������ɣ��ټ���+һ�����֣������䣨���20-30��
		//Pupil[] pupils = new Pupil[length];
		char[] chs = new char[] { '��', '��', '��', '��', '��', '��', '��', '��', '��' };
		Random r = new Random();
		for (int i = 0; i < students.length; i++) {
			// ������
			int chsIndex = r.nextInt(chs.length);
			String firstName = chs[chsIndex] + "";
			// ������
			int cha = 0x9FA5 - 0x4E00;
			int ming = r.nextInt(cha) + 0x4E00;
			String secondName = (char) ming + "";
			// ��������
			int age = r.nextInt(10) + 20;

			Pupil p = new Pupil(firstName + secondName, age);

			// ��p����Students��
			students[i] = p;
			index++;
		}

	}

	//�������
	public void showAll() {
		for (int i = 0; i < index; i++) {
			System.out.println(students[i].toString());
		}
	}

	// ����
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

	// �޸�����
	public void modify(String name, int NewAge) {
		// �޸ĵ�һ������name��ѧ��������
		int nameIndex = find(name, 0);
		if (nameIndex == -1) {
			System.out.println("���޴��ˣ�");
			return;
		}
		Pupil p = students[nameIndex];
		p.setAge(NewAge);
		System.out.println("�޸ĳɹ����µ�ѧ����ϢΪ��" + p); // p�൱�� p.toString();
	}

	// ������������ѧ��
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

	// ���ѧ��
	public void add(Pupil student) {
		if (index >= students.length) {
			System.out.println("��̬������������ʼ�����ݡ�����");
			// �����µ����飬������ԭ���������
			Pupil[] newArray = new Pupil[students.length * 2];
			// ��ԭ��������ݸ��Ƶ���������
			for (int i = 0; i < students.length; i++) {
				newArray[i] = students[i];
			}
			students = newArray;
		}

		students[index] = student;
		index++;
	}

	// ��ȡ��̬����ʵ��Ԫ�ظ���
	public int size() {
		return index;
	}

	// ��ȡ���������
	public int capacity() {
		return students.length;
	}
}

class Pupil {
	private String name;
	private int age;

	// �вι��췽��
	public Pupil(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	// �޲ι��췽��
	public Pupil() {
		super();
	}

	// get �� set
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
