package org.omg;

public class OmgSelector {

	private String qString="{";
	
	public String getSelector(){
		return qString+"}";
	}
	
	public void addField(OmgField field){
		if(qString.length()==1){
			qString+=field;
		}else{
			qString+=","+field;
		}
	}
	
	public String toString(){
		return qString+"}";
	}
}
