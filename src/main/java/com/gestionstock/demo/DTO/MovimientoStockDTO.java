package com.gestionstock.demo.DTO;

import java.time.LocalDate;

public class MovimientoStockDTO {
    private Long id;
    private Long productoId; //relacionado a productoDTO
    private String description;
    private Integer cantidad;
    private String tipoMovimiento;// Entrada o salida
    private LocalDate fecha;
}
