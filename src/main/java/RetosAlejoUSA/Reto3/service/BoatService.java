package RetosAlejoUSA.Reto3.service;

import RetosAlejoUSA.Reto3.model.Boat;
import RetosAlejoUSA.Reto3.repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoatService {

    @Autowired
    private BoatRepository boatRepository;

    public List<Boat> getAll() {
        return boatRepository.getAll();
    }

    public Optional<Boat> getBoat(int id) {
        return boatRepository.getBoat(id);

    }

    public Boat save(Boat boat){
        if (boat.getId()==null){
            return boatRepository.save(boat);
        }else{
            Optional<Boat> baux=boatRepository.getBoat(boat.getId());
            if(baux.isEmpty()){
                return boatRepository.save(boat);
            }else{
                return boat;
            }
        }
    }

    public Boat update(Boat boat){
        if (boat.getId()!=null){
            Optional<Boat> tmpBoat = boatRepository.getBoat(boat.getId());
            if (tmpBoat.isEmpty()){
                return boatRepository.save(boat);
            }
        }
        return null;
    }

    public boolean deleteBoat(int id){
        Boolean aBoolean=getBoat(id).map(boat -> {
            boatRepository.delete(boat);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
