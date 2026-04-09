package com.fag.lucasmartins.arquitetura_software.core.domain.bo;

import java.time.LocalDate;
import java.time.Period;

import com.fag.lucasmartins.arquitetura_software.core.domain.exceptions.DomainException;

public class PessoaBO {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;

    public void validaCpfPessoa() {
        if(this.cpf.length() != 11) {
            throw new DomainException("O CPF tem menos de 11 caracteres.");
        }
    }

    public void validaEmailPessoa() {
        if (!this.email.contains("@")) {
            throw new DomainException("O e-mail não tem um @");
        }
    }

    public void validaTelefonePessoa() {
        if ((this.telefone.contains("-")) || (this.telefone.contains("("))
        || (this.telefone.contains(")")) || (this.telefone.length() != 11)) {
            throw new DomainException("Telefone inválido.");
        }
    }

    LocalDate hoje = LocalDate.now();
    int idade = Period.between(this.dataNascimento, hoje).getYears();
    public void validaDataNascimentoPessoa() {
        if (idade < 18){
            throw new DomainException("A pessoa deve ter no mínimo 18 anos.");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
}
