package test;

import java.util.ArrayList;

import org.omg.OmgDAT;
import org.omg.model.OmgModel;

public class T_save {

	public static class student extends OmgModel{
		private static final long serialVersionUID = -6778289744214333731L;
		
		private String name;
		private int age;
		private int grade;
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

		public int getGrade() {
			return grade;
		}

		public void setGrade(int grade) {
			this.grade = grade;
		}
		
		@Override
		public String toString() {
			return name+":"+grade+":"+age;
		}
	}
	
	public static void main(String[] args){
		ArrayList<student> sArr=OmgDAT.load(student.class,null, null);
		student st=sArr.get(0);
		st.setAge(3);
		st.save();
		sArr=OmgDAT.load(student.class,null, null);
		for(student s:sArr){
			System.out.println(s.toString());
		}
	}
}
