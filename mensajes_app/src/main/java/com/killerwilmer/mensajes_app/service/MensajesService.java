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

  public static void listarMensajes() {

    MensajesDAO.leerMensajesDB();
  }

  public static void borrarMensaje() {

    Scanner sc = new Scanner(System.in);
    System.out.println("indica el ID del mensaje a borrar");
    int id_mensaje = sc.nextInt();
    MensajesDAO.borrarMensajeDB(id_mensaje);
  }

  public static void editarMensaje() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Escribe tu nuevo mensaje");
    String mensaje = sc.nextLine();

    System.out.println("indica el id del mensaje a editar");
    int id_mensaje = sc.nextInt();

    Mensajes registro = new Mensajes();
    registro.setMensaje(mensaje);
    registro.setId_mensaje(id_mensaje);
    MensajesDAO.actualizarMensajeDB(registro);
  }
}
