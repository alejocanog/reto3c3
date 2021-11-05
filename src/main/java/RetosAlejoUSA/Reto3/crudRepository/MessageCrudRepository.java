package RetosAlejoUSA.Reto3.crudRepository;

import RetosAlejoUSA.Reto3.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}
