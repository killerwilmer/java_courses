package com.killerwilmer.ereservation.controller.services;

import com.killerwilmer.ereservation.controller.repository.ClienteRepository;
import com.killerwilmer.ereservation.model.Cliente;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** @author killerwilmer */
@Service
@Transactional(readOnly = true)
public class ClienteService {

  private final ClienteRepository clienteRepository;

  public ClienteService(ClienteRepository clienteRepository) {
    this.clienteRepository = clienteRepository;
  }

  @Transactional
  public Cliente create(Cliente cliente) {
    return this.clienteRepository.save(cliente);
  }

  @Transactional
  public Cliente update(Cliente cliente) {
    return this.clienteRepository.save(cliente);
  }

  @Transactional
  public void delete(Cliente cliente) {
    this.clienteRepository.delete(cliente);
  }

  public Cliente findByIdentificacion(String identificacionCli) {
    return this.clienteRepository.findByIdentificacion(identificacionCli);
  }
}
