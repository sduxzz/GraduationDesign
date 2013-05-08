package test;

import java.util.ArrayList;

import org.omg.OmgDAT;
import org.omg.OmgField;
import org.omg.OmgOption;
import org.omg.OmgSelector;
import org.omg.model.OmgModel;

public class T_load {

	static class ani extends OmgModel{
		private static final long serialVersionUID = -6778289744214333731L;
		
		private String name;
		private int age;
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
	}
	
	public static void main(String[] args){
		OmgSelector s=new OmgSelector();
		//s.addField(new OmgField("name").is("monkey"));
		s.addField(new OmgField("age").lte(115));
		System.out.println(s);
		OmgOption opt=new OmgOption();
		opt.limit(3).sort("age", false).sort("name",false);
		System.out.println(opt);
		ArrayList<ani> arr=OmgDAT.load(ani.class, s.toString(),opt.toString());
		//OmgDAT.load(ani.class, s.toString(),"{\"sort\":[[\"age\",\"DESC\"]],\"limit\":2}");
		for(ani temp:arr){
			System.out.println(temp.getName()+":"+temp.getAge());
		}
	}
}
