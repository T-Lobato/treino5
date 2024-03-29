package base.api.treino5.service;

import base.api.treino5.dto.request.CursoRequestDto;
import base.api.treino5.entities.Aluno;
import base.api.treino5.entities.Curso;
import base.api.treino5.repository.CursoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;
    private final ModelMapper mapper;
    private final AlunoService alunoService;

    @Transactional
    public Curso save(CursoRequestDto cursoRequestDto) {

        Curso curso = new Curso();
        curso.setDisciplina(cursoRequestDto.getDisciplina());
        curso.setPeriodo(cursoRequestDto.getPeriodo());
        curso.setCargaHoraria(cursoRequestDto.getCargaHoraria());
        curso.setDificuldade(cursoRequestDto.getDificuldade());

        Aluno aluno = alunoService.findById(cursoRequestDto.getAlunoRef());
        curso.setAluno(aluno);

        return cursoRepository.save(curso);
    }

    public Curso findById(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
    }

    @Transactional
    public Curso update(CursoRequestDto cursoRequestDto, Long id) {

        Curso curso = this.findById(id);
        curso.setDisciplina(cursoRequestDto.getDisciplina());
        curso.setPeriodo(cursoRequestDto.getPeriodo());
        curso.setCargaHoraria(cursoRequestDto.getCargaHoraria());
        curso.setDificuldade(cursoRequestDto.getDificuldade());
        cursoRepository.save(curso);
        return curso;
    }

    public void deleteById(Long id) {
        Curso curso = this.findById(id);
        cursoRepository.delete(curso);
    }
}