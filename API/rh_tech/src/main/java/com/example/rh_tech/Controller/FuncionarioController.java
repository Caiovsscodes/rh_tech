package com.example.rh_tech.Controller;

import com.example.rh_tech.Model.FuncionarioModel;
import com.example.rh_tech.Service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioService service;

    @GetMapping
    public List<FuncionarioModel> listarTodos(){
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioModel> buscarPorId(@PathVariable  long id){
        return  service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public  FuncionarioModel salvar(@RequestBody FuncionarioModel funcionarioModel){
        return service.salvar(funcionarioModel);
    }


    
    @DeleteMapping
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        if (!service.buscarPorId(id).isPresent()){
            return  ResponseEntity.notFound().build();
        }
        service.deletar(id);
        return  ResponseEntity.noContent().build();
    }
}

