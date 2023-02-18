package entities;

public class Company extends TaxPayer {

	private Integer numbersOfEmployees;

	public Company() {
		super();
	}

	public Company(String name, Double anualIncome, Integer numbersOfEmployees) {
		super(name, anualIncome);
		this.numbersOfEmployees = numbersOfEmployees;
	}

	public Integer getNumbersOfEmployees() {
		return numbersOfEmployees;
	}

	public void setNumbersOfEmployees(Integer numbersOfEmployees) {
		this.numbersOfEmployees = numbersOfEmployees;
	}

	@Override
	public Double tax() {
		if (numbersOfEmployees > 10) {
			return getAnualIncome() * 0.14;
		} else {
			return getAnualIncome() * 0.16;
		}
	}
}