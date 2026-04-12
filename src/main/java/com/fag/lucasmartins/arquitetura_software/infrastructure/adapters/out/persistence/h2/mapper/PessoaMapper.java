package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.out.persistence.h2.entity.PessoaEntity;

public class PessoaMapper {

    private PessoaMapper() {
    }

    public static PessoaEntity toEntity(PessoaBO bo) {
        PessoaEntity entity = new PessoaEntity();
        entity.setCpf(bo.getCpf());
        entity.setNome(bo.getNome());
        entity.setTelefone(bo.getTelefone());
        entity.setEmail(bo.getEmail());
        entity.setDataNascimento(bo.getDataNascimento());

        return entity;
    }

    public static PessoaBO toBo(PessoaEntity entity) {
        PessoaBO bo = new PessoaBO();
        bo.setCpf(entity.getCpf());
        bo.setNome(entity.getNome());
        bo.setTelefone(entity.getTelefone());
        bo.setEmail(entity.getEmail());
        bo.setDataNascimento(entity.getDataNascimento());

        return bo;
    }
}
