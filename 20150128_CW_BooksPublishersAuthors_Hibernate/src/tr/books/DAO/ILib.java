package tr.books.DAO;

import java.util.HashMap;
import java.util.List;

import tr.book.in.*;
import tr.books.entity.*;

public interface ILib {
	boolean addBook(BookD book, List<AuthorD> authors, PublisherD publisher);
	boolean addBook(BookD book, AuthorD author, PublisherD publisher);
	List<AuthorE> getAuthorsByBook(String title);
	AuthorE getAuthorById (int id);
	List<BookE>   getBooksByAuthor(int id);
	BookE getBookByTitle(String title);
	void saveBook (BookE book);
	List<AuthorE> getAuthorsByPublisher(String publisherName);
	@Deprecated
	List<AuthorE> getMostPopularAuthors5(); //by numbers book
	List<AuthorE> getMostPopularAuthors(int popularAuthorsCount); 
	HashMap<AuthorE, Long> getMostPopularAuthorsN(int countOfAuthors);
	
}
