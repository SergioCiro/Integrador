package com.oficios.buscador.entidades;

import com.oficios.buscador.enumeraciones.Status;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJob;

    private String description;
    private Integer cost;

    @OneToOne
    private Client client;

    @OneToOne
    private ServiceProvided serviceProvided;

//    @OneToOne(mappedBy = "job")
//    private JobRating jobRating;
    @Temporal(TemporalType.TIMESTAMP)
    private Date startJobs;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endJobs;

    private Boolean active = true;

    @Enumerated(EnumType.STRING)
    private Status satus;
    
    @OneToMany 
    private List<Chat> chats;

}
