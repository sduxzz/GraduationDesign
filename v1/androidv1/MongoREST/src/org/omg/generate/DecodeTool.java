package org.omg.generate;

import java.util.List;

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
	
	public static <T> List<T> jsonToObjArr(String json,Class<T> c){
		List<T> res=JSON.parseArray(json, c);
	    return res;
	}
}
