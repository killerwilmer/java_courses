package com.killerwilmer.ereservation.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/** @author killerwilmer */
@Data
@Entity
@Table(name = "cliente")
public class Cliente {

  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid2")
  private String idCli;

  private String nombreCli;
  private String apellidoCli;
  private String identificacionCli;
  private String direccionCli;
  private String telefonoCLi;
  private String emailCli;

  @OneToMany(mappedBy = "clientes")
  private Set<Reserva> reservaSet;

  public Cliente() {}
}
