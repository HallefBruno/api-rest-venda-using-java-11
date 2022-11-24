package com.vendas.service;

import com.vendas.entity.Persona;
import com.vendas.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonaService {
  
  private final PersonaRepository personaRepository;
  
  public Persona findPersona() {
    return personaRepository.findById(1).get();
  }
    
}
