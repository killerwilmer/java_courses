package com.killerwilmer.gatos_app.service;

import com.google.gson.Gson;
import com.killerwilmer.gatos_app.model.Gatos;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class GatosService {

  public static void verGatos() throws IOException {

    OkHttpClient client = new OkHttpClient();

    Request request =
        new Request.Builder().url("https://api.thecatapi.com/v1/images/search").get().build();

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
      image = ImageIO.read(url);

      ImageIcon fondoGato = new ImageIcon(image);

      if (fondoGato.getIconWidth() > 800) {
        // redimensionamos
        Image fondo = fondoGato.getImage();
        Image modificada = fondo.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);
        fondoGato = new ImageIcon(modificada);
      }

    } catch (IOException e) {
      System.out.println(e);
    }
  }
}
