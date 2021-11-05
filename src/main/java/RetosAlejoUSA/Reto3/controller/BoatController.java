package RetosAlejoUSA.Reto3.controller;

import RetosAlejoUSA.Reto3.model.Boat;
import RetosAlejoUSA.Reto3.service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Boat")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class BoatController {

    @Autowired
    private BoatService boatService;

    @GetMapping("/all")
    public List<Boat> getAll(){
        return boatService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Boat> getCategory(@PathVariable("id") int id){
        return boatService.getBoat(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    private Boat save(@RequestBody Boat boat){
        return boatService.save(boat);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Boat update(@RequestBody Boat boat){
        return boatService.update(boat);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean delete(@PathVariable("id") int id){
        return boatService.deleteBoat(id);
    }
}
