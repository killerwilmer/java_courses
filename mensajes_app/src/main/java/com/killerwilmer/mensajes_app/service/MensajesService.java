package com.killerwilmer.mensajes_app.service;

import com.killerwilmer.mensajes_app.dao.MensajesDAO;
import com.killerwilmer.mensajes_app.model.Mensajes;

import java.util.Scanner;

public class MensajesService {

  public static void crearMensaje() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Escribe tu mensaje");
    String mensaje = sc.nextLine();

    System.out.println("tu nombre");
    String nombre = sc.nextLine();

    Mensajes registro = new Mensajes();
    registro.setMensaje(mensaje);
    registro.setAutor_mensaje(nombre);
    MensajesDAO.crearMensajeDB(registro);
  }

  public static void listarMensajes() {}

  public static void borrarMensaje() {}

  public static void editarMensaje() {}
}
