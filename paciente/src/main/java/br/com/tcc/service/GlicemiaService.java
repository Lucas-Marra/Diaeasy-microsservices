package br.com.tcc.service;

import br.com.tcc.Repository.GlicemiaRepository;
import br.com.tcc.Repository.PacienteRepository;
import br.com.tcc.model.Paciente;
import br.com.tcc.model.RegistroGlicemia;
import br.com.tcc.vo.dto.Glicemia;
import br.com.tcc.vo.dto.GlicemiaDto;
import br.com.tcc.vo.dto.GlicemiaRecenteDto;
import br.com.tcc.vo.form.AlterarGlicemiaForm;
import br.com.tcc.vo.form.GlicemiaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GlicemiaService {

    @Autowired
    private GlicemiaRepository glicemiaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public ResponseEntity<List<GlicemiaDto>> listarPorPaciente(Long idPaciente) {
        if(pacienteRepository.findById(idPaciente).isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(glicemiaRepository
            .findRegistroGlicemiasByPaciente_Id(idPaciente)
            .stream().map(GlicemiaDto::new).collect(Collectors.toList()));
    }

    public ResponseEntity<List<GlicemiaRecenteDto>> listarRecentes(Long idPaciente) {
        if(pacienteRepository.findById(idPaciente).isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(glicemiaRepository.
            findRegistroGlicemiasByPaciente_Id(idPaciente)
            .stream()
            .map(GlicemiaRecenteDto::new)
            .collect(Collectors.toList()));
    }

    public ResponseEntity<Glicemia> salvar(Long idPaciente, GlicemiaForm glicemiaForm) {
        Optional<Paciente> pacienteOpt = pacienteRepository.findById(idPaciente);
        if (pacienteOpt.isPresent()) {
            RegistroGlicemia rg = glicemiaForm.converter(pacienteOpt.get());
            glicemiaRepository.save(rg);
            //TODO preencher log de registro
            URI uri = UriComponentsBuilder.newInstance().path("/glicemias/registrar/{idPaciente}")
                .build().toUri();
            return ResponseEntity.created(uri).body(new Glicemia(rg));
        }
        // TODO preencher log de erro
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Glicemia> alterar(Long idPaciente, AlterarGlicemiaForm glicemiaForm) {
        Optional<RegistroGlicemia> registroGlicemiaOpt = glicemiaRepository.findById(glicemiaForm.getId());
        if (registroGlicemiaOpt.isPresent() && registroGlicemiaOpt.get().getId().equals(idPaciente)) {
            RegistroGlicemia rg = registroGlicemiaOpt.get();
            glicemiaRepository.save(glicemiaForm.update(rg));
            //TODO preencher log de registro
            return ResponseEntity.accepted().body(new Glicemia(rg));
        }
        // TODO preencher log de erro
        return ResponseEntity.notFound().build();
    }
}
