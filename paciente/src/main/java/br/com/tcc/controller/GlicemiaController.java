package br.com.tcc.controller;

import br.com.tcc.repository.PacienteRepository;
import br.com.tcc.service.GlicemiaService;
import br.com.tcc.vo.dto.Glicemia;
import br.com.tcc.vo.dto.GlicemiaDto;
import br.com.tcc.vo.dto.GlicemiaRecenteDto;
import br.com.tcc.vo.form.AlterarGlicemiaForm;
import br.com.tcc.vo.form.GlicemiaForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/glicemias")
public class GlicemiaController {

    @Autowired
    private GlicemiaService glicemiaService;

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping("/{idPaciente}")
    public ResponseEntity<List<GlicemiaDto>> listar(@PathVariable Long idPaciente) {
        return glicemiaService.listarPorPaciente(idPaciente);
    }

    @GetMapping("/recentes/{idPaciente}")
    public ResponseEntity<List<GlicemiaRecenteDto>> listarRecentes(@PathVariable Long idPaciente) {
        return glicemiaService.listarRecentes(idPaciente);
    }

    @PutMapping("/alterar")
    public ResponseEntity<Glicemia> alterarGlicemia( @RequestBody AlterarGlicemiaForm glicemiaForm) {
        return glicemiaService.alterar(glicemiaForm);
    }

    @PostMapping("/registrar/{idPaciente}")
    public ResponseEntity<Glicemia> registrarGlicemia(@PathVariable Long idPaciente, @RequestBody GlicemiaForm glicemiaForm) {
        return glicemiaService.salvar(idPaciente, glicemiaForm);
    }

    @DeleteMapping("/delete/{idGlicemia}")
    public ResponseEntity deletarGlicemia(@PathVariable Long idGlicemia) {
        return glicemiaService.deletar(idGlicemia);
    }
}
