package ci.sndi.e_permission.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ci.sndi.e_permission.models.Direction;


@Repository
public interface DirectionRepository extends JpaRepository <Direction, Long>{

}
