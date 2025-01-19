//package utils;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//public class ExcelUtils {
//
//    private static FileInputStream fileInput;
//    private static XSSFWorkbook workbook;
//    private static XSSFSheet sheet;
//    private static String filePath;
//
//    /**
//     * Reads data from a specific cell in an Excel sheet.
//     * The Excel usually contains rowHeading in n+1 row, as 1st row shows scenario description.
//     *
//     * @param sheetName     The name of the sheet in the workbook.
//     * @param rowHeading    The heading in the first column to identify the target row.
//     * @param columnHeading The heading in the first row to identify the target column.
//     * @return The data in the specified cell as a string, or null if the cell is empty.
//     * @throws IOException If there is an error reading the file.
//     */
//
//    public String readCell(String sheetName, String rowHeading, String columnHeading) throws IOException {
//        //Getting file and storing in workbook
//        try {
//        filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\ExcelData\\AutomationExercise.xlsx";
//        fileInput = new FileInputStream(filePath);
//        workbook = new XSSFWorkbook(fileInput);
//        }
//
//        catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//        //Getting the sheet name required to get values
//        sheet = workbook.getSheet(sheetName);
//        int columnIndex = -1; // Variable to store the index of the target column.
//        int rowIndex = -1; // Variable to store the index of the target row.
//
//        // Get the first row (header row) to identify the column index for the given
//        // column heading.
//        Row headerRow = sheet.getRow(0);
//        for (Cell cell : headerRow) {
//            if (cell.getStringCellValue().equalsIgnoreCase(columnHeading)) {
//                columnIndex = cell.getColumnIndex(); // Found the target column.
//                break;
//            }
//        }
//
//        // Iterate through the rows to find the row index for the given row heading.
//        for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Start from the second row (index 1).
//            Row row = sheet.getRow(i);
//            if (row != null) {
//                Cell cell = row.getCell(1); // Assuming the row headings are in the first column.
//                if (cell != null && cell.getStringCellValue().equalsIgnoreCase(rowHeading)) {
//                    rowIndex = i; // Found the target row.
//                    break;
//                }
//            }
//        }
//
//        // If either the column or row index is not found, throw an exception.
//        if (columnIndex == -1 || rowIndex == -1) {
//            throw new IllegalArgumentException("Either column heading or row heading not found in the sheet");
//        }
//
//        // Get the row from where data needs to be read.
//        Row dataRow = sheet.getRow(rowIndex);
//
//        // Get the cell value from the target row and column.
//        Cell dataCell = dataRow.getCell(columnIndex);
//        String cellValue = (dataCell != null) ? dataCell.getStringCellValue() : null;
//
//        // Close the input stream and workbook.
//        fileInput.close();
//        workbook.close();
//
//        // Return the cell value.
//        return cellValue;
//    }
//
//    /**
//     * Writes data to a specific cell in an Excel sheet.
//     * The Excel usually contains rowHeading in n+1 row, as 1st row shows scenario description
//     *
//     * @param sheetName     The name of the sheet in the workbook.
//     * @param rowHeading    The heading in the first column to identify the target row.
//     * @param columnHeading The heading in the first row to identify the target column.
//     * @param data          The data to write into the cell.
//     * @throws IOException If there is an error reading or writing the file.
//     */
//    public void writeCell(String sheetName, String rowHeading, String columnHeading, String data)
//            throws IOException {
//
//        try {
//            filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\ExcelData\\AutomationExercise.xlsx";
//            fileInput = new FileInputStream(filePath);
//            workbook = new XSSFWorkbook(fileInput);
//        }
//
//        catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//        //Getting the sheet name required to get values
//        sheet = workbook.getSheet(sheetName);
//        int columnIndex = -1; // Variable to store the index of the target column.
//        int rowIndex = -1; // Variable to store the index of the target row.
//
//        // Get the first row (header row) to identify the column index for the given
//        // column heading.
//        Row headerRow = sheet.getRow(0);
//        for (Cell cell : headerRow) {
//            if (cell.getStringCellValue().equalsIgnoreCase(columnHeading)) {
//                columnIndex = cell.getColumnIndex(); // Found the target column.
//                break;
//            }
//        }
//
//        // Iterate through the rows to find the row index for the given row heading.
//        for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Start from the second row (index 1).
//            Row row = sheet.getRow(i);
//            if (row != null) {
//                Cell cell = row.getCell(1); // Assuming the row headings are in the first column.
//                if (cell != null && cell.getStringCellValue().equalsIgnoreCase(rowHeading)) {
//                    rowIndex = i; // Found the target row.
//                    break;
//                }
//            }
//        }
//
//        // If either the column or row index is not found, throw an exception.
//        if (columnIndex == -1 || rowIndex == -1) {
//            throw new IllegalArgumentException("Either column heading or row heading not found in the sheet");
//        }
//
//        // Get the row where data needs to be written, or create a new one if it doesn't
//        // exist.
//        Row dataRow = sheet.getRow(rowIndex);
//        if (dataRow == null) {
//            dataRow = sheet.createRow(rowIndex);
//        }
//
//        // Create or get the cell in the target row and column, and set its value.
//        Cell dataCell = dataRow.createCell(columnIndex);
//        dataCell.setCellValue(data);
//
//        // Close the input stream as we're done reading the file.
//        fileInput.close();
//
//        // Write the updated workbook back to the file.
//        FileOutputStream fos = new FileOutputStream(filePath);
//        workbook.write(fos);
//
//        // Close the output stream and workbook.
//        fos.close();
//        workbook.close();
//    }
//}
//
//

//-------------------------

//key changes made to ExcelUtils class to support parallel execution and avoid the Stream Closed error:
//
//Synchronized Methods:
//
//Both readCell and writeCell methods are now synchronized to ensure thread safety. This prevents multiple threads from accessing the file simultaneously, which can cause the Stream Closed error.
//Try-with-Resources:
//
//Used try-with-resources for FileInputStream, XSSFWorkbook, and FileOutputStream to ensure that resources are properly closed after use. This helps in managing file streams more effectively and avoids resource leaks.
//Removed Static Fields:
//
//Removed static fields for FileInputStream, XSSFWorkbook, and XSSFSheet to ensure that each method call gets a fresh instance, preventing conflicts between threads.

//---------------------
package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {

    private static final String FILE_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\ExcelData\\AutomationExercise.xlsx";

    /**
     * Reads data from a specific cell in an Excel sheet.
     * The Excel usually contains rowHeading in n+1 row, as 1st row shows scenario description.
     *
     * @param sheetName     The name of the sheet in the workbook.
     * @param rowHeading    The heading in the first column to identify the target row.
     * @param columnHeading The heading in the first row to identify the target column.
     * @return The data in the specified cell as a string, or null if the cell is empty.
     * @throws IOException If there is an error reading the file.
     */
    public synchronized String readCell(String sheetName, String rowHeading, String columnHeading) throws IOException {
        try (FileInputStream fileInput = new FileInputStream(FILE_PATH);
             XSSFWorkbook workbook = new XSSFWorkbook(fileInput)) {

            XSSFSheet sheet = workbook.getSheet(sheetName);
            int columnIndex = -1; // Variable to store the index of the target column.
            int rowIndex = -1; // Variable to store the index of the target row.

            // Get the first row (header row) to identify the column index for the given column heading.
            Row headerRow = sheet.getRow(0);
            for (Cell cell : headerRow) {
                if (cell.getStringCellValue().equalsIgnoreCase(columnHeading)) {
                    columnIndex = cell.getColumnIndex(); // Found the target column.
                    break;
                }
            }

            // Iterate through the rows to find the row index for the given row heading.
            for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Start from the second row (index 1).
                Row row = sheet.getRow(i);
                if (row != null) {
                    Cell cell = row.getCell(1); // Assuming the row headings are in the first column.
                    if (cell != null && cell.getStringCellValue().equalsIgnoreCase(rowHeading)) {
                        rowIndex = i; // Found the target row.
                        break;
                    }
                }
            }

            // If either the column or row index is not found, throw an exception.
            if (columnIndex == -1 || rowIndex == -1) {
                throw new IllegalArgumentException("Either column heading or row heading not found in the sheet");
            }

            // Get the row from where data needs to be read.
            Row dataRow = sheet.getRow(rowIndex);

            // Get the cell value from the target row and column.
            Cell dataCell = dataRow.getCell(columnIndex);
            return (dataCell != null) ? dataCell.getStringCellValue() : null;
        }
    }

    /**
     * Writes data to a specific cell in an Excel sheet.
     * The Excel usually contains rowHeading in n+1 row, as 1st row shows scenario description.
     *
     * @param sheetName     The name of the sheet in the workbook.
     * @param rowHeading    The heading in the first column to identify the target row.
     * @param columnHeading The heading in the first row to identify the target column.
     * @param data          The data to write into the cell.
     * @throws IOException If there is an error reading or writing the file.
     */
    public synchronized void writeCell(String sheetName, String rowHeading, String columnHeading, String data) throws IOException {
        try (FileInputStream fileInput = new FileInputStream(FILE_PATH);
             XSSFWorkbook workbook = new XSSFWorkbook(fileInput)) {

            XSSFSheet sheet = workbook.getSheet(sheetName);
            int columnIndex = -1; // Variable to store the index of the target column.
            int rowIndex = -1; // Variable to store the index of the target row.

            // Get the first row (header row) to identify the column index for the given column heading.
            Row headerRow = sheet.getRow(0);
            for (Cell cell : headerRow) {
                if (cell.getStringCellValue().equalsIgnoreCase(columnHeading)) {
                    columnIndex = cell.getColumnIndex(); // Found the target column.
                    break;
                }
            }

            // Iterate through the rows to find the row index for the given row heading.
            for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Start from the second row (index 1).
                Row row = sheet.getRow(i);
                if (row != null) {
                    Cell cell = row.getCell(1); // Assuming the row headings are in the first column.
                    if (cell != null && cell.getStringCellValue().equalsIgnoreCase(rowHeading)) {
                        rowIndex = i; // Found the target row.
                        break;
                    }
                }
            }

            // If either the column or row index is not found, throw an exception.
            if (columnIndex == -1 || rowIndex == -1) {
                throw new IllegalArgumentException("Either column heading or row heading not found in the sheet");
            }

            // Get the row where data needs to be written, or create a new one if it doesn't exist.
            Row dataRow = sheet.getRow(rowIndex);
            if (dataRow == null) {
                dataRow = sheet.createRow(rowIndex);
            }

            // Create or get the cell in the target row and column, and set its value.
            Cell dataCell = dataRow.createCell(columnIndex);
            dataCell.setCellValue(data);

            // Write the updated workbook back to the file.
            try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
                workbook.write(fos);
            }
        }
    }
}
