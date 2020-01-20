package com.killerwilmer.ereservation.controller.services;

import com.killerwilmer.ereservation.controller.repository.ClienteRepository;
import com.killerwilmer.ereservation.model.Cliente;
import org.springframework.stereotype.Service;

/** @author killerwilmer */
@Service
public class ClienteService {

  private final ClienteRepository clienteRepository;

  public ClienteService(ClienteRepository clienteRepository) {
    this.clienteRepository = clienteRepository;
  }

  public Cliente create(Cliente cliente) {
    return this.clienteRepository.save(cliente);
  }

  public Cliente update(Cliente cliente) {
    return this.clienteRepository.save(cliente);
  }

  public void delete(Cliente cliente) {
    this.clienteRepository.delete(cliente);
  }

  public Cliente findByIdentificacion(String identificacionCli) {
    return this.clienteRepository.findByIdentificacion(identificacionCli);
  }
}
