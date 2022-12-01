package br.com.tcc.model;

import br.com.tcc.config.CriptografiaAesConfig;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistroGlicemia {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = CriptografiaAesConfig.class)
    private Double valor;
    private LocalDateTime horario;
    private LocalDateTime horarioRefeicao;
    private String observacao;

    private Long pacienteId;
}
