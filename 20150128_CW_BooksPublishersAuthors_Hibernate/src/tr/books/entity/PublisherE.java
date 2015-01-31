package tr.books.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class PublisherE {
	@Id 
	String name;
	String country;
	@OneToMany(mappedBy="publisher")
	List<BookE> books;

	public PublisherE(String name, String country) {
		super();
		this.name = name;
		this.country = country;
	}

	public PublisherE() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public List<BookE> getBooks() {
		return books;
	}
	public void setBooks(List<BookE> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "PublisherE [name=" + name + ", country=" + country + "]";
	}
}
