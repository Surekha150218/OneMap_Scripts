package Utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;


public class Reporting_Utilities {
	
	public static File lastFileModified(String dir) {
	    File fl = new File(dir);
	    File[] files = fl.listFiles(new FileFilter() {          
	        public boolean accept(File file) {
	            return file.isFile();
	        }
	    });
	    long lastMod = Long.MIN_VALUE;
	    File choice = null;
	    for (File file : files) {
	        if (file.lastModified() > lastMod) {
	            choice = file;
	            lastMod = file.lastModified();
	        }
	    }
	    return choice;
	}
	
	public static String lastFileNameModified(String dir) {
	    File fl = new File(dir);
	    File[] files = fl.listFiles(new FileFilter() {          
	        public boolean accept(File file) {
	            return file.isFile();
	        }
	    });
	    long lastMod = Long.MIN_VALUE;
	    File choice = null;
	    for (File file : files) {
	        if (file.lastModified() > lastMod) {
	            choice = file;
	            lastMod = file.lastModified();
	        }
	    }
	    return choice.getName();
	}
	public static String lastFileNameModifiedWord(String dir) {
	    File fl = new File(dir);
	    File[] files = fl.listFiles(new FileFilter() {          
	        public boolean accept(File file) {
	            return file.isFile();
	        }
	    });
	    long lastMod = Long.MIN_VALUE;
	    File choice = null;
	    for (File file : files) {
	        if (file.lastModified() > lastMod && file.getName().contains(".doc")) {
	            choice = file;
	            lastMod = file.lastModified();
	        }
	    }
	    return choice.getName();
	}
	
	public static void writeStepToHTMLLog(String tcid, String stepno,String StepDescription, String stepresult, String result, String screenshotpath,String ResultPath)


	{      
		
		
		
		String FilePath=ResultPath+"HTMLtLog.txt";
		
		//System.out.println("File Path is "+FilePath);
		
		
		 try { 
				File file = new File(FilePath);

				// if file doesn't exists, then create it
				if (!file.exists()) 
				{
					file.createNewFile();
				}

				FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
				BufferedWriter bw = new BufferedWriter(fw);
				String dattim=getCurrentDate.getISTTimeHTML();
				//String latestFileName=Reporting_Utilities.lastFileNameModified(ResultPath+"Screenshot/"+tcid);
				//String content=tcid+" :::::  "+Comment+":::"+result;
				//String screenshotcontent=Comment+" : "+result;
				bw.write("<tr>");
				
				bw.write("<td class='tdborder_1'>"+stepno+"</td>");
				bw.write("<td class='tdborder_1'>"+StepDescription+"</td>");
				bw.write("<td class='tdborder_1'>"+stepresult+"</td>");
				bw.write("<td class='tdborder_1_"+result+"'>"+result+"</td>");
				bw.write("<td class='tdborder_1'>"+dattim+"</td>");
				//bw.write("<td class='tdborder_1'><a href='"+ResultPath+"Screenshot/"+tcid+"/"+latestFileName+"'>Screenshot</a></td>");
				bw.write("</tr>");
				//bw.write("<tr>");
				
				System.out.println("Inside html generator screenshotpath"+screenshotpath);
				//System.out.println("Inside html generator latestFileName"+latestFileName);
				
				System.out.println("Inside html generator ResultPath/Screenshot/tcid"+ResultPath+"Screenshot/"+tcid);
				//bw.write(content);			
				//bw.newLine();
				bw.close();
				
		} 
		 
		 
		catch (IOException e) 
		 {
			 e.printStackTrace();
		 }
						
		}
	public static void writeHeaderToHTMLLog(String tcid,String tcname, String ResultPath)


	{      
		
		
		
		String FilePath=System.getProperty("user.dir")+"/"+ResultPath+"HTMLtLog.txt";
		
		//System.out.println("File Path is "+FilePath);
		
		
		 try { 
				File file = new File(FilePath);

				// if file doesn't exists, then create it
				if (!file.exists()) 
				{
					file.createNewFile();
				}

				FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
				BufferedWriter bw = new BufferedWriter(fw);
				
				//String content=tcid+" :::::  "+Comment+":::"+result;
				//String screenshotcontent=Comment+" : "+result;
				
				bw.write("<tr>");
				bw.write("<td class = 'subheading3' colspan = 7 align ='center'>");
				bw.write(tcname);
				bw.write("</td>");
				bw.write("</tr>");
				bw.write("</tr>");
				bw.write("</tr>");
				bw.write("<tr>");
				//bw.write(content);			
				//bw.newLine();
				bw.close();
				
		} 
		 
		 
		catch (IOException e) 
		 {
			 e.printStackTrace();
		 }
						
		}
	public static void writeCloseRowToHTMLLog(String tcid,String ResultPath)


	{      
		
		
		
		String FilePath=ResultPath+"HTMLtLog.txt";
		
		//System.out.println("File Path is "+FilePath);
		
		
		 try { 
				File file = new File(FilePath);

				// if file doesn't exists, then create it
				if (!file.exists()) 
				{
					file.createNewFile();
				}

				FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
				BufferedWriter bw = new BufferedWriter(fw);
				
				String content="</tr>";
				bw.write(content);	
				//bw.newLine();
				bw.close();
				
		} 
		 
		 
		catch (IOException e) 
		 {
			 e.printStackTrace();
		 }
						
		}

	public static void writeToLog(String tcid,String Comment,String result,String ResultPath,XWPFRun xwpfRun)
		
	
		  {      
			
			
			
			String FilePath=ResultPath+"TestLog.txt";
			
			//System.out.println("File Path is "+FilePath);
			
			
			 try { 
					File file = new File(FilePath);
		 
					// if file doesn't exists, then create it
					if (!file.exists()) 
					{
						file.createNewFile();
					}
		 
					FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
					BufferedWriter bw = new BufferedWriter(fw);
					
					String content=tcid+" :::::  "+Comment+":::"+result;
					String screenshotcontent=Comment+" : "+result;
					
					int format=XWPFDocument.PICTURE_TYPE_PNG;
					String latestFileName=Reporting_Utilities.lastFileNameModified(ResultPath+"Screenshot/"+tcid);
					String imgFile=ResultPath+"Screenshot/"+tcid+"/"+latestFileName;
					System.out.println("imgFile "+imgFile);
					
		            try {
		            	xwpfRun.setText(screenshotcontent);
		            	xwpfRun.addBreak();
		            	
						//xwpfRun.addPicture (new FileInputStream(imgFile), format, imgFile, Units.toEMU(475), Units.toEMU(280));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					bw.write(content);			
					bw.newLine();
					bw.close();
					
			} 
			 
			 
			catch (IOException e) 
			 {
				 e.printStackTrace();
			 }
							
			}
	

	public static void writeStepToHTMLLog(String tcid, String stepno,String StepDescription, String stepresult, String result, String ResultPath)


	{      
		
		
		
		String FilePath=System.getProperty("user.dir")+"/"+ResultPath+"HTMLtLog.txt";
		
		//System.out.println("File Path is "+FilePath);
		
		
		 try { 
				File file = new File(FilePath);

				// if file doesn't exists, then create it
				if (!file.exists()) 
				{
					file.createNewFile();
				}

				FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
				BufferedWriter bw = new BufferedWriter(fw);
				String dattim=getCurrentDate.getISTTimeHTML();
				//String latestFileName=Reporting_Utilities.lastFileNameModified(ResultPath+"Screenshot/"+tcid);
				//String content=tcid+" :::::  "+Comment+":::"+result;
				//String screenshotcontent=Comment+" : "+result;
				bw.write("<tr>");
				
				bw.write("<td class='tdborder_1'>"+stepno+"</td>");
				bw.write("<td class='tdborder_1'>"+StepDescription+"</td>");
				bw.write("<td class='tdborder_1'>"+stepresult+"</td>");
				bw.write("<td class='tdborder_1_"+result+"'>"+result+"</td>");
				bw.write("<td class='tdborder_1'>"+dattim+"</td>");
				//bw.write("<td class='tdborder_1'><a href='"+ResultPath+"Screenshot/"+tcid+"/"+latestFileName+"'>Screenshot</a></td>");
				
				String absrespath=new File(ResultPath+"Screenshot/"+tcid).getAbsolutePath();
				//System.out.println("absrespath "+absrespath);
				bw.write("<td class='tdborder_1'><a href='"+absrespath+"'>Evidence Folder</a></td>");
				
				
				bw.write("</tr>");
				//bw.write("<tr>");
				
				//System.out.println("Inside html generator latestFileName"+latestFileName);
				
				//System.out.println("Inside html generator ResultPath/Screenshot/tcid"+ResultPath+"Screenshot/"+tcid);
				//bw.write(content);			
				//bw.newLine();
				bw.close();
				
		} 
		 
		 
		catch (IOException e) 
		 {
			 e.printStackTrace();
		 }
						
		}
	public static String createResultPath(){
		
		String ResultPath="/Results/Result_"+getCurrentDate.getISTTimeHTMLforfolder();
		File dir = new File(System.getProperty("user.dir")+ResultPath);
		dir.mkdir();
		ResultPath=ResultPath+"/";
		System.setProperty("resultpath", ResultPath);
		return ResultPath;
	}
	public static String createResultPath(String customizedName){
		
		String ResultPath="/Results/"+customizedName+"_Result_"+getCurrentDate.getISTTimeHTMLforfolder();
		File dir = new File(System.getProperty("user.dir")+ResultPath);
		dir.mkdir();
		ResultPath=ResultPath+"/";
		System.setProperty("resultpath", ResultPath);
		return ResultPath;
	}
}
