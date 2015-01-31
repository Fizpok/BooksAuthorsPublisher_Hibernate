package tr.books.DAO;

import java.util.List;

import tr.book.in.*;
import tr.books.entity.*;

public interface ILib {
	boolean addBook(BookD book, List<AuthorD> authors, PublisherD publisher);
	List<AuthorE> getAuthorsByBook(String title);
	List<BookE> getBookByAuthor(int id);
	List<AuthorE> getAuthorsByPublisher(String publisherName);
	List<AuthorE> getMostPopularAuthors5(); //by numbers book
	

}
