package tr.book.controller;

import java.util.*;

import org.springframework.context.support.*;

import tr.book.in.*;
import tr.books.DAO.*;
import tr.books.entity.*;


public class TestLib {

	public static void main(String[] args) {
		int max =10;
		List<AuthorD> authors = new ArrayList<AuthorD>();

		authors.add(new AuthorD(rnd(max), "AuthorName"+rnd(max), "Country"+rnd(max), (1900+rnd(max))));
		authors.add(new AuthorD(rnd(max), "AuthorName"+rnd(max), "country"+rnd(max), (1900+rnd(max))));

		List<PublisherD> publishers = new ArrayList<PublisherD>();
		publishers.add(new PublisherD("PublisherName"+rnd(max), "Country"+rnd(max)));
		publishers.add(new PublisherD("PublisherName"+rnd(max), "Country"+rnd(max)));

		List<BookD> books =new ArrayList<BookD>();
		books.add(new BookD("Title"+rnd(max), rnd(max), rnd(max))); 
		books.add(new BookD("Title"+rnd(max), rnd(max), rnd(max)));



		AbstractApplicationContext ctx= new FileSystemXmlApplicationContext("beans.xml");
		ILib lib = (ILib) ctx.getBean("liba");
		System.out.println("addBook");
		lib.addBook(books.get(rnd(books.size()-1)), authors, publishers.get(rnd(publishers.size()-1)));
		String title="Title"+rnd(max);
		System.out.println("getAuthosByBook with Title: "+ title);
		for(AuthorE author:lib.getAuthosByBook(title)){
			System.out.println(author);	
		}
		
		int id=rnd(max);
		System.out.println("getBookByAuthor with Id: "+ id);
		
		for(BookE book:lib.getBookByAuthor(id)){
			System.out.println(book);	
		}
		
		String PublisherName="PublisherName"+rnd(max);
		System.out.println("getAuthorsByPublisher with "+PublisherName);
		for(AuthorE author:lib.getAuthorsByPublisher(PublisherName)){
			System.out.println(author);
		}
		
		System.out.println("getMostPopularAuthors5");
		for(AuthorE author:lib.getMostPopularAuthors5()){
			System.out.println(author);
		}
		
		ctx.close();


	}

	public static int rnd(int max){
		Random rnd = new Random();
		return rnd.nextInt(max);
	}
}
