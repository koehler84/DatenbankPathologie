package de.pathologie_hh_west.service;

import de.pathologie_hh_west.model.Patient;
import de.pathologie_hh_west.support.ProgressListener;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataUpdateWrapper {
	
	private final ExcelService excelService;
	private final Set<ProgressListener> progressListeners;
	private final Set<IndexMapper> indexMappers;
	private final ExcelFile excelFile;
	private final Integer sheetIndex;
	
	@Autowired
	public DataUpdateWrapper(ExcelService excelService, Set<IndexMapper> indexMappers, final ExcelFile excelFile, final Integer sheetIndex) throws NullPointerException {
		if (excelService == null || indexMappers == null || excelFile == null || sheetIndex == null)
			throw new NullPointerException();
		
		this.excelService = excelService;
		this.progressListeners = new HashSet<>();
		this.indexMappers = indexMappers;
		this.excelFile = excelFile;
		this.sheetIndex = sheetIndex;
	}
	
	public DataUpdateWrapper registerListener(ProgressListener listener) {
		this.progressListeners.add(listener);
		return this;
	}
	
	public List<Patient> updateData() {
		final XSSFSheet sheet = excelFile.getSheet(sheetIndex);
		final int numberOfRows = sheet.getPhysicalNumberOfRows();
		final AtomicInteger progressedEntities = new AtomicInteger();
		return IntStream.range(1, numberOfRows)
				.parallel()
				.mapToObj(index -> {
					int progressInt = progressedEntities.incrementAndGet();
					notifyProgressListeners(((double) progressInt) / numberOfRows);
					return excelService.getPatientWithDBCheck(indexMappers, index, sheet);
				})
				.filter(Objects::nonNull)
				.collect(Collectors.toList());
	}
	
	private void notifyProgressListeners(final double progress) {
		progressListeners.forEach(listener -> listener.updateProgress(progress));
	}
	
}
