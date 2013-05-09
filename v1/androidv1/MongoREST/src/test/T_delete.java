package test;

import org.omg.OmgDAT;
import org.omg.OmgField;
import org.omg.OmgSelector;

public class T_delete {

	public static void main(String[] args){
		OmgSelector selector=new OmgSelector();
		selector.addField(new OmgField("age").gt(10));
		OmgDAT.delete(T_save.student.class, selector);
	}
}
