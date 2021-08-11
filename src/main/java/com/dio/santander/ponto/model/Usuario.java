package com.dio.santander.ponto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private BigDecimal tolerancia;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "GMT")
    private LocalDateTime inicioJornada;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "GMT")
    private LocalDateTime finalJornada;

    @ManyToOne //varios usuário para uma categoria
    @JoinColumn(name = "categoriausuario_id")
    private CategoriaUsuario categoriaUsuario;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "nivelacesso_id")
    private NivelAcesso nivelAcesso;

    @ManyToOne
    @JoinColumn(name = "jornadatrabalho_id")
    private JornadaTrabalho jornadaTrabalho;

}
