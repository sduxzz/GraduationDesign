package test;

import org.omg.OmgDAT;
import org.omg.OmgField;
import org.omg.OmgOption;
import org.omg.OmgSelector;

public class T_update {

	public static void main(String[] args){
		OmgSelector selector=new OmgSelector();
		selector.addField(new OmgField("name", "student31"));
		OmgDAT.update(T_save.student.class, selector, new OmgOption().multi(true).upsert(true), new OmgField("age", 250),new OmgField("grade","ÁùÄê¼¶"));
	}
}
