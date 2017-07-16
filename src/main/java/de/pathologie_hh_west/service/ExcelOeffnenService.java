package de.pathologie_hh_west.service;

/**
 * Created by VaniR on 15.07.2017.
 */
public class ExcelOeffnenService {
    public ExcelOeffnenService() {
    }

    public ExcelFile openExcelFile(String dateiPfad) {
        return new ExcelFile(dateiPfad);
    }

}
