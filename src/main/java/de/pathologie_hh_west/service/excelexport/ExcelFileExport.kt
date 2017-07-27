package de.pathologie_hh_west.service.excelexport

import de.pathologie_hh_west.model.Patient
import de.pathologie_hh_west.service.PatientModelAttribute
import de.pathologie_hh_west.service.PatientValueExtractor
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFWorkbookType
import java.io.File
import java.io.FileOutputStream

class ExcelFileExport(val targetFilePath: String,
                      val columns: List<PatientModelAttribute>,
                      val patients: Collection<Patient>) {
	
	val targetFile: File = File(targetFilePath)
	var sheetName: String = "Tabelle 1"
	val workbook: XSSFWorkbook = XSSFWorkbook(XSSFWorkbookType.XLSX)
	lateinit var worksheet: XSSFSheet
	
	init {
		if (targetFile.exists()) throw FileAlreadyExistsException(targetFile)
	}
	
	fun writePatients() {
		initializeWorksheet()
		writeHeaders()
		
		DateCellStyle.init(this.workbook)
		
		patients.forEachIndexed { rowIndex, patient ->
			val row = worksheet.createRow(rowIndex + 1)
			val xssfCellFactory = XSSFCellFactory(row)
			columns.forEachIndexed { columnIndex, patientModelAttribute ->
				val extactedValue = PatientValueExtractor.extactValue(patientModelAttribute.getGetter(), patient)
//				val cell = row.createCell(columnIndex)
//				cell.setCellValue(extactedValue.toString())
				val cell = xssfCellFactory.addCell(columnIndex, extactedValue)
			}
		}
		
		writeToFile()
	}
	
	private fun writeToFile() {
		val fileOutputStream = FileOutputStream(this.targetFile)
		workbook.write(fileOutputStream)
		fileOutputStream.close()
	}
	
	private fun initializeWorksheet() {
		worksheet = workbook.createSheet(sheetName)
	}
	
	private fun writeHeaders() {
		val headerRow = worksheet.createRow(0)
		columns.forEachIndexed { index, patientModelAttribute ->
			val cell = headerRow.createCell(index)
			cell.setCellValue(patientModelAttribute.name)
		}
	}
	
}