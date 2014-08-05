package coffeeshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "country_id")
    private Long id;
	private String name;
	private float latitude;
	private float longitude;
	private int zoom;

	public Country(String name) {
		this.name = name;
	}
	public Country() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public float getLatitude() {
		return latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public int getZoom() {
		return zoom;
	}

	public String getName() {
		return name;
	}
	
	public void setLatitude(double d) {
	       this.latitude = (float) d;
	}

	public void setLongitude(double d) {
	       this.longitude = (float) d;
	}

	public void setZoom(int Zoom) {
	       this.zoom = Zoom;
	}

	public void setName(String name) {
		this.name = name;
	}
	
    @Override
	public String toString() {
		return "Country: " + name;
	}
}
