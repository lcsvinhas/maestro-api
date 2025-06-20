package br.com.maestro.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bandas")
public class Banda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String genero;
    private Integer anoFormacao;
    @OneToMany(mappedBy = "banda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Musico> musicos;
}
