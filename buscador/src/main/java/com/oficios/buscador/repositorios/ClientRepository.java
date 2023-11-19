package com.oficios.buscador.repositorios;

import com.oficios.buscador.entidades.Client;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT c FROM Client c WHERE c.clientEmail = :email")
    public Client findByEmail(@Param("email") String email);

    @Query("SELECT c FROM Client c WHERE c.roll = :roll")
    public List<Client> findByRoll(@Param("roll") String roll);

    @Query("SELECT c FROM Client c WHERE LOWER(c.clientName) LIKE LOWER(CONCAT('%', :name, '%'))")
    public List<Client> findClientsByName(@Param("name") String name);
    
    

}
