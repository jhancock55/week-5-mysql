package bikeEntity;

public class Bikes {
	private int id;
	private String brand;
	private String niche;
	private String modelName;
	private int price;
	
	public Bikes (int id, String brand, String niche, String modelName, int price) {
		this.setId(id);
		this.setBrand(brand);
		this.setNiche(niche);
		this.setModelName(modelName);
		this.setPrice(price);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getNiche() {
		return niche;
	}

	public void setNiche(String niche) {
		this.niche = niche;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
