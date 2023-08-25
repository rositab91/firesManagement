package rositabongiovanni.firesManagement.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Probe {
	
		private int id;
		private int smokeLevel;
		private double latitude;
		private double longitude;

		public Probe(int id, double latitude, double longitude) {
			this.id = id;
			this.smokeLevel = 0;
			this.latitude = latitude;
			this.longitude = longitude;
		}

	}
