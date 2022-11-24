package com.vendas.controller;

import com.vendas.entity.Persona;
import com.vendas.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
@RequiredArgsConstructor
public class PersonaController {
    
    private final PersonaRepository personaRepository;
    
    @PostMapping
    public void salvar(@RequestBody Persona persona) {
        personaRepository.save(persona);
    }
  
  @GetMapping("buscar/{id}")  
  public Persona find(@PathVariable(name = "id", required = true) Integer id) {
    return personaRepository.findById(id).get();
  }
    
}
