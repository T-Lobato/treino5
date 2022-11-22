package base.api.treino5.service;

import base.api.treino5.dto.request.AlunoRequestDto;
import base.api.treino5.entities.Aluno;
import base.api.treino5.repository.AlunoRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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

    public Aluno findById(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    public void deleteById(Long id) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        alunoOptional.orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        alunoRepository.deleteById(id);
    }

    public Aluno update(AlunoRequestDto alunoRequestDto) {
        if(existById(alunoRequestDto.getId())) {
            return alunoRepository.save(mapper.map(alunoRequestDto, Aluno.class));
        } else {
            throw new RuntimeException("Aluno não existe!");
        }
    }

    private boolean existById(Long id){
        return alunoRepository.existsById(id);
    }
}