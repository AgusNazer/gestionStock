package com.gestionstock.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionstock.demo.service.ClienteServicio;
import com.gestionstock.demo.service.ImpClienteServicio.ClienteResponse;

@RestController
public class ClienteController {

    @Autowired
    private ClienteServicio clienteService;

    @GetMapping("/cliente")
    public ClienteResponse getCliente() {
        return clienteService.obtenerCliente();
    }
}