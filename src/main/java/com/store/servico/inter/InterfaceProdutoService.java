package com.store.servico.inter;

import com.store.modelo.repositorio.entidade.Filial;
import com.store.modelo.repositorio.entidade.Produto;

import java.util.List;

public interface InterfaceProdutoService extends IGenericService<Produto, String> {

    public List<Produto> listaProduto(String nome);
    public List<Produto> listaProduto(Long codigo);
    public void transferirProduto(Long codigoProduto, Filial filial, int quantidade);
    public int quantidadeProdutoTotal(Long codigo);
    public int quantidadeProdutoTotal(String nome);
    public int quantidadeProdutoFilial(Long codigo, Filial filial);
}
