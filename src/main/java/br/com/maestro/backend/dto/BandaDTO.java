package br.com.maestro.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BandaDTO {
    @NotBlank(message = "Campo 'nome' não está preenchido.")
    private String nome;

    @NotBlank(message = "Campo 'genero' não está preenchido.")
    private String genero;

    @NotNull(message = "Campo 'anoFormacao' não está preenchido.")
    private Integer anoFormacao;

    private List<MusicoDTO> musicos;

}
