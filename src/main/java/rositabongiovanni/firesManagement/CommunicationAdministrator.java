package rositabongiovanni.firesManagement;

import java.util.ArrayList;
import java.util.List;

import rositabongiovanni.firesManagement.entities.Probe;
import rositabongiovanni.firesManagement.interfaces.FireDetector;
import rositabongiovanni.firesManagement.interfaces.MonitoringCenter;

public class CommunicationAdministrator implements FireDetector {
	private List<MonitoringCenter> observers;
	private List<Probe> probes;

	public CommunicationAdministrator(List<Probe> probes) {
		this.observers = new ArrayList<>();
		this.probes = probes;
	}

	@Override
	public void addObserver(MonitoringCenter observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(MonitoringCenter observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObserver() {
		for (MonitoringCenter observer : observers) {
			List<Probe> fireProbes = new ArrayList<>();
			for (Probe probe : probes) {
				if (probe.getSmokeLevel() > 5) {
					fireProbes.add(probe);
				}
			}
			observer.update(fireProbes);
		}
	}

	public void detectFire() {

		notifyObserver();
	}
}
