package com.gestionstock.demo.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class ImpClienteServicio implements ClienteServicio {
@Override
    public ClienteResponse obtenerCliente() {
        String nombre = "Agustín";
        String apellido = "Nazer";
        LocalDate fechaNacimiento = LocalDate.of(1990, 1, 1); 

        int edad = calcularEdad(fechaNacimiento);
        return new ClienteResponse(nombre, apellido, edad);
    }

    private int calcularEdad(LocalDate fechaNacimiento) {
        return LocalDate.now().getYear() - fechaNacimiento.getYear();
    }
    public static class ClienteResponse {
        private String nombre;
        private String apellido;
        private int años;

        public ClienteResponse(String nombre, String apellido, int años) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.años = años;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public int getAños() {
            return años;
        }

        public void setAños(int años) {
            this.años = años;
        }
    }
}
