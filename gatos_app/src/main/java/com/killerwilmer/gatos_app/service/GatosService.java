package com.killerwilmer.gatos_app.service;

import com.google.gson.Gson;
import com.killerwilmer.gatos_app.model.Gatos;
import com.squareup.okhttp.*;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class GatosService {

  public static void verGatos() throws IOException {

    OkHttpClient client = new OkHttpClient();

    Request request =
        new Request.Builder()
            .url("https://api.thecatapi.com/v1/images/search")
            .addHeader("cache-control", "no-cache")
            .get()
            .build();

    Response response = client.newCall(request).execute();

    String elJson = response.body().string();

    // cortar los corchetes
    elJson = elJson.substring(1, elJson.length());
    elJson = elJson.substring(0, elJson.length() - 1);

    // crear u objeto de la clase Gson
    Gson gson = new Gson();
    Gatos gatos = gson.fromJson(elJson, Gatos.class);

    // redimensionar en caso de necesitar
    Image image = null;
    try {

      URL url = new URL(gatos.getUrl());
      HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
      httpcon.addRequestProperty("User-Agent", "");
      BufferedImage bufferedImage = ImageIO.read(httpcon.getInputStream());

      ImageIcon fondoGato = new ImageIcon(bufferedImage);

      if (fondoGato.getIconWidth() > 800) {
        // redimensionamos
        Image fondo = fondoGato.getImage();
        Image modificada = fondo.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);
        fondoGato = new ImageIcon(modificada);
      }

      String menu = "Opciones: \n" + " 1. ver otra imagen \n" + " 2. Favorito \n" + " 3. Volver \n";

      String[] botones = {"ver otra imagen", "favorito", "volver"};
      String id_gato = gatos.getId();
      String opcion =
          (String)
              JOptionPane.showInputDialog(
                  null,
                  menu,
                  id_gato,
                  JOptionPane.INFORMATION_MESSAGE,
                  fondoGato,
                  botones,
                  botones[0]);

      int seleccion = -1;
      // validamos que opcion selecciona el usuario
      for (int i = 0; i < botones.length; i++) {
        if (opcion.equals(botones[i])) {
          seleccion = i;
        }
      }

      switch (seleccion) {
        case 0:
          verGatos();
          break;
        case 1:
          favoritoGato(gatos);
          break;
        default:
          break;
      }

    } catch (IOException e) {
      System.out.println(e);
    }
  }

  public static void favoritoGato(Gatos gato) {
    try {
      OkHttpClient client = new OkHttpClient();
      MediaType mediaType = MediaType.parse("application/json");
      RequestBody body =
          RequestBody.create(mediaType, "{\n\t\"image_id\":\"" + gato.getId() + "\"\n}");
      Request request =
          new Request.Builder()
              .url("https://api.thecatapi.com/v1/favourites")
              .post(body)
              .addHeader("Content-Type", "application/json")
              .addHeader("x-api-key", gato.getApikey())
              .build();
      Response response = client.newCall(request).execute();

    } catch (IOException e) {
      System.out.println(e);
    }
  }
}
