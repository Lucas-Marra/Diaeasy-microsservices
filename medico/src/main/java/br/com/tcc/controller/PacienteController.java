package br.com.tcc.controller;

import br.com.tcc.model.Paciente;
import br.com.tcc.service.PacienteService;
import br.com.tcc.vo.dto.PacienteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @PostMapping("/registrar/{idMedico}")
    public ResponseEntity registrarPaciente(@PathVariable Long idMedico, @RequestBody Paciente paciente) {
        return pacienteService.registrar(idMedico, paciente);
    }

    @GetMapping("/{idMedico}")
    public ResponseEntity<List<PacienteDto>> buscarPacientes(@PathVariable Long idMedico) {
        return pacienteService.buscarPorMedico(idMedico);
    }

    @GetMapping("/glicemias/{idPaciente}")
    public ResponseEntity buscarGlicemiasPorPaciente(@PathVariable Long idPaciente) {
        return pacienteService.buscarGlicemiaPorPaciente(idPaciente);
    }

    @PutMapping("/alterar")
    public ResponseEntity alterarPaciente(@RequestBody PacienteDto paciente) {
        return pacienteService.alterarPaciente(paciente);
    }
}
