package br.com.alura.loja.vo;

import java.time.LocalDate;

public class RelatorioDeVendasVo {

    private final String nomeProduto;
    private final Long quantidadeVendida;
    private final LocalDate ultimaVenda;

    public RelatorioDeVendasVo(String nomeProduto, Long quantidadeVendida, LocalDate ultimaVenda) {
        this.nomeProduto = nomeProduto;
        this.quantidadeVendida = quantidadeVendida;
        this.ultimaVenda = ultimaVenda;
    }

    @Override
    public String toString() {
        return "RelatorioDeVendasVo{" +
                "nomeProduto='" + nomeProduto + '\'' +
                ", quantidadeVendida=" + quantidadeVendida +
                ", ultimaVenda=" + ultimaVenda +
                '}';
    }
}
