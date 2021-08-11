package com.dio.santander.ponto.model;

import com.dio.santander.ponto.model.pk.BancoHorasPK;
import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class BancoHoras {

    @EmbeddedId
    private BancoHorasPK id;

    private LocalDate dataTrabalhada;

    private BigDecimal quantidadeHoras;

    private BigDecimal saldoHoras;


}
