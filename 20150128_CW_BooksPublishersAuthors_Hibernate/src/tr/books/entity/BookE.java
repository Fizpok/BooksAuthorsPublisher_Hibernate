package tr.books.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class BookE {
	@Id
	String title;
	int price;
	int pages;

	@ManyToMany
	List<AuthorE> authors;
	@ManyToOne 
	PublisherE publisher;

	public BookE(String title, int price, int pages, List<AuthorE> authors,
			PublisherE publisher) {
		super();
		this.title = title;
		this.price = price;
		this.pages = pages;
		this.authors = authors;
		this.publisher = publisher;
	}
	public BookE() {
		super();
	}

	public List<AuthorE> getAuthors() {
		return authors;
	}
	public void setAuthors(List<AuthorE> author) {
		this.authors = author;
	}
	public PublisherE getPublisher() {
		return publisher;
	}
	public void setPublisher(PublisherE publisher) {
		this.publisher = publisher;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}


	@Override
	public String toString() {
		return "BookE [title=" + title + ", price=" + price + ", pages=" + pages
				+ ", authors=" + authors + ", publisher=" + publisher + "]";
	}
}
