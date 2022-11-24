package com.vendas.service;

import com.vendas.entity.Cliente;
import com.vendas.entity.dto.ClienteDTO;
import com.vendas.repository.ClienteRepository;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ClienteService {

  private final ClienteRepository clienteRepository;
  private final ModelMapper modelMapper;
  
  @Transactional
  public void salvar(ClienteDTO clienteDTO) {
    Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
    clienteRepository.save(cliente);
  }
  
  @Transactional
  public void update(Integer id, ClienteDTO clienteDTO) {
    isValidId(id);
    clienteRepository.findById(id)
    .map(cli -> {
      cli = modelMapper.map(clienteDTO, Cliente.class);
      cli.setId(id);
      clienteRepository.save(cli);
      return Void.TYPE;
    }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum resultado encontrado para o identificador: "+id));
  }
  
  public ClienteDTO getCliente(Integer id) {
    isValidId(id);
    return clienteRepository.findById(id)
      .map(cli -> {
        var clienteDTO = modelMapper.map(cli, ClienteDTO.class);
        return clienteDTO;
    }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum resultado encontrado para o identificador: "+id));
  }
  
  @Transactional
  public void deletar(Integer id) {
    isValidId(id);
    clienteRepository.findById(id)
      .map(cliente -> {
        clienteRepository.deleteById(id);
        return Void.TYPE;
      }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum resultado encontrado para o identificador: "+id));
  }

  public List<Cliente> findAll() {
    return clienteRepository.findAll();
  }
  
  public Page<Cliente> page(PageRequest pageRequest) {
    return clienteRepository.todos(pageRequest);
  }
  
  private void isValidId(final Integer id) {
    if(Objects.isNull(id)) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Identificador inválido");
  }

}
//clienteRepository.findByNomeLike(clienteDTO.getNome());
//clienteRepository.existsByNome(clienteDTO.getNome());
