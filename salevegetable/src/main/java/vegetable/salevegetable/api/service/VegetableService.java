package vegetable.salevegetable.api.service;

import java.util.List;

import vegetable.salevegetable.api.model.Vegetable;

public interface VegetableService {
    public List<Vegetable> listVegetable();
    public Vegetable getVegetable(Integer id);
    public Vegetable addVegetable(Vegetable vegetable);
    public Vegetable updateVegetable(Integer id, Vegetable vegetable);
    public boolean deleteVegetable(Integer id);
}
