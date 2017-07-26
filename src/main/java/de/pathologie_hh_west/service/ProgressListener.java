package de.pathologie_hh_west.service;

public interface ProgressListener {
	
	void updateProgress(double workDone, double max);
}
