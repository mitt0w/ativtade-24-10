package com.senai.projeto.service;

import com.senai.projeto.entity.ClienteEntity;
import com.senai.projeto.entity.ProdutoEntity;
import com.senai.projeto.repository.ClienteRepository;
import com.senai.projeto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoEntity> listarTodos() {
        return repository.findAll();
    }

    public ProdutoEntity salvarProduto(ProdutoEntity produto) {

        if (repository.findByEmail(produto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Produto já cadastrado.");
        }
        return repository.save(produto);
    }

    public ProdutoEntity atualizarProduto(Long id, ProdutoEntity produto) {

        if (!repository.existsById(id))
            throw new IllegalArgumentException("Produto não encontrado.");

        produto.setId(id);
        return repository.save(produto);
    }

    public void excluirProduto(Long id) {

        if (!repository.existsById(id))
            throw new IllegalArgumentException("Produto não encontrado.");

        repository.deleteById(id);
    }
}