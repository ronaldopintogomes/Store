package com.store.modelo.seeder;

import com.store.modelo.repositorio.entidade.Produto;
import com.store.servico.inter.InterfaceProdutoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProdutoSeeder {

    @Autowired
    InterfaceProdutoService service;

    @EventListener
    public void seedFilial(ContextRefreshedEvent event) {
        try {
            log.info("Criando produtos....");
            criandoFiliais();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    private void criandoFiliais() {
        for (int i = 1; i < 25; i++) {
            Produto produto = new Produto();
            produto.setId("Cod-Produto-"+i);
            produto.setNome("Sal produto " + i);
            service.save(produto);
        }
    }
}
