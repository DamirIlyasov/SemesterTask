package com.ilyasov.service.impl;

import com.ilyasov.model.Schedule;
import com.ilyasov.model.Worker;
import com.ilyasov.repository.ScheduleRepository;
import com.ilyasov.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Schedule findOneByWorker(Worker worker) {
        return scheduleRepository.findOneByWorker(worker);
    }

    @Override
    public void delete(Long id) {

        scheduleRepository.deleteByWorkerId(id);
    }

    @Override
    public void add(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    @Override
    public List<Schedule> findAllByWorker(Worker worker) {
         return scheduleRepository.findAllByWorker(worker);
    }

    @Override
    public Schedule findOneById(Long id) {
        return scheduleRepository.findOneById(id);
    }

    @Override
    public List<Schedule> getAll() {
        return scheduleRepository.findAll();
    }


}
