package br.com.tcc.Repository;

import br.com.tcc.model.Paciente;
import br.com.tcc.model.RegistroGlicemia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GlicemiaRepository extends JpaRepository<RegistroGlicemia, Long> {

    List<RegistroGlicemia> findAllByPacienteId(Long id);
}
