package de.pathologie_hh_west.service;

import de.pathologie_hh_west.data.PatientRepository;
import de.pathologie_hh_west.model.Patient;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DataUpdateWrapper {
	
	private final ExcelService excelService;
	private PatientRepository patientRepository;
	private final Set<ProgressListener> progressListeners;
	private final List<DataModifier> dataModifiers;
	private final Set<IndexMapper> indexMappers;
	private final ExcelFile excelFile;
	private final Integer sheetIndex;
	private Stream<Patient> patientStream;
	
	@Autowired
	public DataUpdateWrapper(ExcelService excelService, PatientRepository patientRepository, Set<IndexMapper> indexMappers, final ExcelFile excelFile, final Integer sheetIndex) throws NullPointerException {
		if (excelService == null || patientRepository == null ||
				indexMappers == null || excelFile == null || sheetIndex == null)
			throw new NullPointerException();
		
		this.excelService = excelService;
		this.patientRepository = patientRepository;
		this.progressListeners = new HashSet<>();
		this.dataModifiers = new ArrayList<>();
		this.indexMappers = indexMappers;
		this.excelFile = excelFile;
		this.sheetIndex = sheetIndex;
		
		initPatientStream();
	}
	
	private void initPatientStream() {
		final XSSFSheet sheet = excelFile.getSheet(sheetIndex);
		final int numberOfRows = sheet.getPhysicalNumberOfRows();
		final AtomicInteger progressedEntities = new AtomicInteger();
		patientStream = IntStream.range(1, numberOfRows)
				.parallel()
				.mapToObj(index -> {
					int progressInt = progressedEntities.incrementAndGet();
					notifyProgressListeners(progressInt, numberOfRows);
					return excelService.getPatientWithDBCheck(indexMappers, index, sheet);
				});
	}
	
	public DataUpdateWrapper registerListener(ProgressListener listener) {
		this.progressListeners.add(listener);
		return this;
	}
	
	public DataUpdateWrapper addDataModifier(DataModifier dataModifier) {
		this.dataModifiers.add(dataModifier);
		return this;
	}
	
	public List<Patient> getWithoutUpdate() {
		this.dataModifiers.forEach(dataModifier -> {
			this.patientStream = this.patientStream.map(dataModifier::modify);
		});
		return this.patientStream.collect(Collectors.toList());
	}
	
	public List<Patient> updateAndGet() {
		return this.patientStream
				.map(patientRepository::save)
				.filter(Objects::nonNull)
				.collect(Collectors.toList());
	}
	
	private void notifyProgressListeners(final double progress, final double max) {
		progressListeners.forEach(listener -> listener.updateProgress(progress, max));
	}
	
}
