package com.ilyasov.repository;

import com.ilyasov.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {
    List<City> findAll();
    City getOneById(Long id);
}
