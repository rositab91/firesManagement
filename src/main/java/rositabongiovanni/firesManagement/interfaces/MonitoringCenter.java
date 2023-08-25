package rositabongiovanni.firesManagement.interfaces;

import java.util.List;

import rositabongiovanni.firesManagement.entities.Probe;

public interface MonitoringCenter {
	void update(List<Probe> probe);
}
