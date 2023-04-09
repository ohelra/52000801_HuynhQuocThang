package vegetable.salevegetable.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import vegetable.salevegetable.api.model.Vegetable;

public interface VegetableRepository extends JpaRepository<Vegetable,Integer>{


    @Query("SELECT v FROM Vegetable v WHERE v.category = :category_v")
    List<Vegetable> findByCategory(@Param("category_v") String category);

    @Query("SELECT v FROM Vegetable v ORDER BY v.price ASC")
    List<Vegetable> sortVegetablesByPriceASC();

    @Query("SELECT v FROM Vegetable v ORDER BY v.price DESC")
    List<Vegetable> sortVegetablesByPriceDESC();
}
