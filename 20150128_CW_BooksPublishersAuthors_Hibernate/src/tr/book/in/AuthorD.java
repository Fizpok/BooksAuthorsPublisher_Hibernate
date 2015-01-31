package tr.book.in;

public class AuthorD {
	@Override
	public String toString() {
		return "AuthorD [id=" + id + ", name=" + name + ", country=" + country
				+ ", year=" + year + "]";
	}
	int id;
	String name;
	String country;
	int year;
	public AuthorD(int id, String name, String country, int year) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.year =  year;
	}
	
	public int getYear() {
		return year;
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCountry() {
		return country;
	}

}
