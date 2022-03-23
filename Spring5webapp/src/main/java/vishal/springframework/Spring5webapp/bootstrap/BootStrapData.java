package vishal.springframework.Spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vishal.springframework.Spring5webapp.domain.Author;
import vishal.springframework.Spring5webapp.domain.Book;
import vishal.springframework.Spring5webapp.domain.Publisher;
import vishal.springframework.Spring5webapp.repositories.AuthorRepository;
import vishal.springframework.Spring5webapp.repositories.BookRepository;
import vishal.springframework.Spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("John");
        publisher.setAddressLine1("Street No 1");
        publisher.setCity("California");
        publisher.setState("CA");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count is "+publisherRepository.count());

        //First Data
        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","11889900");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        //Second data
        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EEE Development without EJB","1188779900");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of Books"+ bookRepository.count());
        System.out.println("Publisher number of books: "+publisher.getBooks().size());
    }
}
