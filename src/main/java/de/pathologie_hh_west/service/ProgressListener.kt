package de.pathologie_hh_west.service;

interface ProgressListener {
	
	fun updateProgress(workDone: Double, max: Double)
}
