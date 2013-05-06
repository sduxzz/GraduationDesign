package test;

import java.util.HashMap;

import org.omg.restbase.HttpRequestMethod;
import org.omg.restbase.RestUtil;

public class T_connect {

	public static void main(String[] args){
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("save", "{\"name\",\"sww\"}");
		String res=RestUtil.sendRequest(HttpRequestMethod.HttpGet
				, "http://0.0.0.0:3001/test/user/", map);
		System.out.println(res);
	}
}
