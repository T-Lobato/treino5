package base.api.treino5.service;

import base.api.treino5.dto.request.AlunoRequestDto;
import base.api.treino5.entities.Aluno;
import base.api.treino5.repository.AlunoRepository;
import java.util.Arrays;
import java.util.List;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final ModelMapper mapper;


    @Transactional
    public Aluno save(AlunoRequestDto alunoRequestDto) {
        return alunoRepository.save(mapper.map(alunoRequestDto, Aluno.class));
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }
}