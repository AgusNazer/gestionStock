package com.gestionstock.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "MOVIMIENTO_STOCK")
public class MovimientoStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoMovimiento; //entrada o salida
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "USUARIO_ID")
    private Usuario usuario;

}
