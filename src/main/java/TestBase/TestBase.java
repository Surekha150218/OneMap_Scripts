package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

	Properties properties;
	
		
public void loadData() throws IOException{
	
	
	properties = new Properties();
	
	File f = new File(System.getProperty("user.dir")+"\\src\\main\\java\\Test Data\\TestBase.properties");
	FileReader obj = new FileReader(f);
	properties.load(obj);
	
	}

public String getObject(String Data) throws IOException {
	
	loadData();
	String data =properties.getProperty(Data);
	
	return data;
	
}
	

}
