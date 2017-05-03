package com.ilyasov.service;

import com.ilyasov.model.ServiceType;
import com.ilyasov.model.Worker;

import java.util.List;

public interface WorkersService {
    List<Worker> getWorkersByServiceType(ServiceType serviceType);
    Worker findOneById(Long id);
    void add(Worker worker);
    void delete(Worker worker);
}
