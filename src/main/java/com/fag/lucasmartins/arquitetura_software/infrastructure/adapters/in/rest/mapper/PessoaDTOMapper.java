package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.PessoaDTO;

public class PessoaDTOMapper {

    private PessoaDTOMapper() {
    }

    public static PessoaBO toBo(PessoaDTO dto) {
        final PessoaBO bo = new PessoaBO();
        bo.setCpf(dto.getCpf());
        bo.setNome(dto.getNome());
        bo.setTelefone(dto.getTelefone());
        bo.setEmail(dto.getEmail());
        bo.setDataNascimento(dto.getDataNascimento());

        return bo;
    }

    public static PessoaDTO toDto(PessoaBO bo) {
        final PessoaDTO dto = new PessoaDTO();
        dto.setCpf(bo.getCpf());
        dto.setNome(bo.getNome());
        dto.setTelefone(bo.getTelefone());
        dto.setEmail(bo.getEmail());
        dto.setDataNascimento(bo.getDataNascimento());

        return dto;
    }
}
