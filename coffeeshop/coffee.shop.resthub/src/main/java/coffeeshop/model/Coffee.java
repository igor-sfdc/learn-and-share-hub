package coffeeshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Coffee {

	@NotNull
	@Size(min=4, max=32, message="Country name must be between 4 and 32 letters")
    private String name;
    private String description;
    private String region;
    private String processed;
    @Min(value = 1)
    private int weight;

//========== Code defining many-to-one relationship =========================
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "coffee_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "country_id")
    @NotNull(message="Country must be selected")
    Country countryFrom;
//===========================================================    
    
    public Country getCountryFrom() {
		return countryFrom;
	}


	public Coffee() {
        super();
    }

    public Coffee(String name) {
        super();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	public String getProcessed() {
		return processed;
	}

	public void setProcessed(String processed) {
		this.processed = processed;
	}
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	public void setCountryFrom(Country countryFrom) {
		this.countryFrom = countryFrom;
	}
	
	@Override
	public String toString() {
		return "Coffee "
				+ "name: " + name + ", "
				+ "description: " + description + ", "
				+ "country: " + countryFrom.getName() + ", "				
				+ "region: " + region + ", "
				+ "processed: " + processed + ", "
				+ "weight: " + weight;
	}
}
