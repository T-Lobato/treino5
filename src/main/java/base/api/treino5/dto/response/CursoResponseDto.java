package base.api.treino5.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CursoResponseDto {

    private Long id;
    private String disciplina;
    private String periodo;
    private String cargaHoraria;
}
