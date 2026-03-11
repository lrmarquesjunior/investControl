package br.com.invest.investControl.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(
        name = "T_ATIVOS"
)
public class AtivosEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.UUID
    )
    private UUID ativo_id;
    @Column(
            name = "NOME"
    )
    private String nomeAtivo;
    @Column(
            name = "QUANTIDADE"
    )
    private Integer quantidadeAtivo;
    @Column(
            name = "VALOR"
    )
    private BigDecimal valor;
    @JsonFormat(
            shape = Shape.STRING,
            pattern = "dd/MM/yyyy",
            timezone = "America/Sao_Paulo"
    )
    @Column(
            name = "DATA_COMPRA"
    )
    private Date dataCompra;
    @CreationTimestamp
    @Column(
            name = "DATA_CRIACAO"
    )
    private Instant creationTimestamp;

    public AtivosEntity(UUID ativo_id, String nomeAtivo, Integer quantidadeAtivo, BigDecimal valor, Instant creationTimestamp, Instant updatedTimestamp) {
        this.ativo_id = ativo_id;
        this.nomeAtivo = nomeAtivo;
        this.quantidadeAtivo = quantidadeAtivo;
        this.valor = valor;
        this.creationTimestamp = creationTimestamp;
        this.dataCompra = this.dataCompra;
    }

    public AtivosEntity() {
    }

    public UUID getAtivo_id() {
        return this.ativo_id;
    }

    public void setAtivo_id(UUID ativo_id) {
        this.ativo_id = ativo_id;
    }

    public String getNomeAtivo() {
        return this.nomeAtivo;
    }

    public void setNomeAtivo(String nomeAtivo) {
        this.nomeAtivo = nomeAtivo;
    }

    public Integer getQuantidadeAtivo() {
        return this.quantidadeAtivo;
    }

    public void setQuantidadeAtivo(Integer quantidadeAtivo) {
        this.quantidadeAtivo = quantidadeAtivo;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataCompra() {
        return this.dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Instant getCreationTimestamp() {
        return this.creationTimestamp;
    }

    public void setCreationTimestamp(Instant creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }
}