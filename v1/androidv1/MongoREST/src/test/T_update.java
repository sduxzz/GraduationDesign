package test;

import org.omg.OmgDAT;
import org.omg.OmgField;
import org.omg.OmgOption;
import org.omg.OmgSelector;

public class T_update {

	public static void main(String[] args){
		OmgSelector selector=new OmgSelector();
		selector.addField(new OmgField("name", "student3"));
		OmgDAT.update(T_save.student.class, selector, new OmgOption(), new OmgField("age", 1024),new OmgField("grade","ÁùÄê¼¶"));
	}
}
