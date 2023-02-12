package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRep;
import guru.springframework.spring5webapp.repositories.BookRep;
import guru.springframework.spring5webapp.repositories.PublisherRep;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRep authorRep;
    private final BookRep bookRep;
    private final PublisherRep publisherRep;

    public BootstrapData(AuthorRep authorRep, BookRep bookRep, PublisherRep publisherRep) {
        this.authorRep = authorRep;
        this.bookRep = bookRep;
        this.publisherRep = publisherRep;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("PEric");
        publisher.setCity("Taipei");
        publisherRep.save(publisher);

        System.out.println("Number of Publisher: "+ publisherRep.count());

        // Book1
        Author eric = new Author("Eric", "Lu");
        Book pandaStruggle = new Book("Little Panda's Struggle", "1234");
        eric.getBooks().add(pandaStruggle);
        pandaStruggle.getAuthors().add(eric);

        pandaStruggle.setPublisher(publisher);
        publisher.getBooks().add(pandaStruggle);

        authorRep.save(eric);
        bookRep.save(pandaStruggle);
        publisherRep.save(publisher);

        // Book2
        Author eric2 = new Author("Eric", "Lu");
        Book pandaStruggle2 = new Book("Little Panda's Struggle", "1234");
        eric.getBooks().add(pandaStruggle2);
        pandaStruggle.getAuthors().add(eric2);

        pandaStruggle2.setPublisher(publisher);
        publisher.getBooks().add(pandaStruggle2);

        authorRep.save(eric2);
        bookRep.save(pandaStruggle2);
        publisherRep.save(publisher);

        System.out.println("Number of books: "+ bookRep.count());
        System.out.println("Publisher number of books: "+ publisher.getBooks().size());
    }
}
