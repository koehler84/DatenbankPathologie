package de.pathologie_hh_west.service;

import org.springframework.stereotype.Service;

/**
 * Created by VaniR on 15.07.2017.
 * Project: path_db
 */
@Service
public class ExcelService {
    
    public ExcelService() {
    }

    public ExcelFile openExcelFile(String dateiPfad) {
        return new ExcelFile(dateiPfad);
    }
}
