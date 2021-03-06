package org.omg;

import java.util.ArrayList;

public class OmgOption {
	public static final String ASC="ASC";
	public static final String DESC="DESC";

	private String qString = "{";
	private ArrayList<String> sortArr;
	private String[] fieldArr;
	private static final String sortMark="__sort__:";
	private static final String fieldMark="__field__:";

	public String getOptions() {
		makeup();
		return qString + "}";
	}
	
	public String toString() {
		makeup();
		return qString + "}";
	}
	
	public void addOption(String opt) {
		if (qString.length() == 1) {
			qString += opt;
		} else {
			qString += "," + opt;
		}
	}
	
	public OmgOption skip(int num){
		addOption(toJsonString("skip")+":"+num);
		return this;
	}
	
	public OmgOption limit(int num){
		addOption(toJsonString("limit")+":"+num);
		return this;
	}
	
	public OmgOption upsert(boolean updateOrInsert){
		addOption(toJsonString("upsert")+":"+updateOrInsert);
		return this;
	}
	
	public OmgOption multi(boolean multi){
		addOption(toJsonString("multi")+":"+multi);
		return this;
	}
	
	public OmgOption sort(String field,boolean asc){
		if(sortArr==null){
			sortArr=new ArrayList<String>();
			addOption(sortMark);
		}
		sortArr.add("["+toJsonString(field)+","+(asc?toJsonString("ASC"):toJsonString("DESC"))+"]");
		return this;
	}
	
	public OmgOption field(String[] fields){
		if(fieldArr==null){
			fieldArr=fields;
			addOption(fieldMark);
		}
		return this;
	}
	
	
	private String toJsonString(Object o){
		return "\""+o+"\"";
	}
	
	private void makeup(){
		if(sortArr!=null){
			String sortString=toJsonString("sort")+":[";
			for(int i=0;i<sortArr.size()-1;i++){
				sortString+=sortArr.get(i)+",";
			}
			sortString+=sortArr.get(sortArr.size()-1)+"]";
			qString=qString.replace(sortMark, sortString);
		}
		if(fieldArr!=null){
			String fieldString=toJsonString("fields")+":[";
			for(int i=0;i<fieldArr.length-1;i++){
				fieldString+=toJsonString(fieldArr[i])+",";
			}
			fieldString+=toJsonString(fieldArr[fieldArr.length-1])+"]";
			qString=qString.replace(fieldMark, fieldString);
		}
	}

}
