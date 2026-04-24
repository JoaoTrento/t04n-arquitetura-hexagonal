package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PedidoServicePort;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.dto.PedidoEventDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.mapper.PedidoDTOMapper;

import io.awspring.cloud.sqs.annotation.SqsListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class PedidoSqsAdapter {

    private static final Logger log = LoggerFactory.getLogger(PedidoSqsAdapter.class);

    @Autowired
    private PedidoServicePort orderService;

    @SqsListener("${queue.order-events}")
    public void listen(PedidoEventDTO dto) {
        try {
            log.info("Mensagem recebida: " + dto.getCustomerId());
            orderService.criarPedido(PedidoDTOMapper.toBo(dto));

        } catch (Exception e) {
            log.error("Erro ao processar o evento de pedido para o cliente {}", dto.getCustomerId(), e);
        
        }
    }
}
