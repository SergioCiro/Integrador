
package com.oficios.buscador.repositorios;

import com.oficios.buscador.entidades.JobRating;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface JobRatingRepository extends JpaRepository<JobRating, Long>{
    
   @Query("SELECT jr FROM JobRating jr WHERE jr.job.idJob = :idJob")
    JobRating findByJobId(@Param("idJob") Long idJob);
    
   @Query("SELECT jr FROM JobRating jr WHERE jr.job.serviceProvided.idProvided = :idProvided AND jr.calification >= 3")
    List<JobRating> findByPositiveCalification(@Param("idProvided") Long idProvided);
    
    @Query("SELECT jr FROM JobRating jr WHERE jr.job.serviceProvided.idProvided = :idProvided AND jr.calification < 3")
    List<JobRating> findByNegativeCalification(@Param("idProvided") Long idProvided);
}
