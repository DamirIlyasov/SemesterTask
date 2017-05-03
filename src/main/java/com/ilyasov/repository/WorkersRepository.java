package com.ilyasov.repository;

import com.ilyasov.model.ServiceType;
import com.ilyasov.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkersRepository extends JpaRepository<Worker,Long> {
    List<Worker> getOneByServiceType(ServiceType serviceType);
    Worker findOneById(Long id);
}