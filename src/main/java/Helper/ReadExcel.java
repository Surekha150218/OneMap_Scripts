package Helper;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ReadExcel {

	Workbook wb;
	Sheet sh;
	WritableWorkbook wwb;
	
	//Default constructor
	public ReadExcel() throws BiffException, IOException
	{
		File inputFile = new File("src\\main\\java\\Test Data\\Data.xls");
		wb = Workbook.getWorkbook(inputFile);
	}
	
	public String getData(int shno , int col , int row)
	{
		sh = wb.getSheet(shno);
		String Data = sh.getCell(col, row).getContents();
		return Data;
	}
	
	public int getRowCount(int shno)
	{
		sh = wb.getSheet(shno);
		int cnt = sh.getRows();
		return cnt;
	}
	
	
	
	public void writeData(int colnum, int rownum, String price) throws RowsExceededException, WriteException, IOException
	{
		   
		File outputFile = new File("src\\main\\java\\Test Data\\Data.xls");
		wwb = Workbook.createWorkbook(outputFile,wb);
		
		WritableSheet sht = wwb.getSheet(0);
		Label phPrice = new Label(colnum, rownum, price);
		sht.addCell(phPrice);
		System.out.println("Excel write: Price is    "+price);
		wb.close();
		wwb.write();
		wwb.close();
		  
		  	  
	}
}
