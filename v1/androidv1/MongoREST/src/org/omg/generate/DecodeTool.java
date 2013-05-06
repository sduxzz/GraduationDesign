package org.omg.generate;

import org.omg.model.OmgModel;

import com.alibaba.fastjson.JSON;

public class DecodeTool {

	public static String objToJson(OmgModel model){
		String res=null;
		res=JSON.toJSONString(model);
		return res;
	}
	
	public static <T> Object jsonToObj(String json,Class<T> c){
		T res=null;
		res=JSON.parseObject(json, c);
	    return res;
	}
}