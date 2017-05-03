package com.ilyasov.repository;

import com.ilyasov.model.City;
import com.ilyasov.model.ServiceType;
import com.ilyasov.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceType,Long> {
    List<ServiceType> findAllByCity(City city);
    ServiceType findOneById(Long id);
}
