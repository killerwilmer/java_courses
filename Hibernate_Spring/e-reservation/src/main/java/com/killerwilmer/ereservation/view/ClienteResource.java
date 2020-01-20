package com.killerwilmer.ereservation.view;

import com.killerwilmer.ereservation.controller.services.ClienteService;
import com.killerwilmer.ereservation.model.Cliente;
import com.killerwilmer.ereservation.view.vo.ClienteVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** @author killerwilmer */
@RestController
@RequestMapping("/api/cliente")
@Api(tags = "cliente")
public class ClienteResource {

  private final ClienteService clienteService;

  public ClienteResource(ClienteService clienteService) {
    this.clienteService = clienteService;
  }

  @PostMapping
  @ApiOperation(value = "Crear Cliente", notes = "Servicio para crear un nuevo Cliente")
  @ApiResponses(
      value = {
        @ApiResponse(code = 201, message = "Cliente creado correctamente"),
        @ApiResponse(code = 400, message = "Solicitud Inválida")
      })
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
  @ApiOperation(value = "Actualizar Cliente", notes = "Servicio para actualizar un cliente")
  @ApiResponses(
      value = {
        @ApiResponse(code = 201, message = "Cliente actualizado correctamente"),
        @ApiResponse(code = 404, message = "Cliente no encontrado")
      })
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
  @ApiOperation(value = "Eliminar Cliente", notes = "Servicio para eliminar un cliente")
  @ApiResponses(
      value = {
        @ApiResponse(code = 201, message = "Cliente eliminado correctamente"),
        @ApiResponse(code = 404, message = "Cliente no encontrado")
      })
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
  @ApiOperation(value = "Listar Clientes", notes = "Servicio para listar todos los clientes")
  @ApiResponses(
      value = {
        @ApiResponse(code = 201, message = "Clientes encontrados"),
        @ApiResponse(code = 404, message = "Clientes no encontrados")
      })
  public ResponseEntity<List<Cliente>> findAll() {

    return ResponseEntity.ok(this.clienteService.findAll());
  }
}
