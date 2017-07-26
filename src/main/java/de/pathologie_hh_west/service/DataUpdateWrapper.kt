package de.pathologie_hh_west.service

import de.pathologie_hh_west.data.PatientRepository
import de.pathologie_hh_west.model.Patient
import org.springframework.beans.factory.annotation.Autowired
import java.util.*
import java.util.concurrent.atomic.AtomicInteger
import java.util.stream.Collectors
import java.util.stream.IntStream
import java.util.stream.Stream

class DataUpdateWrapper @Autowired constructor(val excelService: ExcelService,
                                               val patientRepository: PatientRepository,
                                               val indexMappers: Set<IndexMapper>,
                                               val excelFile: ExcelFile,
                                               val sheetIndex: Int) {

    private val progressListeners: Set<ProgressListener> = HashSet<ProgressListener>()
    private val dataModifiers: List<DataModifier> = ArrayList<DataModifier>()
    private var patientStream: Stream<Patient>;

    init {
        patientStream = initPatientStream();
    }

    private fun initPatientStream(): Stream<Patient> {
        val sheet = excelFile.getSheet(sheetIndex)
        val numberOfRows = sheet.physicalNumberOfRows
        val procressedEntities = AtomicInteger()

        return IntStream.range(1, numberOfRows)
                .parallel()
                .mapToObj {
                    val progressInt = procressedEntities.incrementAndGet()
                    notifyProgressListeners(progressInt.toDouble(), numberOfRows.toDouble())
                    excelService.getPatientWithDBCheck(indexMappers, it, sheet)
                }
    }

    fun registerListener(listener: ProgressListener): DataUpdateWrapper {
        this.progressListeners.plus(listener)
        return this
    }

    fun addDataModifier(dataModifier: DataModifier): DataUpdateWrapper {
        this.dataModifiers.plus(dataModifier)
        return this
    }

    fun getWithoutUpdate(): List<Patient> {
        this.dataModifiers.forEach { dataModifier ->
            this.patientStream = this.patientStream.map(dataModifier::modify)
        }
        return this.patientStream.collect(Collectors.toList())
    }

    fun updateAndGet(): List<Patient> {
        return this.patientStream
                .map ( patientRepository::save )
                .filter(Objects::nonNull)
                .collect(Collectors.toList())
    }

    private fun notifyProgressListeners(progress: Double, max: Double) {
        progressListeners.forEach { it.updateProgress(progress, max) }
    }
}