package vishal.springframework.Spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import vishal.springframework.Spring5webapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
