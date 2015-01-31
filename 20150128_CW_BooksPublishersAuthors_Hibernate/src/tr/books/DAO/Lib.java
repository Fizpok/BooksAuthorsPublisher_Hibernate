package tr.books.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import tr.book.in.*;
import tr.books.entity.*;

@SuppressWarnings("unchecked")
public class Lib implements ILib {
	@PersistenceContext(unitName="springHibernate",type=PersistenceContextType.EXTENDED)
	EntityManager em;
	@Transactional(readOnly=false)
	@Override
	public boolean addBook(BookD book, List<AuthorD> authors,PublisherD publisher) {
		boolean res=false;
		List<AuthorE> authorsE=listAuthorD2ListAuthorE(authors);
		PublisherE publisherE=publisherD2PublisherE(publisher);
		BookE bookE = bookD2BookE(book,authorsE, publisherE);
		if (bookE!=null) res=true;
		return res;
	}

	@Override
	public boolean addBook(BookD book, AuthorD author, PublisherD publisher) {
		List <AuthorD> tmpAuthorsList = new ArrayList<AuthorD>(1);
		tmpAuthorsList.add(author);
		return addBook(book, tmpAuthorsList, publisher);
	}
	
	@Override
	public List<AuthorE> getAuthorsByBook(String title) {
		Query query = em.createQuery
				("select a from AuthorE a join a.books b where b.title=?1");
		query.setParameter(1, title);
		
		return query.getResultList();

	}

	@Override
	public List<BookE> getBookByAuthor(int id) {
		Query query = em.createQuery
				("select b from BookE b join b.authors a where a.id=?1");
		query.setParameter(1, id);
		return query.getResultList();
	}

	/* */

	@Override
	public List<AuthorE> getAuthorsByPublisher(String publisherName) {
		Query query = em.createQuery
				("select a from BookE b join b.authors a join b.publisher p where p.name=?1");
		query.setParameter(1, publisherName);
		return query.getResultList();
	}

	@Override
	public List<AuthorE> getMostPopularAuthors(int popularAuthorsCount) {
		Query query = em.createQuery
				("select a from AuthorE a join a.books b group by a.id order by count(a.id) desc ");
		query.setMaxResults(popularAuthorsCount);
		return query.getResultList();
	}
	
	@Override
	@Deprecated
	public List<AuthorE> getMostPopularAuthors5() {
		return getMostPopularAuthors(5);
	}

	
	private List<AuthorE> listAuthorD2ListAuthorE(List<AuthorD> authors){
		List<AuthorE> authorEs = new ArrayList<AuthorE>();
		for(AuthorD author: authors){
			AuthorE authorE=em.find(AuthorE.class, author.getId());
			if(authorE==null){
				authorE = new AuthorE(author.getId(), author.getName(), author.getCountry(), author.getYear());
				em.persist(authorE);
			}
			authorEs.add(authorE);
		}
		return authorEs; 
	}
	
	private PublisherE publisherD2PublisherE(PublisherD publisher) {
		PublisherE publisherE = em.find(PublisherE.class, publisher.getName());
		if(publisherE==null){
			publisherE=new PublisherE(publisher.getName(), publisher.getCountry());
			em.persist(publisherE);


		}
		return publisherE;
	}

	private BookE bookD2BookE(BookD book, List<AuthorE> authors, PublisherE publisher) {
		BookE bookE=em.find(BookE.class, book.getTitle());
			if(bookE==null){
			bookE=new BookE(book.getTitle(), book.getPrice(), book.getPages(), authors, publisher);
			em.persist(bookE);
		}
		return bookE;
	}
}
