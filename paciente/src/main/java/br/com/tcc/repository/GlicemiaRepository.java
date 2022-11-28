package br.com.tcc.repository;

import br.com.tcc.model.RegistroGlicemia;
import br.com.tcc.vo.dto.Glicemia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GlicemiaRepository extends JpaRepository<RegistroGlicemia, Long> {
    @Query(value = "select new br.com.tcc.vo.dto.Glicemia(" +
        "g.id, g.valor, g.horario, g.horarioRefeicao, g.observacao) " +
        "from RegistroGlicemia g " +
        "where g.paciente.id = ?1 " +
        "order by g.horario DESC")
    List<Glicemia> findRegistroGlicemiasByPaciente_Id(Long idPaciente);
}
