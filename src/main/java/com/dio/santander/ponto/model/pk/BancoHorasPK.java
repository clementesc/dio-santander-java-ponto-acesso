package com.dio.santander.ponto.model.pk;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BancoHorasPK implements Serializable {

    private Integer bancoHorasId;
    private Integer movimentacaoId;
    private Integer usuarioId;

    public BancoHorasPK() {
    }

    public BancoHorasPK(Integer bancoHorasId, Integer movimentacaoId, Integer usuarioId) {
        this.bancoHorasId = bancoHorasId;
        this.movimentacaoId = movimentacaoId;
        this.usuarioId = usuarioId;
    }

    public Integer getBancoHorasId() {
        return bancoHorasId;
    }

    public void setBancoHorasId(Integer bancoHorasId) {
        this.bancoHorasId = bancoHorasId;
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
        BancoHorasPK that = (BancoHorasPK) o;
        return Objects.equals(bancoHorasId, that.bancoHorasId) && Objects.equals(movimentacaoId, that.movimentacaoId) && Objects.equals(usuarioId, that.usuarioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bancoHorasId, movimentacaoId, usuarioId);
    }
}
