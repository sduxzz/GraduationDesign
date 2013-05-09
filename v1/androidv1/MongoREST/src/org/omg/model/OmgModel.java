package org.omg.model;

import java.io.Serializable;

import org.omg.OmgDAT;

public class OmgModel implements Serializable{

	private static final long serialVersionUID = 1762263005212414891L;

	public void save(){
		OmgDAT.save(this);
	}

	
}
