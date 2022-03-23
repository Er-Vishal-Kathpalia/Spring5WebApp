package vishal.springframework.Spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import vishal.springframework.Spring5webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
