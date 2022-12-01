package br.com.tcc.repository;

import br.com.tcc.model.IdsMedicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MedicosRepository extends JpaRepository<IdsMedicos, Long> {

    @Query(value = "select m.nome " +
            "from medico m " +
            "where m.id = ?1 ", nativeQuery = true)
    String findNomeMedicoById(Long id);
}
