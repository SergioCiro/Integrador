
package com.oficios.buscador.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;


@Entity
@Data
public class Trade {
    
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long idTrade;
     
     private String tradeName;
     private Boolean active = true;
     
    
}
