package de.pathologie_hh_west.service;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by VaniR on 15.07.2017.
 */
public class ExcelOeffnenService {
    public ExcelOeffnenService() {
    }

    public ExcelFile openExcelFile(String dateiPfad) throws IOException {
        try (FileInputStream fis = new FileInputStream(dateiPfad)) {
            return new ExcelFile(fis);
        }
    }

}
