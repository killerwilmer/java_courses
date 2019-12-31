package com.killerwilmer.gatos_app;

import com.killerwilmer.gatos_app.model.Gatos;
import com.killerwilmer.gatos_app.service.GatosService;

import javax.swing.*;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {

    int opcion_menu = -1;
    String[] botones = {" 1. ver gatos", "2. ver favoritos", "3. salir"};

    do {

      String opcion =
          (String)
              JOptionPane.showInputDialog(
                  null,
                  "Gatitos java",
                  "Menu principal",
                  JOptionPane.INFORMATION_MESSAGE,
                  null,
                  botones,
                  botones[0]);

      for (int i = 0; i < botones.length; i++) {
        if (opcion.equals(botones[i])) {
          opcion_menu = i;
        }
      }

      switch (opcion_menu) {
        case 0:
          GatosService.verGatos();
          break;
        case 1:
          Gatos gato = new Gatos();
          GatosService.verFavorito(gato.getApikey());
          break;
        default:
          break;
      }
    } while (opcion_menu != 1);
  }
}
