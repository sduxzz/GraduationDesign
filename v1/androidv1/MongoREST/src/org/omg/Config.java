package org.omg;

public class Config {

	public static String address = "http://0.0.0.0";
	public static int dbRestPort = 3001;
	public static String CollectionName = "test";
	
	public static String getMongoRestAddr() {
		return address+":"+dbRestPort+"/"+CollectionName+"/";
	}
}
