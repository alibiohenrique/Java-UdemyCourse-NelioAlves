package entities;

public class ImportedProducts extends Product {

	private Double customFee;

	public ImportedProducts() {
		super();
	}

	public ImportedProducts(String name, Double price, Double customFee) {
		super(name, price);
		this.customFee = customFee;
	}

	public Double getCustomFee() {
		return customFee;

	}

	public void setCustomFee(Double customFee) {
		this.customFee = customFee;
	}

	public double totalPrice() {
		return customFee + getPrice();
	}

	@Override
	public String priceTag() {
		return getName() + " $ " + String.format("%.2f", totalPrice()) + " (Custom fee: $ "
				+ String.format("%.2f", customFee) + ")";

	}

}
