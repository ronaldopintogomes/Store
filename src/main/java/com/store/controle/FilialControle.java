package com.store.controle;

import com.store.modelo.enumeracao.EnumTipoFilial;
import com.store.modelo.repositorio.dto.FilialDto;
import com.store.modelo.repositorio.dto.mapper.FilialMapper;
import com.store.modelo.repositorio.entidade.Filial;
import com.store.servico.inter.InterfaceFilialService;
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
public class FilialControle {

    private static final String BASE_URL = "filial/";

    @Autowired
    InterfaceFilialService service;
    @Autowired
    InterfaceProdutoService produtoService;

    @GetMapping(value = BASE_URL + "find-all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<Filial>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = BASE_URL + "find-by-id", produces = MediaType.APPLICATION_JSON_VALUE, params = {"id"})
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Filial> findById(@RequestParam(name = "id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping(value = BASE_URL + "update", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Filial> update(@RequestBody FilialDto dto) {
        return ResponseEntity.ok(service.update(FilialMapper.INSTANCE.dtoToEntity(dto)));
    }

    @PostMapping(value = BASE_URL + "insert", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Filial> insert(@RequestBody FilialDto dto) {
        return ResponseEntity.ok(service.save(FilialMapper.INSTANCE.dtoToEntity(dto)));
    }

    @DeleteMapping(value = BASE_URL + "delete", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@RequestParam(name = "id") Long id) {
        service.delete(id);
    }

    @GetMapping(value = BASE_URL + "tipo/find-all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<EnumTipoFilial>> findAllEnumTipoFilial() {
        return ResponseEntity.ok(EnumTipoFilial.getAll());
    }

    @GetMapping(value = BASE_URL + "/transferir/{quantidade}/produto/{codigo}/para/{filial}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void transferirProduto(@PathVariable(name = "quantidade") int quantidade, @PathVariable(name = "codigo") Long codigo, @RequestBody Filial filial) {
        produtoService.transferirProduto(codigo, filial, quantidade);
    }
}
