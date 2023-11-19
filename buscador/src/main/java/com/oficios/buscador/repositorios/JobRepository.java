package com.oficios.buscador.repositorios;

import com.oficios.buscador.entidades.Job;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    @Query("SELECT j FROM Job j WHERE j.client.idClient = :idClient")
    List<Job> findByClientId(@Param("idClient") Long idClient);

    @Query("SELECT j FROM Job j WHERE j.serviceProvided.idProvided= :idProvided")
    List<Job> findByIdProvided(@Param("idProvided") Long idProvided);
    
    
     @Query("SELECT j FROM Job j WHERE j.satus = :status")
    List<Job> findByStatus(@Param("status") String status);

}
