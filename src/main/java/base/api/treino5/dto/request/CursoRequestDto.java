package base.api.treino5.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CursoRequestDto {

    private Long alunoRef;

    private String disciplina;
    private String periodo;
    private String cargaHoraria;
    private String dificuldade;

}