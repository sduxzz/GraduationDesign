package org.omg.model;

import java.io.Serializable;

import org.omg.Config;
import org.omg.generate.DecodeTool;
import org.omg.restbase.HttpRequestMethod;
import org.omg.restbase.RestUtil;

public class OmgModel implements Serializable{

	private static final long serialVersionUID = 1762263005212414891L;

	public void save(){
		String json=DecodeTool.objToJson(this);
		RestUtil.sendRequest(HttpRequestMethod.HttpPost
				, Config.getMongoRestAddr()+getClass().getSimpleName(), null,json);
	}
}
