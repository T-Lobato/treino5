package base.api.treino5.controller;

import base.api.treino5.dto.request.CursoRequestDto;
import base.api.treino5.dto.response.CursoResponseDto;
import base.api.treino5.service.CursoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cursos")
public class CursoController {

    private final ModelMapper mapper;
    private final CursoService cursoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CursoResponseDto save(@RequestBody CursoRequestDto cursoRequestDto) {
        return mapper.map(cursoService.save(cursoRequestDto), CursoResponseDto.class);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CursoResponseDto findById(@PathVariable Long id) {
        return mapper.map(cursoService.findById(id), CursoResponseDto.class);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CursoResponseDto update(@PathVariable Long id, @RequestBody CursoRequestDto cursoRequestDto) {
        return mapper.map(cursoService.update(cursoRequestDto, id), CursoResponseDto.class);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        cursoService.deleteById(id);
    }
}