package br.com.tcc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class IdsPacientes {
    @Id
    private Long id;
}
