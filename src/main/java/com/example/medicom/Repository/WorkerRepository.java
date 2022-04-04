package com.example.medicom.Repository;

import com.example.medicom.Models.User;
import com.example.medicom.Models.Worker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends CrudRepository<Worker, Long> {
    Worker findByPassSeria(String PassSeria);

    Worker findByPassNum(String PassNum);

    Worker findByINN(String INN);
}
