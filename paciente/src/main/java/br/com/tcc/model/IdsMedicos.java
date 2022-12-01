package br.com.tcc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class IdsMedicos {
    @Id
    private Long id;

}
