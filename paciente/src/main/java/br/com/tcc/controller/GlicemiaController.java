package br.com.tcc.controller;

import br.com.tcc.model.RegistroGlicemia;
import br.com.tcc.service.GlicemiaService;
import br.com.tcc.vo.dto.GlicemiaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/glicemias")
public class GlicemiaController {

    @Autowired
    private GlicemiaService glicemiaService;

    @GetMapping("/{id}")
    public ResponseEntity<List<GlicemiaDto>> listaGlicemias(@PathVariable Long id) {
        return glicemiaService.listarGlicemiasDoPaciente(id);
    }
}
