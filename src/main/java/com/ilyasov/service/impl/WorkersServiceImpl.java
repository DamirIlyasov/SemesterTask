package com.ilyasov.service.impl;

import com.ilyasov.model.ServiceType;
import com.ilyasov.model.Worker;
import com.ilyasov.repository.WorkersRepository;
import com.ilyasov.service.WorkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WorkersServiceImpl implements WorkersService {
    private final WorkersRepository workersRepository;

    @Autowired
    public WorkersServiceImpl(WorkersRepository workersRepository){
        this.workersRepository = workersRepository;
    }

    @Override
    public List<Worker> getWorkersByServiceType(ServiceType serviceType) {
        return workersRepository.getOneByServiceType(serviceType);
    }

    @Override
    public Worker findOneById(Long id) {
        return workersRepository.findOneById(id);
    }

    @Override
    public void add(Worker worker) {
        workersRepository.save(worker);
    }

    @Override
    public void delete(Worker worker) {
        workersRepository.delete(worker);
    }


}
