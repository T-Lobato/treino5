package base.api.treino5.dto.response;

import base.api.treino5.entities.Curso;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AlunoResponseDto {

    private Long id;
    private String nome;
    private String telefone;
    private List<Curso> cursoLista;
}