package com.oficios.buscador.repositorios;

import com.oficios.buscador.entidades.Chat;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

    @Query("SELECT c FROM Chat c WHERE c.creationDate = :creationDate")
    public List<Chat> findByCreationDate(@Param("creationDate") Date creationDate);

    @Query("SELECT c FROM Chat c WHERE c.idJob = :idJob")
    public List<Chat> findByJobId(@Param("idJob") Long idJob);

    @Query("SELECT c FROM Chat c WHERE c.active = :active")
    public List<Chat> findByActiveStatus(@Param("active") Boolean active);

}
