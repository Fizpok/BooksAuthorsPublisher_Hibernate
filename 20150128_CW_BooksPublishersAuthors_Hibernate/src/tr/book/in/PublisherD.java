package tr.book.in;

public class PublisherD {
	@Override
	public String toString() {
		return "PublisherD [name=" + name + ", country=" + country + "]";
	}
	String name;
	String country;
	public PublisherD(String name, String country) {
		super();
		this.name = name;
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public String getCountry() {
		return country;
	}
	

}
