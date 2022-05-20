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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelFileReader {


    private final List<String> workoutName = new ArrayList<>();
    private final List<String> workoutSets = new ArrayList<>();
    private final List<String> workoutReps = new ArrayList<>();
    private final List<String> workoutLink = new ArrayList<>();
    private final List<String> workoutPhoto = new ArrayList<>();
    private final List<List<String>> workoutDataList = new ArrayList<>();

    private final List<String> foodName = new ArrayList<>();
    private final List<String> foodQuantity = new ArrayList<>();
    private final List<String> foodCal = new ArrayList<>();
    private final List<String> foodProtein = new ArrayList<>();
    private final List<String> foodCarbs = new ArrayList<>();
    private final List<String> foodFats = new ArrayList<>();
    private final List<String> foodFibers = new ArrayList<>();

    private final List<List<String>> foodDataList = new ArrayList<>();

    private final String fileName;
    private final Context context;

    public ExcelFileReader(String fileName, Context context) {
        this.fileName = fileName;
        this.context = context;
    }

    @SuppressLint("StaticFieldLeak")
    static ExcelFileReader INSTANCE;

    public static ExcelFileReader readerClient(String fileName, Context context){
        if (INSTANCE != null){
            return INSTANCE;
        }
        INSTANCE = new ExcelFileReader(fileName, context);
        return INSTANCE;
    }

    public List<List<String>> getWorkoutDataFromExcel(){
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
                        if(columnNumber == 0){
                            workoutName.add(cell.toString());
                        }else if (columnNumber == 1) {
                            workoutSets.add(cell.toString());
                        } else if (columnNumber == 2) {
                            workoutReps.add(cell.toString());
                        }else if (columnNumber == 3){
                            workoutLink.add(cell.toString());
                        }else if(columnNumber == 4){
                            workoutPhoto.add(cell.toString());
                        }
                        columnNumber++;
                    }
                }
                rowNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        workoutDataList.add(workoutName);
        workoutDataList.add(workoutSets);
        workoutDataList.add(workoutReps);
        workoutDataList.add(workoutLink);
        workoutDataList.add(workoutPhoto);

        return workoutDataList;
    }

    public List<List<String>> getFoodDataFromExcel(){
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
                        if(columnNumber == 0){
                            foodName.add(cell.toString());
                        }else if (columnNumber == 1) {
                            foodQuantity.add(cell.toString());
                        } else if (columnNumber == 2) {
                            foodCal.add(cell.toString());
                        }else if (columnNumber == 3){
                            foodProtein.add(cell.toString());
                        }else if(columnNumber == 4){
                            foodCarbs.add(cell.toString());
                        }else if(columnNumber == 5){
                            foodFats.add(cell.toString());
                        }else if(columnNumber == 6){
                            foodFibers.add(cell.toString());
                        }
                        columnNumber++;
                    }
                }
                rowNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        foodDataList.add(foodName);
        foodDataList.add(foodQuantity);
        foodDataList.add(foodCal);
        foodDataList.add(foodProtein);
        foodDataList.add(foodCarbs);
        foodDataList.add(foodFats);
        foodDataList.add(foodFibers);

        return foodDataList;
    }
}