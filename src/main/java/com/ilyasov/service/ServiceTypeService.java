package com.ilyasov.service;

import com.ilyasov.model.City;
import com.ilyasov.model.ServiceType;
import com.ilyasov.model.Worker;

import java.util.List;

public interface ServiceTypeService {
    List<ServiceType> getAllServicesByCity(City city);
    ServiceType findOneById(Long id);
    void add(ServiceType serviceType);
    void delete(ServiceType serviceType);
}
