package com.fit.fast.models;

import android.annotation.SuppressLint;
import android.content.Context;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class ExcelFileReader {


    private String workoutName = "";
    private String workoutSets = "";
    private String workoutLink = "";

    private String fileName;
    private Context context;

    public ExcelFileReader(String fileName, Context context) {
        this.fileName = fileName;
        this.context = context;
    }

    @SuppressLint("StaticFieldLeak")
    public static ExcelFileReader INSTANCE;

    public static ExcelFileReader readerClient(String fileName, Context context){
        if (INSTANCE != null){
            return INSTANCE;
        }
        INSTANCE.fileName = fileName;
        INSTANCE.context = context;
        return INSTANCE = new ExcelFileReader(fileName, context);
    }

    public void getDataFromExcel(){
        try {
            InputStream stream = context.getAssets().open(fileName);
            POIFSFileSystem poifsFileSystem = new POIFSFileSystem(stream);
            HSSFWorkbook workbook = new HSSFWorkbook(poifsFileSystem);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.rowIterator();
            int rowNumber = 0;
            while (rowIterator.hasNext()){
                HSSFRow row = (HSSFRow) rowIterator.next();
                if (rowNumber != 0){
                    Iterator<Cell> cellIterator = row.cellIterator();
                    int columnNumber = 0;
                    while(cellIterator.hasNext()){
                        HSSFCell cell = (HSSFCell) cellIterator.next();
                        if(columnNumber != 0){
                            workoutName = cell.toString();
                        }else if (columnNumber == 1) {
                            workoutSets = cell.toString();
                        } else if (columnNumber == 2) {
                            workoutLink = cell.toString();
                        }
                        columnNumber++;
                    }
                }
                rowNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
