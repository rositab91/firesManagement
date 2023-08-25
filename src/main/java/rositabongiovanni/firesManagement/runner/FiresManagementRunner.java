package rositabongiovanni.firesManagement.runner;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import rositabongiovanni.firesManagement.CommunicationAdministrator;
import rositabongiovanni.firesManagement.MonitoringCenterImpl;
import rositabongiovanni.firesManagement.entities.Probe;
import rositabongiovanni.firesManagement.entities.ProbeFactory;
import rositabongiovanni.firesManagement.interfaces.MonitoringCenter;

@Component
public class FiresManagementRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		Probe probe = ProbeFactory.createProbe(1, 50.123, 10.456);
		Probe probeB = ProbeFactory.createProbe(2, 52.456, 11.678);

		MonitoringCenter monitoringCenter = new MonitoringCenterImpl();

		CommunicationAdministrator communicationAdministrator = new CommunicationAdministrator(List.of(probe));
		communicationAdministrator.addObserver(monitoringCenter);
		probe.setSmokeLevel(6);
		probeB.setSmokeLevel(6);

		communicationAdministrator.detectFire();
	}

		}

