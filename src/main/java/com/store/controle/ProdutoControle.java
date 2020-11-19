package com.store.controle;


import com.store.modelo.repositorio.dto.ProdutoDto;
import com.store.modelo.repositorio.dto.mapper.ProdutoMapper;
import com.store.modelo.repositorio.entidade.Filial;
import com.store.modelo.repositorio.entidade.Produto;
import com.store.servico.inter.InterfaceProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping
public class ProdutoControle {

    private static final String BASE_URL = "produto/";

    @Autowired
    InterfaceProdutoService service;

    @GetMapping(value = BASE_URL + "find-all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<Produto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = BASE_URL + "find-by-id", produces = MediaType.APPLICATION_JSON_VALUE, params = {"id"})
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Produto> findById(@RequestParam(name = "id") String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping(value = BASE_URL + "update", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Produto> update(@RequestBody ProdutoDto dto) {
        return ResponseEntity.ok(service.update(ProdutoMapper.INSTANCE.dtoToEntity(dto)));
    }

    @PostMapping(value = BASE_URL + "insert", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Produto> insert(@RequestBody ProdutoDto dto) {
        return ResponseEntity.ok(service.save(ProdutoMapper.INSTANCE.dtoToEntity(dto)));
    }

    @DeleteMapping(value = BASE_URL + "delete", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@RequestParam(name = "id") String id) {
        service.delete(id);
    }

    @GetMapping(value = BASE_URL + "/{codigo}/quantidade/total", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Integer> quantidadeProdutoTotal(@PathVariable(name = "codigo") Long codigo) {
        return ResponseEntity.ok(service.quantidadeProdutoTotal(codigo));
    }

    @GetMapping(value = BASE_URL + "/{nome}/quantidade/total", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Integer> quantidadeProdutoTotal(@PathVariable(name = "nome") String nome) {
        return ResponseEntity.ok(service.quantidadeProdutoTotal(nome));
    }

    @GetMapping(value = BASE_URL + "/{codigo}/quantidade/filial/{filial}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Integer> quantidadeProdutoFilial(@PathVariable(name = "codigo") Long codigo, @RequestBody Filial filial) {
        return ResponseEntity.ok(service.quantidadeProdutoFilial(codigo, filial));
    }
}
