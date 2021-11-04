package testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Leadsecicution extends keyswords {
	
	static ArrayList data;
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet s;
	
	@Test
	public void testing() throws Exception {
		
		keyswords key = new keyswords();
		data = new ArrayList();
		f = new FileInputStream("F:\\zohaleads.xlsx");
		w = new XSSFWorkbook(f);
		s = w.getSheet("first");
		
		Iterator<Row> rowitr = s.iterator();
		while(rowitr.hasNext()) {
		Row rowall = 	rowitr.next();
			Iterator<Cell> cellitr = rowall.cellIterator();
			while(cellitr.hasNext()) {
				Cell call1 = cellitr.next();
				
		if(call1.getCellTypeEnum().equals(CellType.STRING)) {
			data.add(call1.getStringCellValue());
		}
		if(call1.getCellTypeEnum().equals(CellType.NUMERIC)) {
			data.add(call1.getNumericCellValue());
		}
		if(call1.getCellTypeEnum().equals(CellType.BOOLEAN)) {
			data.add(call1.getBooleanCellValue());
		}
			
			}
	
		}
		
		for(int i=0;i<data.size();i++) {
			if(data.get(i).equals("openbrowser")) {
			String keywords = (String)data.get(i);
			String date = (String)data.get(i+1);
			String objectname = (String)data.get(i+2);
			String runmode = (String)data.get(i+3);
			System.out.println(keywords+""+date+""+objectname+""+runmode);			
			key.openbrowser();
			}

			if(data.get(i).equals("navigate")) {
				String keywords = (String)data.get(i);
				String date = (String)data.get(i+1);
				String objectname = (String)data.get(i+2);
				String runmode = (String)data.get(i+3);
				System.out.println(keywords+""+date+""+objectname+""+runmode);			
				key.navigate(date);
				}
			if(data.get(i).equals("click")) {
				String keywords = (String)data.get(i);
				String date = (String)data.get(i+1);
				String objectname = (String)data.get(i+2);
				String runmode = (String)data.get(i+3);
				System.out.println(keywords+""+date+""+objectname+""+runmode);			
				key.click(objectname);
				}
			
			if(data.get(i).equals("input")) {
				String keywords = (String)data.get(i);
				String date = (String)data.get(i+1);
				String objectname = (String)data.get(i+2);
				String runmode = (String)data.get(i+3);
				System.out.println(keywords+""+date+""+objectname+""+runmode);			
				key.input(objectname,date);
				}
			
			if(data.get(i).equals("refresh")) {
				String keywords = (String)data.get(i);
				String date = (String)data.get(i+1);
				String objectname = (String)data.get(i+2);
				String runmode = (String)data.get(i+3);
				System.out.println(keywords+""+date+""+objectname+""+runmode);			
				key.refresh();
				}
			
		}
		
		
		
		
	}
	
	

}
