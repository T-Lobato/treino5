package base.api.treino5.dto.request;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AlunoRequestDto {

    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataDeNascimento;
    private String telefone;
}