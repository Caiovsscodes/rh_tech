package com.example.rh_tech.Controller;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rh_tech.Model.CargosModel;
import com.example.rh_tech.Service.CargosService;

@RestController

@RequestMapping("/api/cargos")
public class CargosController {
    @Autowired
    private CargosService service;

    @GetMapping
    public List<CargosModel> listarTodos(){
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargosModel> buscarPorId(@PathVariable Long id{
        return service.buscarPorId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CargosModel salvar(@RequestBody CargosModel cargosModel){
        return service.salvar(cargosModel);
    }

    @DeleteMapping 
    public ResponseEntity<Void> deletar (@PathVariable Long id){
        if (!service.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
