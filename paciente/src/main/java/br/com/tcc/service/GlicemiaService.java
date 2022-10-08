package br.com.tcc.service;

import br.com.tcc.Repository.GlicemiaRepository;
import br.com.tcc.vo.dto.GlicemiaDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GlicemiaService {

    @Autowired
    private GlicemiaRepository glicemiaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<List<GlicemiaDto>> listarGlicemiasDoPaciente(Long id) {
        return ResponseEntity.ok(glicemiaRepository
            .findAllByPacienteId(id)
            .stream().map(g -> modelMapper.map(g, GlicemiaDto.class))
            .collect(Collectors.toList()));
    }
}
