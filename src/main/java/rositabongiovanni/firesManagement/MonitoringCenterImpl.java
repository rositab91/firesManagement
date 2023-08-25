package rositabongiovanni.firesManagement;

import java.util.List;

import rositabongiovanni.firesManagement.entities.Probe;
import rositabongiovanni.firesManagement.interfaces.MonitoringCenter;

public class MonitoringCenterImpl implements MonitoringCenter {

	@Override
		public void update(List<Probe> probes) {

			for (Probe probe : probes) {
				int smokeLevel = probe.getSmokeLevel();
				if (smokeLevel > 5) {
					String url = "http://host/alarm?idprobe=" + probe.getId() + "&lat=" + probe.getLatitude() + "&lon="
							+ probe.getLongitude() + "&smokelevel=" + smokeLevel;

					System.out.println(
							"Probe with id :  " + probe.getId() + " Smoke level detection > of 5: " + url);
				}
			}
		}
	}