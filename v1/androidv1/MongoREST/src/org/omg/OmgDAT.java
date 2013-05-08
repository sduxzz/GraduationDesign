package org.omg;

import java.util.ArrayList;
import java.util.HashMap;

import org.omg.generate.DecodeTool;
import org.omg.model.OmgModel;
import org.omg.restbase.HttpRequestMethod;
import org.omg.restbase.RestUtil;

/**
 * Data Access Tool
 * 
 * @author juqiang
 * 
 */
public class OmgDAT {

	public static void save(OmgModel omg) {
		String json = DecodeTool.objToJson(omg);
		RestUtil.sendRequest(HttpRequestMethod.HttpPost,
				Config.getMongoRestAddr() + omg.getClass().getSimpleName(),
				null, json);
	}

	public static <T extends OmgModel> ArrayList<T> load(Class<T> c,
			OmgSelector selector, OmgOption sort) {
		return load(c, selector.getSelector(), sort.getOptions());
	}
	
	private static <T extends OmgModel> ArrayList<T> load(Class<T> c,
			String selector, String opt) {
		HashMap<String, String> map = new HashMap<String, String>();
		if(selector!=null){
			map.put("selector", selector);
		}
		if(opt!=null){
			map.put("opt", opt);
		}
		String json=RestUtil.sendRequest(HttpRequestMethod.HttpGet,
				Config.getMongoRestAddr() + c.getSimpleName(), map, null);
		
		return (ArrayList<T>) DecodeTool.jsonToObjArr(json, c);
	}
}
