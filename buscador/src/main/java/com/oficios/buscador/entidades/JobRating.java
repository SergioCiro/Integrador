
package com.oficios.buscador.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class JobRating {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJobRating;

    @OneToOne
    @JoinColumn(name = "job_id")
    private Job job;

    private Integer calification;
    private String comment;
    
}
