package br.com.tcc.service;

import br.com.tcc.model.Paciente;
import br.com.tcc.repository.PacienteRepository;
import br.com.tcc.vo.dto.PacienteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public ResponseEntity registrar(Long idMedico, Paciente paciente) {
        paciente.setMedicoId(idMedico);
        paciente.setSenha(new BCryptPasswordEncoder().encode(paciente.getSenha()));
        try {
            pacienteRepository.save(paciente);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<List<PacienteDto>> buscarPorMedico(Long idMedico) {
        return ResponseEntity.ok(pacienteRepository
                .findAllByMedicoId(idMedico)
                .stream()
                .map(PacienteDto::new)
                .collect(Collectors.toList()));

    }

    public ResponseEntity alterarPaciente(PacienteDto paciente) {
        Optional<Paciente> pacienteOpt = pacienteRepository.findById(paciente.getId());
        if (pacienteOpt.isPresent()) {
            if (pacienteOpt.get().getId().equals(paciente.getId())) {
                Paciente pac = pacienteOpt.get();
                pacienteRepository.save(paciente.update(pac));
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}
