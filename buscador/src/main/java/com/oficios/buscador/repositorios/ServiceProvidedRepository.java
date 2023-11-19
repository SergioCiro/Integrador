package com.oficios.buscador.repositorios;

import com.oficios.buscador.entidades.ServiceProvided;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceProvidedRepository extends JpaRepository<ServiceProvided, Long> {

    @Query("SELECT s FROM ServiceProvided s WHERE s.providedEmail =:email")
    public ServiceProvided findByEmail(@Param("email") String email);

    @Query("SELECT s FROM ServiceProvided s WHERE s.providedName =:providedName")
    public ServiceProvided findByProvidedName(@Param("providedName") String providedName);

    @Query("SELECT s FROM ServiceProvided s WHERE s.trades.tradeName = :TradeName")
    public List<ServiceProvided> findByTrade(@Param("tradeName") String tradeName);

    @Query("SELECT s FROM ServiceProvided s WHERE LOWER(s.providedName) LIKE LOWER(CONCAT('%', :name, '%'))")
    public List<ServiceProvided> findByTradeName(@Param("name") String name);

}
