package com.example.ac2.controle;

import com.example.ac2.dominio.Lutador;
import com.example.ac2.repositorio.LutadorRepository;
import com.example.ac2.response.LutadorRespostaSimples;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lutadores")
public class LutadorController {

    @Autowired
    LutadorRepository repository;

    @GetMapping
    public ResponseEntity getLutador(){
        return ResponseEntity.status(200).body(repository.findAllByOrderByForcaGolpeDesc());
    }

    @PostMapping
    public ResponseEntity postLutador(@RequestBody @Valid Lutador lutador){
        repository.save(lutador);
        return ResponseEntity.status(201).body("Salvo com sucesso");
    }

    @GetMapping("/contagem-vivos")
    public ResponseEntity contagemVivos(){
        return ResponseEntity.status(200).body(repository.countAllByVivoTrue());
    }
    
//    @PostMapping("/{id}/concentrar")
//    public ResponseEntity concentrar(@RequestParam Integer id){
//        Optional<Lutador> lutadorOptional = repository.findById(id);
//        if(lutadorOptional.isPresent()){
//
//        }else{
//            return ResponseEntity.status(404).body("Nao encontrado");
//        }
//    }

    @GetMapping("/mortos")
    public ResponseEntity getMortos(){
        List<LutadorRespostaSimples> listaMorto = repository.findByVivoFalse();
        if(listaMorto.isEmpty()){
            return ResponseEntity.status(204).build();
        }else{
            return ResponseEntity.status(200).body(listaMorto);
        }
    }
}
