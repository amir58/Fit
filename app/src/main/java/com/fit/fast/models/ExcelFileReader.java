package com.fit.fast.models;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelFileReader {


    private final List<Workout> sports = new ArrayList<>();
//    private final List<String> workoutName = new ArrayList<>();
//    private final List<String> workoutSets = new ArrayList<>();
//    private final List<String> workoutReps = new ArrayList<>();
//    private final List<String> workoutLink = new ArrayList<>();
//    private final List<String> workoutPhoto = new ArrayList<>();
//    private final List<List<String>> workoutDataList = new ArrayList<>();

    private final List<Food> foods = new ArrayList<>();
//    private final List<String> foodName = new ArrayList<>();
//    private final List<String> foodQuantity = new ArrayList<>();
//    private final List<String> foodCal = new ArrayList<>();
//    private final List<String> foodProtein = new ArrayList<>();
//    private final List<String> foodCarbs = new ArrayList<>();
//    private final List<String> foodFats = new ArrayList<>();
//    private final List<String> foodFibers = new ArrayList<>();

//    private final List<List<String>> foodDataList = new ArrayList<>();

    private final String fileName;
    private final Context context;

    public ExcelFileReader(String fileName, Context context) {
        this.fileName = fileName;
        this.context = context;
    }

    @SuppressLint("StaticFieldLeak")
    static ExcelFileReader INSTANCE;

    public static ExcelFileReader readerClient(String fileName, Context context) {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        INSTANCE = new ExcelFileReader(fileName, context);
        return INSTANCE;
    }

    public List<Workout> getWorkoutDataFromExcel() {
        try {
            InputStream stream = context.getAssets().open(fileName);
            POIFSFileSystem poifsFileSystem = new POIFSFileSystem(stream);
            HSSFWorkbook workbook = new HSSFWorkbook(poifsFileSystem);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.rowIterator();
            int rowNumber = 0;
            while (rowIterator.hasNext()) {
                HSSFRow row = (HSSFRow) rowIterator.next();
                if (rowNumber != 0) {
                    Iterator<Cell> cellIterator = row.cellIterator();
                    int columnNumber = 0;

                    Workout workout = new Workout();
                    while (cellIterator.hasNext()) {
                        HSSFCell cell = (HSSFCell) cellIterator.next();
                        if (columnNumber == 0) {
                            workout.setName(cell.toString());
                        } else if (columnNumber == 1) {
                            workout.setSets(cell.toString());
                        } else if (columnNumber == 2) {
                            workout.setReps(cell.toString());
                        } else if (columnNumber == 3) {
                            workout.setLink(cell.toString());
                        } else if (columnNumber == 4) {
                            workout.setPhoto(cell.toString());
                        }
                        columnNumber++;
                    }
                    sports.add(workout);
                }
                rowNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sports;
    }

    public List<Food> getFoodDataFromExcel(String fileName) {
        try {
            InputStream stream = context.getAssets().open("food_data.xls");
            POIFSFileSystem poifsFileSystem = new POIFSFileSystem(stream);
            HSSFWorkbook workbook = new HSSFWorkbook(poifsFileSystem);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.rowIterator();
            int rowNumber = 0;
            while (rowIterator.hasNext()) {

                HSSFRow row = (HSSFRow) rowIterator.next();
                if (rowNumber != 0) {
                    Iterator<Cell> cellIterator = row.cellIterator();
                    int columnNumber = 0;

                    Food food = new Food();
                    while (cellIterator.hasNext()) {
                        HSSFCell cell = (HSSFCell) cellIterator.next();
                        if (columnNumber == 0) {
                            food.setName(cell.toString());
                        } else if (columnNumber == 1) {
                            food.setQuantity(cell.toString());
                        } else if (columnNumber == 2) {
                            food.setCalories(cell.toString());
                        } else if (columnNumber == 3) {
                            food.setProtein(cell.toString());
                        } else if (columnNumber == 4) {
                            food.setCarb(cell.toString());
                        } else if (columnNumber == 5) {
                            food.setFats(cell.toString());
                        } else if (columnNumber == 6) {
                            food.setFibers(cell.toString());
                        }
                        columnNumber++;
                    }
                    Log.i("READER => ", "getFoodDataFromExcel: " + food.toString());
                    foods.add(food);
                }

                rowNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.i("READER => ", "getFoodDataFromExcel: " + foods.size());
        return foods;
    }
}