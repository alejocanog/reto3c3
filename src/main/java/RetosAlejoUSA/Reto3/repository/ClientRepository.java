package RetosAlejoUSA.Reto3.repository;

import RetosAlejoUSA.Reto3.crudRepository.clientCrudRepository;
import RetosAlejoUSA.Reto3.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private clientCrudRepository ClientCrudrepository;

    public List<Client> getAll(){
        return (List<Client>) ClientCrudrepository.findAll();
    }

    public Optional<Client> getClient(int id){
        return ClientCrudrepository.findById(id);
    }

    public Client save(Client client){
        return ClientCrudrepository.save(client);
    }

    public void delete(Client client){
        ClientCrudrepository.delete(client);
    }

}
