package Base;

import java.util.List;

import utils.ExcelUtility;

public class ReadTestData {

	public void redData() {
		
		ExcelUtility excelUtility= new ExcelUtility();
		

		String sheetName="Test";
        String excelPath="D:\\Model Code Test\\MiY-ModelCodeVerify\\TestData.xlsx";
        
        excelUtility.fileRead(excelPath);
        
        System.out.println(excelUtility.getRowCount(sheetName));
        System.out.println(excelUtility.getColumnCount(sheetName));
        System.out.println(excelUtility.getColumnName(sheetName));
        
        int rowCnt=excelUtility.getRowCount(sheetName);
        int columnCount=excelUtility.getColumnCount(sheetName);
        List<String> names=excelUtility.getColumnName(sheetName);
        
        for(int r=1;r<=rowCnt;r++){
            for(int i=0;i<columnCount;i++){
                String str=names.get(i);
                if(str.equalsIgnoreCase("Status")||str.equalsIgnoreCase("Comments")||str.equalsIgnoreCase("Vehicle Code")){
                	System.out.println(str);
                }
                else{
                	System.out.println(str);
                }
                
            }

	}

	}
}
