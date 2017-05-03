package com.ilyasov.service;

import com.ilyasov.model.Schedule;
import com.ilyasov.model.Worker;

import java.util.List;

public interface ScheduleService {
    Schedule findOneByWorker(Worker worker);
    void delete(Long id);
    void add(Schedule schedule);
    List<Schedule> findAllByWorker(Worker worker);
    Schedule findOneById(Long id);
    List<Schedule> getAll();
}
