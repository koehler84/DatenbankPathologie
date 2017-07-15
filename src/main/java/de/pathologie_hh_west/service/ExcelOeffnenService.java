package de.pathologie_hh_west.service;


import de.pathologie_hh_west.model.Patient;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.HashMap;


/**
 * Created by VaniR on 11.07.2017.
 */
public class ExcelOeffnenService {
    private XSSFWorkbook excelTabelle;
    private HashMap<Integer, String> namenArbeitsblaetter;
    private int anzahlArbeitsblaetter;
    //existieren erst nach Auswahl des zu bearbeitenden Arbeitsblattes
    private XSSFSheet arbeitsblatt;
    private Integer maximaleAnzahlZeilen;

    public ExcelOeffnenService(String dateiPfad) throws IOException {
        this.namenArbeitsblaetter = new HashMap<>();
        try (FileInputStream fis = new FileInputStream(dateiPfad)) {
            this.excelTabelle = new XSSFWorkbook(fis);
            this.anzahlArbeitsblaetter = excelTabelle.getNumberOfSheets();
            for (int i = 0; i < anzahlArbeitsblaetter; i++) {
                this.namenArbeitsblaetter.put(i, excelTabelle.getSheetName(i));
            }
        }
    }

    public Integer getMaximaleAnzahlZeilen() {
        return maximaleAnzahlZeilen;
    }

    private String getStringZellenInhalt(XSSFCell zelle) {
        String zellenInhalt = null;
        if (zelle != null) {
            switch (zelle.getCellType()) {

                case XSSFCell.CELL_TYPE_FORMULA:
                    zellenInhalt = zelle.getCellFormula();
                    break;

                case XSSFCell.CELL_TYPE_NUMERIC:
                    zellenInhalt = zelle.getNumericCellValue() + "";
                    break;

                case XSSFCell.CELL_TYPE_STRING:
                    zellenInhalt = zelle.getStringCellValue();
                    break;

                case XSSFCell.CELL_TYPE_BLANK:
                    zellenInhalt = "";
                    break;

                case XSSFCell.CELL_TYPE_BOOLEAN:
                    zellenInhalt = zelle.getBooleanCellValue() + "";
                    break;

                case XSSFCell.CELL_TYPE_ERROR:
                    zellenInhalt = zelle.getErrorCellValue() + "";
                    break;

                default:
                    zellenInhalt = "<FEHLER IM PROGRAMM>";
            }
        }
        return zellenInhalt;
    }

    public HashMap<Integer, String> getUeberschriftenVonExcel(Integer indexArbeitsblatt) {
        this.arbeitsblatt = excelTabelle.getSheetAt(indexArbeitsblatt);
        maximaleAnzahlZeilen = arbeitsblatt.getPhysicalNumberOfRows();
        HashMap<Integer, String> ueberschriften = new HashMap<>();
        XSSFRow zeile = arbeitsblatt.getRow(0);
        int spaltenAnzahl = zeile.getPhysicalNumberOfCells();
        for (int i = 0; i < spaltenAnzahl; i++) {
            XSSFCell zelle = zeile.getCell(i);
            ueberschriften.put(i, getStringZellenInhalt(zelle));
        }
        return ueberschriften;
    }

    public Patient patientenDatenAusExcelBefuellen(HashMap<Integer, PatientModelAttribute> excelIndexZuPatientenAttributZuordnung, Integer aktuelleZeile) {


        XSSFRow zeile = arbeitsblatt.getRow(aktuelleZeile);
        Patient patient = new Patient();
        for (Integer zellenIndex : excelIndexZuPatientenAttributZuordnung.keySet()) {
            XSSFCell zelle = zeile.getCell(zellenIndex);
            if (zelle != null) {
                switch (zelle.getCellType()) {

                    case XSSFCell.CELL_TYPE_FORMULA:
                        patient = new PatientAttributAuswahl(zelle.getCellFormula(), excelIndexZuPatientenAttributZuordnung.
                                get(zellenIndex), patient).getPatient();
                        break;
                    case XSSFCell.CELL_TYPE_NUMERIC:
                        if (DateUtil.isCellDateFormatted(zelle)) {
                            patient = new PatientAttributAuswahl(zelle.getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).
                                    toLocalDate(), excelIndexZuPatientenAttributZuordnung.get(zellenIndex), patient).getPatient();

                        } else {
                            new PatientAttributAuswahl(BigDecimal.valueOf(zelle.getNumericCellValue()), excelIndexZuPatientenAttributZuordnung.
                                    get(zellenIndex), patient).getPatient();
                        }
                        break;
                    case XSSFCell.CELL_TYPE_STRING:
                        patient = new PatientAttributAuswahl(zelle.getStringCellValue(), excelIndexZuPatientenAttributZuordnung.
                                get(zellenIndex), patient).getPatient();
                        break;
                    case XSSFCell.CELL_TYPE_BLANK:
                        patient = new PatientAttributAuswahl("", excelIndexZuPatientenAttributZuordnung.
                                get(zellenIndex), patient).getPatient();
                        break;
                    case XSSFCell.CELL_TYPE_BOOLEAN:
                        patient = new PatientAttributAuswahl(zelle.getBooleanCellValue() + "", excelIndexZuPatientenAttributZuordnung.
                                get(zellenIndex), patient).getPatient();
                        break;
                    case XSSFCell.CELL_TYPE_ERROR:
                        patient = new PatientAttributAuswahl(zelle.getErrorCellValue() + "", excelIndexZuPatientenAttributZuordnung.
                                get(zellenIndex), patient).getPatient();
                        break;

                    default:
                        patient = new PatientAttributAuswahl("<FEHLER IM PROGRAMM>", excelIndexZuPatientenAttributZuordnung.
                                get(zellenIndex), patient).getPatient();
                }
            }
        }
        return patient;
    }
    
    public HashMap<Integer, String> getNamenArbeitsblaetter() {
        return namenArbeitsblaetter;
    }
}
