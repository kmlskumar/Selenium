package Utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.management.RuntimeErrorException;

public class Property_data {
	
private Properties prop;
private final String propertyFilePath="./src/test/resources/prop.properties";

public void read_data_from_propertyfile() throws IOException{
	prop=new Properties();
	BufferedReader reader;
	File destination =new File(propertyFilePath);
	try{
	reader=new BufferedReader(new FileReader(propertyFilePath));
	//prop=new Properties();
	try{
	prop.load(reader);
	reader.close();
	}
	catch(IOException e){
		e.printStackTrace();
	}
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}
	}
public String getbrowser(){
	String browser = prop.getProperty("browser");
	if(browser!= null) return browser;
	else throw new RuntimeException("browser not specified in the Configuration.properties file.");		
}
	public String get_url(){
		String url = prop.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	
	}
	
	public String get_url2(){
		String url2 = prop.getProperty("url2");
		if(url2 != null) return url2;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	
	}
	

    public String getDriverPath(){
		String driverPath = prop.getProperty("Chromepath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
    public String getDriverPath_firefox(){
		String driverPath = prop.getProperty("Firefoxpath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
    public String get_from_city(){
    	String fromcity=prop.getProperty("from");
		if(fromcity!=null) return fromcity;
		else throw new RuntimeException("fromcity not specified in the configration.properties filr. ");
		
    }
    public String get_To_city(){
    	String Tocity=prop.getProperty("To");
		if(Tocity!=null) return Tocity;
		else throw new RuntimeException("fromcity not specified in the configration.properties filr. ");
    }
}


