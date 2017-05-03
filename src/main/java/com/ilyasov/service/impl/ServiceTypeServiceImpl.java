package com.ilyasov.service.impl;

import com.ilyasov.model.City;
import com.ilyasov.model.ServiceType;
import com.ilyasov.model.Worker;
import com.ilyasov.repository.ServiceRepository;
import com.ilyasov.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceTypeServiceImpl implements ServiceTypeService {

    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceTypeServiceImpl(ServiceRepository serviceRepository){
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<ServiceType> getAllServicesByCity(City city) {
        return serviceRepository.findAllByCity(city);
    }

    @Override
    public ServiceType findOneById(Long id) {
        return serviceRepository.findOneById(id);
    }

    @Override
    public void add(ServiceType serviceType) {
        serviceRepository.save(serviceType);
    }

    @Override
    public void delete(ServiceType serviceType) {
        serviceRepository.delete(serviceType);
    }
}
