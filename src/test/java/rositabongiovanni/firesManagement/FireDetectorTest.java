package rositabongiovanni.firesManagement;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import rositabongiovanni.firesManagement.entities.Probe;
import rositabongiovanni.firesManagement.entities.ProbeFactory;
import rositabongiovanni.firesManagement.interfaces.MonitoringCenter;

@SpringBootTest
public class FireDetectorTest {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@AfterEach
	public void tearDown() {
		System.setOut(standardOut);
	}

	@Test
	void testUrlInvocation() {
		Probe probe = ProbeFactory.createProbe(1, 50.123, 10.456);

		MonitoringCenter monitoringCenter = new MonitoringCenterImpl();

		CommunicationAdministrator communicationAdministrator = new CommunicationAdministrator(List.of(probe));
		communicationAdministrator.addObserver(monitoringCenter);
		probe.setSmokeLevel(6);

		communicationAdministrator.detectFire();

		String expectedUrl = "http://host/alarm?idprobe=1&lat=50.123&lon=10.456&smokelevel=6";

		assertTrue(outputStreamCaptor.toString().contains(expectedUrl));
	}
}
