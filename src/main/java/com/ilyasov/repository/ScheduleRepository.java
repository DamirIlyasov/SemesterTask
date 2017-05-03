package com.ilyasov.repository;

import com.ilyasov.model.Schedule;
import com.ilyasov.model.User;
import com.ilyasov.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
    Schedule findOneByWorker(Worker worker);
    List<Schedule> findAllByWorker(Worker worker);
    Schedule findOneById(Long id);
    void deleteByWorkerId(Long id);
}
