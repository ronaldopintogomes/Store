package com.store.servico.impl;

import com.store.modelo.repositorio.dao.InterfaceProdutoDao;
import com.store.modelo.repositorio.entidade.Filial;
import com.store.modelo.repositorio.entidade.Produto;
import com.store.servico.inter.AbstractGenericServicePersistence;
import com.store.servico.inter.InterfaceProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService extends AbstractGenericServicePersistence<InterfaceProdutoDao, Produto, String> implements InterfaceProdutoService {

    @Autowired
    InterfaceProdutoDao produtoDao;

    @Override
    public Produto save(Produto produto) {
        return null;
    }

    @Override
    public List<Produto> findAll() {
        return null;
    }

    @Override
    public Produto findById(String s) {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public void delete(Produto produto) {

    }

    @Override
    public Produto update(Produto produto) {
        return null;
    }

    @Override
    public List<Produto> listaProduto(String nome) {
        return produtoDao.listaProdutoNome(nome);
    }

    @Override
    public List<Produto> listaProduto(Long codigo) {
        return produtoDao.listaProdutoCodigo(codigo);
    }

    @Override
    @Transactional(readOnly = false)
    public void transferirProduto(Long codigo, Filial filial, int quantidade) {
        if(quantidade > 0) {
            Optional<List<Produto>> produtos = Optional.ofNullable(produtoDao.listaProdutoCodigo(codigo));
            produtos.ifPresent(p -> {
                if(p.size() >= quantidade) {
                    p.stream()
                    .limit(quantidade)
                    .forEach(f -> {
                       f.setFilial(filial);
                       produtoDao.save(f);
                    });
                }
            });
        }
    }

    @Override
    public int quantidadeProdutoTotal(Long codigo) {
        int quantidade = 0;
        Optional<List<Produto>> produtos = Optional.ofNullable(produtoDao.listaProdutoCodigo(codigo));
        if(produtos.isPresent()) {
            quantidade = produtos.get().size();
        }
        return quantidade;
    }

    @Override
    public int quantidadeProdutoTotal(String nome) {
        int quantidade = 0;
        Optional<List<Produto>> produtos = Optional.ofNullable(produtoDao.listaProdutoNome(nome));
        if(produtos.isPresent()) {
            quantidade = produtos.get().size();
        }
        return quantidade;
    }

    @Override
    @Transactional(readOnly = true)
    public int quantidadeProdutoFilial(Long codigo, Filial filial) {
        int quantidade = 0;
        Optional<List<Produto>> produtos = Optional.ofNullable(produtoDao.listaProdutoFilial(filial.getCnpj()));
        if(produtos.isPresent()) {
            quantidade = produtos.get().size();
        }
        return quantidade;
    }
}