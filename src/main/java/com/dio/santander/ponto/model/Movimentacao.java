package com.dio.santander.ponto.model;

import com.dio.santander.ponto.model.pk.MovimentacaoPK;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Movimentacao {

    @EmbeddedId
    private MovimentacaoPK id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm", timezone = "GMT")
    private LocalDateTime dataEntrada;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm", timezone = "GMT")
    private LocalDateTime dataSaida;

    private BigDecimal periodo;

    @ManyToOne
    @JoinColumn(name = "ocorrencia_id")
    private Ocorrencia ocorrencia;

    @ManyToOne
    @JoinColumn(name = "calendario_id")
    private Calendario calendario;
}
