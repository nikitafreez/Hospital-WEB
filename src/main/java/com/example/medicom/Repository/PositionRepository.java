package com.example.medicom.Repository;

import com.example.medicom.Models.Position;
import com.example.medicom.Models.Worker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends CrudRepository<Position, Long> {
    Position findByPositionName(String positionName);

}
