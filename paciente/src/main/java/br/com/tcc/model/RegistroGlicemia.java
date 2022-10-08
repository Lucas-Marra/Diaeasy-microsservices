package br.com.tcc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistroGlicemia {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_glicemia")
    private Long id;

    private BigDecimal valor;
    private String data;
    private String hora;

    @Column(name = "data_refeicao")
    private String dataRefeicao;

    @Column(name = "hora_refeicao")
    private String horaRefeicao;

    private String observacao;

    //TODO mudar nome no banco de dados
    @ManyToOne(optional = false)
    private Paciente paciente;
}
