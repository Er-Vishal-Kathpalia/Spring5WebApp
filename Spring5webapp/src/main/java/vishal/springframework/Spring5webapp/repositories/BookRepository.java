package vishal.springframework.Spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import vishal.springframework.Spring5webapp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
