package br.com.maestro.backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MusicoDTO {
    @NotBlank(message = "Campo 'nome' não está preenchido.")
    private String nome;

    @NotBlank(message = "Campo 'instrumento' não está preenchido.")
    private String instrumento;

    @NotBlank(message = "Campo 'nacionalidade' não está preenchido.")
    private String nacionalidade;

    @NotNull(message = "Campo 'dataNascimento' não está preenchido.")
    private LocalDate dataNascimento;

    @NotNull(message = "Campo 'idBanda' não está preenchido.")
    private Long idBanda;
}
