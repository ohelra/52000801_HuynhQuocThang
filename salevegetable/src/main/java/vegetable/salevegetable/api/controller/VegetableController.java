package vegetable.salevegetable.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vegetable.salevegetable.api.model.Vegetable;
import vegetable.salevegetable.api.repository.VegetableRepository;
import vegetable.salevegetable.api.service.VegetableService;


@RestController
@RequestMapping("api/vegetable")
public class VegetableController implements VegetableService {

    @Autowired
    private VegetableRepository vegetableRepository;

    @GetMapping
    @Override
    public List<Vegetable> listVegetable() {
        return vegetableRepository.findAll();
    }

    @GetMapping("{id}")
    @Override
    public Vegetable getVegetable(@PathVariable("id") Integer id) {
        return vegetableRepository.findById(id).orElse(null);
    }
    //filter find by category
    @GetMapping("find-by-category/{category}")
    public List<Vegetable> findByCategory(@PathVariable("category") String category) {
        return vegetableRepository.findByCategory(category);
    }
    //filter sort price asc
    @GetMapping("sort-price-asc/{price}")
    public  List<Vegetable> sortVegetablesByPriceASC(){
        return vegetableRepository.sortVegetablesByPriceASC();
    }
    //filter sort price desc
    @GetMapping("sort-price-desc/{price}")
    public  List<Vegetable> sortVegetablesByPriceDESC(){
        return vegetableRepository.sortVegetablesByPriceDESC();
    }


    @PostMapping
    @Override
    public Vegetable addVegetable(@RequestBody Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
        
    }
    @PutMapping("{id}")
    @Override
    public Vegetable updateVegetable(@PathVariable("id") Integer id, @RequestBody Vegetable vegetable) {
        return vegetableRepository.findById(id).map(vegetableUpdate -> {
            vegetableUpdate.setName(vegetable.getName());
            vegetableUpdate.setStatus(vegetable.getStatus());
            return vegetableRepository.save(vegetableUpdate);
        }).orElse(null);
    }

    @DeleteMapping("{id}")
    @Override
    public boolean deleteVegetable(@PathVariable("id") Integer id) {
       try{
          vegetableRepository.deleteById(id);
          return true;
        
       }catch(Exception e){
            return false;
       }
    }
    
}
