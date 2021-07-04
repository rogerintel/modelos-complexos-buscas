package br.com.alura.loja.dao;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.vo.RelatorioDeVendasVo;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class PedidoDao {

	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}

	public BigDecimal valorTotalVendido() {
		return em.createQuery("select sum(p.valorTotal) from Pedido p", BigDecimal.class).getSingleResult();
	}

	public List<RelatorioDeVendasVo> relatorioDeVendas() {
		return em.createQuery(
				"select new br.com.alura.loja.vo.RelatorioDeVendasVo(" +
						"produto.nome, " +
						"sum(item.quantidade), " +
						"max(pedido.data) )" +
						"from " +
						"Pedido pedido " +
						"join pedido.itens item " +
						"join item.produto produto " +
						"group by produto.nome " +
						"order by item.quantidade desc", RelatorioDeVendasVo.class).getResultList();
	}

}
