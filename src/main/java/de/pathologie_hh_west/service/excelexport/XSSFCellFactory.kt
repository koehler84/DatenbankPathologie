package de.pathologie_hh_west.service.excelexport

import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFCellStyle
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.sql.Date
import java.time.LocalDate

class XSSFCellFactory(val row: XSSFRow) {
	
	fun addCell(index: Int, value: Any): XSSFCell {
		val cell: XSSFCell
		
		when (value) {
			is Int -> {
				cell = row.createCell(index, XSSFCell.CELL_TYPE_NUMERIC)
				cell.setCellValue(value.toDouble())
			}
			is LocalDate -> {
				cell = row.createCell(index, XSSFCell.CELL_TYPE_NUMERIC)
				val date = Date.valueOf(value) as java.util.Date
				cell.setCellValue(date)
				cell.cellStyle = DateCellStyle.style
			}
			is Boolean -> {
				cell = row.createCell(index, XSSFCell.CELL_TYPE_BOOLEAN)
				cell.setCellValue(value)
			}
			else -> {
				cell = row.createCell(index, XSSFCell.CELL_TYPE_STRING)
				cell.setCellValue(value.toString())
			}
		}
		
		return cell
	}
}

object DateCellStyle {
	lateinit var style: XSSFCellStyle
	
	fun init(workbook: XSSFWorkbook) {
		style = workbook.createCellStyle()
		style.dataFormat = workbook.creationHelper.createDataFormat().getFormat("m/d/yy")
	}
}