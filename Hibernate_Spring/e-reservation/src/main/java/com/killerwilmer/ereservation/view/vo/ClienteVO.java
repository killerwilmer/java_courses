package com.killerwilmer.ereservation.view.vo;

import com.killerwilmer.ereservation.model.Reserva;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/** @author killerwilmer */
@Data
public class ClienteVO {

  private String nombreCli;
  private String apellidoCli;
  private String identificacionCli;
  private String direccionCli;
  private String telefonoCLi;
  private String emailCli;
}
