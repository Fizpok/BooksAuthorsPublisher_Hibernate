package tr.books.entity;
import java.util.*;

import javax.persistence.*;

@Entity
public class AuthorE {
	@Id
	int id;
	String name;
	String country;
	int year;
	
	@ManyToMany(mappedBy="authors")
	List<BookE> books;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<BookE> getBooks() {
		return books;
	}

	public void setBooks(List<BookE> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "AuthorE [id=" + id + ", name=" + name + ", country=" + country
				+ ", year=" + year + "]";
	}

	
	public AuthorE(int id, String name, String country, int year) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.year = year;

	}

	public AuthorE() {
		super();
	}
	
	

}
