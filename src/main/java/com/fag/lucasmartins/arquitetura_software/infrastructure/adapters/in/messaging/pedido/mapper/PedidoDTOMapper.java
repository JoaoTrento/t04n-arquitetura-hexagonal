package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.mapper;

import java.util.ArrayList;
import java.util.List;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoProdutoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.dto.OrderItemsDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.dto.PedidoEventDTO;

public class PedidoDTOMapper {

    private PedidoDTOMapper() {
    }

    public static PedidoBO toBo(PedidoEventDTO dto) {
        final PedidoBO bo = new PedidoBO(); 

        PessoaBO pessoa = new PessoaBO();
        pessoa.setId(dto.getCustomerId());
        bo.setPessoa(pessoa);

        bo.setCep(dto.getZipCode());

        final List<PedidoProdutoBO> itens = new ArrayList<>();
        for (OrderItemsDTO item : dto.getOrderItems()) {
            PedidoProdutoBO pedidoProduto = new PedidoProdutoBO();
            
            ProdutoBO produto = new ProdutoBO();
            produto.setId(item.getSku());

            pedidoProduto.setProduto(produto);
            pedidoProduto.setQuantidade(item.getAmount());
            
            itens.add(pedidoProduto);
        }
        bo.setItens(itens);

        return bo;
    }
}
