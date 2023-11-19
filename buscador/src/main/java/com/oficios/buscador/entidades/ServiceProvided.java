package com.oficios.buscador.entidades;

import com.oficios.buscador.enumeraciones.ExperienceLevel;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class ServiceProvided {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProvided;

    private String providedName;

    @Column(unique = true)
    private String providedEmail;
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registrerDate;
    private Boolean active = true;

    @ManyToMany
    @JoinTable(
            name = "service_provided_trade",
            joinColumns = @JoinColumn(name = "service_provided_id"),
            inverseJoinColumns = @JoinColumn(name = "trade_id")
    )
    private List<Trade> trades;

    @OneToMany(mappedBy = "serviceProvided")
    private List<Job> jobs;
    
    @Enumerated(EnumType.STRING)
    private ExperienceLevel level;

}
