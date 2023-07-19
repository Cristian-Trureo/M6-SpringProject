package cl.awakelab.SprintM6.repository;

import cl.awakelab.SprintM6.entity.Empleador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadorRepository extends JpaRepository<Empleador, Integer> {

}
