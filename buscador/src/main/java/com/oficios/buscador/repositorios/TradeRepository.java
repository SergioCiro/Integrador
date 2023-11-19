
package com.oficios.buscador.repositorios;

import com.oficios.buscador.entidades.Trade;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long>{
    
    @Query("SELECT t FROM Trade t WHERE t.tradeName= :tradeName")
    public Trade findByTradeName(@Param("tradeName")String tradeName );
    
    @Query("SELECT t FROM Trade t WHERE t.active= :true")
    public List<Trade> findByTradeActive();
    
    
}
