
package com.oficios.buscador.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Chat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChat;

    private Long idJob;
    private String feedback;
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    private Boolean active;
    
    
    
}
    