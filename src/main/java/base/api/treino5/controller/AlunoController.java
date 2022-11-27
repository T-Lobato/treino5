package base.api.treino5.controller;

import base.api.treino5.dto.request.AlunoRequestDto;
import base.api.treino5.dto.response.AlunoResponseDto;
import base.api.treino5.service.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/alunos")
@Tag(name = "Aluno Controller")
public class AlunoController {

    private final ModelMapper mapper;

    private final AlunoService alunoService;

    @PostMapping
    @Operation(summary = "Registra um Aluno.")
    public ResponseEntity<AlunoResponseDto> save(@RequestBody AlunoRequestDto alunoRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(alunoService.save(alunoRequestDto), AlunoResponseDto.class));
    }
    @GetMapping
    @Operation(summary = "Buscar todos os Alunos registrados.")
    public ResponseEntity<List<AlunoResponseDto>> findAll(){
        return ResponseEntity.ok().body(alunoService.findAll()
                .stream()
                .map(n -> (mapper.map(n, AlunoResponseDto.class)))
                .collect(Collectors.toList()));
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Busca um aluno pelo seu ID.")
    public ResponseEntity<AlunoResponseDto> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(mapper.map(alunoService.findById(id), AlunoResponseDto.class));

    }
    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deleta um Aluno pelo seu ID.")
    public ResponseEntity<Object> deleteById(@PathVariable Long id){
        alunoService.deleteById(id);
        return ResponseEntity.ok().body("Aluno deletado com sucesso!");
    }
    @PutMapping(value = "/{id}")
    @Operation(summary = "Atualiza um Aluno pelo seu ID.")
    public ResponseEntity<AlunoResponseDto> update(@PathVariable Long id, @RequestBody AlunoRequestDto alunoRequestDto){
        alunoRequestDto.setId(id);
        alunoService.update(alunoRequestDto);
        return ResponseEntity.ok().body(mapper.map(alunoService.findById(id), AlunoResponseDto.class));
    }
}