package com.dio.santander.ponto.model.pk;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MovimentacaoPK implements Serializable {

    private Integer movimentacaoId;
    private Integer usuarioId;

    public MovimentacaoPK() {
    }

    public MovimentacaoPK(Integer movimentacaoId, Integer usuarioId) {
        this.movimentacaoId = movimentacaoId;
        this.usuarioId = usuarioId;
    }

    public Integer getMovimentacaoId() {
        return movimentacaoId;
    }

    public void setMovimentacaoId(Integer movimentacaoId) {
        this.movimentacaoId = movimentacaoId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovimentacaoPK that = (MovimentacaoPK) o;
        return Objects.equals(movimentacaoId, that.movimentacaoId) && Objects.equals(usuarioId, that.usuarioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movimentacaoId, usuarioId);
    }
}
