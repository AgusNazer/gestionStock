package com.gestionstock.demo.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiMeliAuth {
    public static void main(String[] args) {
        try {
            // URL de búsqueda de productos en Mercado Libre (ejemplo: "laptop")
            String apiUrl = "https://api.mercadolibre.com/sites/MLA/search?q=laptop";
            
            // Crear conexión HTTP
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");

            // Leer la respuesta
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Imprimir la respuesta JSON
            System.out.println("Respuesta de MercadoLibre:");
            System.out.println(response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
