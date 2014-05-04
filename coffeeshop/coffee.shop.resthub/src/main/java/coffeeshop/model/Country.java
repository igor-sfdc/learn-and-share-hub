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
	private float Latitude;
	private float Longitude;
	private int Zoom;

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
		return Latitude;
	}

	public float getLongitude() {
		return Longitude;
	}

	public int getZoom() {
		return Zoom;
	}

	public String getName() {
		return name;
	}
	
	public void setLatitude(double d) {
	       this.Latitude = (float) d;
	}

	public void setLongitude(double d) {
	       this.Longitude = (float) d;
	}

	public void setZoom(int Zoom) {
	       this.Zoom = Zoom;
	}

	public void setName(String name) {
		this.name = name;
	}
	
    @Override
	public String toString() {
		return "Country: " + name;
	}
}
