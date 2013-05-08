package test;

import org.omg.OmgDAT;
import org.omg.model.OmgModel;

public class T_save {

	static class Student extends OmgModel{
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
	}
	
	public static void main(String[] args){
		for(int i=0;i<20;i++){
			Student s=new Student();
			s.age=(int) (20*Math.random());
			s.grade=(int) (10*Math.random());
			s.name="student"+(i+1);
			s.save();
		}
		System.out.println(OmgDAT.load(Student.class,null, null));
	}
}
