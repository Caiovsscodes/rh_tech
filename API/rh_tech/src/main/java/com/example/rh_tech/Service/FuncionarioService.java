package com.example.rh_tech.Service;

import com.example.rh_tech.Model.FuncionarioModel;
import com.example.rh_tech.Repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;

    public List<FuncionarioModel> listarTodos(){
        return repository.findAll();
    }
    public Optional<FuncionarioModel> buscarPorId(Long id){
        return repository.findById(id);
    }

    public FuncionarioModel salvar(FuncionarioModel funcionarioModel){
        return  repository.save(funcionarioModel);
    }
    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioModel> atualizar(@PathVariable Long id, @RequestBody FuncionarioModel funcionarioModel){
        if (buscarPorId(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        funcionarioModel.setId(id);
        return ResponseEntity.ok(salvar(funcionarioModel));
    }
    public void deletar(Long id){
        repository.deleteById(id);
    }
}

