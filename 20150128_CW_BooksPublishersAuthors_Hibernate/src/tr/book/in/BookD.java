package tr.book.in;

public class BookD {
	String title;
	int price;
	int pages;
/*	List<AuthorD> authors;
	PublisherD publisher;*/
	public BookD(String title, int price, int pages/*, List<AuthorD> authors,
			PublisherD publisher*/) {
		super();
		this.title = title;
		this.price = price;
		this.pages = pages;
//		this.authors = authors;
//		this.publisher = publisher;
	}
	
/*	public List<AuthorD> getAuthors() {
		return authors;
	}
	public PublisherD getPublisher() {
		return publisher;
	}
	*/
	
	public String getTitle() {
		return title;
	}
	@Override
	public String toString() {
		return "BookD [title=" + title + ", price=" + price + ", pages="
				+ pages + "]";
	}

	public int getPrice() {
		return price;
	}
	public int getPages() {
		return pages;
	}
	
}
