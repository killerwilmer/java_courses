package com.killerwilmer.ereservation.view;

import com.killerwilmer.ereservation.controller.services.ClienteService;
import com.killerwilmer.ereservation.model.Cliente;
import com.killerwilmer.ereservation.view.vo.ClienteVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** @author killerwilmer */
@RestController
@RequestMapping("/api/cliente")
public class ClienteResource {

  private final ClienteService clienteService;

  public ClienteResource(ClienteService clienteService) {
    this.clienteService = clienteService;
  }

  @PostMapping
  public ResponseEntity<Cliente> createCliente(@RequestBody ClienteVO clienteVO) {

    Cliente cliente = new Cliente();
    cliente.setNombreCli(clienteVO.getNombreCli());
    cliente.setApellidoCli(clienteVO.getApellidoCli());
    cliente.setDireccionCli(clienteVO.getDireccionCli());
    cliente.setTelefonoCLi(clienteVO.getTelefonoCLi());
    cliente.setEmailCli(clienteVO.getEmailCli());

    return new ResponseEntity<>(this.clienteService.create(cliente), HttpStatus.CREATED);
  }

  @PutMapping("/{identificacion}")
  public ResponseEntity<Cliente> updateCliente(
      @PathVariable("identificacion") String identificacion, ClienteVO clienteVO) {

    Cliente cliente = this.clienteService.findByIdentificacion(identificacion);
    if (cliente == null) {
      return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
    } else {
      cliente.setNombreCli(clienteVO.getNombreCli());
      cliente.setApellidoCli(clienteVO.getApellidoCli());
      cliente.setDireccionCli(clienteVO.getDireccionCli());
      cliente.setTelefonoCLi(clienteVO.getTelefonoCLi());
      cliente.setEmailCli(clienteVO.getEmailCli());
    }

    return new ResponseEntity<>(this.clienteService.update(cliente), HttpStatus.OK);
  }

  @DeleteMapping("/{identificacion}")
  public ResponseEntity<Cliente> removeCliente(
      @PathVariable("identificacion") String identificacion) {

    Cliente cliente = this.clienteService.findByIdentificacion(identificacion);

    if (cliente != null) {
      this.clienteService.delete(cliente);
      return new ResponseEntity<Cliente>(HttpStatus.OK);
    } else {
      return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping
  public ResponseEntity<List<Cliente>> findAll() {

    return ResponseEntity.ok(this.clienteService.findAll());
  }
}
