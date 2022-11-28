package br.com.tcc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
// TODO deixar somente getters and setters
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistroGlicemia {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // TODO encriptar valor;
    private String valor;
    private LocalDateTime horario;
    private LocalDateTime horarioRefeicao;
    private String observacao;

    @ManyToOne(optional = false)
    private Paciente paciente;
}
