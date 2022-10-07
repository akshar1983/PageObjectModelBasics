package com.akshar.utilities;

import java.lang.reflect.Method;
import java.util.Hashtable;
import org.testng.annotations.DataProvider;

import com.akshar.base.Page;


public class DataUtil extends Page


{
	
	
	@DataProvider(name="dp")
	public Object[][] getData(Method m)
	
	{
		String sheetName=m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		System.out.println("No of rows are "+rows);
		System.out.println("No of cols are "+cols);
		
		Object[][] data = new Object[rows-1][1];
		Hashtable<String, String> table = null;
		for (int rowNum=2;rowNum <= rows; rowNum++)
			
			
		{
			
			table = new Hashtable<String,String>();
			for (int colNum=0;colNum< cols; colNum++)
				
			{
				//data[0][0]
				table.put(excel.getCellData(sheetName, colNum,1), excel.getCellData(sheetName, colNum,rowNum));
				data[rowNum-2][0] = table;
			   System.out.println(data[rowNum-2][0]);
			   System.out.println("Test Data");
			}
		}
		
		return data;
		
	}

}
