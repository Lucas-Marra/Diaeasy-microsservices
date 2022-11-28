package br.com.tcc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToOne;
import java.time.LocalDate;

@Getter
@Setter
public class Paciente {
    private Long id;

    private String nome;
    private String documento;
    private LocalDate dataNascimento;
    private String sexo;
    private String email;
    private String senha;
    private Long medico;
}
