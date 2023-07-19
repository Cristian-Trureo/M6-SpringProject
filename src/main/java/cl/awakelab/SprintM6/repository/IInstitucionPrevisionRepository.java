package cl.awakelab.SprintM6.repository;

import cl.awakelab.SprintM6.entity.InstitucionPrevision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInstitucionPrevisionRepository extends JpaRepository<InstitucionPrevision, Integer> {
}
