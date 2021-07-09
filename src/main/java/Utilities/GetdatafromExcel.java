package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;



public class GetdatafromExcel {
	 
	public static String TestDataPath=Utilities.ProjectConfigurations.LoadProperties("TestDataPath");
	public static String SheetName=Utilities.ProjectConfigurations.LoadProperties("SheetName");
	 public static String s = System.getProperty("user.dir")+"/"+TestDataPath;
	 public static Map<String, Integer> map = new HashMap<String,Integer>();

	 public static ArrayList<Object[]> getDataFromExcel() throws BiffException, IOException{
		 
		 ArrayList<Object[]> data=new ArrayList<Object[]>();
		 
		 Workbook wk1=Workbook.getWorkbook(new File(s));
		 Sheet sh=wk1.getSheet(SheetName);
		 int Rows=sh.getRows();
		 Cell[] cell=null;
		 for(int i=0;i<Rows;i++) {
			 cell=sh.getRow(i);
			 map.put(cell[i].getContents(), i);
		 }
		 for(int j=1;j<=Rows;j++) {
			 
			 String Search=sh.getCell(map.get("Search"), j).getContents().trim();
			 String HospitalName=sh.getCell(map.get("HospitalName"), j).getContents().trim();
			 System.out.println("Search value is "+Search);
		 }
		 
		return data;
		 
		 
		 
		
		 
	 }
}