package com.killerwilmer.ereservation.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/** @author killerwilmer */
@Data
@Entity
@Table(name = "reserva")
public class Reserva {

  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid2")
  private String idRes;

  private Date fechaIngresoRes;
  private Date fechaSalidaRes;
  private int cantidadPersonasRes;
  private String descripcionRes;

  @ManyToOne
  @JoinColumn(name = "idCli")
  private Cliente cliente;
}
