package test;

import org.omg.model.OmgModel;

public class T_save {

	static class ani extends OmgModel{
		private static final long serialVersionUID = -6778289744214333731L;
		
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
	
	public static void main(String[] args){
		ani u=new ani();
		u.setName("dog");
		u.save();
	}
}
