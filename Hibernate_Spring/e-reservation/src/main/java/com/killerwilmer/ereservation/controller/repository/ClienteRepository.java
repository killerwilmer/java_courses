package com.killerwilmer.ereservation.controller.repository;

import com.killerwilmer.ereservation.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/** @author killerwilmer */
public interface ClienteRepository extends JpaRepository<Cliente, String> {

  /**
   * @param apellidoCli
   * @return
   */
  List<Cliente> findByApellidoCli(String apellidoCli);

  /**
   * @param identificacionCli
   * @return
   */
  Cliente findByIdentificacion(String identificacionCli);
}
