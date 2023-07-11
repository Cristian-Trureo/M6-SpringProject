package cl.awakelab.SprintM6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name="liquidacion")
public class Liquidacion {
    @Column(name="id_liquidacion",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idLiquidacion;
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name="id_trabajador",nullable = false)
    private int idTrabajador; //foreign key
    @Column(nullable = false)
    private LocalDate periodo;
    @Column(name="sueldo_imponible",nullable = false)
    private int sueldoImponible;
    @Column(name="sueldo_liquido",nullable = false)
    private int sueldoLiquiedo;
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name="id_inst_salud",nullable = false)
    private int idInstSalud;
    @Column(name="monto_inst_salud",nullable = false)
    private int montoInstSalud;
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name="id_inst_previsional",nullable = false)
    private int idInstPrevision;
    @Column(name="monto_inst_previsional",nullable = false)
    private int montoInstPrevisional;
    @Column(name="total_descuento",nullable = false)
    private int totalDescuento;
    @Column(name="total_haberes",nullable = false)
    private int totalHaberes;
    @Column(nullable = false)
    private int anticipo;


}
