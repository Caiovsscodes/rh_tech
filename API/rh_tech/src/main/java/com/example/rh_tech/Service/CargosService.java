package com.example.rh_tech.Service;

import com.example.rh_tech.Model.CargosModel;
import com.example.rh_tech.Repository.CargosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargosService {
    @Autowired
    private CargosRepository repository;

    public List<CargosModel> listarTodos(){
        return repository.findAll();
    }

    public Optional<CargosModel> buscarPorId(Long id){
        return  repository.findById(id);
    }

    public CargosModel salvar(CargosModel cargosModal){
        return  repository.save(cargosModal);
    }

    public  void deletar(Long id){
        repository.deleteById(id);
    }
}
