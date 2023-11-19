package com.oficios.buscador.entidades;

import com.oficios.buscador.enumeraciones.Roll;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    private String clientName;

    @Column(unique = true)
    private String clientEmail;
    private String password;

    @Temporal(TemporalType.DATE)
    private Date registrerDate;
    private Boolean active = true;

    @Enumerated(EnumType.STRING)
    private Roll roll;

}
