package de.pathologie_hh_west.service;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;


/**
 * Created by VaniR on 11.07.2017.
 */
public class ExcelOeffnenService {
    private String dateiPfad;
    private XSSFWorkbook excelTabelle;
    private int anzahlArbeitsblaetter;
    private HashMap<Integer, String> namenArbeitsblaetter;

    public ExcelOeffnenService(String dateiPfad) throws IOException {
        FileInputStream fis = new FileInputStream(dateiPfad);
        this.namenArbeitsblaetter = new HashMap<>();
        try {
            this.excelTabelle = new XSSFWorkbook(fis);
            this.anzahlArbeitsblaetter = excelTabelle.getNumberOfSheets();
            for (int i = 0; i < anzahlArbeitsblaetter; i++) {
                this.namenArbeitsblaetter.put(i, excelTabelle.getSheetName(i));
            }

        } finally {
            fis.close();
        }
    }

    public HashMap<Integer, String> getUeberschriftenVonExcel(Integer indexArbeitsblatt) {
        HashMap<Integer, String> ueberschriften = new HashMap<>();
        XSSFSheet arbeitsblatt = excelTabelle.getSheetAt(indexArbeitsblatt);
        XSSFRow zeile = arbeitsblatt.getRow(0);
        int spaltenAnzahl = zeile.getPhysicalNumberOfCells();
        for (int i = 0; i < spaltenAnzahl; i++) {
            XSSFCell zelle = zeile.getCell(i);
            if (zelle != null) {
                switch (zelle.getCellType()) {

                    case XSSFCell.CELL_TYPE_FORMULA:
                        ueberschriften.put(i, zeile.getCell(i).getCellFormula());
                        break;

                    case XSSFCell.CELL_TYPE_NUMERIC:
                        ueberschriften.put(i, zeile.getCell(i).getNumericCellValue() + "");
                        break;

                    case XSSFCell.CELL_TYPE_STRING:
                        ueberschriften.put(i, zeile.getCell(i).getStringCellValue());
                        break;

                    case XSSFCell.CELL_TYPE_BLANK:
                        ueberschriften.put(i, "");
                        break;

                    case XSSFCell.CELL_TYPE_BOOLEAN:
                        ueberschriften.put(i, zeile.getCell(i).getBooleanCellValue() + "");
                        break;

                    case XSSFCell.CELL_TYPE_ERROR:
                        ueberschriften.put(i, zeile.getCell(i).getErrorCellValue() + "");
                        break;

                    default:
                        ueberschriften.put(i, "<FEHLER IM PROGRAMM>");
                }
            }


        }
        return ueberschriften;


    }

}
