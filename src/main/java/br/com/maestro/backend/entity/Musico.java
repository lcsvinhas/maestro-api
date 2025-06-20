package br.com.maestro.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "musicos")
public class Musico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String instrumento;
    private String nacionalidade;
    private LocalDate dataNascimento;
    @ManyToOne
    @JoinColumn(name = "id_banda")
    private Banda banda;
}
