package Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

public class PoiWriteExcelFile {
	
	public static void merge(String cell1, String cell2, HSSFSheet worksheet){
	    CellReference start = new CellReference(cell1);
	    CellReference end = new CellReference(cell2);

	    CellRangeAddress address = new CellRangeAddress(start.getRow(),
	            end.getRow(), start.getCol(), end.getCol());
	    
	    worksheet.addMergedRegion(address);
	}

	public static void main(String[] args) {
		try {
			FileOutputStream fileOut = new FileOutputStream("poi-test.xls");
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet worksheet = workbook.createSheet("POI Worksheet");

			// index from 0,0... cell A1 is cell(0,0)
			HSSFRow row1 = worksheet.createRow((short) 0);

			HSSFCell cellA1 = row1.createCell((short) 0);
			cellA1.setCellValue("SKU\nSEQ");
			

			HSSFCell cellB1 = row1.createCell((short) 1);
			cellB1.setCellValue("SKU Name");
			

			HSSFCell cellC1 = row1.createCell((short) 2);
			cellC1.setCellValue(" Unit & Category");
			
			HSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			cellC1.setCellStyle(cellStyle);
			
			HSSFRow row2 = worksheet.createRow((short) 1);

			HSSFCell cellC2 = row2.createCell((short) 2);
			cellC2.setCellValue(" Unit1 ");
			
			HSSFCell cellD2 = row2.createCell((short) 3);
			cellD2.setCellValue(" Unit2 ");
			
			HSSFCell cellF2 = row2.createCell((short) 4);
			cellF2.setCellValue(" Cate3 ");
			
			HSSFCell cellG2 = row2.createCell((short) 5);
			cellG2.setCellValue(" Cate4 ");
			
			HSSFCell cellH2 = row2.createCell((short) 6);
			cellH2.setCellValue(" Cate5 ");
			
			
		   merge("A1", "A2", worksheet);
		   merge("B1", "B2", worksheet);
		   merge("C1", "G1", worksheet);
		   merge("H1", "H2", worksheet);
			

			

			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}