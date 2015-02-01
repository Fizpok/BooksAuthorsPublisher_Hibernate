package tr.book.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import tr.book.in.*;
import tr.books.DAO.*;
import tr.books.entity.*;


public class TestLib {

	public static void main(String[] args) {
		int max = 90;
		List<AuthorD> authors = new ArrayList<AuthorD>();
		authors.addAll(createAuthors());
		
		List<PublisherD> publishers = new ArrayList<PublisherD>();
		publishers.addAll(createPublishers());
		
		List<BookD> books =new ArrayList<BookD>();
		books.addAll(createBooks());
		
		AbstractApplicationContext ctx= new FileSystemXmlApplicationContext("beans.xml");
		ILib lib = (ILib) ctx.getBean("liba");
		
		
		for (int i=0; i<20;i++){
			lib.addBook(books.get(i), authors.get(i), publishers.get(i));
//			System.out.println("addBook" + i);
		}
		
		String bookTitle = "mollis nec";
		System.out.println("getAuthorsByBook with Title: \""+ bookTitle+"\"");
		for(AuthorE author:lib.getAuthorsByBook(bookTitle)){
			System.out.println(author);	
		}
		
		int authorId=666884007;
		BookE bookEntityForAddingAnotherAuthor = lib.getBookByTitle(bookTitle);
		AuthorE tmpAuthor = lib.getAuthorById(authorId);
		List<AuthorE> authorsForTheBook = bookEntityForAddingAnotherAuthor.getAuthors();
		authorsForTheBook.add(tmpAuthor);
		tmpAuthor = lib.getAuthorById(163270100);
		authorsForTheBook.add(tmpAuthor);
		tmpAuthor = lib.getAuthorById(803685018);
		authorsForTheBook.add(tmpAuthor);
		bookEntityForAddingAnotherAuthor.setAuthors(authorsForTheBook);
		lib.saveBook(bookEntityForAddingAnotherAuthor);

		bookEntityForAddingAnotherAuthor = lib.getBookByTitle("Proin dolor. Nulla");
		tmpAuthor = lib.getAuthorById(163270100);
		authorsForTheBook = bookEntityForAddingAnotherAuthor.getAuthors();
		authorsForTheBook.add(tmpAuthor);
		bookEntityForAddingAnotherAuthor.setAuthors(authorsForTheBook);
		lib.saveBook(bookEntityForAddingAnotherAuthor);
		
		
		System.out.println("getAuthorsByBook with Title: \""+ bookTitle+"\"");
		for(AuthorE author:lib.getAuthorsByBook(bookTitle)){
			System.out.println(author);	
			for (BookE book:author.getBooks()){
				System.out.println("\t"+book.toString());
			}
		}
		
/*		lib.addBook(books.get(rnd(books.size()-1)), authors, publishers.get(rnd(publishers.size()-1)));
		String title="Title"+rnd(max);
		System.out.println("getAuthorsByBook with Title: "+ title);
		for(AuthorE author:lib.getAuthorsByBook(title)){
			System.out.println(author);	
		}*/
		
		System.out.println("getBookByAuthor with Id: "+ authorId);
		
		for(BookE book:lib.getBooksByAuthor(authorId)){
			System.out.println(book);	
		}
		
		String PublisherName="Publisher Mauris ut quam vel";
		System.out.println("getAuthorsByPublisher with \""+PublisherName+'\"');
		for(AuthorE author:lib.getAuthorsByPublisher(PublisherName)){
			System.out.println(author);
		}
		
		System.out.println("Yuri's original function getMostPopularAuthors5");
		for(AuthorE author:lib.getMostPopularAuthors5()){
			System.out.println(author);
			for (BookE book:author.getBooks()){
				System.out.println("\t"+book.toString());
			}
		}
		
		System.out.println("\n===getMostPopularAuthorsN with books count===");
		HashMap<AuthorE, Long> authorsWithBooksCount = lib.getMostPopularAuthorsN(5);
		for (Entry<AuthorE, Long> entry:authorsWithBooksCount.entrySet()){
			AuthorE tmpAuthor1 =entry.getKey(); 
			System.out.println(tmpAuthor1.toString() +" wrote "+ entry.getValue()+" books:");
			for (BookE book:tmpAuthor1.getBooks()){
				System.out.println("\t"+book.toString());
			}
		}
		
		ctx.close();
	}

	private static List<AuthorD> createAuthors() {
		List<AuthorD> authors = new ArrayList<AuthorD>();
		authors.add(new AuthorD (263492838,"Daquan Finch","Saint Helena, Ascension and Tristan da Cunha",1985) );
		authors.add(new AuthorD (747186228,"Ray House","Ecuador",2013) );
		authors.add(new AuthorD (729734202,"Erin Sims","Papua New Guinea",1994) );
		authors.add(new AuthorD (220916973,"Aquila William","Bhutan",2014) );
		authors.add(new AuthorD (926241243,"Suki Osborne","Burundi",1947) );
		authors.add(new AuthorD (519666107,"Blake Potts","Barbados",1995) );
		authors.add(new AuthorD (805706706,"Uriah Schroeder","South Africa",1923) );
		authors.add(new AuthorD (497352787,"Wanda Finch","Poland",1995) );
		authors.add(new AuthorD (535232376,"Halee Guerra","Fiji",1956) );
		authors.add(new AuthorD (149044084,"Phillip Zimmerman","Guinea",1912) );
		authors.add(new AuthorD (897577313,"Reece Emerson","Finland",1937) );
		authors.add(new AuthorD (827982041,"Fleur Whitley","Bonaire, Sint Eustatius and Saba",1960) );
		authors.add(new AuthorD (666884007,"Naida Charles","Mayotte",1918) );
		authors.add(new AuthorD (640724317,"Gregory Walls","Jamaica",2000) );
		authors.add(new AuthorD (163270100,"Price Klein","Cameroon",1907) );
		authors.add(new AuthorD (726604318,"Quamar Cooper","Slovakia",2003) );
		authors.add(new AuthorD (289050886,"Quinlan Hooper","Gibraltar",1964) );
		authors.add(new AuthorD (908684448,"Lilah Good","Germany",1990) );
		authors.add(new AuthorD (537734385,"Leo Ewing","New Zealand",2008) );
		authors.add(new AuthorD (803685018,"Sebastian Hunter","Bolivia",1995) );
		return authors;
	}

	private static List<BookD> createBooks() {
		List<BookD> books = new ArrayList<BookD>();
		books.add(new BookD ("mollis nec",88,279));
		books.add(new BookD ("Fusce aliquet",95,225));
		books.add(new BookD ("nisl. Nulla eu neque",19,260));
		books.add(new BookD ("semper pretium neque.",58,230));
		books.add(new BookD ("adipiscing fringilla, porttitor vulputate",99,111));
		books.add(new BookD ("Cum sociis natoque",39,192));
		books.add(new BookD ("Nunc ut",48,248));
		books.add(new BookD ("non, lobortis",19,177));
		books.add(new BookD ("purus mauris",35,191));
		books.add(new BookD ("erat vel pede blandit",26,159));
		books.add(new BookD ("Curabitur vel lectus. Cum",44,261));
		books.add(new BookD ("magnis dis parturient montes",18,281));
		books.add(new BookD ("Proin dolor. Nulla",34,234));
		books.add(new BookD ("Fusce mollis. Duis sit",40,145));
		books.add(new BookD ("commodo ipsum. Suspendisse non",73,286));
		books.add(new BookD ("egestas nunc sed",44,101));
		books.add(new BookD ("et ultrices posuere cubilia",74,218));
		books.add(new BookD ("enim nec tempus",58,208));
		books.add(new BookD ("lobortis tellus justo",54,278));
		books.add(new BookD ("Vivamus sit amet",61,262));
		return books;
	}

	private static List<PublisherD> createPublishers() {
		List<PublisherD> publishers = new ArrayList<PublisherD>();
		publishers.add(new PublisherD("Publisher risus. Duis a","South Georgia and The South Sandwich Islands"));
		publishers.add(new PublisherD("Publisher tincidunt aliquam arcu. Aliquam","Guadeloupe"));
		publishers.add(new PublisherD("Publisher urna. Nunc","Tonga"));
		publishers.add(new PublisherD("Publisher a, auctor non, feugiat","Mexico"));
		publishers.add(new PublisherD("Publisher facilisis lorem tristique aliquet.","Jersey"));
		publishers.add(new PublisherD("Publisher Nullam nisl. Maecenas","Estonia"));
		publishers.add(new PublisherD("Publisher bibendum fermentum metus.","Slovakia"));
		publishers.add(new PublisherD("Publisher fermentum vel, mauris.","Myanmar"));
		publishers.add(new PublisherD("Publisher eget, volutpat ornare, facilisis","Luxembourg"));
		publishers.add(new PublisherD("Publisher nunc nulla vulputate","Brunei"));
		publishers.add(new PublisherD("Publisher tempor diam","India"));
		publishers.add(new PublisherD("Publisher cursus vestibulum.","Congo, the Democratic Republic of the"));
		publishers.add(new PublisherD("Publisher magna a tortor.","Bonaire, Sint Eustatius and Saba"));
		publishers.add(new PublisherD("Publisher taciti sociosqu","Saint Lucia"));
		publishers.add(new PublisherD("Publisher eleifend, nunc risus","Falkland Islands"));
		publishers.add(new PublisherD("Publisher Nam nulla magna,","American Samoa"));
		publishers.add(new PublisherD("Publisher vel arcu.","Moldova"));
		publishers.add(new PublisherD("Publisher est. Nunc","Nicaragua"));
		publishers.add(new PublisherD("Publisher Mauris ut quam vel","Bermuda"));
		publishers.add(new PublisherD("Publisher odio semper cursus.","Greenland"));
		return publishers;
	}
	
	public static int rnd(int max){
		Random rnd = new Random();
		return rnd.nextInt(max);
	}
}
