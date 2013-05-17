package org.omg;

public class OmgField {

	private String name;
	private String qString="";
	public OmgField(String name){
		this.name=name;
	}
	
	public OmgField(String name,Object value){
		this(name);
		is(value);
	}
	
	public OmgField is(Object o){
		qString+=split()+ toJsonString(name)+":"+(o instanceof String?toJsonString(o):o.toString());
		return this;
	}
	/**
	 * 大于o的值
	 * @param o
	 * @return
	 */
	public OmgField gt(Object o){
		qString+=split()+ toJsonString(name)+":{\"$gt\":"+(o instanceof String?toJsonString(o):o.toString())+"}";
		return this;
	}
	
	public OmgField lt(Object o){
		qString+=split()+ toJsonString(name)+":{\"$lt\":"+(o instanceof String?toJsonString(o):o.toString())+"}";
		return this;
	}
	
	public OmgField gte(Object o){
		qString+=split()+ toJsonString(name)+":{\"$gte\":"+(o instanceof String?toJsonString(o):o.toString())+"}";
		return this;
	}
	
	public OmgField lte(Object o){
		qString+=split()+ toJsonString(name)+":{\"$lte\":"+(o instanceof String?toJsonString(o):o.toString())+"}";
		return this;
	}
	
	public OmgField ne(Object o){
		qString+=split()+ toJsonString(name)+":{\"$ne\":"+(o instanceof String?toJsonString(o):o.toString())+"}";
		return this;
	}
	

	@Override
	public String toString() {
		return qString;
	}
	
	private String toJsonString(Object o){
		return "\""+o+"\"";
	}
	
	private String split() {
		return qString.length()==0?"":",";
	}
}
