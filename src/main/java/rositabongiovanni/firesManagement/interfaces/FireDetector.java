package rositabongiovanni.firesManagement.interfaces;

public interface FireDetector {
	void addObserver(MonitoringCenter observer);

	void removeObserver(MonitoringCenter observer);

	void notifyObserver();
}
